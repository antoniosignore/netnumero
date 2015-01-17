package com.numhero.client.mvp.wizard;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.DialogBox;
import com.numhero.client.Application;
import com.numhero.client.ClientCache;
import com.numhero.client.model.datacargo.businessaccount.GetBusinessAccountRequest;
import com.numhero.client.model.datacargo.businessaccount.SaveBusinessAccountRequest;
import com.numhero.client.model.datacargo.businessaccount.SaveBusinessAccountResponse;
import com.numhero.client.mvp.businessaccount.BusinessAccountPanel;
import com.numhero.client.service.Service;
import com.numhero.client.service.ServiceCallbackImpl;
import com.numhero.shared.datacargo.CommandResponse;

public class WizardDialog extends DialogBox {

    public WizardDialog(final Service<SaveBusinessAccountRequest, SaveBusinessAccountResponse> businessAccountSaveService) {

        final WizardDialog dialog = this;

        final BusinessAccountPanel panel = new BusinessAccountPanel();
        panel.getBtCancel().setVisible(false);
        panel.getBtSkip().setVisible(true);

        panel.setPojo(ClientCache.getCurrentBA());

        panel.getBtCancel().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                dialog.hide();
            }
        });

        panel.getBtSave().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {

                if (panel.saveValuesFromUi()) {
                    SaveBusinessAccountRequest request = new SaveBusinessAccountRequest();
                    request.setBusinessAccountId(ClientCache.getCurrentBA().fBusinessAccountUri.getValue());
                    request.setBusinessAccount(panel.getBusinessAccountC());
                    Application.showGlasspanelLoading();
                    businessAccountSaveService.execute(request, new ServiceCallbackImpl<SaveBusinessAccountResponse>() {
                        @Override
                        public void onSuccess(SaveBusinessAccountResponse response) {
                            Application.injector.getClientCache().dontUseCache(new GetBusinessAccountRequest(), new ServiceCallbackImpl<CommandResponse>() {
                                @Override
                                public void onSuccess(CommandResponse response) {
                                    dialog.hide();
                                }
                            });
                        }
                    });
                }
            }
        });

        // if user clicks on Skip then do not save so next time the Wizard will pop-up again.
        panel.getBtSkip().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                dialog.hide();
            }
        });

//        panel.getMessage().setText(Application.getConstants().wizardMessage());
        setModal(true);
        setGlassEnabled(true);
        setAnimationEnabled(true);
        setWidget(panel);
        setText(Application.getConstants().Wizard());
    }
}
