package com.numhero.client.mvp.document;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.numhero.client.Application;
import com.numhero.client.model.pojoc.Invoice;
import com.numhero.shared.util.SharedUtils;

public class InvoicesTable extends AbstractInvoicesTable {


    public InvoicesTable() {
		super(true);
    }


	@Override
    protected void setOtherColumns(int row, Invoice invoice) {
        HTML hPDF = new HTML("<a href='/pdf/" + invoice.getId() + "' target='_blank'><img src='../i/files/pdf.gif' boder='0'></a>");
        setWidget(row, 2, hPDF);

        setText(row, 3, invoice.getClientSupplierName());
        setText(row, 4, invoice.getNotes());
        if (invoice.getDateRaised() != null) {
            setText(row, 5, DateTimeFormat.getShortDateFormat().format(invoice.getDateRaised()));
        } else {
            setText(row, 5, "");
        }
        setText(row, 6, SharedUtils.currencyToStr(invoice.getPrice(), 2, invoice.getCurrency()));

        if (invoice.getInvoiceStatus() != null) {
            setText(row, 7, invoice.getInvoiceStatus().name());
            table.getFlexCellFormatter().setStyleName(row, 7, invoice.getInvoiceStatus().name().toLowerCase() + "-invoice");
        } else {
            setText(row, 7, "");
        }
    }

    @Override
    protected void setHeader() {
        setHeader(0, "", HasHorizontalAlignment.ALIGN_CENTER, "20px");
        setHeader(1, Application.getConstants().invoice(), HasHorizontalAlignment.ALIGN_LEFT, "80px");
        setHeader(2, Application.getConstants().pdf(), HasHorizontalAlignment.ALIGN_LEFT, "20px");
        setHeader(3, Application.getConstants().client(), HasHorizontalAlignment.ALIGN_LEFT, "140px");
        setHeader(4, Application.getConstants().notes(), HasHorizontalAlignment.ALIGN_LEFT, "%");
        setHeader(5, Application.getConstants().date(), HasHorizontalAlignment.ALIGN_LEFT, "80px");
        setHeader(6, Application.getConstants().total(), HasHorizontalAlignment.ALIGN_RIGHT, "80px");
        setHeader(7, Application.getConstants().status(), HasHorizontalAlignment.ALIGN_LEFT, "80px");
    }
}
