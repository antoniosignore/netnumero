package com.numhero.client.mvp.proxy;

import com.numhero.client.Application;
import com.numhero.client.model.datacargo.client_supplier.GetClientSupplierRequest;
import com.numhero.client.model.datacargo.client_supplier.SaveClientSupplierRequest;
import com.numhero.client.model.pojoc.ClientSupplier;
import com.numhero.client.mvp.EditPageView;
import com.numhero.client.mvp.GenericClientTabEditPage;
import com.numhero.client.mvp.clientsupplier.ClientPanel;
import com.numhero.client.mvp.clientsupplier.ClientPresenter;
import com.numhero.shared.datacargo.GetSingleEntityResponse;
import com.numhero.shared.datacargo.SaveSingleEntityResponse;

public class ClientPresenterProxy extends PresenterProxy<ClientPresenter> {


	@Override
    protected ClientPresenter createPresenter() {
		EditPageView view = new GenericClientTabEditPage(new ClientPanel());

		return new ClientPresenter(getEventManager(),
                view,
                PresenterProxy.<GetClientSupplierRequest, GetSingleEntityResponse<ClientSupplier>>createNewService(),
                PresenterProxy.<SaveClientSupplierRequest, SaveSingleEntityResponse>createNewService(),
                Application.getConstants());
    }
}
