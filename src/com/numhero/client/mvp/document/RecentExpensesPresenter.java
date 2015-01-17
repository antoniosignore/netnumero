package com.numhero.client.mvp.document;

import com.google.gwt.user.client.Command;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.numhero.client.model.datacargo.invoice.*;
import com.numhero.client.mvp.CommandWrapper;
import com.numhero.client.mvp.GenericMoneyoutTabGridPage;
import com.numhero.client.place.PlaceManager;
import com.numhero.client.service.Service;
import com.numhero.shared.datacargo.BulkActionResponse;
import com.numhero.shared.enums.InvoiceStatusEnum;
import com.numhero.shared.enums.InvoiceTypeEnum;

//     protected Service<ChangeSupplierStatusOfDocumentsRequest, BulkActionResponse> changeSupplierStatusService;

@Singleton
public class RecentExpensesPresenter extends RecentDocumentsPresenter {
//    private Service<ConvertToInvoiceRequest, BulkActionResponse> convertToInvoicesService;

    @Inject
    public RecentExpensesPresenter(PlaceManager eventManager,
                                   Service<InvoiceListRequest, InvoiceListResponse> invoiceListService,
                                   Service<DeleteDocumentsRequest, BulkActionResponse> deleteDocumentsService,
                                   Service<ConvertToInvoiceRequest, BulkActionResponse> convertToInvoicesService,
                                   Service<ChangeStatusOfDocumentsRequest, BulkActionResponse> changeStatusService, InvoiceConstants constants) {
        super(eventManager,
                invoiceListService,
                deleteDocumentsService,
                changeStatusService,
                new GenericMoneyoutTabGridPage(new ExpensesTable()),
                InvoiceTypeEnum.Expense);

        getView().setDetailTitlePanel(constants.mostRecentExpenses());

        CommandWrapper deleteExpensesCommand = new CommandWrapper(constants.deleteExpenses() ,new Command() {
            public void execute() {
                deleteDocuments(getView().getSelectedIds());
            }
        });
        CommandWrapper setPaidInvoicesCommand = new CommandWrapper(constants.markAsReimbursed() ,new Command() {
            public void execute() {
                changeStatusTo(InvoiceStatusEnum.Paid, getView().getSelectedIds());
            }
        });
        CommandWrapper setArchivedEstimatesCommand = new CommandWrapper(constants.markAsArchived() ,new Command() {
            public void execute() {
                changeStatusTo(InvoiceStatusEnum.Archived, getView().getSelectedIds());
            }
        });

        getView().addActionsCommands(deleteExpensesCommand, setPaidInvoicesCommand, setArchivedEstimatesCommand);

    }

}
