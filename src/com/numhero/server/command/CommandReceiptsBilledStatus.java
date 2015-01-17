package com.numhero.server.command;

import com.google.inject.Inject;
import com.numhero.client.model.datacargo.expense.ReceiptsBilledStatusRequest;
import com.numhero.client.model.pojoc.ExpenseReceipt;
import com.numhero.server.model.daolite.ExpenseReceiptDao;
import com.numhero.shared.datacargo.BulkActionResponse;
import com.numhero.shared.enums.InvoiceStatusEnum;
import com.numhero.shared.exception.ClientWarningException;

import java.util.List;

public class CommandReceiptsBilledStatus extends AbstractAuthenticatedCommand<ReceiptsBilledStatusRequest, BulkActionResponse> {

    @Inject
    ExpenseReceiptDao dao;

    @Override
    public BulkActionResponse execute(ReceiptsBilledStatusRequest request) throws Exception {

        BulkActionResponse resp = new BulkActionResponse();
        List<Long> ids = request.getEntityIdList();

        if (ids.isEmpty()) throw new ClientWarningException("ids cannot be null");

        for (Long s : ids) {
            ExpenseReceipt expenseReceipt = dao.get(s);
            expenseReceipt.fInvoiceStatus.setValue(InvoiceStatusEnum.Billed);

            dao.save(expenseReceipt);
            resp.getSuccessIdList().add(s);
        }
        log.fine("resp.getSuccessIdList().size() = " + resp.getSuccessIdList().size());
        log.fine("resp.getFailureIdList().size() = " + resp.getFailureIdList().size());

        resp.setSuccessIdList(resp.getSuccessIdList());
        resp.setFailureIdList(resp.getFailureIdList());
        resp.setMessage("OK");

        return resp;
    }
}
