package com.numhero.server.model.daolite;

import com.google.appengine.api.datastore.Query;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class QuerySortTest {

    @Test
    public void testConstructor() throws Exception {

        QuerySort qs = new QuerySort("ord", Query.SortDirection.DESCENDING);
        assertThat(qs.getSortFieldName(), is("ord"));
        assertThat(qs.getSortDirection(), is(Query.SortDirection.DESCENDING));

    }

    @Test
    public void testShortConstructor() throws Exception {

        QuerySort qs = new QuerySort("reord");
        assertThat(qs.getSortFieldName(), is("reord"));
        assertThat(qs.getSortDirection(), is(Query.SortDirection.ASCENDING));

    }

}
