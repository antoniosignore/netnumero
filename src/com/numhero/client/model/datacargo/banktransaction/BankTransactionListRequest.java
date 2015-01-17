package com.numhero.client.model.datacargo.banktransaction;

import com.numhero.shared.datacargo.ListCommandRequest;
import com.numhero.shared.service.ApplicationCommandEnum;

public class BankTransactionListRequest extends ListCommandRequest {

    public BankTransactionListRequest() {
        setCommand(ApplicationCommandEnum.CommandGetBankTransactions);
    }
}
