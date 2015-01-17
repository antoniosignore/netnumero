package com.numhero.client.mvp.document;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.numhero.client.ClientCache;
import com.numhero.client.model.datacargo.client_supplier.ClientListRequest;
import com.numhero.client.model.datacargo.client_supplier.ClientSupplierListResponse;
import com.numhero.client.model.datacargo.client_supplier.SaveClientSupplierRequest;
import com.numhero.client.model.datacargo.invoice.GetInvoiceRequest;
import com.numhero.client.model.datacargo.invoice.SaveInvoiceRequest;
import com.numhero.client.model.datacargo.invoice.SendInvoiceRequest;
import com.numhero.client.model.pojoc.Invoice;
import com.numhero.client.mvp.clientsupplier.ClientSelect;
import com.numhero.client.place.PlaceManager;
import com.numhero.client.service.Service;
import com.numhero.shared.datacargo.GetSingleEntityResponse;
import com.numhero.shared.datacargo.SaveSingleEntityResponse;
import com.numhero.shared.enums.InvoiceStatusEnum;
import com.numhero.shared.enums.InvoiceTypeEnum;

import java.util.Date;

@Singleton
public class EstimatePresenter extends AbstractInvoicePresenter {
    private InvoiceConstants constants;

    @Inject
    public EstimatePresenter(PlaceManager eventManager,
                             Service<GetInvoiceRequest, GetSingleEntityResponse<Invoice>> invoiceGetService,
                             Service<SaveInvoiceRequest, SaveSingleEntityResponse> invoiceSaveService,
                             Service<SendInvoiceRequest, SaveSingleEntityResponse> invoiceSendService,
                             Service<ClientListRequest, ClientSupplierListResponse> clientSuppliersListService,
                             Service<SaveClientSupplierRequest, SaveSingleEntityResponse> clientSupplierSaveService,
                             InvoiceDetailsTable invoiceTable,
                             InvoiceConstants constants) {
        super(eventManager,
                invoiceGetService, invoiceSaveService, invoiceSendService, new GenericInvoiceEditTabbedPage(
         new EstimatePanel(new ClientSelect(null, clientSuppliersListService, clientSupplierSaveService), invoiceTable)));
        this.constants = constants;

        getView().setDetailsLabel(constants.estimateDetails());

    }


    @Override
    protected Invoice createInvoice() {
        Invoice ret = new Invoice();

        if (getUrl().getParam1() != null) ret.setClientSupplierID(Long.parseLong(getUrl().getParam1()));
        if (getUrl().getParam2() != null) ret.setClientSupplierName(getUrl().getParam2());

        ret.setInvoiceType(InvoiceTypeEnum.Estimate);
        ret.setDiscount(0D);
        ret.setDateRaised(new Date());
        ret.setInvoiceStatus(InvoiceStatusEnum.Draft);
        ret.setPrice(0D);
        if (ClientCache.getCurrentBA() != null) {
            ret.fName.setValue("Estimate---");
            ret.fDateDue.setValue(new Date(System.currentTimeMillis() + ((long) ClientCache.getCurrentBA().fDefaultDaysDue.getValue()) * 24 * 60 * 60 * 1000));
            ret.fCurrency.setValue(ClientCache.getCurrentBA().fCurrency.getValue());
            ret.fTermsConditions.setValue(ClientCache.getCurrentBA().fTermsConditions.getValue());
        }
        return ret;
    }

    @Override
    protected String getDetailTitlePanelNewEntity() {
        return constants.newEstimate();
    }

    @Override
    protected String getDetailTitlePanelEditEntity() {
        return constants.editEstimate();
    }

    @Override
    protected String getDetailTitlePanelViewEntity() {
        return constants.viewInvoice();
    }


    @Override
    protected String getReturnUrl() {
        return "estimates";
    }


}
