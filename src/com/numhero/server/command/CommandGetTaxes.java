package com.numhero.server.command;

import com.google.inject.Inject;
import com.numhero.client.model.datacargo.report.chartofaccounts.AccountBalanceResponse;
import com.numhero.client.model.datacargo.report.taxes.TaxesRequest;
import com.numhero.client.model.pojoc.BusinessAccount;
import com.numhero.client.model.pojoc.NominalLedgerAccount;
import com.numhero.server.model.daolite.BusinessAccountDao;
import com.numhero.server.model.daolite.NominalLedgerAccountDao;
import com.numhero.server.service.CompanyBuilder;
import com.numhero.server.utils.CommandUtils;
import com.numhero.shared.enums.AccountClassEnum;

public class CommandGetTaxes extends AbstractAuthenticatedCommand<TaxesRequest, AccountBalanceResponse> {

    @Inject
    CommandGetAccountBalance commandGetAccountBalance;

    @Inject
    NominalLedgerAccountDao nldao;

    @Inject
    BusinessAccountDao baDao;

    @Override
    public AccountBalanceResponse execute(TaxesRequest request) throws Exception {
        BusinessAccount ba = baDao.getByUri(request.getBusinessAccountId());
        NominalLedgerAccount ar = CommandUtils.retrieveNominalAccount(
                request,
                getBusinessAccount(),
                nldao, CompanyBuilder.TAXES);
        request.setLedgerAccountId(ar.getId());
        request.setLedgerAccountClass(AccountClassEnum.NominalLedgerAccount);
        request.setCountry(ba.fCountry.getValue());
        return commandGetAccountBalance.execute(request);
    }
}
