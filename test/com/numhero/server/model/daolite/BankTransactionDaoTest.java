package com.numhero.server.model.daolite;

import com.numhero.client.model.pojoc.BankTransaction;
import com.numhero.server.NumheroUtils;
import com.numhero.server.utils.PojoTestUtils;
import com.numhero.shared.datacargo.PaginatedList;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class BankTransactionDaoTest extends BaseDaoTest {

	private BankTransactionDao btDao;

	@Override
	public void setUp() throws Exception {
		super.setUp();

		btDao = NumheroUtils.injector.getInstance(BankTransactionDao.class);
	}


	@Test
	public void testFindAllPaginated() throws Exception {
		btDao.save(PojoTestUtils.createBankTransaction());

		PaginatedList<BankTransaction> ul = btDao.findAllPaginated("ba1", 10, null);
		assertThat(ul.getList().size(), is(equalTo(1)));
		assertThat(ul.isFirstPage(), is(equalTo(Boolean.TRUE)));
		assertThat(ul.isLastPage(), is(equalTo(Boolean.TRUE)));


	}

}
