package com.numhero.client.mvp.service;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.numhero.client.Application;
import com.numhero.client.ClientCache;
import com.numhero.client.model.datacargo.product.GetItemRequest;
import com.numhero.client.model.datacargo.product.GetItemResponse;
import com.numhero.client.model.datacargo.product.SaveProductRequest;
import com.numhero.client.model.datacargo.product.SaveProductResponse;
import com.numhero.client.model.pojoc.ProductService;
import com.numhero.client.mvp.BasePresenter;
import com.numhero.client.mvp.GenericMoneyinTabEditPage;
import com.numhero.client.place.PlaceManager;
import com.numhero.client.service.Service;
import com.numhero.client.service.ServiceCallbackImpl;

@Singleton
public class ServicePresenter extends BasePresenter {
    private Service<GetItemRequest, GetItemResponse> getService;
    private Service<SaveProductRequest, SaveProductResponse> saveService;
    private ServiceConstants constants;
    private ProductService product;

    @Inject
    public ServicePresenter(PlaceManager eventManager,
                            Service<GetItemRequest, GetItemResponse> getService,
                            Service<SaveProductRequest, SaveProductResponse> saveService,
                            ServiceConstants constants) {
        super(eventManager, new GenericMoneyinTabEditPage(new ServicePanel()));
        this.getService = getService;
        this.saveService = saveService;
        this.constants = constants;
    }


    @Override
    public GenericMoneyinTabEditPage getView() {
        return (GenericMoneyinTabEditPage) super.getView();
    }

    private ServicePanel getServicePanel() {
        return ((ServicePanel) getView().getContentPanel().getContentWidget());
    }

    @Override
    protected void onShow() {
        if (getUrl().getId() == null) {
            String constantsNewEntity = constants.newService();
            getView().setDetailTitlePanel(constantsNewEntity);
            product = new ProductService();
            if (ClientCache.getCurrentBA() != null) {
                product.fCurrency.setValue(ClientCache.getCurrentBA().fCurrency.getValue());
            }
            getServicePanel().setPojo(product);
        } else {
            String constantsEditEntity = constants.editService();
            getView().setDetailTitlePanel(constantsEditEntity);
            GetItemRequest request = new GetItemRequest();
            request.setEntityId(getUrl().getId());

            getService.execute(request, new ServiceCallbackImpl<GetItemResponse>() {
                @Override
                public void onSuccess(GetItemResponse response) {
                    product = response.getEntity();
                    getServicePanel().setPojo(product);
                }
            });
        }
    }

    @Override
    protected void onBind() {
        super.onBind();
        getServicePanel().getBtSave().addClickHandler(getSaveHandler());
        getServicePanel().getBtCancel().setHref("#services");
    }

    private ClickHandler getSaveHandler() {
        ClickHandler ret = new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                if (getServicePanel().saveValuesFromUi()) {
                    SaveProductRequest request = new SaveProductRequest();
                    request.setProduct(product);
                    Application.showGlasspanelLoading();
                    saveService.execute(request, new ServiceCallbackImpl<SaveProductResponse>() {
                        @Override
                        public void onSuccess(SaveProductResponse response) {
                            // TODO present message in parent view
                            Application.toasterMessage(Application.getConstants().serviceSaved());
                            Application.getPlaceManager().moveToPlace("services");
                        }
                    });
                }
            }
        };
        return ret;
    }
}
