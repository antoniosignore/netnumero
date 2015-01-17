package com.numhero.server.model.daolite;

import com.numhero.client.model.pojoc.User;
import com.numhero.server.NumheroUtils;
import com.numhero.server.auth.OneWayEncryptionService;
import com.numhero.server.utils.PojoTestUtils;
import com.numhero.shared.datacargo.PaginatedList;
import org.junit.Test;

import static junit.framework.Assert.assertNull;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class UserDaoTest extends BaseDaoTest {
    private OneWayEncryptionService encryptionService;
    private UserDao userDao;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        userDao = NumheroUtils.injector.getInstance(UserDao.class);
        encryptionService = NumheroUtils.injector.getInstance(OneWayEncryptionService.class);
    }

    @Test
    public void testInjection() throws Exception {
        assertNotNull(userDao);
    }

    @Test
    public void testDataIsThere() {
        User user = userDao.get(123434566L);
        assertNull(user);

    }

    @Test
    public void testSaveAndRetrieve() throws Exception {
        User u = new User();
        u.setFirstName("jerry");
        userDao.save(u);
        pm.flush();
        pm.evictAll();

        User u2 = userDao.get(u.getId());
        assertNotNull("failed to retrieve user", u.getFirstName());
        assertEquals(u.getFirstName(), u2.getFirstName());
    }

    @Test
    public void testSave() throws Exception {
        User u = new User();
        u.setFirstName("Fran\u00E7ais");
        u.fUserPortalId.setValue("666");

        userDao.save(u);
        assertNotNull("failed to create user id", u.getId());

        User uFound = userDao.findByPortalUserId("666");
        assertNotNull(uFound);
    }

    @Test
    public void testFindByPortalUserId() {
        User u = new User();
        u.setFirstName("jerry");
        u.fEmail.setValue("jerry@netnumero.com");
        u.fUserPortalId.setValue("666");
        userDao.save(u);

        User user = userDao.findByPortalUserId("666");
        assertNotNull(user);
        assertEquals("jerry", user.getFirstName());

        user = userDao.findByPortalUserId("jeRRy1");
        assertNull(user);
    }



    @Test
    public void testRelationToBas() {
        User u = new User();
        u.fBusinessAccountUri.setValue("baId1");
        userDao.save(u);
    }


    @Test
    public void testGet(){
        Long nullId = null;
        User user = userDao.get(nullId);
        assertNull(user);
    }

	@Test
	public void testFindAllPaginated() {
		userDao.save(PojoTestUtils.createUser());
		PaginatedList<User> ul = userDao.findAllPaginated("ba1", 10, null);
		assertThat(ul.getList().size(), is(equalTo(1)));
		assertThat(ul.isFirstPage(), is(equalTo(Boolean.TRUE)));
		assertThat(ul.isLastPage(), is(equalTo(Boolean.TRUE)));
	}


}
