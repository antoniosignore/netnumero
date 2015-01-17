package com.numhero.server.model.daolite;

import com.google.appengine.api.datastore.*;
import org.junit.Before;

import java.util.List;

import static org.junit.Assert.assertEquals;


public class NativeApiDaoTest extends BaseDaoTest {
    private DatastoreService ds;

    @Before
    public void setUp() throws Exception {
        super.setUp();

        ds = DatastoreServiceFactory.getDatastoreService();
    }

    public void testAncestorQuery() throws Exception {


        Entity e = new Entity("Customers");
        e.setProperty("name", "Uberto");
        ds.put(e);

        Key parentKey = e.getKey();

        Entity d1 = new Entity("CustomerItems", parentKey);
        d1.setProperty("name", "Dvd");
        ds.put(d1);

        Entity d2 = new Entity("CustomerItems", parentKey);
        d2.setProperty("name", "Book");
        ds.put(d2);

        Query q = new Query("CustomerItems", parentKey);

        System.err.println("query for ancestor " + KeyFactory.keyToString(parentKey));
        PreparedQuery pq = ds.prepare(q);

        List<Entity> l = pq.asList(FetchOptions.Builder.withLimit(10));
        for (Entity entity : l) {
            System.err.println("e " + entity.getProperty("name"));
        }
        assertEquals(2, l.size());

    }
}
