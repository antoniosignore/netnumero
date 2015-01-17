package com.numhero.client.mvp.document;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.numhero.client.ClientCache;
import com.numhero.client.model.datacargo.invoice.GetInvoiceRequest;
import com.numhero.client.model.datacargo.invoice.SaveInvoiceRequest;
import com.numhero.client.model.datacargo.invoice.SendInvoiceRequest;
import com.numhero.client.model.pojoc.Invoice;
import com.numhero.client.place.PlaceManager;
import com.numhero.client.service.Service;
import com.numhero.shared.datacargo.GetSingleEntityResponse;
import com.numhero.shared.datacargo.SaveSingleEntityResponse;
import com.numhero.shared.enums.InvoiceStatusEnum;
import com.numhero.shared.enums.InvoiceTypeEnum;

import java.util.Date;

@Singleton
public class InvoicePresenter extends AbstractInvoicePresenter {

    private InvoiceConstants constants;

    @Inject
    public InvoicePresenter(PlaceManager eventManager,
                            Service<GetInvoiceRequest, GetSingleEntityResponse<Invoice>> invoiceGetService,
                            Service<SaveInvoiceRequest, SaveSingleEntityResponse> invoiceSaveService,
                            Service<SendInvoiceRequest, SaveSingleEntityResponse> invoiceSendService,
                            InvoiceConstants constants,
                            InvoiceEditPageView view) {
        super(eventManager,
                invoiceGetService, invoiceSaveService, invoiceSendService, view);
        this.constants = constants;

       getView().setDetailsLabel(constants.invoiceDetails());

    }


    @Override
    protected Invoice createInvoice() {
        Invoice invoice = new Invoice();

        if (getUrl().getParam1() != null) invoice.setClientSupplierID(Long.parseLong(getUrl().getParam1()));
        if (getUrl().getParam2() != null) invoice.setClientSupplierName(getUrl().getParam2());

        invoice.setInvoiceType(InvoiceTypeEnum.Invoice);
        invoice.setDiscount(0D);
        invoice.setDateRaised(new Date());
        invoice.setInvoiceStatus(InvoiceStatusEnum.Draft);
        invoice.setPrice(0D);
        if (ClientCache.getCurrentBA() != null) {
            invoice.fName.setValue(ClientCache.getCurrentBA().fPrefix.getValue() + "---");
            invoice.fDateDue.setValue(new Date(System.currentTimeMillis() + ((long) ClientCache.getCurrentBA().fDefaultDaysDue.getValue()) * 24 * 60 * 60 * 1000));
            invoice.fCurrency.setValue(ClientCache.getCurrentBA().fCurrency.getValue());
            invoice.fTermsConditions.setValue(ClientCache.getCurrentBA().fTermsConditions.getValue());
        }
        return invoice;
    }


    @Override
    public String getDetailTitlePanelNewEntity() {
        return constants.createAnInvoice();
    }

    @Override
    public String getDetailTitlePanelEditEntity() {
        return constants.editInvoice();
    }

    @Override
    protected String getDetailTitlePanelViewEntity() {
        return constants.viewInvoice();
    }


    @Override
    protected String getReturnUrl() {
        return "invoices";
    }


}
