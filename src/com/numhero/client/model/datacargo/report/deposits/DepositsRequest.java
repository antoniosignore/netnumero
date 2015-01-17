package com.numhero.client.model.datacargo.report.deposits;

import com.numhero.client.model.datacargo.report.chartofaccounts.AccountBalanceRequest;
import com.numhero.shared.service.ApplicationCommandEnum;

public class DepositsRequest extends AccountBalanceRequest {

    public DepositsRequest() {
        setCommand(ApplicationCommandEnum.CommandGetDeposits);
    }

}
