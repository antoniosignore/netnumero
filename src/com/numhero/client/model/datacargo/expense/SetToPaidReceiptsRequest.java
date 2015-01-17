package com.numhero.client.model.datacargo.expense;

import com.numhero.shared.datacargo.BulkActionRequest;
import com.numhero.shared.service.ApplicationCommandEnum;

public class SetToPaidReceiptsRequest extends BulkActionRequest {

    public SetToPaidReceiptsRequest() {
        setCommand(ApplicationCommandEnum.CommandPaidReceipts);
    }

}
