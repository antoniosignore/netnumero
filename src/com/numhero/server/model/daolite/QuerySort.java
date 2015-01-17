package com.numhero.server.model.daolite;

import com.google.appengine.api.datastore.Query;

public class QuerySort {
    private final String sortFieldName;
    private final Query.SortDirection sortDirection;

    QuerySort(String sortFieldName, Query.SortDirection sortDirection) {
        this.sortFieldName = sortFieldName;
        this.sortDirection = sortDirection;
    }

    QuerySort(String sortFieldName) {
        this.sortFieldName = sortFieldName;
        this.sortDirection = Query.SortDirection.ASCENDING;
    }

    public String getSortFieldName() {
        return sortFieldName;
    }

    public Query.SortDirection getSortDirection() {
        return sortDirection;
    }

    void setSort(Query q) {
        if (getSortFieldName() != null) {
            if (getSortDirection() == null) {
                q.addSort(getSortFieldName());
            } else {
                q.addSort(getSortFieldName(), getSortDirection());
            }
        }
    }
}
