package com.numhero.client.mvp.proxy;

import com.numhero.client.model.datacargo.client_supplier.GetClientSupplierRequest;
import com.numhero.client.model.datacargo.client_supplier.SaveClientSupplierRequest;
import com.numhero.client.model.pojoc.ClientSupplier;
import com.numhero.client.mvp.clientsupplier.SupplierPresenter;
import com.numhero.shared.datacargo.GetSingleEntityResponse;
import com.numhero.shared.datacargo.SaveSingleEntityResponse;

public class SupplierPresenterProxy extends PresenterProxy<SupplierPresenter> {
    @Override
    protected SupplierPresenter createPresenter() {

        return new SupplierPresenter(getEventManager(),
                PresenterProxy.<GetClientSupplierRequest, GetSingleEntityResponse<ClientSupplier>>createNewService(),
                PresenterProxy.<SaveClientSupplierRequest, SaveSingleEntityResponse>createNewService(),
                getConstants());
    }
}
