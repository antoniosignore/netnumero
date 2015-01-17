package com.numhero.client.mvp.category;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.DisclosurePanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.numhero.client.Application;
import com.numhero.client.model.pojoc.Category;
import com.numhero.client.mvp.AbstractEditEntityPanel;
import com.numhero.client.widget.NetNumeroButton;
import com.numhero.shared.pojoc.EntityPojo;
import eu.maydu.gwt.validation.client.actions.FocusAction;
import eu.maydu.gwt.validation.client.actions.StyleAction;
import eu.maydu.gwt.validation.client.validators.standard.NotEmptyValidator;

public class CategoryPanel extends AbstractEditEntityPanel {

    interface CategoryUiBinder extends UiBinder<Widget, CategoryPanel> {
    }

    private static CategoryUiBinder uiBinder = GWT.create(CategoryUiBinder.class);

    @UiField
    DisclosurePanel errorsPanel;

    @UiField
    TextBox name;

    @UiField
    TextBox description;

    @UiField
    NetNumeroButton btSave;

    @UiField
    NetNumeroButton btCancel;

//    @UiField
//    NumberTextBox taxPercent;


    public CategoryPanel() {
        initWidget(uiBinder.createAndBindUi(this));
        createValidator(errorsPanel);
    }

    public TextBox getName() {
        return name;
    }

    public TextBox getDescription() {
        return description;
    }

    public void setDescription(TextBox description) {
        this.description = description;
    }


    public boolean saveValuesFromUi() {
        boolean ret = validator.validate();
        if (ret) {
            getCategory().fName.setValue(getName().getText());
            getCategory().setDescription(getDescription().getText());
//            getCategory().fTaxPercent.setValue(taxPercent.getAmount());

        } else {
            errorsPanel.setVisible(true);
        }
        return ret;
    }

    @Override
    public void setPojo(EntityPojo pojo) {
        super.setPojo(pojo);
        name.setValue(getCategory().fName.getValue());
        description.setValue(getCategory().getDescription());
//        taxPercent.setAmount(getCategory().fTaxPercent.getValue());
    }

    public NetNumeroButton getBtCancel() {
        return btCancel;
    }

    public Category getCategory() {
        return (Category) getPojo();
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    protected void addValidators() {
        FocusAction focusAction = new FocusAction();
        validator.addValidators(Application.getConstants().name(),
                new NotEmptyValidator(name, true, "required")
                        .addActionForFailure(focusAction)
                        .addActionForFailure(new StyleAction("validation-failed")));
    }

    public NetNumeroButton getBtSave() {
        return btSave;
    }
}
