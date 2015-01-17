package com.numhero.client.mvp.product;

import com.google.gwt.event.logical.shared.CloseEvent;
import com.google.gwt.event.logical.shared.CloseHandler;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.SuggestOracle.Suggestion;
import com.numhero.client.Application;
import com.numhero.client.model.datacargo.product.ProductListResponse;
import com.numhero.client.model.datacargo.product.ProductServicesListRequest;
import com.numhero.client.model.datacargo.product.SaveProductRequest;
import com.numhero.client.model.datacargo.product.SaveProductResponse;
import com.numhero.client.model.pojoc.ProductService;
import com.numhero.client.mvp.service.ServicePanel;
import com.numhero.client.service.Service;
import com.numhero.client.widget.combobox.DropDownBox;
import com.numhero.client.widget.combobox.ServerSuggestOracle;
import com.numhero.client.widget.combobox.ServerSuggestOracle.CommandItem;

public class ProductServiceSelect extends DropDownBox<ProductServicesListRequest, ProductListResponse> {
    private Service<SaveProductRequest, SaveProductResponse> saveService;
    private ProductService pojo;

    public ProductServiceSelect(
            DropDownBoxHandler handler,
            Service<ProductServicesListRequest, ProductListResponse> getListService,
            Service<SaveProductRequest, SaveProductResponse> saveService) {
        super(getListService, new ProductServicesListRequest());
        setHandler(handler);

        this.saveService = saveService;

        initPojo();
    }

    public void setProduct(Long productId, String name, String description, Double unitPrice) {
        pojo.setId(productId);
        pojo.fName.setValue(name);
        pojo.setDescription(description);
        pojo.setUnitPrice(unitPrice);
        suggestBox.setValue(pojo.fName.getValue(), false);
    }

    @Override
    public void setPojo(Suggestion pojo) {
        super.setPojo(pojo);
        if (pojo instanceof ProductService) {
            this.pojo = (ProductService) pojo;
        }
    }

    @Override
    public ProductService getPojo() {
        return pojo;
    }

    @Override
    protected void initPojo() {
        pojo = new ProductService();
    }

    @Override
    protected void commandSelected(CommandItem commandItem) {
        suggestBox.hideSuggestionList();
        if (commandItem.getReplacementString().equals("+p")) {
            showNewProductDialog();
        } else if (commandItem.getReplacementString().equals("+s")) {
            showNewServiceDialog();
        } else if (commandItem.getReplacementString().equals(ServerSuggestOracle.CommandItem.moreKey)) {
            showMoreDialog();
        }
    }

    private void showNewProductDialog() {
        ProductPanel panel = new ProductPanel();
        ProductDialog dlg = new ProductDialog(saveService, panel, sso.getLastSuggestRequest());
        dlg.setText(Application.getConstants().product());
        addDialogHandler(dlg);
        dlg.center();
    }

    private void showNewServiceDialog() {
        ServicePanel panel = new ServicePanel();
        ProductDialog dlg = new ProductDialog(saveService, panel, sso.getLastSuggestRequest());
        dlg.setText(Application.getConstants().service());
        addDialogHandler(dlg);
        dlg.center();
    }

    private void showMoreDialog() {
        final SearchProductDialog dlg = new SearchProductDialog(getListService, sso.getLastSuggestRequest());
        dlg.addCloseHandler(new CloseHandler<PopupPanel>() {
            @Override
            public void onClose(CloseEvent<PopupPanel> event) {
                if (dlg.getPojo() != null && dlg.getPojo().getId() != null) {
                    suggestBox.setValue(dlg.getPojo().getReplacementString());
                    suggestBox.setFocus(true);
                    handler.itemSelected(dlg.getPojo());
                }
            }
        });
        dlg.center();
    }

    @Override
    protected void addCommandItems(ServerSuggestOracle<ProductServicesListRequest, ProductListResponse> so) {
        so.addCommandItem(new CommandItem("+p", Application.getConstants().newProduct() + "..."));
        so.addCommandItem(new CommandItem("+s", Application.getConstants().newService() + "..."));
        so.addMoreItem();
    }

    private void addDialogHandler(DialogBox dlg) {
        dlg.addCloseHandler(new CloseHandler<PopupPanel>() {
            @Override
            public void onClose(CloseEvent<PopupPanel> event) {
                ProductDialog dlg = (ProductDialog) event.getTarget();
                if (dlg.getProduct() != null && dlg.getProduct().getId() != null) {
                    suggestBox.setValue(dlg.getProduct().getReplacementString());
                    suggestBox.setFocus(true);
                    handler.itemSelected(dlg.getProduct());
                }
            }
        });
    }
}
