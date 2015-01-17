package com.numhero.client.model.datacargo.report.trialbalance;

import com.numhero.client.model.pojoc.BalanceSheetRow;
import com.numhero.shared.datacargo.CommandResponse;

import java.util.List;

public class TrialBalanceResponse implements CommandResponse {

    private List<BalanceSheetRow> sheetRows;

    public List<BalanceSheetRow> getTrialRows() {
        return sheetRows;
    }

    public void setTrialRows(List<BalanceSheetRow> sheetRows) {
        this.sheetRows = sheetRows;
    }
}
