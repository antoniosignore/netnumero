package com.numhero.client.mvp.proxy;

import com.numhero.client.model.datacargo.client_supplier.ClientListRequest;
import com.numhero.client.model.datacargo.client_supplier.ClientSupplierListResponse;
import com.numhero.client.model.datacargo.client_supplier.DeleteClientsSuppliersRequest;
import com.numhero.client.mvp.GridTabbedPage;
import com.numhero.client.mvp.clientsupplier.ClientSuppliersTable;
import com.numhero.client.mvp.clientsupplier.ClientsPresenter;
import com.numhero.client.mvp.decorator.ClientTabDecorator;
import com.numhero.client.service.Service;
import com.numhero.shared.datacargo.BulkActionResponse;

public class ClientsPresenterProxy extends PresenterProxy<ClientsPresenter> {
    private final Object viewBuilder = new Object();

    @Override
    protected ClientsPresenter createPresenter() {

        Service<ClientListRequest,ClientSupplierListResponse> listService = createNewService();
        Service<DeleteClientsSuppliersRequest,BulkActionResponse> deleteService = createNewService();
        return new ClientsPresenter(getEventManager(),
                new GridTabbedPage(new ClientSuppliersTable(), new ClientTabDecorator()),
                listService,
                deleteService,
                getConstants());
    }

}
