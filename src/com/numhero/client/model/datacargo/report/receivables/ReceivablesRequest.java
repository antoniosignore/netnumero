package com.numhero.client.model.datacargo.report.receivables;

import com.numhero.client.model.datacargo.report.chartofaccounts.AccountBalanceRequest;
import com.numhero.shared.service.ApplicationCommandEnum;

public class ReceivablesRequest extends AccountBalanceRequest {

    public ReceivablesRequest() {
        setCommand(ApplicationCommandEnum.CommandGetReceivables);
    }
}
