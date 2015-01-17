package com.numhero.client.model.datacargo.staff;

import com.numhero.client.model.pojoc.Staff;
import com.numhero.shared.datacargo.CommandRequest;
import com.numhero.shared.datacargo.SaveSingleEntityRequest;
import com.numhero.shared.service.ApplicationCommandEnum;

public class SaveStaffRequest extends SaveSingleEntityRequest {

    public SaveStaffRequest() {
        setCommand(ApplicationCommandEnum.CommandSaveStaff);
    }

    public Staff getStaff() {
        return (Staff) getEntity();
    }

    public void setStaff(Staff staff) {
        setEntity(staff);
    }

    @Override
    public CommandRequest[] getRemoveFromCacheOnSuccess() {
    	return new CommandRequest[] { new StaffListRequest() };
    }
}
