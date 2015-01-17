package com.numhero.server.command;

import com.google.inject.Inject;
import com.numhero.client.model.datacargo.banktransaction.GetBankTransactionRequest;
import com.numhero.client.model.datacargo.banktransaction.GetBankTransactionResponse;
import com.numhero.client.model.pojoc.BankTransaction;
import com.numhero.server.model.daolite.BankTransactionDao;

public class CommandGetBankTransaction extends AbstractAuthenticatedCommand<GetBankTransactionRequest, GetBankTransactionResponse> {

    @Inject
    BankTransactionDao dao;

    @Override
    public GetBankTransactionResponse execute(GetBankTransactionRequest request) throws Exception {
        GetBankTransactionResponse response = new GetBankTransactionResponse();
        BankTransaction timeEntry = dao.get(request.getEntityId());
        response.setEntity(timeEntry);
        return response;
    }
}
