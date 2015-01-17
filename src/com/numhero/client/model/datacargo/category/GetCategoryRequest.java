package com.numhero.client.model.datacargo.category;

import com.numhero.shared.datacargo.GetSingleEntityRequest;
import com.numhero.shared.service.ApplicationCommandEnum;

public class GetCategoryRequest extends GetSingleEntityRequest {

    public GetCategoryRequest() {
        setCommand(ApplicationCommandEnum.CommandGetCategory);
    }

}
