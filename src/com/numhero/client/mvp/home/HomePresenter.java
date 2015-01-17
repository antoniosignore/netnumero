package com.numhero.client.mvp.home;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.numhero.client.ClientCache;
import com.numhero.client.model.datacargo.businessaccount.SaveBusinessAccountRequest;
import com.numhero.client.model.datacargo.businessaccount.SaveBusinessAccountResponse;
import com.numhero.client.model.datacargo.businesstransaction.BusinessTransactionListRequest;
import com.numhero.client.model.datacargo.businesstransaction.BusinessTransactionListResponse;
import com.numhero.client.model.datacargo.businesstransaction.GetBusinessTransactionRequest;
import com.numhero.client.model.datacargo.businesstransaction.GetBusinessTransactionResponse;
import com.numhero.client.model.datacargo.invoice.InvoiceListRequest;
import com.numhero.client.model.datacargo.invoice.InvoiceListResponse;
import com.numhero.client.model.pojoc.BusinessTransaction;
import com.numhero.client.mvp.BasePresenter;
import com.numhero.client.mvp.wizard.WizardDialog;
import com.numhero.client.place.PlaceManager;
import com.numhero.client.service.Service;
import com.numhero.client.service.ServiceCallbackImpl;
import com.numhero.client.util.CoreUtils;
import com.numhero.shared.enums.InvoiceTypeEnum;

import java.util.List;

@Singleton
public class HomePresenter extends BasePresenter {

    private Service<InvoiceListRequest, InvoiceListResponse> invoiceListService;
    private Service<BusinessTransactionListRequest, BusinessTransactionListResponse> transactionsListService;
    private Service<GetBusinessTransactionRequest, GetBusinessTransactionResponse> getBusinessTransactionService;
    private Service<SaveBusinessAccountRequest,SaveBusinessAccountResponse> businessAccountSaveService;

    @Inject
    public HomePresenter(PlaceManager eventManager,
                         Service<InvoiceListRequest, InvoiceListResponse> invoiceListService,
                         Service<BusinessTransactionListRequest, BusinessTransactionListResponse> transactionsListService,
                         Service<GetBusinessTransactionRequest, GetBusinessTransactionResponse> getBusinessTransactionService,
                         HomeView view, Service<SaveBusinessAccountRequest, SaveBusinessAccountResponse> businessAccountSaveService) {
        super(eventManager, view);
        this.invoiceListService = invoiceListService;
        this.transactionsListService = transactionsListService;
        this.getBusinessTransactionService = getBusinessTransactionService;
        this.businessAccountSaveService = businessAccountSaveService;
    }

    @Override
    public void onShow() {
        WizardDialog dlg = null;
        CoreUtils.debug("ClientCache.getCurrentUser().getLastLogin() = " + ClientCache.getCurrentUser().getLastLogin());
        if (ClientCache.getCurrentUser().getLastLogin() == null) {
            dlg = new WizardDialog(businessAccountSaveService);
            dlg.center();
        }
        refreshFromServer();
    }

    @Override
    public HomeView getView() {
        return (HomeView) super.getView();
    }

    protected void refreshFromServer() {
        getView().getContent().getInvoicesRecapPanel().showLoading();
        getView().getContent().getExpensesRecapPanel().showLoading();
        getView().getContent().getRecentTransactionsTable().showLoading();

        InvoiceListRequest request = new InvoiceListRequest(InvoiceTypeEnum.Invoice);
        invoiceListService.execute(request, new ServiceCallbackImpl<InvoiceListResponse>() {
            @Override
            public void onSuccess(InvoiceListResponse response) {
                InvoicesRecapTable table = getView().getContent().getInvoicesRecapPanel();
                table.setEntities(response.getEntityList());
            }
        });

        InvoiceListRequest requestExpenses = new InvoiceListRequest(InvoiceTypeEnum.Expense);
        invoiceListService.execute(requestExpenses, new ServiceCallbackImpl<InvoiceListResponse>() {
            @Override
            public void onSuccess(InvoiceListResponse response) {
                ExpensesRecapTable table = getView().getContent().getExpensesRecapPanel();
                table.setEntities(response.getEntityList());
            }
        });

        BusinessTransactionListRequest request2 = new BusinessTransactionListRequest();
        transactionsListService.execute(request2, new ServiceCallbackImpl<BusinessTransactionListResponse>() {
            @Override
            public void onSuccess(BusinessTransactionListResponse response) {
                HomeRecentTransactionsTable table = getView().getContent().getRecentTransactionsTable();
                table.setTransactions((List<BusinessTransaction>) response.getEntityList(), getBusinessTransactionService);
            }
        });
    }
}
