package com.numhero.server.command;

import com.google.inject.Inject;
import com.numhero.client.model.datacargo.expense.ReceiptsListRequest;
import com.numhero.client.model.datacargo.expense.ReceiptsListResponse;
import com.numhero.client.model.pojoc.ExpenseReceipt;
import com.numhero.server.model.daolite.ExpenseReceiptDao;

import java.util.List;


public class CommandGetReceipts extends AbstractAuthenticatedCommand<ReceiptsListRequest, ReceiptsListResponse> {

    @Inject
    ExpenseReceiptDao expenseReceiptDao;

    @Override
    public ReceiptsListResponse execute(ReceiptsListRequest request) {
        ReceiptsListResponse response = new ReceiptsListResponse();
        response.setEntityList(getResults(request));
        return response;
    }

	private List<ExpenseReceipt> getResults(ReceiptsListRequest request) {

		return expenseReceiptDao.findReceipts(
                request.getBusinessAccountId(),
                request.getClientId(),
                request.getStaffId(),
                request.getFromDate(),
                request.getToDate(),
                request.getClientStatus(),
                request.getReceiptStaffStatus());
	}
}
