package com.numhero.server.model.daolite;

import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;
import com.numhero.server.NumheroUtils;
import org.junit.After;
import org.junit.Before;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import java.util.logging.Logger;

public abstract class BaseDaoTest  {
    protected PersistenceManager pm;

    private final LocalServiceTestHelper helper =
            new LocalServiceTestHelper(new LocalDatastoreServiceTestConfig());


    protected static final Logger log = Logger.getLogger("test");

    @Before
    public void setUp() throws Exception {
        helper.setUp();
        pm = NumheroUtils.injector.getInstance(PersistenceManagerFactory.class).getPersistenceManagerProxy();
    }

    @After
    public void tearDown() throws Exception {
        helper.tearDown();
    }

}
