package com.numhero.client.mvp.bankaccount;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.DisclosurePanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.numhero.client.Application;
import com.numhero.client.model.pojoc.BankAccount;
import com.numhero.client.mvp.AbstractEditEntityPanel;
import com.numhero.client.widget.NetNumeroButton;
import com.numhero.client.widget.combobox.CountryComboBox;
import com.numhero.client.widget.combobox.CurrencySelect;
import com.numhero.client.widget.textbox.NumberTextBox;
import com.numhero.shared.pojoc.EntityPojo;

public class BankAccountPanel extends AbstractEditEntityPanel {

    interface BankAccountUiBinder extends UiBinder<Widget, BankAccountPanel> {
    }

    private static BankAccountUiBinder uiBinder = GWT.create(BankAccountUiBinder.class);

    @UiField
    DisclosurePanel errorsPanel;

    @UiField
    TextBox name = new TextBox();

    @UiField
    TextBox description = new TextBox();

    @UiField
    TextBox bank = new TextBox();

    @UiField
    TextBox swift = new TextBox();

    @UiField
    CurrencySelect cbCurrency;

    @UiField
    TextBox account = new TextBox();

    @UiField
    TextBox iban = new TextBox();

    @UiField
    NumberTextBox openingBalance;

    @UiField
    Label currentBalance;

    @UiField
    TextBox tbAddress;

    @UiField
    TextBox tbZipCode;

    @UiField
    TextBox tbCity;

    @UiField
    TextBox tbRegion;

    @UiField
    CountryComboBox tbCountry;

    @UiField
    Label isMainTradingAccount;

    @UiField
    NetNumeroButton btSave;

    @UiField
    NetNumeroButton btCancel;


    public BankAccountPanel() {
        initWidget(uiBinder.createAndBindUi(this));
        createValidator(errorsPanel);
    }

    @Override
    public void setPojo(EntityPojo pojo) {
        super.setPojo(pojo);
        BankAccount ba = (BankAccount) pojo;
        name.setValue(ba.fName.getValue());
        cbCurrency.setPojo(ba.fCurrency.getValue());
        currentBalance.setText(ba.fValue.getValueAsString());
        openingBalance.setAmount(ba.fOpeningBalance.getValue());
        bank.setValue(ba.fBank.getValue());
        description.setValue(ba.getDescription());
        account.setValue(ba.fAccountNumber.getValue());
        iban.setValue(ba.fIban.getValue());
        swift.setValue(ba.fSwift.getValue());

        tbAddress.setValue(ba.fAddress.getValue());
        tbZipCode.setValue(ba.fZipCode.getValue());
        tbCity.setValue(ba.fCity.getValue());
        tbRegion.setValue(ba.fRegion.getValue());
        tbCountry.setValue(ba.fCountry.getValue());
        isMainTradingAccount.setText(ba.fIsMainTradingAccount.getValueAsString());
    }

    public boolean saveValuesFromUi() {
        boolean ret = validator.validate();
        if (ret) {
            BankAccount ba = (BankAccount) pojo;
            ba.fName.setValue(name.getValue());
            ba.fCurrency.setValue(cbCurrency.getPojo());
            ba.fAccountNumber.setValue(account.getValue());
            ba.fBank.setValue(bank.getValue());
            ba.setDescription(description.getValue());
            ba.fIban.setValue(iban.getValue());
            ba.fOpeningBalance.setValue(openingBalance.getAmount());
            ba.fSwift.setValue(swift.getValue());
            ba.fAddress.setValue(tbAddress.getValue());
            ba.fZipCode.setValue(tbZipCode.getValue());
            ba.fCity.setValue(tbCity.getValue());
            ba.fRegion.setValue(tbRegion.getValue());
            ba.fCountry.setValue(tbCountry.getValue());

        } else {
            errorsPanel.setVisible(true);
        }
        return ret;
    }

    public NetNumeroButton getBtCancel() {
        return btCancel;
    }

    public BankAccount getBankAccountC() {
        return (BankAccount) pojo;
    }

    @Override
    protected void addValidators() {
        addValidators(Application.getConstants().name(), notEmptyValidator(name));
        addValidators(Application.getConstants().accountNumber(), notEmptyValidator(account));
        addValidators(Application.getConstants().bankName(), notEmptyValidator(bank));
    }

    public TextBox getName() {
        return name;
    }

    public void setName(TextBox name) {
        this.name = name;
    }

    public TextBox getDescription() {
        return description;
    }

    public void setDescription(TextBox description) {
        this.description = description;
    }

    public TextBox getBank() {
        return bank;
    }

    public void setBank(TextBox bank) {
        this.bank = bank;
    }

    public TextBox getSwift() {
        return swift;
    }

    public void setSwift(TextBox swift) {
        this.swift = swift;
    }

    public TextBox getAccount() {
        return account;
    }

    public void setAccount(TextBox account) {
        this.account = account;
    }

    public TextBox getIban() {
        return iban;
    }

    public void setIban(TextBox iban) {
        this.iban = iban;
    }

    public NumberTextBox getOpeningBalance() {
        return openingBalance;
    }

    public void setOpeningBalance(NumberTextBox openingBalance) {
        this.openingBalance = openingBalance;
    }

    public Label getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(Label currentBalance) {
        this.currentBalance = currentBalance;
    }

    public TextBox getTbAddress() {
        return tbAddress;
    }

    public void setTbAddress(TextBox tbAddress) {
        this.tbAddress = tbAddress;
    }

    public TextBox getTbZipCode() {
        return tbZipCode;
    }

    public void setTbZipCode(TextBox tbZipCode) {
        this.tbZipCode = tbZipCode;
    }

    public TextBox getTbCity() {
        return tbCity;
    }

    public void setTbCity(TextBox tbCity) {
        this.tbCity = tbCity;
    }

    public TextBox getTbRegion() {
        return tbRegion;
    }

    public void setTbRegion(TextBox tbRegion) {
        this.tbRegion = tbRegion;
    }

    public CountryComboBox getTbCountry() {
        return tbCountry;
    }

    public void setTbCountry(CountryComboBox tbCountry) {
        this.tbCountry = tbCountry;
    }

    public NetNumeroButton getBtSave() {
        return btSave;
    }

    public void setBtSave(NetNumeroButton btSave) {
        this.btSave = btSave;
    }
}

