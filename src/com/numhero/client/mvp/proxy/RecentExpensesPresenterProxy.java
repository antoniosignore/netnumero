package com.numhero.client.mvp.proxy;

import com.numhero.client.model.datacargo.invoice.*;
import com.numhero.client.mvp.document.RecentExpensesPresenter;
import com.numhero.shared.datacargo.BulkActionResponse;

public class RecentExpensesPresenterProxy extends PresenterProxy<RecentExpensesPresenter> {
    @Override
    protected RecentExpensesPresenter createPresenter() {

        return new RecentExpensesPresenter(getEventManager(),
                PresenterProxy.<InvoiceListRequest, InvoiceListResponse>createNewService(),
                PresenterProxy.<DeleteDocumentsRequest, BulkActionResponse>createNewService(),
                PresenterProxy.<ConvertToInvoiceRequest, BulkActionResponse>createNewService(),
                PresenterProxy.<ChangeStatusOfDocumentsRequest, BulkActionResponse>createNewService(),
                getConstants());
    }
}
