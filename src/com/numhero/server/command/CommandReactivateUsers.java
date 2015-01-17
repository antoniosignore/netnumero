package com.numhero.server.command;

import com.google.inject.Inject;
import com.numhero.client.model.datacargo.user.ReactivateUsersRequest;
import com.numhero.client.model.pojoc.User;
import com.numhero.server.model.daolite.UserDao;
import com.numhero.shared.datacargo.BulkActionResponse;
import com.numhero.shared.enums.UserStatusEnum;

import java.util.List;

public class CommandReactivateUsers extends AbstractAuthenticatedCommand<ReactivateUsersRequest, BulkActionResponse> {

    @Inject
    UserDao dao;

    @Override
    public BulkActionResponse execute(ReactivateUsersRequest reactivateUsersRequest) throws Exception {
        BulkActionResponse resp = new BulkActionResponse();
        List<Long> ids = reactivateUsersRequest.getEntityIdList();
        for (Long s : ids) {
            User user = dao.get(s);
            user.fUserStatus.setValue(UserStatusEnum.ACTIVE);
            dao.save(user);
            resp.getSuccessIdList().add(s);
        }
        resp.setSuccessIdList(resp.getSuccessIdList());
        resp.setFailureIdList(resp.getFailureIdList());
        resp.setMessage("OK");
        return resp;
    }
}