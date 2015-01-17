package com.numhero.client.mvp.businessaccount;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.FormPanel.SubmitCompleteEvent;
import com.google.gwt.user.client.ui.FormPanel.SubmitCompleteHandler;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.numhero.client.Application;
import com.numhero.client.model.datacargo.businessaccount.GetBusinessAccountRequest;
import com.numhero.client.model.datacargo.businessaccount.GetBusinessAccountResponse;
import com.numhero.client.model.datacargo.businessaccount.SaveBusinessAccountRequest;
import com.numhero.client.model.datacargo.businessaccount.SaveBusinessAccountResponse;
import com.numhero.client.mvp.EditPresenter;
import com.numhero.client.place.PlaceManager;
import com.numhero.client.service.Service;
import com.numhero.client.service.ServiceCallbackImpl;
import com.numhero.shared.datacargo.CommandResponse;

@Singleton
public class BusinessAccountPresenter extends EditPresenter {
    Service<GetBusinessAccountRequest, GetBusinessAccountResponse> businessAccountGetService;
    private Service<SaveBusinessAccountRequest, SaveBusinessAccountResponse> businessAccountSaveService;

    @Inject
    public BusinessAccountPresenter(
            PlaceManager eventManager,
            Service<GetBusinessAccountRequest, GetBusinessAccountResponse> businessAccountGetService,
            BusinessAccountPanel businessAccountPanel,
            Service<SaveBusinessAccountRequest, SaveBusinessAccountResponse> businessAccountSaveService) {
        super(eventManager, new BusinessAccountView(businessAccountPanel));
        this.businessAccountGetService = businessAccountGetService;
        this.businessAccountSaveService = businessAccountSaveService;
    }

    @Override
    protected String getReturnUrl() {
        return "dashboard";
    }

    @Override
    public BusinessAccountView getView() {
        return (BusinessAccountView) super.getView();
    }

    @Override
    public void onShow() {
        // this will force the currentBA to be reloaded

        getView().getBusinessAccountPanel().getBtCancel().setVisible(true);
        getView().getBusinessAccountPanel().getBtSkip().setVisible(false);

        Application.injector.getClientCache().dontUseCache(new GetBusinessAccountRequest(), new ServiceCallbackImpl<CommandResponse>() {
            @Override
            public void onSuccess(CommandResponse response) {
                getView().getBusinessAccountPanel().setPojo(((GetBusinessAccountResponse) response).getEntity());
            }
        });
    }

    @Override
    protected void onBind() {
        super.onBind();
        BusinessAccountPanel panel = getView().getBusinessAccountPanel();
        panel.getBtSave().addClickHandler(getSaveHandler());
        panel.getBtCancel().setHref("#dashboard");

        panel.fuLogo.addChangeHandler(getLogoUploadChangeHandler());
        panel.fpUploadLogo.addSubmitCompleteHandler(createSubmitLogoCompleteHandler());
    }

    private SubmitCompleteHandler createSubmitLogoCompleteHandler() {
        SubmitCompleteHandler ret = new SubmitCompleteHandler() {
            @Override
            public void onSubmitComplete(SubmitCompleteEvent event) {
                BusinessAccountPanel panel = getView().getBusinessAccountPanel();
                panel.imgLogo.refresh();
                panel.fpUploadLogo.reset();
            }
        };
        return ret;
    }

    private ChangeHandler getLogoUploadChangeHandler() {
        ChangeHandler ret = new ChangeHandler() {
            @Override
            public void onChange(ChangeEvent event) {
                BusinessAccountPanel panel = getView().getBusinessAccountPanel();
                panel.fpUploadLogo.submit();
            }
        };
        return ret;
    }

    private ClickHandler getSaveHandler() {
        ClickHandler ret = new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                if (getView().getBusinessAccountPanel().saveValuesFromUi()) {
                    SaveBusinessAccountRequest request = new SaveBusinessAccountRequest();
                    request.setBusinessAccount(getView().getBusinessAccountPanel().getBusinessAccountC());
                    Application.showGlasspanelLoading();
                    businessAccountSaveService.execute(request, new ServiceCallbackImpl<SaveBusinessAccountResponse>() {
                        @Override
                        public void onSuccess(SaveBusinessAccountResponse response) {
                            Application.toasterMessage(Application.getConstants().businessAccontSaved());

                            Application.injector.getClientCache().dontUseCache(new GetBusinessAccountRequest(), new ServiceCallbackImpl<CommandResponse>() {
                                @Override
                                public void onSuccess(CommandResponse response) {
                                    getView().getBusinessAccountPanel().setPojo(((GetBusinessAccountResponse) response).getEntity());
                                    redirect();
                                }
                            });
                        }
                    });
                }
            }
        };
        return ret;
    }
}
