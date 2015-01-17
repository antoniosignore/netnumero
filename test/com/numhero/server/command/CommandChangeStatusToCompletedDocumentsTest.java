package com.numhero.server.command;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.numhero.client.model.datacargo.invoice.ChangeStatusOfDocumentsRequest;
import com.numhero.client.model.datacargo.invoice.SaveInvoiceRequest;
import com.numhero.client.model.pojoc.BusinessAccount;
import com.numhero.client.model.pojoc.Invoice;
import com.numhero.server.model.daolite.BusinessAccountDao;
import com.numhero.server.model.daolite.InvoiceDao;
import com.numhero.server.service.MockedGuiceModule;
import com.numhero.shared.datacargo.SaveSingleEntityResponse;
import com.numhero.shared.enums.InvoiceStatusEnum;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.numhero.server.utils.PojoTestUtils.createBusinessAccount;
import static com.numhero.server.utils.PojoTestUtils.createInvoice;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.*;

public class CommandChangeStatusToCompletedDocumentsTest extends TestCase {

    InvoiceDao invDao;
    BusinessAccountDao baDao;
    CommandSaveInvoice commandSaveInvoice;
    CommandChangeStatusOfDocuments commandChangeStatus;
    BusinessAccount ba;

    @Before
    public void setUp() throws Exception {
        commandSaveInvoice = new CommandSaveInvoice();
        ba = createBusinessAccount();
        commandSaveInvoice.setBusinessAccount(ba);

        commandChangeStatus = new CommandChangeStatusOfDocuments();
        commandChangeStatus.setBusinessAccount(ba);
        Injector injector = Guice.createInjector(new MockedGuiceModule());
        invDao = injector.getInstance(InvoiceDao.class);
        baDao = injector.getInstance(BusinessAccountDao.class);
        injector.injectMembers(commandSaveInvoice);
        injector.injectMembers(commandChangeStatus);
    }

    @Test
    public void testSaveCompletedInvoice() throws Exception {
        SaveInvoiceRequest request = new SaveInvoiceRequest();
        Invoice inv = createInvoice();
        inv.setInvoiceStatus(InvoiceStatusEnum.Sent);

        request.setEntity(inv);
        request.setBusinessAccountId(inv.fBusinessAccountUri.getValue());
        SaveSingleEntityResponse response = commandSaveInvoice.execute(request);
        verify(invDao, times(1)).save(inv);
        verify(baDao).save(ba);
        assertThat(inv.getId(), is(response.getEntityId()));
        assertThat(inv.fName.getValue(), is("2010/1"));
        assertThat(ba.fLastInvoiceID.getValue(), is(1L));

        when(invDao.get(inv.getId())).thenReturn(inv);

        ChangeStatusOfDocumentsRequest changeRequest = new ChangeStatusOfDocumentsRequest();
        changeRequest.setBusinessAccountId(inv.fBusinessAccountUri.getValue());
        List<Long> ids = new ArrayList<Long>();
        ids.add(inv.getId());
        changeRequest.setEntityIdList(ids);
        changeRequest.setStatus(InvoiceStatusEnum.Sent);

//        BulkActionResponse responseCommand = commandChangeStatusToCompletedDocuments.execute(changeRequest);
//        assertEquals(responseCommand.getMessage(), "OK");
//
//        assertEquals(InvoiceStatusEnum.Completed, inv.fInvoiceStatus.getValue());
    }


}
