package com.numhero.server.command;

import com.google.inject.Inject;
import com.numhero.client.model.datacargo.bankaccount.GetMainTradingBankAccountRequest;
import com.numhero.client.model.datacargo.bankaccount.GetMainTradingBankAccountResponse;
import com.numhero.client.model.pojoc.BankAccount;
import com.numhero.server.model.daolite.BankAccountDao;

public class CommandGetMainTradingBankAccount extends AbstractAuthenticatedCommand<GetMainTradingBankAccountRequest, GetMainTradingBankAccountResponse> {

    @Inject
    BankAccountDao dao;

    @Override
    public GetMainTradingBankAccountResponse execute(GetMainTradingBankAccountRequest request) throws Exception {
        BankAccount ba = dao.getMainTradingAccount(getBusinessAccount().fBusinessAccountUri.getValue());
        GetMainTradingBankAccountResponse rsp = new GetMainTradingBankAccountResponse();
        rsp.setEntity(ba);
        return rsp;
    }
}
