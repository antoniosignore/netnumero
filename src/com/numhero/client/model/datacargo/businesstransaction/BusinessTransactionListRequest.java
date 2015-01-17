package com.numhero.client.model.datacargo.businesstransaction;

import com.numhero.shared.datacargo.ListCommandRequest;
import com.numhero.shared.service.ApplicationCommandEnum;

public class BusinessTransactionListRequest extends ListCommandRequest {
    public BusinessTransactionListRequest() {
        setCommand(ApplicationCommandEnum.CommandGetBusinessTransactions);
    }
}
