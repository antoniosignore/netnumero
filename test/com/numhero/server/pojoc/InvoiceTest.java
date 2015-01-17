package com.numhero.server.pojoc;

import com.numhero.client.model.pojoc.Invoice;
import com.numhero.client.model.pojoc.TaxInfo;
import com.numhero.server.utils.PojoTestUtils;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class InvoiceTest {
    @Test
    public void testID() throws Exception {
    	Invoice invoice = new Invoice();
    	invoice.fName.setValue("2010/12");
        assertEquals("2010/", invoice.getPrefixIDFromName());
        assertEquals(12l, invoice.getNumberIDFromName());

    	invoice.fName.setValue("2010/3/0005");
        assertEquals("2010/3/", invoice.getPrefixIDFromName());
        assertEquals(5l, invoice.getNumberIDFromName());

    	invoice.fName.setValue("07");
        assertEquals("", invoice.getPrefixIDFromName());
        assertEquals(7l, invoice.getNumberIDFromName());

    	invoice.fName.setValue("07mu");
        assertEquals("07mu", invoice.getPrefixIDFromName());
        assertEquals(0l, invoice.getNumberIDFromName());
    }

    @Test
    public void testCalculate() throws Exception {
        Invoice inv = PojoTestUtils.createInvoice();
        Map<Long, TaxInfo> taxes = PojoTestUtils.createTaxesMap();

        double n = inv.calculateNet();
        Map<String, Double> calculatedTaxes = inv.calculateTaxes(taxes);

        double approx = 0.001;
        assertEquals(60000.0, n, approx);
        assertEquals(n * 0.175, calculatedTaxes.get("VAT"), approx);
        assertEquals(70500, inv.getPrice(), approx);

        inv.setDiscount(10.0);
        n = inv.calculateNet();
        calculatedTaxes = inv.calculateTaxes(taxes);

        assertEquals(54000.0, n, approx);
        assertEquals(n * 0.175, calculatedTaxes.get("VAT"), approx);
    }

    public void testFkID() throws Exception {
        Invoice invoice = PojoTestUtils.createInvoice();
        assertNotNull(invoice);
        assertNotNull(invoice.fClientSupplierID);
    }

    @Test
    public void testNoTaxes() throws Exception {
        Invoice invoice = PojoTestUtils.createInvoiceNoVat();
        Map<Long, TaxInfo> map = new HashMap<Long, TaxInfo>();
        Map<String, Double> taxes = invoice.calculateTaxes(map);
        assertThat(taxes.size(), equalTo(0) );
    }

    @Test
    public void testSimpleVatTaxes() throws Exception {
        Invoice invoice = PojoTestUtils.createInvoiceVAT();
        Map<Long, TaxInfo> map = new HashMap<Long, TaxInfo>();
        TaxInfo tax = PojoTestUtils.createVatTaxInfo(20.0);
        map.put(1L, tax);
        Map<String, Double> taxes = invoice.calculateTaxes(map);
        assertThat(taxes.size(), equalTo(1) );
        assertThat(taxes.get("VAT20.0"), equalTo(400.0) );
    }

    @Test
    public void testComplexVatTaxes() throws Exception {
        Invoice invoice = PojoTestUtils.createInvoiceMultiVAT();
        Map<Long, TaxInfo> map = new HashMap<Long, TaxInfo>();
        map.put(11L, PojoTestUtils.createVatTaxInfo(20.0));
        map.put(12L, PojoTestUtils.createVatTaxInfo(10.0));
        map.put(13L, PojoTestUtils.createVatTaxInfo(5.0));
        map.put(14L, PojoTestUtils.createVatTaxInfo(17.5));
        Map<String, Double> taxes = invoice.calculateTaxes(map);
        assertThat(taxes.size(), equalTo(4) );

//        invoice.addInvoiceDetail(createInvoiceDetail(1000, "detail1", 1L, 2L));
//        invoice.addInvoiceDetail(createInvoiceDetail(800, "detail2", 2L, 3L));
//        invoice.addInvoiceDetail(createInvoiceDetail(600, "detail3", null, 4L));

        assertThat(taxes.get("VAT20.0"), equalTo(1000.0 * 0.2) );
        assertThat(taxes.get("VAT10.0"), equalTo(1800.0 * 0.1) );
        assertThat(taxes.get("VAT5.0"), equalTo(800.0 * 0.05) );
        assertThat(taxes.get("VAT17.5"), equalTo(600.0 * 0.175) );
    }
}
