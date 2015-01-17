package com.numhero.server.model.daolite;

import com.numhero.client.model.pojoc.Category;
import com.numhero.server.NumheroUtils;
import com.numhero.server.utils.PojoTestUtils;
import com.numhero.shared.datacargo.PaginatedList;
import org.hamcrest.Matchers;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class CategoryDaoTest extends BaseDaoTest {


	private CategoryDao dao;


	@Override
    public void setUp() throws Exception {
        super.setUp();    //To change body of overridden methods use File | Settings | File Templates.

        dao = NumheroUtils.injector.getInstance(CategoryDao.class);
    }

	@Test
	public void testFindAllPaginated() throws Exception {

		dao.save(PojoTestUtils.createCategory());

		PaginatedList<Category> ul = dao.findAllPaginated("ba1", 10, null);

		assertThat(ul.getList().size(), Matchers.is(equalTo(1)));
		assertThat(ul.isFirstPage(), Matchers.is(equalTo(Boolean.TRUE)));
		assertThat(ul.isLastPage(), Matchers.is(equalTo(Boolean.TRUE)));

	}


}
