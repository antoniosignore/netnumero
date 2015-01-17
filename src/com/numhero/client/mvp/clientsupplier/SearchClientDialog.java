package com.numhero.client.mvp.clientsupplier;

import com.numhero.client.Application;
import com.numhero.client.model.datacargo.client_supplier.ClientListRequest;
import com.numhero.client.model.datacargo.client_supplier.ClientSupplierListResponse;
import com.numhero.client.service.Service;
import com.numhero.client.widget.search.SearchPanel;
import com.numhero.client.widget.search.SearchPojoDialog;

public class SearchClientDialog extends SearchPojoDialog {

    public SearchClientDialog(Service<ClientListRequest, ClientSupplierListResponse> getListService, String search) {
        super(Application.getConstants().searchClients(), search, getListService, new SearchPanel(new SearchClientSupplierTable()), new ClientListRequest());
    }
}
