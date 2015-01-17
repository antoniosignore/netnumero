package com.numhero.server.command;

import com.google.inject.*;
import com.numhero.client.model.datacargo.expense.SaveReceiptRequest;
import com.numhero.client.model.datacargo.expense.SaveReceiptResponse;
import com.numhero.client.model.pojoc.BusinessAccount;
import com.numhero.client.model.pojoc.ExpenseReceipt;
import com.numhero.server.model.daolite.BankAccountDao;
import com.numhero.server.model.daolite.BusinessAccountDao;
import com.numhero.server.model.daolite.ExpenseReceiptDao;
import com.numhero.server.utils.PojoTestUtils;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.*;

public class CommandSaveExpenseTest {
    ExpenseReceiptDao expenseReceiptDao;
    CommandSaveReceipt commandSaveReceipt;
    BusinessAccountDao baDao;

    @Before
    public void setUp() throws Exception {
        commandSaveReceipt = new CommandSaveReceipt();
        Injector injector = Guice.createInjector(new MockedGuiceModule());
        baDao = injector.getInstance(BusinessAccountDao.class);
        expenseReceiptDao = injector.getInstance(ExpenseReceiptDao.class);
        injector.injectMembers(commandSaveReceipt);
    }

    @Test
    public void testSaveExpense() throws Exception {
        BusinessAccount ba = PojoTestUtils.createBusinessAccount();

        SaveReceiptRequest request = new SaveReceiptRequest();
        ExpenseReceipt expenseReceipt = PojoTestUtils.createExpenseReceipt();
        when(baDao.getByUri(expenseReceipt.fBusinessAccountUri.getValue())).thenReturn(ba);
        request.setExpense(expenseReceipt);
        request.setBusinessAccountId(expenseReceipt.fBusinessAccountUri.getValue());
        SaveReceiptResponse response = commandSaveReceipt.execute(request);
        verify(expenseReceiptDao).save(expenseReceipt);
        assertThat(expenseReceipt.getId(), is(response.getEntityId()));

    }

    private class MockedGuiceModule extends AbstractModule {
        @Override
        protected void configure() {
        }

        @Provides
        @Singleton
        BankAccountDao getBankAccountDao() {
            return mock(BankAccountDao.class);
        }

        @Provides
        @Singleton
        BusinessAccountDao getBADao() {
            return mock(BusinessAccountDao.class);
        }

        @Provides
        @Singleton
        ExpenseReceiptDao getExpenseDao() {
            return mock(ExpenseReceiptDao.class);
        }
    }
}
