package com.numhero.client.mvp.proxy;

import com.numhero.client.model.datacargo.report.chartofaccounts.AccountBalanceResponse;
import com.numhero.client.model.datacargo.report.receivables.ReceivablesRequest;
import com.numhero.client.mvp.report.receivables.ReceivablesPanel;
import com.numhero.client.mvp.report.receivables.ReceivablesPresenter;

public class ReceivablesPresenterProxy extends PresenterProxy<ReceivablesPresenter> {
    @Override
    protected ReceivablesPresenter createPresenter() {

        ReceivablesPanel panel = new ReceivablesPanel();
        return new ReceivablesPresenter(getEventManager(),
                panel,
                PresenterProxy.<ReceivablesRequest, AccountBalanceResponse>createNewService());
    }
}
