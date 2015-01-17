package com.numhero.server.command;

import com.google.inject.Inject;
import com.numhero.client.model.datacargo.staff.StaffListRequest;
import com.numhero.client.model.datacargo.staff.StaffListResponse;
import com.numhero.client.model.pojoc.Staff;
import com.numhero.server.model.daolite.StaffDao;
import com.numhero.shared.datacargo.ListCommandRequest;
import com.numhero.shared.datacargo.PaginatedList;

public class CommandGetStaffMembers extends AbstractGetPaginatedCommand<StaffListRequest, StaffListResponse> {

    @Inject
    StaffDao staffDao;

    @Override
    public StaffListResponse execute(StaffListRequest request) {
        StaffListResponse response = new StaffListResponse();
        if (request.getType() == ListCommandRequest.TYPE.SUGGEST) {
            if (request.getStartingKey().equals("*")) {
                response.setEntityList(staffDao.findAll(
                        request.getBusinessAccountId(),
                        request.getMaxResults()));
                return response;
            } else {
                response.setEntityList(staffDao.searchForStartsWith(
                        request.getStartingKey(),
                        request.getMaxResults(),
                        request.getBusinessAccountId()));
                return response;
            }
        } else if (request.getType() == ListCommandRequest.TYPE.SEARCH) {
            response.setEntityList(staffDao.search(
                    request.getStartingKey(),
                    request.getBusinessAccountId()));
            return response;
        } else if (request.getStaffType() != null) {
            response.setEntityList(staffDao.findAllByType(
                    request.getBusinessAccountId(),
                    request.getMaxResults(),
                    request.getStaffType()));
            return response;
        } else {
            return getPaginatedResults(request);
        }

    }

    private PaginatedList<Staff> getPaginated(StaffListRequest request) {

        return staffDao.findAllPaginated(request.getBusinessAccountId(), request.getMaxResults(), request.getRefObjectId(), request.getStaffType());
    }

    @Override
    protected StaffListResponse getPaginatedResults(StaffListRequest request) {
        StaffListResponse response = new StaffListResponse();
        response.setPaginatedList(getPaginated(request));
        return response;
    }
}
