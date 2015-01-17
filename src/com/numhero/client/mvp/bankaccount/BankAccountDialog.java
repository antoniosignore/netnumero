package com.numhero.client.mvp.bankaccount;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.inject.Inject;
import com.numhero.client.Application;
import com.numhero.client.model.datacargo.bankaccount.SaveBankAccountRequest;
import com.numhero.client.model.datacargo.bankaccount.SaveBankAccountResponse;
import com.numhero.client.model.pojoc.BankAccount;
import com.numhero.client.service.Service;
import com.numhero.client.service.ServiceCallbackImpl;

public class BankAccountDialog extends DialogBox {

    private BankAccount bankaccount;

    @Inject
    public BankAccountDialog(final Service<SaveBankAccountRequest, SaveBankAccountResponse> bankaccountSaveService,
                             final BankAccountPanel bankaccountPanel,
                             String bankaccountName) {
        setText(Application.getConstants().createNewBankAccount());
        setModal(true);
        setGlassEnabled(true);
        setAnimationEnabled(true);

        bankaccount = new BankAccount();
        bankaccount.fName.setValue(bankaccountName);

        bankaccountPanel.setPojo(bankaccount);

        bankaccountPanel.btSave.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                if (bankaccountPanel.saveValuesFromUi()) {
                    SaveBankAccountRequest request = new SaveBankAccountRequest();
                    request.setBankAccount(bankaccount);
                    Application.showGlasspanelLoading();
                    bankaccountSaveService.execute(request, new ServiceCallbackImpl<SaveBankAccountResponse>() {
                        @Override
                        public void onSuccess(SaveBankAccountResponse response) {
                            Application.toasterMessage(Application.getConstants().bankAccountSaved());
                            bankaccount.setId(response.getEntityId());
                            BankAccountDialog.this.hide();
                        }
                    });
                }
            }
        });
        bankaccountPanel.btCancel.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                BankAccountDialog.this.hide();
            }
        });
        setWidget(bankaccountPanel);
    }

    public BankAccount getBankAccount() {
        return bankaccount;
    }
}
