package com.numhero.server.command;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.numhero.client.model.datacargo.invoice.InvoiceListRequest;
import com.numhero.client.model.datacargo.invoice.InvoiceListResponse;
import com.numhero.client.model.pojoc.BusinessAccount;
import com.numhero.client.model.pojoc.Invoice;
import com.numhero.server.model.daolite.InvoiceDao;
import com.numhero.server.service.MockedGuiceModule;
import com.numhero.shared.datacargo.PaginatedArrayList;
import com.numhero.shared.datacargo.PaginatedList;
import com.numhero.shared.enums.InvoiceStatusEnum;
import com.numhero.shared.enums.InvoiceTypeEnum;
import org.junit.Before;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;

import static com.numhero.server.utils.PojoTestUtils.createBusinessAccount;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.*;

public class CommandGetInvoicesTest {

	private CommandGetInvoices commandGetInvoices;
	private BusinessAccount ba;
	private InvoiceDao dao;

	@Before
	public void setUp() throws Exception {

		Injector injector = Guice.createInjector(new MockedGuiceModule());
		dao = injector.getInstance(InvoiceDao.class);

        ba = createBusinessAccount();

        commandGetInvoices = new CommandGetInvoices();
        commandGetInvoices.setBusinessAccount(ba);

        injector.injectMembers(commandGetInvoices);

	}

	@Test
	public void testExecute() throws Exception {

		when(dao.findAllPaginated("ba1",2,null, InvoiceTypeEnum.Invoice, InvoiceStatusEnum.Paid)).thenAnswer(new Answer<Object>() {
			@Override
			public PaginatedList<Invoice> answer(InvocationOnMock invocationOnMock) throws Throwable {

				PaginatedList<Invoice> pl = new PaginatedArrayList<Invoice>(new ArrayList<Invoice>(), true, true);
				return pl;
			}
		});
		InvoiceListRequest req = new InvoiceListRequest(InvoiceTypeEnum.Invoice, InvoiceStatusEnum.Paid);
		req.setMaxResults(2);
		req.setBusinessAccountId(ba.fBusinessAccountUri.getValue());
		InvoiceListResponse resp = commandGetInvoices.execute(req);

		verify(dao).findAllPaginated("ba1",2,null, InvoiceTypeEnum.Invoice, InvoiceStatusEnum.Paid);
		assertThat(resp.isFirstPage(), is(Boolean.TRUE));
		assertThat(resp.isLastPage(), is(Boolean.TRUE));
		verifyNoMoreInteractions(dao);
	}
}
