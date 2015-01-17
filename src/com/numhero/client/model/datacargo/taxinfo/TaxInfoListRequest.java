package com.numhero.client.model.datacargo.taxinfo;

import com.numhero.shared.datacargo.ListCommandRequest;
import com.numhero.shared.service.ApplicationCommandEnum;

public class TaxInfoListRequest extends ListCommandRequest {

    public TaxInfoListRequest() {
        setCommand(ApplicationCommandEnum.CommandGetTaxInfos);
    }
}
