package com.numhero.client.mvp.report.deposits;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.numhero.client.Application;
import com.numhero.client.ClientCache;
import com.numhero.client.model.pojoc.AccountBalanceRow;
import com.numhero.client.widget.table.AbstractTableWithHeaderAndFooter;
import com.numhero.shared.util.SharedUtils;

import java.util.List;

public class DepositsTable extends AbstractTableWithHeaderAndFooter {

    public void setAccountIF(List<AccountBalanceRow> rows) {
        removeAllRows();
        for (int row = 0; row < rows.size(); row++) {
            AccountBalanceRow accountBalanceRow = rows.get(row);
            setText(row, 0, DateTimeFormat.getShortDateFormat().format(accountBalanceRow.fDate.getValue()));
            setText(row, 1, accountBalanceRow.fTitle.getValue());
            setText(row, 2, SharedUtils.currencyToStr(accountBalanceRow.fDebitValue.getValue(), 2, ClientCache.getCurrentBA().fCurrency.getValue()));
            setText(row, 3, SharedUtils.currencyToStr(accountBalanceRow.fCreditValue.getValue(), 2, ClientCache.getCurrentBA().fCurrency.getValue()));
            setText(row, 4, SharedUtils.currencyToStr(accountBalanceRow.fBalance.getValue(), 2, ClientCache.getCurrentBA().fCurrency.getValue()));
        }
        addEmptyStatus();
    }

    protected void setHeader() {
        setHeader(0, Application.getConstants().date(), HasHorizontalAlignment.ALIGN_LEFT, "80px");
        setHeader(1, Application.getConstants().title(), HasHorizontalAlignment.ALIGN_LEFT, "80px");
        setHeader(2, Application.getConstants().debit(), HasHorizontalAlignment.ALIGN_LEFT, "100px");
        setHeader(3, Application.getConstants().credit(), HasHorizontalAlignment.ALIGN_LEFT, "100px");
        setHeader(4, Application.getConstants().balance(), HasHorizontalAlignment.ALIGN_LEFT, "100px");
    }
}
