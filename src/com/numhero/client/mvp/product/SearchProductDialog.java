package com.numhero.client.mvp.product;

import com.numhero.client.Application;
import com.numhero.client.model.datacargo.product.ProductListResponse;
import com.numhero.client.model.datacargo.product.ProductServicesListRequest;
import com.numhero.client.service.Service;
import com.numhero.client.widget.search.SearchPanel;
import com.numhero.client.widget.search.SearchPojoDialog;

public class SearchProductDialog extends SearchPojoDialog {
    public SearchProductDialog(Service<ProductServicesListRequest, ProductListResponse> getListService, String search) {
        super(Application.getConstants().searchProduct(), search, getListService, new SearchPanel(new SearchProductTable()), new ProductServicesListRequest());
    }
}
