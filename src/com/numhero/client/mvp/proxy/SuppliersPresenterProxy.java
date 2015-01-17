package com.numhero.client.mvp.proxy;

import com.numhero.client.model.datacargo.client_supplier.ClientSupplierListResponse;
import com.numhero.client.model.datacargo.client_supplier.DeleteClientsSuppliersRequest;
import com.numhero.client.model.datacargo.client_supplier.SupplierListRequest;
import com.numhero.client.mvp.GenericAccountsTabViewPage;
import com.numhero.client.mvp.GridTabbedPage;
import com.numhero.client.mvp.clientsupplier.ClientSuppliersTable;
import com.numhero.client.mvp.clientsupplier.SuppliersPresenter;
import com.numhero.shared.datacargo.BulkActionResponse;

public class SuppliersPresenterProxy extends PresenterProxy<SuppliersPresenter> {
    @Override
    protected SuppliersPresenter createPresenter() {
    		GridTabbedPage view = new GenericAccountsTabViewPage(new ClientSuppliersTable());


        return new SuppliersPresenter(getEventManager(),
                view,
                PresenterProxy.<SupplierListRequest, ClientSupplierListResponse>createNewService(),
                PresenterProxy.<DeleteClientsSuppliersRequest, BulkActionResponse>createNewService(),
                getConstants());
    }
}
