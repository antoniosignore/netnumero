package com.numhero.client.mvp;

import com.numhero.client.Application;
import com.numhero.client.mvp.decorator.AccountsDecorator;
import com.numhero.client.widget.TabBar.INumheroTab;
import com.numhero.client.widget.panelsubmenu.AccountsSubmenuPanel;

public class GenericAccountsTabEditPage extends TabbedEditPage {


    public GenericAccountsTabEditPage(AbstractEditEntityPanel entityPanel) {
        super(entityPanel, new AccountsDecorator());
        setSubmenu(new AccountsSubmenuPanel());

    }

    @Override
    protected String getPageTitle() {
        return Application.getConstants().accounts();
    }

    @Override
    public INumheroTab getCurrentTab() {
        return INumheroTab.accounts;
    }


}
