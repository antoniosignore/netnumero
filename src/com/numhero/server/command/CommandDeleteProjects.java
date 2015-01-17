package com.numhero.server.command;

import com.google.inject.Inject;
import com.numhero.client.model.datacargo.project.DeleteProjectsRequest;
import com.numhero.server.model.daolite.ProjectDao;
import com.numhero.shared.datacargo.BulkActionResponse;

import java.util.List;

import static com.numhero.server.utils.BulkCommandUtils.deleteIdList;

public class CommandDeleteProjects extends AbstractAuthenticatedCommand<DeleteProjectsRequest, BulkActionResponse> {

    @Inject
    ProjectDao dao;

    @Override
    public BulkActionResponse execute(DeleteProjectsRequest deleteProjectsRequest) throws Exception {

        BulkActionResponse resp = new BulkActionResponse();
        List<Long> ids = deleteProjectsRequest.getEntityIdList();
        deleteIdList(resp, ids, dao);
        return resp;
    }
}
