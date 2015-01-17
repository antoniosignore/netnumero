package com.numhero.server.command;

import com.google.inject.Inject;
import com.numhero.client.model.datacargo.user.SuspendUsersRequest;
import com.numhero.client.model.pojoc.User;
import com.numhero.server.model.daolite.UserDao;
import com.numhero.shared.datacargo.BulkActionResponse;
import com.numhero.shared.enums.UserStatusEnum;

import java.util.List;

public class CommandSuspendUsers extends AbstractAuthenticatedCommand<SuspendUsersRequest, BulkActionResponse> {

    @Inject
    UserDao dao;

    @Override
    public BulkActionResponse execute(SuspendUsersRequest suspendUsersRequest) throws Exception {
        BulkActionResponse resp = new BulkActionResponse();
        List<Long> ids = suspendUsersRequest.getEntityIdList();
        for (Long s : ids) {
            User user = dao.get(s);
            user.fUserStatus.setValue(UserStatusEnum.SUSPENDED);
            dao.save(user);
            resp.getSuccessIdList().add(s);
        }
        resp.setSuccessIdList(resp.getSuccessIdList());
        resp.setFailureIdList(resp.getFailureIdList());
        resp.setMessage("OK");
        return resp;
    }

}