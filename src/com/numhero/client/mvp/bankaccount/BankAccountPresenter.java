package com.numhero.client.mvp.bankaccount;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.numhero.client.Application;
import com.numhero.client.model.datacargo.bankaccount.GetBankAccountRequest;
import com.numhero.client.model.datacargo.bankaccount.GetBankAccountResponse;
import com.numhero.client.model.datacargo.bankaccount.SaveBankAccountRequest;
import com.numhero.client.model.datacargo.bankaccount.SaveBankAccountResponse;
import com.numhero.client.model.pojoc.BankAccount;
import com.numhero.client.mvp.EditPageView;
import com.numhero.client.mvp.EditPresenter;
import com.numhero.client.mvp.GenericAccountsTabEditPage;
import com.numhero.client.place.PlaceManager;
import com.numhero.client.service.Service;
import com.numhero.client.service.ServiceCallbackImpl;

@Singleton
public class BankAccountPresenter extends EditPresenter {

    Service<GetBankAccountRequest, GetBankAccountResponse> bankAccountGetService;
    Service<SaveBankAccountRequest, SaveBankAccountResponse> bankAccountSaveService;
    private BankAccountConstants constants;

    @Inject
    public BankAccountPresenter(PlaceManager eventManager,
                                Service<GetBankAccountRequest, GetBankAccountResponse> bankAccountGetService,
                                Service<SaveBankAccountRequest, SaveBankAccountResponse> bankAccountSaveService,
                                BankAccountConstants constants) {
        super(eventManager, new GenericAccountsTabEditPage(new BankAccountPanel()));
        this.bankAccountGetService = bankAccountGetService;
        this.bankAccountSaveService = bankAccountSaveService;
        this.constants = constants;
    }


    @Override
    public EditPageView getView() {
        return (EditPageView) super.getView();
    }

    @Override
    public void onShow() {
        if (getUrl().getId() == null) {
            getBankAccountPanel().setPojo(new BankAccount());
            getView().setDetailTitlePanel(constants.createNewBankAccount());
        } else {
            GetBankAccountRequest request = new GetBankAccountRequest();
            request.setEntityId(getUrl().getId());
            getView().setDetailTitlePanel(constants.editBankAccount());
            bankAccountGetService.execute(request, new ServiceCallbackImpl<GetBankAccountResponse>() {
                @Override
                public void onSuccess(GetBankAccountResponse response) {
                    getBankAccountPanel().setPojo(response.getEntity());
                }
            });
        }
    }

    private BankAccountPanel getBankAccountPanel() {
        return ((BankAccountPanel) getView().getContentPanel().getContentWidget());
    }

    @Override
    protected void onBind() {
        super.onBind();
        BankAccountPanel panel = getBankAccountPanel();
        panel.getBtSave().addClickHandler(saveBankAccountHandler());
        panel.getBtCancel().setHref("#bankaccounts");
    }

    @Override
    protected void onUnbind() {
        super.onUnbind();
    }

    private ClickHandler saveBankAccountHandler() {
        ClickHandler ret = new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                if (getBankAccountPanel().saveValuesFromUi()) {
                    SaveBankAccountRequest request = new SaveBankAccountRequest();
                    request.setBankAccount(getBankAccountPanel().getBankAccountC());
                    Application.showGlasspanelLoading();
                    bankAccountSaveService.execute(request, new ServiceCallbackImpl<SaveBankAccountResponse>() {
                        @Override
                        public void onSuccess(SaveBankAccountResponse response) {
                            Application.toasterMessage("Bank account " + getBankAccountPanel().getBankAccountC().fName.getValue() + " saved");
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
        return "bankaccounts";
    }
}
