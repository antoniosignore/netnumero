package com.numhero.client.model.datacargo.expense;

import com.numhero.shared.datacargo.GetSingleEntityRequest;
import com.numhero.shared.service.ApplicationCommandEnum;

public class GetUnbilledReceiptRequest extends GetSingleEntityRequest {

    public GetUnbilledReceiptRequest() {
        setCommand(ApplicationCommandEnum.CommandGetUnbilledReceipt);
    }

}
