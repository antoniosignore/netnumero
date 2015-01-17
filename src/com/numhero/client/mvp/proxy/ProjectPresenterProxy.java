package com.numhero.client.mvp.proxy;

import com.numhero.client.model.datacargo.businessaccount.SaveBusinessAccountRequest;
import com.numhero.client.model.datacargo.businessaccount.SaveBusinessAccountResponse;
import com.numhero.client.model.datacargo.client_supplier.ClientListRequest;
import com.numhero.client.model.datacargo.client_supplier.ClientSupplierListResponse;
import com.numhero.client.model.datacargo.client_supplier.SaveClientSupplierRequest;
import com.numhero.client.model.datacargo.currency.GetCurrencyConversionRequest;
import com.numhero.client.model.datacargo.currency.GetCurrencyConversionResponse;
import com.numhero.client.model.datacargo.expense.ReceiptsBilledStatusRequest;
import com.numhero.client.model.datacargo.expense.ReceiptsBillingListRequest;
import com.numhero.client.model.datacargo.expense.ReceiptsListResponse;
import com.numhero.client.model.datacargo.project.*;
import com.numhero.client.model.datacargo.staff.SaveStaffRequest;
import com.numhero.client.model.datacargo.staff.SaveStaffResponse;
import com.numhero.client.model.datacargo.staff.StaffListRequest;
import com.numhero.client.model.datacargo.staff.StaffListResponse;
import com.numhero.client.model.datacargo.task.SaveTaskRequest;
import com.numhero.client.model.datacargo.task.SaveTaskResponse;
import com.numhero.client.model.datacargo.task.TaskListRequest;
import com.numhero.client.model.datacargo.task.TaskListResponse;
import com.numhero.client.model.datacargo.timeentry.TimeEntriesBilledStatusRequest;
import com.numhero.client.model.datacargo.timeentry.TimeEntryBillingListRequest;
import com.numhero.client.model.datacargo.timeentry.TimeEntryListResponse;
import com.numhero.client.mvp.project.ProjectPanel;
import com.numhero.client.mvp.project.ProjectPresenter;
import com.numhero.client.mvp.project.ProjectStaffDetailsTable;
import com.numhero.client.mvp.project.ProjectTasksDetailsTable;
import com.numhero.client.mvp.staff.StaffPanel;
import com.numhero.client.mvp.task.TaskPanel;
import com.numhero.shared.datacargo.BulkActionResponse;
import com.numhero.shared.datacargo.ListCommandRequest;
import com.numhero.shared.datacargo.ListCommandResponse;
import com.numhero.shared.datacargo.SaveSingleEntityResponse;
import com.numhero.shared.enums.CurrencyEnum;

public class ProjectPresenterProxy extends PresenterProxy<ProjectPresenter> {
    @Override
    protected ProjectPresenter createPresenter() {

        TaskPanel taskPanel = new TaskPanel();
        ProjectTasksDetailsTable tasksTable = new ProjectTasksDetailsTable(
                getEventManager(),
                PresenterProxy.<TaskListRequest, TaskListResponse>createNewService(),
                PresenterProxy.<SaveTaskRequest, SaveTaskResponse>createNewService(),
                taskPanel,
                PresenterProxy.<ListCommandRequest, ListCommandResponse<CurrencyEnum>>createNewService(),
                PresenterProxy.<SaveBusinessAccountRequest, SaveBusinessAccountResponse>createNewService()
        );

        StaffPanel staffPanel = new StaffPanel();
        ProjectStaffDetailsTable staffTable = new ProjectStaffDetailsTable(getEventManager(),
                PresenterProxy.<StaffListRequest, StaffListResponse>createNewService(),
                PresenterProxy.<SaveStaffRequest, SaveStaffResponse>createNewService(),
                PresenterProxy.<ListCommandRequest, ListCommandResponse<CurrencyEnum>>createNewService(),
                PresenterProxy.<SaveBusinessAccountRequest, SaveBusinessAccountResponse>createNewService(),
                staffPanel);

        ProjectPanel panel = new ProjectPanel(PresenterProxy.<ClientListRequest, ClientSupplierListResponse>createNewService(),
                PresenterProxy.<SaveClientSupplierRequest, SaveSingleEntityResponse>createNewService(),
                tasksTable, staffTable);

        return new ProjectPresenter(getEventManager(),
                PresenterProxy.<GetProjectRequest, GetProjectResponse>createNewService(),
                PresenterProxy.<SaveProjectRequest, SaveProjectResponse>createNewService(),
                PresenterProxy.<TimeEntryBillingListRequest, TimeEntryListResponse>createNewService(),
                PresenterProxy.<ReceiptsBillingListRequest, ReceiptsListResponse>createNewService(),
                panel,
                PresenterProxy.<ProjectGenerateInvoiceRequest, ProjectGenerateInvoiceResponse>createNewService(),
                PresenterProxy.<ClientListRequest, ClientSupplierListResponse>createNewService(),
                PresenterProxy.<SaveClientSupplierRequest, SaveSingleEntityResponse>createNewService(),
                PresenterProxy.<TimeEntriesBilledStatusRequest, BulkActionResponse>createNewService(),
                PresenterProxy.<ReceiptsBilledStatusRequest, BulkActionResponse>createNewService(),
                PresenterProxy.<GetCurrencyConversionRequest, GetCurrencyConversionResponse>createNewService(),
                getConstants());
    }
}
