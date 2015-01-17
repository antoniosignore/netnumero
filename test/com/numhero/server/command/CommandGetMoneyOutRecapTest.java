package com.numhero.server.command;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.numhero.client.model.datacargo.moneyout.MoneyOutRecapRequest;
import com.numhero.client.model.datacargo.moneyout.MoneyOutRecapResponse;
import com.numhero.client.model.pojoc.BusinessAccount;
import com.numhero.server.model.daolite.ExpenseReceiptDao;
import com.numhero.server.model.daolite.FXDao;
import com.numhero.server.model.daolite.InvoiceDao;
import com.numhero.server.service.MockedGuiceModule;
import org.junit.Before;
import org.junit.Test;

import static com.numhero.server.utils.PojoTestUtils.createBusinessAccount;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;

public class CommandGetMoneyOutRecapTest {

    private CommandGetMoneyOutRecap commandGetMoneyOutRecap;
    private BusinessAccount ba;
    public InvoiceDao invoiceDao;
    public FXDao fxDao;
    public ExpenseReceiptDao expenseReceiptDao;

    @Before
    public void setUp() throws Exception {

        Injector injector = Guice.createInjector(new MockedGuiceModule());
        invoiceDao = injector.getInstance(InvoiceDao.class);
        fxDao = injector.getInstance(FXDao.class);
        expenseReceiptDao = injector.getInstance(ExpenseReceiptDao.class);


        ba = createBusinessAccount();

        commandGetMoneyOutRecap = new CommandGetMoneyOutRecap();
        commandGetMoneyOutRecap.setBusinessAccount(ba);

        injector.injectMembers(commandGetMoneyOutRecap);

    }

    @Test
    public void testExecute() throws Exception {

        MoneyOutRecapRequest request = new MoneyOutRecapRequest();
        MoneyOutRecapResponse response = commandGetMoneyOutRecap.execute(request);
        assertNotNull(response);

        assertThat(response.getRows().size(), is(12));

    }
}
