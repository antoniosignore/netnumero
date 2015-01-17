package com.numhero.client.mvp.proxy;

import com.numhero.client.model.datacargo.client_supplier.ClientListRequest;
import com.numhero.client.model.datacargo.client_supplier.ClientSupplierListResponse;
import com.numhero.client.model.datacargo.client_supplier.SaveClientSupplierRequest;
import com.numhero.client.model.datacargo.currency.GetCurrencyConversionRequest;
import com.numhero.client.model.datacargo.currency.GetCurrencyConversionResponse;
import com.numhero.client.model.datacargo.invoice.GetInvoiceRequest;
import com.numhero.client.model.datacargo.invoice.SaveInvoiceRequest;
import com.numhero.client.model.datacargo.invoice.SendInvoiceRequest;
import com.numhero.client.model.datacargo.product.ProductListResponse;
import com.numhero.client.model.datacargo.product.ProductServicesListRequest;
import com.numhero.client.model.datacargo.product.SaveProductRequest;
import com.numhero.client.model.datacargo.product.SaveProductResponse;
import com.numhero.client.model.datacargo.taxinfo.SaveTaxInfoRequest;
import com.numhero.client.model.datacargo.taxinfo.SaveTaxInfoResponse;
import com.numhero.client.model.datacargo.taxinfo.TaxInfoListRequest;
import com.numhero.client.model.datacargo.taxinfo.TaxInfoListResponse;
import com.numhero.client.model.pojoc.Invoice;
import com.numhero.client.mvp.clientsupplier.ClientSelect;
import com.numhero.client.mvp.document.*;
import com.numhero.client.service.Service;
import com.numhero.shared.datacargo.GetSingleEntityResponse;
import com.numhero.shared.datacargo.SaveSingleEntityResponse;

public class InvoicePresenterProxy extends PresenterProxy<InvoicePresenter> {
    @Override
    protected InvoicePresenter createPresenter() {

        Service<SaveClientSupplierRequest,SaveSingleEntityResponse> clientSaveService= createNewService();
        Service<ClientListRequest,ClientSupplierListResponse> clientListService= createNewService();
        InvoiceDetailsTable invoiceTable = new InvoiceDetailsTable(
                PresenterProxy.<ProductServicesListRequest, ProductListResponse>createNewService(),
                PresenterProxy.<SaveProductRequest, SaveProductResponse>createNewService(),
                PresenterProxy.<TaxInfoListRequest, TaxInfoListResponse>createNewService(),
                PresenterProxy.<SaveTaxInfoRequest, SaveTaxInfoResponse>createNewService(),
                PresenterProxy.<GetCurrencyConversionRequest, GetCurrencyConversionResponse>createNewService());

        InvoicePanel panel = new InvoicePanel(new ClientSelect(null, clientListService, clientSaveService), invoiceTable);
        InvoiceEditPageView view = new GenericInvoiceEditTabbedPage(panel);
        Service<GetInvoiceRequest,GetSingleEntityResponse<Invoice>> getService= createNewService();
        Service<SaveInvoiceRequest, SaveSingleEntityResponse> saveService= createNewService();
        Service<SendInvoiceRequest, SaveSingleEntityResponse> sendService= createNewService();
        return new InvoicePresenter(getEventManager(),
                getService,
                saveService,
                sendService,
                getConstants(),
                view);

    }
}
