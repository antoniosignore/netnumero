package com.numhero.client.mvp.proxy;

import com.numhero.client.model.datacargo.invoice.*;
import com.numhero.client.mvp.document.RecentEstimatesPresenter;
import com.numhero.shared.datacargo.BulkActionResponse;

public class RecentEstimatesPresenterProxy extends PresenterProxy<RecentEstimatesPresenter> {
    @Override
    protected RecentEstimatesPresenter createPresenter() {


        return new RecentEstimatesPresenter(getEventManager(),
                PresenterProxy.<InvoiceListRequest, InvoiceListResponse>createNewService(),
                PresenterProxy.<DeleteDocumentsRequest, BulkActionResponse>createNewService(),
                PresenterProxy.<ConvertToInvoiceRequest, BulkActionResponse>createNewService(),
                PresenterProxy.<ChangeStatusOfDocumentsRequest, BulkActionResponse>createNewService(),
                getConstants());
    }
}
