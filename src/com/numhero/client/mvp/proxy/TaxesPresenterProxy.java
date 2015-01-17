package com.numhero.client.mvp.proxy;

import com.numhero.client.model.datacargo.report.chartofaccounts.AccountBalanceResponse;
import com.numhero.client.model.datacargo.report.taxes.TaxesRequest;
import com.numhero.client.mvp.report.taxes.TaxesPanel;
import com.numhero.client.mvp.report.taxes.TaxesPresenter;

public class TaxesPresenterProxy extends PresenterProxy<TaxesPresenter> {
    @Override
    protected TaxesPresenter createPresenter() {

        TaxesPanel panel = new TaxesPanel();
        return new TaxesPresenter(getEventManager(),
                panel,
                PresenterProxy.<TaxesRequest, AccountBalanceResponse>createNewService());
    }
}
