package com.numhero.server.command;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.numhero.client.model.datacargo.businessaccount.SaveBusinessAccountRequest;
import com.numhero.client.model.datacargo.businessaccount.SaveBusinessAccountResponse;
import com.numhero.client.model.pojoc.BusinessAccount;
import com.numhero.server.model.daolite.BusinessAccountDao;
import com.numhero.server.service.MockedGuiceModule;
import com.numhero.server.utils.PojoTestUtils;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import static com.numhero.server.utils.PojoTestUtils.createBusinessAccount;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

public class CommandSaveBusinessAccountTest extends TestCase {

    BusinessAccountDao dao;
    CommandSaveBusinessAccount commandSaveBusinessAccount;

    @Before
    public void setUp() throws Exception {
        commandSaveBusinessAccount = new CommandSaveBusinessAccount();
        commandSaveBusinessAccount.setUser(PojoTestUtils.createUser());
        Injector injector = Guice.createInjector(new MockedGuiceModule());
        dao = injector.getInstance(BusinessAccountDao.class);
        injector.injectMembers(commandSaveBusinessAccount);
    }


    @Test
    public void testSaveBusinessAccount() throws Exception {
        SaveBusinessAccountRequest request = new SaveBusinessAccountRequest();
        BusinessAccount businessAccount = createBusinessAccount();
        businessAccount.setId(null); //new BA
        request.setBusinessAccount(businessAccount);
        SaveBusinessAccountResponse response = commandSaveBusinessAccount.execute(request);
        verify(dao).save(businessAccount);
        verify(dao, never()).get(anyLong());
        assertNotNull(response.getEntityId());
    }

    @Test
    public void testSaveExistingBusinessAccount() throws Exception {
        SaveBusinessAccountRequest request = new SaveBusinessAccountRequest();
        BusinessAccount businessAccount = createBusinessAccount();
        request.setBusinessAccount(businessAccount);
        SaveBusinessAccountResponse response = commandSaveBusinessAccount.execute(request);
        verify(dao).save(businessAccount);
        verify(dao).get(businessAccount.getId());
        assertNotNull(response.getEntityId());
    }

}
