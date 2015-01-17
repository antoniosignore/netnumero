package com.numhero.client.model.datacargo.client_supplier;

import com.numhero.shared.datacargo.GetSingleEntityRequest;
import com.numhero.shared.service.ApplicationCommandEnum;

public class GetClientSupplierRequest extends GetSingleEntityRequest {

    public GetClientSupplierRequest() {
        setCommand(ApplicationCommandEnum.CommandGetClientSupplier);
    }

}
