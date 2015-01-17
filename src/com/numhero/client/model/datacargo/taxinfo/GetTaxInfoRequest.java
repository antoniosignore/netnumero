package com.numhero.client.model.datacargo.taxinfo;

import com.numhero.shared.datacargo.GetSingleEntityRequest;
import com.numhero.shared.service.ApplicationCommandEnum;

public class GetTaxInfoRequest extends GetSingleEntityRequest {

    public GetTaxInfoRequest() {
        setCommand(ApplicationCommandEnum.CommandGetTaxInfo);
    }

}
