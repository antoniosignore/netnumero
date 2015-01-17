package com.numhero.client.mvp.proxy;

import com.numhero.client.model.datacargo.invoice.InvoiceListRequest;
import com.numhero.client.model.datacargo.invoice.InvoiceListResponse;
import com.numhero.client.mvp.document.ArchivedInvoicesPresenter;
import com.numhero.client.service.Service;

public class ArchivedInvoicesPresenterProxy extends PresenterProxy<ArchivedInvoicesPresenter> {
    @Override
    protected ArchivedInvoicesPresenter createPresenter() {
        Service<InvoiceListRequest,InvoiceListResponse> listService = createNewService();
        return new ArchivedInvoicesPresenter(getEventManager(),
                listService,
                getConstants());

    }
}
