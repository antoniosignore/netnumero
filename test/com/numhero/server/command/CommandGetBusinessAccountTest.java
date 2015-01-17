package com.numhero.server.command;

import com.google.inject.*;
import com.numhero.client.model.datacargo.businessaccount.GetBusinessAccountRequest;
import com.numhero.client.model.datacargo.businessaccount.GetBusinessAccountResponse;
import com.numhero.client.model.pojoc.BusinessAccount;
import com.numhero.server.model.daolite.BusinessAccountDao;
import com.numhero.server.service.MockedGuiceModule;
import com.numhero.server.utils.PojoTestUtils;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.mockito.Mockito.*;

public class CommandGetBusinessAccountTest extends TestCase {

    BusinessAccountDao dao;

    CommandGetBusinessAccount commandGetBusinessAccount;
    CommandSaveBusinessAccount commandSaveBusinessAccount;

    @Before
    public void setUp() throws Exception {
        super.setUp();

        commandGetBusinessAccount = new CommandGetBusinessAccount();
        commandSaveBusinessAccount = new CommandSaveBusinessAccount();
        Injector injector = Guice.createInjector(new MockedGuiceModule());
        dao = injector.getInstance(BusinessAccountDao.class);
        injector.injectMembers(commandSaveBusinessAccount);
        injector.injectMembers(commandGetBusinessAccount);
    }

    @Test
    public void testGetBusinessAccountC() throws Exception {
        BusinessAccountDao baDao = mock(BusinessAccountDao.class);
        when(baDao.getByUri("gama")).thenAnswer(new Answer<BusinessAccount>() {

            @Override
            public BusinessAccount answer(InvocationOnMock invocationOnMock) throws Throwable {
                BusinessAccount businessAccount = PojoTestUtils.createBusinessAccount();
                businessAccount.setId(42L);
                return businessAccount;
            }
        });
        commandGetBusinessAccount.businessAccountDao = baDao;

        GetBusinessAccountRequest request = new GetBusinessAccountRequest();
        request.setEntityId(42L);
        request.setBusinessAccountId("gama");
        GetBusinessAccountResponse response = commandGetBusinessAccount.execute(request);

        BusinessAccount baC = response.getEntity();
        assertEquals(42L, baC.getId().longValue());
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
    }
}
