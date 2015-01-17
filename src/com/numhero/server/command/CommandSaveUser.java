package com.numhero.server.command;

import com.google.inject.Inject;
import com.numhero.client.model.datacargo.user.SaveUserRequest;
import com.numhero.client.model.datacargo.user.SaveUserResponse;
import com.numhero.client.model.pojoc.User;
import com.numhero.server.model.daolite.UserDao;
import com.numhero.server.utils.DaoUtils;

import java.util.logging.Logger;

public class CommandSaveUser extends AbstractAuthenticatedCommand<SaveUserRequest, SaveUserResponse> {
    @SuppressWarnings("unused")
    private static final Logger log = Logger.getLogger(CommandSaveUser.class.getName());

    @Inject
    UserDao userDao;

    @Override
    public SaveUserResponse execute(SaveUserRequest request) {
        log.fine("CommandSaveUser.execute");

        User user = (User) request.getEntity();
        DaoUtils.setData(request, user);
        userDao.save(user);

        SaveUserResponse response = new SaveUserResponse();
        response.setEntityId(user.getId());
        return response;
    }
}
