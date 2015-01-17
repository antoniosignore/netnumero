package com.numhero.client.mvp.accounting;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.numhero.client.Application;
import com.numhero.client.ClientCache;
import com.numhero.client.model.pojoc.AccountingLeg;
import com.numhero.client.model.pojoc.BusinessTransaction;
import com.numhero.client.util.CoreUtils;
import com.numhero.client.widget.table.FlexTableWithHeader;
import com.numhero.shared.enums.AccountingEntrySide;
import com.numhero.shared.pojoc.field.OwnedListField;
import com.numhero.shared.util.SharedUtils;

import java.util.Iterator;

public class LegsTable extends FlexTableWithHeader {

    public void setEntry(BusinessTransaction entry) {
        removeAllRows();
        this.setWidth("100%");
        setHeader();

        OwnedListField<AccountingLeg> legs = entry.getAccountingLegs();
        CoreUtils.debug("legs.size() = " + legs.size());

        int row = 0;
        for (Iterator<AccountingLeg> accountingLegIterator = legs.iterator(); accountingLegIterator.hasNext();) {
            AccountingLeg accountingLeg = accountingLegIterator.next();

            if (accountingLeg.fDoubleEntryType.getValue() == AccountingEntrySide.debit) {
                setText(row, 0, DateTimeFormat.getShortDateFormat().format(entry.fDate.getValue()));
                setText(row, 1, accountingLeg.fAccountName.getValueAsString());
                setText(row, 2, SharedUtils.currencyToStr(accountingLeg.fValue.getValue(), 2, ClientCache.getCurrentBA().fCurrency.getValue()));
                getFlexCellFormatter().setStyleName(row, 2, "ledger-cell");
                setText(row, 3, "");
                setText(row, 4, "");
                setText(row, 5, "");
            } else {
                setText(row, 0, "");
                setText(row, 1, "");
                setText(row, 2, "");
                setText(row, 3, SharedUtils.currencyToStr(accountingLeg.fValue.getValue(), 2, ClientCache.getCurrentBA().fCurrency.getValue()));
                getFlexCellFormatter().setStyleName(row, 3, "ledger-cell");
                setText(row, 4, accountingLeg.fAccountName.getValueAsString());
                setText(row, 5, DateTimeFormat.getShortDateFormat().format(entry.fDate.getValue()));
            }
            row++;
        }
    }

    protected void setHeader() {
        setHeader(0, "", HasHorizontalAlignment.ALIGN_LEFT, "80px");
        setHeader(1, Application.getConstants().ledger(), HasHorizontalAlignment.ALIGN_LEFT, "80px");
        setHeader(2, Application.getConstants().debit(), HasHorizontalAlignment.ALIGN_LEFT, "80px");
        setHeader(3, Application.getConstants().credit(), HasHorizontalAlignment.ALIGN_LEFT, "80px");
        setHeader(4, Application.getConstants().ledger(), HasHorizontalAlignment.ALIGN_LEFT, "80px");
        setHeader(5, "", HasHorizontalAlignment.ALIGN_LEFT, "80px");
    }
}
