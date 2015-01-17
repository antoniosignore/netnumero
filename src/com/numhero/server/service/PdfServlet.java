package com.numhero.server.service;

import com.itextpdf.text.PageSize;
import com.numhero.client.model.pojoc.*;
import com.numhero.server.NumheroUtils;
import com.numhero.server.model.daolite.*;
import com.numhero.server.pdf.InvoicePdf;
import com.numhero.shared.enums.InvoiceStatusEnum;
import com.numhero.shared.util.SharedUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class PdfServlet extends HttpServlet {
    private static final long serialVersionUID = 217903650215085532L;

    private static final Logger log = Logger.getLogger(PdfServlet.class.getName());

    private SessionDao sessionDao;
    private InvoiceDao invoiceDao;
    private BusinessAccountDao businessAccountDao;
    private ClientSupplierDao clientSupplierDao;
    private TaxInfoDao taxInfoDao;

    public PdfServlet() {
        sessionDao = NumheroUtils.injector.getInstance(SessionDao.class);
        invoiceDao = NumheroUtils.injector.getInstance(InvoiceDao.class);
        businessAccountDao = NumheroUtils.injector.getInstance(BusinessAccountDao.class);
        clientSupplierDao = NumheroUtils.injector.getInstance(ClientSupplierDao.class);
        taxInfoDao = NumheroUtils.injector.getInstance(TaxInfoDao.class);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // authenticate

        log.info("\n\n\n\n\n\n\n\n\n*****************\n\n\n\n\n\n\n\nPdfServlet.doPost");

        String sessionIDFromClient = NumheroUtils.getSessionFromCookie(request);
        log.fine("sessionIDFromClient " + sessionIDFromClient);

        Session session = null;
        if (sessionIDFromClient != null) {
            session = sessionDao.findBySessionID(sessionIDFromClient);
        }
        if (session == null) {
            log.fine("sessionIDFromClient null: SC_UNAUTHORIZED");
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        Invoice invoice = null;
        String uri = request.getRequestURI();
        if (uri.startsWith("/pdf/")) {
            String[] p = SharedUtils.splitUri(uri);
            if (p != null && p.length == 3) {
                try {
                    long invoiceId = Long.parseLong(p[2]);
                    invoice = invoiceDao.get(invoiceId);
                } catch (Exception ex) {
                    log.info("PdfServlet: Bad invoiceID request - " + p[2]);
                }
            }
        }
        if (invoice == null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            log.fine("sessionIDFromClient null: SC_BAD_REQUEST");
            return;
        }

        if (!invoice.fPDF.isEmpty()) {
            try {
                byte[] pdf = invoice.fPDF.getValue();
                writeResponse(response, invoice.fName.getValue(), pdf);
            } catch (Exception ex) {
                response.sendError(404);
                log.throwing(this.getClass().getCanonicalName(), "doPost", ex);
            }
            return;
        }

        BusinessAccount ba = businessAccountDao.getByUri(invoice.fBusinessAccountUri.getValue());
        if (ba == null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        ClientSupplier cs = clientSupplierDao.get(invoice.fClientSupplierID.getValue());
        if (cs == null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        List<TaxInfo> lTaxes = taxInfoDao.findAll(invoice.fBusinessAccountUri.getValue());
        Map<Long, TaxInfo> taxes = new HashMap<Long, TaxInfo>();
        for (TaxInfo tax : lTaxes) {
            taxes.put(tax.getId(), tax);
        }

        try {
            log.info("InvoicePdf.getPdf");
            ByteArrayOutputStream baosPDF = InvoicePdf.getPdf(PageSize.A4, ba, cs, invoice, taxes);
            byte[] pdf = baosPDF.toByteArray();
            if (invoice.getInvoiceStatus() != InvoiceStatusEnum.Draft) {
                invoice.fPDF.setValue(pdf);
                invoiceDao.save(invoice);
            }
            writeResponse(response, invoice.fName.getValue(), pdf);
        } catch (Throwable ex) {
            log.throwing(this.getClass().getCanonicalName(), "doPost", ex);
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    private void writeResponse(HttpServletResponse response, String name, byte[] pdf) throws IOException {
        log.info("PdfServlet.writeResponse");

        // no cache headers
        response.setHeader("Cache-Control", "no-cache, post-check=0, pre-check=0");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Expires", "Thu, 01 Dec 1994 16:00:00 GMT");
        response.setDateHeader("Expires", 0);
        // pdf headers
        response.setHeader("Content-disposition", "inline; filename=invoice_" + name + ".pdf");
        response.setContentType("application/pdf");
        response.setContentLength(pdf.length);
        ServletOutputStream sos = response.getOutputStream();
        sos.write(pdf);
        sos.flush();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
