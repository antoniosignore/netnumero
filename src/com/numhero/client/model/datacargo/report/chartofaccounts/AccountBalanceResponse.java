package com.numhero.client.model.datacargo.report.chartofaccounts;

import com.numhero.client.model.pojoc.AccountBalanceRow;
import com.numhero.shared.datacargo.CommandResponse;

import java.util.List;

public class AccountBalanceResponse implements CommandResponse {

    private List<AccountBalanceRow> accountBalanceRowList;

    public List<AccountBalanceRow> getAccountBalanceRowList() {
        return accountBalanceRowList;
    }

    public void setAccountBalanceRowList(List<AccountBalanceRow> accountBalanceRowList) {
        this.accountBalanceRowList = accountBalanceRowList;
    }

}
