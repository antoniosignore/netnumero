package com.numhero.client.model.datacargo.user;

import com.numhero.shared.datacargo.GetSingleEntityRequest;
import com.numhero.shared.service.ApplicationCommandEnum;

public class GetUserRequest extends GetSingleEntityRequest {

    public GetUserRequest() {
        setCommand(ApplicationCommandEnum.CommandGetUser);
    }

}
