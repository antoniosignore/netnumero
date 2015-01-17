package com.numhero.client.mvp.proxy;

import com.numhero.client.model.datacargo.user.GetUserRequest;
import com.numhero.client.model.datacargo.user.GetUserResponse;
import com.numhero.client.model.datacargo.user.SaveUserRequest;
import com.numhero.client.model.datacargo.user.SaveUserResponse;
import com.numhero.client.mvp.users.UserPresenter;
import com.numhero.client.mvp.users.UserView;

public class UserPresenterProxy extends PresenterProxy<UserPresenter> {
    @Override
    protected UserPresenter createPresenter() {

        UserView view = new UserView();
        return new UserPresenter(getEventManager(),
                PresenterProxy.<GetUserRequest, GetUserResponse>createNewService(),
                PresenterProxy.<SaveUserRequest, SaveUserResponse>createNewService(),
                view);
    }
}
