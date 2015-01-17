package com.numhero.client.mvp.clientsupplier;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.numhero.client.ClientCache;
import com.numhero.client.model.datacargo.client_supplier.GetClientSupplierRequest;
import com.numhero.client.model.datacargo.client_supplier.SaveClientSupplierRequest;
import com.numhero.client.model.pojoc.ClientSupplier;
import com.numhero.client.mvp.EditPageView;
import com.numhero.client.mvp.EditPresenter;
import com.numhero.client.place.PlaceManager;
import com.numhero.client.service.Service;
import com.numhero.client.service.ServiceCallbackImpl;
import com.numhero.shared.datacargo.GetSingleEntityResponse;
import com.numhero.shared.datacargo.SaveSingleEntityResponse;

public class ClientPresenter extends EditPresenter {
    private Service<GetClientSupplierRequest, GetSingleEntityResponse<ClientSupplier>> clientSupplierGetService;
    private Service<SaveClientSupplierRequest, SaveSingleEntityResponse> clientSaveService;
    private ClientsConstants constants;


    public ClientPresenter(PlaceManager eventManager, EditPageView view,
                           Service<GetClientSupplierRequest, GetSingleEntityResponse<ClientSupplier>> clientSupplierGetService,
                           Service<SaveClientSupplierRequest, SaveSingleEntityResponse> clientSaveService, ClientsConstants constants) {
        super(eventManager, view);
        this.clientSupplierGetService = clientSupplierGetService;
        this.clientSaveService = clientSaveService;
        this.constants = constants;
    }


    @Override
    public EditPageView getView() {
        return (EditPageView) super.getView();
    }

    @Override
    protected void onShow() {
        if (getUrl().getId() == null) {
            getView().setDetailTitlePanel(constants.newClient());
            ClientSupplier client = new ClientSupplier();
            if (ClientCache.getCurrentBA() != null) {
                client.fCountry.setValue(ClientCache.getCurrentBA().fCountry.getValue());
            }
            client.fClient.setValue(true);
            client.fSupplier.setValue(false);
            getView().setPojo(client);
        } else {
            getView().setDetailTitlePanel(constants.editClient());

            GetClientSupplierRequest request = new GetClientSupplierRequest();
            request.setEntityId(getUrl().getId());
            clientSupplierGetService.execute(request, new ServiceCallbackImpl<GetSingleEntityResponse<ClientSupplier>>() {
                @Override
                public void onSuccess(GetSingleEntityResponse<ClientSupplier> response) {
                    getView().setPojo(response.getEntity());
                }
            });
        }
    }


    @Override
    protected void onBind() {
        super.onBind();
		getView().addSaveClickHandler(getSaveHandler());
		getView().addCanceltHref("#clients");
    }

    private ClickHandler getSaveHandler() {
        ClickHandler ret = new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                if (getView().saveValuesFromUi()) {
                    SaveClientSupplierRequest request = new SaveClientSupplierRequest();
					request.setEntity((ClientSupplier) getView().getPojo());
					getView().showGlassPanel();
                    clientSaveService.execute(request, new ServiceCallbackImpl<SaveSingleEntityResponse>() {
                        @Override
                        public void onSuccess(SaveSingleEntityResponse response) {
							getView().showToaster(constants.clientSavedSuccessfully());
                            redirect();
                        }
                    });
                }
            }
        };
        return ret;
    }

    @Override
    protected String getReturnUrl() {
        return "clients";
    }

}
