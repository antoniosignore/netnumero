package com.numhero.client.model.datacargo.invoice;

import com.numhero.client.model.pojoc.Invoice;
import com.numhero.shared.datacargo.SaveSingleEntityRequest;
import com.numhero.shared.service.ApplicationCommandEnum;

public class SendInvoiceRequest extends SaveSingleEntityRequest {

    public SendInvoiceRequest() {
        setCommand(ApplicationCommandEnum.CommandSendInvoiceByMail);
    }

    public Invoice getInvoice() {
        return (Invoice) getEntity();
    }

    public void setInvoice(Invoice invoice) {
        setEntity(invoice);
    }

}
