package com.numhero.client.mvp.product;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.DialogBox;
import com.numhero.client.Application;
import com.numhero.client.ClientCache;
import com.numhero.client.model.datacargo.product.SaveProductRequest;
import com.numhero.client.model.datacargo.product.SaveProductResponse;
import com.numhero.client.model.pojoc.ProductService;
import com.numhero.client.mvp.AbstractEditEntityPanel;
import com.numhero.client.service.Service;
import com.numhero.client.service.ServiceCallbackImpl;

public class ProductDialog extends DialogBox {
    private AbstractEditEntityPanel panel;
    private ProductService product;

    public ProductDialog(final Service<SaveProductRequest, SaveProductResponse> saveService,
                         AbstractEditEntityPanel p,
                         String name) {
        setModal(true);
        setGlassEnabled(true);
        setAnimationEnabled(true);

        this.panel = p;
        product = new ProductService();
        product.fName.setValue(name);
        if (ClientCache.getCurrentBA() != null) {
            product.fCurrency.setValue(ClientCache.getCurrentBA().fCurrency.getValue());
        }
        panel.setPojo(product);
        panel.getBtSave().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                if (panel.saveValuesFromUi()) {
                    SaveProductRequest request = new SaveProductRequest();
                    request.setProduct(product);
                    Application.showGlasspanelLoading();
                    saveService.execute(request, new ServiceCallbackImpl<SaveProductResponse>() {
                        @Override
                        public void onSuccess(SaveProductResponse response) {
                            Application.toasterMessage(Application.getConstants().productSaved());
                            product.setId(response.getEntityId());
                            ProductDialog.this.hide();
                        }
                    });
                }
            }
        });
        panel.getBtCancel().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                ProductDialog.this.hide();
            }
        });
        setWidget(panel);
    }

    public ProductService getProduct() {
        return product;
    }
}
