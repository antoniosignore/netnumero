package com.numhero.client.model.datacargo.expense;

import com.numhero.shared.datacargo.BulkActionRequest;
import com.numhero.shared.service.ApplicationCommandEnum;

public class DeleteReceiptsRequest extends BulkActionRequest {

    public DeleteReceiptsRequest() {
        setCommand(ApplicationCommandEnum.CommandDeleteReceipts);
    }

}