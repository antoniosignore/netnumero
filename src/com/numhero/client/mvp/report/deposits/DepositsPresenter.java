package com.numhero.client.mvp.report.deposits;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.numhero.client.model.datacargo.report.chartofaccounts.AccountBalanceResponse;
import com.numhero.client.model.datacargo.report.deposits.DepositsRequest;
import com.numhero.client.mvp.BasePresenter;
import com.numhero.client.mvp.GenericReportTabViewPage;
import com.numhero.client.place.PlaceManager;
import com.numhero.client.service.Service;
import com.numhero.client.service.ServiceCallbackImpl;

@Singleton
public class DepositsPresenter extends BasePresenter {

    private Service<DepositsRequest, AccountBalanceResponse> getAccountBalance;

    @Inject
    public DepositsPresenter(PlaceManager eventManager,
                             DepositsPanel recentTransactionsPanel,
                             Service<DepositsRequest, AccountBalanceResponse> getAccountBalance) {
        super(eventManager, new GenericReportTabViewPage(recentTransactionsPanel));
        this.getAccountBalance = getAccountBalance;
    }

    private DepositsPanel getDepositsPanel() {
        return ((DepositsPanel) getView().getContentPanel().getContentWidget());
    }

    @Override
    public GenericReportTabViewPage getView() {
        return (GenericReportTabViewPage) super.getView();
    }

    @Override
    public void onShow() {
        refreshFromServer();
    }


    private void refreshFromServer() {
        getDepositsPanel().getDepositsTable().showLoading();
        DepositsRequest request = new DepositsRequest();
        getAccountBalance.execute(request, new ServiceCallbackImpl<AccountBalanceResponse>() {
            @Override
            public void onSuccess(AccountBalanceResponse response) {
                getDepositsPanel().getDepositsTable().setAccountIF(response.getAccountBalanceRowList());
            }
        });
    }
}
