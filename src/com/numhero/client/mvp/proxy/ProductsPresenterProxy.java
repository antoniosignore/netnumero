package com.numhero.client.mvp.proxy;

import com.numhero.client.model.datacargo.product.DeleteProductsRequest;
import com.numhero.client.model.datacargo.product.ProductListResponse;
import com.numhero.client.model.datacargo.product.ProductServicesListRequest;
import com.numhero.client.mvp.product.ProductsPresenter;
import com.numhero.shared.datacargo.BulkActionResponse;

public class ProductsPresenterProxy extends PresenterProxy<ProductsPresenter> {
    @Override
    protected ProductsPresenter createPresenter() {

        return new ProductsPresenter(getEventManager(),
                PresenterProxy.<ProductServicesListRequest, ProductListResponse>createNewService(),
                PresenterProxy.<DeleteProductsRequest, BulkActionResponse>createNewService(),
                getConstants());
    }
}
