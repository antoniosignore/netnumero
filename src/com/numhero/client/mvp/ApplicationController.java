package com.numhero.client.mvp;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.user.client.Window;
import com.numhero.client.Application;
import com.numhero.client.mvp.proxy.*;
import com.numhero.client.place.PlaceManager;
import com.numhero.client.place.PlaceRequestEvent;
import com.numhero.client.place.PlaceRequestHandler;
import com.numhero.client.place.RestUrl;

import java.util.HashMap;
import java.util.Map;

public class ApplicationController {

    private Map<String, PresenterProxy<?>> presenterProxyMap = new HashMap<String, PresenterProxy<?>>();

    private PlaceManager placeManager;

    private class MyPlaceRequestHandler implements PlaceRequestHandler {

        public void onPlaceRequest(PlaceRequestEvent event) {
            final RestUrl newPlace = event.getUrl();
            final PresenterProxy<?> pp = presenterProxyMap.get(newPlace.getPresenterUrl());

            if (pp != null) {
                Application.showGlasspanelLoading();

                GWT.runAsync(new RunAsyncCallback() {
                    public void onFailure(Throwable caught) {
                        Application.hideGlasspanelLoading();
                        Window.alert("Code split download failed!!! Please try to refresh the application.");
                    }

                    public void onSuccess() {
                        Application.hideGlasspanelLoading();
                        BasePresenter p = pp.getPresenter();
                        p.doActivation(newPlace);
                    }
                });
            }
        }
    }

    public ApplicationController() {
        prepareProxyMap();
        placeManager = Application.injector.getPlaceManager();
        placeManager.addPlaceRequestHandler(new MyPlaceRequestHandler());
    }

    private void prepareProxyMap() {
        presenterProxyMap.put("dashboard", new HomePresenterProxy());
        presenterProxyMap.put("client", new ClientPresenterProxy());
        presenterProxyMap.put("clients", new ClientsPresenterProxy());
        presenterProxyMap.put("supplier", new SupplierPresenterProxy());
        presenterProxyMap.put("suppliers", new SuppliersPresenterProxy());
        presenterProxyMap.put("moneyout", new MoneyOutPresenterProxy());
        presenterProxyMap.put("moneyin", new MoneyInPresenterProxy());
        presenterProxyMap.put("invoices", new RecentInvoicesPresenterProxy());
        presenterProxyMap.put("archived-invoices", new ArchivedInvoicesPresenterProxy());
        presenterProxyMap.put("archived-estimates", new ArchivedEstimatesPresenterProxy());
        presenterProxyMap.put("estimates", new RecentEstimatesPresenterProxy());
        presenterProxyMap.put("expenses", new RecentExpensesPresenterProxy());
        presenterProxyMap.put("invoice", new InvoicePresenterProxy());
        presenterProxyMap.put("estimate", new EstimatePresenterProxy());
        presenterProxyMap.put("expense", new ExpensePresenterProxy());
        presenterProxyMap.put("pettyexpense", new ExpenseReceiptPresenterProxy());
        presenterProxyMap.put("businessaccount", new BusinessAccountPresenterProxy());
        presenterProxyMap.put("projects", new ProjectsPresenterProxy());
        presenterProxyMap.put("project", new ProjectPresenterProxy());
        presenterProxyMap.put("task", new TaskPresenterProxy());
        presenterProxyMap.put("tasks", new TasksPresenterProxy());
        presenterProxyMap.put("timeentry", new TimeEntryPresenterProxy());
        presenterProxyMap.put("timeentries", new TimeEntriesPresenterProxy());
        presenterProxyMap.put("internal", new InternalPresenterProxy());
        presenterProxyMap.put("contractor", new ContractorPresenterProxy());
        presenterProxyMap.put("internals", new InternalsPresenterProxy());
        presenterProxyMap.put("contractors", new ContractorsPresenterProxy());
        presenterProxyMap.put("user", new UserPresenterProxy());
        presenterProxyMap.put("users", new UsersPresenterProxy());
        presenterProxyMap.put("product", new ProductPresenterProxy());
        presenterProxyMap.put("products", new ProductsPresenterProxy());
        presenterProxyMap.put("service", new ServicePresenterProxy());
        presenterProxyMap.put("services", new ServicesPresenterProxy());
        presenterProxyMap.put("bankaccount", new BankAccountPresenterProxy());
        presenterProxyMap.put("bankaccounts", new BankAccountsPresenterProxy());
        presenterProxyMap.put("category", new CategoryPresenterProxy());
        presenterProxyMap.put("categories", new CategoriesPresenterProxy());
//        presenterProxyMap.put("paid-expenses", new PaidExpensesPresenterProxy());
//        presenterProxyMap.put("unpaid-expenses", new UnpaidExpensesPresenterProxy());
        presenterProxyMap.put("staff-receipts", new BilledExpensesPresenterProxy());
//        presenterProxyMap.put("unbilled-expenses", new UnbilledExpensesPresenterProxy());
        presenterProxyMap.put("bank-transaction", new BankTransactionPresenterProxy());
        presenterProxyMap.put("bank-transactions", new BankTransactionsPresenterProxy());
        presenterProxyMap.put("profit-loss", new ProfitLossPresenterProxy());
        presenterProxyMap.put("recent-transactions", new RecentTransactionsPresenterProxy());
        presenterProxyMap.put("chart-accounts", new ChartOfAccountsPresenterProxy());
        presenterProxyMap.put("trial-balance", new TrialBalancePresenterProxy());
        presenterProxyMap.put("taxinfo", new TaxInfoPresenterProxy());
        presenterProxyMap.put("taxinfos", new TaxInfosPresenterProxy());
        presenterProxyMap.put("sales-tax", new TaxesPresenterProxy());
        presenterProxyMap.put("receivables", new ReceivablesPresenterProxy());
        presenterProxyMap.put("deposits", new DepositsPresenterProxy());
        presenterProxyMap.put("sales-vat", new VATPresenterProxy());
        presenterProxyMap.put("reimburse-staff", new ReimbursableStaffPresenterProxy());
        presenterProxyMap.put("search", new SearchPresenterProxy());
    }
}
