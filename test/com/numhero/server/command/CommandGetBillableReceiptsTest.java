package com.numhero.server.command;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.numhero.client.model.datacargo.expense.ReceiptsBillingListRequest;
import com.numhero.client.model.datacargo.expense.ReceiptsListResponse;
import com.numhero.client.model.pojoc.BusinessAccount;
import com.numhero.client.model.pojoc.ClientSupplier;
import com.numhero.server.model.daolite.ExpenseReceiptDao;
import com.numhero.server.service.MockedGuiceModule;
import com.numhero.server.utils.PojoTestUtils;
import com.numhero.shared.enums.InvoiceStatusEnum;
import org.junit.Before;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.numhero.server.utils.PojoTestUtils.createBusinessAccount;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CommandGetBillableReceiptsTest   {

    private CommandGetBillableReceipts commandGetBillableReceipts;

    ExpenseReceiptDao dao;
    private BusinessAccount ba;


    @Before
    public void setUp() throws Exception {
        ba = createBusinessAccount();

        commandGetBillableReceipts = new CommandGetBillableReceipts();
        Injector injector = Guice.createInjector(new MockedGuiceModule());
        dao = injector.getInstance(ExpenseReceiptDao.class);
        injector.injectMembers(commandGetBillableReceipts);
    }

    @Test
    public void testExecute() throws Exception {

                final ClientSupplier client = PojoTestUtils.createClientSupplier();
        Date from = new Date();
        Date to = new Date(from.getTime() + 1000);

        when(dao.findReceipts("ba1", null,
                null,
                from,
                to,
                InvoiceStatusEnum.Unbilled,
                null)).thenAnswer(new Answer<List<ClientSupplier>>() {

            @Override
            public List<ClientSupplier> answer(InvocationOnMock invocationOnMock) throws Throwable {
                List<ClientSupplier> l = new ArrayList<ClientSupplier>();
                l.add(client);
                return l;
            }
        });

        ReceiptsBillingListRequest request = new ReceiptsBillingListRequest();
        request.setFromDate(from);
        request.setToDate(to);
        request.setBusinessAccountId(ba.fBusinessAccountUri.getValue());
        ReceiptsListResponse response = commandGetBillableReceipts.execute(request);

        verify(dao).findReceipts("ba1", null,
                null,
                from,
                to,
                InvoiceStatusEnum.Unbilled,
                null);
        assertThat(response.getEntityList().size(), is(1));
        assertThat(response.isFirstPage(), is(Boolean.TRUE));
        assertThat(response.isLastPage(), is(Boolean.TRUE));


    }
}
