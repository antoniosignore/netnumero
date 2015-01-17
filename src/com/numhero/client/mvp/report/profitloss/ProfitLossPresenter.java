package com.numhero.client.mvp.report.profitloss;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.numhero.client.model.datacargo.report.profitloss.GetProfitLossRequest;
import com.numhero.client.model.datacargo.report.profitloss.GetProfitLossResponse;
import com.numhero.client.mvp.BasePresenter;
import com.numhero.client.mvp.GenericReportTabViewPage;
import com.numhero.client.place.PlaceManager;
import com.numhero.client.service.Service;
import com.numhero.client.service.ServiceCallbackImpl;

@Singleton
public class ProfitLossPresenter extends BasePresenter {

    private Service<GetProfitLossRequest, GetProfitLossResponse> profitLossService;

    @Inject
    public ProfitLossPresenter(PlaceManager eventManager,
                               ProfitLossPanel profitLossPanel,
                               Service<GetProfitLossRequest, GetProfitLossResponse> profitLossService) {
        super(eventManager, new GenericReportTabViewPage(profitLossPanel));
        this.profitLossService = profitLossService;
    }

    private ProfitLossPanel getProfitLossPanel() {
        return ((ProfitLossPanel) getView().getContentPanel().getContentWidget());
    }


    @Override
    public GenericReportTabViewPage getView() {
        return (GenericReportTabViewPage) super.getView();
    }



    @Override
    protected void onBind() {
        super.onBind();
    }

    @Override
    protected void onUnbind() {
        super.onUnbind();
    }

    protected void refreshFromServer() {
        getProfitLossPanel().getProfitLossTable().showLoading();
        GetProfitLossRequest request = new GetProfitLossRequest();
        profitLossService.execute(request, new ServiceCallbackImpl<GetProfitLossResponse>() {
            @Override
            public void onSuccess(GetProfitLossResponse response) {
                getProfitLossPanel().getProfitLossTable().setTransactions(response);
            }
        });
    }
}
