package com.numhero.client.model.datacargo.invoice;

import com.numhero.shared.datacargo.BulkActionRequest;
import com.numhero.shared.service.ApplicationCommandEnum;

public class DeleteDocumentsRequest extends BulkActionRequest {

    public DeleteDocumentsRequest() {
        setCommand(ApplicationCommandEnum.CommandDeleteDocuments);
    }

}