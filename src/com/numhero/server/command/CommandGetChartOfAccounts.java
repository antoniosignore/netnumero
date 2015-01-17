package com.numhero.server.command;

import com.google.inject.Inject;
import com.numhero.client.model.datacargo.report.chartofaccounts.ChartOfAccountsRequest;
import com.numhero.client.model.datacargo.report.chartofaccounts.ChartOfAccountsResponse;
import com.numhero.server.model.daolite.*;
import com.numhero.server.utils.CommandUtils;
import com.numhero.shared.pojoc.SearchablePojo;

import java.util.List;

public class CommandGetChartOfAccounts extends AbstractAuthenticatedCommand<ChartOfAccountsRequest, ChartOfAccountsResponse> {

    @Inject
    NominalLedgerAccountDao nominalLedgerAccountDao;

    @Inject
    CategoryDao categoryDao;

    @Inject
    BankAccountDao bankAccountDao;

    @Inject
    ClientSupplierDao clientSupplierDao;

    @Inject
    TaxInfoDao taxInfoDao;

    @Override
    public ChartOfAccountsResponse execute(ChartOfAccountsRequest request) throws Exception {
		//TODO different request
        List<SearchablePojo> nominalLedgerAccounts =
              CommandUtils.getChartOfAccounts(request, bankAccountDao, nominalLedgerAccountDao, categoryDao, clientSupplierDao, taxInfoDao);
        ChartOfAccountsResponse rsp = new ChartOfAccountsResponse();
        rsp.setAccounts(nominalLedgerAccounts);
        return rsp;

    }

}
