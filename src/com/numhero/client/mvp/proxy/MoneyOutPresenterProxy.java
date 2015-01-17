package com.numhero.client.mvp.proxy;

import com.numhero.client.model.datacargo.invoice.InvoiceListRequest;
import com.numhero.client.model.datacargo.invoice.InvoiceListResponse;
import com.numhero.client.model.datacargo.moneyout.MoneyOutRecapRequest;
import com.numhero.client.model.datacargo.moneyout.MoneyOutRecapResponse;
import com.numhero.client.mvp.moneyout.MoneyOutPanel;
import com.numhero.client.mvp.moneyout.MoneyOutPresenter;

public class MoneyOutPresenterProxy extends PresenterProxy<MoneyOutPresenter> {
    @Override
    protected MoneyOutPresenter createPresenter() {

        MoneyOutPanel panel = new MoneyOutPanel();
        return new MoneyOutPresenter(getEventManager(),
                panel,
                PresenterProxy.<InvoiceListRequest, InvoiceListResponse>createNewService(),
                PresenterProxy.<MoneyOutRecapRequest, MoneyOutRecapResponse>createNewService());
    }
}
