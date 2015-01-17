package com.numhero.client.mvp.product;

import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.numhero.client.mvp.TabbedPage;
import com.numhero.client.widget.TabBar.INumheroTab;

public class ProductView extends TabbedPage {

    private ProductPanel productPanel;

    @Inject
    public ProductView(ProductPanel productPanel) {
        this.productPanel = productPanel;
        init();
    }

    @Override
    public INumheroTab getCurrentTab() {
        return INumheroTab.moneyin;
    }

    @Override
    public Widget getContent() {
        return productPanel;
    }

    public ProductPanel getProductPanel() {
        return productPanel;
    }
}
