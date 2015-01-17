package com.numhero.client.mvp.product;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.DisclosurePanel;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.SuggestOracle.Suggestion;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.numhero.client.Application;
import com.numhero.client.model.pojoc.ProductService;
import com.numhero.client.mvp.AbstractEditEntityPanel;
import com.numhero.client.widget.NetNumeroButton;
import com.numhero.client.widget.combobox.CurrencySelect;
import com.numhero.client.widget.combobox.DropDownBox.DropDownBoxHandler;
import com.numhero.client.widget.textbox.NumberTextBox;
import com.numhero.shared.enums.CurrencyEnum;
import com.numhero.shared.enums.ProductTypeEnum;
import com.numhero.shared.pojoc.EntityPojo;
import eu.maydu.gwt.validation.client.validators.standard.NotEmptyValidator;

public class ProductPanel extends AbstractEditEntityPanel {
    interface ProductPanelUiBinder extends UiBinder<HTMLPanel, ProductPanel> {
    }

    private static ProductPanelUiBinder uiBinder = GWT.create(ProductPanelUiBinder.class);

    @UiField
    DisclosurePanel errorsPanel;

    @UiField
    TextBox tbProductName;

    @UiField
    TextArea tbProductDescription;

    @UiField
    CurrencySelect cbProductCurrency;

    @UiField
    NumberTextBox tbProductUnitPrice;

    /*
    @UiField
    CheckBox cbProductTrackingEnabled;

    @UiField
    Label lbProductQuantity;

    @UiField
    NumberTextBox tbProductQuantity;
    */

    @UiField
    NetNumeroButton btSave;

    @UiField
    NetNumeroButton btCancel;

    public ProductPanel() {
        initWidget(uiBinder.createAndBindUi(this));

        createValidator(errorsPanel);

        cbProductCurrency.setHandler(new DropDownBoxHandler() {
            @Override
            public void itemSelected(Suggestion pojo) {
                CurrencyEnum currency = (CurrencyEnum) pojo;
                tbProductUnitPrice.setCurrency(currency);
            }
        });
//        cbProductTrackingEnabled.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
//            @Override
//            public void onValueChange(ValueChangeEvent<Boolean> event) {
//                lbProductQuantity.setVisible(event.getValue());
//                tbProductQuantity.setVisible(event.getValue());
//            }
//        });
    }

    @Override
    public void setPojo(EntityPojo pojo) {
        super.setPojo(pojo);
        ProductService ps = (ProductService) pojo;
        tbProductName.setValue(ps.fName.getValue());
        tbProductDescription.setValue(ps.getDescription());
        cbProductCurrency.setPojo(ps.getCurrency());
        tbProductUnitPrice.setCurrency(ps.getCurrency());
        tbProductUnitPrice.setAmount(ps.getUnitPrice());
//        cbProductTrackingEnabled.setValue(ps.isTrackingEnabled());
//        lbProductQuantity.setVisible(ps.isTrackingEnabled());
//        tbProductQuantity.setVisible(ps.isTrackingEnabled());
//        tbProductQuantity.setAmount(ps.getQuantity());
        tbProductName.setFocus(true);
    }

    public boolean saveValuesFromUi() {
        boolean ret = validator.validate();
        if (ret) {
            ProductService productC = (ProductService) pojo;
            productC.setProductType(ProductTypeEnum.product);
            productC.fName.setValue(tbProductName.getValue());
            productC.setDescription(tbProductDescription.getValue());
            productC.setCurrency(cbProductCurrency.getPojo());
            productC.setUnitPrice(tbProductUnitPrice.getAmount());
//            productC.setTrackingEnabled(cbProductTrackingEnabled.getValue());
//            productC.setQuantity(tbProductQuantity.getAmount());
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

    public TextBox getName() {
        return tbProductName;
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    @Override
    protected void addValidators() {
        addValidators(Application.getConstants().name(), new NotEmptyValidator(tbProductName, true, "required"));
        addValidators(Application.getConstants().description(), new NotEmptyValidator(tbProductDescription, true, "required"));
        addValidators(Application.getConstants().unitPrice(), new NotEmptyValidator(tbProductUnitPrice.getAmountBox(), true, "required"));
    }

}
