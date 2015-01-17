package com.numhero.client.model.datacargo.project;

import com.numhero.shared.datacargo.ListCommandRequest;
import com.numhero.shared.service.ApplicationCommandEnum;

public class StaffProjectsListRequest extends ListCommandRequest {

    String staffId;

    public StaffProjectsListRequest() {
        setCommand(ApplicationCommandEnum.CommandStaffProjectsListRequest);
    }

    public StaffProjectsListRequest(String staffId) {
        this();
        this.staffId = staffId;
    }

}
