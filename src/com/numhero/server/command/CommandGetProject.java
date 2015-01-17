package com.numhero.server.command;

import com.google.inject.Inject;
import com.numhero.client.model.datacargo.project.GetProjectRequest;
import com.numhero.client.model.datacargo.project.GetProjectResponse;
import com.numhero.client.model.pojoc.Project;
import com.numhero.server.model.daolite.ProjectDao;

public class CommandGetProject extends AbstractAuthenticatedCommand<GetProjectRequest, GetProjectResponse> {
    @Inject
    ProjectDao projectDao;

    @Override
    public GetProjectResponse execute(GetProjectRequest request) throws Exception {
        GetProjectResponse response = new GetProjectResponse();
        Project project = projectDao.get(request.getEntityId());
        response.setEntity(project);
        return response;
    }
}
