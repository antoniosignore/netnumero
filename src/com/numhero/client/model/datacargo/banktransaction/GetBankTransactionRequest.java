package com.numhero.client.model.datacargo.banktransaction;


import com.numhero.shared.datacargo.GetSingleEntityRequest;
import com.numhero.shared.service.ApplicationCommandEnum;

public class GetBankTransactionRequest extends GetSingleEntityRequest {

    public GetBankTransactionRequest() {
        setCommand(ApplicationCommandEnum.CommandGetBankTransaction);
    }

}
