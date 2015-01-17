package com.numhero.client.model.datacargo.account;

import com.numhero.shared.datacargo.ListCommandRequest;
import com.numhero.shared.service.ApplicationCommandEnum;

public class AccountListRequest extends ListCommandRequest {

    public AccountListRequest() {
        setCommand(ApplicationCommandEnum.CommandGetAccounts);
    }
}
