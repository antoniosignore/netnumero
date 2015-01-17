package com.numhero.client.mvp.report.recentTransactions;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.numhero.client.model.datacargo.businesstransaction.BusinessTransactionListRequest;
import com.numhero.client.model.datacargo.businesstransaction.BusinessTransactionListResponse;
import com.numhero.client.model.datacargo.businesstransaction.GetBusinessTransactionRequest;
import com.numhero.client.model.datacargo.businesstransaction.GetBusinessTransactionResponse;
import com.numhero.client.model.pojoc.BusinessTransaction;
import com.numhero.client.mvp.BasePresenter;
import com.numhero.client.mvp.GenericReportTabViewPage;
import com.numhero.client.place.PlaceManager;
import com.numhero.client.service.Service;
import com.numhero.client.service.ServiceCallbackImpl;

import java.util.List;

@Singleton
public class RecentTransactionsPresenter extends BasePresenter {

    private Service<BusinessTransactionListRequest, BusinessTransactionListResponse> transactionsListService;
    private Service<GetBusinessTransactionRequest, GetBusinessTransactionResponse> getBusinessTransactionService;

    @Inject
    public RecentTransactionsPresenter(PlaceManager eventManager,
                                       RecentTransactionsPanel recentTransactionsPanel,
                                       Service<BusinessTransactionListRequest, BusinessTransactionListResponse> transactionsListService,
                                       Service<GetBusinessTransactionRequest, GetBusinessTransactionResponse> getBusinessTransactionService) {
        super(eventManager, new GenericReportTabViewPage(recentTransactionsPanel));
        this.transactionsListService = transactionsListService;
        this.getBusinessTransactionService = getBusinessTransactionService;
    }

    private RecentTransactionsPanel getTransactionsPanel() {
        return ((RecentTransactionsPanel) getView().getContentPanel().getContentWidget());
    }

    @Override
    public GenericReportTabViewPage getView() {
        return (GenericReportTabViewPage) super.getView();
    }

    @Override
    public void onShow() {
        refreshFromServer();
    }

    @Override
    protected void onBind() {
        super.onBind();
    }

    @Override
    protected void onUnbind() {
        super.onUnbind();
    }

    private void refreshFromServer() {
        getTransactionsPanel().getRecentTransactionsTable().showLoading();
        BusinessTransactionListRequest request = new BusinessTransactionListRequest();
        transactionsListService.execute(request, new ServiceCallbackImpl<BusinessTransactionListResponse>() {
            @Override
            public void onSuccess(BusinessTransactionListResponse response) {
                getTransactionsPanel().getRecentTransactionsTable().setTransactions(
                        (List<BusinessTransaction>) response.getEntityList(),
                        getBusinessTransactionService);
            }
        });
    }
}
