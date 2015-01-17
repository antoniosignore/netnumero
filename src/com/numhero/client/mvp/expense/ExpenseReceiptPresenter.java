package com.numhero.client.mvp.expense;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.numhero.client.Application;
import com.numhero.client.ClientCache;
import com.numhero.client.model.datacargo.expense.*;
import com.numhero.client.model.pojoc.ExpenseReceipt;
import com.numhero.client.mvp.BasePresenter;
import com.numhero.client.mvp.GenericMoneyoutTabEditPage;
import com.numhero.client.place.PlaceManager;
import com.numhero.client.service.Service;
import com.numhero.client.service.ServiceCallbackImpl;
import com.numhero.client.util.ClientUtils;
import com.numhero.shared.datacargo.BulkActionResponse;
import com.numhero.shared.enums.InvoiceStatusEnum;

import java.util.Date;
import java.util.List;

@Singleton
public class ExpenseReceiptPresenter extends BasePresenter {

    Service<GetReceiptRequest, GetReceiptResponse> expenseGetService;
    Service<SaveReceiptRequest, SaveReceiptResponse> expenseSaveService;
    private Service<ReceiptsListRequest, ReceiptsListResponse> expensesListService;
    private Service<DeleteReceiptsRequest, BulkActionResponse> deleteExpensesService;
    private Service<SetToPaidReceiptsRequest, BulkActionResponse> paidExpensesService;
    private ExpenseReceiptConstants constants;

    @Inject
    public ExpenseReceiptPresenter(PlaceManager eventManager,
                                   Service<GetReceiptRequest, GetReceiptResponse> expenseGetService,
                                   Service<SaveReceiptRequest, SaveReceiptResponse> expenseSaveService,
                                   ExpenseReceiptPanel expensePanel,
                                   Service<ReceiptsListRequest, ReceiptsListResponse> expensesListService,
                                   Service<DeleteReceiptsRequest, BulkActionResponse> deleteExpensesService,
                                   Service<SetToPaidReceiptsRequest, BulkActionResponse> paidExpensesService,
                                   ExpenseReceiptConstants constants) {
        super(eventManager, new GenericMoneyoutTabEditPage(expensePanel));
        this.expenseGetService = expenseGetService;
        this.expenseSaveService = expenseSaveService;
        this.expensesListService = expensesListService;
        this.deleteExpensesService = deleteExpensesService;
        this.paidExpensesService = paidExpensesService;
        this.constants = constants;

        final ExpensesTable table = getExpensePanel().getExpensesTable();

        Command deleteCommand = new Command() {
            public void execute() {
                deleteExpenses(table.getSelectedIds());
            }
        };

        Command paidCommand = new Command() {
            public void execute() {
                paidExpenses(table.getSelectedIds());
            }
        };

        table.getFooter().getTableFooterActionsCombo().setAnimationEnabled(true);
        table.getFooter().getTableFooterActionsCombo().setAutoOpen(true);
        MenuBar bulkActions = new MenuBar(true);
        bulkActions.addItem(new MenuItem(Application.getConstants().deleteExpenses(), deleteCommand));
//        bulkActions.addItem(new MenuItem(Application.getConstants().payExpenses(), paidCommand));
        table.getFooter().getTableFooterActionsCombo().addItem(new MenuItem(Application.getConstants().bulkAction(), bulkActions));
    }

    private ExpenseReceiptPanel getExpensePanel() {
        return ((ExpenseReceiptPanel) getView().getContentPanel().getContentWidget());
    }

    private void deleteExpenses(List<Long> selectedIds) {
        if (ClientUtils.warnNotEmptyIds(selectedIds, getView())) return;
        DeleteReceiptsRequest request = new DeleteReceiptsRequest();
        request.setEntityIdList(selectedIds);
        deleteExpensesService.execute(request, new ServiceCallbackImpl<BulkActionResponse>() {
            @Override
            public void onSuccess(BulkActionResponse response) {
                if (!response.getFailureIdList().isEmpty()) {
                    Window.alert(Application.getConstants().errorDeleting());
                } else {
                    Application.toasterMessage(Application.getConstants().itemsDeleted());
                }
                refreshFromServer();
            }
        });
    }

    private void paidExpenses(List<Long> selectedIds) {
        if (ClientUtils.warnNotEmptyIds(selectedIds, getView())) return;
        SetToPaidReceiptsRequest requestSetTo = new SetToPaidReceiptsRequest();
        requestSetTo.setEntityIdList(selectedIds);
        paidExpensesService.execute(requestSetTo, new ServiceCallbackImpl<BulkActionResponse>() {
            @Override
            public void onSuccess(BulkActionResponse response) {
                if (!response.getFailureIdList().isEmpty()) Window.alert("Errors setting expenses in paid state");
                refreshFromServer();
            }
        });
    }

    @Override
    public GenericMoneyoutTabEditPage getView() {
        return (GenericMoneyoutTabEditPage) super.getView();
    }

    @Override
    public void onShow() {
        if (getUrl().getId() == null) {
            ExpenseReceipt receipt = new ExpenseReceipt();
            if (ClientCache.getCurrentBA() != null) {
                receipt.fCurrency.setValue(ClientCache.getCurrentBA().fCurrency.getValue());
            }
            getExpensePanel().setPojo(receipt);
            String constantsNewEntity = constants.newEditReceipts();
            getView().setDetailTitlePanel(constantsNewEntity);
        } else {
            String constantsEditEntity = constants.editExpense();
            getView().setDetailTitlePanel(constantsEditEntity);
            GetReceiptRequest request = new GetReceiptRequest();
            request.setEntityId(getUrl().getId());
            expenseGetService.execute(request, new ServiceCallbackImpl<GetReceiptResponse>() {
                @Override
                public void onSuccess(GetReceiptResponse response) {
                    getExpensePanel().setPojo(response.getEntity());
                }
            });
        }
        refreshFromServer();
    }

    private ClickHandler saveExpenseHandler() {
        ClickHandler ret = new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                ExpenseReceipt ex = getExpensePanel().getExpense();
                if (getExpensePanel().saveValuesFromUi()) {
                    if (ex.fInvoiceStatus.getValue() == InvoiceStatusEnum.Billed || ex.fInvoiceStatus.getValue() == InvoiceStatusEnum.Paid)
                        Window.alert(Application.getConstants().expenseAlreadyBilledOrPaid());
                    else {
                        SaveReceiptRequest request = new SaveReceiptRequest();
                        request.setExpense(getExpensePanel().getExpense());
                        expenseSaveService.execute(request, new ServiceCallbackImpl<SaveReceiptResponse>() {
                            @Override
                            public void onSuccess(SaveReceiptResponse response) {
                                Application.toasterMessage(Application.getConstants().expenseSaved());
                                refreshFromServer();
                            }
                        });
                    }
                }
            }
        };
        return ret;
    }

    private ClickHandler newExpenseHandler() {
        ClickHandler ret = new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                Application.getPlaceManager().moveToPlace("pettyexpense");
            }
        };
        return ret;
    }

    @Override
    protected void onBind() {
        super.onBind();
        final ExpenseReceiptPanel panel = getExpensePanel();
        panel.getSelectedDate().setValue(new Date());
        panel.getBtSave().addClickHandler(saveExpenseHandler());
        panel.getBtNew().addClickHandler(newExpenseHandler());
        panel.getBtCancel().addClickHandler(cancelTimeEntryHandler());
    }

    private ClickHandler cancelTimeEntryHandler() {
        ClickHandler ret = new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                Application.getPlaceManager().moveToPlace("expenses");
            }
        };
        return ret;
    }

    @Override
    protected void onUnbind() {
        super.onUnbind();
    }

    private void refreshFromServer() {
        ReceiptsListRequest request = new ReceiptsListRequest();
        expensesListService.execute(request, new ServiceCallbackImpl<ReceiptsListResponse>() {
            @Override
            public void onSuccess(ReceiptsListResponse response) {
                getExpensePanel().getExpensesTable().setEntities((List<ExpenseReceipt>) response.getEntityList());
            }
        });
    }
}
