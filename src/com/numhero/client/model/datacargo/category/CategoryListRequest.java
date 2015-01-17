package com.numhero.client.model.datacargo.category;

import com.numhero.shared.datacargo.ListCommandRequest;
import com.numhero.shared.service.ApplicationCommandEnum;

public class CategoryListRequest extends ListCommandRequest {

    public CategoryListRequest() {
        setCommand(ApplicationCommandEnum.CommandGetCategories);
    }
}
