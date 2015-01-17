package com.numhero.server.command;

import com.google.inject.Inject;
import com.numhero.client.model.datacargo.project.ProjectListRequest;
import com.numhero.client.model.datacargo.project.ProjectListResponse;
import com.numhero.client.model.pojoc.Project;
import com.numhero.server.model.daolite.ProjectDao;
import com.numhero.shared.datacargo.ListCommandRequest.TYPE;
import com.numhero.shared.datacargo.PaginatedList;

import java.util.logging.Logger;

public class CommandGetProjects extends AbstractGetPaginatedCommand<ProjectListRequest, ProjectListResponse> {

    @SuppressWarnings("unused")
    private static final Logger log = Logger.getLogger(CommandGetProjects.class.getName());

    @Inject
    ProjectDao projectDao;

    @Override
    public ProjectListResponse execute(ProjectListRequest request) {
        ProjectListResponse response = new ProjectListResponse();

        if (request.getType() == TYPE.SUGGEST) {
            if (request.getStartingKey().equals("*")) {
                response.setEntityList(projectDao.findAllMaxResults(
                        request.getBusinessAccountId(),
                        request.getMaxResults()));
                return response;
            } else {
                response.setEntityList(projectDao.searchForStartsWith(
                        request.getStartingKey(),
                        request.getMaxResults(),
                        request.getBusinessAccountId()));
                return response;
            }
        } else if (request.getType() == TYPE.SEARCH) {
            response.setEntityList(projectDao.search(request.getStartingKey(), request.getBusinessAccountId()));
            return response;

        } else {
            return getPaginatedResults(request);
        }


    }

    private PaginatedList<Project> getPaginated(ProjectListRequest request) {

        return projectDao.findAllPaginated(request.getBusinessAccountId(), request.getMaxResults(), request.getRefObjectId());
    }

    @Override
    protected ProjectListResponse getPaginatedResults(ProjectListRequest request) {
        ProjectListResponse response = new ProjectListResponse();
        response.setPaginatedList(getPaginated(request));
        return response;

    }
}
