package com.numhero.client.mvp.report.chartofaccounts;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.numhero.client.model.datacargo.report.chartofaccounts.AccountBalanceRequest;
import com.numhero.client.model.datacargo.report.chartofaccounts.AccountBalanceResponse;
import com.numhero.client.model.datacargo.report.chartofaccounts.ChartOfAccountsRequest;
import com.numhero.client.model.datacargo.report.chartofaccounts.ChartOfAccountsResponse;
import com.numhero.client.mvp.BasePresenter;
import com.numhero.client.mvp.GenericReportTabViewPage;
import com.numhero.client.place.PlaceManager;
import com.numhero.client.service.Service;
import com.numhero.client.service.ServiceCallbackImpl;

@Singleton
public class ChartOfAccountsPresenter extends BasePresenter {

    private Service<ChartOfAccountsRequest, ChartOfAccountsResponse> chartOfAccountsService;
    private Service<AccountBalanceRequest, AccountBalanceResponse> getAccountBalance;

    @Inject
    public ChartOfAccountsPresenter(PlaceManager eventManager,
                                    ChartOfAccountsPanel recentTransactionsPanel,
                                    Service<ChartOfAccountsRequest, ChartOfAccountsResponse> getChartOfAccounts,
                                    Service<AccountBalanceRequest, AccountBalanceResponse> getAccountBalance) {
        super(eventManager, new GenericReportTabViewPage(recentTransactionsPanel));
        this.chartOfAccountsService = getChartOfAccounts;
        this.getAccountBalance = getAccountBalance;
    }

    private ChartOfAccountsPanel getChartOfAccountsPanel() {
        return ((ChartOfAccountsPanel) getView().getContentPanel().getContentWidget());
    }

    @Override
    public GenericReportTabViewPage getView() {
        return (GenericReportTabViewPage) super.getView();
    }

    @Override
    public void onShow() {
        refreshFromServer();
    }

    @Override
    protected void onUnbind() {
        super.onUnbind();
    }

    private void refreshFromServer() {
        getChartOfAccountsPanel().getChartOfAccountsTable().showLoading();
        ChartOfAccountsRequest request = new ChartOfAccountsRequest();
        chartOfAccountsService.execute(request, new ServiceCallbackImpl<ChartOfAccountsResponse>() {
            @Override
            public void onSuccess(ChartOfAccountsResponse response) {
                getChartOfAccountsPanel().getChartOfAccountsTable().setAccounts(response.getAccounts(), getAccountBalance);
            }
        });
    }
}
