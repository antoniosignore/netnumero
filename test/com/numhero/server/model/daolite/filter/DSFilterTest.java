package com.numhero.server.model.daolite.filter;

import com.google.appengine.api.datastore.Query;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class DSFilterTest {
    @Test
    public void testGetFieldName() throws Exception {
        DSFilter f = new DSFilter("pippo");
        assertThat(f.getFieldName(), equalTo("pippo"));
    }

    @Test
    public void testEqualsTo() throws Exception {
        DSFilter f = new DSFilter("pippo").equalsTo("pluto");
        assertThat(f.getOperator(), is(Query.FilterOperator.EQUAL));
        assertThat((String) f.getValue(), equalTo("pluto"));

    }

    @Test
    public void testGreaterThan() throws Exception {
        DSFilter f = new DSFilter("pippo").greaterThan("pluto");
        assertThat(f.getOperator(), is(Query.FilterOperator.GREATER_THAN));
        assertThat((String) f.getValue(), equalTo("pluto"));

    }

    @Test
    public void testGreaterThanOrEqualTo() throws Exception {
        DSFilter f = new DSFilter("pippo").greaterThanOrEqualTo("pluto");
        assertThat(f.getOperator(), is(Query.FilterOperator.GREATER_THAN_OR_EQUAL));
        assertThat((String) f.getValue(), equalTo("pluto"));

    }

    @Test
    public void testLessThan() throws Exception {
        DSFilter f = new DSFilter("pippo").lessThan("pluto");
        assertThat(f.getOperator(), is(Query.FilterOperator.LESS_THAN));
        assertThat((String) f.getValue(), equalTo("pluto"));

    }

    @Test
    public void testLessThanOrEqualTo() throws Exception {
        DSFilter f = new DSFilter("pippo").lessThanOrEqualTo("pluto");
        assertThat(f.getOperator(), is(Query.FilterOperator.LESS_THAN_OR_EQUAL));
        assertThat((String) f.getValue(), equalTo("pluto"));

    }

    @Test
    public void testNotEqualTo() throws Exception {
        DSFilter f = new DSFilter("pippo").notEqualTo("pluto");
        assertThat(f.getOperator(), is(Query.FilterOperator.NOT_EQUAL));
        assertThat((String) f.getValue(), equalTo("pluto"));

    }

    @Test
    public void testNull() throws Exception {
        DSFilter f = new DSFilter("pippo").equalsTo(null);
        assertThat(f, is(NullDSFilter.class));

    }
}
