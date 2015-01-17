package com.numhero.server.command;

import com.google.inject.Inject;
import com.numhero.client.model.datacargo.project.ProjectGenerateInvoiceRequest;
import com.numhero.client.model.datacargo.project.ProjectGenerateInvoiceResponse;
import com.numhero.client.model.pojoc.Invoice;
import com.numhero.server.model.daolite.InvoiceDao;
import com.numhero.server.utils.DaoUtils;

public class CommandProjectGenerateInvoice extends AbstractAuthenticatedCommand<ProjectGenerateInvoiceRequest, ProjectGenerateInvoiceResponse> {

    @Inject
    InvoiceDao invoiceDao;

    @Override
    public ProjectGenerateInvoiceResponse execute(ProjectGenerateInvoiceRequest request) throws Exception {
        Invoice invoice = (Invoice) request.getEntity();
        DaoUtils.setData(request, invoice);
        invoiceDao.save(invoice);
        log.fine("saved invoice: " + invoice);

        // createAudit
        ProjectGenerateInvoiceResponse response = new ProjectGenerateInvoiceResponse();
        response.setEntityId(invoice.getId());
        return response;
    }
}
