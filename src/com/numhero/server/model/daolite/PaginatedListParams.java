package com.numhero.server.model.daolite;

import com.google.appengine.api.datastore.Query;

public class PaginatedListParams {
    public final String orderedFieldName;
    public final Long refObjectId;
    public final boolean prevPageAsked;
    public final int resultsForPage;
    public Query.SortDirection resultSortOrder;
    public Query.SortDirection querySortOrder;

    public PaginatedListParams(String orderedFieldName, Long refObjectId, Query.SortDirection sortOrder, int maxResults) {
        this.orderedFieldName = orderedFieldName;
        this.refObjectId = refObjectId;
        this.resultSortOrder = sortOrder;
        this.prevPageAsked = maxResults < 0;
        this.resultsForPage = prevPageAsked ? -maxResults: maxResults;
        this.querySortOrder = prevPageAsked ? inverse(resultSortOrder): resultSortOrder;
    }

    private Query.SortDirection inverse(Query.SortDirection sortOrder) {
        return sortOrder == Query.SortDirection.ASCENDING ? Query.SortDirection.DESCENDING : Query.SortDirection.ASCENDING;
    }

}
