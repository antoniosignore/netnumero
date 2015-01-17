package com.numhero.client.mvp.product;

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

//todo mikado it should extend EditPresenter
@Singleton
public class ProductPresenter extends BasePresenter {
    private Service<GetItemRequest, GetItemResponse> getService;
    private Service<SaveProductRequest, SaveProductResponse> saveService;
    private ProductConstants constants;
    private ProductService product;

    @Inject
    public ProductPresenter(PlaceManager eventManager,
                            Service<GetItemRequest, GetItemResponse> getService,
                            Service<SaveProductRequest, SaveProductResponse> saveService,
                            ProductPanel productPanel,
                            ProductConstants constants) {
        super(eventManager, new GenericMoneyinTabEditPage(productPanel));
        this.getService = getService;
        this.saveService = saveService;
        this.constants = constants;
    }


    @Override
    public GenericMoneyinTabEditPage getView() {
        return (GenericMoneyinTabEditPage) super.getView();
    }

    private ProductPanel getProductPanel() {
        return ((ProductPanel) getView().getContentPanel().getContentWidget());
    }

    @Override
    protected void onShow() {
        if (getUrl().getId() == null) {
            String constantsNewEntity = constants.newProduct();
            getView().setDetailTitlePanel(constantsNewEntity);
            product = new ProductService();
            if (ClientCache.getCurrentBA() != null) {
                product.fCurrency.setValue(ClientCache.getCurrentBA().fCurrency.getValue());
            }
            getProductPanel().setPojo(product);
        } else {
            String constantsEditEntity = constants.editProduct();
            getView().setDetailTitlePanel(constantsEditEntity);
            GetItemRequest request = new GetItemRequest();
            request.setEntityId(getUrl().getId());

            getService.execute(request, new ServiceCallbackImpl<GetItemResponse>() {
                @Override
                public void onSuccess(GetItemResponse response) {
                    product = response.getEntity();
                    getProductPanel().setPojo(product);
                }
            });
        }
    }

    @Override
    protected void onBind() {
        super.onBind();
        getProductPanel().getBtSave().addClickHandler(getSaveHandler());
        getProductPanel().getBtCancel().setHref("#products");
    }

    private ClickHandler getSaveHandler() {
        ClickHandler ret = new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                if (getProductPanel().saveValuesFromUi()) {
                    SaveProductRequest request = new SaveProductRequest();
                    request.setProduct(product);
                    Application.showGlasspanelLoading();
                    saveService.execute(request, new ServiceCallbackImpl<SaveProductResponse>() {
                        @Override
                        public void onSuccess(SaveProductResponse response) {
                            // TODO present message in parent view
                            Application.toasterMessage(Application.getConstants().productSaved());
                            Application.getPlaceManager().moveToPlace("products");
                        }
                    });
                }
            }
        };
        return ret;
    }
}
