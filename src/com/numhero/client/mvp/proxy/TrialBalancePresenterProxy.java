package com.numhero.client.mvp.proxy;

import com.numhero.client.model.datacargo.report.trialbalance.TrialBalanceRequest;
import com.numhero.client.model.datacargo.report.trialbalance.TrialBalanceResponse;
import com.numhero.client.mvp.report.trialbalance.TrialBalancePanel;
import com.numhero.client.mvp.report.trialbalance.TrialBalancePresenter;

public class TrialBalancePresenterProxy extends PresenterProxy<TrialBalancePresenter> {
    @Override
    protected TrialBalancePresenter createPresenter() {

        TrialBalancePanel panel = new TrialBalancePanel();
        return new TrialBalancePresenter(getEventManager(),
                panel,
                PresenterProxy.<TrialBalanceRequest, TrialBalanceResponse>createNewService());
    }
}
