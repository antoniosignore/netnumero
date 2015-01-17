package com.numhero.server.command;

import com.google.inject.Inject;
import com.numhero.client.model.datacargo.staff.SaveStaffRequest;
import com.numhero.client.model.datacargo.staff.SaveStaffResponse;
import com.numhero.client.model.pojoc.Staff;
import com.numhero.server.model.daolite.StaffDao;
import com.numhero.server.utils.DaoUtils;
import com.numhero.shared.exception.ClientWarningException;

import java.util.logging.Logger;

public class CommandSaveStaff extends AbstractAuthenticatedCommand<SaveStaffRequest, SaveStaffResponse> {
    @SuppressWarnings("unused")
    private static final Logger log = Logger.getLogger(CommandSaveStaff.class.getName());

    @Inject
    StaffDao staffDao;

    @Override
    public SaveStaffResponse execute(SaveStaffRequest request) {

        Staff staff = request.getStaff();
        DaoUtils.setData(request, staff);

        validate(request.getBusinessAccountId(), staff);

        staffDao.save(staff);

        SaveStaffResponse response = new SaveStaffResponse();
        response.setEntityId(staff.getId());
        return response;
    }


    private void validate(String ba, Staff staff) {
        Staff csWithSameName = staffDao.findByName(ba, staff.fName.getValue());
        if (csWithSameName != null && !csWithSameName.fId.getValue().equals(staff.fId.getValue())) {
            throw new ClientWarningException("staffExists");
        }
    }
}
