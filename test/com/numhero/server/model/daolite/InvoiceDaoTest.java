package com.numhero.server.model.daolite;

import com.google.appengine.api.datastore.Query;
import com.numhero.client.model.pojoc.Invoice;
import com.numhero.client.model.pojoc.InvoiceDetail;
import com.numhero.server.NumheroUtils;
import com.numhero.server.model.daolite.filter.DSFilters;
import com.numhero.server.utils.PojoTestUtils;
import com.numhero.shared.datacargo.PaginatedList;
import com.numhero.shared.enums.InvoiceStatusEnum;
import com.numhero.shared.enums.InvoiceTypeEnum;
import org.junit.Test;

import java.util.List;

import static com.numhero.server.utils.PojoTestUtils.createInvoiceDetail;
import static com.numhero.server.utils.PojoTestUtils.createNewInvoice;
import static org.junit.Assert.*;


public class InvoiceDaoTest extends BaseDaoTest {


    InvoiceDao invoiceDao;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        invoiceDao = NumheroUtils.injector.getInstance(InvoiceDao.class);

    }

    public void tearDown() throws Exception {
        super.tearDown();
    }

    @Test
    public void testInjection() throws Exception {
        assertNotNull(invoiceDao);
    }


    @Test
    public void testSave() {
        Invoice invoice = createNewInvoice();
        invoiceDao.save(invoice);
        assertNotNull(invoiceDao.get(invoice.getId()));


        InvoiceDetail invDetail = createInvoiceDetail();
        invoice.addInvoiceDetail(invDetail);
        //      System.err.println("invoice.getId() " + invoice.getId());
        invoiceDao.save(invoice);
        //     System.err.println("invoice.getId() " + invoice.getId());
        Invoice i2 = invoiceDao.get(invoice.getId());
        assertNotNull(i2);
        assertEquals(3, i2.getDetails().size());
        assertEquals(invDetail, i2.getDetails().get(2));
    }

    @Test
    public void testDelete() {
        Invoice invoice = createNewInvoice();
        invoiceDao.save(invoice);
        Long id = invoice.getId();
        assertNotNull(invoiceDao.get(id));
        invoiceDao.delete(invoice);
        assertNull(invoiceDao.get(id));
//        System.out.println("invoice = " + invoice.getId());
    }

    @Test
    public void testSearch() {
        Invoice invoice = createNewInvoice();
        invoice.fName.setValue("2010/1");
        invoiceDao.save(invoice);

        List<Invoice> searchRet;
//shipment will be done in 2 days from confirmation of payment
//payable by bank transfer

        searchRet = invoiceDao.search("shipment", "ba1");
        assertEquals(1, searchRet.size());

        searchRet = invoiceDao.search("confirmation", "ba1");
        assertEquals(1, searchRet.size());

        searchRet = invoiceDao.search("payabl", "ba1");
        assertEquals(1, searchRet.size());

        searchRet = invoiceDao.search("bank", "ba1");
        assertEquals(1, searchRet.size());

        searchRet = invoiceDao.search("2010/1", "ba1");
        assertEquals(1, searchRet.size());

        // the is not a word, so search should not return
        searchRet = invoiceDao.search("the", "ba1");
        assertEquals(0, searchRet.size());

        // the searches in another ba
        searchRet = invoiceDao.search("bank", "ba2");
        assertEquals(0, searchRet.size());
    }

    @Test
    public void testMultiSearch() {
        Invoice invoice = createNewInvoice();
        invoiceDao.save(invoice);

        List<Invoice> searchRet;
//shipment will be done in 2 days from confirmation of payment
//payable by bank transfer

        searchRet = invoiceDao.search("shipment pippo", "ba1");
        assertEquals(1, searchRet.size());

        searchRet = invoiceDao.search("ship pluto pippo", "ba1");
        assertEquals(0, searchRet.size());
    }

    @Test
    public void testDateSearch() {
        Invoice invoice = createNewInvoice();
        invoiceDao.save(invoice);

        String date = invoice.fDateDue.getValueAsString();

        System.err.println("--" + date);
        List<Invoice> searchRet = invoiceDao.search(date, "ba1");
        assertEquals(1, searchRet.size());

        searchRet = invoiceDao.search(invoice.fDateRaised.getValueAsString(), "ba1");
        assertEquals(1, searchRet.size());
    }


    @Test
    public void testFindAll() {
        saveInvoices(4);

        List<Invoice> searchRet = invoiceDao.findAll("ba1");
        assertEquals(4, searchRet.size());
        assertEquals("2010/1", searchRet.get(0).fName.getValue());
        assertEquals("2010/4", searchRet.get(3).fName.getValue());

//        assertEquals(2, searchRet.get(2).getDetails().size());
//        assertEquals(2000.0, searchRet.get(1).getDetails().get(1).getPrice());

        searchRet = invoiceDao.findAll("ba2");
        assertEquals(0, searchRet.size());
    }


    private void saveInvoices(int numberOfInv) {
        for (int i = 0; i < numberOfInv; i++) {
            Invoice invoice = createNewInvoice();
            invoice.fName.setValue("2010/" + (i + 1));
            invoiceDao.save(invoice);

            System.err.println("---" + invoice.getId() + " " + invoice.fLastUpdated.getValueAsString());
        }
    }


    @Test
    public void testManyDetails() {
        Invoice invoice = createNewInvoice();
        invoice.getDetails().clear();
        for (int i = 0; i < 50; i++) {
            InvoiceDetail id = createInvoiceDetail();
            id.setPrice(i * 100.0);
            invoice.addInvoiceDetail(id);
        }
        long t = System.currentTimeMillis();
        invoiceDao.save(invoice);
        pm.evictAll();
        pm.flush();
        System.out.println("1." + (System.currentTimeMillis() - t));

        Long id = invoice.getId();
        Invoice i2 = invoiceDao.get(id);
        assertEquals(id, i2.getId());
        System.out.println("2." + (System.currentTimeMillis() - t));

        assertNotNull(i2.fId.getValue());
        System.out.println("3." + (System.currentTimeMillis() - t));

        assertEquals(50, i2.getDetails().size());
        System.out.println("4." + (System.currentTimeMillis() - t));

        assertEquals(200, 0.01, i2.getDetails().get(2).getPrice());
        System.out.println("5." + (System.currentTimeMillis() - t));
    }

    @Test
    public void testPagination() {
        saveInvoices(6);

        PaginatedList<Invoice> paginatedList = invoiceDao.findAllPaginatedInternal("ba1", 2, Invoice.FIELD_LAST_UPDATED, null, Query.SortDirection.DESCENDING);
        List<Invoice> searchRet = paginatedList.getList();
        assertEquals(2, searchRet.size());
        assertEquals("2010/6", searchRet.get(0).fName.getValue());
        assertEquals("2010/5", searchRet.get(1).fName.getValue());
        assertEquals(true, paginatedList.isFirstPage());
        assertEquals(false, paginatedList.isLastPage());

        PaginatedList<Invoice> paginatedList1 = invoiceDao.findAllPaginatedInternal("ba1", 2, Invoice.FIELD_LAST_UPDATED, searchRet.get(1).getId(), Query.SortDirection.DESCENDING);
        searchRet = paginatedList1.getList();
        assertEquals(2, searchRet.size());
        assertEquals("2010/4", searchRet.get(0).fName.getValue());
        assertEquals("2010/3", searchRet.get(1).fName.getValue());
        assertEquals(false, paginatedList1.isFirstPage());
        assertEquals(false, paginatedList1.isLastPage());

        PaginatedList<Invoice> paginatedList2 = invoiceDao.findAllPaginatedInternal("ba1", 2, Invoice.FIELD_LAST_UPDATED, searchRet.get(1).getId(), Query.SortDirection.DESCENDING);
        searchRet = paginatedList2.getList();
        assertEquals(2, searchRet.size());
        assertEquals("2010/2", searchRet.get(0).fName.getValue());
        assertEquals("2010/1", searchRet.get(1).fName.getValue());
        assertEquals(false, paginatedList2.isFirstPage());
        assertEquals(true, paginatedList2.isLastPage());

        PaginatedList<Invoice> paginatedList3 = invoiceDao.findAllPaginatedInternal("ba1", -2, Invoice.FIELD_LAST_UPDATED, searchRet.get(0).getId(), Query.SortDirection.DESCENDING);
        searchRet = paginatedList3.getList();
        assertEquals(2, searchRet.size());
        assertEquals("2010/4", searchRet.get(0).fName.getValue());
        assertEquals("2010/3", searchRet.get(1).fName.getValue());
        assertEquals(false, paginatedList3.isFirstPage());
        assertEquals(false, paginatedList3.isLastPage());

        PaginatedList<Invoice> paginatedList4 = invoiceDao.findAllPaginatedInternal("ba1", -2, Invoice.FIELD_LAST_UPDATED, null, Query.SortDirection.DESCENDING);
        searchRet = paginatedList4.getList();
        assertEquals(2, searchRet.size());
        assertEquals("2010/2", searchRet.get(0).fName.getValue());
        assertEquals("2010/1", searchRet.get(1).fName.getValue());
        assertEquals(false, paginatedList4.isFirstPage());
        assertEquals(true, paginatedList4.isLastPage());
    }


    @Test
    public void testPaginationTypeStatus() {
        invoiceDao.save(PojoTestUtils.createExpense());
        saveInvoices(6);
        invoiceDao.save(PojoTestUtils.createEstimate());


        PaginatedList<Invoice> searchRet = invoiceDao.findAllPaginated("ba1", 2, null, InvoiceTypeEnum.Invoice, null);
        List<Invoice> list1 = searchRet.getList();
        assertEquals(2, list1.size());
        assertEquals("2010/6", list1.get(0).fName.getValue());
        assertEquals("2010/5", list1.get(1).fName.getValue());
        assertTrue(searchRet.isFirstPage());
        assertFalse(searchRet.isLastPage());

        PaginatedList<Invoice> paginated = invoiceDao.findAllPaginated("ba1", 2, list1.get(1).getId(), InvoiceTypeEnum.Invoice, null);
        List<Invoice> list2 = paginated.getList();
        assertEquals(2, list2.size());
        assertEquals("2010/4", list2.get(0).fName.getValue());
        assertEquals("2010/3", list2.get(1).fName.getValue());
        assertFalse(paginated.isFirstPage());
        assertFalse(paginated.isLastPage());

        PaginatedList<Invoice> paginated1 = invoiceDao.findAllPaginated("ba1", -2, list2.get(0).getId(), InvoiceTypeEnum.Invoice, null);
        List<Invoice> list3 = paginated1.getList();
        assertEquals(2, list3.size());
        assertEquals("2010/6", list3.get(0).fName.getValue());
        assertEquals("2010/5", list3.get(1).fName.getValue());
        assertTrue(paginated1.isFirstPage());
        assertFalse(paginated1.isLastPage());

        PaginatedList<Invoice> paginated2 = invoiceDao.findAllPaginated("ba1", -2, null, InvoiceTypeEnum.Invoice, InvoiceStatusEnum.Billed);
        assertEquals(0, paginated2.getList().size());
        assertTrue(paginated2.isFirstPage());
        assertTrue(paginated2.isLastPage());



    }
    @Test
    public void testPaginationOtherType() {
        invoiceDao.save(PojoTestUtils.createExpense());
        saveInvoices(6);
        invoiceDao.save(PojoTestUtils.createEstimate());


        PaginatedList<Invoice> estimateList = invoiceDao.findAllPaginated("ba1", 2, null, InvoiceTypeEnum.Estimate, null);
        assertEquals(1, estimateList.getList().size());
        assertTrue(estimateList.isFirstPage());
        assertTrue(estimateList.isLastPage());

        List<Invoice> il = invoiceDao.findByCriteria("ba1", DSFilters.eq(Invoice.INVOICE_TYPE, InvoiceTypeEnum.Expense));
        assertEquals(1, il.size());


        PaginatedList<Invoice> ExpenseList = invoiceDao.findAllPaginated("ba1", -2, null, InvoiceTypeEnum.Expense, null);
        assertEquals(1, ExpenseList.getList().size());
        assertTrue(ExpenseList.isFirstPage());
        assertTrue(ExpenseList.isLastPage());

    }

}
