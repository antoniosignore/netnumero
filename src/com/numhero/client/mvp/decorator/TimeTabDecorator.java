package com.numhero.client.mvp.decorator;

import com.google.gwt.user.client.ui.Widget;
import com.numhero.client.Application;
import com.numhero.client.widget.TabBar;
import com.numhero.client.widget.panelsubmenu.TimeSubmenuPanel;

public class TimeTabDecorator implements TabbedPageDecorator {
    @Override
    public Widget createSubMenu() {
        return new TimeSubmenuPanel();
    }

    @Override
    public String getTabTitle() {
        return Application.getConstants().time();
    }

    @Override
    public TabBar.INumheroTab getCurrentTab() {
        return TabBar.INumheroTab.time;
    }
}
