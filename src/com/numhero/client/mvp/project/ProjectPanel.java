package com.numhero.client.mvp.project;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.TableRowElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.DisclosurePanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SuggestOracle.Suggestion;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.numhero.client.Application;
import com.numhero.client.model.datacargo.client_supplier.ClientListRequest;
import com.numhero.client.model.datacargo.client_supplier.ClientSupplierListResponse;
import com.numhero.client.model.datacargo.client_supplier.SaveClientSupplierRequest;
import com.numhero.client.model.pojoc.ClientSupplier;
import com.numhero.client.model.pojoc.Project;
import com.numhero.client.model.pojoc.ProjectStaffDetail;
import com.numhero.client.model.pojoc.ProjectTaskDetail;
import com.numhero.client.mvp.AbstractEditEntityPanel;
import com.numhero.client.mvp.clientsupplier.ClientSelect;
import com.numhero.client.mvp.timeentry.TimeEntriesTable;
import com.numhero.client.service.Service;
import com.numhero.client.util.ApplicationValidationMessages;
import com.numhero.client.util.CoreUtils;
import com.numhero.client.widget.CustomFormatDateBox;
import com.numhero.client.widget.NetNumeroButton;
import com.numhero.client.widget.combobox.*;
import com.numhero.client.widget.textbox.NumberTextBox;
import com.numhero.shared.datacargo.SaveSingleEntityResponse;
import com.numhero.shared.enums.BillingMethodEnum;
import com.numhero.shared.pojoc.EntityPojo;
import eu.maydu.gwt.validation.client.actions.FocusAction;
import eu.maydu.gwt.validation.client.actions.StyleAction;
import eu.maydu.gwt.validation.client.i18n.ValidationMessages;
import eu.maydu.gwt.validation.client.validators.standard.NotEmptyValidator;

public class ProjectPanel extends AbstractEditEntityPanel implements ClientSelect.DropDownBoxHandler {

    interface ProjectUiBinder extends UiBinder<Widget, ProjectPanel> {
    }

    private static ProjectUiBinder uiBinder = GWT.create(ProjectUiBinder.class);

    @UiField
    DisclosurePanel errorsPanel;

    @UiField(provided = true)
    DropDownBox<?, ?> sbClient;

    @UiField
    TextBox name;

    @UiField
    TextBox description;

    @UiField
    Label created;

    @UiField
    Label lastBilled;

    @UiField
    Label totalTime;

    @UiField
    Label billableTime;

    @UiField
    ProjectStateEnumComboBox cbState;

    @UiField(provided = true)
    ProjectTasksDetailsTable projectTasksDetailsTable;

    @UiField(provided = true)
    ProjectStaffDetailsTable projectStaffDetailsTable;

    @UiField
    NetNumeroButton btAddTask;

    @UiField
    NetNumeroButton btAddStaff;

    @UiField
    NetNumeroButton btSave;

    @UiField
    NetNumeroButton btCancel;

    @UiField
    BillingMethodComboBox billingMethod;

    @UiField
    CurrencySelect cbCurrency;

    @UiField
    NumberTextBox billingFlatRate;

    @UiField
    NumberTextBox billingRate;

    @UiField
    TimeUnitComboBox timeUnit;

    @UiField
    NetNumeroButton btGenerateInvoice;

    @UiField
    TimeEntriesTable timeEntriesTable;

    @UiField
    ProjectExpensesTable expensesTable;

    @UiField
    CustomFormatDateBox from;

    @UiField
    CustomFormatDateBox to;

    @UiField
    NetNumeroButton btGenerateEstimate;

    @UiField
    TableRowElement billingFlatRateRow;

    @UiField
    TableRowElement billingRateRow;

    @UiField
    Label valuationLabel;

    @UiField
    DisclosurePanel taskGroup;

    @UiField
    DisclosurePanel staffGroup;

    @UiField
    DisclosurePanel hoursGroup;

    @UiField
    DisclosurePanel expensesGroup;

    @UiField
    NetNumeroButton btConvert;

//    @UiField
//    CurrencyPanel currencyPanel;

    Double valuation = 0.0D;


    @Inject
    public ProjectPanel(Service<ClientListRequest, ClientSupplierListResponse> clientSuppliersService,
                        Service<SaveClientSupplierRequest, SaveSingleEntityResponse> clientSupplierSaveService,
                        ProjectTasksDetailsTable tdt,
                        ProjectStaffDetailsTable sdt) {
        sbClient = new ClientSelect(this, clientSuppliersService, clientSupplierSaveService);
        sbClient.setHandler(this);

        projectTasksDetailsTable = tdt;
        projectStaffDetailsTable = sdt;

        initWidget(uiBinder.createAndBindUi(this));

        createValidator(errorsPanel);

        projectTasksDetailsTable.setValidator(validator);
        projectStaffDetailsTable.setValidator(validator);

        btAddTask.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                ProjectTaskDetail idc1 = new ProjectTaskDetail();
                getProject().fProjectTaskDetails.add(idc1);
                projectTasksDetailsTable.addLine(idc1);
                projectTasksDetailsTable.setValues();
            }
        });

        btAddStaff.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                ProjectStaffDetail psd = new ProjectStaffDetail();
                getProject().fProjectStaffDetails.add(psd);
                projectStaffDetailsTable.addLine(psd);
                projectStaffDetailsTable.setValues();
            }
        });
    }

    public Double getValuation() {
        return valuation;
    }

    public void setValuation(Double valuation) {
        this.valuation = valuation;
    }

    public NetNumeroButton getBtSave() {
        return btSave;
    }

    @Override
    public void setPojo(EntityPojo pojo) {
        super.setPojo(pojo);

        billingMethod.setValue(getProject().fBillingMethod.getValue());
        cbCurrency.setPojo(getProject().fCurrency.getValue());
        timeUnit.setValue(getProject().fTimeUnit.getValue());
        billingRate.setAmount(getProject().fBillingRate.getValue());
        billingFlatRate.setAmount(getProject().fFlatBillingRate.getValue());

        projectTasksDetailsTable.setProject((Project) pojo);
        projectStaffDetailsTable.setProject((Project) pojo);

        ClientSupplier cs = (ClientSupplier) sbClient.getPojo();
        cs.setId(getProject().fClientSupplierID.getValue());
        cs.fClient.setValue(true);
        cs.fName.setValue(getProject().fClientSupplierName.getValue());
        sbClient.getSuggestBox().setValue(getProject().fClientSupplierName.getValue());

        created.setText(DateTimeFormat.getShortDateFormat().format(getProject().getCreated()));
        if (getProject().fLastBilled != null && getProject().fLastBilled.getValue() != null) {
            lastBilled.setText(DateTimeFormat.getShortDateFormat().format(getProject().fLastBilled.getValue()));
        }
        billableTime.setText(getProject().fBillableTime.getValueAsString());

        cbState.setValue(getProject().fState.getValue());
        name.setValue(getProject().fName.getValue());
        description.setValue(getProject().getDescription());
        totalTime.setText(getProject().fTotalBilledTime.getValueAsString());

    }

    @Override
    public void itemSelected(Suggestion pojo) {
        ClientSupplier clientSupplierC = (ClientSupplier) pojo;
        getProject().fClientSupplierID.setValue(clientSupplierC.getId());
        getProject().fClientSupplierName.setValue(clientSupplierC.fName.getValue());
    }

    public boolean saveValuesFromUi() {
        projectTasksDetailsTable.removeEmptyRows();
        projectStaffDetailsTable.removeEmptyRows();

        boolean ret = validator.validate();
        if (ret) {
            Project project = (Project) pojo;
            project.fName.setValue(name.getText());
            project.setDescription(description.getText());
            if (billableTime != null) {
                project.fBillableTime.setValue(Double.parseDouble(billableTime.getText()));
            }
            if (totalTime != null) {
                project.fTotalBilledTime.setValue(Double.parseDouble(totalTime.getText()));
            }
            project.fState.setValue(cbState.getValue());

            project.fBillingMethod.setValue(billingMethod.getValue());
            project.fFlatBillingRate.setValue(billingFlatRate.getAmount());
            project.fBillingRate.setValue(billingRate.getAmount());
            project.fCurrency.setValue(cbCurrency.getPojo());
            project.fTimeUnit.setValue(timeUnit.getValue());

            projectTasksDetailsTable.saveValuesFromUi();
            projectStaffDetailsTable.saveValuesFromUi();
        } else {
            errorsPanel.setVisible(true);
        }
        return ret;
    }

    public TextBox getName() {
        return name;
    }

    public TextBox getDescription() {
        return description;
    }

    public Label getLastBilled() {
        return lastBilled;
    }

    public Label getBillableTime() {
        return billableTime;
    }

    public ProjectTasksDetailsTable getProjectTasksDetailsTable() {
        return projectTasksDetailsTable;
    }

    public ProjectStaffDetailsTable getProjectStaffDetailsTable() {
        return projectStaffDetailsTable;
    }

    public Project getProject() {
        return (Project) pojo;
    }

    public NetNumeroButton getBtCancel() {
        return btCancel;
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    @Override
    protected void addValidators() {
        FocusAction focusAction = new FocusAction();

        validator.addValidators(Application.getConstants().client(),
                new NotEmptyValidator(sbClient.getSuggestBox().getTextBox(), true, "required").
                        addActionForFailure(focusAction).addActionForFailure(
                        new StyleAction("validation-failed")));

        validator.addValidators(Application.getConstants().name(),
                new NotEmptyValidator(name, true, "required").addActionForFailure(focusAction).
                        addActionForFailure(
                                new StyleAction("validation-failed")));
    }

    @Override
    protected ValidationMessages createValidationMessages() {
        return new ApplicationValidationMessages() {
            @Override
            public String getPropertyName(String propertyName) {
                if (propertyName.startsWith("Item")) {
                    return Application.getConstants().description();
                } else {
                    return propertyName;
                }
            }
        };
    }

    public CurrencySelect getCbCurrency() {
        return cbCurrency;
    }

    public BillingMethodComboBox getBillingMethod() {
        return billingMethod;
    }

    public NumberTextBox getBillingFlatRate() {
        return billingFlatRate;
    }

    public NumberTextBox getBillingRate() {
        return billingRate;
    }

    public TimeUnitComboBox getTimeUnit() {
        return timeUnit;
    }

    public TimeEntriesTable getTimeEntriesTable() {
        return timeEntriesTable;
    }

    public ProjectExpensesTable getExpensesTable() {
        return expensesTable;
    }

    public NetNumeroButton getBtGenerateInvoice() {
        return btGenerateInvoice;
    }

    public CustomFormatDateBox getFrom() {
        return from;
    }

    public CustomFormatDateBox getTo() {
        return to;
    }

    public void setTo(CustomFormatDateBox to) {
        this.to = to;
    }

    public NetNumeroButton getBtGenerateEstimate() {
        return btGenerateEstimate;
    }

    public Label getValuationLabel() {
        return valuationLabel;
    }

    public DisclosurePanel getTaskGroup() {
        return taskGroup;
    }

    public DisclosurePanel getStaffGroup() {
        return staffGroup;
    }

    public DisclosurePanel getHoursGroup() {
        return hoursGroup;
    }

    public DisclosurePanel getExpensesGroup() {
        return expensesGroup;
    }

    public NetNumeroButton getBtConvert() {
        return btConvert;
    }

    public void paint() {
        CoreUtils.debug("ProjectPanel.paint");

        BillingMethodEnum enumer = billingMethod.getValue();
        CoreUtils.debug("enumer = " + enumer.toString());

        billingFlatRateRow.setClassName("row-collapse");
        billingRateRow.setClassName("row-collapse");

        if (enumer == BillingMethodEnum.FLAT_AMOUNT) {
            billingFlatRateRow.setClassName("row-visible");
            taskGroup.setOpen(false);
            staffGroup.setOpen(false);
        }

        if (enumer == BillingMethodEnum.PROJECT_RATE) {
            billingRateRow.setClassName("row-visible");
            taskGroup.setOpen(false);
            staffGroup.setOpen(false);
        }

        if (enumer == BillingMethodEnum.STAFF_RATE) {
            taskGroup.setOpen(false);
            staffGroup.setOpen(true);
        }

        if (enumer == BillingMethodEnum.TASK_RATE) {
            taskGroup.setOpen(true);
            staffGroup.setOpen(false);
        }

        projectTasksDetailsTable.paint();
        projectStaffDetailsTable.paint();

    }


//    public CurrencyPanel getCurrencyPanel() {
//        return currencyPanel;
//    }
}
