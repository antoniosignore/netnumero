package com.numhero.client.model.datacargo.account;

import com.numhero.shared.datacargo.ListCommandRequest;
import com.numhero.shared.service.ApplicationCommandEnum;

public class ExpenseAccountListRequest extends ListCommandRequest {

    public ExpenseAccountListRequest() {
        setCommand(ApplicationCommandEnum.CommandGetExpenseAccounts);
    }
}