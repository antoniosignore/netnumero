package com.numhero.client.model.datacargo;

import com.numhero.shared.datacargo.ListCommandRequest;
import com.numhero.shared.service.ApplicationCommandEnum;

public class GlobalSearchListRequest extends ListCommandRequest {

    public GlobalSearchListRequest() {
        setCommand(ApplicationCommandEnum.CommandGlobalSearch);
    }
}
