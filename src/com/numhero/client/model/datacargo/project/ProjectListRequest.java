package com.numhero.client.model.datacargo.project;

import com.numhero.shared.datacargo.ListCommandRequest;
import com.numhero.shared.service.ApplicationCommandEnum;

public class ProjectListRequest extends ListCommandRequest {

    public ProjectListRequest() {
        setCommand(ApplicationCommandEnum.CommandGetProjects);
    }
}
