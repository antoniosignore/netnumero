package com.numhero.client.mvp.task;

import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Window;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.numhero.client.Application;
import com.numhero.client.model.datacargo.task.DeleteTasksRequest;
import com.numhero.client.model.datacargo.task.TaskListRequest;
import com.numhero.client.model.datacargo.task.TaskListResponse;
import com.numhero.client.mvp.CommandWrapper;
import com.numhero.client.mvp.GenericTimeTabViewPage;
import com.numhero.client.mvp.GridPresenter;
import com.numhero.client.place.PlaceManager;
import com.numhero.client.service.Service;
import com.numhero.client.service.ServiceCallbackImpl;
import com.numhero.client.util.ClientUtils;
import com.numhero.shared.datacargo.BulkActionResponse;

import java.util.List;

@Singleton
public class TasksPresenter extends GridPresenter {

    private Service<TaskListRequest, TaskListResponse> taskListService;
    private Service<DeleteTasksRequest, BulkActionResponse> deleteTasksService;

    @Inject
    public TasksPresenter(PlaceManager eventManager,
                          Service<TaskListRequest, TaskListResponse> taskListService,
                          Service<DeleteTasksRequest, BulkActionResponse> deleteTasksService, final TaskConstants constants) {
        super(eventManager, new GenericTimeTabViewPage(new TasksTable()));

        this.taskListService = taskListService;
        this.deleteTasksService = deleteTasksService;

        getView().setDetailTitlePanel(constants.manageTasks());

        CommandWrapper deleteTaskCommand = new CommandWrapper(constants.deleteTasks(),new Command() {
            public void execute() {
                deleteTasks(getView().getSelectedIds());
            }

        });

        getView().addActionsCommands(deleteTaskCommand);
    }

    private void deleteTasks(List<Long> ids) {
        if (ClientUtils.warnNotEmptyIds(ids, getView())) return;

        DeleteTasksRequest request = new DeleteTasksRequest();
        request.setEntityIdList(ids);
        deleteTasksService.execute(request, new ServiceCallbackImpl<BulkActionResponse>() {
            @Override
            public void onSuccess(BulkActionResponse response) {
                if (!response.getFailureIdList().isEmpty()) {
                    Window.alert(Application.getConstants().errorDeleting());
                } else {
                    Application.toasterMessage(Application.getConstants().itemsDeleted());
                }
                refreshFromServer();
            }
        });
    }

    protected void refreshFromServer() {
        TaskListRequest request = new TaskListRequest();

        setPagination(request);
        super.refreshFromServer();

        taskListService.execute(request, new ServiceCallbackImpl<TaskListResponse>() {
            @Override
            public void onSuccess(TaskListResponse response) {
//                ((TasksTable) getView().getContentPanel().getContentWidget()).setTasks(response.getEntityList());
//                getTable().manageNavigationBar(response.getEntityList().isEmpty(), response.isFirstPage(), response.isLastPage());
                getView().putEntitiesInGrid(response);

            }
        });
    }
}
