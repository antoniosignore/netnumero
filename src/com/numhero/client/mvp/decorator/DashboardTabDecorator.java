package com.numhero.client.mvp.decorator;

import com.google.gwt.user.client.ui.Widget;
import com.numhero.client.widget.TabBar;

public class DashboardTabDecorator implements TabbedPageDecorator {

    @Override
    public Widget createSubMenu() {
        return null;
    }

    @Override
    public String getTabTitle() {
        return "";
    }

    @Override
    public TabBar.INumheroTab getCurrentTab() {
        return TabBar.INumheroTab.dashboard;
    }
}
