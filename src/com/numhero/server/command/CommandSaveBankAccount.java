package com.numhero.server.command;

import com.google.inject.Inject;
import com.numhero.client.model.datacargo.bankaccount.SaveBankAccountRequest;
import com.numhero.client.model.datacargo.bankaccount.SaveBankAccountResponse;
import com.numhero.client.model.pojoc.BankAccount;
import com.numhero.server.model.daolite.BankAccountDao;
import com.numhero.server.utils.DaoUtils;

import java.util.logging.Logger;

public class CommandSaveBankAccount extends AbstractAuthenticatedCommand<SaveBankAccountRequest, SaveBankAccountResponse> {
    @SuppressWarnings("unused")
    private static final Logger log = Logger.getLogger(CommandSaveBankAccount.class.getName());

    @Inject
    BankAccountDao bankAccountDao;

    @Override
    public SaveBankAccountResponse execute(SaveBankAccountRequest request) {

        BankAccount bankAccount = (BankAccount) request.getEntity();

        DaoUtils.setData(request, bankAccount);
        bankAccountDao.save(bankAccount);

        // createAudit
        SaveBankAccountResponse response = new SaveBankAccountResponse();
        response.setEntityId(bankAccount.getId());
        return response;
    }
}
