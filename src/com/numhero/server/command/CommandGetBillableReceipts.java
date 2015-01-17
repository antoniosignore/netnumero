package com.numhero.server.command;

import com.google.inject.Inject;
import com.numhero.client.model.datacargo.expense.ReceiptsBillingListRequest;
import com.numhero.client.model.datacargo.expense.ReceiptsListResponse;
import com.numhero.client.model.pojoc.ExpenseReceipt;
import com.numhero.server.model.daolite.ExpenseReceiptDao;
import com.numhero.shared.enums.InvoiceStatusEnum;

import java.util.List;
import java.util.logging.Logger;

public class CommandGetBillableReceipts extends AbstractAuthenticatedCommand<ReceiptsBillingListRequest, ReceiptsListResponse> {

    @SuppressWarnings("unused")
    private static final Logger log = Logger.getLogger(CommandGetBillableReceipts.class.getName());

    @Inject
    ExpenseReceiptDao dao;

    @Override
    public ReceiptsListResponse execute(ReceiptsBillingListRequest request) {
        ReceiptsListResponse response = new ReceiptsListResponse();

        response.setEntityList(getList(request));

        return response;
    }

	private List<ExpenseReceipt> getList(ReceiptsBillingListRequest req) {
		return dao.findReceipts(
                req.getBusinessAccountId(),
                req.getClientId(),
                null,
                req.getFromDate(),
                req.getToDate(),
                InvoiceStatusEnum.Unbilled,
                null);
	}

}
