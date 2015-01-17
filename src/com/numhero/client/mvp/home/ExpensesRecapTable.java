package com.numhero.client.mvp.home;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.numhero.client.Application;
import com.numhero.client.model.pojoc.Invoice;
import com.numhero.client.mvp.document.AbstractInvoicesTable;
import com.numhero.shared.util.SharedUtils;

public class ExpensesRecapTable extends AbstractInvoicesTable {
	public ExpensesRecapTable() {
		super(false);
	}


	@Override
	protected void init() {
		super.init();
		table.setStyleName("inh-standard-recap");
	}

    @Override
    protected void addFooter() {
    }

    @Override
    protected void setOtherColumns(int row, Invoice invoice) {
        setText(row, 1, invoice.getClientSupplierName());
        setText(row, 2, SharedUtils.currencyToStr(invoice.getPrice(), 2, invoice.getCurrency()));

        if (invoice.getDateRaised() != null) {
            setText(row, 3, DateTimeFormat.getShortDateFormat().format(invoice.getDateRaised()));
        } else {
            setText(row, 3, "");
        }
    }

    @Override
    protected void setHeader() {
        setHeader(0, Application.getConstants().date(), HasHorizontalAlignment.ALIGN_LEFT, "80px");
        setHeader(1, Application.getConstants().supplier(), HasHorizontalAlignment.ALIGN_LEFT, "80px");
        setHeader(2, Application.getConstants().total(), HasHorizontalAlignment.ALIGN_LEFT, "80px");
        setHeader(3, Application.getConstants().dateRaised(), HasHorizontalAlignment.ALIGN_LEFT, "80px");
    }
}
