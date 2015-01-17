package com.numhero.client.mvp.clientsupplier;

import com.numhero.client.Application;
import com.numhero.client.model.datacargo.client_supplier.ClientSupplierListResponse;
import com.numhero.client.model.datacargo.client_supplier.SupplierListRequest;
import com.numhero.client.service.Service;
import com.numhero.client.widget.search.SearchPanel;
import com.numhero.client.widget.search.SearchPojoDialog;

public class SearchSupplierDialog extends SearchPojoDialog {

    public SearchSupplierDialog(Service<SupplierListRequest, ClientSupplierListResponse> getListService, String search) {
        super(Application.getConstants().searchSuppliers(), search, getListService, new SearchPanel(new SearchClientSupplierTable()), new SupplierListRequest());
    }
}
