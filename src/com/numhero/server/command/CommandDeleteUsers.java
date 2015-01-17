package com.numhero.server.command;

import com.google.inject.Inject;
import com.numhero.client.model.datacargo.user.DeleteUsersRequest;
import com.numhero.server.model.daolite.UserDao;
import com.numhero.shared.datacargo.BulkActionResponse;

import java.util.List;

import static com.numhero.server.utils.BulkCommandUtils.deleteIdList;

public class CommandDeleteUsers extends AbstractAuthenticatedCommand<DeleteUsersRequest, BulkActionResponse> {

    @Inject
    UserDao dao;

    @Override
    public BulkActionResponse execute(DeleteUsersRequest deleteUsersRequest) throws Exception {
        BulkActionResponse resp = new BulkActionResponse();
        List<Long> ids = deleteUsersRequest.getEntityIdList();
        deleteIdList(resp, ids, dao);
        return resp;
    }

}
