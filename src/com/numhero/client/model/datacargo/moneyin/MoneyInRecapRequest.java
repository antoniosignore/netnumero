package com.numhero.client.model.datacargo.moneyin;

import com.numhero.shared.datacargo.ListCommandRequest;
import com.numhero.shared.service.ApplicationCommandEnum;

public class MoneyInRecapRequest extends ListCommandRequest {

    public MoneyInRecapRequest() {
        setCommand(ApplicationCommandEnum.CommandGetMoneyInRecap);
    }
}
