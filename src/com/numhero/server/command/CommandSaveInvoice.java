package com.numhero.server.command;

import com.google.inject.Inject;
import com.numhero.client.model.datacargo.invoice.SaveInvoiceRequest;
import com.numhero.client.model.pojoc.Invoice;
import com.numhero.server.model.daolite.BusinessAccountDao;
import com.numhero.server.model.daolite.InvoiceDao;
import com.numhero.server.service.DoubleEntryProcessor;
import com.numhero.server.utils.CommandUtils;
import com.numhero.server.utils.DaoUtils;
import com.numhero.shared.datacargo.SaveSingleEntityResponse;

import java.util.logging.Logger;

public class CommandSaveInvoice extends AbstractAuthenticatedCommand<SaveInvoiceRequest, SaveSingleEntityResponse> {
    protected static final Logger log = Logger.getLogger(CommandSaveInvoice.class.getName());

    @Inject
    protected InvoiceDao invoiceDao;

    @Inject
    protected BusinessAccountDao businessAccountDao;

    @Inject
    DoubleEntryProcessor doubleEntryProcessor;

    @Override
    public SaveSingleEntityResponse execute(SaveInvoiceRequest request) {

        Invoice invoice = (Invoice) request.getEntity();

        DaoUtils.setData(request, invoice);
        CommandUtils.persistDocument(
                getBusinessAccount(),
                invoiceDao,
                businessAccountDao,
                invoice,
                doubleEntryProcessor);

        SaveSingleEntityResponse response = new SaveSingleEntityResponse();
        response.setEntityId(invoice.getId());
        return response;
    }
}
