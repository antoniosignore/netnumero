package com.numhero.server.command;

import com.google.inject.Inject;
import com.numhero.client.model.datacargo.expense.ReceiptsListResponse;
import com.numhero.client.model.datacargo.expense.UnpaidReceiptsListRequest;
import com.numhero.client.model.pojoc.ExpenseReceipt;
import com.numhero.server.model.daolite.ExpenseReceiptDao;
import com.numhero.shared.enums.InvoiceStatusEnum;
import com.numhero.shared.enums.ReceiptStatusEnum;

import java.util.Date;
import java.util.List;


public class CommandGetUnpaidReceipts extends AbstractAuthenticatedCommand<UnpaidReceiptsListRequest, ReceiptsListResponse> {

    @Inject
    ExpenseReceiptDao expenseReceiptDao;

    @Override
    public ReceiptsListResponse execute(UnpaidReceiptsListRequest request) {
        ReceiptsListResponse response = new ReceiptsListResponse();

        List<ExpenseReceipt> expenseReceipts;

		Date from = request.getFromDate();
		Date to = request.getToDate();
		Long clientId = request.getClientId();

		//TODO different request
		expenseReceipts =  expenseReceiptDao.findReceipts(
				request.getBusinessAccountId(), clientId, null, from, to, InvoiceStatusEnum.Billed, ReceiptStatusEnum.Presented);

        response.setEntityList(expenseReceipts);

        return response;
    }



}
