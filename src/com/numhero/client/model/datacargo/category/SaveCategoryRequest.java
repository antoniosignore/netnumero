package com.numhero.client.model.datacargo.category;

import com.numhero.client.model.pojoc.Category;
import com.numhero.shared.datacargo.CommandRequest;
import com.numhero.shared.datacargo.SaveSingleEntityRequest;
import com.numhero.shared.service.ApplicationCommandEnum;

public class SaveCategoryRequest extends SaveSingleEntityRequest<Category> {

    public SaveCategoryRequest() {
        setCommand(ApplicationCommandEnum.CommandSaveCategory);
    }


	@Override
    public CommandRequest[] getRemoveFromCacheOnSuccess() {
    	return new CommandRequest[] { new CategoryListRequest() };
    }
}
