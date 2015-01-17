package com.numhero.server.command;

import com.google.inject.Inject;
import com.numhero.client.model.datacargo.category.SaveCategoryRequest;
import com.numhero.client.model.pojoc.Category;
import com.numhero.server.model.daolite.CategoryDao;
import com.numhero.server.utils.DaoUtils;
import com.numhero.shared.datacargo.SaveSingleEntityResponse;

import java.util.logging.Logger;

public class CommandSaveCategory extends AbstractAuthenticatedCommand<SaveCategoryRequest, SaveSingleEntityResponse> {
    @SuppressWarnings("unused")
    private static final Logger log = Logger.getLogger(CommandSaveCategory.class.getName());

    @Inject
    CategoryDao categoryDao;

    @Override
    public SaveSingleEntityResponse execute(SaveCategoryRequest request) {

        Category category = (Category) request.getEntity();
        DaoUtils.setData(request, category);
        categoryDao.save(category);

        SaveSingleEntityResponse response = new SaveSingleEntityResponse();
        response.setEntityId(category.getId());
        return response;
    }
}
