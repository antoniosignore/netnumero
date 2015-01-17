package com.numhero.client.mvp.proxy;

import com.numhero.client.model.datacargo.category.CategoryListRequest;
import com.numhero.client.model.datacargo.category.CategoryListResponse;
import com.numhero.client.model.datacargo.category.DeleteCategoriesRequest;
import com.numhero.client.mvp.GenericAccountsTabViewPage;
import com.numhero.client.mvp.category.CategoriesPresenter;
import com.numhero.client.mvp.category.CategoriesTable;
import com.numhero.client.service.Service;
import com.numhero.shared.datacargo.BulkActionResponse;

public class CategoriesPresenterProxy extends PresenterProxy<CategoriesPresenter> {


    @Override
    protected CategoriesPresenter createPresenter() {

        Service<CategoryListRequest,CategoryListResponse> listService = createNewService();
        Service<DeleteCategoriesRequest,BulkActionResponse> saveService = createNewService();
        return new CategoriesPresenter(getEventManager(),
                new GenericAccountsTabViewPage(new CategoriesTable()),
                listService,
                saveService,
                getConstants());


    }

}
