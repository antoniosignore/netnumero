package com.numhero.server.command;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.numhero.client.model.datacargo.invoice.SaveInvoiceRequest;
import com.numhero.client.model.pojoc.BusinessAccount;
import com.numhero.client.model.pojoc.Invoice;
import com.numhero.server.model.daolite.BusinessAccountDao;
import com.numhero.server.model.daolite.InvoiceDao;
import com.numhero.server.service.MockedGuiceModule;
import com.numhero.server.utils.PojoTestUtils;
import com.numhero.shared.datacargo.SaveSingleEntityResponse;
import org.junit.Before;
import org.junit.Test;

import static com.numhero.server.utils.PojoTestUtils.createBusinessAccount;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CommandSaveEstimateTest {
    InvoiceDao invDao;
    BusinessAccountDao baDao;
    CommandSaveInvoice commandSaveInvoice;
    BusinessAccount ba;

    @Before
    public void setUp() {
        ba = createBusinessAccount();
        commandSaveInvoice = new CommandSaveInvoice();
        commandSaveInvoice.setBusinessAccount(ba);
        Injector injector = Guice.createInjector(new MockedGuiceModule());
        invDao = injector.getInstance(InvoiceDao.class);
        baDao = injector.getInstance(BusinessAccountDao.class);
        injector.injectMembers(commandSaveInvoice);
    }

    @Test
    public void testSaveEstimateTest() {
        SaveInvoiceRequest request = new SaveInvoiceRequest();
        Invoice inv = PojoTestUtils.createEstimate();


        when(baDao.getByUri(inv.fBusinessAccountUri.getValue())).thenReturn(ba);

        request.setEntity(inv);
        request.setBusinessAccountId(inv.fBusinessAccountUri.getValue());
        SaveSingleEntityResponse response = commandSaveInvoice.execute(request);
        verify(invDao).save(inv);
        verify(baDao).save(ba);
        assertThat(inv.getId(), is(response.getEntityId()));
        assertThat(inv.fName.getValue(), is("Estimate1"));
        assertThat(ba.fLastInvoiceID.getValue(), is(0L));
    }


}
