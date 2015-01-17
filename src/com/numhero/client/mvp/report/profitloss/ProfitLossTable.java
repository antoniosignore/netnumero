package com.numhero.client.mvp.report.profitloss;

import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.numhero.client.Application;
import com.numhero.client.ClientCache;
import com.numhero.client.model.datacargo.report.profitloss.GetProfitLossResponse;
import com.numhero.client.model.pojoc.BalanceSheetRow;
import com.numhero.client.widget.table.AbstractTableWithHeaderAndFooter;
import com.numhero.shared.enums.CurrencyEnum;
import com.numhero.shared.util.SharedUtils;

public class ProfitLossTable extends AbstractTableWithHeaderAndFooter {

    public void setTransactions(GetProfitLossResponse response) {
        removeAllRows();
        CurrencyEnum currency = null;

        setText(0, 0, Application.getConstants().sales());
        setText(0, 1, "");
        setText(0, 2, SharedUtils.currencyToStr(response.getSales(), 2, currency));

        setText(1, 0, Application.getConstants().costOfSales());
        setText(1, 1, "");
        setText(1, 2, SharedUtils.currencyToStr(response.getCostOfSales().doubleValue(), 2, currency));

        setText(2, 0, Application.getConstants().grossProfits());
        setText(2, 1, "");
        setText(2, 2, SharedUtils.currencyToStr(response.getGrossProfit().doubleValue(), 2, currency));

        int row = 0;
        for (; row < response.getSheetRows().size(); row++) {
            BalanceSheetRow entry = response.getSheetRows().get(row);
            currency = ClientCache.getCurrentBA().fCurrency.getValue();
            setText(row + 3, 0, entry.fNominalLedgerName.getValue());

            Double debit = -entry.fDebitValue.getValue();
            Double credit = entry.fCreditValue.getValue();

            if (debit > 0)
                setText(row + 3, 1, SharedUtils.currencyToStr(entry.fDebitValue.getValue(), 2, ClientCache.getCurrentBA().fCurrency.getValue()));
            else
                setText(row + 3, 1, "");

            if (credit > 0)
                setText(row + 3, 2, SharedUtils.currencyToStr(entry.fCreditValue.getValue(), 2, ClientCache.getCurrentBA().fCurrency.getValue()));
            else
                setText(row + 3, 2, "");
        }

        setText(row + 4, 0, Application.getConstants().totalExpenses());
        setText(row + 4, 1, "");
        setText(row + 4, 2, SharedUtils.currencyToStr(response.getTotalExpenses().doubleValue(), 2, currency));
        addEmptyStatus();

    }

    @Override
    protected void setHeader() {
        setHeader(0, Application.getConstants().ledger(), HasHorizontalAlignment.ALIGN_LEFT, "80px");
        setHeader(1, Application.getConstants().debit(), HasHorizontalAlignment.ALIGN_LEFT, "80px");
        setHeader(2, Application.getConstants().credit(), HasHorizontalAlignment.ALIGN_LEFT, "100px");
    }
}
