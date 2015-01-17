package com.numhero.client.mvp.document;

import com.google.gwt.user.client.Command;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.numhero.client.Application;
import com.numhero.client.model.datacargo.invoice.*;
import com.numhero.client.mvp.CommandWrapper;
import com.numhero.client.mvp.GenericMoneyinTabGridPage;
import com.numhero.client.place.PlaceManager;
import com.numhero.client.service.Service;
import com.numhero.client.service.ServiceCallbackImpl;
import com.numhero.client.util.ClientDialogUtils;
import com.numhero.shared.datacargo.BulkActionResponse;
import com.numhero.shared.enums.InvoiceStatusEnum;
import com.numhero.shared.enums.InvoiceTypeEnum;

import java.util.List;

@Singleton
public class RecentEstimatesPresenter extends RecentDocumentsPresenter {
    private Service<ConvertToInvoiceRequest, BulkActionResponse> convertToInvoicesService;

    @Inject
    public RecentEstimatesPresenter(PlaceManager eventManager,
                                    Service<InvoiceListRequest, InvoiceListResponse> invoiceListService,
                                    Service<DeleteDocumentsRequest, BulkActionResponse> deleteDocumentsService,
                                    Service<ConvertToInvoiceRequest, BulkActionResponse> convertToInvoicesService,
                                    Service<ChangeStatusOfDocumentsRequest, BulkActionResponse> changeStatusService, InvoiceConstants constants) {
        super(eventManager,
                invoiceListService,
                deleteDocumentsService,
                changeStatusService,
                new GenericMoneyinTabGridPage(new InvoicesTable()),
                InvoiceTypeEnum.Estimate);
        this.convertToInvoicesService = convertToInvoicesService;
        getView().setDetailTitlePanel(constants.mostRecentEstimates());

        CommandWrapper deleteEstimatesCommand = new CommandWrapper(constants.deleteEstimates() ,new Command() {
            public void execute() {
                deleteDocuments(getView().getSelectedIds());
            }
        });
        CommandWrapper convertToInvoicesCommand = new CommandWrapper(constants.convertToInvoices() ,new Command() {
            public void execute() {
                convertToInvoices(getView().getSelectedIds());
            }
        });
        CommandWrapper setArchivedEstimatesCommand = new CommandWrapper(constants.markAsArchived() ,new Command() {
            public void execute() {
                changeStatusTo(InvoiceStatusEnum.Archived, getView().getSelectedIds());
            }
        });


        getView().addActionsCommands(deleteEstimatesCommand, convertToInvoicesCommand, setArchivedEstimatesCommand);
    }

    private void convertToInvoices(List<Long> ids) {
        if (warnNotEmptyIds(ids)) return;
        final ConvertToInvoiceRequest request = new ConvertToInvoiceRequest();
        request.setEntityIdList(ids);
        convertToInvoicesService.execute(request, new ServiceCallbackImpl<BulkActionResponse>() {
            @Override
            public void onSuccess(BulkActionResponse response) {
                if (!response.getFailureIdList().isEmpty()) {
                    ClientDialogUtils.showGeneralError();
                } else {
                    List<Long> ids = request.getEntityIdList();
                    Application.toasterMessage(Application.getConstants().estimatesConverted());
                    redirectToEntity(ids.get(0), "invoice");
                }
                refreshFromServer();
            }
        });
    }
}
