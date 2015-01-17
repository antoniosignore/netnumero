package com.numhero.client.model.datacargo.project;

import com.numhero.shared.datacargo.GetSingleEntityRequest;
import com.numhero.shared.service.ApplicationCommandEnum;

public class GetProjectRequest extends GetSingleEntityRequest {

    public GetProjectRequest() {
        setCommand(ApplicationCommandEnum.CommandGetProject);
    }

}
