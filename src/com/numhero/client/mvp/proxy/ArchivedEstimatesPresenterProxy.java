package com.numhero.client.mvp.proxy;

import com.numhero.client.model.datacargo.invoice.InvoiceListRequest;
import com.numhero.client.model.datacargo.invoice.InvoiceListResponse;
import com.numhero.client.mvp.document.ArchivedEstimatesPresenter;
import com.numhero.client.service.Service;

public class ArchivedEstimatesPresenterProxy extends PresenterProxy<ArchivedEstimatesPresenter> {
    @Override
    protected ArchivedEstimatesPresenter createPresenter() {
        Service<InvoiceListRequest,InvoiceListResponse> listService = createNewService();
        return new ArchivedEstimatesPresenter(getEventManager(),
                listService,
                getConstants());
    }
}
