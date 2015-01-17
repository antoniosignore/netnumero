package com.numhero.server.model.daolite;

import com.google.appengine.tools.development.testing.LocalMemcacheServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;
import com.numhero.client.model.pojoc.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.*;

public class SessionDaoTest {

    private final LocalServiceTestHelper helper =
            new LocalServiceTestHelper(new LocalMemcacheServiceTestConfig());

    @Before
    public void setUp() {
        helper.setUp();
    }

    @After
    public void tearDown() {
        helper.tearDown();
    }

    @Test
    public void testFindBySessionID() throws Exception {
        SessionDao dao = new SessionDao();
        Session s1 = createTestSession();

        assertFalse(dao.isPresent(s1.getSessionID()));

        dao.save(s1);

        assertTrue(dao.isPresent(s1.getSessionID()));

        Session s2 = dao.findBySessionID(s1.getSessionID());
        assertEquals(s1, s2);
        assertTrue(dao.isPresent(s1.getSessionID()));

    }


    @Test
    public void testDelete() throws Exception {
        SessionDao dao = new SessionDao();
        Session s1 = createTestSession();
        dao.save(s1);
        assertTrue(dao.isPresent(s1.getSessionID()));
        dao.delete(s1.getSessionID());

        assertFalse(dao.isPresent(s1.getSessionID()));
    }


    private Session createTestSession() {

        return new Session(1L, "sess1");
    }
}
