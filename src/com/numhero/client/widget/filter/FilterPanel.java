package com.numhero.client.widget.filter;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SuggestOracle.Suggestion;
import com.google.inject.Inject;
import com.numhero.client.model.datacargo.client_supplier.ClientListRequest;
import com.numhero.client.model.datacargo.client_supplier.ClientSupplierListResponse;
import com.numhero.client.model.datacargo.client_supplier.SaveClientSupplierRequest;
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
import com.numhero.client.model.pojoc.ClientSupplier;
import com.numhero.client.model.pojoc.Project;
import com.numhero.client.model.pojoc.Staff;
import com.numhero.client.model.pojoc.Task;
import com.numhero.client.mvp.clientsupplier.ClientSelect;
import com.numhero.client.mvp.project.ProjectPanel;
import com.numhero.client.mvp.project.ProjectSelect;
import com.numhero.client.mvp.staff.StaffPanel;
import com.numhero.client.mvp.staff.StaffSelect;
import com.numhero.client.mvp.task.TaskPanel;
import com.numhero.client.mvp.task.TaskSelect;
import com.numhero.client.service.Service;
import com.numhero.client.widget.CustomFormatDateBox;
import com.numhero.client.widget.NetNumeroButton;
import com.numhero.client.widget.combobox.DropDownBox;
import com.numhero.shared.datacargo.SaveSingleEntityResponse;

public class FilterPanel extends Composite implements DropDownBox.DropDownBoxHandler {

    interface ExpenseUiBinder extends UiBinder<HTMLPanel, FilterPanel> {
    }

    private static ExpenseUiBinder uiBinder = GWT.create(ExpenseUiBinder.class);

    @UiField
    CustomFormatDateBox from;

    @UiField
    CustomFormatDateBox to;

    @UiField
    NetNumeroButton btFilter;

    @UiField(provided = true)
    ClientSelect sbClient;

    @UiField(provided = true)
    StaffSelect sbStaff;

    @UiField(provided = true)
    ProjectSelect sbProject;

    @UiField(provided = true)
    TaskSelect sbTask;

    @UiField
    Label clientLabel;

    @UiField
    Label staffLabel;

    @UiField
    Label projectLabel;

    @UiField
    Label taskLabel;

    private ClientSupplier client = null;
    private Staff staff = null;
    private Project project = null;
    private Task task = null;

    @Inject
    public FilterPanel(final Service<ClientListRequest, ClientSupplierListResponse> clientSuppliersService,
                       final Service<SaveClientSupplierRequest, SaveSingleEntityResponse> clientSupplierSaveService,
                       Service<StaffListRequest, StaffListResponse> listStaffService,
                       Service<SaveStaffRequest, SaveStaffResponse> saveStaffService,
                       StaffPanel staffPanel,
                       Service<ProjectListRequest, ProjectListResponse> projectListService,
                       Service<SaveProjectRequest, SaveProjectResponse> projectSaveService,
                       Service<TaskListRequest, TaskListResponse> taskListService,
                       Service<SaveTaskRequest, SaveTaskResponse> taskSaveService,
                       ProjectPanel projectPanel,
                       TaskPanel taskPanel) {
        sbClient = new ClientSelect(this, clientSuppliersService, clientSupplierSaveService);
        sbStaff = new StaffSelect(this, listStaffService, saveStaffService, staffPanel);
        sbProject = new ProjectSelect(this, projectListService, projectSaveService, projectPanel);
        sbTask = new TaskSelect(this, taskListService, taskSaveService, taskPanel);

        initWidget(uiBinder.createAndBindUi(this));

        sbClient.setVisible(false);
        sbStaff.setVisible(false);
        sbProject.setVisible(false);
        sbTask.setVisible(false);

        clientLabel.setVisible(false);
        staffLabel.setVisible(false);
        projectLabel.setVisible(false);
        taskLabel.setVisible(false);
    }

    public CustomFormatDateBox getFrom() {
        return from;
    }

    public CustomFormatDateBox getTo() {
        return to;
    }

    public Label getStaffLabel() {
        return staffLabel;
    }

    public Label getProjectLabel() {
        return projectLabel;
    }

    public Label getTaskLabel() {
        return taskLabel;
    }

    public NetNumeroButton getBtFilter() {
        return btFilter;
    }

    public StaffSelect getSbStaff() {
        return sbStaff;
    }

    public ProjectSelect getSbProject() {
        return sbProject;
    }

    public TaskSelect getSbTask() {
        return sbTask;
    }

    public BAPojoFilter getFilter() {
        BAPojoFilter filter = new BAPojoFilter();
        if (from != null) filter.setFrom(from.getValue());
        if (to != null) filter.setTo(to.getValue());
        if (client != null) filter.putClientSupplier(client);
        if (staff != null) filter.setStaff(staff);
        if (project != null) filter.setProject(project);
        if (task != null) filter.setTask(task);
        return filter;
    }

    @Override
    public void itemSelected(Suggestion pojo) {
        if (pojo instanceof ClientSupplier)
            client = (ClientSupplier) pojo;
        else if (pojo instanceof Staff)
            staff = (Staff) pojo;
        else if (pojo instanceof Project)
            project = (Project) pojo;
        else if (pojo instanceof Task)
            task = (Task) pojo;
    }
}
