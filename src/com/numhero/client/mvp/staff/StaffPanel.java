package com.numhero.client.mvp.staff;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.numhero.client.Application;
import com.numhero.client.model.pojoc.Staff;
import com.numhero.client.mvp.AbstractEditEntityPanel;
import com.numhero.client.widget.NetNumeroButton;
import com.numhero.client.widget.combobox.CountryComboBox;
import com.numhero.client.widget.combobox.CurrencySelect;
import com.numhero.client.widget.combobox.TimeUnitComboBox;
import com.numhero.client.widget.textbox.NumberTextBox;
import com.numhero.shared.pojoc.EntityPojo;

public class StaffPanel extends AbstractEditEntityPanel {

    interface StaffUiBinder extends UiBinder<Widget, StaffPanel> {
    }

    private static StaffUiBinder uiBinder = GWT.create(StaffUiBinder.class);

    @UiField
    DisclosurePanel errorsPanel;

    // contacts
    @UiField
    TextBox name;

    @UiField
    TextBox tbEmail;

    @UiField
    TextBox tbPhone;

    @UiField
    TextBox tbMobile;

    @UiField
    TextBox tbFax;

    @UiField
    TextBox tbAddress;

    @UiField
    TextBox tbCity;

    @UiField
    TextBox tbRegion;

    @UiField
    TextBox tbZipCode;

    @UiField
    CountryComboBox tbCountry;

    @UiField
    TextArea taNotes;

    @UiField
    TimeUnitComboBox timeUnit;

    @UiField
    NumberTextBox billingRate;

    @UiField
    CurrencySelect currency;

    @UiField
    NetNumeroButton btSave;

    @UiField
    NetNumeroButton btCancel;

    @UiField
    ReimbursableExpensesTable reimbursableExpenseTable;

    @UiField
    NetNumeroButton btConvert;

    @UiField
    HTMLPanel rembourse;

    public StaffPanel() {
        initWidget(uiBinder.createAndBindUi(this));
        createValidator(errorsPanel);
        reimbursableExpenseTable.setStyleName("entity-details-table");

        btConvert.setVisible(true);
    }

    @Override
    public void setPojo(EntityPojo pojo) {
        super.setPojo(pojo);
        Staff staff = (Staff) pojo;
        name.setValue(staff.fName.getValue());
        tbEmail.setValue(staff.getEmail());
        tbPhone.setValue(staff.getPhone());
        tbMobile.setValue(staff.getMobile());
        tbFax.setValue(staff.getFax());
        tbAddress.setValue(staff.getAddress());
        tbCity.setValue(staff.getCity());
        tbRegion.setValue(staff.getRegion());
        tbZipCode.setValue(staff.getZipCode());
        tbCountry.setValue(staff.fCountry.getValue());
        taNotes.setValue(staff.getNotes());

        timeUnit.setValue(staff.fTimeUnit.getValue());
        billingRate.setAmount(staff.fBillingRate.getValue());
        currency.setPojo(staff.fCurrency.getValue());
    }

    public boolean saveValuesFromUi() {
        boolean ret = validator.validate();
        if (ret) {
            Staff staff = (Staff) pojo;
            staff.fName.setValue(name.getValue());
            staff.setEmail(tbEmail.getValue());
            staff.setPhone(tbPhone.getValue());
            staff.setFax(tbFax.getValue());
            staff.setMobile(tbMobile.getValue());
            staff.setPhone(tbPhone.getValue());
            staff.setFax(tbFax.getValue());
            staff.setAddress(tbAddress.getValue());
            staff.setCity(tbCity.getValue());
            staff.setRegion(tbRegion.getValue());
            staff.setZipCode(tbZipCode.getValue());
            staff.fCountry.setValue(tbCountry.getValue());
            staff.setNotes(taNotes.getValue());

            staff.fTimeUnit.setValue(timeUnit.getValue());
            staff.fBillingRate.setValue(billingRate.getAmount());
            staff.fCurrency.setValue(currency.getPojo());
        } else {
            errorsPanel.setVisible(true);
        }
        return ret;
    }

    @Override
    protected void addValidators() {
        addValidators(Application.getConstants().name(), notEmptyValidator(name));
    }

    public NetNumeroButton getBtSave() {
        return btSave;
    }

    public NetNumeroButton getBtCancel() {
        return btCancel;
    }

    public Staff getStaff() {
        return (Staff) pojo;
    }

    public TextBox getName() {
        return name;
    }

    public ReimbursableExpensesTable getReimbursableExpenseTable() {
        return reimbursableExpenseTable;
    }

    public NetNumeroButton getBtConvert() {
        return btConvert;
    }

    public void setBtConvert(NetNumeroButton btConvert) {
        this.btConvert = btConvert;
    }

    public HTMLPanel getRembourse() {
        return rembourse;
    }
}
