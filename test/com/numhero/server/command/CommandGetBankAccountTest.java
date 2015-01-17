package com.numhero.server.command;

import com.google.inject.*;
import com.numhero.client.model.datacargo.bankaccount.GetBankAccountRequest;
import com.numhero.client.model.datacargo.bankaccount.GetBankAccountResponse;
import com.numhero.client.model.pojoc.BankAccount;
import com.numhero.client.model.pojoc.BusinessAccount;
import com.numhero.client.model.pojoc.User;
import com.numhero.server.model.daolite.BankAccountDao;
import com.numhero.server.model.daolite.BusinessAccountDao;
import com.numhero.server.service.MockedGuiceModule;
import com.numhero.server.utils.PojoTestUtils;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;

public class CommandGetBankAccountTest extends TestCase {

    BankAccountDao bankAccountDao;
    BusinessAccountDao dao;

    CommandGetBankAccount commandGetBankAccount;


    User user = PojoTestUtils.createUser();

    @Before
    public void setUp() throws Exception {
        super.setUp();

        commandGetBankAccount = new CommandGetBankAccount();


        Injector injector = Guice.createInjector(new MockedGuiceModule());
        bankAccountDao = injector.getInstance(BankAccountDao.class);
        injector.injectMembers(commandGetBankAccount);

        dao = injector.getInstance(BusinessAccountDao.class);
    }



    @Test
    public void testGetBankAccountC() throws Exception {

        BusinessAccount businessAccount = PojoTestUtils.createBusinessAccount();
        dao.save(businessAccount);

        BankAccount bankAccount = PojoTestUtils.createBankAccount();
        bankAccount.fBusinessAccountUri.setValue(businessAccount.fName.getValue());

        bankAccountDao.save(bankAccount);

        GetBankAccountRequest request = new GetBankAccountRequest();
        request.setEntityId(bankAccount.getId());
        request.setBusinessAccountId(businessAccount.fName.getValue());

        GetBankAccountResponse response = commandGetBankAccount.execute(request);
        BankAccount baC = response.getEntity();
        assertEquals(bankAccount.getId(), baC.getId());

    }

    // inner class --------------------------------------
    private class GuiceModule extends AbstractModule {
        @Override
        protected void configure() {
        }

        @SuppressWarnings("unused")
        @Provides
        @Singleton
        BusinessAccountDao getDao() {
            BusinessAccountDao dao = mock(BusinessAccountDao.class);
            doAnswer(new Answer<BusinessAccount>() {
                @Override
                public BusinessAccount answer(InvocationOnMock invocation) throws Throwable {
                    Long id = (Long) invocation.getArguments()[0];
                    BusinessAccount ba = new BusinessAccount();
                    ba.setId(id);
                    return ba;
                }
            }).when(dao).get(anyLong());

            return dao;
        }

        @SuppressWarnings("unused")
        @Provides
        @Singleton
        BankAccountDao getBankAccountDao() {
            BankAccountDao dao = mock(BankAccountDao.class);
            doAnswer(new Answer<BankAccount>() {
                @Override
                public BankAccount answer(InvocationOnMock invocation) throws Throwable {
                    Long id = (Long) invocation.getArguments()[0];
                    BankAccount ba = new BankAccount();
                    ba.setId(id);
                    return ba;
                }
            }).when(dao).get(anyLong());


            return dao;
        }


    }
}
