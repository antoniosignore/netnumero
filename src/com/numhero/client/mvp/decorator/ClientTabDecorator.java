package com.numhero.client.mvp.decorator;

import com.google.gwt.user.client.ui.Widget;
import com.numhero.client.Application;
import com.numhero.client.widget.TabBar;
import com.numhero.client.widget.panelsubmenu.ClientsSubmenuPanel;

public class ClientTabDecorator implements TabbedPageDecorator {

    @Override
    public Widget createSubMenu() {
        return new ClientsSubmenuPanel();
    }

    @Override
    public String getTabTitle() {
        return Application.getConstants().clients();
    }

    @Override
    public TabBar.INumheroTab getCurrentTab() {
        return TabBar.INumheroTab.clients;
    }
}
