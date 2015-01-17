package com.numhero.server.model.daolite;

import com.numhero.client.model.pojoc.BusinessTransaction;
import com.numhero.server.NumheroUtils;
import com.numhero.server.utils.PojoTestUtils;
import com.numhero.shared.datacargo.PaginatedList;
import com.numhero.shared.enums.ReferenceDocEnum;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.core.Is.is;

public class BusinessTransactionDaoTest extends BaseDaoTest {
	private BusinessTransactionDao dao;

	@Override
	public void setUp() throws Exception {
		super.setUp();	//To change body of overridden methods use File | Settings | File Templates.

		dao = NumheroUtils.injector.getInstance(BusinessTransactionDao.class);
	}

//	@Test
//	public void testFindByAccountAndDateRange() throws Exception {
//        create3BT();
//
//		Long accLeg1Id = 1L;
//		Date now = new Date();
//		List<BusinessTransaction> r = dao.findByAccountAndDateRange("ba1", new Date(now.getTime() - 1000),
//				new Date(now.getTime() + 1000), accLeg1Id);
//
//		assertThat(r.size(), is(3));
//
//        Long accLeg2Id = 2L;
//        r = dao.findByAccountAndDateRange("ba1", new Date(now.getTime() - 1000),
//				new Date(now.getTime() + 1000), accLeg2Id);
//
//		assertThat(r.size(), is(3));
//
//	}

    private void create3BT() {
        BusinessTransaction bt1 = PojoTestUtils.createAccountingEntry();
        dao.save(bt1);

        System.out.println("saved " + bt1);
        System.out.println("fLastUpdated.getValue " + bt1.fLastUpdated.getValue());
        System.out.println("fLastUpdated.getValueAsString " + bt1.fLastUpdated.getValueAsString());
        BusinessTransaction bt2 = PojoTestUtils.createAccountingEntry();
        dao.save(bt2);
        BusinessTransaction bt3 = PojoTestUtils.createAccountingEntry();
        dao.save(bt3);
    }

    @Test
	public void testSave() throws Exception {
		BusinessTransaction bt = PojoTestUtils.createAccountingEntry();

		dao.save(bt);
		assertThat(bt.getId(), greaterThan(0L));

		assertThat(bt.fReferenceDocId.getValue(), is(42L));

	}

	@Test
	public void testFindByDocRelation() throws Exception {
		BusinessTransaction bt = PojoTestUtils.createAccountingEntry();

		dao.save(bt);
		Long id = bt.getId();

		List<BusinessTransaction> l = dao.findByDocRelation(bt.fBusinessAccountUri.getValue(), 42L, ReferenceDocEnum.BankTransaction);

		assertThat(l.size(), is(1));
		assertThat(l.get(0).getId(), is(id));
		assertThat(l.get(0).fReferenceDocId.getValue(), is(42L));

	}


	@Test
	public void testFindAllPaginated() throws Exception {
        create3BT();

		PaginatedList<BusinessTransaction> rp = dao.findAllPaginated("ba1", 10, null);
		assertThat(rp.getList().size(), is(3));
		assertThat(rp.isFirstPage(), is(Boolean.TRUE));
		assertThat(rp.isLastPage(), is(Boolean.TRUE));

	}
}
