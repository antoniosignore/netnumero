package com.numhero.server.model.daolite;

import com.numhero.client.model.pojoc.ClientSupplier;
import com.numhero.client.model.pojoc.Invoice;
import com.numhero.server.NumheroUtils;
import com.numhero.server.utils.PojoTestUtils;
import com.numhero.shared.pojoc.SearchReference;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class SearchReferenceDaoTest extends BaseDaoTest {

	private ClientSupplierDao clDao;
	private InvoiceDao invDao;
	private SearchReferenceDao searchDao;

	@Override
	public void setUp() throws Exception {
		super.setUp();

		clDao = NumheroUtils.injector.getInstance(ClientSupplierDao.class);
		invDao = NumheroUtils.injector.getInstance(InvoiceDao.class);
		searchDao = NumheroUtils.injector.getInstance(SearchReferenceDao.class);
	}

	@Test
	public void testSave() throws Exception {
		Invoice inv = PojoTestUtils.createInvoice();
		ClientSupplier cl = PojoTestUtils.createClientSupplier();
		invDao.save(inv);
		clDao.save(cl);

		List<SearchReference> lt = searchDao.findAll(inv.fBusinessAccountUri.getValue());
		assertEquals(2, lt.size());

		lt = searchDao.globalSearch("pippo", inv.fBusinessAccountUri.getValue());
		assertEquals(0, lt.size());

		lt = searchDao.globalSearch("bank", inv.fBusinessAccountUri.getValue());
		assertEquals(2, lt.size());
	}
}
