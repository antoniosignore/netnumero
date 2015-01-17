package com.numhero.client.model.datacargo.product;

import com.numhero.shared.datacargo.GetSingleEntityRequest;
import com.numhero.shared.service.ApplicationCommandEnum;

public class GetItemRequest extends GetSingleEntityRequest {

    public GetItemRequest() {
        setCommand(ApplicationCommandEnum.CommandGetProduct);
    }

}
