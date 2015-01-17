package com.numhero.server.command;

import com.google.inject.Inject;
import com.numhero.client.model.datacargo.user.GetUserRequest;
import com.numhero.client.model.datacargo.user.GetUserResponse;
import com.numhero.client.model.pojoc.User;
import com.numhero.server.model.daolite.UserDao;

public class CommandGetUser extends AbstractAuthenticatedCommand<GetUserRequest, GetUserResponse> {
    @Inject
    UserDao userDao;

    @Override
    public GetUserResponse execute(GetUserRequest request) throws Exception {
        GetUserResponse response = new GetUserResponse();
        User user = userDao.get(request.getEntityId());
        response.setEntity(user);
        return response;
    }
}
