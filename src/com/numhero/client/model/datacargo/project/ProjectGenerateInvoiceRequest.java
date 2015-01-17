package com.numhero.client.model.datacargo.project;

import com.numhero.client.model.pojoc.Invoice;
import com.numhero.shared.datacargo.SaveSingleEntityRequest;
import com.numhero.shared.service.ApplicationCommandEnum;

public class ProjectGenerateInvoiceRequest extends SaveSingleEntityRequest {

    public ProjectGenerateInvoiceRequest() {
        setCommand(ApplicationCommandEnum.CommandProjectGenerateInvoice);
    }

    public Invoice getInvoice() {
        return (Invoice) getEntity();
    }

    public void setInvoice(Invoice invoice) {
        setEntity(invoice);
    }
}

