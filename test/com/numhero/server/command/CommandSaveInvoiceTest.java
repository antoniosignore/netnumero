package com.numhero.server.command;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.numhero.client.model.datacargo.invoice.SaveInvoiceRequest;
import com.numhero.client.model.pojoc.BusinessAccount;
import com.numhero.client.model.pojoc.Invoice;
import com.numhero.server.model.daolite.BusinessAccountDao;
import com.numhero.server.model.daolite.InvoiceDao;
import com.numhero.server.service.DoubleEntryProcessor;
import com.numhero.server.service.MockedGuiceModule;
import com.numhero.shared.datacargo.SaveSingleEntityResponse;
import com.numhero.shared.enums.InvoiceStatusEnum;
import org.junit.Before;
import org.junit.Test;

import static com.numhero.server.utils.PojoTestUtils.createBusinessAccount;
import static com.numhero.server.utils.PojoTestUtils.createInvoice;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.*;

public class CommandSaveInvoiceTest {
    InvoiceDao invDao;
    BusinessAccountDao baDao;
    DoubleEntryProcessor doubleEntryProcessor;
    CommandSaveInvoice commandSaveInvoice;
    BusinessAccount ba;


    @Before
    public void setUp() throws Exception {
        ba = createBusinessAccount();

        commandSaveInvoice = new CommandSaveInvoice();
        commandSaveInvoice.setBusinessAccount(ba);
        Injector injector = Guice.createInjector(new MockedGuiceModule());
        invDao = injector.getInstance(InvoiceDao.class);
        baDao = injector.getInstance(BusinessAccountDao.class);
        doubleEntryProcessor = injector.getInstance(DoubleEntryProcessor.class);
        injector.injectMembers(commandSaveInvoice);
        injector.injectMembers(doubleEntryProcessor);
    }


    @Test
    public void testSaveNewDraftInvoice() throws Exception {
        SaveInvoiceRequest request = new SaveInvoiceRequest();

        Invoice inv = createInvoice();
        inv.fName.setValue("---");
        inv.setInvoiceStatus(InvoiceStatusEnum.Draft);

        when(baDao.getByUri(inv.fBusinessAccountUri.getValue())).thenReturn(ba);

        when(invDao.get(null)).thenReturn(null);

        request.setEntity(inv);
        request.setBusinessAccountId(inv.fBusinessAccountUri.getValue());
        SaveSingleEntityResponse response = commandSaveInvoice.execute(request);
        verify(invDao).save(inv);
        verify(baDao, never()).save(ba);

        assertThat(inv.getId(), is(response.getEntityId()));
        assertThat(inv.fName.getValue(), is("---"));
    }

    @Test
    public void testSaveNewSentInvoice() throws Exception {
        SaveInvoiceRequest request = new SaveInvoiceRequest();

        Invoice inv = createInvoice();
        inv.fName.setValue("---");
        inv.setInvoiceStatus(InvoiceStatusEnum.Sent);

        when(baDao.getByUri(inv.fBusinessAccountUri.getValue())).thenReturn(ba);
        when(invDao.get(null)).thenReturn(null);

        request.setEntity(inv);
        request.setBusinessAccountId(inv.fBusinessAccountUri.getValue());
        SaveSingleEntityResponse response = commandSaveInvoice.execute(request);
        verify(invDao).save(inv);
        verify(baDao).save(ba);
        assertThat(inv.getId(), is(response.getEntityId()));
        assertThat(inv.fName.getValue(), is("2010/1"));

//        verify(doubleEntryProcessor, times(1)).processSaleToClient(ba,inv);

    }


    @Test
    public void testDraftToSentTransitionInvoice() throws Exception {
        SaveInvoiceRequest request = new SaveInvoiceRequest();

        Invoice originv = createInvoice();
        originv.fId.setValue(1L);
        originv.setInvoiceStatus(InvoiceStatusEnum.Draft);
        originv.fName.setValue("2000/---");

        Invoice inv = createInvoice();
        inv.setInvoiceStatus(InvoiceStatusEnum.Sent);

        when(baDao.getByUri(inv.fBusinessAccountUri.getValue())).thenReturn(ba);
        when(invDao.get(1L)).thenReturn(originv);

        request.setEntity(inv);
        request.setBusinessAccountId(inv.fBusinessAccountUri.getValue());
        SaveSingleEntityResponse response = commandSaveInvoice.execute(request);
        verify(invDao).save(inv);
        verify(baDao).save(ba);
        assertThat(inv.getId(), is(response.getEntityId()));
        assertThat(inv.fName.getValue(), is("2010/1"));

        assertThat(ba.fLastInvoiceID.getValue(), is(1L));
    }

    @Test
    public void testSaveSentInvoice() throws Exception {
        SaveInvoiceRequest request = new SaveInvoiceRequest();

        Invoice originv = createInvoice();
        originv.fId.setValue(1L);
        originv.setInvoiceStatus(InvoiceStatusEnum.Sent);
        originv.fName.setValue("2000/1");

        Invoice inv = createInvoice();
        inv.fId.setValue(1L);
        inv.setInvoiceStatus(InvoiceStatusEnum.Sent);

        when(baDao.getByUri(inv.fBusinessAccountUri.getValue())).thenReturn(ba);
        when(invDao.get(1L)).thenReturn(originv);

        request.setEntity(inv);
        request.setBusinessAccountId(inv.fBusinessAccountUri.getValue());
        SaveSingleEntityResponse response = commandSaveInvoice.execute(request);
        verify(invDao).save(inv);
        verify(baDao, never()).save(ba);

        assertThat(inv.getId(), is(response.getEntityId()));
        assertThat(inv.fName.getValue(), is("2010/1"));
        assertThat(ba.fLastInvoiceID.getValue(), is(0L));
    }

    @Test
    public void testRevertSentToDraftInvoice() throws Exception {
        SaveInvoiceRequest request = new SaveInvoiceRequest();

        Invoice originv = createInvoice();
        originv.fId.setValue(1L);
        originv.setInvoiceStatus(InvoiceStatusEnum.Sent);
        originv.fName.setValue("2000/1");

        Invoice inv = createInvoice();
        inv.fId.setValue(1L);
        inv.setInvoiceStatus(InvoiceStatusEnum.Draft);

        when(baDao.getByUri(inv.fBusinessAccountUri.getValue())).thenReturn(ba);
        when(invDao.get(1L)).thenReturn(originv);

        request.setEntity(inv);
        request.setBusinessAccountId(inv.fBusinessAccountUri.getValue());
        SaveSingleEntityResponse response = commandSaveInvoice.execute(request);
        verify(invDao).save(inv);
        verify(baDao, never()).save(ba);

        assertThat(inv.getId(), is(response.getEntityId()));
        assertThat(inv.fName.getValue(), is("2010/1"));
        assertThat(ba.fLastInvoiceID.getValue(), is(0L));
    }


}
