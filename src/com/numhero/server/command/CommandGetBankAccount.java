package com.numhero.server.command;

import com.google.inject.Inject;
import com.numhero.client.model.datacargo.bankaccount.GetBankAccountRequest;
import com.numhero.client.model.datacargo.bankaccount.GetBankAccountResponse;
import com.numhero.client.model.pojoc.BankAccount;
import com.numhero.server.model.daolite.BankAccountDao;

public class CommandGetBankAccount extends AbstractAuthenticatedCommand<GetBankAccountRequest, GetBankAccountResponse> {

    @Inject
    BankAccountDao dao;

    @Override
    public GetBankAccountResponse execute(GetBankAccountRequest request) {
        GetBankAccountResponse response = new GetBankAccountResponse();
        BankAccount ba = dao.get(request.getEntityId());
        response.setEntity(ba);
        return response;
    }
}
