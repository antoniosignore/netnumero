package com.numhero.client.mvp.moneyin;

import com.google.inject.Inject;
import com.numhero.client.model.datacargo.invoice.InvoiceListRequest;
import com.numhero.client.model.datacargo.invoice.InvoiceListResponse;
import com.numhero.client.model.datacargo.moneyin.MoneyInRecapRequest;
import com.numhero.client.model.datacargo.moneyin.MoneyInRecapResponse;
import com.numhero.client.mvp.BasePresenter;
import com.numhero.client.mvp.EditPageView;
import com.numhero.client.mvp.GenericMoneyinTabViewPage;
import com.numhero.client.place.PlaceManager;
import com.numhero.client.service.Service;
import com.numhero.client.service.ServiceCallbackImpl;
import com.numhero.shared.enums.InvoiceTypeEnum;

public class MoneyinPresenter extends BasePresenter {
    private Service<InvoiceListRequest, InvoiceListResponse> invoiceListService;
    private Service<MoneyInRecapRequest, MoneyInRecapResponse> moneyInRecapListService;

    @Inject
    public MoneyinPresenter(PlaceManager eventManager, MoneyinPanel moneyInPanel,
                            Service<InvoiceListRequest, InvoiceListResponse> invoiceListService,
                            Service<MoneyInRecapRequest, MoneyInRecapResponse> moneyInRecapListService) {
        super(eventManager, new GenericMoneyinTabViewPage(moneyInPanel));
        this.invoiceListService = invoiceListService;
        this.moneyInRecapListService = moneyInRecapListService;
    }

    @Override
    public EditPageView getView() {
        return (EditPageView) super.getView();
    }

    protected MoneyinPanel getMoneyInPanel() {
        return ((MoneyinPanel) getView().getContentPanel().getContentWidget());
    }

    protected void onShow() {
        InvoiceListRequest request = new InvoiceListRequest(InvoiceTypeEnum.Invoice);
        invoiceListService.execute(request, new ServiceCallbackImpl<InvoiceListResponse>() {
            @Override
            public void onSuccess(InvoiceListResponse response) {
                getMoneyInPanel().invoicesTable.setEntities(response.getEntityList());
            }
        });

        InvoiceListRequest request2 = new InvoiceListRequest(InvoiceTypeEnum.Estimate);
        invoiceListService.execute(request2, new ServiceCallbackImpl<InvoiceListResponse>() {
            @Override
            public void onSuccess(InvoiceListResponse response) {
                getMoneyInPanel().estimatesTable.setEntities(response.getEntityList());
            }
        });

        MoneyInRecapRequest request3 = new MoneyInRecapRequest();
        moneyInRecapListService.execute(request3, new ServiceCallbackImpl<MoneyInRecapResponse>() {
            @Override
            public void onSuccess(MoneyInRecapResponse response) {
                getMoneyInPanel().moneyInSummaryTable.setRecaps(response.getRows());
            }
        });
    }
}
