package com.numhero.server.service;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.numhero.client.model.pojoc.BusinessAccount;
import com.numhero.client.model.pojoc.ClientSupplier;
import com.numhero.client.model.pojoc.Invoice;
import com.numhero.server.utils.PojoTestUtils;
import org.junit.Before;
import org.junit.Test;

public class AccountingEntryBuilderTest {

    private DoubleEntryProcessor cb;

    private MockedGuiceModule mockedDaoGuiceModule = new MockedGuiceModule();

    @Before
    public void setUp() throws Exception {
        Injector injector = Guice.createInjector(mockedDaoGuiceModule);

        cb = new DoubleEntryProcessor();
        injector.injectMembers(cb);

    }

    @Test
    public void testBuild() throws Exception {

        BusinessAccount businessAccount = PojoTestUtils.createBusinessAccount();
        Invoice invoice = PojoTestUtils.createInvoice();
        ClientSupplier client = PojoTestUtils.createClientSupplier();

        invoice.setClientSupplierID(client.getId());
        invoice.setClientSupplierName(client.fName.getValue());

        //todo - create the ledger accounts 
//        cb.process(businessAccount, invoice);
//        verify(cb.businessTransactionDao, times(3)).save(any(BusinessTransaction.class));

    }

}
