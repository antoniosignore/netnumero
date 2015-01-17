package com.numhero.client.model.datacargo.report.taxes;

import com.numhero.client.model.datacargo.report.chartofaccounts.AccountBalanceRequest;
import com.numhero.shared.service.ApplicationCommandEnum;

public class TaxesRequest extends AccountBalanceRequest {

    public TaxesRequest() {
        setCommand(ApplicationCommandEnum.CommandGetTaxes);
    }
}
