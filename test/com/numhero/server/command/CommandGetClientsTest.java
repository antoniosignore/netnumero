package com.numhero.server.command;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.numhero.client.model.datacargo.client_supplier.ClientListRequest;
import com.numhero.client.model.datacargo.client_supplier.ClientSupplierListResponse;
import com.numhero.client.model.pojoc.BusinessAccount;
import com.numhero.client.model.pojoc.ClientSupplier;
import com.numhero.server.model.daolite.ClientSupplierDao;
import com.numhero.server.service.MockedGuiceModule;
import com.numhero.server.utils.PojoTestUtils;
import com.numhero.shared.datacargo.PaginatedArrayList;
import com.numhero.shared.datacargo.PaginatedList;
import com.numhero.shared.enums.ClientSupplierEnum;
import org.junit.Before;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;
import java.util.List;

import static com.numhero.server.utils.PojoTestUtils.createBusinessAccount;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CommandGetClientsTest {

    private CommandGetClients commandGetClients;

    private ClientSupplierDao clientSupplierDao;
    private BusinessAccount ba;

    @Before
    public void setUp() throws Exception {

        Injector injector = Guice.createInjector(new MockedGuiceModule());
        clientSupplierDao = injector.getInstance(ClientSupplierDao.class);

        ba = createBusinessAccount();

        commandGetClients = new CommandGetClients();
        commandGetClients.setBusinessAccount(ba);

        injector.injectMembers(commandGetClients);

    }

    @Test
    public void testExecute() throws Exception {

        final ClientSupplier client = PojoTestUtils.createClientSupplier();

        when(clientSupplierDao.findAllPaginated("ba1", 10, null, ClientSupplierEnum.client)).thenAnswer(new Answer<PaginatedList<ClientSupplier>>() {

            @Override
            public PaginatedList<ClientSupplier> answer(InvocationOnMock invocationOnMock) throws Throwable {
                List<ClientSupplier> l = new ArrayList<ClientSupplier>();
                l.add(client);
                return new PaginatedArrayList<ClientSupplier>(l, true, true);
            }
        });

        ClientListRequest request = new ClientListRequest();
        request.setMaxResults(10);
        request.setBusinessAccountId(ba.fBusinessAccountUri.getValue());
        ClientSupplierListResponse response = commandGetClients.execute(request);

        assertThat(response.getEntityList().size(), is(1));
        assertThat(response.isFirstPage(), is(Boolean.TRUE));
        assertThat(response.isLastPage(), is(Boolean.TRUE));

        verify(clientSupplierDao).findAllPaginated("ba1", 10, null, ClientSupplierEnum.client);
    }
}
