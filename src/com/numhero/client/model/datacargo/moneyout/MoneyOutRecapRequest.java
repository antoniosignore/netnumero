package com.numhero.client.model.datacargo.moneyout;

import com.numhero.shared.datacargo.ListCommandRequest;
import com.numhero.shared.service.ApplicationCommandEnum;

public class MoneyOutRecapRequest extends ListCommandRequest {

    public MoneyOutRecapRequest() {
        setCommand(ApplicationCommandEnum.CommandGetMoneyOutRecap);
    }
}
