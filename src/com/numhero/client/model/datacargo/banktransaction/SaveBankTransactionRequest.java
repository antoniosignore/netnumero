package com.numhero.client.model.datacargo.banktransaction;


import com.numhero.client.model.pojoc.BankTransaction;
import com.numhero.shared.datacargo.SaveSingleEntityRequest;
import com.numhero.shared.service.ApplicationCommandEnum;

public class SaveBankTransactionRequest extends SaveSingleEntityRequest {

    public SaveBankTransactionRequest() {
        setCommand(ApplicationCommandEnum.CommandSaveBankTransaction);
    }

    public BankTransaction getBankTransaction() {
        return (BankTransaction) getEntity();
    }

    public void setBankTransaction(BankTransaction businessTransaction) {
        setEntity(businessTransaction);
    }

}
