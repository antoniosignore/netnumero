package com.numhero.server.command;

import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.itextpdf.text.PageSize;
import com.numhero.client.model.datacargo.invoice.SendInvoiceRequest;
import com.numhero.client.model.pojoc.BusinessAccount;
import com.numhero.client.model.pojoc.ClientSupplier;
import com.numhero.client.model.pojoc.Invoice;
import com.numhero.client.model.pojoc.TaxInfo;
import com.numhero.server.model.daolite.*;
import com.numhero.server.pdf.InvoicePdf;
import com.numhero.server.service.CompanyBuilder;
import com.numhero.server.service.MockedGuiceModule;
import com.numhero.server.utils.PojoTestUtils;
import com.numhero.shared.datacargo.SaveSingleEntityResponse;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;

import java.io.ByteArrayOutputStream;
import java.util.Map;

import static com.numhero.server.utils.PojoTestUtils.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Matchers.startsWith;
import static org.mockito.Mockito.*;

public class CommandSendInvoiceByMailTest {
    InvoiceDao invDao;
    BusinessAccountDao baDao;
    CommandSendInvoiceByMail commandSendInvoice;
    ClientSupplierDao clientDao;
    EmailDao emailDao;

    BusinessAccount ba;
    private final LocalServiceTestHelper helper = new LocalServiceTestHelper(new LocalDatastoreServiceTestConfig());

    @Before
    public void setUp() throws Exception {
        ba = createBusinessAccount();

        commandSendInvoice = new CommandSendInvoiceByMail();
        commandSendInvoice.setBusinessAccount(ba);
        Injector injector = Guice.createInjector(new MockedGuiceModule());
        invDao = injector.getInstance(InvoiceDao.class);
        baDao = injector.getInstance(BusinessAccountDao.class);
        clientDao = injector.getInstance(ClientSupplierDao.class);
        emailDao = injector.getInstance(EmailDao.class);
        injector.injectMembers(commandSendInvoice);

        TaxInfoDao taxDao = mock(TaxInfoDao.class);
        when(taxDao.findAllFromInvoice(any(Invoice.class))).thenReturn(PojoTestUtils.createTaxesMap());
        commandSendInvoice.taxDao = taxDao;
        
        helper.setUp();
    }

    @Test
    public void testSendInvoice() throws Exception {

        SendInvoiceRequest request = new SendInvoiceRequest();

        Invoice inv = createInvoice();
        inv.fId.setValue(1234L);

        ClientSupplier cs = createClientSupplier();
        cs.setId(inv.getClientSupplierID());
        when(clientDao.get(cs.getId())).thenReturn(cs);

        when(baDao.getByUri(inv.fBusinessAccountUri.getValue())).thenReturn(ba);

        request.setInvoice(inv);
        when(invDao.get(inv.getId())).thenReturn(inv);

        inv.fPDF.setValue(getPdfBytes(inv, cs, ba));

        SaveSingleEntityResponse response = commandSendInvoice.execute(request);

        assertThat(response.getEntityId(), is(1234L));

        
        verify(emailDao, times(1)).sendEmail(eq(CompanyBuilder.MAILSERVER_NETNUMERO_COM),eq("client@jimwalls.de"),startsWith("This is the invoice 2010/1"), eq("Invoice 2010/1"), Matchers.<byte[]>anyVararg(), eq("invoice2010/1.pdf"));

    }

    private byte[] getPdfBytes(Invoice inv, ClientSupplier cs, BusinessAccount ba) {

        Map<Long, TaxInfo> taxes = PojoTestUtils.createTaxesMap();
        ByteArrayOutputStream baosPDF = InvoicePdf.getPdf(PageSize.A4, ba, cs, inv, taxes);

        return baosPDF.toByteArray();
    }


}
