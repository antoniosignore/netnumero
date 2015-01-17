package com.numhero.client.mvp.proxy;

import com.numhero.client.model.datacargo.task.GetTaskRequest;
import com.numhero.client.model.datacargo.task.GetTaskResponse;
import com.numhero.client.model.datacargo.task.SaveTaskRequest;
import com.numhero.client.model.datacargo.task.SaveTaskResponse;
import com.numhero.client.mvp.task.TaskPanel;
import com.numhero.client.mvp.task.TaskPresenter;

public class TaskPresenterProxy extends PresenterProxy<TaskPresenter> {
    @Override
    protected TaskPresenter createPresenter() {

        TaskPanel panel = new TaskPanel();
        return new TaskPresenter(getEventManager(),
                PresenterProxy.<GetTaskRequest, GetTaskResponse>createNewService(),
                PresenterProxy.<SaveTaskRequest, SaveTaskResponse>createNewService(),
                panel,
                getConstants());
    }
}
