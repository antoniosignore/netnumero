package com.numhero.client.mvp.clientsupplier;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.DialogBox;
import com.numhero.client.Application;
import com.numhero.client.model.datacargo.client_supplier.SaveClientSupplierRequest;
import com.numhero.client.model.pojoc.ClientSupplier;
import com.numhero.client.service.Service;
import com.numhero.client.service.ServiceCallbackImpl;
import com.numhero.shared.datacargo.SaveSingleEntityResponse;

public class ClientSupplierDialog extends DialogBox {
    private ClientSupplierPanel clientSupplierPanel;

    public ClientSupplierDialog(final Service<SaveClientSupplierRequest, SaveSingleEntityResponse> clientSupplierSaveService, ClientSupplier pojo) {
        setText(Application.getConstants().newClientSupplier());
        setModal(true);
        setGlassEnabled(true);
        setAnimationEnabled(true);

        clientSupplierPanel = new ClientSupplierPanel();

        clientSupplierPanel.setPojo(pojo);

        clientSupplierPanel.btSave.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                boolean isValid = clientSupplierPanel.saveValuesFromUi();
                if (isValid) {
                    SaveClientSupplierRequest request = new SaveClientSupplierRequest();
					request.setEntity(getPojo());
					Application.showGlasspanelLoading();
                    clientSupplierSaveService.execute(request, new ServiceCallbackImpl<SaveSingleEntityResponse>() {
                        @Override
                        public void onSuccess(SaveSingleEntityResponse response) {
                            getPojo().setId(response.getEntityId());
                            Application.toasterMessage(Application.getConstants().partnerSavedSuccessfully());
                            ClientSupplierDialog.this.hide();
                        }
                    });
                }
            }
        });
        clientSupplierPanel.btCancel.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                ClientSupplierDialog.this.hide();
            }
        });
        setWidget(clientSupplierPanel);
    }

    public ClientSupplier getPojo() {
        return clientSupplierPanel.getClientSupplierC();
    }
}
