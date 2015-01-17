package com.numhero.client.model.datacargo.report.chartofaccounts;

import com.numhero.shared.datacargo.CommandResponse;
import com.numhero.shared.pojoc.SearchablePojo;

import java.util.List;

public class ChartOfAccountsResponse implements CommandResponse {

    private List<SearchablePojo> nominalLedgerAccounts;

    public void setAccounts(List<SearchablePojo> nominalLedgerAccounts) {
        this.nominalLedgerAccounts = nominalLedgerAccounts;
    }

    public List<SearchablePojo> getAccounts() {
        return nominalLedgerAccounts;
    }
}
