package com.numhero.client.mvp.service;

import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.numhero.client.mvp.TabbedPage;
import com.numhero.client.widget.TabBar.INumheroTab;

public class ServiceView extends TabbedPage {

    private ServicePanel servicePanel;

    @Inject
    public ServiceView(ServicePanel productPanel) {
        this.servicePanel = productPanel;
        init();
    }

    @Override
    public INumheroTab getCurrentTab() {
        return INumheroTab.moneyin;
    }

    @Override
    public Widget getContent() {
        return servicePanel;
    }

    public ServicePanel getProductPanel() {
        return servicePanel;
    }
}
