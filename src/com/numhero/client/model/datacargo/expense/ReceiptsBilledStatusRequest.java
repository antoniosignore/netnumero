package com.numhero.client.model.datacargo.expense;

import com.numhero.shared.datacargo.BulkActionRequest;
import com.numhero.shared.service.ApplicationCommandEnum;

public class ReceiptsBilledStatusRequest extends BulkActionRequest {

    public ReceiptsBilledStatusRequest() {
        setCommand(ApplicationCommandEnum.CommandReceiptsBilledStatus);
    }

}