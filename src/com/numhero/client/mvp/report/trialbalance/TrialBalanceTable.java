package com.numhero.client.mvp.report.trialbalance;

import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.numhero.client.Application;
import com.numhero.client.ClientCache;
import com.numhero.client.model.pojoc.BalanceSheetRow;
import com.numhero.client.model.pojoc.BusinessTransaction;
import com.numhero.client.widget.table.AbstractTableWithHeaderAndFooter;
import com.numhero.shared.enums.CurrencyEnum;
import com.numhero.shared.util.SharedUtils;

import java.util.List;

public class TrialBalanceTable extends AbstractTableWithHeaderAndFooter {

    List<BusinessTransaction> businessTransactions;

    public void setBalanceRows(List<BalanceSheetRow> balanceSheetRows) {
        removeAllRows();

        Double totDebit = 0D;
        Double totCredit = 0D;

        CurrencyEnum currency = null;

        int row = 0;
        for (; row < balanceSheetRows.size(); row++) {
            BalanceSheetRow entry = balanceSheetRows.get(row);

            currency = ClientCache.getCurrentBA().fCurrency.getValue();

            setText(row, 0, entry.fNominalLedgerName.getValue());

            Double debit = -entry.fDebitValue.getValue();
            Double credit = entry.fCreditValue.getValue();

            if (debit > 0)
                setText(row, 1, SharedUtils.currencyToStr(entry.fDebitValue.getValue(), 2, currency));
            else
                setText(row, 1, "");

            if (credit > 0)
                setText(row, 2, SharedUtils.currencyToStr(entry.fCreditValue.getValue(), 2, currency));
            else
                setText(row, 2, "");

            setText(row, 3, entry.fAccountingGroup.getValueAsString());

            totDebit += debit;
            totCredit += credit;
        }

        setText(row, 0, "");
        setText(row, 1, SharedUtils.currencyToStr(totDebit, 2, currency));
        setText(row, 2, SharedUtils.currencyToStr(totCredit, 2, currency));
        setText(row, 3, "");
        
        addEmptyStatus();

    }

    @Override
    protected void setHeader() {
        setHeader(0, Application.getConstants().ledger(), HasHorizontalAlignment.ALIGN_LEFT, "80px");
        setHeader(1, Application.getConstants().debit(), HasHorizontalAlignment.ALIGN_LEFT, "80px");
        setHeader(2, Application.getConstants().credit(), HasHorizontalAlignment.ALIGN_LEFT, "100px");
        setHeader(3, Application.getConstants().accountType(), HasHorizontalAlignment.ALIGN_LEFT, "100px");
    }
}
