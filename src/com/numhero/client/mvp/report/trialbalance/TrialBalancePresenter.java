package com.numhero.client.mvp.report.trialbalance;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.numhero.client.model.datacargo.report.trialbalance.TrialBalanceRequest;
import com.numhero.client.model.datacargo.report.trialbalance.TrialBalanceResponse;
import com.numhero.client.mvp.BasePresenter;
import com.numhero.client.mvp.GenericReportTabViewPage;
import com.numhero.client.place.PlaceManager;
import com.numhero.client.service.Service;
import com.numhero.client.service.ServiceCallbackImpl;

@Singleton
public class TrialBalancePresenter extends BasePresenter {

    private Service<TrialBalanceRequest, TrialBalanceResponse> TrialBalanceService;

    @Inject
    public TrialBalancePresenter(PlaceManager eventManager,
                                 TrialBalancePanel recentTransactionsPanel,
                                 Service<TrialBalanceRequest, TrialBalanceResponse> TrialBalanceService) {
        super(eventManager, new GenericReportTabViewPage(recentTransactionsPanel));
        this.TrialBalanceService = TrialBalanceService;
    }

    private TrialBalancePanel getTrialBalancePanel() {
        return ((TrialBalancePanel) getView().getContentPanel().getContentWidget());
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
        getTrialBalancePanel().getTrialBalanceTable().showLoading();
        TrialBalanceRequest request = new TrialBalanceRequest();
        TrialBalanceService.execute(request, new ServiceCallbackImpl<TrialBalanceResponse>() {
            @Override
            public void onSuccess(TrialBalanceResponse response) {
                getTrialBalancePanel().getTrialBalanceTable().setBalanceRows(response.getTrialRows());
            }
        });
    }
}
