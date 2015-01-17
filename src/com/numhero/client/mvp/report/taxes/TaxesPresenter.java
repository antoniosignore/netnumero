package com.numhero.client.mvp.report.taxes;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.numhero.client.model.datacargo.report.chartofaccounts.AccountBalanceResponse;
import com.numhero.client.model.datacargo.report.taxes.TaxesRequest;
import com.numhero.client.mvp.BasePresenter;
import com.numhero.client.mvp.GenericReportTabViewPage;
import com.numhero.client.place.PlaceManager;
import com.numhero.client.service.Service;
import com.numhero.client.service.ServiceCallbackImpl;

@Singleton
public class TaxesPresenter extends BasePresenter {

    private Service<TaxesRequest, AccountBalanceResponse> getAccountBalance;

    @Inject
    public TaxesPresenter(PlaceManager eventManager,
                          TaxesPanel recentTransactionsPanel,
                          Service<TaxesRequest, AccountBalanceResponse> getAccountBalance) {
        super(eventManager, new GenericReportTabViewPage(recentTransactionsPanel));
        this.getAccountBalance = getAccountBalance;
    }

    private TaxesPanel getTaxesPanel() {
        return ((TaxesPanel) getView().getContentPanel().getContentWidget());
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
        getTaxesPanel().getTaxesTable().showLoading();
        TaxesRequest request = new TaxesRequest();
        getAccountBalance.execute(request, new ServiceCallbackImpl<AccountBalanceResponse>() {
            @Override
            public void onSuccess(AccountBalanceResponse response) {
                getTaxesPanel().getTaxesTable().setAccountIF(response.getAccountBalanceRowList());
            }
        });
    }
}
