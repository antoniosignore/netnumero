package com.numhero.client.mvp.proxy;

import com.numhero.client.model.datacargo.report.chartofaccounts.AccountBalanceResponse;
import com.numhero.client.model.datacargo.report.deposits.DepositsRequest;
import com.numhero.client.mvp.report.deposits.DepositsPanel;
import com.numhero.client.mvp.report.deposits.DepositsPresenter;
import com.numhero.client.service.Service;

public class DepositsPresenterProxy extends PresenterProxy<DepositsPresenter> {
    @Override
    protected DepositsPresenter createPresenter() {

        Service<DepositsRequest, AccountBalanceResponse> listService = createNewService();
        DepositsPanel panel = new DepositsPanel();
        return new DepositsPresenter(getEventManager(), panel, listService);
    }
}
