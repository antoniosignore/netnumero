package com.numhero.client.mvp.category;

import com.numhero.client.Application;
import com.numhero.client.model.datacargo.category.CategoryListRequest;
import com.numhero.client.model.datacargo.category.CategoryListResponse;
import com.numhero.client.service.Service;
import com.numhero.client.widget.search.SearchPanel;
import com.numhero.client.widget.search.SearchPojoDialog;

public class SearchCategoryDialog extends SearchPojoDialog {
    public SearchCategoryDialog(Service<CategoryListRequest, CategoryListResponse> getListService, String search) {
        super(Application.getConstants().searchCategories(), search, getListService, new SearchPanel(new SearchCategoryTable()), new CategoryListRequest());
    }
}
