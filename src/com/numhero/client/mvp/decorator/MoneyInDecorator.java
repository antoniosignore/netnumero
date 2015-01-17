package com.numhero.client.mvp.decorator;

import com.google.gwt.user.client.ui.Widget;
import com.numhero.client.Application;
import com.numhero.client.widget.TabBar;
import com.numhero.client.widget.panelsubmenu.MoneyinSubmenuPanel;

public class MoneyInDecorator implements TabbedPageDecorator {
    @Override
    public Widget createSubMenu() {
        return  new MoneyinSubmenuPanel();
    }

    @Override
    public String getTabTitle() {
        return Application.getConstants().moneyIn();
    }

    @Override
    public TabBar.INumheroTab getCurrentTab() {
        return TabBar.INumheroTab.moneyin;
    }
}
