package com.numhero.client.model.datacargo.bankaccount;

import com.numhero.client.model.pojoc.BankAccount;
import com.numhero.shared.datacargo.SaveSingleEntityRequest;
import com.numhero.shared.service.ApplicationCommandEnum;

public class SaveBankAccountRequest extends SaveSingleEntityRequest {

    public SaveBankAccountRequest() {
        setCommand(ApplicationCommandEnum.CommandSaveBankAccount);
    }

    public BankAccount getBankAccount() {
        return (BankAccount) getEntity();
    }

    public void setBankAccount(BankAccount bankAccount) {
        setEntity(bankAccount);
    }

}
