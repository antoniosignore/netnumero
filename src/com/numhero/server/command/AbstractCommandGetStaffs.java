package com.numhero.server.command;

import com.google.inject.Inject;
import com.numhero.client.model.datacargo.staff.StaffListResponse;
import com.numhero.client.model.pojoc.Staff;
import com.numhero.server.model.daolite.StaffDao;
import com.numhero.server.model.daolite.filter.DSFilters;
import com.numhero.shared.datacargo.ListCommandRequest;
import com.numhero.shared.datacargo.ListCommandRequest.TYPE;
import com.numhero.shared.enums.StaffTypeEnum;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractCommandGetStaffs<REQUEST extends ListCommandRequest> extends AbstractAuthenticatedCommand<REQUEST, StaffListResponse> {

    @Inject
    StaffDao staffDao;

    protected StaffListResponse execute(REQUEST request, StaffTypeEnum type) {
        StaffListResponse response = new StaffListResponse();

        List<Staff> staffs = new ArrayList<Staff>();
        if (request.getType() == TYPE.SUGGEST) {
            if (request.getStartingKey().equals("*")) {
                staffs = staffDao.findAllByType(
                        request.getBusinessAccountId(),
                        request.getMaxResults(),
                        type);
            } else {
                staffs = staffDao.searchForStartsWith(
                        request.getStartingKey(),
                        request.getMaxResults(),
                        request.getBusinessAccountId(),
                        DSFilters.eq("type", type.name()));
            }
        } else if (request.getType() == TYPE.SEARCH) {
            staffDao.searchByType(staffs,
                    request.getStartingKey(),
                    request.getMaxResults(),
                    request.getBusinessAccountId(),
                    DSFilters.eq("staffType", type.name()));
        } else {
            staffs = staffDao.findAllByType(
                    request.getBusinessAccountId(),
                    0,
                    type);
        }
        for (Staff cs : staffs) {
            response.addItem(cs);
        }
        return response;
    }
}
