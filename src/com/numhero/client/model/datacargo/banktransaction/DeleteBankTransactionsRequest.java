package com.numhero.client.model.datacargo.banktransaction;


import com.numhero.shared.datacargo.BulkActionRequest;
import com.numhero.shared.service.ApplicationCommandEnum;

public class DeleteBankTransactionsRequest extends BulkActionRequest {

	public DeleteBankTransactionsRequest() {
		setCommand(ApplicationCommandEnum.CommandDeleteBankTransactions);
	}

}