package com.numhero.client.mvp.banktransaction;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.numhero.client.model.datacargo.banktransaction.BankTransactionListRequest;
import com.numhero.client.model.datacargo.banktransaction.BankTransactionListResponse;
import com.numhero.client.model.datacargo.banktransaction.DeleteBankTransactionsRequest;
import com.numhero.client.mvp.GenericMoneyinTabGridPage;
import com.numhero.client.mvp.GridPresenter;
import com.numhero.client.place.PlaceManager;
import com.numhero.client.service.Service;
import com.numhero.client.service.ServiceCallbackImpl;
import com.numhero.shared.datacargo.BulkActionResponse;

@Singleton
public class BankTransactionsPresenter extends GridPresenter {

    private Service<BankTransactionListRequest, BankTransactionListResponse> listService;
    private Service<DeleteBankTransactionsRequest, BulkActionResponse> deleteBankTransactionsService;

    @Inject
    public BankTransactionsPresenter(PlaceManager eventManager,
                                     Service<BankTransactionListRequest, BankTransactionListResponse> listService,
                                     Service<DeleteBankTransactionsRequest, BulkActionResponse> deleteBankTransactionsService, BankTransConstants constants) {
        super(eventManager, new GenericMoneyinTabGridPage(new BankTransactionsTable()));

        this.listService = listService;
        this.deleteBankTransactionsService = deleteBankTransactionsService;  //todo to be completed with delete action

        getView().setDetailTitlePanel(constants.bankTransactions());
    }

    protected void refreshFromServer() {
        BankTransactionListRequest request = new BankTransactionListRequest();
        setPagination(request);

        super.refreshFromServer();
        listService.execute(request, new ServiceCallbackImpl<BankTransactionListResponse>() {
            @Override
            public void onSuccess(BankTransactionListResponse response) {

                getView().putEntitiesInGrid(response);

            }
        });
    }
}
