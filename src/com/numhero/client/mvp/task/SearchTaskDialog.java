package com.numhero.client.mvp.task;

import com.numhero.client.Application;
import com.numhero.client.model.datacargo.task.TaskListRequest;
import com.numhero.client.model.datacargo.task.TaskListResponse;
import com.numhero.client.service.Service;
import com.numhero.client.widget.search.SearchPanel;
import com.numhero.client.widget.search.SearchPojoDialog;

public class SearchTaskDialog extends SearchPojoDialog {
    public SearchTaskDialog(Service<TaskListRequest, TaskListResponse> getListService, String search) {
        super(Application.getConstants().searchTasks(), search, getListService, new SearchPanel(new SearchTaskTable()), new TaskListRequest());
    }
}
