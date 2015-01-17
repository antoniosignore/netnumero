package com.numhero.server.service;

import com.itextpdf.text.PageSize;
import com.numhero.client.model.pojoc.BusinessAccount;
import com.numhero.client.model.pojoc.ClientSupplier;
import com.numhero.client.model.pojoc.Invoice;
import com.numhero.client.model.pojoc.TaxInfo;
import com.numhero.server.pdf.InvoicePdf;
import com.numhero.server.utils.PojoTestUtils;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.util.Map;

import static com.numhero.server.utils.PojoTestUtils.createBusinessAccount;
import static com.numhero.server.utils.PojoTestUtils.createClientSupplier;
import static org.hamcrest.MatcherAssert.assertThat;

public class PdfServletTest {

    @Test
    public void testPdfGeneration(){
        BusinessAccount ba = createBusinessAccount();
        ClientSupplier cs= createClientSupplier();
        Invoice invoice= PojoTestUtils.createInvoice();
        Map<Long, TaxInfo> taxes = PojoTestUtils.createTaxesMap();
        ByteArrayOutputStream baosPDF = InvoicePdf.getPdf(PageSize.A4, ba, cs, invoice, taxes);

        byte[] pdf = baosPDF.toByteArray();
        assertThat(pdf.length, Matchers.greaterThan(100));

    }
}
