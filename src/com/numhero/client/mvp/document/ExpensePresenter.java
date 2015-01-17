package com.numhero.client.mvp.document;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.numhero.client.Application;
import com.numhero.client.ClientCache;
import com.numhero.client.model.datacargo.category.CategoryListRequest;
import com.numhero.client.model.datacargo.category.CategoryListResponse;
import com.numhero.client.model.datacargo.category.SaveCategoryRequest;
import com.numhero.client.model.datacargo.client_supplier.ClientSupplierListResponse;
import com.numhero.client.model.datacargo.client_supplier.SaveClientSupplierRequest;
import com.numhero.client.model.datacargo.client_supplier.SupplierListRequest;
import com.numhero.client.model.datacargo.invoice.GetInvoiceRequest;
import com.numhero.client.model.datacargo.invoice.SaveInvoiceRequest;
import com.numhero.client.model.datacargo.taxinfo.TaxInfoListRequest;
import com.numhero.client.model.datacargo.taxinfo.TaxInfoListResponse;
import com.numhero.client.model.pojoc.Invoice;
import com.numhero.client.model.pojoc.TaxInfo;
import com.numhero.client.mvp.EditPageView;
import com.numhero.client.mvp.EditPresenter;
import com.numhero.client.mvp.GenericMoneyoutTabEditPage;
import com.numhero.client.mvp.category.CategoryPanel;
import com.numhero.client.mvp.clientsupplier.SupplierSelect;
import com.numhero.client.place.PlaceManager;
import com.numhero.client.service.Service;
import com.numhero.client.service.ServiceCallbackImpl;
import com.numhero.shared.datacargo.CommandResponse;
import com.numhero.shared.datacargo.GetSingleEntityResponse;
import com.numhero.shared.datacargo.SaveSingleEntityResponse;
import com.numhero.shared.enums.InvoiceStatusEnum;
import com.numhero.shared.enums.InvoiceTypeEnum;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Singleton
public class ExpensePresenter extends EditPresenter {

    @Inject
    private Service<GetInvoiceRequest, GetSingleEntityResponse<Invoice>> getService;

    @Inject
    private Service<SaveInvoiceRequest, SaveSingleEntityResponse> saveService;

    private Invoice invoice;
    private InvoiceConstants constants;

    @Inject
    public ExpensePresenter(PlaceManager eventManager,
                            Service<SupplierListRequest, ClientSupplierListResponse> clientSuppliersListService,
                            Service<SaveClientSupplierRequest, SaveSingleEntityResponse> clientSupplierSaveService,
                            Service<CategoryListRequest, CategoryListResponse> categoriesService,
                            Service<SaveCategoryRequest, SaveSingleEntityResponse> categorySaveService,
                            CategoryPanel panel,
                            InvoiceDetailsTable invoiceTable,
                            InvoiceConstants constants
    ) {
        super(eventManager, new GenericMoneyoutTabEditPage(new ExpensePanel(
                new SupplierSelect(null, clientSuppliersListService, clientSupplierSaveService),
                categoriesService, categorySaveService, panel, invoiceTable)));
        this.constants = constants;
    }

    @Override
    public EditPageView getView() {
        return (EditPageView) super.getView();
    }

    @Override
    protected String getReturnUrl() {
        return "expenses";
    }

    @Override
    public void onShow() {
        Application.injector.getClientCache().useCache(new TaxInfoListRequest(), new ServiceCallbackImpl<CommandResponse>() {
            @Override
            public void onSuccess(CommandResponse response) {
                getExpensePanel().invoiceDetailsTable.setTaxes(createMap((TaxInfoListResponse) response));
                internalShow();
            }
        });
    }

    protected ExpensePanel getExpensePanel() {
        return ((ExpensePanel) getView().getContentPanel().getContentWidget());
    }

    @Override
    protected void onBind() {
        getExpensePanel().getBtSave().addClickHandler(getSaveHandler());
        getExpensePanel().getBtCancel().setHref("#" + getReturnUrl());
    }

    private Map<Long, TaxInfo> createMap(TaxInfoListResponse response) {
        Map<Long, TaxInfo> m = new HashMap<Long, TaxInfo>();
        Collection<TaxInfo> l = response.getEntityList();
        for (TaxInfo taxInfo : l) {
            m.put(taxInfo.getId(), taxInfo);
        }

        return m;
    }

    private void internalShow() {
        Long id = getUrl().getId();
        if (id == null) {
            getView().setDetailTitlePanel(constants.newExpense());
            invoice = createSupplierExpense();
            getExpensePanel().setPojo(invoice);
        } else {
            getView().setDetailTitlePanel(constants.editExpense());
            GetInvoiceRequest request = new GetInvoiceRequest(id);
            getService.execute(request, new ServiceCallbackImpl<GetSingleEntityResponse<Invoice>>() {
                @Override
                public void onSuccess(GetSingleEntityResponse<Invoice> response) {
                    invoice = response.getEntity();
                    getExpensePanel().setPojo(invoice);
                }
            });
        }
    }

    private Invoice createSupplierExpense() {
        Invoice ret = new Invoice();
        if (getUrl().getParam1() != null) ret.setClientSupplierID(Long.parseLong(getUrl().getParam1()));
        if (getUrl().getParam2() != null) ret.setClientSupplierName(getUrl().getParam2());

        ret.setInvoiceType(InvoiceTypeEnum.Expense);
        ret.setDiscount(0D);
        ret.setDateRaised(new Date());
        ret.setInvoiceStatus(InvoiceStatusEnum.Draft);
        ret.setPrice(0D);
        if (ClientCache.getCurrentBA() != null) {
            ret.fCurrency.setValue(ClientCache.getCurrentBA().fCurrency.getValue());
        }
        return ret;
    }

    private ClickHandler getSaveHandler() {
        ClickHandler ret = new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                if (getExpensePanel().saveValuesFromUi()) {
                    SaveInvoiceRequest request = new SaveInvoiceRequest();
                    request.setEntity(invoice);
                    final Object source = event.getSource();
                    getView().showGlassPanel();
                    saveService.execute(request, new ServiceCallbackImpl<SaveSingleEntityResponse>() {
                        @Override
                        public void onSuccess(SaveSingleEntityResponse response) {
                            if (source == getExpensePanel().getBtSave().getAnchor()) {
                                getView().showToaster(constants.documentSaved());
                                redirect();
//                            } else if (source == getExpensePanel().getBtPrintAsPDF().getAnchor()) {
//                                ClientUtils.openPdf("/pdf/" + response.getEntityId());
                            }
                        }
                    });
                }
            }
        };
        return ret;
    }
}
