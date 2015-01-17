package com.numhero.server.command;

import com.google.inject.Inject;
import com.numhero.client.model.datacargo.expense.DeleteReceiptsRequest;
import com.numhero.server.model.daolite.ExpenseReceiptDao;
import com.numhero.shared.datacargo.BulkActionResponse;

import java.util.List;

import static com.numhero.server.utils.BulkCommandUtils.deleteIdList;

public class CommandReceiptsExpenses extends AbstractAuthenticatedCommand<DeleteReceiptsRequest, BulkActionResponse> {

    @Inject
    ExpenseReceiptDao dao;

    @Override
    public BulkActionResponse execute(DeleteReceiptsRequest deleteReceiptsRequest) throws Exception {

        BulkActionResponse resp = new BulkActionResponse();
        List<Long> ids = deleteReceiptsRequest.getEntityIdList();
        deleteIdList(resp, ids, dao);
        return resp;
    }
}
