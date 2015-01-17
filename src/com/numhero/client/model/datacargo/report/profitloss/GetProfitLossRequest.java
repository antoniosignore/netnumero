package com.numhero.client.model.datacargo.report.profitloss;

import com.numhero.client.model.datacargo.report.trialbalance.TrialBalanceRequest;
import com.numhero.shared.service.ApplicationCommandEnum;

public class GetProfitLossRequest extends TrialBalanceRequest {

    public GetProfitLossRequest() {
        setCommand(ApplicationCommandEnum.CommandGetProfitLoss);
    }

}
