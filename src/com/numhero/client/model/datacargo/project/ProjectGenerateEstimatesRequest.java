package com.numhero.client.model.datacargo.project;

import com.numhero.shared.datacargo.BulkActionRequest;
import com.numhero.shared.service.ApplicationCommandEnum;

public class ProjectGenerateEstimatesRequest extends BulkActionRequest {

    public ProjectGenerateEstimatesRequest() {
        setCommand(ApplicationCommandEnum.CommandProjectsRaiseEstimates);
    }

}