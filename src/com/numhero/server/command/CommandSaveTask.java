package com.numhero.server.command;

import com.google.inject.Inject;
import com.numhero.client.model.datacargo.task.SaveTaskRequest;
import com.numhero.client.model.datacargo.task.SaveTaskResponse;
import com.numhero.client.model.pojoc.Task;
import com.numhero.server.model.daolite.TaskDao;
import com.numhero.server.utils.DaoUtils;

import java.util.logging.Logger;

public class CommandSaveTask extends AbstractAuthenticatedCommand<SaveTaskRequest, SaveTaskResponse> {
    @SuppressWarnings("unused")
    private static final Logger log = Logger.getLogger(CommandSaveTask.class.getName());

    @Inject
    TaskDao taskDao;

    @Override
    public SaveTaskResponse execute(SaveTaskRequest request) {

        Task task = (Task) request.getEntity();
        DaoUtils.setData(request, task);
        taskDao.save(task);


        SaveTaskResponse response = new SaveTaskResponse();
        response.setEntityId(task.getId());
        return response;
    }
}
