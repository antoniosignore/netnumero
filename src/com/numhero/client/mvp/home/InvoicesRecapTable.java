package com.numhero.client.mvp.home;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.numhero.client.Application;
import com.numhero.client.model.pojoc.Invoice;
import com.numhero.client.mvp.document.AbstractInvoicesTable;
import com.numhero.shared.util.SharedUtils;

public class InvoicesRecapTable extends AbstractInvoicesTable {
    public InvoicesRecapTable() {
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
        HTML hPDF = new HTML("<a href='/pdf/" + invoice.getId() + "' target='_blank'><img src='../i/files/pdf.gif' boder='0'></a>");
        setWidget(row, 1, hPDF);

        setText(row, 2, invoice.getClientSupplierName());
        setText(row, 3, SharedUtils.currencyToStr(invoice.getPrice(), 2, invoice.getCurrency()));

        if (invoice.getDateRaised() != null) {
            setText(row, 4, DateTimeFormat.getShortDateFormat().format(invoice.getDateRaised()));
        } else {
            setText(row, 4, "");
        }
    }

    @Override
    protected void setHeader() {
        setHeader(0, Application.getConstants().invoice(), HasHorizontalAlignment.ALIGN_LEFT, "80px");
        setHeader(1, Application.getConstants().pdf(), HasHorizontalAlignment.ALIGN_LEFT, "20px");
        setHeader(2, Application.getConstants().client(), HasHorizontalAlignment.ALIGN_LEFT, "140px");
        setHeader(3, Application.getConstants().total(), HasHorizontalAlignment.ALIGN_LEFT, "80px");
        setHeader(4, Application.getConstants().dateRaised(), HasHorizontalAlignment.ALIGN_LEFT, "80px");
    }
}
