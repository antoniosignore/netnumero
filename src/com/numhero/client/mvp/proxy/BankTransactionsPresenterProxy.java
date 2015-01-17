package com.numhero.client.mvp.proxy;

import com.numhero.client.model.datacargo.banktransaction.BankTransactionListRequest;
import com.numhero.client.model.datacargo.banktransaction.BankTransactionListResponse;
import com.numhero.client.model.datacargo.banktransaction.DeleteBankTransactionsRequest;
import com.numhero.client.mvp.banktransaction.BankTransactionsPresenter;
import com.numhero.shared.datacargo.BulkActionResponse;

public class BankTransactionsPresenterProxy extends PresenterProxy<BankTransactionsPresenter> {
    @Override
    protected BankTransactionsPresenter createPresenter() {
        return new BankTransactionsPresenter(getEventManager(),
                PresenterProxy.<BankTransactionListRequest, BankTransactionListResponse>createNewService(),
                PresenterProxy.<DeleteBankTransactionsRequest, BulkActionResponse>createNewService(),
                getConstants());
    }
}
