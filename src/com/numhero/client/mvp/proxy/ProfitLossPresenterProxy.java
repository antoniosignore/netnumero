package com.numhero.client.mvp.proxy;

import com.numhero.client.model.datacargo.report.profitloss.GetProfitLossRequest;
import com.numhero.client.model.datacargo.report.profitloss.GetProfitLossResponse;
import com.numhero.client.mvp.report.profitloss.ProfitLossPanel;
import com.numhero.client.mvp.report.profitloss.ProfitLossPresenter;

public class ProfitLossPresenterProxy extends PresenterProxy<ProfitLossPresenter> {
    @Override
    protected ProfitLossPresenter createPresenter() {

        ProfitLossPanel panel = new ProfitLossPanel();
        return new ProfitLossPresenter(getEventManager(),
                panel,
                PresenterProxy.<GetProfitLossRequest, GetProfitLossResponse>createNewService());
    }
}
