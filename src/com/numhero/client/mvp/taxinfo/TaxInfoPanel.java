package com.numhero.client.mvp.taxinfo;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.DisclosurePanel;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.numhero.client.Application;
import com.numhero.client.model.pojoc.TaxInfo;
import com.numhero.client.mvp.AbstractEditEntityPanel;
import com.numhero.client.widget.NetNumeroButton;
import com.numhero.client.widget.textbox.NumberTextBox;
import com.numhero.shared.pojoc.EntityPojo;

public class TaxInfoPanel extends AbstractEditEntityPanel {
    interface TaxInfoPanelUiBinder extends UiBinder<HTMLPanel, TaxInfoPanel> {
    }

    private static TaxInfoPanelUiBinder uiBinder = GWT.create(TaxInfoPanelUiBinder.class);

    @UiField
    DisclosurePanel errorsPanel;

    @UiField
    TextBox tbName;

    @UiField
    NumberTextBox tbPercent;

    @UiField
    NetNumeroButton btSave;

    @UiField
    NetNumeroButton btCancel;

    @UiField
    TextBox description;

    @UiField
    CheckBox cbIsVat;

    public TaxInfoPanel() {
        initWidget(uiBinder.createAndBindUi(this));
        createValidator(errorsPanel);
    }

    @Override
    public void setPojo(EntityPojo pojo) {
        super.setPojo(pojo);
        TaxInfo ti = (TaxInfo) pojo;
        tbName.setValue(ti.fName.getValue());
        description.setValue(ti.fDescription.getValue());
        tbPercent.setAmount(ti.getPercent());
        cbIsVat.setValue(ti.fIsVAT.getValue());
    }

    public boolean saveValuesFromUi() {
        boolean ret = validator.validate();
        if (ret) {
            TaxInfo ti = getTaxInfo();
            ti.fName.setValue(tbName.getValue());
            ti.fDescription.setValue(description.getValue());
            ti.setPercent(tbPercent.getAmount());
            ti.fIsVAT.setValue(cbIsVat.getValue());
        } else {
            errorsPanel.setVisible(true);
        }
        return ret;
    }

    public TaxInfo getTaxInfo() {
        return (TaxInfo) pojo;
    }

    public NetNumeroButton getBtSave() {
        return btSave;
    }

    public NetNumeroButton getBtCancel() {
        return btCancel;
    }

    @Override
    protected void addValidators() {
        addValidators(Application.getConstants().name(), notEmptyValidator(tbName));
        addValidators(Application.getConstants().taxPercent(), doubleValidator(tbPercent.getAmountBox(), 0.00f, 100.00f, false));
    }

}
