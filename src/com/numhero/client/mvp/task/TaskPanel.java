package com.numhero.client.mvp.task;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.DisclosurePanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.numhero.client.Application;
import com.numhero.client.model.pojoc.Task;
import com.numhero.client.mvp.AbstractEditEntityPanel;
import com.numhero.client.widget.NetNumeroButton;
import com.numhero.client.widget.combobox.CurrencySelect;
import com.numhero.client.widget.combobox.TimeUnitComboBox;
import com.numhero.client.widget.textbox.NumberTextBox;
import com.numhero.shared.pojoc.EntityPojo;
import eu.maydu.gwt.validation.client.actions.FocusAction;
import eu.maydu.gwt.validation.client.actions.StyleAction;
import eu.maydu.gwt.validation.client.validators.standard.NotEmptyValidator;

public class TaskPanel extends AbstractEditEntityPanel {
    interface TaskUiBinder extends UiBinder<Widget, TaskPanel> {
    }

    private static TaskUiBinder uiBinder = GWT.create(TaskUiBinder.class);

    @UiField
    DisclosurePanel errorsPanel;

    @UiField
    TextBox name;

    @UiField
    TextBox description;

    @UiField
    NumberTextBox billingRate;

    @UiField
    TimeUnitComboBox timeUnit;

    @UiField
    CurrencySelect cbCurrency;

    @UiField
    CheckBox billable;

    @UiField
    NetNumeroButton btSave;

    @UiField
    NetNumeroButton btCancel;

    @Inject
    public TaskPanel() {
        initWidget(uiBinder.createAndBindUi(this));
        createValidator(errorsPanel);
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

    public NumberTextBox getBillingRate() {
        return billingRate;
    }

    public void setBillingRate(NumberTextBox billingRate) {
        this.billingRate = billingRate;
    }

    public CheckBox getBillable() {
        return billable;
    }

    public void setBillable(CheckBox billable) {
        this.billable = billable;
    }

    public NetNumeroButton getBtSearch() {
        return btSave;
    }

    public void setBtSave(NetNumeroButton btSave) {
        this.btSave = btSave;
    }

    public boolean saveValuesFromUi() {
        boolean ret = validator.validate();
        if (ret) {
            Task task = (Task) pojo;
            task.fName.setValue(getName().getText());
            task.setDescription(getDescription().getText());
            task.fBillable.setValue(getBillable().getValue());
            task.fBillingRate.setValue(getBillingRate().getAmount());
            task.fCurrency.setValue(getCbCurrency().getPojo());
            task.fTimeUnit.setValue(getTimeUnit().getValue());

        } else {
            errorsPanel.setVisible(true);
        }
        return ret;
    }

    @Override
    public void setPojo(EntityPojo pojo) {
        super.setPojo(pojo);
        Task task = (Task) pojo;

        name.setValue(task.fName.getValue());
        description.setValue(task.getDescription());

        billable.setValue(task.fBillable.getValue());
        billingRate.setAmount(task.fBillingRate.getValue());
        cbCurrency.setPojo(task.fCurrency.getValue());
        timeUnit.setValue(task.fTimeUnit.getValue());
    }

    public NetNumeroButton getBtCancel() {
        return btCancel;
    }

    public Task getTask() {
        return (Task) pojo;
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    protected void addValidators() {
        FocusAction focusAction = new FocusAction();
        validator.addValidators(Application.getConstants().name(),
                new NotEmptyValidator(name, true, "required")
                        .addActionForFailure(focusAction)
                        .addActionForFailure(new StyleAction("validation-failed")));
    }

    protected DisclosurePanel getErrorsPanel() {
        return errorsPanel;
    }

    public NetNumeroButton getBtSave() {
        return btSave;
    }

    public CurrencySelect getCbCurrency() {
        return cbCurrency;
    }

    public TimeUnitComboBox getTimeUnit() {
        return timeUnit;
    }

    public void setTimeUnit(TimeUnitComboBox timeUnit) {
        this.timeUnit = timeUnit;
    }
}
