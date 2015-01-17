package com.numhero.server.command;

import com.google.inject.Inject;
import com.numhero.client.model.datacargo.category.GetCategoryRequest;
import com.numhero.client.model.pojoc.Category;
import com.numhero.server.model.daolite.CategoryDao;
import com.numhero.shared.datacargo.GetSingleEntityResponse;

public class CommandGetCategory extends AbstractAuthenticatedCommand<GetCategoryRequest, GetSingleEntityResponse<Category>> {

    @Inject
    CategoryDao categoryDao;

    @Override
    public GetSingleEntityResponse<Category> execute(GetCategoryRequest request) throws Exception {
        GetSingleEntityResponse<Category> response = new GetSingleEntityResponse<Category>();
        Category category = categoryDao.get(request.getEntityId());
        response.setEntity(category);
        return response;
    }
}
