package com.numhero.client.model.datacargo.task;

import com.numhero.shared.datacargo.ListCommandRequest;
import com.numhero.shared.service.ApplicationCommandEnum;

public class TaskListRequest extends ListCommandRequest {

    public TaskListRequest() {
        setCommand(ApplicationCommandEnum.CommandGetTasks);
    }
}
