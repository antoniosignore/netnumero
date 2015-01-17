package com.numhero.client.mvp.proxy;

import com.numhero.client.model.datacargo.client_supplier.ClientListRequest;
import com.numhero.client.model.datacargo.client_supplier.ClientSupplierListResponse;
import com.numhero.client.model.datacargo.client_supplier.SaveClientSupplierRequest;
import com.numhero.client.model.datacargo.expense.ReceiptsListRequest;
import com.numhero.client.model.datacargo.expense.ReceiptsListResponse;
import com.numhero.client.mvp.report.expenses.StaffExpensesPanel;
import com.numhero.client.mvp.report.expenses.StaffExpensesPresenter;
import com.numhero.shared.datacargo.SaveSingleEntityResponse;

public class BilledExpensesPresenterProxy extends PresenterProxy<StaffExpensesPresenter> {
    @Override
    protected StaffExpensesPresenter createPresenter() {
        StaffExpensesPanel panel = new StaffExpensesPanel(
                PresenterProxy.<ClientListRequest, ClientSupplierListResponse>createNewService(),
                PresenterProxy.<SaveClientSupplierRequest, SaveSingleEntityResponse>createNewService());
        return new StaffExpensesPresenter(getEventManager(),
                panel,
                PresenterProxy.<ReceiptsListRequest, ReceiptsListResponse>createNewService());
    }
}
