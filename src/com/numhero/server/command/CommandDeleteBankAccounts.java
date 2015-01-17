package com.numhero.server.command;

import com.google.inject.Inject;
import com.numhero.client.model.datacargo.bankaccount.DeleteBankAccountsRequest;
import com.numhero.server.model.daolite.BankAccountDao;
import com.numhero.shared.datacargo.BulkActionResponse;

import java.util.List;

import static com.numhero.server.utils.BulkCommandUtils.deleteIdList;

public class CommandDeleteBankAccounts extends AbstractAuthenticatedCommand<DeleteBankAccountsRequest, BulkActionResponse> {

    @Inject
    BankAccountDao dao;

    @Override
    public BulkActionResponse execute(DeleteBankAccountsRequest deleteBankAccountsRequest) throws Exception {
        BulkActionResponse resp = new BulkActionResponse();
        List<Long> ids = deleteBankAccountsRequest.getEntityIdList();
        deleteIdList(resp, ids, dao);

        return resp;
    }

}
