package com.numhero.client.mvp.document;

import com.google.gwt.user.client.ui.HTML;
import com.numhero.client.model.pojoc.Invoice;
import com.numhero.client.mvp.AbstractTableForEntities;

import java.util.List;

public abstract class AbstractInvoicesTable extends AbstractTableForEntities<Invoice> {
    private boolean showCheckboxes;

    public AbstractInvoicesTable(boolean showCheckboxes) {
        this.showCheckboxes = showCheckboxes;
    }

    @Override
    public void setEntities(List<Invoice> invoices) {
        removeAllRows();
        int row = 0;
        for (Invoice invoice : invoices) {
            row++;
            int column = 0;
            if (showCheckboxes) {
                setWidget(row, 0, getCheckbox(invoice.getId()));
                column++;
            }
            String href = "#" + invoice.getInvoiceType().name().toLowerCase();
            HTML hID = new HTML("<a href='" + href + "/" + invoice.getId() + "'>" + invoice.fName.getValue() + "</a>");
            setWidget(row, column, hID);
            setOtherColumns(row, invoice);
        }
        addEmptyStatus();
    }

    protected abstract void setOtherColumns(int row, Invoice invoice);
}
