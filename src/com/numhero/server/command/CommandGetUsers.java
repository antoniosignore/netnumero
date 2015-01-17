package com.numhero.server.command;

import com.google.inject.Inject;
import com.numhero.client.model.datacargo.user.UserListRequest;
import com.numhero.client.model.datacargo.user.UserListResponse;
import com.numhero.client.model.pojoc.User;
import com.numhero.server.model.daolite.UserDao;
import com.numhero.shared.datacargo.ListCommandRequest.TYPE;
import com.numhero.shared.datacargo.PaginatedList;

import java.util.List;

public class CommandGetUsers extends AbstractGetPaginatedCommand<UserListRequest, UserListResponse> {
    @Inject
    UserDao userDao;

    @Override
    public UserListResponse execute(UserListRequest request) {
        UserListResponse response = new UserListResponse();

        List<User> users;
        if (request.getType() == TYPE.SUGGEST) {
            if ("*".equals(request.getStartingKey())) {
                users = userDao.findAllMaxResults(
                        request.getBusinessAccountId(),
                        request.getMaxResults());
                response.setEntityList(users);
                return response;
            } else {
                users = userDao.searchForStartsWith(
                        request.getStartingKey(),
                        request.getMaxResults(),
                        request.getBusinessAccountId());
                response.setEntityList(users);
                return response;
            }
        } else if (request.getType() == TYPE.SEARCH) {
            users = userDao.search(
                    request.getStartingKey(),
                    request.getBusinessAccountId());
            response.setEntityList(users);
            return response;
        } else {
            return getPaginatedResults(request);
        }

    }

    private PaginatedList<User> getPaginated(UserListRequest request) {

        return userDao.findAllPaginated(
                request.getBusinessAccountId(), request.getMaxResults(), request.getRefObjectId());
    }

    @Override
    protected UserListResponse getPaginatedResults(UserListRequest request) {
        UserListResponse response = new UserListResponse();
        response.setPaginatedList(getPaginated(request));
        return response;
    }
}
