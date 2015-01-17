package com.numhero.client.model.datacargo.task;

import com.numhero.shared.datacargo.ListCommandRequest;
import com.numhero.shared.service.ApplicationCommandEnum;

public class ProjectTasksListRequest extends ListCommandRequest {

    String projectId;

    public ProjectTasksListRequest() {
        setCommand(ApplicationCommandEnum.CommandProjectTasksListRequest);
    }

    public ProjectTasksListRequest(String projectId) {
        this();
        this.projectId = projectId;
    }

}