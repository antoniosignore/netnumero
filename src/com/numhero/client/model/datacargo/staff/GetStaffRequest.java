package com.numhero.client.model.datacargo.staff;

import com.numhero.shared.datacargo.GetSingleEntityRequest;
import com.numhero.shared.service.ApplicationCommandEnum;

public class GetStaffRequest extends GetSingleEntityRequest {

    public GetStaffRequest() {
        setCommand(ApplicationCommandEnum.CommandGetStaffMember);
    }

}
