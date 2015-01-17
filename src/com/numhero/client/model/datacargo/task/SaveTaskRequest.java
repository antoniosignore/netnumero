package com.numhero.client.model.datacargo.task;

import com.numhero.client.model.pojoc.Task;
import com.numhero.shared.datacargo.CommandRequest;
import com.numhero.shared.datacargo.SaveSingleEntityRequest;
import com.numhero.shared.service.ApplicationCommandEnum;

public class SaveTaskRequest extends SaveSingleEntityRequest {

    public SaveTaskRequest() {
        setCommand(ApplicationCommandEnum.CommandSaveTask);
    }

    public Task getTask() {
        return (Task) getEntity();
    }

    public void setTask(Task taskC) {
        setEntity(taskC);
    }

    @Override
    public CommandRequest[] getRemoveFromCacheOnSuccess() {
    	return new CommandRequest[] { new TaskListRequest() };
    }
}
