package com.numhero.client.mvp.decorator;

import com.google.gwt.user.client.ui.Widget;
import com.numhero.client.Application;
import com.numhero.client.widget.TabBar;
import com.numhero.client.widget.panelsubmenu.AccountsSubmenuPanel;

public class AccountsDecorator implements TabbedPageDecorator {

    @Override
    public Widget createSubMenu() {
        return new AccountsSubmenuPanel();
    }

    @Override
    public String getTabTitle() {
        return Application.getConstants().accounts();
    }

    @Override
    public TabBar.INumheroTab getCurrentTab() {
        return TabBar.INumheroTab.accounts;
    }
}
