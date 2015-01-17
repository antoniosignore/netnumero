package com.numhero.server.command;

import com.google.inject.Inject;
import com.numhero.client.model.datacargo.report.chartofaccounts.AccountBalanceResponse;
import com.numhero.client.model.datacargo.report.deposits.DepositsRequest;
import com.numhero.client.model.pojoc.BankAccount;
import com.numhero.server.model.daolite.BankAccountDao;
import com.numhero.shared.enums.AccountClassEnum;

public class CommandGetDeposits extends AbstractAuthenticatedCommand<DepositsRequest, AccountBalanceResponse> {

    @Inject
    CommandGetAccountBalance commandGetAccountBalance;

    @Inject
    BankAccountDao dao;

    @Override
    public AccountBalanceResponse execute(DepositsRequest request) throws Exception {
        BankAccount ba = dao.getMainTradingAccount(getBusinessAccount().fBusinessAccountUri.getValue());
        request.setLedgerAccountId(ba.getId());
        request.setLedgerAccountClass(AccountClassEnum.BankAccount);
        request.setCountry(ba.fCountry.getValue());
        return commandGetAccountBalance.execute(request);
    }
}
