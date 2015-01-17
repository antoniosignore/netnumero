package com.numhero.server.model.daolite.filter;

import com.google.appengine.api.datastore.Query;

public class NullDSFilter extends DSFilter {
    public NullDSFilter() {
        super("NullDSFilter");
    }

    @Override
    public void addFilter(Query q) {
        //nothing to do
    }

}
