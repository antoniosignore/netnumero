package com.numhero.client.mvp.proxy;

import com.numhero.client.model.datacargo.category.CategoryListRequest;
import com.numhero.client.model.datacargo.category.CategoryListResponse;
import com.numhero.client.model.datacargo.category.SaveCategoryRequest;
import com.numhero.client.model.datacargo.client_supplier.ClientListRequest;
import com.numhero.client.model.datacargo.client_supplier.ClientSupplierListResponse;
import com.numhero.client.model.datacargo.client_supplier.SaveClientSupplierRequest;
import com.numhero.client.model.datacargo.expense.*;
import com.numhero.client.model.datacargo.staff.SaveStaffRequest;
import com.numhero.client.model.datacargo.staff.SaveStaffResponse;
import com.numhero.client.model.datacargo.staff.StaffListRequest;
import com.numhero.client.model.datacargo.staff.StaffListResponse;
import com.numhero.client.mvp.category.CategoryPanel;
import com.numhero.client.mvp.expense.ExpenseReceiptPanel;
import com.numhero.client.mvp.expense.ExpenseReceiptPresenter;
import com.numhero.client.mvp.staff.StaffPanel;
import com.numhero.shared.datacargo.BulkActionResponse;
import com.numhero.shared.datacargo.SaveSingleEntityResponse;

public class ExpenseReceiptPresenterProxy extends PresenterProxy<ExpenseReceiptPresenter> {
    @Override
    protected ExpenseReceiptPresenter createPresenter() {
        StaffPanel staffPanel = new StaffPanel();
        CategoryPanel categoryPanel = new CategoryPanel();
        ExpenseReceiptPanel panel = new ExpenseReceiptPanel(
                PresenterProxy.<ClientListRequest, ClientSupplierListResponse>createNewService(),
                PresenterProxy.<SaveClientSupplierRequest, SaveSingleEntityResponse>createNewService(),
                PresenterProxy.<CategoryListRequest, CategoryListResponse>createNewService(),
                PresenterProxy.<SaveCategoryRequest, SaveSingleEntityResponse>createNewService(),
                PresenterProxy.<StaffListRequest, StaffListResponse>createNewService(),
                PresenterProxy.<SaveStaffRequest, SaveStaffResponse>createNewService(),
                staffPanel, categoryPanel);
        return new ExpenseReceiptPresenter(getEventManager(),
                PresenterProxy.<GetReceiptRequest, GetReceiptResponse>createNewService(),
                PresenterProxy.<SaveReceiptRequest, SaveReceiptResponse>createNewService(),
                panel,
                PresenterProxy.<ReceiptsListRequest, ReceiptsListResponse>createNewService(),
                PresenterProxy.<DeleteReceiptsRequest, BulkActionResponse>createNewService(),
                PresenterProxy.<SetToPaidReceiptsRequest, BulkActionResponse>createNewService(),
                getConstants());
    }

}
