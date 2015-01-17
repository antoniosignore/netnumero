package com.numhero.client.mvp.proxy;

import com.numhero.client.model.datacargo.category.CategoryListRequest;
import com.numhero.client.model.datacargo.category.CategoryListResponse;
import com.numhero.client.model.datacargo.category.SaveCategoryRequest;
import com.numhero.client.model.datacargo.client_supplier.ClientSupplierListResponse;
import com.numhero.client.model.datacargo.client_supplier.SaveClientSupplierRequest;
import com.numhero.client.model.datacargo.client_supplier.SupplierListRequest;
import com.numhero.client.model.datacargo.currency.GetCurrencyConversionRequest;
import com.numhero.client.model.datacargo.currency.GetCurrencyConversionResponse;
import com.numhero.client.model.datacargo.product.ProductListResponse;
import com.numhero.client.model.datacargo.product.ProductServicesListRequest;
import com.numhero.client.model.datacargo.product.SaveProductRequest;
import com.numhero.client.model.datacargo.product.SaveProductResponse;
import com.numhero.client.model.datacargo.taxinfo.SaveTaxInfoRequest;
import com.numhero.client.model.datacargo.taxinfo.SaveTaxInfoResponse;
import com.numhero.client.model.datacargo.taxinfo.TaxInfoListRequest;
import com.numhero.client.model.datacargo.taxinfo.TaxInfoListResponse;
import com.numhero.client.mvp.category.CategoryPanel;
import com.numhero.client.mvp.document.ExpensePresenter;
import com.numhero.client.mvp.document.InvoiceDetailsTable;
import com.numhero.shared.datacargo.SaveSingleEntityResponse;

public class ExpensePresenterProxy extends PresenterProxy<ExpensePresenter> {
    @Override
    protected ExpensePresenter createPresenter() {

        CategoryPanel panel = new CategoryPanel();
        InvoiceDetailsTable invoiceTable = new InvoiceDetailsTable(
                PresenterProxy.<ProductServicesListRequest, ProductListResponse>createNewService(),
                PresenterProxy.<SaveProductRequest, SaveProductResponse>createNewService(),
                PresenterProxy.<TaxInfoListRequest, TaxInfoListResponse>createNewService(),
                PresenterProxy.<SaveTaxInfoRequest, SaveTaxInfoResponse>createNewService(),
                PresenterProxy.<GetCurrencyConversionRequest, GetCurrencyConversionResponse>createNewService());

        return new ExpensePresenter(getEventManager(),
                PresenterProxy.<SupplierListRequest, ClientSupplierListResponse>createNewService(),
                PresenterProxy.<SaveClientSupplierRequest, SaveSingleEntityResponse>createNewService(),
                PresenterProxy.<CategoryListRequest, CategoryListResponse>createNewService(),
                PresenterProxy.<SaveCategoryRequest, SaveSingleEntityResponse>createNewService(),
                panel,
                invoiceTable,
                getConstants());
    }
}
