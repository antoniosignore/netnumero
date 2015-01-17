package com.numhero.client.model.datacargo.user;

import com.numhero.shared.datacargo.ListCommandRequest;
import com.numhero.shared.service.ApplicationCommandEnum;

public class UserListRequest extends ListCommandRequest {

    public UserListRequest() {
        setCommand(ApplicationCommandEnum.CommandGetUsers);
    }
}