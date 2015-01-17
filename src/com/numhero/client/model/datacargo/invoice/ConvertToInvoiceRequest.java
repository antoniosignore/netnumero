package com.numhero.client.model.datacargo.invoice;

import com.numhero.shared.datacargo.BulkActionRequest;
import com.numhero.shared.service.ApplicationCommandEnum;

public class ConvertToInvoiceRequest extends BulkActionRequest {

    public ConvertToInvoiceRequest() {
        setCommand(ApplicationCommandEnum.CommandConvertToInvoices);
    }

}