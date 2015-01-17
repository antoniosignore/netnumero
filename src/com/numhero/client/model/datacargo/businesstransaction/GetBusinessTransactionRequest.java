package com.numhero.client.model.datacargo.businesstransaction;


import com.numhero.shared.datacargo.GetSingleEntityRequest;
import com.numhero.shared.service.ApplicationCommandEnum;

public class GetBusinessTransactionRequest extends GetSingleEntityRequest {

    public GetBusinessTransactionRequest() {
        setCommand(ApplicationCommandEnum.CommandGetBusinessTransaction);
    }

}
