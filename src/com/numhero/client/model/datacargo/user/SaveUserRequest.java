package com.numhero.client.model.datacargo.user;

import com.numhero.client.model.pojoc.User;
import com.numhero.shared.datacargo.SaveSingleEntityRequest;
import com.numhero.shared.service.ApplicationCommandEnum;

public class SaveUserRequest extends SaveSingleEntityRequest {

    public SaveUserRequest() {
        setCommand(ApplicationCommandEnum.CommandSaveUser);
    }

    public User getUser() {
        return (User) getEntity();
    }

    public void setUser(User user) {
        setEntity(user);
    }

}
