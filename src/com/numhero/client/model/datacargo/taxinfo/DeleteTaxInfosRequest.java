package com.numhero.client.model.datacargo.taxinfo;

import com.numhero.shared.datacargo.BulkActionRequest;
import com.numhero.shared.service.ApplicationCommandEnum;

public class DeleteTaxInfosRequest extends BulkActionRequest {

    public DeleteTaxInfosRequest() {
        setCommand(ApplicationCommandEnum.CommandDeleteTaxInfos);
    }

}