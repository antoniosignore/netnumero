package com.numhero.client.mvp.service;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.DisclosurePanel;
import com.google.gwt.user.client.ui.SuggestOracle.Suggestion;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.numhero.client.Application;
import com.numhero.client.model.pojoc.ProductService;
import com.numhero.client.mvp.AbstractEditEntityPanel;
import com.numhero.client.widget.NetNumeroButton;
import com.numhero.client.widget.combobox.CurrencySelect;
import com.numhero.client.widget.combobox.DropDownBox.DropDownBoxHandler;
import com.numhero.client.widget.combobox.ServiceUnitComboBox;
import com.numhero.client.widget.textbox.NumberTextBox;
import com.numhero.shared.enums.ProductTypeEnum;
import com.numhero.shared.pojoc.EntityPojo;
import eu.maydu.gwt.validation.client.validators.standard.NotEmptyValidator;

public class ServicePanel extends AbstractEditEntityPanel {
    interface ProductPanelUiBinder extends UiBinder<Widget, ServicePanel> {
    }

    private static ProductPanelUiBinder uiBinder = GWT.create(ProductPanelUiBinder.class);

    @UiField
    DisclosurePanel errorsPanel;

    @UiField
    TextBox tbName;

    @UiField
    TextArea tbServiceDescription;

    @UiField
    ServiceUnitComboBox cbServiceUnit;

    @UiField
    CurrencySelect cbServiceCurrency;

    @UiField
    NumberTextBox tbServiceUnitPrice;

    @UiField
    NetNumeroButton btSave;

    @UiField
    NetNumeroButton btCancel;

    public ServicePanel() {
        initWidget(uiBinder.createAndBindUi(this));

        createValidator(errorsPanel);

        cbServiceCurrency.setHandler(new DropDownBoxHandler() {
            @Override
            public void itemSelected(Suggestion pojo) {
                tbServiceUnitPrice.setCurrency(cbServiceCurrency.getPojo());
            }
        });
    }

    @Override
    public void setPojo(EntityPojo pojo) {
        super.setPojo(pojo);
        ProductService product = (ProductService) pojo;
        tbName.setValue(product.fName.getValue());
        tbServiceDescription.setValue(product.getDescription());
        cbServiceCurrency.setPojo(product.getCurrency());
        tbServiceUnitPrice.setCurrency(product.getCurrency());
        tbServiceUnitPrice.setAmount(product.getUnitPrice());
        cbServiceUnit.setValue(product.getServiceUnit());
        tbName.setFocus(true);
    }

    public boolean saveValuesFromUi() {
        boolean ret = validator.validate();
        if (ret) {
            ProductService product = (ProductService) pojo;
            product.setProductType(ProductTypeEnum.service);
            product.fName.setValue(tbName.getValue());
            product.setDescription(tbServiceDescription.getValue());
            product.setCurrency(cbServiceCurrency.getPojo());
            product.setUnitPrice(tbServiceUnitPrice.getAmount());
            product.setServiceUnit(cbServiceUnit.getValue());
        } else {
            errorsPanel.setVisible(true);
        }
        return ret;
    }

    public NetNumeroButton getBtSave() {
        return btSave;
    }

    public NetNumeroButton getBtCancel() {
        return btCancel;
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    @Override
    protected void addValidators() {
        addValidators(Application.getConstants().name(),
                new NotEmptyValidator(tbName, true, "required"));
        addValidators(Application.getConstants().description(),
                new NotEmptyValidator(tbServiceDescription, true, "required"));
        addValidators(Application.getConstants().unitPrice(),
                new NotEmptyValidator(tbServiceUnitPrice.getAmountBox(), true, "required"));
    }

    public TextBox getName() {
        return tbName;
    }
}
