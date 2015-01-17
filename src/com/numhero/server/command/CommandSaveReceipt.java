package com.numhero.server.command;

import com.google.inject.Inject;
import com.numhero.client.model.datacargo.expense.SaveReceiptRequest;
import com.numhero.client.model.datacargo.expense.SaveReceiptResponse;
import com.numhero.client.model.pojoc.ExpenseReceipt;
import com.numhero.server.model.daolite.ExpenseReceiptDao;
import com.numhero.server.utils.DaoUtils;

import java.util.logging.Logger;

public class CommandSaveReceipt extends AbstractAuthenticatedCommand<SaveReceiptRequest, SaveReceiptResponse> {
    @SuppressWarnings("unused")
    private static final Logger log = Logger.getLogger(CommandSaveReceipt.class.getName());

    @Inject
    ExpenseReceiptDao dao;

    @Override
    public SaveReceiptResponse execute(SaveReceiptRequest request) {

        ExpenseReceipt timeEntry = (ExpenseReceipt) request.getEntity();
        DaoUtils.setData(request, timeEntry);
        dao.save(timeEntry);

        SaveReceiptResponse response = new SaveReceiptResponse();
        response.setEntityId(timeEntry.getId());
        return response;
    }
}
