package com.numhero.server.command;

import com.google.inject.Inject;
import com.numhero.client.model.datacargo.staff.ReimbursableStaffListRequest;
import com.numhero.client.model.datacargo.staff.StaffListRequest;
import com.numhero.client.model.datacargo.staff.StaffListResponse;
import com.numhero.client.model.pojoc.ExpenseReceipt;
import com.numhero.client.model.pojoc.Staff;
import com.numhero.server.model.daolite.BaseDao;
import com.numhero.server.model.daolite.ExpenseReceiptDao;
import com.numhero.server.model.daolite.StaffDao;
import com.numhero.shared.datacargo.PaginatedList;
import com.numhero.shared.enums.ReceiptStatusEnum;

import java.util.Iterator;
import java.util.List;

public class CommandGetReimbursableStaffMembers extends AbstractAuthenticatedCommand<ReimbursableStaffListRequest, StaffListResponse> {

    @Inject
    StaffDao staffDao;

    @Inject
    ExpenseReceiptDao expenseReceiptDao;

    @Override
    public StaffListResponse execute(ReimbursableStaffListRequest request) {
        StaffListResponse response = new StaffListResponse();

        StaffListRequest r = new StaffListRequest();
        r.setBusinessAccountId(request.getBusinessAccountId());


        PaginatedList<Staff> allPaginated = staffDao.findAllPaginated(request.getBusinessAccountId(), BaseDao.MAX_RESULTS_FOR_PAGE, request.getRefObjectId(), request.getStaffType());
        List<Staff> staff = allPaginated.getList();
        for (Iterator<Staff> staffIterator = staff.iterator(); staffIterator.hasNext();) {
            Staff staff1 = staffIterator.next();
            if (hasReceipts(request.getBusinessAccountId(), staff1))
                response.getEntityList().add(staff1);
        }
        return response;
    }

    public boolean hasReceipts(String baId, Staff staff1) {
        List<ExpenseReceipt> receipts =
                expenseReceiptDao.findReceipts(baId, null,staff1.getId(),null, null, null,ReceiptStatusEnum.Presented);
        if (receipts !=null && receipts.size() > 0) return true;
        return false;
    }


}
