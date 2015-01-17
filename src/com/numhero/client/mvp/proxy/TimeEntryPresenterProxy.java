package com.numhero.client.mvp.proxy;

import com.numhero.client.model.datacargo.businessaccount.SaveBusinessAccountRequest;
import com.numhero.client.model.datacargo.businessaccount.SaveBusinessAccountResponse;
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
import com.numhero.client.model.datacargo.timeentry.*;
import com.numhero.client.mvp.project.ProjectPanel;
import com.numhero.client.mvp.project.ProjectStaffDetailsTable;
import com.numhero.client.mvp.project.ProjectTasksDetailsTable;
import com.numhero.client.mvp.staff.StaffPanel;
import com.numhero.client.mvp.task.TaskPanel;
import com.numhero.client.mvp.timeentry.TimeEntryPanel;
import com.numhero.client.mvp.timeentry.TimeEntryPresenter;
import com.numhero.client.service.Service;
import com.numhero.shared.datacargo.BulkActionResponse;
import com.numhero.shared.datacargo.ListCommandRequest;
import com.numhero.shared.datacargo.ListCommandResponse;
import com.numhero.shared.datacargo.SaveSingleEntityResponse;
import com.numhero.shared.enums.CurrencyEnum;

public class TimeEntryPresenterProxy extends PresenterProxy<TimeEntryPresenter> {
    @Override
    protected TimeEntryPresenter createPresenter() {

        TaskPanel taskPanel = new TaskPanel();
        Service<TaskListRequest,TaskListResponse> taskListService = PresenterProxy.<TaskListRequest, TaskListResponse>createNewService();
        Service<SaveTaskRequest, SaveTaskResponse> taskSaveService = PresenterProxy.<SaveTaskRequest, SaveTaskResponse>createNewService();
        Service<ListCommandRequest, ListCommandResponse<CurrencyEnum>> currenciesService =
                PresenterProxy.<ListCommandRequest, ListCommandResponse<CurrencyEnum>>createNewService();
        Service<SaveBusinessAccountRequest, SaveBusinessAccountResponse> businessAccountSaveService =
                PresenterProxy.<SaveBusinessAccountRequest, SaveBusinessAccountResponse>createNewService();
        ProjectTasksDetailsTable taskTable = new ProjectTasksDetailsTable(
                getEventManager(),
                taskListService,
                taskSaveService,
                taskPanel,
                currenciesService,
                businessAccountSaveService
        );
        StaffPanel staffPanel = new StaffPanel();
        Service<StaffListRequest, StaffListResponse> staffListService = PresenterProxy.<StaffListRequest, StaffListResponse>createNewService();
        Service<SaveStaffRequest, SaveStaffResponse> saveStaffService = PresenterProxy.<SaveStaffRequest, SaveStaffResponse>createNewService();
        ProjectStaffDetailsTable projetTable = new ProjectStaffDetailsTable(
                getEventManager(),
                staffListService,
                saveStaffService,
                currenciesService,
                businessAccountSaveService,
                staffPanel
        );
        ProjectPanel projectPanel = new ProjectPanel(
                PresenterProxy.<ClientListRequest, ClientSupplierListResponse>createNewService(),
                PresenterProxy.<SaveClientSupplierRequest, SaveSingleEntityResponse>createNewService(),
                taskTable,
                projetTable
        );
        TimeEntryPanel panel = new TimeEntryPanel(PresenterProxy.<ProjectListRequest, ProjectListResponse>createNewService(),
                PresenterProxy.<SaveProjectRequest, SaveProjectResponse>createNewService(),
                taskListService,
                taskSaveService,
                projectPanel,
                taskPanel,
                staffListService,
                saveStaffService,
                staffPanel);
        return new TimeEntryPresenter(getEventManager(),
                PresenterProxy.<GetTimeEntryRequest, GetTimeEntryResponse>createNewService(),
                PresenterProxy.<SaveTimeEntryRequest, SaveTimeEntryResponse>createNewService(),
                panel,
                PresenterProxy.<TimeEntryListRequest, TimeEntryListResponse>createNewService(),
                PresenterProxy.<DeleteTimeEntriesRequest, BulkActionResponse>createNewService(),
                getConstants());
    }
}
