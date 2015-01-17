package com.numhero.client.mvp.proxy;

import com.numhero.client.model.datacargo.product.GetItemRequest;
import com.numhero.client.model.datacargo.product.GetItemResponse;
import com.numhero.client.model.datacargo.product.SaveProductRequest;
import com.numhero.client.model.datacargo.product.SaveProductResponse;
import com.numhero.client.mvp.service.ServicePresenter;

public class ServicePresenterProxy extends PresenterProxy<ServicePresenter> {
    @Override
    protected ServicePresenter createPresenter() {

        return new ServicePresenter(getEventManager(),
                PresenterProxy.<GetItemRequest, GetItemResponse>createNewService(),
                PresenterProxy.<SaveProductRequest, SaveProductResponse>createNewService(),
                getConstants());
    }
}
