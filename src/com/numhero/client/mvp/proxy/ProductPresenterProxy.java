package com.numhero.client.mvp.proxy;

import com.numhero.client.model.datacargo.product.GetItemRequest;
import com.numhero.client.model.datacargo.product.GetItemResponse;
import com.numhero.client.model.datacargo.product.SaveProductRequest;
import com.numhero.client.model.datacargo.product.SaveProductResponse;
import com.numhero.client.mvp.product.ProductPanel;
import com.numhero.client.mvp.product.ProductPresenter;

public class ProductPresenterProxy extends PresenterProxy<ProductPresenter> {
    @Override
    protected ProductPresenter createPresenter() {

        ProductPanel panel = new ProductPanel();
        return new ProductPresenter(getEventManager(),
                PresenterProxy.<GetItemRequest, GetItemResponse>createNewService(),
                PresenterProxy.<SaveProductRequest, SaveProductResponse>createNewService(),
                panel,
                getConstants());
    }
}
