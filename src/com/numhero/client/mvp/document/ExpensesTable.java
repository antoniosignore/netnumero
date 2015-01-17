package com.numhero.client.mvp.document;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.numhero.client.Application;
import com.numhero.client.model.pojoc.Invoice;
import com.numhero.shared.util.SharedUtils;

public class ExpensesTable extends AbstractInvoicesTable {
	public ExpensesTable() {
		super(true);
	}

	@Override
    protected void setOtherColumns(int row, Invoice invoice) {
        setText(row, 2, invoice.getClientSupplierName());
        setText(row, 3, invoice.getNotes());
        if (invoice.getDateRaised() != null) {
            setText(row, 4, DateTimeFormat.getShortDateFormat().format(invoice.getDateRaised()));
        } else {
            setText(row, 4, "");
        }
        setText(row, 5, SharedUtils.currencyToStr(invoice.getPrice(), 2, invoice.getCurrency()));
        setText(row, 6, invoice.getInvoiceStatus().name());
    }

    protected void setHeader() {
        setHeader(0, "", HasHorizontalAlignment.ALIGN_CENTER, "20px");
        setHeader(1, Application.getConstants().invoice(), HasHorizontalAlignment.ALIGN_LEFT, "80px");
        setHeader(2, Application.getConstants().supplier(), HasHorizontalAlignment.ALIGN_LEFT, "140px");
        setHeader(3, Application.getConstants().description(), HasHorizontalAlignment.ALIGN_LEFT, "%");
        setHeader(4, Application.getConstants().date(), HasHorizontalAlignment.ALIGN_LEFT, "80px");
        setHeader(5, Application.getConstants().total(), HasHorizontalAlignment.ALIGN_RIGHT, "80px");
        setHeader(6, Application.getConstants().status(), HasHorizontalAlignment.ALIGN_RIGHT, "80px");
    }
}
