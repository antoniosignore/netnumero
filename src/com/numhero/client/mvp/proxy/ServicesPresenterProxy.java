package com.numhero.client.mvp.proxy;

import com.numhero.client.model.datacargo.product.DeleteProductsRequest;
import com.numhero.client.model.datacargo.product.ProductListResponse;
import com.numhero.client.model.datacargo.product.ProductServicesListRequest;
import com.numhero.client.mvp.service.ServicesPresenter;
import com.numhero.shared.datacargo.BulkActionResponse;

public class ServicesPresenterProxy extends PresenterProxy<ServicesPresenter> {
    @Override
    protected ServicesPresenter createPresenter() {

        return new ServicesPresenter(getEventManager(),
                PresenterProxy.<ProductServicesListRequest, ProductListResponse>createNewService(),
                PresenterProxy.<DeleteProductsRequest, BulkActionResponse>createNewService(),
                getConstants());
    }
}
