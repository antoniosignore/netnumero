package com.numhero.server.model.daolite;

import com.google.appengine.api.datastore.Query;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class PaginatedListParamsTest {
    @Test
    public void testConstructor() throws Exception {

        PaginatedListParams p = new PaginatedListParams("ord", null, Query.SortDirection.ASCENDING, 12);
        assertThat(p.orderedFieldName, is("ord"));
        assertThat(p.refObjectId, is((Long) null));
        assertThat(p.resultSortOrder, is(Query.SortDirection.ASCENDING));
        assertThat(p.querySortOrder, is(Query.SortDirection.ASCENDING));
        assertThat(p.resultsForPage, is(12));
        assertThat(p.prevPageAsked, is(false));

    }

    @Test
    public void testIsPrevPageAsked() throws Exception {

        PaginatedListParams p = new PaginatedListParams("ord", null, Query.SortDirection.DESCENDING, -12);
        assertThat(p.orderedFieldName, is("ord"));
        assertThat(p.refObjectId, is((Long) null));
        assertThat(p.resultSortOrder, is(Query.SortDirection.DESCENDING));
        assertThat(p.querySortOrder, is(Query.SortDirection.ASCENDING));
        assertThat(p.resultsForPage, is(12));
        assertThat(p.prevPageAsked, is(true));

    }

}
