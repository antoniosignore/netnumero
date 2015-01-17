package com.numhero.client.mvp.proxy;

import com.numhero.client.model.datacargo.report.chartofaccounts.AccountBalanceResponse;
import com.numhero.client.model.datacargo.report.vat.VATRequest;
import com.numhero.client.mvp.report.vat.VATPanel;
import com.numhero.client.mvp.report.vat.VATPresenter;
import com.numhero.client.service.Service;

public class VATPresenterProxy extends PresenterProxy<VATPresenter> {
    @Override
    protected VATPresenter createPresenter() {

        Service<VATRequest,AccountBalanceResponse> service= createNewService();
        VATPanel panel = new VATPanel();
        return new VATPresenter(getEventManager(), panel, service);
    }
}
