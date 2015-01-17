package com.numhero.client.mvp.proxy;

import com.numhero.client.model.datacargo.bankaccount.BankAccountListRequest;
import com.numhero.client.model.datacargo.bankaccount.BankAccountListResponse;
import com.numhero.client.model.datacargo.bankaccount.DeleteBankAccountsRequest;
import com.numhero.client.mvp.bankaccount.BankAccountsPresenter;
import com.numhero.shared.datacargo.BulkActionResponse;

public class BankAccountsPresenterProxy extends PresenterProxy<BankAccountsPresenter> {
    @Override
    protected BankAccountsPresenter createPresenter() {
        return new BankAccountsPresenter(getEventManager(),
                PresenterProxy.<BankAccountListRequest, BankAccountListResponse>createNewService(),
                PresenterProxy.<DeleteBankAccountsRequest, BulkActionResponse>createNewService(),
                getConstants());
    }
}
