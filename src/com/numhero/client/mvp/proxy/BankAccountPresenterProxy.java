package com.numhero.client.mvp.proxy;

import com.numhero.client.model.datacargo.bankaccount.GetBankAccountRequest;
import com.numhero.client.model.datacargo.bankaccount.GetBankAccountResponse;
import com.numhero.client.model.datacargo.bankaccount.SaveBankAccountRequest;
import com.numhero.client.model.datacargo.bankaccount.SaveBankAccountResponse;
import com.numhero.client.mvp.bankaccount.BankAccountPresenter;

public class BankAccountPresenterProxy extends PresenterProxy<BankAccountPresenter> {
    @Override
    protected BankAccountPresenter createPresenter() {
        return new BankAccountPresenter(getEventManager(),
                PresenterProxy.<GetBankAccountRequest, GetBankAccountResponse>createNewService(),
                PresenterProxy.<SaveBankAccountRequest, SaveBankAccountResponse>createNewService(),
                getConstants());
    }
}
