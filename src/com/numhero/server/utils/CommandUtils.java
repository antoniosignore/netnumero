package com.numhero.server.utils;

import com.numhero.client.model.datacargo.report.chartofaccounts.AccountBalanceRequest;
import com.numhero.client.model.pojoc.*;
import com.numhero.server.model.daolite.*;
import com.numhero.server.service.DoubleEntryProcessor;
import com.numhero.shared.datacargo.CommandRequest;
import com.numhero.shared.enums.AccountingEntrySide;
import com.numhero.shared.enums.InvoiceDetailTypeEnum;
import com.numhero.shared.enums.InvoiceStatusEnum;
import com.numhero.shared.enums.InvoiceTypeEnum;
import com.numhero.shared.pojoc.SearchablePojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

public class CommandUtils {

    private static final Logger log = Logger.getLogger(CommandUtils.class.getName());

    static public boolean belongsToAnUnpaidInvoice(List<Invoice> invoices, ExpenseReceipt expenseReceipt) {
        for (int i = 0; i < invoices.size(); i++) {
            Invoice invoice = invoices.get(i);
            List<InvoiceDetail> details = invoice.getDetails();
            for (int j = 0; j < details.size(); j++) {
                InvoiceDetail invoiceDetail = details.get(j);
                if (invoiceDetail.fOriginatingType.getValue() == InvoiceDetailTypeEnum.from_receipt) {
                    if (invoiceDetail.fOriginalID.getValue() == expenseReceipt.getId()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean isPaidToDraft(Invoice invoice, Invoice invBeforeOperation) {
        return
                invBeforeOperation.getInvoiceStatus() == InvoiceStatusEnum.Paid &&
                        invoice.getInvoiceStatus() == InvoiceStatusEnum.Draft;
    }

    private static boolean isDraftToSent(Invoice invoice, Invoice invBeforeOperation) {
        return
                invBeforeOperation.getInvoiceStatus() == InvoiceStatusEnum.Draft &&
                        invoice.getInvoiceStatus() == InvoiceStatusEnum.Sent;
    }

    private static boolean isSentToDraft(Invoice invoice, Invoice invBeforeOperation) {
        return
                invBeforeOperation.getInvoiceStatus() != InvoiceStatusEnum.Draft &&
                        invoice.getInvoiceStatus() == InvoiceStatusEnum.Draft;
    }

    public static void persistDocument(BusinessAccount ba,
                                       InvoiceDao invoiceDao,
                                       BusinessAccountDao businessAccountDao,
                                       Invoice invoice,
                                       DoubleEntryProcessor doubleEntryProcessor) {

        //TODO this code badly need a Refactoring to Strategy Pattern
        invoice.fPDF.setEmptyValue();

        if (invoice.getInvoiceType() == InvoiceTypeEnum.Expense) {
            if (invoice.fName.getValue() != null && !invoice.fName.getValue().isEmpty()) {
                invoiceDao.save(invoice);
                doubleEntryProcessor.processPurchaseFromSupplier(ba, invoice);
            }
        } else if (invoice.getInvoiceType() == InvoiceTypeEnum.Invoice) {
            Invoice invBeforeOperation = null;

            if (invoice.getId() != null)
                invBeforeOperation = invoiceDao.get(invoice.getId());

            if (invBeforeOperation == null) {
                if (invoice.getInvoiceStatus() == InvoiceStatusEnum.Sent) {
                    createNewInvoiceID(ba, businessAccountDao, invoice);
                    invoiceDao.save(invoice);
                    doubleEntryProcessor.processSaleToClient(ba, invoice);
                } else {
                    invoiceDao.save(invoice);
                }
            } else {
                if (isSentToDraft(invoice, invBeforeOperation)) {
                    invoiceDao.save(invoice);
                    doubleEntryProcessor.deleteInvoiceRelatedEntries(invoice);
                } else if (isDraftToSent(invoice, invBeforeOperation)) {
                    createNewInvoiceID(ba, businessAccountDao, invoice);
                    invoiceDao.save(invoice);
                    doubleEntryProcessor.processSaleToClient(ba, invoice);
                } else if (isPaidToDraft(invoice, invBeforeOperation)) {
                    invoiceDao.save(invoice);
                    doubleEntryProcessor.deleteInvoiceRelatedEntries(invoice);
                } else {
                    invoiceDao.save(invoice);
                }
            }
        } else if (invoice.getInvoiceType() == InvoiceTypeEnum.Estimate) {
            long invoiceID = ba.fLastEstimateID.getValue() + 1;
            invoice.fName.setValue("Estimate" + invoiceID);
            ba.fLastEstimateID.setValue(invoiceID);
            businessAccountDao.save(ba);
            invoiceDao.save(invoice);
        }
    }

    private static void createNewInvoiceID(BusinessAccount ba, BusinessAccountDao businessAccountDao, Invoice invoice) {
        long invoiceID = ba.fLastInvoiceID.getValue() + 1;
        invoice.fName.setValue(ba.fPrefix.getValue() + invoiceID);
        ba.fLastInvoiceID.setValue(invoiceID);
        businessAccountDao.save(ba);
    }

    public static List<SearchablePojo> getChartOfAccounts(CommandRequest request,
                                                          BankAccountDao bankAccountDao,
                                                          NominalLedgerAccountDao nominalLedgerAccountDao,
                                                          CategoryDao categoryDao,
                                                          ClientSupplierDao clientSupplierDao,
                                                          TaxInfoDao taxInfoDao) {

        List<SearchablePojo> allAccounts = new ArrayList<SearchablePojo>();
        List<BankAccount> banks = bankAccountDao.findAll(request.getBusinessAccountId());
        List<NominalLedgerAccount> nominalLedgerAccounts = nominalLedgerAccountDao.findAll(request.getBusinessAccountId());
        List<Category> catlist = categoryDao.findAll(request.getBusinessAccountId());
        List<ClientSupplier> clientSuppliers = clientSupplierDao.findAll(request.getBusinessAccountId());
        List<TaxInfo> taxes = taxInfoDao.findAll(request.getBusinessAccountId());

        allAccounts.addAll(nominalLedgerAccounts);
        allAccounts.addAll(banks);
        allAccounts.addAll(catlist);
        allAccounts.addAll(clientSuppliers);
        allAccounts.addAll(taxes);

        log.info("allAccounts.size() = " + allAccounts.size());
        return allAccounts;
    }

    public static List<AccountBalanceRow> prepareLedgerBalance(String baid,
                                                               Long ledgerAccountId,
                                                               AccountingLegDao accountingLegDao,
                                                               Date from,
                                                               Date to) {

        log.info("CommandUtils.prepareLedgerBalance");
        log.info("ledgerAccountId = " + ledgerAccountId);

        List<AccountBalanceRow> rows = new ArrayList<AccountBalanceRow>();
        List<AccountingLeg> legs = accountingLegDao.findByCriteria(baid, ledgerAccountId, null, from, to);

        for (int i = 0; i < legs.size(); i++) {
            AccountingLeg leg = legs.get(i);
            AccountBalanceRow row = new AccountBalanceRow();
            row.fDate.setValue(leg.fDate.getValue());
            row.fTitle.setValue(leg.fAccountName.getValue());

            AccountingEntrySide side = leg.fDoubleEntryType.getValue();
            if (side == AccountingEntrySide.debit) {
                row.fDebitValue.setValue(leg.fValue.getValue());
                row.fCreditValue.setValue(0D);
            } else {
                row.fCreditValue.setValue(leg.fValue.getValue());
                row.fDebitValue.setValue(0D);
            }

            row.fBalance.setValue(0D);
            rows.add(row);
        }
        return rows;
    }


    public static NominalLedgerAccount retrieveNominalAccount(AccountBalanceRequest request, BusinessAccount businessAccount, NominalLedgerAccountDao nldao, String code) {
        return nldao.loadAccountsByCode(request.getBusinessAccountId(), code);
    }

}
