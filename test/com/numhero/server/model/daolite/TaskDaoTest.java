package com.numhero.server.model.daolite;

import com.numhero.client.model.pojoc.Task;
import com.numhero.server.NumheroUtils;
import com.numhero.server.utils.PojoTestUtils;
import com.numhero.shared.datacargo.PaginatedList;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TaskDaoTest extends BaseDaoTest {

    private TaskDao taskDao;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        taskDao = NumheroUtils.injector.getInstance(TaskDao.class);
    }

    @Test
    public void testInjection() throws Exception {
        assertNotNull(taskDao);
    }

    @Test
    public void testSaveAndRetrieve() throws Exception {

        Task u = PojoTestUtils.createTask();

        taskDao.save(u);
        pm.flush();
        pm.evictAll();

        Task u2 = taskDao.get(u.getId());

        assertEquals(u.getId(), u2.getId());
    }


    @Test
    public void testSave() throws Exception {
        Task u = PojoTestUtils.createTask();

        taskDao.save(u);
        assertNotNull("failed to create task id", u.getId());

        List<Task> tasks = taskDao.findAll("ba1");

        assertEquals(1, tasks.size());
    }

    @Test
    public void testFindAllPaginated() throws Exception {
        Task u = PojoTestUtils.createTask();

        taskDao.save(u);

        PaginatedList<Task> ul = taskDao.findAllPaginated("ba1", 10, null);

		Assert.assertThat(ul.getList().size(), is(equalTo(1)));
		Assert.assertThat(ul.isFirstPage(), is(equalTo(Boolean.TRUE)));
		Assert.assertThat(ul.isLastPage(), is(equalTo(Boolean.TRUE)));

    }

}
