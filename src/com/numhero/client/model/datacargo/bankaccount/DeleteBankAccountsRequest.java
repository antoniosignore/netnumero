package com.numhero.client.model.datacargo.bankaccount;

import com.numhero.shared.datacargo.BulkActionRequest;
import com.numhero.shared.service.ApplicationCommandEnum;

public class DeleteBankAccountsRequest extends BulkActionRequest {

	public DeleteBankAccountsRequest() {
		setCommand(ApplicationCommandEnum.CommandDeleteBankAccounts);
	}

}