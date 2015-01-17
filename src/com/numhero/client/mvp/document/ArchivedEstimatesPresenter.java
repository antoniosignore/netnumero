package com.numhero.client.mvp.document;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.numhero.client.model.datacargo.invoice.InvoiceListRequest;
import com.numhero.client.model.datacargo.invoice.InvoiceListResponse;
import com.numhero.client.mvp.GenericMoneyinTabGridPage;
import com.numhero.client.mvp.GridPresenter;
import com.numhero.client.place.PlaceManager;
import com.numhero.client.service.Service;
import com.numhero.client.service.ServiceCallbackImpl;
import com.numhero.shared.enums.InvoiceStatusEnum;
import com.numhero.shared.enums.InvoiceTypeEnum;

@Singleton
public class ArchivedEstimatesPresenter extends GridPresenter {

    private Service<InvoiceListRequest, InvoiceListResponse> invoiceListService;

    @Inject
    public ArchivedEstimatesPresenter(PlaceManager eventManager,
                                      Service<InvoiceListRequest, InvoiceListResponse> invoiceListService, InvoiceConstants constants
    ) {
        super(eventManager, new GenericMoneyinTabGridPage(new InvoicesTable()));
        this.invoiceListService = invoiceListService;
        getView().setDetailTitlePanel(constants.archivedEstimates());
    }

    protected void refreshFromServer() {
        InvoiceListRequest request = new InvoiceListRequest(InvoiceTypeEnum.Estimate, InvoiceStatusEnum.Archived);
        setPagination(request);

        super.refreshFromServer();
        invoiceListService.execute(request, new ServiceCallbackImpl<InvoiceListResponse>() {
            @Override
            public void onSuccess(InvoiceListResponse response) {
                getView().putEntitiesInGrid(response);

            }
        });
    }
}
