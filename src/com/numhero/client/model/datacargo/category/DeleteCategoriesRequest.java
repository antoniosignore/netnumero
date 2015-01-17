package com.numhero.client.model.datacargo.category;

import com.numhero.shared.datacargo.BulkActionRequest;
import com.numhero.shared.service.ApplicationCommandEnum;

public class DeleteCategoriesRequest extends BulkActionRequest {

    public DeleteCategoriesRequest() {
        setCommand(ApplicationCommandEnum.CommandDeleteCategories);
    }

}