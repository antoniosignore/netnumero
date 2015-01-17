package com.numhero.server.command;

import com.google.inject.Inject;
import com.numhero.client.model.datacargo.invoice.ChangeStatusOfDocumentsRequest;
import com.numhero.client.model.pojoc.Invoice;
import com.numhero.server.model.daolite.InvoiceDao;
import com.numhero.server.service.DoubleEntryProcessor;
import com.numhero.shared.datacargo.BulkActionResponse;
import com.numhero.shared.enums.InvoiceStatusEnum;
import com.numhero.shared.enums.InvoiceTypeEnum;
import com.numhero.shared.exception.ClientWarningException;

import java.util.List;

public class CommandChangeStatusOfDocuments extends AbstractAuthenticatedCommand<ChangeStatusOfDocumentsRequest, BulkActionResponse> {

    @Inject
    InvoiceDao dao;

    @Inject
    DoubleEntryProcessor doubleEntryProcessor;

    @Override
    public BulkActionResponse execute(ChangeStatusOfDocumentsRequest request) throws Exception {

        //todo -- process the payment to Supplier

        List<Long> ids = request.getEntityIdList();
        if (ids.isEmpty()) throw new ClientWarningException("ids cannot be null");

        BulkActionResponse resp = new BulkActionResponse();

        for (Long s : ids) {
            Invoice invoice = dao.get(s);

            InvoiceStatusEnum newStatus = request.getStatus();
            invoice.setInvoiceStatus(request.getStatus());

            dao.save(invoice);

            if (invoice.fType.getValue() == InvoiceTypeEnum.Invoice && newStatus == InvoiceStatusEnum.Paid) {
                doubleEntryProcessor.processPaymentFromClient(getBusinessAccount(), invoice);
            }

            if (invoice.fType.getValue() == InvoiceTypeEnum.Expense && newStatus == InvoiceStatusEnum.Paid) {
                doubleEntryProcessor.processPaymentToSupplier(getBusinessAccount(), invoice);
            }

            resp.getSuccessIdList().add(s);
        }
        resp.setMessage("OK");
        return resp;
    }
}
