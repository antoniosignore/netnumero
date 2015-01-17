package com.numhero.server.command;

import com.google.inject.Inject;
import com.numhero.client.model.datacargo.expense.DeleteReceiptsRequest;
import com.numhero.client.model.pojoc.BusinessAccount;
import com.numhero.client.model.pojoc.ExpenseReceipt;
import com.numhero.client.model.pojoc.Invoice;
import com.numhero.server.model.daolite.BaseDao;
import com.numhero.server.model.daolite.ExpenseReceiptDao;
import com.numhero.server.model.daolite.InvoiceDao;
import com.numhero.server.utils.CommandUtils;
import com.numhero.shared.datacargo.BulkActionResponse;

import java.util.List;

public class CommandDeleteReceipts extends AbstractAuthenticatedCommand<DeleteReceiptsRequest, BulkActionResponse> {

    @Inject
    ExpenseReceiptDao dao;

    @Inject
    InvoiceDao invoiceDao;

    protected void deleteIdList(BulkActionResponse resp, List<Long> ids, BaseDao dao) {
        BusinessAccount ba = getBusinessAccount();
        List<Invoice> invoices = invoiceDao.findUnpaidByType(ba.fBusinessAccountUri.getValue());
        for (Long s : ids) {
            ExpenseReceipt expenseReceipt = (ExpenseReceipt) dao.get(s);
            if (CommandUtils.belongsToAnUnpaidInvoice(invoices, expenseReceipt)) {
                resp.getFailureIdList().add(s);
                continue;
            }
            dao.delete(expenseReceipt);
            resp.getSuccessIdList().add(s);
        }
        resp.setMessage("OK");
    }

    @Override
    public BulkActionResponse execute(DeleteReceiptsRequest deleteReceiptsRequest) throws Exception {
        BulkActionResponse resp = new BulkActionResponse();
        List<Long> ids = deleteReceiptsRequest.getEntityIdList();
        deleteIdList(resp, ids, dao);
        return resp;
    }
}
