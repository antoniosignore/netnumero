package com.numhero.client.mvp.proxy;

import com.numhero.client.model.datacargo.invoice.ChangeStatusOfDocumentsRequest;
import com.numhero.client.model.datacargo.invoice.DeleteDocumentsRequest;
import com.numhero.client.model.datacargo.invoice.InvoiceListRequest;
import com.numhero.client.model.datacargo.invoice.InvoiceListResponse;
import com.numhero.client.mvp.GenericMoneyinTabGridPage;
import com.numhero.client.mvp.GridTabbedPage;
import com.numhero.client.mvp.document.InvoicesTable;
import com.numhero.client.mvp.document.RecentInvoicesPresenter;
import com.numhero.client.service.Service;
import com.numhero.shared.datacargo.BulkActionResponse;

public class RecentInvoicesPresenterProxy extends PresenterProxy<RecentInvoicesPresenter> {

    @Override
    protected RecentInvoicesPresenter createPresenter() {

        GridTabbedPage view = new GenericMoneyinTabGridPage(new InvoicesTable());
        Service<InvoiceListRequest, InvoiceListResponse> listService = createNewService();
        Service<DeleteDocumentsRequest, BulkActionResponse> deleteService = createNewService();
        Service<ChangeStatusOfDocumentsRequest, BulkActionResponse> changeStatusService = createNewService();
        return new RecentInvoicesPresenter(
                getEventManager(),
                listService,
                deleteService,
                changeStatusService,
                getConstants(),
                view);
    }
}
