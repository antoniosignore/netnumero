package com.numhero.server.command;

import com.google.inject.Inject;
import com.numhero.client.model.datacargo.expense.GetReceiptRequest;
import com.numhero.client.model.datacargo.expense.GetReceiptResponse;
import com.numhero.client.model.pojoc.ExpenseReceipt;
import com.numhero.server.model.daolite.ExpenseReceiptDao;

public class CommandGetReceipt extends AbstractAuthenticatedCommand<GetReceiptRequest, GetReceiptResponse> {

    @Inject
    ExpenseReceiptDao dao;

    @Override
    public GetReceiptResponse execute(GetReceiptRequest request) throws Exception {
        GetReceiptResponse response = new GetReceiptResponse();
        ExpenseReceipt timeEntry = dao.get(request.getEntityId());
        response.setEntity(timeEntry);
        return response;
    }
}
