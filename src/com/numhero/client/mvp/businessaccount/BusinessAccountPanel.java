package com.numhero.client.mvp.businessaccount;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.numhero.client.Application;
import com.numhero.client.model.pojoc.BusinessAccount;
import com.numhero.client.mvp.AbstractEditEntityPanel;
import com.numhero.client.widget.NetNumeroButton;
import com.numhero.client.widget.combobox.ColorComboBox;
import com.numhero.client.widget.combobox.CountryComboBox;
import com.numhero.client.widget.image.Image;
import com.numhero.client.widget.textbox.NumberTextBox;
import com.numhero.shared.pojoc.EntityPojo;

public class BusinessAccountPanel extends AbstractEditEntityPanel {
    interface BusinessAccountUiBinder extends UiBinder<Widget, BusinessAccountPanel> {
    }

    private static BusinessAccountUiBinder uiBinder = GWT.create(BusinessAccountUiBinder.class);

    @UiField
    DisclosurePanel errorsPanel;

    @UiField
    TextBox tbName;

    @UiField
    TextBox tbEmail;

    @UiField
    TextBox tbWeb;

    @UiField
    TextBox tbPhone;

    @UiField
    TextBox tbFax;

    @UiField
    TextBox tbVat;

    @UiField
    FileUpload fuLogo;

    @UiField
    FormPanel fpUploadLogo;

    @UiField
    Hidden hBusinessAccountId;

    @UiField
    Image imgLogo;

//    @UiField
//    DateFormatComboBox cbDateFormat;
//
//    @UiField
//    TimeFormatComboBox cbTimeFormat;

    @UiField
    TextBox tbInvoiceIDPrefix;

    @UiField
    NumberTextBox tbLastInvoiceID;

    @UiField
    NumberTextBox tbLastEstimateID;

    @UiField
    Label cbCurrency;

    @UiField
    NumberTextBox tbDefaultDaysDue;

    @UiField
    TextArea taTermsConditions;

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
    NetNumeroButton btSave;

    @UiField
    NetNumeroButton btCancel;

    @UiField
    ColorComboBox cbColorScheme;

    @UiField
    NetNumeroButton btSkip;

    public BusinessAccountPanel() {
        initWidget(uiBinder.createAndBindUi(this));

        createValidator(errorsPanel);
    }

    @Override
    public void setPojo(EntityPojo pojo) {
        super.setPojo(pojo);
        BusinessAccount ba = (BusinessAccount) pojo;
        tbName.setText(ba.fName.getValue());
        tbVat.setText(ba.fVat.getValue());
        hBusinessAccountId.setValue(ba.fId.getValueAsString());
        imgLogo.setUrl("/serveLogo/" + ba.getId());
//        cbDateFormat.setValue(ba.fDateFormat.getValue());
//        cbTimeFormat.setValue(ba.fTimeFormat.getValue());
        taTermsConditions.setText(ba.fTermsConditions.getValue());

        tbEmail.setText(ba.fEmail.getValue());
        tbWeb.setText(ba.fWeb.getValue());
        tbPhone.setText(ba.fPhone.getValue());
        tbFax.setText(ba.fFax.getValue());

        tbAddress.setValue(ba.fAddress.getValue());
        tbCity.setValue(ba.fCity.getValue());
        tbRegion.setValue(ba.fRegion.getValue());
        tbZipCode.setValue(ba.fZipCode.getValue());
        tbCountry.setValue(ba.fCountry.getValue());

        cbCurrency.setText(ba.fCurrency.getValueAsString());
        tbInvoiceIDPrefix.setText(ba.fPrefix.getValue());
        if (ba.fLastInvoiceID.getValue() != null) {
            tbLastInvoiceID.setAmount(ba.fLastInvoiceID.getValue());
        }
        if (ba.fLastEstimateID.getValue() != null) {
            tbLastEstimateID.setAmount(ba.fLastEstimateID.getValue());
        }
        if (ba.fDefaultDaysDue.getValue() != null) {
            tbDefaultDaysDue.setAmount(ba.fDefaultDaysDue.getValue());
        }
        cbColorScheme.setValue(ba.fInvoiceColor.getValue());

        tbName.setFocus(true);
    }

    public BusinessAccount getBusinessAccountC() {
        return (BusinessAccount) pojo;
    }

    public NetNumeroButton getBtSave() {
        return btSave;
    }

    public NetNumeroButton getBtCancel() {
        return btCancel;
    }

    public NetNumeroButton getBtSkip() {
        return btSkip;
    }

    public boolean saveValuesFromUi() {
        boolean ret = validator.validate();
        if (ret) {
            BusinessAccount ba = getBusinessAccountC();
            ba.fName.setValue(tbName.getText());
            ba.fVat.setValue(tbVat.getText());
//            ba.fDateFormat.setValue(cbDateFormat.getValue());
//            ba.fTimeFormat.setValue(cbTimeFormat.getValue());
            ba.fTermsConditions.setValue(taTermsConditions.getText());

            ba.fEmail.setValue(tbEmail.getText());
            ba.fWeb.setValue(tbWeb.getText());
            ba.fPhone.setValue(tbPhone.getText());
            ba.fFax.setValue(tbFax.getText());

            ba.fAddress.setValue(tbAddress.getValue());
            ba.fCity.setValue(tbCity.getValue());
            ba.fRegion.setValue(tbRegion.getValue());
            ba.fZipCode.setValue(tbZipCode.getValue());
            ba.fCountry.setValue(tbCountry.getValue());

            //      ba.fCurrency.setValue(cbCurrency.getText());
            ba.fPrefix.setValue(tbInvoiceIDPrefix.getText());
            ba.fLastInvoiceID.setValue(tbLastInvoiceID.getLongAmount());
            ba.fLastEstimateID.setValue(tbLastEstimateID.getLongAmount());
            ba.fDefaultDaysDue.setValue(tbDefaultDaysDue.getLongAmount());
            ba.fInvoiceColor.setValue(cbColorScheme.getValue());
        } else {
            errorsPanel.setVisible(true);
        }
        return ret;
    }

    @Override
    protected void addValidators() {
        addValidators(Application.getConstants().name(), notEmptyValidator(tbName));
        addValidators(Application.getConstants().web(), urlValidator(tbWeb, false));
        addValidators(Application.getConstants().phone(), phoneValidator(tbPhone, false));
        addValidators(Application.getConstants().fax(), phoneValidator(tbFax, false));
    }


}
