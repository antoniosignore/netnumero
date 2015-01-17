package com.numhero.server.model.daolite;

import com.numhero.client.model.pojoc.TaxInfo;
import com.numhero.server.NumheroUtils;
import com.numhero.server.utils.PojoTestUtils;
import com.numhero.shared.datacargo.PaginatedList;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class TaxInfoDaoTest extends BaseDaoTest {
    private TaxInfoDao dao;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        dao = NumheroUtils.injector.getInstance(TaxInfoDao.class);
    }


    @Test
    public void testFindAllFromInvoice() throws Exception {

        TaxInfo ti = PojoTestUtils.createPercentTaxInfo();
        dao.save(ti);
        TaxInfo ti2 = PojoTestUtils.createPercentTaxInfo();
        ti2.setId(2L);
        dao.save(ti2);
        TaxInfo ti3 = PojoTestUtils.createPercentTaxInfo();
        ti3.setId(3L);
        dao.save(ti3);
        TaxInfo ti4 = PojoTestUtils.createPercentTaxInfo();
        ti4.setId(4L);
        dao.save(ti4);

        Map<Long, TaxInfo> l = dao.findAllFromInvoice(PojoTestUtils.createInvoiceMultiVAT());
    }


	@Test
	public void testFindAllPaginated(){
		dao.save(PojoTestUtils.createPercentTaxInfo());

		PaginatedList<TaxInfo> ul = dao.findAllPaginated("ba1", 10, null);

		Assert.assertThat(ul.getList().size(), is(equalTo(1)));
		Assert.assertThat(ul.isFirstPage(), is(equalTo(Boolean.TRUE)));
		Assert.assertThat(ul.isLastPage(), is(equalTo(Boolean.TRUE)));

	}

}
