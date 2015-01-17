package com.numhero.client.mvp.document;

import com.numhero.client.Application;
import com.numhero.client.model.datacargo.invoice.ChangeStatusOfDocumentsRequest;
import com.numhero.client.model.datacargo.invoice.DeleteDocumentsRequest;
import com.numhero.client.model.datacargo.invoice.InvoiceListRequest;
import com.numhero.client.model.datacargo.invoice.InvoiceListResponse;
import com.numhero.client.mvp.GridPresenter;
import com.numhero.client.mvp.GridTabbedPage;
import com.numhero.client.place.PlaceManager;
import com.numhero.client.service.Service;
import com.numhero.client.service.ServiceCallbackImpl;
import com.numhero.client.util.ClientDialogUtils;
import com.numhero.client.util.ClientUtils;
import com.numhero.shared.datacargo.BulkActionResponse;
import com.numhero.shared.enums.InvoiceStatusEnum;
import com.numhero.shared.enums.InvoiceTypeEnum;

import java.util.List;

public abstract class RecentDocumentsPresenter extends GridPresenter {
    protected Service<InvoiceListRequest, InvoiceListResponse> invoiceListService;
    private Service<DeleteDocumentsRequest, BulkActionResponse> deleteDocumentsService;
    private Service<ChangeStatusOfDocumentsRequest, BulkActionResponse> changeStatusService;
    protected InvoiceTypeEnum type;


    public RecentDocumentsPresenter(PlaceManager eventManager,
                                    Service<InvoiceListRequest, InvoiceListResponse> invoiceListService,
                                    Service<DeleteDocumentsRequest, BulkActionResponse> deleteDocumentsService,
                                    Service<ChangeStatusOfDocumentsRequest, BulkActionResponse> changeStatusService,
                                    GridTabbedPage view,
                                    InvoiceTypeEnum type
    ) {
        super(eventManager, view);
        this.invoiceListService = invoiceListService;
        this.deleteDocumentsService = deleteDocumentsService;
        this.changeStatusService = changeStatusService;
        this.type = type;
    }


    protected void deleteDocuments(List<Long> ids) {
        if (ClientUtils.warnNotEmptyIds(ids, getView())) return;
        DeleteDocumentsRequest request = new DeleteDocumentsRequest();
        request.setEntityIdList(ids);
        deleteDocumentsService.execute(request, new ServiceCallbackImpl<BulkActionResponse>() {
            @Override
            public void onSuccess(BulkActionResponse response) {
                if (!response.getFailureIdList().isEmpty()) {
                    ClientDialogUtils.showGeneralError();
                } else {
                    Application.toasterMessage(Application.getConstants().documentsDeleted());
                }
                refreshFromServer();
            }
        });
    }

    protected void changeStatusTo(InvoiceStatusEnum status, List<Long> ids) {
        if (ClientUtils.warnNotEmptyIds(ids, getView())) return;
        ChangeStatusOfDocumentsRequest request = new ChangeStatusOfDocumentsRequest();
        request.setStatus(status);
        request.setEntityIdList(ids);
        changeStatusService.execute(request, new ServiceCallbackImpl<BulkActionResponse>() {
            @Override
            public void onSuccess(BulkActionResponse response) {
                if (!response.getFailureIdList().isEmpty()) {
                    ClientDialogUtils.showGeneralError();
                }
                refreshFromServer();
            }
        });
    }


    protected void refreshFromServer() {
        InvoiceListRequest request = new InvoiceListRequest(type);
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
