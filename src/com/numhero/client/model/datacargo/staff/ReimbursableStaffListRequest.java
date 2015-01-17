package com.numhero.client.model.datacargo.staff;

import com.numhero.shared.datacargo.ListCommandRequest;
import com.numhero.shared.enums.StaffTypeEnum;
import com.numhero.shared.service.ApplicationCommandEnum;

public class ReimbursableStaffListRequest extends ListCommandRequest {

    private StaffTypeEnum staffType;

    public ReimbursableStaffListRequest() {
        setCommand(ApplicationCommandEnum.CommandGetReimbursableStaffMembers);
    }

    public StaffTypeEnum getStaffType() {
        return staffType;
    }

    public void setStaffType(StaffTypeEnum staffType) {
        this.staffType = staffType;
    }
}