package com.numhero.client.mvp.proxy;

import com.numhero.client.model.datacargo.report.chartofaccounts.AccountBalanceRequest;
import com.numhero.client.model.datacargo.report.chartofaccounts.AccountBalanceResponse;
import com.numhero.client.model.datacargo.report.chartofaccounts.ChartOfAccountsRequest;
import com.numhero.client.model.datacargo.report.chartofaccounts.ChartOfAccountsResponse;
import com.numhero.client.mvp.report.chartofaccounts.ChartOfAccountsPanel;
import com.numhero.client.mvp.report.chartofaccounts.ChartOfAccountsPresenter;

public class ChartOfAccountsPresenterProxy extends PresenterProxy<ChartOfAccountsPresenter> {
    @Override
    protected ChartOfAccountsPresenter createPresenter() {

        ChartOfAccountsPanel panel = new ChartOfAccountsPanel();
        return new ChartOfAccountsPresenter(getEventManager(),
                panel,
                PresenterProxy.<ChartOfAccountsRequest, ChartOfAccountsResponse>createNewService(),
                PresenterProxy.<AccountBalanceRequest, AccountBalanceResponse>createNewService());
    }
}
