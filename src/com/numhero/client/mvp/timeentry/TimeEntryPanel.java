package com.numhero.client.mvp.timeentry;

import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.DisclosurePanel;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.SuggestOracle.Suggestion;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.inject.Inject;
import com.numhero.client.Application;
import com.numhero.client.model.datacargo.project.ProjectListRequest;
import com.numhero.client.model.datacargo.project.ProjectListResponse;
import com.numhero.client.model.datacargo.project.SaveProjectRequest;
import com.numhero.client.model.datacargo.project.SaveProjectResponse;
import com.numhero.client.model.datacargo.staff.SaveStaffRequest;
import com.numhero.client.model.datacargo.staff.SaveStaffResponse;
import com.numhero.client.model.datacargo.staff.StaffListRequest;
import com.numhero.client.model.datacargo.staff.StaffListResponse;
import com.numhero.client.model.datacargo.task.SaveTaskRequest;
import com.numhero.client.model.datacargo.task.SaveTaskResponse;
import com.numhero.client.model.datacargo.task.TaskListRequest;
import com.numhero.client.model.datacargo.task.TaskListResponse;
import com.numhero.client.model.pojoc.Project;
import com.numhero.client.model.pojoc.Staff;
import com.numhero.client.model.pojoc.Task;
import com.numhero.client.model.pojoc.TimeEntry;
import com.numhero.client.mvp.AbstractEditEntityPanel;
import com.numhero.client.mvp.project.ProjectPanel;
import com.numhero.client.mvp.project.ProjectSelect;
import com.numhero.client.mvp.staff.StaffPanel;
import com.numhero.client.mvp.staff.StaffSelect;
import com.numhero.client.mvp.task.TaskPanel;
import com.numhero.client.mvp.task.TaskSelect;
import com.numhero.client.service.Service;
import com.numhero.client.widget.NetNumeroButton;
import com.numhero.client.widget.combobox.DropDownBox.DropDownBoxHandler;
import com.numhero.client.widget.textbox.NumberTextBox;
import com.numhero.shared.pojoc.EntityPojo;
import eu.maydu.gwt.validation.client.actions.FocusAction;
import eu.maydu.gwt.validation.client.actions.StyleAction;
import eu.maydu.gwt.validation.client.validators.numeric.DoubleValidator;
import eu.maydu.gwt.validation.client.validators.standard.NotEmptyValidator;

public class TimeEntryPanel extends AbstractEditEntityPanel implements DropDownBoxHandler {

    interface TimeEntryUiBinder extends UiBinder<HTMLPanel, TimeEntryPanel> {
    }

    private static TimeEntryUiBinder uiBinder = GWT.create(TimeEntryUiBinder.class);

    @UiField
    DisclosurePanel errorsPanel;

    @UiField
    TextBox notes;

    @UiField
    DateBox selectedDate;

    @UiField(provided = true)
    StaffSelect staffSelect;

    @UiField(provided = true)
    ProjectSelect sbProject;

    @UiField(provided = true)
    TaskSelect sbTask;

    @UiField
    NumberTextBox hours;

    @UiField
    NetNumeroButton btSave;

    @UiField
    NetNumeroButton btCancel;

//    @UiField
//    TimeEntriesTable timeEntriesTable;

    @Inject
    public TimeEntryPanel(
            Service<ProjectListRequest, ProjectListResponse> projectListService,
            Service<SaveProjectRequest, SaveProjectResponse> projectSaveService,
            Service<TaskListRequest, TaskListResponse> taskListService,
            Service<SaveTaskRequest, SaveTaskResponse> taskSaveService,
            ProjectPanel projectPanel,
            TaskPanel taskPanel,
            Service<StaffListRequest, StaffListResponse> listStaffService,
            Service<SaveStaffRequest, SaveStaffResponse> saveStaffService,
            StaffPanel staffPanel) {

        staffSelect = new StaffSelect(this, listStaffService, saveStaffService, staffPanel);
        sbProject = new ProjectSelect(this, projectListService, projectSaveService, projectPanel);
        sbTask = new TaskSelect(this, taskListService, taskSaveService, taskPanel);

        initWidget(uiBinder.createAndBindUi(this));
        selectedDate.setFormat(new DateBox.DefaultFormat(DateTimeFormat.getShortDateFormat()));
        createValidator(errorsPanel);
    }

    public TimeEntry getTimeEntry() {
        return (TimeEntry) pojo;
    }

    @Override
    public void itemSelected(Suggestion pojo) {
        if (pojo instanceof Project) {
            Project projectC = (Project) pojo;
            getTimeEntry().fProjectId.setValue(projectC.getId());
            getTimeEntry().fProjectName.setValue(projectC.fName.getValue());
        } else if (pojo instanceof Task) {
            Task taskC = (Task) pojo;
            getTimeEntry().fTaskId.setValue(taskC.getId());
            getTimeEntry().fTaskName.setValue(taskC.fName.getValue());
        } else if (pojo instanceof Staff) {
            Staff clientC = (Staff) pojo;
            getTimeEntry().fStaffId.setValue(clientC.getId());
            getTimeEntry().fStaffName.setValue(clientC.fName.getValue());
        }
    }

    public TextBox getNotes() {
        return notes;
    }

    public void setNotes(TextBox notes) {
        this.notes = notes;
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
            getTimeEntry().fNotes.setValue(getNotes().getValue());
            getTimeEntry().fStaffId.setValue(staffSelect.getPojo().getId());
            getTimeEntry().fStaffName.setValue(staffSelect.getPojo().fName.getValue());
            getTimeEntry().fProjectId.setValue(sbProject.getPojo().getId());
            getTimeEntry().fProjectName.setValue(sbProject.getPojo().fName.getValue());
            getTimeEntry().fTaskId.setValue(sbTask.getPojo().getId());
            getTimeEntry().fTaskName.setValue(sbTask.getPojo().fName.getValue());
            getTimeEntry().fHours.setValue(getHours().getAmount());
        } else {
            errorsPanel.setVisible(true);
        }
        return ret;
    }

    @Override
    public void setPojo(EntityPojo pojo) {
        super.setPojo(pojo);
        notes.setValue(getTimeEntry().fNotes.getValue());
        sbProject.setProject(getTimeEntry().fProjectId.getValue(), getTimeEntry().fProjectName.getValue());
        sbTask.setTask(getTimeEntry().fTaskId.getValue(), getTimeEntry().fTaskName.getValue());
        staffSelect.setStaff(getTimeEntry().fStaffId.getValue(), getTimeEntry().fStaffName.getValue());
        hours.setAmount(getTimeEntry().fHours.getValue());
    }

    protected DisclosurePanel getErrorsPanel() {
        return errorsPanel;
    }

    public ProjectSelect getSbProject() {
        return sbProject;
    }

    public void setSbProject(ProjectSelect sbProject) {
        this.sbProject = sbProject;
    }

    public StaffSelect getStaffSelect() {
        return staffSelect;
    }

    public void setStaffSelect(StaffSelect staffSelect) {
        this.staffSelect = staffSelect;
    }

    public TaskSelect getSbTask() {
        return sbTask;
    }

    public void setSbTask(TaskSelect sbTask) {
        this.sbTask = sbTask;
    }

    public NetNumeroButton getBtCancel() {
        return btCancel;
    }

    public void setBtCancel(NetNumeroButton btCancel) {
        this.btCancel = btCancel;
    }

    public DateBox getSelectedDate() {
        return selectedDate;
    }

    public void setSelectedDate(DateBox selectedDate) {
        this.selectedDate = selectedDate;
    }

    @Override
    protected void addValidators() {
        FocusAction focusAction = new FocusAction();

        validator.addValidators(Application.getConstants().staff(),
                new NotEmptyValidator(staffSelect.getSuggestBox().getTextBox(), true, "required").
                        addActionForFailure(focusAction).addActionForFailure(new StyleAction("validation-failed")));

        validator.addValidators(Application.getConstants().project(),
                new NotEmptyValidator(sbProject.getSuggestBox().getTextBox(), true, "required").
                        addActionForFailure(focusAction).
                        addActionForFailure(new StyleAction("validation-failed")));

        validator.addValidators(Application.getConstants().task(),
                new NotEmptyValidator(sbTask.getSuggestBox().getTextBox(), true, "required").
                        addActionForFailure(focusAction).
                        addActionForFailure(new StyleAction("validation-failed")));

        validator.addValidators(Application.getConstants().hoursNotInDailyRange(),
                new DoubleValidator(hours.getAmountBox(), 0, 24, true).
                        addActionForFailure(focusAction).
                        addActionForFailure(new StyleAction("validation-failed")));

    }

    //    public TimeEntriesTable getTimeEntriesTable() {
//        return timeEntriesTable;
//    }
//

    //    public void setTimeEntriesTable(TimeEntriesTable timeEntriesTable) {
//        this.timeEntriesTable = timeEntriesTable;
//    }
//
    public NumberTextBox getHours() {
        return hours;
    }

    public void setHours(NumberTextBox hours) {
        this.hours = hours;
    }

    public NetNumeroButton getBtSave() {
        return btSave;
    }

}
