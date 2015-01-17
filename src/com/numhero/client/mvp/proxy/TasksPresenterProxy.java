package com.numhero.client.mvp.proxy;

import com.numhero.client.model.datacargo.task.DeleteTasksRequest;
import com.numhero.client.model.datacargo.task.TaskListRequest;
import com.numhero.client.model.datacargo.task.TaskListResponse;
import com.numhero.client.mvp.task.TasksPresenter;
import com.numhero.shared.datacargo.BulkActionResponse;

public class TasksPresenterProxy extends PresenterProxy<TasksPresenter> {
    @Override
    protected TasksPresenter createPresenter() {

        return new TasksPresenter(getEventManager(),
                PresenterProxy.<TaskListRequest, TaskListResponse>createNewService(),
                PresenterProxy.<DeleteTasksRequest, BulkActionResponse>createNewService(),
                getConstants());
    }
}
