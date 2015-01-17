package com.numhero.server.command;

import com.google.inject.Inject;
import com.numhero.client.model.datacargo.banktransaction.SaveBankTransactionRequest;
import com.numhero.client.model.datacargo.banktransaction.SaveBankTransactionResponse;
import com.numhero.client.model.pojoc.BankAccount;
import com.numhero.client.model.pojoc.BankTransaction;
import com.numhero.server.model.daolite.BankAccountDao;
import com.numhero.server.model.daolite.BankTransactionDao;
import com.numhero.server.service.DoubleEntryProcessor;
import com.numhero.server.utils.DaoUtils;
import com.numhero.shared.enums.TransactionEnum;

import java.util.logging.Logger;

public class CommandSaveBankTransaction extends AbstractAuthenticatedCommand<SaveBankTransactionRequest, SaveBankTransactionResponse> {
    @SuppressWarnings("unused")
    private static final Logger log = Logger.getLogger(CommandSaveBankTransaction.class.getName());

    @Inject
    BankTransactionDao bankTransactionDao;

    @Inject
    BankAccountDao bankAccountDao;

    @Inject
    DoubleEntryProcessor doubleEntryProcessor;

    @Override
    public SaveBankTransactionResponse execute(SaveBankTransactionRequest request) {

        BankTransaction bankTransaction = (BankTransaction) request.getEntity();
        DaoUtils.setData(request, bankTransaction);
        bankTransactionDao.save(bankTransaction);
        doubleEntryProcessor.processDirectPayment(getBusinessAccount(), bankTransaction);

        log.info("bankTransaction.fBankAccountId = " + bankTransaction.fBankAccountId);

        BankAccount bankAccount = bankAccountDao.get(bankTransaction.fBankAccountId.getValue());
        if (bankTransaction.fType.getValue() == TransactionEnum.deposit) {
            bankAccount.fValue.setValue(bankAccount.fValue.getValue() + bankTransaction.fValue.getValue());
        } else {
            bankAccount.fValue.setValue(bankAccount.fValue.getValue() - bankTransaction.fValue.getValue());
        }

        bankAccountDao.save(bankAccount);

        SaveBankTransactionResponse response = new SaveBankTransactionResponse();
        response.setEntityId(bankTransaction.getId());
        return response;
    }
}
