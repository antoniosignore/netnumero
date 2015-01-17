package com.numhero.client.mvp.proxy;

import com.numhero.client.model.datacargo.businessaccount.GetBusinessAccountRequest;
import com.numhero.client.model.datacargo.businessaccount.GetBusinessAccountResponse;
import com.numhero.client.model.datacargo.businessaccount.SaveBusinessAccountRequest;
import com.numhero.client.model.datacargo.businessaccount.SaveBusinessAccountResponse;
import com.numhero.client.model.datacargo.invoice.InvoiceListRequest;
import com.numhero.client.model.datacargo.invoice.InvoiceListResponse;
import com.numhero.client.mvp.businessaccount.BusinessAccountPanel;
import com.numhero.client.mvp.businessaccount.BusinessAccountPresenter;
import com.numhero.client.service.Service;

public class BusinessAccountPresenterProxy extends PresenterProxy<BusinessAccountPresenter> {
    @Override
    protected BusinessAccountPresenter createPresenter() {
        Service<InvoiceListRequest,InvoiceListResponse> listService = createNewService();
        BusinessAccountPanel panel = new BusinessAccountPanel();
        return new BusinessAccountPresenter(getEventManager(),
                PresenterProxy.<GetBusinessAccountRequest, GetBusinessAccountResponse>createNewService(),
                panel,
                PresenterProxy.<SaveBusinessAccountRequest, SaveBusinessAccountResponse>createNewService());

    }
}
