package com.numhero.client.mvp.clientsupplier;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.numhero.client.Application;
import com.numhero.client.model.pojoc.ClientSupplier;
import com.numhero.client.mvp.AbstractEditEntityPanel;
import com.numhero.client.widget.NetNumeroButton;
import com.numhero.client.widget.combobox.CountryComboBox;
import com.numhero.shared.pojoc.EntityPojo;

public class ClientSupplierPanel extends AbstractEditEntityPanel {

    interface ClientSupplierUiBinder extends UiBinder<Widget, ClientSupplierPanel> {
    }

    private static ClientSupplierUiBinder uiBinder = GWT.create(ClientSupplierUiBinder.class);

    @UiField
    DisclosurePanel errorsPanel;

    @UiField
    TextBox tbCompanyName;

    @UiField
    TextBox tbVAT;

    @UiField
    Label lbPartnerType;

    @UiField
    CheckBox cbPartnerType;

    @UiField
    TextBox tbCompanyEmail;

    @UiField
    TextBox tbCompanyPhone;

    @UiField
    TextBox tbCompanyFax;

    @UiField
    TextArea taNotes;

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
    TextBox tbName;

    @UiField
    TextBox tbEmail;

    @UiField
    TextBox tbPhone;

    @UiField
    TextBox tbMobile;

    @UiField
    NetNumeroButton btSave;

    @UiField
    NetNumeroButton btCancel;

    public ClientSupplierPanel() {
        initWidget(uiBinder.createAndBindUi(this));
        createValidator(errorsPanel);
    }

    @Override
    public void setPojo(EntityPojo pojo) {
        super.setPojo(pojo);
        ClientSupplier cs = (ClientSupplier) pojo;

        tbCompanyName.setValue(cs.fName.getValue());
        tbVAT.setValue(cs.fVat.getValue());
        if (cs.fClient.getValue() && cs.fSupplier.getValue()) {
            cbPartnerType.setVisible(false);
            lbPartnerType.setText(Application.getConstants().bothClientAndSupplier());
        } else {
            cbPartnerType.setVisible(true);
            if (cs.fClient.getValue()) {
                lbPartnerType.setText(Application.getConstants().makeSupplier());
            } else {
                lbPartnerType.setText(Application.getConstants().makeClient());
            }
            cbPartnerType.setValue(false);
        }
        tbCompanyEmail.setValue(cs.fCompanyEmail.getValue());
        tbCompanyPhone.setValue(cs.fCompanyPhone.getValue());
        tbCompanyFax.setValue(cs.fCompanyFax.getValue());
        taNotes.setValue(cs.fNotes.getValue());

        tbAddress.setValue(cs.fAddress.getValue());
        tbZipCode.setValue(cs.fZipCode.getValue());
        tbCity.setValue(cs.fCity.getValue());
        tbRegion.setValue(cs.fRegion.getValue());
        tbCountry.setValue(cs.fCountry.getValue());

        tbName.setValue(cs.fContactName.getValue());
        tbEmail.setValue(cs.fContactEmail.getValue());
        tbPhone.setValue(cs.fContactPhone.getValue());
        tbMobile.setValue(cs.fContactMobile.getValue());

        tbCompanyName.setFocus(true);
    }

    public ClientSupplier getClientSupplierC() {
        return (ClientSupplier) pojo;
    }

    public boolean saveValuesFromUi() {
        boolean ret = validator.validate();
        if (ret) {
            ClientSupplier cs = getClientSupplierC();
            cs.fName.setValue(tbCompanyName.getValue());
            cs.fVat.setValue(tbVAT.getValue());
            if (!cs.fClient.getValue() && cbPartnerType.getValue()) {
                cs.fClient.setValue(true);
            }
            if (!cs.fSupplier.getValue() && cbPartnerType.getValue()) {
                cs.fSupplier.setValue(true);
            }
            cs.fCompanyEmail.setValue(tbCompanyEmail.getValue());
            cs.fCompanyPhone.setValue(tbCompanyPhone.getValue());
            cs.fCompanyFax.setValue(tbCompanyFax.getValue());
            cs.fNotes.setValue(taNotes.getValue());

            cs.fAddress.setValue(tbAddress.getValue());
            cs.fZipCode.setValue(tbZipCode.getValue());
            cs.fCity.setValue(tbCity.getValue());
            cs.fRegion.setValue(tbRegion.getValue());
            cs.fCountry.setValue(tbCountry.getValue());

            cs.fContactName.setValue(tbName.getValue());
            cs.fContactEmail.setValue(tbEmail.getValue());
            cs.fContactPhone.setValue(tbPhone.getValue());
            cs.fContactMobile.setValue(tbMobile.getValue());
        } else {
            errorsPanel.setVisible(true);
        }
        return ret;
    }

    @Override
    public NetNumeroButton getBtSave() {
        return btSave;
    }

    @Override
    public NetNumeroButton getBtCancel() {
        return btCancel;
    }

    @Override
    protected void addValidators() {
        addValidators(Application.getConstants().organisationName(), notEmptyValidator(tbCompanyName));
        addValidators(Application.getConstants().companyEmail(), emailValidator(tbCompanyEmail, false));
        addValidators(Application.getConstants().companyPhone(), phoneValidator(tbCompanyPhone, false));
        addValidators(Application.getConstants().fax(), phoneValidator(tbCompanyFax, false));
        addValidators(Application.getConstants().zip(), zipCodeValidator(tbZipCode, false));
        addValidators(Application.getConstants().email(), emailValidator(tbEmail, false));
        addValidators(Application.getConstants().phone(), phoneValidator(tbPhone, false));
        addValidators(Application.getConstants().mobile(), phoneValidator(tbMobile, false));
    }

}
