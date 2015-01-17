package com.numhero.server.command;

import com.google.inject.Inject;
import com.numhero.client.model.datacargo.task.TaskListRequest;
import com.numhero.client.model.datacargo.task.TaskListResponse;
import com.numhero.client.model.pojoc.Task;
import com.numhero.server.model.daolite.TaskDao;
import com.numhero.shared.datacargo.ListCommandRequest.TYPE;
import com.numhero.shared.datacargo.PaginatedList;

import java.util.logging.Logger;

public class CommandGetTasks extends AbstractGetPaginatedCommand<TaskListRequest, TaskListResponse> {

    @SuppressWarnings("unused")
    private static final Logger log = Logger.getLogger(CommandGetTasks.class.getName());

    @Inject
    TaskDao taskDao;

    @Override
    public TaskListResponse execute(TaskListRequest request) {
        TaskListResponse response = new TaskListResponse();

        if (request.getType() == TYPE.SUGGEST) {
            if (request.getStartingKey().equals("*")) {
                response.setEntityList(taskDao.findAllMaxResults(
                        request.getBusinessAccountId(),
                        request.getMaxResults()));
                return response;
            } else {
                response.setEntityList(taskDao.searchForStartsWith(
                        request.getStartingKey(),
                        request.getMaxResults(),
                        request.getBusinessAccountId()));
                return response;
            }
        } else if (request.getType() == TYPE.SEARCH) {
            response.setEntityList(taskDao.search(
                    request.getStartingKey(),
                    request.getBusinessAccountId()));
            return response;
        } else {
            return getPaginatedResults(request);
        }

    }

    private PaginatedList<Task> getPaginated(TaskListRequest request) {

        return taskDao.findAllPaginated(
                request.getBusinessAccountId(), request.getMaxResults(), request.getRefObjectId());
    }

    @Override
    protected TaskListResponse getPaginatedResults(TaskListRequest request) {
        TaskListResponse response = new TaskListResponse();
        response.setPaginatedList(getPaginated(request));
        return response;
    }
}
