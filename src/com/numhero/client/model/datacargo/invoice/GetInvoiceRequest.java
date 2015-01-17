package com.numhero.client.model.datacargo.invoice;

import com.numhero.shared.datacargo.GetSingleEntityRequest;
import com.numhero.shared.service.ApplicationCommandEnum;

public class GetInvoiceRequest extends GetSingleEntityRequest {

    public GetInvoiceRequest() {
        setCommand(ApplicationCommandEnum.CommandGetInvoice);
    }

    public GetInvoiceRequest(Long id) {
    	this();
        setEntityId(id);
    }
}
