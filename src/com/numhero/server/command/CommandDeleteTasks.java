package com.numhero.server.command;

import com.google.inject.Inject;
import com.numhero.client.model.datacargo.task.DeleteTasksRequest;
import com.numhero.server.model.daolite.TaskDao;
import com.numhero.shared.datacargo.BulkActionResponse;

import java.util.List;

import static com.numhero.server.utils.BulkCommandUtils.deleteIdList;

public class CommandDeleteTasks extends AbstractAuthenticatedCommand<DeleteTasksRequest, BulkActionResponse> {

    @Inject
    TaskDao dao;

    @Override
    public BulkActionResponse execute(DeleteTasksRequest deleteTasksRequest) throws Exception {
        BulkActionResponse resp = new BulkActionResponse();
        List<Long> ids = deleteTasksRequest.getEntityIdList();
        deleteIdList(resp, ids, dao);
        return resp;
    }
}
