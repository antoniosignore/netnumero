package com.numhero.client.model.datacargo.expense;

import com.numhero.shared.datacargo.GetSingleEntityRequest;
import com.numhero.shared.service.ApplicationCommandEnum;

public class GetReceiptRequest extends GetSingleEntityRequest {

    public GetReceiptRequest() {
        setCommand(ApplicationCommandEnum.CommandGetReceipt);
    }

}
