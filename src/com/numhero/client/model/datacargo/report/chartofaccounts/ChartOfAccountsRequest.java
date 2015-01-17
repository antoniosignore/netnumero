package com.numhero.client.model.datacargo.report.chartofaccounts;

import com.numhero.shared.datacargo.CommandRequest;
import com.numhero.shared.service.ApplicationCommandEnum;

public class ChartOfAccountsRequest extends CommandRequest {

    public ChartOfAccountsRequest() {
        setCommand(ApplicationCommandEnum.CommandGetChartOfAccounts);
    }

}
