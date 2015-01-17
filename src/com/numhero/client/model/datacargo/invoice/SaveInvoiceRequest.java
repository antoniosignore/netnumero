package com.numhero.client.model.datacargo.invoice;

import com.numhero.client.model.pojoc.Invoice;
import com.numhero.shared.datacargo.SaveSingleEntityRequest;
import com.numhero.shared.service.ApplicationCommandEnum;

public class SaveInvoiceRequest extends SaveSingleEntityRequest<Invoice>  {

    public SaveInvoiceRequest() {
        setCommand(ApplicationCommandEnum.CommandSaveInvoice);
    }


}
