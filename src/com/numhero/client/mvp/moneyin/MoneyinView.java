package com.numhero.client.mvp.moneyin;

import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.numhero.client.mvp.TabbedPage;
import com.numhero.client.widget.TabBar;
import com.numhero.client.widget.TabBar.INumheroTab;

public class MoneyinView extends TabbedPage {
    private MoneyinPanel moneyinPanel;

    @Inject
    public MoneyinView(MoneyinPanel moneyinPanel) {
        this.moneyinPanel = moneyinPanel;
        init();
    }

    @Override
    public Widget getContent() {
        return moneyinPanel;
    }

    @Override
    public INumheroTab getCurrentTab() {
        return TabBar.INumheroTab.moneyin;
    }

    public MoneyinPanel getMoneyinPanel() {
        return moneyinPanel;
    }

}
