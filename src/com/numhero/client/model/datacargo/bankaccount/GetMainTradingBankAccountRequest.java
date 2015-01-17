package com.numhero.client.model.datacargo.bankaccount;

import com.numhero.shared.datacargo.GetSingleEntityRequest;
import com.numhero.shared.service.ApplicationCommandEnum;

public class GetMainTradingBankAccountRequest extends GetSingleEntityRequest {

    public GetMainTradingBankAccountRequest() {
        setCommand(ApplicationCommandEnum.CommandGetMainTradingBankAccount);
    }

}
