package com.numhero.server.command;

import com.google.inject.Inject;
import com.numhero.client.model.datacargo.project.SaveProjectRequest;
import com.numhero.client.model.datacargo.project.SaveProjectResponse;
import com.numhero.client.model.pojoc.Project;
import com.numhero.server.model.daolite.ProjectDao;
import com.numhero.server.utils.DaoUtils;

import java.util.logging.Logger;

public class CommandSaveProject extends AbstractAuthenticatedCommand<SaveProjectRequest, SaveProjectResponse> {

    @SuppressWarnings("unused")
    private static final Logger log = Logger.getLogger(CommandSaveProject.class.getName());

    @Inject
    ProjectDao projectDao;

    @Override
    public SaveProjectResponse execute(SaveProjectRequest request) {

        Project project = (Project) request.getEntity();
        DaoUtils.setData(request, project);
        projectDao.save(project);
        SaveProjectResponse response = new SaveProjectResponse();
        response.setEntityId(project.getId());
        return response;
    }
}
