package com.numhero.server.command;

import com.google.inject.Inject;
import com.numhero.client.model.datacargo.report.chartofaccounts.AccountBalanceResponse;
import com.numhero.client.model.datacargo.report.receivables.ReceivablesRequest;
import com.numhero.client.model.pojoc.BusinessAccount;
import com.numhero.client.model.pojoc.NominalLedgerAccount;
import com.numhero.server.model.daolite.AccountingLegDao;
import com.numhero.server.model.daolite.BusinessAccountDao;
import com.numhero.server.model.daolite.NominalLedgerAccountDao;
import com.numhero.server.service.CompanyBuilder;
import com.numhero.server.utils.CommandUtils;
import com.numhero.shared.enums.AccountClassEnum;

import java.util.logging.Logger;

public class CommandGetReceivables extends AbstractAuthenticatedCommand<ReceivablesRequest, AccountBalanceResponse> {

    @SuppressWarnings("unused")
    private static final Logger log = Logger.getLogger(CommandGetReceivables.class.getName());

    @Inject
    AccountingLegDao accountingLegDao;

    @Inject
    CommandGetAccountBalance commandGetAccountBalance;

    @Inject
    NominalLedgerAccountDao nldao;

    @Inject
    BusinessAccountDao baDao;

    @Override
    public AccountBalanceResponse execute(ReceivablesRequest request) throws Exception {
        BusinessAccount ba = baDao.getByUri(request.getBusinessAccountId());
        NominalLedgerAccount ar = CommandUtils.retrieveNominalAccount(request, getBusinessAccount(), nldao, CompanyBuilder.ACCOUNTS_PAYABLE);
        request.setLedgerAccountId(ar.getId());
        request.setLedgerAccountClass(AccountClassEnum.NominalLedgerAccount);
        request.setCountry(ba.fCountry.getValue());
        return commandGetAccountBalance.execute(request);
    }

}
