package com.numhero.client.mvp.proxy;

import com.google.inject.Singleton;
import com.numhero.client.model.datacargo.businessaccount.SaveBusinessAccountRequest;
import com.numhero.client.model.datacargo.businessaccount.SaveBusinessAccountResponse;
import com.numhero.client.model.datacargo.businesstransaction.BusinessTransactionListRequest;
import com.numhero.client.model.datacargo.businesstransaction.BusinessTransactionListResponse;
import com.numhero.client.model.datacargo.businesstransaction.GetBusinessTransactionRequest;
import com.numhero.client.model.datacargo.businesstransaction.GetBusinessTransactionResponse;
import com.numhero.client.model.datacargo.invoice.InvoiceListRequest;
import com.numhero.client.model.datacargo.invoice.InvoiceListResponse;
import com.numhero.client.mvp.home.HomePresenter;
import com.numhero.client.mvp.home.HomeView;

@Singleton
public class HomePresenterProxy extends PresenterProxy<HomePresenter> {

    @Override
    protected HomePresenter createPresenter() {

        HomeView view = new HomeView();
        return new HomePresenter(getEventManager(),
                PresenterProxy.<InvoiceListRequest, InvoiceListResponse>createNewService(),
                PresenterProxy.<BusinessTransactionListRequest, BusinessTransactionListResponse>createNewService(),
                PresenterProxy.<GetBusinessTransactionRequest, GetBusinessTransactionResponse>createNewService(),
                view,
                PresenterProxy.<SaveBusinessAccountRequest, SaveBusinessAccountResponse>createNewService());
    }
}
