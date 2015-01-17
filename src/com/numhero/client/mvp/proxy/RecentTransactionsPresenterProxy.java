package com.numhero.client.mvp.proxy;

import com.numhero.client.model.datacargo.businesstransaction.BusinessTransactionListRequest;
import com.numhero.client.model.datacargo.businesstransaction.BusinessTransactionListResponse;
import com.numhero.client.model.datacargo.businesstransaction.GetBusinessTransactionRequest;
import com.numhero.client.model.datacargo.businesstransaction.GetBusinessTransactionResponse;
import com.numhero.client.mvp.report.recentTransactions.RecentTransactionsPanel;
import com.numhero.client.mvp.report.recentTransactions.RecentTransactionsPresenter;
import com.numhero.client.service.Service;

public class RecentTransactionsPresenterProxy extends PresenterProxy<RecentTransactionsPresenter> {
    @Override
    protected RecentTransactionsPresenter createPresenter() {

        Service<GetBusinessTransactionRequest, GetBusinessTransactionResponse> transGetService = createNewService();
        Service<BusinessTransactionListRequest, BusinessTransactionListResponse> transListService = createNewService();
        RecentTransactionsPanel panel = new RecentTransactionsPanel();
        return new RecentTransactionsPresenter(getEventManager(), panel, transListService, transGetService);
    }
}
