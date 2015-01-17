package com.numhero.server.service;

import com.google.inject.Inject;
import com.numhero.client.model.pojoc.*;
import com.numhero.client.util.ClientUtils;
import com.numhero.client.util.CoreUtils;
import com.numhero.server.model.daolite.*;
import com.numhero.shared.enums.AccountingEntrySide;
import com.numhero.shared.enums.BusinessTransactionEnum;
import com.numhero.shared.enums.CurrencyEnum;
import com.numhero.shared.enums.ReferenceDocEnum;

import java.util.*;
import java.util.logging.Logger;

public class DoubleEntryProcessor {

    private static final Logger log = Logger.getLogger(DoubleEntryProcessor.class.getName());

    @Inject
    public ClientSupplierDao clientSupplierDao;

    @Inject
    public FXDao fxDao;

    @Inject
    public NominalLedgerAccountDao nominalLedgerAccountDao;

    @Inject
    public CategoryDao categoryDao;

    @Inject
    public BusinessTransactionDao businessTransactionDao;

    @Inject
    public TaxInfoDao taxInfoDao;

    @Inject
    public BankAccountDao bankAccountDao;

    public void processSaleToClient(BusinessAccount ba, Invoice invoice) {
        log.info("DoubleEntryProcessor.processSaleToClient");


        LedgerAccountIF client = clientSupplierDao.get(invoice.getClientSupplierID());
        BusinessTransaction entry = createSaleToClientEntry(ba, invoice, client);
        createInvoiceLegs(ba, invoice, client, entry);


        deleteInvoiceRelatedEntries(invoice);

        businessTransactionDao.save(entry);
    }

    protected void createInvoiceLegs(BusinessAccount ba, Invoice invoice, LedgerAccountIF client, BusinessTransaction entry) {
        CurrencyEnum invoiceCurrency = invoice.fCurrency.getValue();

        double net = invoice.calculateNet();
        Map<Long, TaxInfo> lTaxes = taxInfoDao.findAllFromInvoice(invoice);
        Map<String, Double> taxes = invoice.calculateTaxes(lTaxes);

        String baUri = ba.fBusinessAccountUri.getValue();
        CurrencyEnum baCurrency = ba.fCurrency.getValue();

//        NominalLedgerAccount VATNominalLedger = nominalLedgerAccountDao.loadAccountsByCode(baUri, CompanyBuilder.VAT);
        NominalLedgerAccount salesNominalLedgerAccount = nominalLedgerAccountDao.loadAccountsByCode(baUri, CompanyBuilder.SALES);

        double totalTax = ClientUtils.calculateSumOfDoubles(taxes.values());

        double total = net + totalTax;
        entry.addAccountingLeg(createLeg(entry, CompanyBuilder.ACCOUNTS_RECEIVABLE, client, AccountingEntrySide.debit, fxDao.convertToOtherCurrency(total, invoiceCurrency, baCurrency)));
        entry.addAccountingLeg(createLeg(entry, CompanyBuilder.SALES, salesNominalLedgerAccount, AccountingEntrySide.credit, fxDao.convertToOtherCurrency(net, invoiceCurrency, baCurrency)));
        if (totalTax > 0) {
            for (TaxInfo taxInfo : lTaxes.values()) {

                String nominal;
                if (taxInfo.fIsVAT.getValue()) {
                    nominal = CompanyBuilder.VAT;
                } else {
                    nominal = CompanyBuilder.TAXES;
                }

                double currTax = taxes.get(taxInfo.fName.getValue());
                entry.addAccountingLeg(createLeg(entry, nominal, taxInfo, AccountingEntrySide.credit, fxDao.convertToOtherCurrency(currTax, invoiceCurrency, baCurrency)));
            }
        }
    }

    private BusinessTransaction createSaleToClientEntry(BusinessAccount ba, Invoice invoice, LedgerAccountIF client) {
        String title = "Invoice " + invoice.getName();
        String description = "Sale to Client: " + client.getName();
        BusinessTransaction entry = createEntry(ba, title, description, invoice.getId(), invoice.getName(), ReferenceDocEnum.Invoice, BusinessTransactionEnum.SaleToClient);
        return entry;
    }

    private BusinessTransaction createPurchaseFromSupplierEntry(BusinessAccount ba, Invoice exp, LedgerAccountIF client) {
        String description = "Purchase from Supplier: " + client.getName();
        String title = "Expense " + exp.getName();

        BusinessTransaction entry = createEntry(ba, title, description, exp.getId(), exp.getName(), ReferenceDocEnum.Expense, BusinessTransactionEnum.SupplierExpense);
        return entry;
    }


    public void processPaymentFromClient(BusinessAccount ba, Invoice invoice) {
        CoreUtils.debug("DoubleEntryProcessor.processClientPayment");
        ClientSupplier client = clientSupplierDao.get(invoice.getClientSupplierID());

        NominalLedgerAccount cashNominalLedger = nominalLedgerAccountDao.loadAccountsByCode(ba.fBusinessAccountUri.getValue(), CompanyBuilder.BANK);

        double net = invoice.calculateNet();
        Map<Long, TaxInfo> lTaxes = taxInfoDao.findAllFromInvoice(invoice);
        Map<String, Double> t1 = invoice.calculateTaxes(lTaxes);
        Map<String, Double> t = t1;

        double totalTax = ClientUtils.calculateSumOfDoubles(t.values());

        BusinessTransaction entry = createPaymentEntry(ba, invoice, client);

        Double total = net + totalTax;
        entry.addAccountingLeg(createLeg(entry, CompanyBuilder.BANK, cashNominalLedger, AccountingEntrySide.debit, fxDao.convertToOtherCurrency(total, invoice.fCurrency.getValue(), ba.fCurrency.getValue())));
        entry.addAccountingLeg(createLeg(entry, CompanyBuilder.ACCOUNTS_RECEIVABLE, client, AccountingEntrySide.credit, fxDao.convertToOtherCurrency(total, invoice.fCurrency.getValue(), ba.fCurrency.getValue())));

        businessTransactionDao.save(entry);
    }

    private BusinessTransaction createPaymentEntry(BusinessAccount ba, Invoice invoice, ClientSupplier client) {

        String title = invoice.getName();
        String description = "Payment received from client :" + client.getName();
        return createEntry(ba, title, description, invoice.getId(), invoice.getName(), ReferenceDocEnum.Invoice, BusinessTransactionEnum.ClientPayment);

    }

    private BusinessTransaction createEntry(BusinessAccount ba,
                                            String title,
                                            String description,
                                            Long refId,
                                            String refIdDesc,
                                            ReferenceDocEnum refIdType,
                                            BusinessTransactionEnum btEnum) {

        log.info("DoubleEntryProcessor.createEntry");
        log.info("refId = " + refId);
        log.info("refIdDesc = " + refIdDesc);
        log.info("refIdType = " + refIdType);

        BusinessTransaction entry = new BusinessTransaction();
        entry.fName.setValue(title);
        entry.fDescription.setValue(description);
        entry.fDate.setValue(new Date());
        entry.fBusinessAccountUri.setValue(ba.fBusinessAccountUri.getValue());
        entry.fBusinessTransaction.setValue(btEnum);

        entry.fReferenceDocId.setValue(refId);
        entry.fReferenceDocName.setValue(refIdDesc);
        entry.fReferenceDocType.setValue(refIdType);

        return entry;
    }

    private AccountingLeg createLeg(BusinessTransaction entry,
                                    String nominalCode,
                                    LedgerAccountIF ledgerAccount,
                                    AccountingEntrySide side,
                                    double amount) {

        if (entry == null) {
            throw new IllegalArgumentException("entry cannot be null");
        }
        if (ledgerAccount == null) {
            throw new IllegalArgumentException("ledger cannot be null");
        }

        if (nominalCode == null) {
            throw new IllegalArgumentException("nominalCode cannot be null");
        }
        if (amount == 0D) {
            return null;
        }

        AccountingLeg leg = new AccountingLeg();

        leg.fNominalCode.setValue(nominalCode);
        leg.fValue.setValue(amount);
        leg.fDoubleEntryType.setValue(side);
        leg.fAccountId.setValue(ledgerAccount.getId());
        leg.fAccountName.setValue(ledgerAccount.getName());
        leg.fAccountClass.setValue(ledgerAccount.getAccountClass());

        return leg;
    }


    public void deleteInvoiceRelatedEntries(Invoice invoice) {
        List<BusinessTransaction> dl = businessTransactionDao.findByDocRelation(invoice.fBusinessAccountUri.getValue(), invoice.getId(), ReferenceDocEnum.Invoice);

        deleteAll(dl);
    }

    private void deleteAll(List<BusinessTransaction> dl) {
        for (BusinessTransaction bt : dl) {
            businessTransactionDao.delete(bt.getId());
        }
    }

    public void deleteExpenseRelatedEntries(Invoice expense) {
        List<BusinessTransaction> dl = businessTransactionDao.findByDocRelation(expense.fBusinessAccountUri.getValue(), expense.getId(), ReferenceDocEnum.Expense);
        deleteAll(dl);
    }

    public void deleteBankTransRelatedEntries(BankTransaction bankTrans) {
        List<BusinessTransaction> dl = businessTransactionDao.findByDocRelation(bankTrans.fBusinessAccountUri.getValue(), bankTrans.getId(), ReferenceDocEnum.BankTransaction);
        deleteAll(dl);

    }

    public void processReimbursementsPayment(BusinessAccount ba, BankTransaction bt, Map<Category, Double> rmap) {
        CoreUtils.debug("DoubleEntryProcessor.processReimbursementsPayment");

        LedgerAccountIF bank = bankAccountDao.get(bt.fBankAccountId.getValue());

        BusinessTransaction entry = createReimbursementsPaymentEntry(ba, bt);

        entry.addAccountingLeg(createLeg(entry, CompanyBuilder.BANK, bank, AccountingEntrySide.debit, fxDao.convertToOtherCurrency(bt.fValue.getValue(), bt.fCurrency.getValue(), ba.fCurrency.getValue())));

        ArrayList<Category> cats = new ArrayList<Category>(rmap.keySet());
        Collections.sort(cats);

        for (Category category : cats) {

            double amount = rmap.get(category);
            entry.addAccountingLeg(createLeg(entry, CompanyBuilder.MISCELLANEOUS_EXPENSES, category, AccountingEntrySide.credit, fxDao.convertToOtherCurrency(amount, bt.fCurrency.getValue(), ba.fCurrency.getValue())));
        }

        deleteBankTransRelatedEntries(bt);

        businessTransactionDao.save(entry);
    }

    private BusinessTransaction createReimbursementsPaymentEntry(BusinessAccount ba, BankTransaction bt) {

        String title = "Payment Bank Transaction " + bt.getId();
        String description = "Payment for reimbursements";

        return createEntry(ba, title, description, bt.getId(), bt.getName(), ReferenceDocEnum.BankTransaction, BusinessTransactionEnum.ReimbursementsPayment);
    }

    public void processDirectPayment(BusinessAccount ba, BankTransaction bt) {

        CoreUtils.debug("DoubleEntryProcessor.processDirectPayment");

        LedgerAccountIF bank = bankAccountDao.get(bt.fBankAccountId.getValue());

        LedgerAccountIF cat = categoryDao.get(bt.fAccountID.getValue());

        BusinessTransaction entry = createDirectPaymentEntry(ba, cat, bt);

        entry.addAccountingLeg(createLeg(entry, CompanyBuilder.BANK, bank, AccountingEntrySide.debit, fxDao.convertToOtherCurrency(bt.fValue.getValue(), bt.fCurrency.getValue(), ba.fCurrency.getValue())));
        entry.addAccountingLeg(createLeg(entry, CompanyBuilder.UTILITIES, cat, AccountingEntrySide.credit, fxDao.convertToOtherCurrency(bt.fValue.getValue(), bt.fCurrency.getValue(), ba.fCurrency.getValue())));

        deleteBankTransRelatedEntries(bt);

        businessTransactionDao.save(entry);
    }

    private BusinessTransaction createDirectPaymentEntry(BusinessAccount ba, LedgerAccountIF cat, BankTransaction bt) {
        String title = "Payment Bank Transaction " + bt.getId();
        String description = "Payment for: " + cat.getName();

        return createEntry(ba, title, description, bt.getId(), bt.getName(), ReferenceDocEnum.BankTransaction, BusinessTransactionEnum.DirectPayment);
    }

    public void processPurchaseFromSupplier(BusinessAccount ba, Invoice exp) {
        log.info("DoubleEntryProcessor.processPurchaseFromSupplier");

        LedgerAccountIF client = clientSupplierDao.get(exp.fClientSupplierID.getValue());
        BusinessTransaction entry = createPurchaseFromSupplierEntry(ba, exp, client);

        createExpenseLegs(ba, exp, client, entry);

        deleteExpenseRelatedEntries(exp);
        businessTransactionDao.save(entry);
    }

    private void createExpenseLegs(BusinessAccount ba, Invoice expense, LedgerAccountIF client, BusinessTransaction entry) {
        LedgerAccountIF cat = categoryDao.get(expense.fAccountID.getValue());

        CurrencyEnum invoiceCurrency = expense.fCurrency.getValue();

        double net = expense.calculateNet();
        Map<Long, TaxInfo> lTaxes = taxInfoDao.findAllFromInvoice(expense);
        Map<String, Double> taxes = expense.calculateTaxes(lTaxes);

//        String baUri = ba.fBusinessAccountUri.getValue();
        CurrencyEnum baCurrency = ba.fCurrency.getValue();

        double totalTax = ClientUtils.calculateSumOfDoubles(taxes.values());

        double total = net + totalTax;

        entry.addAccountingLeg(createLeg(entry, CompanyBuilder.ACCOUNTS_PAYABLE, client, AccountingEntrySide.debit, fxDao.convertToOtherCurrency(total, invoiceCurrency, baCurrency)));
        entry.addAccountingLeg(createLeg(entry, CompanyBuilder.PURCHASES, cat, AccountingEntrySide.credit, fxDao.convertToOtherCurrency(net, invoiceCurrency, baCurrency)));
        if (totalTax > 0) {
            for (TaxInfo taxInfo : lTaxes.values()) {

                String nominal;
                if (taxInfo.fIsVAT.getValue()) {
                    nominal = CompanyBuilder.VAT;
                } else {
                    nominal = CompanyBuilder.TAXES;
                }

                double currTax = taxes.get(taxInfo.fName.getValue());
                entry.addAccountingLeg(createLeg(entry, nominal, taxInfo, AccountingEntrySide.credit, fxDao.convertToOtherCurrency(currTax, invoiceCurrency, baCurrency)));
            }
        }
    }

    public void processPaymentToSupplier(BusinessAccount ba, Invoice expense) {
        CoreUtils.debug("DoubleEntryProcessor.processPurchaseFromSupplierPayment");
        ClientSupplier client = clientSupplierDao.get(expense.getClientSupplierID());
        NominalLedgerAccount cashNominalLedger = nominalLedgerAccountDao.loadAccountsByCode(ba.fBusinessAccountUri.getValue(), CompanyBuilder.BANK);

        double net = expense.calculateNet();
        Map<Long, TaxInfo> lTaxes = taxInfoDao.findAllFromInvoice(expense);
        Map<String, Double> t = expense.calculateTaxes(lTaxes);

        double totalTax = ClientUtils.calculateSumOfDoubles(t.values());

        BusinessTransaction entry = createSupplierPaymentEntry(ba, expense, client);

        Double total = net + totalTax;
        entry.addAccountingLeg(createLeg(entry, CompanyBuilder.BANK, cashNominalLedger, AccountingEntrySide.debit, fxDao.convertToOtherCurrency(total, expense.fCurrency.getValue(), ba.fCurrency.getValue())));
        entry.addAccountingLeg(createLeg(entry, CompanyBuilder.ACCOUNTS_PAYABLE, client, AccountingEntrySide.credit, fxDao.convertToOtherCurrency(total, expense.fCurrency.getValue(), ba.fCurrency.getValue())));

        businessTransactionDao.save(entry);
    }

    private BusinessTransaction createSupplierPaymentEntry(BusinessAccount ba, Invoice expense, ClientSupplier client) {
        String title = expense.getName();
        String description = "Payment to supplier: " + client.getName();
        return createEntry(ba, title, description, expense.getId(), expense.getName(), ReferenceDocEnum.Expense, BusinessTransactionEnum.SupplierPayment);
    }
}
