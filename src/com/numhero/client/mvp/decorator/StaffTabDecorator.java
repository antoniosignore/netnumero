package com.numhero.client.mvp.decorator;

import com.google.gwt.user.client.ui.Widget;
import com.numhero.client.Application;
import com.numhero.client.widget.TabBar;
import com.numhero.client.widget.panelsubmenu.StaffSubmenuPanel;

public class StaffTabDecorator implements TabbedPageDecorator {


    @Override
    public Widget createSubMenu() {
        return new StaffSubmenuPanel();
    }

    @Override
    public String getTabTitle() {
        return Application.getConstants().staff();
    }

    @Override
    public TabBar.INumheroTab getCurrentTab() {
        return TabBar.INumheroTab.staff;
    }
}
