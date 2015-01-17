package com.numhero.server.command;

import com.google.inject.Inject;
import com.numhero.client.model.datacargo.staff.GetStaffRequest;
import com.numhero.client.model.datacargo.staff.GetStaffResponse;
import com.numhero.client.model.pojoc.ExpenseReceipt;
import com.numhero.client.model.pojoc.Staff;
import com.numhero.server.model.daolite.ExpenseReceiptDao;
import com.numhero.server.model.daolite.StaffDao;
import com.numhero.shared.enums.ReceiptStatusEnum;

import java.util.List;

public class CommandGetStaffMember extends AbstractAuthenticatedCommand<GetStaffRequest, GetStaffResponse> {

    @Inject
    StaffDao staffDao;

    @Inject
    ExpenseReceiptDao expenseReceiptDao;

    @Override
    public GetStaffResponse execute(GetStaffRequest request) throws Exception {
        GetStaffResponse response = new GetStaffResponse();
        Staff staff = staffDao.get(request.getEntityId());

        List<ExpenseReceipt> receipts =
                expenseReceiptDao.findReceipts(request.getBusinessAccountId(),
                        null,staff.getId(),null, null, null, ReceiptStatusEnum.Presented);

        response.setRemboursableExpenses(receipts);
        response.setEntity(staff);
        return response;
    }
}
