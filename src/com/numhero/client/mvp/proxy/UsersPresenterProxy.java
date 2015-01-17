package com.numhero.client.mvp.proxy;

import com.numhero.client.model.datacargo.user.*;
import com.numhero.client.mvp.users.UsersPresenter;
import com.numhero.client.mvp.users.UsersView;
import com.numhero.client.service.Service;
import com.numhero.shared.datacargo.BulkActionResponse;

public class UsersPresenterProxy extends PresenterProxy<UsersPresenter> {
    @Override
    protected UsersPresenter createPresenter() {

        Service<ReactivateUsersRequest, BulkActionResponse> reactivateUsersService = createNewService();
        Service<UserListRequest, UserListResponse> userListService = createNewService();
        Service<DeleteUsersRequest, BulkActionResponse> deleteUserService = createNewService();
        Service<SuspendUsersRequest, BulkActionResponse> suspendUserService = createNewService();
        UsersView recenteUsersView = new UsersView();
        return new UsersPresenter(getEventManager(), userListService, recenteUsersView, deleteUserService, suspendUserService, reactivateUsersService);
    }
}
