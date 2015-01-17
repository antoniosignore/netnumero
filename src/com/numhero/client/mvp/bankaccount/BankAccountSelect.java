package com.numhero.client.mvp.bankaccount;

import com.google.gwt.event.logical.shared.CloseEvent;
import com.google.gwt.event.logical.shared.CloseHandler;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.SuggestOracle.Suggestion;
import com.numhero.client.model.datacargo.bankaccount.BankAccountListRequest;
import com.numhero.client.model.datacargo.bankaccount.BankAccountListResponse;
import com.numhero.client.model.datacargo.bankaccount.SaveBankAccountRequest;
import com.numhero.client.model.datacargo.bankaccount.SaveBankAccountResponse;
import com.numhero.client.model.pojoc.BankAccount;
import com.numhero.client.service.Service;
import com.numhero.client.widget.combobox.DropDownBox;
import com.numhero.client.widget.combobox.ServerSuggestOracle;
import com.numhero.client.widget.combobox.ServerSuggestOracle.CommandItem;

public class BankAccountSelect extends DropDownBox<BankAccountListRequest, BankAccountListResponse> {
    private Service<SaveBankAccountRequest, SaveBankAccountResponse> saveService;
    private BankAccount bankaccount;
    private BankAccountPanel panel;

    public BankAccountSelect(DropDownBoxHandler handler,
                             Service<BankAccountListRequest, BankAccountListResponse> getListService,
                             Service<SaveBankAccountRequest, SaveBankAccountResponse> saveService,
                             BankAccountPanel panel) {
        super(getListService, new BankAccountListRequest());
        setHandler(handler);
        this.saveService = saveService;
        this.panel = panel;
        initPojo();
    }

    public void setBankAccount(Long BankAccountId, String name) {
        bankaccount.setId(BankAccountId);
        bankaccount.fName.setValue(name);
        suggestBox.setValue(name, false);
    }

    @Override
    public void setPojo(Suggestion pojo) {
        super.setPojo(pojo);
        if (pojo instanceof BankAccount) {
            this.bankaccount = (BankAccount) pojo;
        }
    }

    @Override
    public BankAccount getPojo() {
        return bankaccount;
    }

    @Override
    protected void initPojo() {
        this.bankaccount = new BankAccount();
    }

    // private methods --------------------------------------------------
    @Override
    protected void commandSelected(CommandItem commandItem) {
        suggestBox.hideSuggestionList();
        if (commandItem.getReplacementString().equals(ServerSuggestOracle.CommandItem.addKey)) {
            showAddNewDialog();
        } else if (commandItem.getReplacementString().equals(ServerSuggestOracle.CommandItem.moreKey)) {
            showMoreDialog();
        }
    }

    protected void addCommandItems(ServerSuggestOracle<BankAccountListRequest, BankAccountListResponse> so) {
        so.addAddNewItem();
        so.addMoreItem();
    }

    private void showAddNewDialog() {
        final BankAccountDialog dlg = new BankAccountDialog(saveService, panel, sso.getLastSuggestRequest());
        dlg.addCloseHandler(new CloseHandler<PopupPanel>() {
            @Override
            public void onClose(CloseEvent<PopupPanel> event) {
                if (dlg.getBankAccount() != null && dlg.getBankAccount().getId() != null) {
                    suggestBox.setValue(dlg.getBankAccount().getReplacementString());
                    bankaccount.setId(dlg.getBankAccount().getId());
                    handler.itemSelected(dlg.getBankAccount());
                }
            }
        });
        dlg.center();
    }

    private void showMoreDialog() {
        final SearchBankAccountDialog dlg = new SearchBankAccountDialog(getListService, sso.getLastSuggestRequest());
        dlg.addCloseHandler(new CloseHandler<PopupPanel>() {
            @Override
            public void onClose(CloseEvent<PopupPanel> event) {
                if (dlg.getPojo() != null && dlg.getPojo().getId() != null) {
                    suggestBox.setValue(dlg.getPojo().fName.getValue());
                    bankaccount.setId(dlg.getPojo().getId());
                    handler.itemSelected(dlg.getPojo());
                }
            }
        });
        dlg.center();
    }
}
