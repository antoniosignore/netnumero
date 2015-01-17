package com.numhero.server.command;

import com.google.inject.Inject;
import com.numhero.client.model.datacargo.expense.SetToPaidReceiptsRequest;
import com.numhero.client.model.pojoc.BusinessAccount;
import com.numhero.client.model.pojoc.ExpenseReceipt;
import com.numhero.client.model.pojoc.Invoice;
import com.numhero.server.model.daolite.ExpenseReceiptDao;
import com.numhero.server.model.daolite.InvoiceDao;
import com.numhero.server.utils.CommandUtils;
import com.numhero.shared.datacargo.BulkActionResponse;
import com.numhero.shared.enums.InvoiceStatusEnum;

import java.util.List;

public class CommandPaidReceipts extends AbstractAuthenticatedCommand<SetToPaidReceiptsRequest, BulkActionResponse> {

    @Inject
    ExpenseReceiptDao dao;

    @Inject
    InvoiceDao invoiceDao;



    protected void payExpenseList(BulkActionResponse resp, List<Long> ids) {
        BusinessAccount ba = getBusinessAccount();
        List<Invoice> invoices = invoiceDao.findUnpaidByType(ba.fBusinessAccountUri.getValue());
        for (Long s : ids) {
            ExpenseReceipt expenseReceipt = (ExpenseReceipt) dao.get(s);
            if (CommandUtils.belongsToAnUnpaidInvoice(invoices, expenseReceipt)) {
                resp.getFailureIdList().add(s);
                continue;
            }
            expenseReceipt.fInvoiceStatus.setValue(InvoiceStatusEnum.Paid);
            dao.save(expenseReceipt);
            resp.getSuccessIdList().add(s);
            addPaidExpenseTransaction(ba, expenseReceipt);

        }
        resp.setMessage("OK");
    }

    @Override
    public BulkActionResponse execute(SetToPaidReceiptsRequest setToPaidReceiptsRequest) throws Exception {
        BulkActionResponse resp = new BulkActionResponse();
        List<Long> ids = setToPaidReceiptsRequest.getEntityIdList();
        payExpenseList(resp, ids);
        return resp;
    }

    private void addPaidExpenseTransaction(BusinessAccount ba, ExpenseReceipt receipt) {
//        DoubleEntryProcessor doubleEntryProcessor = NumheroUtils.injector.getInstance(DoubleEntryProcessor.class);
////        BankAccount bankAccount = bankAccountDao.loadCashBook(ba.fBusinessAccountUri.getValue());
//        Category category = categoryDao.get(receipt.fCategoryID.getValue());
//        Staff staff = staffDao.get(receipt.fStaffId.getValue());
//        doubleEntryProcessor.process(ba, receipt, category, null);
    }
}
