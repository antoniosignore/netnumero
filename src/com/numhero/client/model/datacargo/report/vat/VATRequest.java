package com.numhero.client.model.datacargo.report.vat;

import com.numhero.client.model.datacargo.report.chartofaccounts.AccountBalanceRequest;
import com.numhero.shared.service.ApplicationCommandEnum;

public class VATRequest extends AccountBalanceRequest {

    public VATRequest() {
        setCommand(ApplicationCommandEnum.CommandGetVAT);
    }
}
