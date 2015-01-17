package com.numhero.client.model.datacargo.report.trialbalance;

import com.numhero.client.model.datacargo.report.chartofaccounts.AccountBalanceRequest;
import com.numhero.shared.service.ApplicationCommandEnum;

public class TrialBalanceRequest extends AccountBalanceRequest {

    public TrialBalanceRequest() {
        setCommand(ApplicationCommandEnum.CommandGetTrialBalance);
    }
}
