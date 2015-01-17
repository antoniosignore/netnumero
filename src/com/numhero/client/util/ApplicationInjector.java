package com.numhero.client.util;

import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import com.numhero.client.ClientCache;
import com.numhero.client.mvp.ApplicationController;
import com.numhero.client.place.PlaceManager;
import com.numhero.client.service.DataServiceAsync;

import java.util.Map;

@GinModules(com.numhero.client.util.ApplicationModule.class)
public interface ApplicationInjector extends Ginjector {

    // utility objects
    ClientCache getClientCache();

    ApplicationController getApplicationController();

    PlaceManager getPlaceManager();

    Map<String, String> getRestURLsMap();


    DataServiceAsync getAsyncService();

//    // presenters
//    HomePresenter getHomePresenter();
//
//    SupplierPresenter getSupplierPresenter();
//
//    ArchivedEstimatesPresenter getArchivedEstimatesPresenter();
//
//    ArchivedInvoicesPresenter getArchivedInvoicesPresenter();
//
//    BankAccountPresenter getBankAccountPresenter();
//
//    BankAccountsPresenter getBankAccountsPresenter();
//
//    BankTransactionPresenter getBankTransactionPresenter();
//
//    BankTransactionsPresenter getBankTransactionsPresenter();
//
//    StaffExpensesPresenter getBilledExpensesPresenter();
//
//    BusinessAccountPresenter getBusinessAccountPresenter();
//
//    VATPresenter getVATPresenter();
//
//    ChartOfAccountsPresenter getChartOfAccountsPresenter();
//
//    ContractorPresenter getContractorPresenter();
//
//    ContractorsPresenter getContractorsPresenter();
//
//    DepositsPresenter getDepositsPresenter();
//
//    EstimatePresenter getEstimatePresenter();
//
//    ExpensePresenter getExpensePresenter();
//
//    ExpenseReceiptPresenter getExpenseReceiptPresenter();
//
//    InternalPresenter getInternalPresenter();
//
//    InternalsPresenter getInternalsPresenter();
//
////    InvoicePresenter getInvoicePresenter();
//
//    MoneyinPresenter getMoneyinPresenter();
//
//    MoneyOutPresenter getMoneyOutPresenter();
//
//    ProductPresenter getProductPresenter();
//
//    ProductsPresenter getProductsPresenter();
//
//    ProfitLossPresenter getProfitLossPresenter();
//
//    ProjectPresenter getProjectPresenter();
//
//    ProjectsPresenter getProjectsPresenter();
//
//    ReceivablesPresenter getReceivablesPresenter();
//
//    RecentEstimatesPresenter getRecentEstimatesPresenter();
//
//    RecentExpensesPresenter getRecentExpensesPresenter();
//
////    RecentInvoicesPresenter getRecentInvoicesPresenter();
//
//    RecentTransactionsPresenter getRecentTransactionsPresenter();
//
//    ReimbursableStaffPresenter getReimbursableStaffPresenter();
//
//    ServicePresenter getServicePresenter();
//
//    ServicesPresenter getServicesPresenter();
//
//    TaskPresenter getTaskPresenter();
//
//    TasksPresenter getTasksPresenter();
//
//    TaxesPresenter getTaxesPresenter();
//
//    TaxInfoPresenter getTaxInfoPresenter();
//
//    TaxInfosPresenter getTaxInfosPresenter();
//
//    TimeEntriesPresenter getTimeEntriesPresenter();
//
//    TimeEntryPresenter getTimeEntryPresenter();
//
//    TrialBalancePresenter getTrialBalancePresenter();
//
//    UserPresenter getUserPresenter();
//
//    UsersPresenter getUsersPresenter();
//
//	SearchPresenter getSearchPresenter();
//
//    // widgets & panels
//    InvoiceDetailsTable getInvoiceDetailsTable();
//
//    FeedbackPanel getFeedbackPanel();
//
//    FeedbackDialog getFeedbackDialog();
//
//    ReportBugPanel getReportBugPanel();
//
//    ReportBugDialog getReportBugDialog();
//
//    BusinessAccountPanel getBusinessAccountPanel();
//
//    // services
//    GetCurrenciesService getGetCurrenciesService();
//
//    Service<GetCurrencyConversionRequest, GetCurrencyConversionResponse> getConversionService();
//
//    Service<SaveBusinessAccountRequest, SaveBusinessAccountResponse> getBusinessAccountSaveService();
//
//
//    PlaceManager getEventManager();


}
