package com.numhero.server.command;

import com.google.inject.Inject;
import com.numhero.client.model.datacargo.GlobalSearchListRequest;
import com.numhero.client.model.datacargo.GlobalSearchListResponse;
import com.numhero.server.model.daolite.SearchReferenceDao;
import com.numhero.shared.pojoc.SearchReference;

import java.util.List;

public class CommandGlobalSearch extends AbstractAuthenticatedCommand<GlobalSearchListRequest, GlobalSearchListResponse> {
    @Inject
    private SearchReferenceDao searchDao;

    @Override
    public GlobalSearchListResponse execute(GlobalSearchListRequest request) {
    	GlobalSearchListResponse response = new GlobalSearchListResponse();

        List<SearchReference> results;
        results = searchDao.globalSearch(request.getStartingKey(), request.getBusinessAccountId());
        log.fine("search results: " + results.size());

        response.setEntityList(results);
        return response;
    }
}
