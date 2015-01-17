package com.numhero.client.mvp.moneyout;

import com.google.inject.Inject;
import com.numhero.client.model.datacargo.invoice.InvoiceListRequest;
import com.numhero.client.model.datacargo.invoice.InvoiceListResponse;
import com.numhero.client.model.datacargo.moneyout.MoneyOutRecapRequest;
import com.numhero.client.model.datacargo.moneyout.MoneyOutRecapResponse;
import com.numhero.client.mvp.BasePresenter;
import com.numhero.client.mvp.EditPageView;
import com.numhero.client.mvp.GenericMoneyoutTabViewPage;
import com.numhero.client.place.PlaceManager;
import com.numhero.client.service.Service;
import com.numhero.client.service.ServiceCallbackImpl;
import com.numhero.shared.enums.InvoiceTypeEnum;

public class MoneyOutPresenter extends BasePresenter {
    private Service<InvoiceListRequest, InvoiceListResponse> invoiceListService;
    private Service<MoneyOutRecapRequest, MoneyOutRecapResponse> moneyOutRecapListService;

    @Inject
    public MoneyOutPresenter(PlaceManager eventManager, MoneyOutPanel moneyOutPanel,
                             Service<InvoiceListRequest, InvoiceListResponse> invoiceListService,
                             Service<MoneyOutRecapRequest, MoneyOutRecapResponse> moneyOutRecapListService) {
        super(eventManager, new GenericMoneyoutTabViewPage(moneyOutPanel));
        this.invoiceListService = invoiceListService;
        this.moneyOutRecapListService = moneyOutRecapListService;
    }

    @Override
    public EditPageView getView() {
        return (EditPageView) super.getView();
    }

    protected MoneyOutPanel getMoneyOutPanel() {
        return ((MoneyOutPanel) getView().getContentPanel().getContentWidget());
    }

    protected void onShow() {
        InvoiceListRequest request = new InvoiceListRequest(InvoiceTypeEnum.Expense);
        invoiceListService.execute(request, new ServiceCallbackImpl<InvoiceListResponse>() {
            @Override
            public void onSuccess(InvoiceListResponse response) {
                getMoneyOutPanel().invoicesTable.setEntities(response.getEntityList());
            }
        });

        MoneyOutRecapRequest request3 = new MoneyOutRecapRequest();
        moneyOutRecapListService.execute(request3, new ServiceCallbackImpl<MoneyOutRecapResponse>() {
            @Override
            public void onSuccess(MoneyOutRecapResponse response) {
                getMoneyOutPanel().moneyOutSummaryTable.setRecaps(response.getRows());
            }
        });
    }
}
