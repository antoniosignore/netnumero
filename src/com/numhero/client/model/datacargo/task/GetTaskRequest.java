package com.numhero.client.model.datacargo.task;

import com.numhero.shared.datacargo.GetSingleEntityRequest;
import com.numhero.shared.service.ApplicationCommandEnum;

public class GetTaskRequest extends GetSingleEntityRequest {

    public GetTaskRequest() {
        setCommand(ApplicationCommandEnum.CommandGetTask);
    }

}
