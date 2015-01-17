package com.numhero.client.model.datacargo.bankaccount;

import com.numhero.shared.datacargo.ListCommandRequest;
import com.numhero.shared.service.ApplicationCommandEnum;

public class BankAccountListRequest extends ListCommandRequest {

    public BankAccountListRequest() {
        setCommand(ApplicationCommandEnum.CommandGetBankAccounts);
    }
}
