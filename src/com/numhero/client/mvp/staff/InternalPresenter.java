package com.numhero.client.mvp.staff;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.numhero.client.Application;
import com.numhero.client.ClientCache;
import com.numhero.client.model.datacargo.currency.GetCurrencyConversionRequest;
import com.numhero.client.model.datacargo.currency.GetCurrencyConversionResponse;
import com.numhero.client.model.datacargo.staff.*;
import com.numhero.client.model.pojoc.Staff;
import com.numhero.client.mvp.EditPresenter;
import com.numhero.client.mvp.GenericStaffTabEditPage;
import com.numhero.client.place.PlaceManager;
import com.numhero.client.service.Service;
import com.numhero.client.service.ServiceCallbackImpl;
import com.numhero.shared.datacargo.BulkActionResponse;
import com.numhero.shared.enums.ReceiptStatusEnum;
import com.numhero.shared.enums.StaffTypeEnum;

@Singleton
public class InternalPresenter extends EditPresenter {

    private Service<GetStaffRequest, GetStaffResponse> staffGetService;
    private Service<SaveStaffRequest, SaveStaffResponse> staffSaveService;
    private Service<DirectPaymentStaffListRequest, BulkActionResponse> directPaymentStaffService;
    private Service<GetCurrencyConversionRequest, GetCurrencyConversionResponse> conversionService;
    private StaffConstants constants;

    @Inject
    public InternalPresenter(PlaceManager eventManager,
                             Service<GetStaffRequest, GetStaffResponse> staffGetService,
                             Service<SaveStaffRequest, SaveStaffResponse> staffSaveService,
                             Service<DirectPaymentStaffListRequest, BulkActionResponse> directPaymentStaffService,
                             Service<GetCurrencyConversionRequest, GetCurrencyConversionResponse> conversionService,
                             StaffConstants constants) {
        super(eventManager, new GenericStaffTabEditPage(new InternalPanel()));
        this.staffGetService = staffGetService;
        this.staffSaveService = staffSaveService;
        this.directPaymentStaffService = directPaymentStaffService;
        this.conversionService = conversionService;
        this.constants = constants;
    }

    @Override
    public GenericStaffTabEditPage getView() {
        return (GenericStaffTabEditPage) super.getView();
    }

    @Override
    protected void onShow() {
        if (getUrl().getId() == null) {
            Staff staff = new Staff();
            staff.fCurrency.setValue(ClientCache.getCurrentBA().fCurrency.getValue());
            getStaffPanel().setPojo(staff);
            getStaffPanel().getRembourse().setVisible(false);
            getStaffPanel().getStaff().setStaffType(StaffTypeEnum.Internal);
            String constantsNewEntity = constants.newInternal();
            getView().setDetailTitlePanel(constantsNewEntity);
        } else {
            getStaffPanel().getRembourse().setVisible(true);
            refreshStaff();
        }
    }

    private void refreshStaff() {
        GetStaffRequest request = new GetStaffRequest();
        request.setEntityId(getUrl().getId());
        String constantsEditEntity = constants.editInternal();
        getView().setDetailTitlePanel(constantsEditEntity);
        staffGetService.execute(request, new ServiceCallbackImpl<GetStaffResponse>() {
            @Override
            public void onSuccess(GetStaffResponse response) {
                getStaffPanel().setPojo(response.getEntity());
                getStaffPanel().getReimbursableExpenseTable().setEntities(response.getRemboursableExpenses());
                getStaffPanel().getBtConvert().addClickHandler(conversionProjectHandler());
            }
        });
    }

    private ClickHandler conversionProjectHandler() {
        return new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
//                getProjectPanel().getCurrencyPanel().setVisible(true);


//                setStaffConvertedCurrency();
            }
        };
    }

    private void setStaffConvertedCurrency() {
        final StaffPanel staffPanel = getStaffPanel();
        ReimbursableExpensesTable table = staffPanel.getReimbursableExpenseTable();
        table.convertCurrencies(conversionService);
    }

    private StaffPanel getStaffPanel() {
        return ((StaffPanel) getView().getContentPanel().getContentWidget());
    }

    @Override
    protected void onBind() {
        super.onBind();
        getStaffPanel().getBtSave().addClickHandler(getSaveHandler());
        getStaffPanel().getBtCancel().setHref("#internals");

        getStaffPanel().getReimbursableExpenseTable();

        Command directPayment = new Command() {
            public void execute() {
                StaffUtils.directPayment(directPaymentStaffService,
                        getStaffPanel().getReimbursableExpenseTable().getSelectedIds(),
                        ReceiptStatusEnum.Paid, getView());
                refreshStaff();
            }
        };

        Command rejectPayment = new Command() {
            public void execute() {
                StaffUtils.directPayment(directPaymentStaffService,
                        getStaffPanel().getReimbursableExpenseTable().getSelectedIds(),
                        ReceiptStatusEnum.Rejected, getView());
                refreshStaff();
            }
        };

        Command archivePayment = new Command() {
            public void execute() {
                StaffUtils.directPayment(directPaymentStaffService,
                        getStaffPanel().getReimbursableExpenseTable().getSelectedIds(),
                        ReceiptStatusEnum.Archived, getView());
                refreshStaff();
            }
        };

        getStaffPanel().getReimbursableExpenseTable().getFooter().getTableFooterActionsCombo().setAnimationEnabled(true);
        getStaffPanel().getReimbursableExpenseTable().getFooter().getTableFooterActionsCombo().setAutoOpen(true);
        MenuBar bulkActions = new MenuBar(true);
        bulkActions.addItem(new MenuItem(Application.getConstants().directPayment(), directPayment));
        bulkActions.addItem(new MenuItem(Application.getConstants().expenseRejected(), rejectPayment));
        bulkActions.addItem(new MenuItem(Application.getConstants().expenseArchived(), archivePayment));
        getStaffPanel().getReimbursableExpenseTable().getFooter().getTableFooterActionsCombo().addItem(new MenuItem(Application.getConstants().bulkAction(), bulkActions));
    }


    private ClickHandler getSaveHandler() {
        ClickHandler ret = new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                if (getStaffPanel().saveValuesFromUi()) {
                    getStaffPanel().getStaff().setStaffType(StaffTypeEnum.Internal);
                    SaveStaffRequest request = new SaveStaffRequest();
                    request.setStaff(getStaffPanel().getStaff());
                    Application.showGlasspanelLoading();
                    staffSaveService.execute(request, new ServiceCallbackImpl<SaveStaffResponse>() {
                        @Override
                        public void onSuccess(SaveStaffResponse response) {
                            Application.toasterMessage(Application.getConstants().internalStaffSaved());
                            redirect();
                        }
                    });
                }
            }
        };
        return ret;
    }

    @Override
    protected String getReturnUrl() {
        return "internals";
    }
}
