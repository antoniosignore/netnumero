package com.numhero.client.mvp.project;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.SuggestOracle.Suggestion;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.numhero.client.Application;
import com.numhero.client.ClientCache;
import com.numhero.client.model.datacargo.client_supplier.ClientListRequest;
import com.numhero.client.model.datacargo.client_supplier.ClientSupplierListResponse;
import com.numhero.client.model.datacargo.client_supplier.SaveClientSupplierRequest;
import com.numhero.client.model.datacargo.currency.GetCurrencyConversionRequest;
import com.numhero.client.model.datacargo.currency.GetCurrencyConversionResponse;
import com.numhero.client.model.datacargo.expense.ReceiptsBilledStatusRequest;
import com.numhero.client.model.datacargo.expense.ReceiptsBillingListRequest;
import com.numhero.client.model.datacargo.expense.ReceiptsListResponse;
import com.numhero.client.model.datacargo.project.*;
import com.numhero.client.model.datacargo.timeentry.TimeEntriesBilledStatusRequest;
import com.numhero.client.model.datacargo.timeentry.TimeEntryBillingListRequest;
import com.numhero.client.model.datacargo.timeentry.TimeEntryListResponse;
import com.numhero.client.model.pojoc.ExpenseReceipt;
import com.numhero.client.model.pojoc.Project;
import com.numhero.client.model.pojoc.TimeEntry;
import com.numhero.client.mvp.EditPresenter;
import com.numhero.client.mvp.GenericTimeTabEditPage;
import com.numhero.client.place.PlaceManager;
import com.numhero.client.service.Service;
import com.numhero.client.service.ServiceCallbackImpl;
import com.numhero.client.widget.combobox.CurrencySelect;
import com.numhero.client.widget.combobox.DropDownBox.DropDownBoxHandler;
import com.numhero.client.widget.filter.BAPojoFilter;
import com.numhero.client.widget.textbox.NumberTextBox;
import com.numhero.shared.datacargo.BulkActionResponse;
import com.numhero.shared.datacargo.SaveSingleEntityResponse;
import com.numhero.shared.enums.BillingMethodEnum;
import com.numhero.shared.enums.InvoiceTypeEnum;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Singleton
public class ProjectPresenter extends EditPresenter implements ProjectValuationChangedHandler {

    Service<GetProjectRequest, GetProjectResponse> projectGetService;
    Service<SaveProjectRequest, SaveProjectResponse> projectSaveService;
    Service<TimeEntryBillingListRequest, TimeEntryListResponse> getBillableTimeEntriesService;
    Service<ReceiptsBillingListRequest, ReceiptsListResponse> getBillableExpensesService;
    Service<ProjectGenerateInvoiceRequest, ProjectGenerateInvoiceResponse> generateInvoiceService;
    Service<TimeEntriesBilledStatusRequest, BulkActionResponse> setBilledStatusTimeEntriesService;
    Service<ReceiptsBilledStatusRequest, BulkActionResponse> setBilledStatusExpensesService;
    Service<ClientListRequest, ClientSupplierListResponse> clientSuppliersService;
    Service<SaveClientSupplierRequest, SaveSingleEntityResponse> clientSupplierSaveService;
    Service<GetCurrencyConversionRequest, GetCurrencyConversionResponse> conversionService;
    private ProjectConstants constants;
    public boolean isSameCurrency = true;
    private Long clientId = null;

    @Inject
    public ProjectPresenter(PlaceManager eventManager,
                            Service<GetProjectRequest, GetProjectResponse> projectGetService,
                            Service<SaveProjectRequest, SaveProjectResponse> projectSaveService,
                            Service<TimeEntryBillingListRequest, TimeEntryListResponse> getBillableTimeEntriesService,
                            Service<ReceiptsBillingListRequest, ReceiptsListResponse> getBillableExpensesService,
                            ProjectPanel projectPanel,
                            Service<ProjectGenerateInvoiceRequest, ProjectGenerateInvoiceResponse> generateInvoiceService,
                            final Service<ClientListRequest, ClientSupplierListResponse> clientSuppliersService,
                            final Service<SaveClientSupplierRequest, SaveSingleEntityResponse> clientSupplierSaveService,
                            Service<TimeEntriesBilledStatusRequest, BulkActionResponse> setBilledStatusTimeEntriesService,
                            Service<ReceiptsBilledStatusRequest, BulkActionResponse> setBilledStatusExpensesService,
                            Service<GetCurrencyConversionRequest, GetCurrencyConversionResponse> conversionService,
                            ProjectConstants constants) {
        super(eventManager, new GenericTimeTabEditPage(projectPanel));
        this.projectGetService = projectGetService;
        this.projectSaveService = projectSaveService;
        this.getBillableTimeEntriesService = getBillableTimeEntriesService;
        this.getBillableExpensesService = getBillableExpensesService;
        this.generateInvoiceService = generateInvoiceService;
        this.setBilledStatusTimeEntriesService = setBilledStatusTimeEntriesService;
        this.clientSuppliersService = clientSuppliersService;
        this.clientSupplierSaveService = clientSupplierSaveService;
        this.setBilledStatusExpensesService = setBilledStatusExpensesService;
        this.conversionService = conversionService;
        this.constants = constants;
        eventManager.addHandler(ProjectValuationChangedEvent.TYPE, this);
    }

    @Override
    public GenericTimeTabEditPage getView() {
        return (GenericTimeTabEditPage) super.getView();
    }

    @Override
    public void onShow() {

        if (getUrl().getId() == null) {
            getView().setDetailTitlePanel(Application.getConstants().createNewProject());
            Project project = new Project();
            project.setCreated(new Date());
            project.fBillingMethod.setValue(BillingMethodEnum.FLAT_AMOUNT);
            if (ClientCache.getCurrentBA() != null) {
                project.fCurrency.setValue(ClientCache.getCurrentBA().fCurrency.getValue());
            }
            getProjectPanel().setPojo(project);
        } else {
            getView().setDetailTitlePanel(Application.getConstants().editProject());
            GetProjectRequest request = new GetProjectRequest();
            request.setEntityId(getUrl().getId());
            projectGetService.execute(request, new ServiceCallbackImpl<GetProjectResponse>() {
                @Override
                public void onSuccess(GetProjectResponse response) {
                    getProjectPanel().setPojo(response.getEntity());
                    clientId = response.getEntity().fClientSupplierID.getValue();
                }
            });
        }

        getProjectPanel().getCbCurrency().setHandler(new DropDownBoxHandler() {
            @Override
            public void itemSelected(Suggestion pojo) {
                setRecomputeValueHandler("currency change");
            }
        });

        getProjectPanel().getBillingMethod().addChangeHandler(billingMethodChangeHandler());
        getProjectPanel().getBillingFlatRate().getAmountBox().addChangeHandler(setRecomputeValueHandler("amount changed"));
        getProjectPanel().getBillingRate().getAmountBox().addChangeHandler(setRecomputeValueHandler("rate changed"));
        getProjectPanel().getTimeUnit().addChangeHandler(setRecomputeValueHandler("time unit changed"));

        getProjectPanel().getFrom().getDatePicker().addValueChangeHandler(new ValueChangeHandler() {
            @Override
            public void onValueChange(ValueChangeEvent valueChangeEvent) {
                retrieveTimeEntries();
                retrieveExpenses();
                getPlaceManager().fireEvent(new ProjectValuationChangedEvent("from date"));
            }
        });

        getProjectPanel().getTo().getDatePicker().addValueChangeHandler(new ValueChangeHandler() {
            @Override
            public void onValueChange(ValueChangeEvent valueChangeEvent) {
                retrieveTimeEntries();
                retrieveExpenses();
                getPlaceManager().fireEvent(new ProjectValuationChangedEvent("to date"));
            }
        });

        retrieveTimeEntries();
        retrieveExpenses();
        evaluateProjectPrice();
        displayGenerateButtons(getProjectPanel());
        getProjectPanel().paint();

    }

    private ProjectPanel getProjectPanel() {
        return ((ProjectPanel) getView().getContentPanel().getContentWidget());
    }

    private ClickHandler saveProjectHandler() {
        return new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                saveProject();
            }
        };
    }

    private ClickHandler conversionProjectHandler() {
        return new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
//                getProjectPanel().getCurrencyPanel().setVisible(false);

//                BillingMethodEnum enumer = getProjectPanel().getBillingMethod().getValue();
//                if (enumer == BillingMethodEnum.STAFF_RATE) setStaffConvertedCurrency();
//                else if (enumer == BillingMethodEnum.TASK_RATE) setTasksConvertedCurrency();
            }
        };
    }

    @Override
    protected void onBind() {
        super.onBind();
        getProjectPanel().getBtSave().addClickHandler(saveProjectHandler());
        getProjectPanel().getBtCancel().setHref("#projects");
        getProjectPanel().getBtGenerateInvoice().addClickHandler(createInvoiceHandler(this, InvoiceTypeEnum.Invoice));
        getProjectPanel().getBtGenerateEstimate().addClickHandler(createInvoiceHandler(this, InvoiceTypeEnum.Estimate));
        getProjectPanel().getBtConvert().setVisible(false);
        getProjectPanel().getBtConvert().addClickHandler(conversionProjectHandler());
    }

    private ChangeHandler setRecomputeValueHandler(final String s) {
        ChangeHandler ret = new ChangeHandler() {
            @Override
            public void onChange(ChangeEvent changeEvent) {
                evaluateProjectPrice();
            }
        };
        return ret;
    }

    private ClickHandler createInvoiceHandler(final ProjectPresenter presenter, final InvoiceTypeEnum type) {
        ClickHandler ret = new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                InvoiceGenerator.generateInvoiceFromProject(presenter, getProjectPanel(), type, projectSaveService);
            }
        };
        return ret;
    }

    public void saveProject() {
        SaveProjectRequest saveProjectRequest = new SaveProjectRequest();
        if (getProjectPanel().saveValuesFromUi()) {
            saveProjectRequest.setProject(getProjectPanel().getProject());
            getProjectPanel().getProject().fLastBilled.setValue(new Date());
            getProjectPanel().getProject().fTotalBilledTime.setValue(
                    getProjectPanel().getProject().fTotalBilledTime.getValue() +
                            getProjectPanel().getProject().fBillableTime.getValue());
            Application.showGlasspanelLoading();

            projectSaveService.execute(saveProjectRequest, new ServiceCallbackImpl<SaveProjectResponse>() {
                @Override
                public void onSuccess(SaveProjectResponse response) {
                    Application.toasterMessage(Application.getConstants().projectSaved());
                    redirect();
                }
            });
        }
    }

    public void timeEntriesBilled() {
        List<Long> ids = new ArrayList<Long>();
        List<TimeEntry> entries = getProjectPanel().getTimeEntriesTable().getCheckedTimeEntries();
        for (TimeEntry timeEntry : entries) {
            ids.add(timeEntry.getId());
        }

        if (ids.size() > 0) {
            TimeEntriesBilledStatusRequest request = new TimeEntriesBilledStatusRequest();
            request.setEntityIdList(ids);
            setBilledStatusTimeEntriesService.execute(request, new ServiceCallbackImpl<BulkActionResponse>() {
                @Override
                public void onSuccess(BulkActionResponse bulkActionResponse) {
                    Application.toasterMessage(Application.getConstants().timeEntrySavedAsBilled());
                }
            });
        }
    }

    public void expensesBilled() {
        List<Long> ids = new ArrayList<Long>();
        List<ExpenseReceipt> entries = getProjectPanel().getExpensesTable().getCheckedExpenses();
        for (ExpenseReceipt expenseReceipt : entries) {
            ids.add(expenseReceipt.getId());
        }
        if (ids.size() > 0) {
            ReceiptsBilledStatusRequest request = new ReceiptsBilledStatusRequest();
            request.setEntityIdList(ids);
            setBilledStatusExpensesService.execute(request, new ServiceCallbackImpl<BulkActionResponse>() {
                @Override
                public void onSuccess(BulkActionResponse bulkActionResponse) {
                    Application.toasterMessage(Application.getConstants().expensesSavedAsBilled());
                }
            });
        }
    }

    @Override
    protected String getReturnUrl() {
        return "projects";
    }

//    // TODO @Antonio - method private and unused
//    private void setTasksConvertedCurrency() {
//        CoreUtils.debug("ProjectPresenter.setTasksConvertedCurrency");
//
//        ProjectTasksDetailsTable tasksDetailsTable = getProjectPanel().getProjectTasksDetailsTable();
//        final List<ProjectTasksDetailsTable.TaskLine> tasks = tasksDetailsTable.getLines();
//
//        final List<CurrencyConvertBean> toConvert = new ArrayList<CurrencyConvertBean>();
//        for (ProjectTasksDetailsTable.TaskLine taskLine : tasks) {
//            if (!taskLine.getSuggestBoxTask().getSuggestBox().getText().isEmpty()) {
//                if (taskLine.currency.getPojo() != getProjectPanel().getCbCurrency().getPojo()) {
//                    CurrencyConvertBean ccb = new CurrencyConvertBean();
//                    ccb.setFromAmount(taskLine.billingRate.getAmount());
//                    ccb.setFromCurrency(taskLine.currency.getPojo());
//                    ccb.setToAmount(0);
//                    ccb.setToCurrency(getProjectPanel().getCbCurrency().getPojo());
//                    toConvert.add(ccb);
//                }
//            }
//        }
//
//        CurrencyConvertDialog dlg = new CurrencyConvertDialog(toConvert);
//        dlg.center();
//        dlg.addCloseHandler(new CloseHandler<PopupPanel>() {
//            @Override
//            public void onClose(CloseEvent<PopupPanel> event) {
//                int toConvertIndex = 0;
//                for (ProjectTasksDetailsTable.TaskLine taskLine : tasks) {
//                    if (!taskLine.getSuggestBoxTask().getSuggestBox().getText().isEmpty()) {
//                        if (taskLine.currency.getPojo() != getProjectPanel().getCbCurrency().getPojo()) {
//                            CurrencyConvertBean ccb = toConvert.get(toConvertIndex);
//                            taskLine.billingRate.setAmount(ccb.getToAmount());
//                            taskLine.billingRate.setCurrency(ccb.getToCurrency());
//                            taskLine.currency.setPojo(ccb.getToCurrency());
//                            taskLine.valueToBill.setAmount(taskLine.billingRate.getAmount() * taskLine.notBilledHours.getAmount());
//                            taskLine.valueToBill.setCurrency(ccb.getToCurrency());
//                            toConvertIndex++;
//                        }
//                    }
//                }
//            }
//        });
//
//        // TODO @Antonio - why add a handler here - maybe you wanted to fire an event?
//        placeManager.addHandler(ProjectValuationChangedEvent.TYPE, this);
//    }
//
//    // TODO @Antonio - method private and unused
//    private void setStaffConvertedCurrency() {
//        CoreUtils.debug("ProjectPresenter.setStaffConvertedCurrency");
//
//        ProjectStaffDetailsTable staffsDetailsTable = getProjectPanel().getProjectStaffDetailsTable();
//        final List<ProjectStaffDetailsTable.StaffLine> staffs = staffsDetailsTable.getLines();
//
//        final List<CurrencyConvertBean> toConvert = new ArrayList<CurrencyConvertBean>();
//        for (ProjectStaffDetailsTable.StaffLine staffLine : staffs) {
//            if (!staffLine.getSbStaff().getSuggestBox().getText().isEmpty()) {
//                if (staffLine.currency.getPojo() != getProjectPanel().getCbCurrency().getPojo()) {
//                    CurrencyConvertBean ccb = new CurrencyConvertBean();
//                    ccb.setFromAmount(staffLine.billingRate.getAmount());
//                    ccb.setFromCurrency(staffLine.currency.getPojo());
//                    ccb.setToAmount(0);
//                    ccb.setToCurrency(getProjectPanel().getCbCurrency().getPojo());
//                    toConvert.add(ccb);
//                }
//            }
//        }
//
//        CurrencyConvertDialog dlg = new CurrencyConvertDialog(toConvert);
//        dlg.center();
//        dlg.addCloseHandler(new CloseHandler<PopupPanel>() {
//            @Override
//            public void onClose(CloseEvent<PopupPanel> event) {
//                int toConvertIndex = 0;
//                for (ProjectStaffDetailsTable.StaffLine staffLine : staffs) {
//                    if (!staffLine.getSbStaff().getSuggestBox().getText().isEmpty()) {
//                        if (staffLine.currency.getPojo() != getProjectPanel().getCbCurrency().getPojo()) {
//                            CurrencyConvertBean ccb = toConvert.get(toConvertIndex);
//                            staffLine.billingRate.setAmount(ccb.getToAmount());
//                            staffLine.billingRate.setCurrency(ccb.getToCurrency());
//                            staffLine.currency.setPojo(ccb.getToCurrency());
//                            staffLine.valueToBill.setAmount(staffLine.billingRate.getAmount() * staffLine.billableHours.getAmount());
//                            staffLine.valueToBill.setCurrency(ccb.getToCurrency());
//                            toConvertIndex++;
//                        }
//                    }
//                }
//            }
//        });
//
//        // TODO @Antonio - why add a handler here - maybe you wanted to fire an event?
//        placeManager.addHandler(ProjectValuationChangedEvent.TYPE, this);
//    }

    private double getCheckedExpensesPrice() {
        double price = 0;
        ProjectExpensesTable table = getProjectPanel().getExpensesTable();
        int rowCount = table.getRowCount();
        for (int i = 0; i < rowCount; i++) {
            CheckBox box = (CheckBox) table.getWidget(i, 0);
            if (box != null && box.getValue()) {
                CurrencySelect currency = (CurrencySelect) table.getWidget(i, 4);
                NumberTextBox amount = (NumberTextBox) table.getWidget(i, 5);
                if (currency.getPojo() == getProjectPanel().getCbCurrency().getPojo()) {
                    price += amount.getAmount();
                    table.getWidget(i, 4).setStyleName("gwt-ListBox");
                } else {
                    table.getWidget(i, 4).setStyleName("error-cell");
                    isSameCurrency = false;
                }
            }
        }
        return price;
    }

    @Override
    public void onValuationChanged(ProjectValuationChangedEvent eventProject) {
        evaluateProjectPrice();
        displayGenerateButtons(getProjectPanel());
        getProjectPanel().paint();
    }

    private void evaluateProjectPrice() {
        isSameCurrency = true;
        BillingMethodEnum enumer = getProjectPanel().getBillingMethod().getValue();
        if (enumer == BillingMethodEnum.FLAT_AMOUNT) ProjectValueCalculator.setProjectFlatValuation(getProjectPanel());
        if (enumer == BillingMethodEnum.PROJECT_RATE) ProjectValueCalculator.setProjectRateValuation(getProjectPanel());
        if (enumer == BillingMethodEnum.STAFF_RATE)
            isSameCurrency = ProjectValueCalculator.setProjectStaffRateValuation(getProjectPanel());
        if (enumer == BillingMethodEnum.TASK_RATE)
            isSameCurrency = ProjectValueCalculator.setProjectTaskRateValuation(getProjectPanel());
        getProjectPanel().setValuation(getProjectPanel().getValuation() + getCheckedExpensesPrice());
        getProjectPanel().getValuationLabel().setText("" + (getProjectPanel().getValuation()));
    }

    private void displayGenerateButtons(ProjectPanel projectPanel) {
        projectPanel.getBtGenerateInvoice().setVisible(true);
        projectPanel.getBtGenerateEstimate().setVisible(true);
        //   if (!isSameCurrency) getProjectPanel().getBtConvert().setVisible(true);
    }

    private void retrieveTimeEntries() {
        if (getProjectPanel().getBillingMethod().getValue() != BillingMethodEnum.FLAT_AMOUNT) {
            TimeEntryBillingListRequest request = new TimeEntryBillingListRequest();
            BAPojoFilter filter = new BAPojoFilter();
            filter.setFrom(getProjectPanel().getFrom() != null ? getProjectPanel().getFrom().getValue() : null);
            filter.setTo(getProjectPanel().getTo() != null ? getProjectPanel().getTo().getValue() : null);
            filter.setProject(getProjectPanel().getProject());
            filter.setBilled(false);
            request.setFilter(filter);

            getBillableTimeEntriesService.execute(request, new ServiceCallbackImpl<TimeEntryListResponse>() {
                @Override
                public void onSuccess(TimeEntryListResponse response) {
                    if (!response.getEntityList().isEmpty()) {
                        getProjectPanel().getTimeEntriesTable().setEntities(response.getEntityList());
                        getProjectPanel().getTimeEntriesTable().setHandler(setRecomputeValueHander("changed time entry"));
                    } else {
                        getProjectPanel().getHoursGroup().setVisible(false);
                    }
                }
            });
        }
    }

    private void retrieveExpenses() {
        ReceiptsBillingListRequest request = new ReceiptsBillingListRequest();
        request.setClientId(clientId);
        request.setFromDate(getProjectPanel().getFrom().getValue());
        request.setToDate(getProjectPanel().getTo().getValue());
        getBillableExpensesService.execute(request, new ServiceCallbackImpl<ReceiptsListResponse>() {
            @Override
            public void onSuccess(ReceiptsListResponse response) {
                if (!response.getEntityList().isEmpty()) {
                    getProjectPanel().getExpensesTable().setEntities(response.getEntityList());
                    getProjectPanel().getExpensesTable().setHandler(setRecomputeValueHander("changed expense entry"));
                } else {
                    getProjectPanel().getExpensesGroup().setVisible(false);
                }
            }
        });
    }

    private ChangeHandler billingMethodChangeHandler() {
        ChangeHandler ret = new ChangeHandler() {
            @Override
            public void onChange(ChangeEvent changeEvent) {
                getProjectPanel().getProjectStaffDetailsTable().getProject().fBillingMethod.setValue(getProjectPanel().getBillingMethod().getValue());
                getProjectPanel().getProjectTasksDetailsTable().getProject().fBillingMethod.setValue(getProjectPanel().getBillingMethod().getValue());
 //               placeManager.fireEvent(new ProjectValuationChangedEvent("changed the billing method"));
            }
        };
        return ret;
    }

    private ClickHandler setRecomputeValueHander(final String s) {
        ClickHandler ret = new ClickHandler() {
            @Override
            public void onClick(ClickEvent changeEvent) {
                evaluateProjectPrice();
            }
        };
        return ret;
    }
}

