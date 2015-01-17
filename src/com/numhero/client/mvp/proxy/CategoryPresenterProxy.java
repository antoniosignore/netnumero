package com.numhero.client.mvp.proxy;

import com.numhero.client.Application;
import com.numhero.client.model.datacargo.category.GetCategoryRequest;
import com.numhero.client.model.datacargo.category.SaveCategoryRequest;
import com.numhero.client.model.pojoc.Category;
import com.numhero.client.mvp.EditPageView;
import com.numhero.client.mvp.GenericAccountsTabEditPage;
import com.numhero.client.mvp.category.CategoryPanel;
import com.numhero.client.mvp.category.CategoryPresenter;
import com.numhero.client.place.PlaceManager;
import com.numhero.client.service.DataServiceAsync;
import com.numhero.client.service.Service;
import com.numhero.shared.datacargo.GetSingleEntityResponse;
import com.numhero.shared.datacargo.SaveSingleEntityResponse;

public class CategoryPresenterProxy extends PresenterProxy<CategoryPresenter> {
    @Override
    protected CategoryPresenter createPresenter() {
        EditPageView view = new GenericAccountsTabEditPage(new CategoryPanel());

        PlaceManager eventMng = Application.injector.getPlaceManager();
        DataServiceAsync service = Application.injector.getAsyncService();

        Service<GetCategoryRequest,GetSingleEntityResponse<Category>> categoryGetService = new Service<GetCategoryRequest, GetSingleEntityResponse<Category>>(service);
        Service<SaveCategoryRequest, SaveSingleEntityResponse> categorySaveService = new Service<SaveCategoryRequest, SaveSingleEntityResponse>(service);
        return new CategoryPresenter(eventMng, view, categoryGetService, categorySaveService, Application.getConstants());
    }
}
