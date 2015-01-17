package com.numhero.client.mvp.moneyin;

import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.numhero.client.Application;
import com.numhero.client.ClientCache;
import com.numhero.client.model.pojoc.MoneyInOutRecapRow;
import com.numhero.client.widget.table.FlexTableWithHeader;
import com.numhero.shared.util.SharedUtils;

import java.util.Collection;

public class MoneyInSummaryTable extends FlexTableWithHeader {

    public MoneyInSummaryTable() {
        setStyleName("inh-standard-recap");
        setHeader();
    }

    public void setRecaps(Collection<MoneyInOutRecapRow> rows) {
        removeAllRows();
        int row = 0;
        for (MoneyInOutRecapRow invoice : rows) {
            row++;
            setText(row, 0, getLocalizedMonth(invoice.fMonth.getValue()));
            setText(row, 1, invoice.fYear.getValueAsString());
            setText(row, 2, SharedUtils.currencyToStr(invoice.fInvoiceValue.getValue().doubleValue(), 2, ClientCache.getCurrentBA().fCurrency.getValue()));
            setText(row, 3, SharedUtils.currencyToStr(invoice.fEstimatesValue.getValue().doubleValue(), 2, ClientCache.getCurrentBA().fCurrency.getValue()));
        }
    }

    private String getLocalizedMonth(Integer value) {
        if (value == 0) return Application.getConstants().january();
        if (value == 1) return Application.getConstants().february();
        if (value == 2) return Application.getConstants().march();
        if (value == 3) return Application.getConstants().april();
        if (value == 4) return Application.getConstants().may();
        if (value == 5) return Application.getConstants().june();
        if (value == 6) return Application.getConstants().july();
        if (value == 7) return Application.getConstants().august();
        if (value == 8) return Application.getConstants().september();
        if (value == 9) return Application.getConstants().october();
        if (value == 10) return Application.getConstants().november();
        return Application.getConstants().december();
    }

    protected void setHeader() {
        setHeader(0, "", HasHorizontalAlignment.ALIGN_LEFT, "80px");
        setHeader(1, "", HasHorizontalAlignment.ALIGN_LEFT, "140px");
        setHeader(2, Application.getConstants().paidInvoices(), HasHorizontalAlignment.ALIGN_LEFT, "80px");
        setHeader(3, Application.getConstants().estimates(), HasHorizontalAlignment.ALIGN_LEFT, "80px");
    }
}
