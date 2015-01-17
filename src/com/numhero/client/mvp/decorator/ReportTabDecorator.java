package com.numhero.client.mvp.decorator;

import com.google.gwt.user.client.ui.Widget;
import com.numhero.client.Application;
import com.numhero.client.widget.TabBar;
import com.numhero.client.widget.panelsubmenu.ReportsSubmenuPanel;

public class ReportTabDecorator implements TabbedPageDecorator {

    @Override
    public Widget createSubMenu() {
        return new ReportsSubmenuPanel();
    }

    @Override
    public String getTabTitle() {
        return Application.getConstants().reports();
    }

    @Override
    public TabBar.INumheroTab getCurrentTab() {
        return TabBar.INumheroTab.reports;
    }
}
