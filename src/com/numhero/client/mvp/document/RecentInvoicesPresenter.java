package com.numhero.client.mvp.document;

import com.google.gwt.user.client.Command;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.numhero.client.model.datacargo.invoice.ChangeStatusOfDocumentsRequest;
import com.numhero.client.model.datacargo.invoice.DeleteDocumentsRequest;
import com.numhero.client.model.datacargo.invoice.InvoiceListRequest;
import com.numhero.client.model.datacargo.invoice.InvoiceListResponse;
import com.numhero.client.mvp.CommandWrapper;
import com.numhero.client.mvp.GridTabbedPage;
import com.numhero.client.place.PlaceManager;
import com.numhero.client.service.Service;
import com.numhero.shared.datacargo.BulkActionResponse;
import com.numhero.shared.enums.InvoiceStatusEnum;
import com.numhero.shared.enums.InvoiceTypeEnum;

@Singleton
public class RecentInvoicesPresenter extends RecentDocumentsPresenter {
    @Inject
    public RecentInvoicesPresenter(PlaceManager eventManager,
                                   Service<InvoiceListRequest, InvoiceListResponse> invoiceListService,
                                   Service<DeleteDocumentsRequest, BulkActionResponse> deleteDocumentsService,
                                   Service<ChangeStatusOfDocumentsRequest, BulkActionResponse> changeStatusService,
                                   InvoiceConstants constants,
                                   final GridTabbedPage view) {
        super(eventManager,
                invoiceListService,
                deleteDocumentsService,
                changeStatusService,
                view,
                InvoiceTypeEnum.Invoice);
        getView().setDetailTitlePanel(constants.mostRecentInvoices());

        CommandWrapper deleteInvoicesCommand = new CommandWrapper(constants.deleteInvoices() ,new Command() {
            public void execute() {
                deleteDocuments(getView().getSelectedIds());
            }
        });
        CommandWrapper setPaidInvoicesCommand = new CommandWrapper(constants.markAsPaid() ,new Command() {
            public void execute() {
                changeStatusTo(InvoiceStatusEnum.Paid, getView().getSelectedIds());
            }
        });
        CommandWrapper setArchivedInvoicesCommand = new CommandWrapper(constants.markAsArchived() ,new Command() {
            public void execute() {
                changeStatusTo(InvoiceStatusEnum.Archived, getView().getSelectedIds());
            }
        });

        getView().addActionsCommands(deleteInvoicesCommand, setPaidInvoicesCommand, setArchivedInvoicesCommand);


    }

}
