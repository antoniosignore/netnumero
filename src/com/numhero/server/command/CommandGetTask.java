package com.numhero.server.command;

import com.google.inject.Inject;
import com.numhero.client.model.datacargo.task.GetTaskRequest;
import com.numhero.client.model.datacargo.task.GetTaskResponse;
import com.numhero.client.model.pojoc.Task;
import com.numhero.server.model.daolite.TaskDao;

public class CommandGetTask extends AbstractAuthenticatedCommand<GetTaskRequest, GetTaskResponse> {

    @Inject
    TaskDao taskDao;

    @Override
    public GetTaskResponse execute(GetTaskRequest request) throws Exception {
        GetTaskResponse response = new GetTaskResponse();
        Task task = taskDao.get(request.getEntityId());
        response.setEntity(task);
        return response;
    }
}
