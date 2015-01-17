package com.numhero.client.mvp.proxy;

import com.numhero.client.model.datacargo.GlobalSearchListRequest;
import com.numhero.client.model.datacargo.GlobalSearchListResponse;
import com.numhero.client.mvp.search.SearchPresenter;
import com.numhero.client.mvp.search.SearchView;
import com.numhero.client.service.Service;

public class SearchPresenterProxy extends PresenterProxy<SearchPresenter> {
    @Override
    protected SearchPresenter createPresenter() {

        Service<GlobalSearchListRequest, GlobalSearchListResponse> searchService = createNewService();
        SearchView view = new SearchView();
        return new SearchPresenter(getEventManager(),
                searchService,
                view);
    }
}
