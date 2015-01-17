package com.numhero.server.pdf;

import com.itextpdf.text.PageSize;
import com.numhero.server.utils.PojoTestUtils;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.fail;

public class TestPdf {
    public static final String RESULT = "test.pdf";

    @Test
    public void createInvoice() throws IOException {

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(RESULT);
            InvoicePdf.getPdf(PageSize.A4,
                    PojoTestUtils.createBusinessAccount(),
                    PojoTestUtils.createClientSupplier(),
                    PojoTestUtils.createInvoice(),
                    PojoTestUtils.createTaxesMap()).writeTo(fos);
            fos.flush();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
            fail("No exceptions hould have been thrown");
        }
        assertNotNull(fos);

    }
}
