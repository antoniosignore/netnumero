package com.numhero.client.mvp.project;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SuggestOracle.Suggestion;
import com.google.gwt.user.client.ui.TextBox;
import com.numhero.client.Application;
import com.numhero.client.model.datacargo.businessaccount.SaveBusinessAccountRequest;
import com.numhero.client.model.datacargo.businessaccount.SaveBusinessAccountResponse;
import com.numhero.client.model.datacargo.task.SaveTaskRequest;
import com.numhero.client.model.datacargo.task.SaveTaskResponse;
import com.numhero.client.model.datacargo.task.TaskListRequest;
import com.numhero.client.model.datacargo.task.TaskListResponse;
import com.numhero.client.model.pojoc.Project;
import com.numhero.client.model.pojoc.ProjectTaskDetail;
import com.numhero.client.model.pojoc.Task;
import com.numhero.client.mvp.task.TaskPanel;
import com.numhero.client.mvp.task.TaskPanelDialog;
import com.numhero.client.mvp.task.TaskSelect;
import com.numhero.client.place.PlaceManager;
import com.numhero.client.service.Service;
import com.numhero.client.widget.combobox.CurrencySelect;
import com.numhero.client.widget.combobox.DropDownBox.DropDownBoxHandler;
import com.numhero.client.widget.combobox.TaskStatusComboBox;
import com.numhero.client.widget.combobox.TimeUnitComboBox;
import com.numhero.client.widget.table.FlexTableWithHeader;
import com.numhero.client.widget.table.TableDetailToolbar;
import com.numhero.client.widget.textbox.NumberTextBox;
import com.numhero.shared.datacargo.ListCommandRequest;
import com.numhero.shared.datacargo.ListCommandResponse;
import com.numhero.shared.enums.CurrencyEnum;
import eu.maydu.gwt.validation.client.ValidationProcessor;

import java.util.ArrayList;
import java.util.List;

public class ProjectTasksDetailsTable extends FlexTableWithHeader {

    private PlaceManager eventManager;
    public List<TaskLine> getLines() {
        return lines;
    }
    private List<TaskLine> lines;

    private Service<ListCommandRequest,ListCommandResponse<CurrencyEnum>> getCurrenciesService;

    private Service<SaveBusinessAccountRequest,SaveBusinessAccountResponse> businessAccountSaveService;

    private Service<TaskListRequest, TaskListResponse> getListService;
    private Service<SaveTaskRequest, SaveTaskResponse> saveService;

    private TaskPanel taskPanel;
    private Project project;
    private ValidationProcessor validator;

    public ProjectTasksDetailsTable(PlaceManager eventManager,
                                    Service<TaskListRequest, TaskListResponse> taskService,
                                    Service<SaveTaskRequest, SaveTaskResponse> taskSaveService,
                                    TaskPanel taskPanel, Service<ListCommandRequest, ListCommandResponse<CurrencyEnum>> getCurrenciesService, Service<SaveBusinessAccountRequest, SaveBusinessAccountResponse> businessAccountSaveService) {
        this.getCurrenciesService = getCurrenciesService;
        this.businessAccountSaveService = businessAccountSaveService;
        this.lines = new ArrayList<TaskLine>();
        this.getListService = taskService;
        this.saveService = taskSaveService;
        this.taskPanel = taskPanel;
        this.eventManager = eventManager;
        setStyleName("entity-details-table");
    }

    public void setProject(Project p) {
        this.project = p;

        if (project.fProjectTaskDetails.isEmpty()) {
            ProjectTaskDetail idc1 = new ProjectTaskDetail();
            idc1.fCurrency.setValue(project.fCurrency.getValue());
            project.fProjectTaskDetails.add(idc1);

            ProjectTaskDetail idc2 = new ProjectTaskDetail();
            idc2.fCurrency.setValue(project.fCurrency.getValue());
            project.fProjectTaskDetails.add(idc2);

            ProjectTaskDetail idc3 = new ProjectTaskDetail();
            idc3.fCurrency.setValue(project.fCurrency.getValue());
            project.fProjectTaskDetails.add(idc3);
        }

        lines.clear();
        for (ProjectTaskDetail idc : project.fProjectTaskDetails) {
            addLine(idc);
        }
        setHeader();
        setValues();
    }

    public void addLine(ProjectTaskDetail idc) {
        lines.add(new TaskLine(idc));
        eventManager.fireEvent(new ProjectValuationChangedEvent("added task to project"));
    }

    private void setHeader() {
        removeHeaderRow();
//        if (project.fBillingMethod.getValue() == BillingMethodEnum.TASK_RATE) {
        setHeader(0, Application.getConstants().item(), HasHorizontalAlignment.ALIGN_RIGHT, "140px");
        setHeader(1, Application.getConstants().description(), HasHorizontalAlignment.ALIGN_LEFT, "70px");
        setHeader(2, Application.getConstants().currency(), HasHorizontalAlignment.ALIGN_LEFT, "70px");
        setHeader(3, Application.getConstants().billingRate(), HasHorizontalAlignment.ALIGN_LEFT, "70px");
        setHeader(4, Application.getConstants().timeUnit(), HasHorizontalAlignment.ALIGN_LEFT, "70px");
        setHeader(5, Application.getConstants().hoursNotBilled(), HasHorizontalAlignment.ALIGN_LEFT, "70px");
        setHeader(6, Application.getConstants().valueToBill(), HasHorizontalAlignment.ALIGN_LEFT, "70px");
        setHeader(7, Application.getConstants().billable(), HasHorizontalAlignment.ALIGN_LEFT, "70px");
        setHeader(8, Application.getConstants().status(), HasHorizontalAlignment.ALIGN_LEFT, "70px");
        setHeader(9, "", HasHorizontalAlignment.ALIGN_RIGHT, "52px", "invoiceDetailsToolbar");
//        } else {
//            setHeader(0, Application.getConstants().item(), HasHorizontalAlignment.ALIGN_RIGHT, "140px");
//            setHeader(1, Application.getConstants().description(), HasHorizontalAlignment.ALIGN_LEFT, "70px");
//            setHeader(2, Application.getConstants().status(), HasHorizontalAlignment.ALIGN_LEFT, "70px");
//            setHeader(3, "", HasHorizontalAlignment.ALIGN_RIGHT, "52px", "invoiceDetailsToolbar");
//        }
    }

    public void setValues() {
        removeAllRows();
//        if (project.fBillingMethod.getValue() == BillingMethodEnum.TASK_RATE) {
        for (int row = 0; row < lines.size(); row++) {
            TaskLine idline = lines.get(row);
            setWidget(row, 0, idline.suggestBoxTask);
            setWidget(row, 1, idline.txDescription);
            setWidget(row, 2, idline.currency);
            setWidget(row, 3, idline.billingRate);
            setWidget(row, 4, idline.timeUnit);
            setWidget(row, 5, idline.notBilledHours);
            setWidget(row, 6, idline.valueToBill);
            setWidget(row, 7, idline.billable);
            setWidget(row, 8, idline.status);
            setWidget(row, 9, idline.toolbar);
            for (int i = 0; i < 10; i++) {
                getCellFormatter().setStyleName(row, i, NETNUMERO_ROW);
            }
        }
//        } else {
//            for (int row = 0; row < lines.size(); row++) {
//                TaskLine idline = lines.get(row);
//                setWidget(row, 0, idline.suggestBoxTask);
//                setWidget(row, 1, idline.txDescription);
//                setWidget(row, 2, idline.status);
//                setWidget(row, 3, idline.toolbar);
//                for (int i = 0; i < 4; i++) {
//                    getCellFormatter().setStyleName(row, i, NETNUMERO_ROW);
//                }
//            }
//        }
    }

    public void removeEmptyRows() {
        for (int row = 0; row < lines.size(); row++) {
            TaskLine idline = lines.get(row);
            idline.remove();
        }
    }

    public void saveValuesFromUi() {
        project.fProjectTaskDetails.clear();
        for (int row = 0; row < lines.size(); row++) {
            TaskLine idline = lines.get(row);
            idline.saveValuesFromUi();
            project.fProjectTaskDetails.add(idline.projectTaskDetail);
        }
    }

    public void setValidator(ValidationProcessor validator) {
        this.validator = validator;
    }

    public void paint() {
        setHeader();
        setValues();
    }

    public Project getProject() {
        return project;
    }

    public class TaskLine implements DropDownBoxHandler {

        private ProjectTaskDetail projectTaskDetail;
        private TaskSelect suggestBoxTask;
        private TextBox txDescription;

        public CurrencySelect currency;
        public NumberTextBox billingRate;
        public TimeUnitComboBox timeUnit;
        public TaskStatusComboBox status;
        public Label billable;

        public NumberTextBox notBilledHours;
        public NumberTextBox valueToBill;

        TableDetailToolbar toolbar;

        TaskLine(ProjectTaskDetail idc) {
            projectTaskDetail = idc;

            suggestBoxTask = new TaskSelect(this, getListService, saveService, taskPanel);
            suggestBoxTask.setTask(projectTaskDetail.getId(), projectTaskDetail.fName.getValue());

            txDescription = new TextBox();
            txDescription.setValue(projectTaskDetail.getDescription());

            currency = new CurrencySelect(getCurrenciesService, businessAccountSaveService);
            currency.setPojo(projectTaskDetail.fCurrency.getValue());
            currency.setWidth("80px");
            currency.setHandler(new DropDownBoxHandler() {
                @Override
                public void itemSelected(Suggestion pojo) {
                    CurrencyEnum currency = (CurrencyEnum) pojo;
                    billingRate.setCurrency(currency);
                    valueToBill.setCurrency(currency);
                    eventManager.fireEvent(new ProjectValuationChangedEvent("task currency change"));
                }
            });

            billingRate = new NumberTextBox(projectTaskDetail.fCurrency.getValue()) {
                public void stopEdit() {
                    super.stopEdit();
                    eventManager.fireEvent(new ProjectValuationChangedEvent("task amount change"));
                }
            };
            billingRate.setAmount(projectTaskDetail.fBillingRate.getValue());

            notBilledHours = new NumberTextBox();
            notBilledHours.setAmount(0);
            notBilledHours.setReadOnly(true);

            valueToBill = new NumberTextBox(projectTaskDetail.fCurrency.getValue());
            valueToBill.setAmount(0);
            valueToBill.setReadOnly(true);

            timeUnit = new TimeUnitComboBox();
            timeUnit.setValue(projectTaskDetail.fTimeUnit.getValue());
            timeUnit.setWidth("110px");
            timeUnit.addChangeHandler(new ChangeHandler() {
                @Override
                public void onChange(ChangeEvent changeEvent) {
                    eventManager.fireEvent(new ProjectValuationChangedEvent("task timeunit change"));
                }
            });

            status = new TaskStatusComboBox();
            status.setValue(projectTaskDetail.fStatus.getValue());
            status.setWidth("90px");
            status.addChangeHandler(new ChangeHandler() {
                @Override
                public void onChange(ChangeEvent changeEvent) {
                    eventManager.fireEvent(new ProjectValuationChangedEvent("task status change"));
                }
            });

            billable = new Label();
            billable.setVisible(projectTaskDetail.fBillable.getValue());

            toolbar = new TableDetailToolbar();
            toolbar.getBtDelete().addClickHandler(new ClickHandler() {
                @Override
                public void onClick(ClickEvent event) {
                    destroy();
                }
            });
            toolbar.getBtMoveUp().addClickHandler(new ClickHandler() {
                @Override
                public void onClick(ClickEvent event) {
                    moveUp();
                }
            });
            toolbar.getBtMoveDown().addClickHandler(new ClickHandler() {
                @Override
                public void onClick(ClickEvent event) {
                    moveDown();
                }
            });

            addValidators();
            setLineValues();
        }

        void setLineValues() {
            txDescription.setText(projectTaskDetail.getDescription());
            currency.setPojo(projectTaskDetail.fCurrency.getValue());
            billingRate.setAmount(projectTaskDetail.fBillingRate.getValue());
            timeUnit.setValue(projectTaskDetail.fTimeUnit.getValue());
            status.setValue(projectTaskDetail.fStatus.getValue());
            billable.setText(projectTaskDetail.fBillable.getValueAsString());
//            placeManager.fireEvent(new ProjectValuationChangedEvent());
        }

        int getRow() {
            return lines.indexOf(TaskLine.this);
        }

        void moveUp() {
            int row = getRow();
            if (row > 0) {
                lines.set(row, lines.get(row - 1));
                lines.set(row - 1, TaskLine.this);
                setValues();
            }
        }

        void moveDown() {
            int row = getRow();
            if (row < lines.size() - 1) {
                lines.set(row, lines.get(row + 1));
                lines.set(row + 1, TaskLine.this);
                setValues();
            }
        }

        void destroy() {
            validator.removeValidators("Item" + this);
            removeRow(getRow());
            lines.remove(TaskLine.this);
            eventManager.fireEvent(new ProjectValuationChangedEvent("removed task from project"));
        }

        public void saveValuesFromUi() {
            projectTaskDetail.setDescription(txDescription.getText());
            projectTaskDetail.fBillingRate.setValue(billingRate.getAmount());
            projectTaskDetail.fCurrency.setValue(currency.getPojo());
            projectTaskDetail.fTimeUnit.setValue(timeUnit.getValue());
            projectTaskDetail.fStatus.setValue(status.getValue());
            projectTaskDetail.fBillable.setValue(Boolean.parseBoolean(billable.getText()));
        }

        @Override
        public void itemSelected(Suggestion pojo) {
            Task taskC = (Task) pojo;
            projectTaskDetail.fName.setValue(taskC.fName.getValue());
            projectTaskDetail.setDescription(taskC.getDescription());
            projectTaskDetail.fBillingRate.setValue(taskC.fBillingRate.getValue());
            projectTaskDetail.fCurrency.setValue(taskC.fCurrency.getValue());
            projectTaskDetail.fTimeUnit.setValue(taskC.fTimeUnit.getValue());
            projectTaskDetail.fBillable.setValue(taskC.fBillable.getValue());
            valuesChanged();
        }

        void valuesChanged() {
            setLineValues();
        }

        private void addValidators() {
        }

        public TaskSelect getSuggestBoxTask() {
            return suggestBoxTask;
        }

        void edit() {
            validator.removeValidators("Item" + this);
            Task task = this.getSuggestBoxTask().getPojo();
            final TaskPanelDialog dlg = new TaskPanelDialog(saveService, taskPanel, task);
            dlg.center();
        }

        void remove() {
            if (this.getSuggestBoxTask().getSuggestBox().getText() == null || this.getSuggestBoxTask().getSuggestBox().getText().length() == 0) {
                destroy();
            }
        }
    }
}
