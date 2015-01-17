package com.numhero.client.mvp.banktransaction;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.numhero.client.Application;
import com.numhero.client.model.pojoc.BankTransaction;
import com.numhero.client.mvp.AbstractTableForEntities;
import com.numhero.shared.util.SharedUtils;

import java.util.List;

public class BankTransactionsTable extends AbstractTableForEntities<BankTransaction> {

    @Override
    public void setEntities(List<BankTransaction> bankTransactions) {
        removeAllRows();
        int row = 0;
        for (BankTransaction bt : bankTransactions) {
            row++;
            HTML hID = new HTML("<a href='#bank-transaction/" + bt.getId() + "'>" + bt.fId.getValue() + "</a>");
            setText(row, 0, DateTimeFormat.getShortDateFormat().format(bt.fDate.getValue()));
            setWidget(row, 1, hID);
            setText(row, 2, bt.fBankAccountName.getValue());
            setText(row, 3, bt.fType.getValueAsString());
            setText(row, 4, SharedUtils.currencyToStr(bt.fValue.getValue(), 2, bt.fCurrency.getValue()));
        }
        addEmptyStatus();
    }


	protected void setHeader() {
        setHeader(0, Application.getConstants().date(), HasHorizontalAlignment.ALIGN_CENTER, "20px");
        setHeader(1, Application.getConstants().id(), HasHorizontalAlignment.ALIGN_LEFT, "80px");
        setHeader(2, Application.getConstants().bankName(), HasHorizontalAlignment.ALIGN_LEFT, "%");
        setHeader(3, Application.getConstants().transactionType(), HasHorizontalAlignment.ALIGN_LEFT, "%");
        setHeader(4, Application.getConstants().price(), HasHorizontalAlignment.ALIGN_RIGHT, "80px");
    }
}
