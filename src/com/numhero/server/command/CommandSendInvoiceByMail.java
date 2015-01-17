package com.numhero.server.command;

import com.google.inject.Inject;
import com.itextpdf.text.PageSize;
import com.numhero.client.model.datacargo.invoice.SendInvoiceRequest;
import com.numhero.client.model.pojoc.BusinessAccount;
import com.numhero.client.model.pojoc.ClientSupplier;
import com.numhero.client.model.pojoc.Invoice;
import com.numhero.client.model.pojoc.TaxInfo;
import com.numhero.server.model.daolite.*;
import com.numhero.server.pdf.InvoicePdf;
import com.numhero.server.service.CompanyBuilder;
import com.numhero.server.service.DoubleEntryProcessor;
import com.numhero.server.utils.CommandUtils;
import com.numhero.server.utils.DaoUtils;
import com.numhero.shared.datacargo.SaveSingleEntityResponse;
import com.numhero.shared.enums.InvoiceStatusEnum;
import com.numhero.shared.exception.ClientWarningException;

import java.io.ByteArrayOutputStream;
import java.util.Map;

//import static com.google.appengine.repackaged.com.google.common.base.StringUtil.isEmpty;

public class CommandSendInvoiceByMail extends AbstractAuthenticatedCommand<SendInvoiceRequest, SaveSingleEntityResponse> {
    @Inject
    public ClientSupplierDao clientDao;

    @Inject
    public InvoiceDao invoiceDao;

    @Inject
    public TaxInfoDao taxDao;

    @Inject
    public BusinessAccountDao businessAccountDao;

    @Inject
    public DoubleEntryProcessor doubleEntryProcessor;

    @Inject
    public EmailDao emailDao;

    public SaveSingleEntityResponse execute(SendInvoiceRequest request) {
//        Invoice invoice = (Invoice) request.getEntity();
//
//        if (invoice != null && invoice.getId() != null) {
//            invoice = invoiceDao.get(invoice.getId());
//        }
//        log.info("invoice.getClientSupplierID() = " + invoice.getClientSupplierID());
//        ClientSupplier cs = clientDao.get(invoice.getClientSupplierID());
//        if (cs.fCompanyEmail.getValue() == null || cs.fCompanyEmail.getValue().isEmpty()) {
//            throw new ClientWarningException("sendMailClientEmailMissing");
//        }
//
//        DaoUtils.setData(request, invoice);
//        invoice.fInvoiceStatus.setValue(InvoiceStatusEnum.Sent);
//
//        BusinessAccount ba = getBusinessAccount();
//        CommandUtils.persistDocument(ba, invoiceDao, businessAccountDao, invoice, doubleEntryProcessor);
//
//        Map<Long, TaxInfo> taxes = taxDao.findAllFromInvoice(invoice);
//        InvoicePdf.getPdf(PageSize.A4, ba, cs, invoice, taxes);
//
//        if (! sendByEmail(invoice, getBusinessAccount().fEmail.getValue(), cs.fCompanyEmail.getValue())){
//            throw new ClientWarningException("Impossible to send email, please retry later");
//        }
//
//        doubleEntryProcessor.processSaleToClient(ba, invoice);


        Invoice invoice = (Invoice) request.getEntity();

        ClientSupplier cs = clientDao.get(invoice.getClientSupplierID());
        if (cs.fCompanyEmail.getValue() == null || cs.fCompanyEmail.getValue().isEmpty()) {
            throw new ClientWarningException("sendMailClientEmailMissing");
        }

        DaoUtils.setData(request, invoice);
        invoice.setInvoiceStatus(InvoiceStatusEnum.Sent);
        BusinessAccount ba = getBusinessAccount();
        CommandUtils.persistDocument(
                ba,
                invoiceDao,
                businessAccountDao,
                invoice,
                doubleEntryProcessor);

        Map<Long, TaxInfo> taxes = taxDao.findAllFromInvoice(invoice);
        ByteArrayOutputStream baosPDF = InvoicePdf.getPdf(PageSize.A4, ba, cs, invoice, taxes);
        byte[] pdf = baosPDF.toByteArray();
        invoice.fPDF.setValue(pdf);
        invoiceDao.save(invoice);

        if (!sendByEmail(invoice, CompanyBuilder.MAILSERVER_NETNUMERO_COM, cs.fCompanyEmail.getValue())) {
            throw new ClientWarningException("sendMailFailed");
        }
        SaveSingleEntityResponse response = new SaveSingleEntityResponse();
        response.setEntityId(invoice.getId());
        return response;
    }

    private boolean sendByEmail(Invoice inv, String fromEmail, String destEmail) {
//        if (isEmpty(fromEmail)) {
//            throw new ClientWarningException("noEmailAddressForBA");
//        }

        String msgBody = "This is the invoice " + inv.fName.getValue() + "\n";
        msgBody += inv.fDescription.getValue() + "\n";
        msgBody += inv.fTermsConditions.getValue() + "\n";
        msgBody += "\n\nby http://www.netnumero.com";

        String subj = "Invoice " + inv.fName.getValue();
        String attachFileName = "invoice" + inv.fName.getValue() + ".pdf";
        byte[] attachment = inv.fPDF.getValue();
        try {
            emailDao.sendEmail(fromEmail, destEmail, msgBody, subj, attachment, attachFileName);
        }
        catch (Exception e) {
            //throw new RuntimeException(e);
            //e.printStackTrace();
            log.severe(e.toString() + " -- " + inv.toString() + " " + fromEmail + " " + destEmail);
            return false;
        }
        return true;
    }

}
