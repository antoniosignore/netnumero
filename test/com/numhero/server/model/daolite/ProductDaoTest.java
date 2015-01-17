package com.numhero.server.model.daolite;

import com.numhero.client.model.pojoc.ProductService;
import com.numhero.server.NumheroUtils;
import com.numhero.server.utils.PojoTestUtils;
import com.numhero.shared.datacargo.PaginatedList;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class ProductDaoTest extends BaseDaoTest {


	private ProductDao dao;

	@Override
	public void setUp() throws Exception {
		super.setUp();
		dao = NumheroUtils.injector.getInstance(ProductDao.class);
	}

	@Test
	public void testFindAllPaginated() throws Exception {

		dao.save(PojoTestUtils.createProduct());

		PaginatedList<ProductService> ul = dao.findAllPaginated("ba1", 10, null);

		Assert.assertThat(ul.getList().size(), is(equalTo(1)));
		Assert.assertThat(ul.isFirstPage(), is(equalTo(Boolean.TRUE)));
		Assert.assertThat(ul.isLastPage(), is(equalTo(Boolean.TRUE)));

	}
}
