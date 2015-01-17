package com.numhero.client.mvp.report.expenses;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.numhero.client.model.datacargo.expense.ReceiptsListRequest;
import com.numhero.client.model.datacargo.expense.ReceiptsListResponse;
import com.numhero.client.model.pojoc.ExpenseReceipt;
import com.numhero.client.mvp.BasePresenter;
import com.numhero.client.mvp.GenericReportTabViewPage;
import com.numhero.client.place.PlaceManager;
import com.numhero.client.service.Service;
import com.numhero.client.service.ServiceCallbackImpl;
import com.numhero.client.util.CoreUtils;

import java.util.List;

@Singleton
public class StaffExpensesPresenter extends BasePresenter {

    private Service<ReceiptsListRequest, ReceiptsListResponse> expensesListService;

    @Inject
    public StaffExpensesPresenter(PlaceManager eventManager,
                                  StaffExpensesPanel expensePanel,
                                  Service<ReceiptsListRequest, ReceiptsListResponse> expensesListService) {
        super(eventManager, new GenericReportTabViewPage(expensePanel));
        this.expensesListService = expensesListService;
    }

    private StaffExpensesPanel getExpensePanel() {
        return (StaffExpensesPanel) getView().getContentPanel().getContentWidget();
    }

    @Override
    public GenericReportTabViewPage getView() {
        return (GenericReportTabViewPage) super.getView();
    }

    @Override
    public void onShow() {


        refreshFromServer();
    }

    @Override
    protected void onBind() {
        super.onBind();
        getExpensePanel().getBtRefresh().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                CoreUtils.debug("event = " + event);
                refreshFromServer();
            }
        });
    }

    @Override
    protected void onUnbind() {
        super.onUnbind();
    }

    protected void refreshFromServer() {
        getExpensePanel().getUnbilledExpensesTable().showLoading();

        ReceiptsListRequest request = new ReceiptsListRequest();
        request.setReceiptStaffStatus(getExpensePanel().getReceiptStatusComboBox().getValue());
        request.setClientStatus(getExpensePanel().getReceiptClientStatusComboBox().getValue());
        request.setFromDate(getExpensePanel().getFrom().getValue());
        request.setToDate(getExpensePanel().getTo().getValue());
        if (getExpensePanel().getClient() != null) request.setClientId(getExpensePanel().getClient().getId());

        expensesListService.execute(request, new ServiceCallbackImpl<ReceiptsListResponse>() {
            @Override
            public void onSuccess(ReceiptsListResponse response) {
                getExpensePanel().getUnbilledExpensesTable().setEntities((List<ExpenseReceipt>) response.getEntityList());
            }
        });
    }
}
