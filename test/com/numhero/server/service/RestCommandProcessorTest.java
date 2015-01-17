package com.numhero.server.service;

import com.numhero.client.model.datacargo.client_supplier.SaveClientSupplierRequest;
import com.numhero.client.model.datacargo.invoice.GetInvoiceRequest;
import com.numhero.client.model.datacargo.invoice.InvoiceListRequest;
import com.numhero.client.model.datacargo.invoice.SaveInvoiceRequest;
import com.numhero.client.model.datacargo.user.GetUserRequest;
import com.numhero.client.model.datacargo.user.SaveUserRequest;
import com.numhero.client.model.pojoc.ClientSupplier;
import com.numhero.client.model.pojoc.Invoice;
import com.numhero.client.model.pojoc.User;
import com.numhero.server.NumheroUtils;
import com.numhero.server.model.daolite.BaseDaoTest;
import com.numhero.server.model.daolite.ClientSupplierDao;
import com.numhero.server.model.daolite.InvoiceDao;
import com.numhero.server.utils.PojoTestUtils;
import com.numhero.shared.datacargo.GetSingleEntityRequest;
import com.numhero.shared.datacargo.ListCommandRequest;
import com.numhero.shared.datacargo.SaveSingleEntityRequest;
import com.numhero.shared.enums.CurrencyEnum;
import com.numhero.shared.enums.InvoiceTypeEnum;
import org.junit.Before;
import org.junit.Test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

import static com.numhero.server.utils.XmlUtils.serializeEntity;
import static org.junit.Assert.*;
import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.*;

public class RestCommandProcessorTest extends BaseDaoTest {

    InvoiceDao invoiceDao;
    RestCommandPreProcessor preP;
    ClientSupplierDao clientDao;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        invoiceDao = NumheroUtils.injector.getInstance(InvoiceDao.class);
        clientDao = NumheroUtils.injector.getInstance(ClientSupplierDao.class);
        preP = NumheroUtils.injector.getInstance(RestCommandPreProcessor.class);
    }

    @Test
    public void testIsUriOk() throws Exception {
        assertTrue(preP.isUriOk("/rest/mycompany/search/invoices"));
        assertTrue(preP.isUriOk("/rest/mycompany/invoice/12"));
        assertFalse(preP.isUriOk("/rest/mycompany/invoices"));
        assertFalse(preP.isUriOk("/rest/mycompany/invoice/1223/abc"));

        assertFalse(preP.isUriOk("/pippocamminadritto"));
    }

    @Test
    public void testProcess() throws Exception {
        User u = createUserC();
        u.setId((Long) null);
        StringBuffer xml = new StringBuffer();
        serializeEntity(xml, u);

        HttpServletResponse httpResp = mock(HttpServletResponse.class);
        HttpServletRequest httpReq = mock(HttpServletRequest.class);
        when(httpReq.getRequestURI()).thenReturn("/rest/mycompany/user/12");
        when(httpReq.getMethod()).thenReturn("POST");
        when(httpReq.getParameter("entity")).thenReturn(xml.toString());
        PrintWriter mockWriter = mock(PrintWriter.class);
        when(httpResp.getWriter()).thenReturn(mockWriter);
        preP.process(httpReq, httpResp);
        verify(mockWriter).println("<id>1</id>");
    }

    @Test
    public void testCreateGetInvoiceRequest() {
        GetSingleEntityRequest req = (GetSingleEntityRequest) preP.prepareHelper("/rest/mycompany/invoice/12", "GET", "").getCmdRequest();
        assertEquals(GetInvoiceRequest.class.getName(), req.getClass().getName());
        assertEquals(12L, req.getEntityId().longValue());
        assertEquals("mycompany", req.getBusinessAccountId());
    }

    @Test
    public void testCreateGetUserRequest() {
        GetSingleEntityRequest req = (GetSingleEntityRequest) preP.prepareHelper("/rest/mycompany/user/12", "GET", "").getCmdRequest();
        assertEquals(GetUserRequest.class.getName(), req.getClass().getName());
        assertEquals(12, req.getEntityId().longValue());
        assertEquals("mycompany", req.getBusinessAccountId());
    }

    @Test
    public void testCreateSaveClientRequest() {
        ClientSupplier c = createClientSupplierC();
        StringBuffer xml = new StringBuffer();
        serializeEntity(xml, c);
        System.out.println("xml " + xml.toString());
        SaveSingleEntityRequest req = (SaveSingleEntityRequest) preP.prepareHelper("/rest/mycompany/client_supplier/12", "POST", xml.toString()).getCmdRequest();
        assertEquals(SaveClientSupplierRequest.class.getName(), req.getClass().getName());
        assertEquals(ClientSupplier.class, req.getEntity().getClass());
        assertEquals("mycompany", req.getBusinessAccountId());
    }

    @Test
    public void testCreateSaveInvoiceRequest() {
        Invoice inv = createInvoiceC();
        StringBuffer xml = new StringBuffer();
        serializeEntity(xml, inv);
        System.out.println("xml " + xml.toString());

        SaveSingleEntityRequest req = (SaveSingleEntityRequest) preP.prepareHelper("/rest/mycompany/invoice/12", "POST", xml.toString()).getCmdRequest();
        assertEquals(SaveInvoiceRequest.class.getName(), req.getClass().getName());
        assertEquals("mycompany", req.getBusinessAccountId());
        Invoice respInv = (Invoice) req.getEntity();
        assertEquals(inv.getNotes(), respInv.getNotes());
        assertEquals(inv.getCurrency(), respInv.getCurrency());
        assertEquals(inv.getPrice(), respInv.getPrice());
    }

    @Test
    public void testCreateSaveUserRequest() {
        User u = createUserC();
        StringBuffer xml = new StringBuffer();
        serializeEntity(xml, u);
        //System.out.println("xml " + xml.toString());

        SaveSingleEntityRequest req = (SaveSingleEntityRequest) preP.prepareHelper("/rest/mycompany/user/12", "POST", xml.toString()).getCmdRequest();
        assertEquals(SaveUserRequest.class.getName(), req.getClass().getName());
        assertEquals("mycompany", req.getBusinessAccountId());
        User respU = ((SaveUserRequest) req).getUser();
        assertEquals(u.getFirstName(), respU.getFirstName());
        assertEquals(u.getLastName(), respU.getLastName());
        assertEquals(u.getId(), respU.getId());
        assertEquals(u.fBusinessAccountUri.getValue(), respU.fBusinessAccountUri.getValue());
    }


    @Test
    public void testCreateGetInvoicesRequest() {
        ListCommandRequest req = (ListCommandRequest) preP.prepareHelper("/rest/mycompany/invoice", "GET", "").getCmdRequest();
        assertEquals(InvoiceListRequest.class.getName(), req.getClass().getName());
        assertEquals("mycompany", req.getBusinessAccountId());
        assertEquals(20, req.getMaxResults());
    }

    @Test
    public void testProcessGetInvoices() throws Exception {
        ClientSupplier client = PojoTestUtils.createClientSupplier();
        clientDao.save(client);

        Invoice invoice = PojoTestUtils.createInvoice();
        invoice.setInvoiceType(InvoiceTypeEnum.Invoice);
        invoice.fBusinessAccountUri.setValue("mycompany");
        invoice.setClientSupplierName(client.fName.getValue());
        invoiceDao.save(invoice);


        HttpServletResponse httpResp = mock(HttpServletResponse.class);
        HttpServletRequest httpReq = mock(HttpServletRequest.class);
        when(httpReq.getRequestURI()).thenReturn("/rest/mycompany/invoice");
        when(httpReq.getMethod()).thenReturn("GET");

        PrintWriter mockWriter = mock(PrintWriter.class);
        when(httpResp.getWriter()).thenReturn(mockWriter);
        preP.process(httpReq, httpResp);

        verify(mockWriter).println(contains("<entity type=\"Invoice\" >"));

        //        "<response><entity><entity type=\"Invoice\" ><currency>USD</currency><dateDue>Sat Jul 10 13:41:30 CEST 2010</dateDue><dateRaised>Sat Jul 10 13:41:30 CEST 2010</dateRaised><discount>1.5</discount><id>agR0ZXN0cg0LEgdJbnZvaWNlGAIM</id><invoiceID>invoice</invoiceID><invoiceType>Invoice</invoiceType><notes>brown lasy fox jumps over the green fence</notes></entity></entity></response>"
    }


    public static ClientSupplier createClientSupplierC() {
        ClientSupplier c = new ClientSupplier();
        c.fNotes.setValue("notes");
        c.fAddress.setValue("via della Spiga");
        c.fName.setValue("Camiceria Mariella s.n.c.");
        c.fClient.setValue(true);
        c.fSupplier.setValue(true);
        return c;
    }

    public static User createUserC() {
        User u = new User();
        u.setId(12L);
        u.fBusinessAccountUri.setValue("1234");
        u.setFirstName("ubi");
        u.setLastName("barbini");
        return u;
    }

    public static Invoice createInvoiceC() {
        Invoice invoiceC = new Invoice();
        invoiceC.setCurrency(CurrencyEnum.EUR);
        invoiceC.setNotes("notes");
        invoiceC.setPrice(123.45);
        return invoiceC;
    }
}
