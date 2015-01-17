package com.numhero.server.command;

import com.google.inject.Inject;
import com.numhero.client.model.datacargo.invoice.GetInvoiceRequest;
import com.numhero.client.model.pojoc.Invoice;
import com.numhero.server.model.daolite.InvoiceDao;
import com.numhero.shared.datacargo.GetSingleEntityResponse;

public class CommandGetInvoice extends AbstractAuthenticatedCommand<GetInvoiceRequest, GetSingleEntityResponse<Invoice>> {
    @Inject
    InvoiceDao invoiceDao;

    @Override
    public GetSingleEntityResponse<Invoice> execute(GetInvoiceRequest request) throws Exception {

        GetSingleEntityResponse<Invoice> response = new GetSingleEntityResponse<Invoice>();

        Invoice invoice = invoiceDao.get(request.getEntityId());
        response.setEntity(invoice);

        return response;
    }
}
