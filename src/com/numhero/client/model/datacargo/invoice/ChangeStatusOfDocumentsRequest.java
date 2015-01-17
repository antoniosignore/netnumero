package com.numhero.client.model.datacargo.invoice;

import com.numhero.shared.datacargo.BulkActionRequest;
import com.numhero.shared.enums.InvoiceStatusEnum;
import com.numhero.shared.service.ApplicationCommandEnum;

public class ChangeStatusOfDocumentsRequest extends BulkActionRequest {
    private InvoiceStatusEnum status;

    public ChangeStatusOfDocumentsRequest() {
        setCommand(ApplicationCommandEnum.CommandChangeStatusOfDocuments);
    }

    public InvoiceStatusEnum getStatus() {
        return status;
    }

    public void setStatus(InvoiceStatusEnum status) {
        this.status = status;
    }
}
