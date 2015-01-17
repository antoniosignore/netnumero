package com.numhero.client.mvp.decorator;

import com.google.gwt.user.client.ui.Widget;
import com.numhero.client.Application;
import com.numhero.client.widget.TabBar;
import com.numhero.client.widget.panelsubmenu.MoneyoutSubmenuPanel;

public class MoneyOutDecorator implements TabbedPageDecorator {

    @Override
    public Widget createSubMenu() {
        return new MoneyoutSubmenuPanel();
    }

    @Override
    public String getTabTitle() {
        return Application.getConstants().moneyOut();
    }

    @Override
    public TabBar.INumheroTab getCurrentTab() {
        return TabBar.INumheroTab.moneyout;
    }
}
