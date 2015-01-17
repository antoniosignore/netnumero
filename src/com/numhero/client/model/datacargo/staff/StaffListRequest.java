package com.numhero.client.model.datacargo.staff;

import com.numhero.shared.datacargo.ListCommandRequest;
import com.numhero.shared.enums.StaffTypeEnum;
import com.numhero.shared.service.ApplicationCommandEnum;

public class StaffListRequest extends ListCommandRequest {

    private StaffTypeEnum staffType;

    public StaffListRequest() {
        setCommand(ApplicationCommandEnum.CommandGetStaffMembers);
    }

    public StaffTypeEnum getStaffType() {
        return staffType;
    }

    public void setStaffType(StaffTypeEnum staffType) {
        this.staffType = staffType;
    }
}