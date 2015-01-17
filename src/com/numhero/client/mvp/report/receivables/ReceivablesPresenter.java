package com.numhero.client.mvp.report.receivables;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.numhero.client.model.datacargo.report.chartofaccounts.AccountBalanceResponse;
import com.numhero.client.model.datacargo.report.receivables.ReceivablesRequest;
import com.numhero.client.mvp.BasePresenter;
import com.numhero.client.mvp.GenericReportTabViewPage;
import com.numhero.client.place.PlaceManager;
import com.numhero.client.service.Service;
import com.numhero.client.service.ServiceCallbackImpl;

@Singleton
public class ReceivablesPresenter extends BasePresenter {

    private Service<ReceivablesRequest, AccountBalanceResponse> getAccountBalance;

    @Inject
    public ReceivablesPresenter(PlaceManager eventManager,
                                ReceivablesPanel recentTransactionsPanel,
                                Service<ReceivablesRequest, AccountBalanceResponse> getAccountBalance) {
        super(eventManager, new GenericReportTabViewPage(recentTransactionsPanel));
        this.getAccountBalance = getAccountBalance;
    }

    private ReceivablesPanel getReceivablesPanel() {
        return ((ReceivablesPanel) getView().getContentPanel().getContentWidget());
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
    protected void onBind() {
        super.onBind();
    }

    @Override
    protected void onUnbind() {
        super.onUnbind();
    }

    private void refreshFromServer() {
        getReceivablesPanel().getReceivablesTable().showLoading();
        ReceivablesRequest request = new ReceivablesRequest();
        getAccountBalance.execute(request, new ServiceCallbackImpl<AccountBalanceResponse>() {
            @Override
            public void onSuccess(AccountBalanceResponse response) {
                getReceivablesPanel().getReceivablesTable().setAccountIF(response.getAccountBalanceRowList());
            }
        });
    }
}
