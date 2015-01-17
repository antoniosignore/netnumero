package com.numhero.client.mvp.clientsupplier;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.numhero.client.Application;
import com.numhero.client.ClientCache;
import com.numhero.client.model.datacargo.client_supplier.GetClientSupplierRequest;
import com.numhero.client.model.datacargo.client_supplier.SaveClientSupplierRequest;
import com.numhero.client.model.pojoc.ClientSupplier;
import com.numhero.client.mvp.EditPresenter;
import com.numhero.client.mvp.GenericClientTabEditPage;
import com.numhero.client.place.PlaceManager;
import com.numhero.client.service.Service;
import com.numhero.client.service.ServiceCallbackImpl;
import com.numhero.shared.datacargo.GetSingleEntityResponse;
import com.numhero.shared.datacargo.SaveSingleEntityResponse;

@Singleton
public class SupplierPresenter extends EditPresenter {
    private Service<GetClientSupplierRequest, GetSingleEntityResponse<ClientSupplier>> clientSupplierGetService;
    private Service<SaveClientSupplierRequest, SaveSingleEntityResponse> supplierSaveService;
    private ClientsConstants constants;

    @Inject
    public SupplierPresenter(PlaceManager eventManager,
                             Service<GetClientSupplierRequest, GetSingleEntityResponse<ClientSupplier>> clientSupplierGetService,
                             Service<SaveClientSupplierRequest, SaveSingleEntityResponse> supplierSaveService,
                             ClientsConstants constants) {
        super(eventManager, new GenericClientTabEditPage(new SupplierPanel()));
        this.clientSupplierGetService = clientSupplierGetService;
        this.supplierSaveService = supplierSaveService;
        this.constants = constants;
    }


    @Override
    public GenericClientTabEditPage getView() {
        return (GenericClientTabEditPage) super.getView();
    }

    @Override
    protected void onShow() {
        if (getUrl().getId() == null) {
            getView().setDetailTitlePanel(constants.newSupplier());
            ClientSupplier supplier = new ClientSupplier();
            if (ClientCache.getCurrentBA() != null) {
                supplier.fCountry.setValue(ClientCache.getCurrentBA().fCountry.getValue());
            }
            supplier.fClient.setValue(false);
            supplier.fSupplier.setValue(true);
            getClientSupplierPanel().setPojo(supplier);
        } else {
            getView().setDetailTitlePanel(constants.editSupplier());
            GetClientSupplierRequest request = new GetClientSupplierRequest();
            request.setEntityId(getUrl().getId());
            clientSupplierGetService.execute(request, new ServiceCallbackImpl<GetSingleEntityResponse<ClientSupplier>>() {
                @Override
                public void onSuccess(GetSingleEntityResponse<ClientSupplier> response) {
                    getClientSupplierPanel().setPojo(response.getEntity());
                }
            });
        }
    }

    private ClientSupplierPanel getClientSupplierPanel() {
        return ((ClientSupplierPanel) getView().getContentPanel().getContentWidget());
    }

    @Override
    protected void onBind() {
        super.onBind();
        getClientSupplierPanel().getBtSave().addClickHandler(getSaveHandler());
        getClientSupplierPanel().getBtCancel().setHref("#suppliers");
    }

    private ClickHandler getSaveHandler() {
        ClickHandler ret = new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                if (getClientSupplierPanel().saveValuesFromUi()) {
                    SaveClientSupplierRequest request = new SaveClientSupplierRequest();
					request.setEntity(getClientSupplierPanel().getClientSupplierC());
					Application.showGlasspanelLoading();
                    supplierSaveService.execute(request, new ServiceCallbackImpl<SaveSingleEntityResponse>() {
                        @Override
                        public void onSuccess(SaveSingleEntityResponse response) {
                            Application.toasterMessage(Application.getConstants().supplierSavedSuccessfully());
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
        return "suppliers";
    }
}
