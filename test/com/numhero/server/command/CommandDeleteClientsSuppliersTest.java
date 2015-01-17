package com.numhero.server.command;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.numhero.client.model.datacargo.client_supplier.DeleteClientsSuppliersRequest;
import com.numhero.server.model.daolite.ClientSupplierDao;
import com.numhero.server.service.MockedGuiceModule;
import com.numhero.shared.datacargo.BulkActionResponse;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class CommandDeleteClientsSuppliersTest {

    ClientSupplierDao dao;

    CommandDeleteClientsSuppliers cmd;

    @Before
    public void setUp() throws Exception {

        cmd = new CommandDeleteClientsSuppliers();
//		User user = PojoCTestUtils.createUser();
//		user.setBusinessAccountId("ba1");
//		commandGetBusinessAccount.setUser(user);
//
//      commandSaveBusinessAccount = new CommandSaveBusinessAccount();
//      Injector injector = Guice.createInjector(new GuiceModule());
        Injector injector = Guice.createInjector(new MockedGuiceModule());
       dao = injector.getInstance(ClientSupplierDao.class);
      injector.injectMembers(cmd);
    }

    @Test
    public void testCreate() throws Exception {
        assertNotNull(cmd);
    }


    @Test
    public void testDeleteClients() throws Exception {

        DeleteClientsSuppliersRequest req = new DeleteClientsSuppliersRequest();
        req.getEntityIdList().add(1L);
        req.getEntityIdList().add(2L);
        req.getEntityIdList().add(3L);
        BulkActionResponse resp = cmd.execute(req);

        assertNotNull(resp);
        assertEquals(req.getEntityIdList(), resp.getSuccessIdList());
        assertEquals(0, resp.getFailureIdList().size());
        Mockito.verify(dao).delete(1L);
        Mockito.verify(dao).delete(2L);
        Mockito.verify(dao).delete(3L);

    }
}
