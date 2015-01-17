package com.numhero.server.command;

import com.google.inject.Inject;
import com.numhero.client.model.datacargo.invoice.ConvertToInvoiceRequest;
import com.numhero.client.model.pojoc.BusinessAccount;
import com.numhero.client.model.pojoc.Invoice;
import com.numhero.client.model.pojoc.InvoiceDetail;
import com.numhero.server.model.daolite.BusinessAccountDao;
import com.numhero.server.model.daolite.InvoiceDao;
import com.numhero.shared.datacargo.BulkActionResponse;
import com.numhero.shared.enums.InvoiceStatusEnum;
import com.numhero.shared.enums.InvoiceTypeEnum;
import com.numhero.shared.exception.ClientWarningException;

import java.util.Date;
import java.util.List;

public class CommandConvertToInvoices extends AbstractAuthenticatedCommand<ConvertToInvoiceRequest, BulkActionResponse> {

    @Inject
    InvoiceDao dao;

    @Inject
    BusinessAccountDao baDao;

    @Override
    public BulkActionResponse execute(ConvertToInvoiceRequest convertToInvoiceRequest) throws Exception {

        BulkActionResponse resp = new BulkActionResponse();
        List<Long> ids = convertToInvoiceRequest.getEntityIdList();
        if (ids.isEmpty()) throw new ClientWarningException("ids cannot be null");
        log.fine("id List:" + ids);

        for (Long s : ids) {
            Invoice expense = dao.get(s);
            BusinessAccount ba = baDao.getByUri(convertToInvoiceRequest.getBusinessAccountId());

            Invoice invoice = new Invoice();
            invoice.fName.setValue(expense.fName.getValue());
            invoice.fDescription.setValue("Supplier expense : " + expense.fName);
            invoice.fBusinessAccountUri.setValue(ba.fBusinessAccountUri.getValue());

            invoice.setInvoiceType(InvoiceTypeEnum.Invoice);
            invoice.setInvoiceStatus(InvoiceStatusEnum.Draft);
            invoice.setDateRaised(new Date());
            invoice.setClientSupplierID(expense.fClientSupplierID.getValue());
            invoice.setClientSupplierName(expense.fClientSupplierName.getValue());
            invoice.setCurrency(expense.fCurrency.getValue());
            invoice.setDiscount(expense.getDiscount());
            invoice.fName.setValue(expense.fName.getValue());
            invoice.fDateDue.setValue(new Date(System.currentTimeMillis() + ba.fDefaultDaysDue.getValue() * 24 * 60 * 60 * 1000));
            invoice.setTermsConditions(ba.fTermsConditions.getValue());
            invoice.fNotes.setValue("Converted to invoice from supplier invoice : " + expense.fName);

            invoice.setCreated(new Date());

            List<InvoiceDetail> details = expense.getDetails();
            for (InvoiceDetail detail : details) {
                invoice.addInvoiceDetail(detail);
            }

            invoice.setPrice(expense.fValue.getValue());

            dao.save(invoice);
            resp.getSuccessIdList().add(s);
        }
        log.fine("resp.getSuccessIdList().size() = " + resp.getSuccessIdList().size());
        log.fine("resp.getFailureIdList().size() = " + resp.getFailureIdList().size());

        resp.setSuccessIdList(resp.getSuccessIdList());
        resp.setFailureIdList(resp.getFailureIdList());
        resp.setMessage("OK");

        return resp;
    }
}
