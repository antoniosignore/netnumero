package com.numhero.client.mvp.report.vat;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.numhero.client.model.datacargo.report.chartofaccounts.AccountBalanceResponse;
import com.numhero.client.model.datacargo.report.vat.VATRequest;
import com.numhero.client.mvp.BasePresenter;
import com.numhero.client.mvp.GenericReportTabViewPage;
import com.numhero.client.place.PlaceManager;
import com.numhero.client.service.Service;
import com.numhero.client.service.ServiceCallbackImpl;

@Singleton
public class VATPresenter extends BasePresenter {

    private Service<VATRequest, AccountBalanceResponse> getAccountBalance;

    @Inject
    public VATPresenter(PlaceManager eventManager,
                        VATPanel recentTransactionsPanel,
                        Service<VATRequest, AccountBalanceResponse> getAccountBalance) {
        super(eventManager, new GenericReportTabViewPage(recentTransactionsPanel));
        this.getAccountBalance = getAccountBalance;
    }

    private VATPanel getVATPanel() {
        return ((VATPanel) getView().getContentPanel().getContentWidget());
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
        getVATPanel().getVATTable().showLoading();
        VATRequest request = new VATRequest();
        getAccountBalance.execute(request, new ServiceCallbackImpl<AccountBalanceResponse>() {
            @Override
            public void onSuccess(AccountBalanceResponse response) {
                getVATPanel().getVATTable().setAccountIF(response.getAccountBalanceRowList());
            }
        });
    }
}
