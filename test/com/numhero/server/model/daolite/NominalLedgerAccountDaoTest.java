package com.numhero.server.model.daolite;

import com.numhero.client.model.pojoc.NominalLedgerAccount;
import com.numhero.server.NumheroUtils;
import com.numhero.server.utils.PojoTestUtils;
import com.numhero.shared.enums.AccountingGroupEnum;
import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.assertNull;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.internal.matchers.IsCollectionContaining.hasItem;

public class NominalLedgerAccountDaoTest extends BaseDaoTest {
	private NominalLedgerAccountDao nominalLedgerAccountDao;


	@Override
	public void setUp() throws Exception {
		super.setUp();
		nominalLedgerAccountDao = NumheroUtils.injector.getInstance(NominalLedgerAccountDao.class);
	}

	@Test
	public void testFindAllMaxResults() throws Exception {
		NominalLedgerAccount a1 = PojoTestUtils.createNominalLedgerAccount();
		a1.fName.setValue("a1");
		nominalLedgerAccountDao.save(a1);
		NominalLedgerAccount a2 = PojoTestUtils.createNominalLedgerAccount();
		a2.fName.setValue("a2");
		nominalLedgerAccountDao.save(a2);
		NominalLedgerAccount a3 = PojoTestUtils.createNominalLedgerAccount();
		a3.fName.setValue("a3");
		nominalLedgerAccountDao.save(a3);

		List<NominalLedgerAccount> r = nominalLedgerAccountDao.findAll("ba1", 10);
		assertThat(r.size(), equalTo(3));
		assertThat(r, hasItem(a1));
	}


	@Test
	public void testSave() throws Exception {
		NominalLedgerAccount ac = PojoTestUtils.createNominalLedgerAccount();
		nominalLedgerAccountDao.save(ac);
		assertThat(ac.getId(), greaterThan(0L));
	}

	@Test
	public void testLoadAccountsByCode() throws Exception {
		NominalLedgerAccount a1 = PojoTestUtils.createNominalLedgerAccount();
		nominalLedgerAccountDao.save(a1);

		NominalLedgerAccount nl = nominalLedgerAccountDao.loadAccountsByCode("ba1", "a/c");
		assertThat(nl.fName.getValue(), equalTo("name"));
		assertThat(nl.fCode.getValue(), equalTo("a/c"));

		nl = nominalLedgerAccountDao.loadAccountsByCode("ba1", "qq");
		assertNull(nl);

		nl = nominalLedgerAccountDao.loadAccountsByCode("qqq", "a/c");
		assertNull(nl);
	}

	@Test
	public void testFindAllByGroup() throws Exception {
		nominalLedgerAccountDao.save(PojoTestUtils.createNominalLedgerAccount());
		nominalLedgerAccountDao.save(PojoTestUtils.createNominalLedgerAccount());

		List<NominalLedgerAccount> al = nominalLedgerAccountDao.findAllByGroup("ba1", AccountingGroupEnum.Asset);
		assertThat(al.size(), equalTo(0));
		al = nominalLedgerAccountDao.findAllByGroup("ba1", AccountingGroupEnum.Expense);
		assertThat(al.size(), equalTo(2));
	}

	@Test
	public void testFindPaginated() {
		NominalLedgerAccount a1 = PojoTestUtils.createNominalLedgerAccount();
		nominalLedgerAccountDao.save(a1);

		NominalLedgerAccount nl = nominalLedgerAccountDao.loadAccountsByCode("ba1", "a/c");
		assertThat(nl.fName.getValue(), equalTo("name"));
		assertThat(nl.fCode.getValue(), equalTo("a/c"));

	}

}
