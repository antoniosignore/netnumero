package com.numhero.client.mvp.proxy;

import com.numhero.client.model.datacargo.invoice.InvoiceListRequest;
import com.numhero.client.model.datacargo.invoice.InvoiceListResponse;
import com.numhero.client.model.datacargo.moneyin.MoneyInRecapRequest;
import com.numhero.client.model.datacargo.moneyin.MoneyInRecapResponse;
import com.numhero.client.mvp.moneyin.MoneyinPanel;
import com.numhero.client.mvp.moneyin.MoneyinPresenter;

public class MoneyInPresenterProxy extends PresenterProxy<MoneyinPresenter> {
    @Override
    protected MoneyinPresenter createPresenter() {

        MoneyinPanel panel = new MoneyinPanel();
        return new MoneyinPresenter(getEventManager(),
                panel,
                PresenterProxy.<InvoiceListRequest, InvoiceListResponse>createNewService(),
                PresenterProxy.<MoneyInRecapRequest, MoneyInRecapResponse>createNewService());
    }
}
