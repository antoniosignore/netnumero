package com.numhero.client.mvp.document;

import com.numhero.client.widget.combobox.DropDownBox;

public class InvoicePanel extends AbstractInvoicePanel {

    public InvoicePanel(DropDownBox<?, ?> sbPartner, InvoiceDetailsTable invoiceDetailsTable) {
        super(sbPartner, invoiceDetailsTable);
    }
}
