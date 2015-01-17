package com.numhero.client.model.datacargo.report.profitloss;

import com.numhero.client.model.pojoc.BalanceSheetRow;
import com.numhero.shared.datacargo.CommandResponse;

import java.util.List;

public class GetProfitLossResponse implements CommandResponse {

    private List<BalanceSheetRow> sheetRows;
    private Double costOfSales;
    private Double sales;
    private Double grossProfit;
    private Double totalExpenses;

    public List<BalanceSheetRow> getSheetRows() {
        return sheetRows;
    }

    public void setSheetRows(List<BalanceSheetRow> sheetRows) {
        this.sheetRows = sheetRows;
    }

    public void setCostOfSales(Double costOfSales) {
        this.costOfSales = costOfSales;
    }

    public Double getCostOfSales() {
        return costOfSales;
    }

    public void setSales(Double sales) {
        this.sales = sales;
    }

    public Double getSales() {
        return sales;
    }

    public void setGrossProfit(Double grossProfit) {
        this.grossProfit = grossProfit;
    }

    public Double getGrossProfit() {
        return grossProfit;
    }

    public void setTotalExpenses(Double totalExpenses) {
        this.totalExpenses = totalExpenses;
    }

    public Double getTotalExpenses() {
        return totalExpenses;
    }
}
