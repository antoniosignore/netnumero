package com.numhero.server.model.daolite;

import com.numhero.client.model.pojoc.BankAccount;
import com.numhero.server.NumheroUtils;
import com.numhero.server.utils.PojoTestUtils;
import com.numhero.shared.datacargo.PaginatedList;
import org.junit.Test;

import static junit.framework.Assert.assertTrue;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


public class BankAccountDaoTest extends BaseDaoTest  {
	private BankAccountDao baDao;

	@Override
    public void setUp() throws Exception {
        super.setUp();    //To change body of overridden methods use File | Settings | File Templates.

        baDao = NumheroUtils.injector.getInstance(BankAccountDao.class);
    }


	@Test
	public void testFindAllPaginated() throws Exception {
		baDao.save(PojoTestUtils.createBankAccount());

		PaginatedList<BankAccount> ul = baDao.findAllPaginated("ba1", 10, null);
		assertThat(ul.getList().size(), is(1));
		assertTrue(ul.isFirstPage());
		assertTrue(ul.isLastPage());


	}
}
