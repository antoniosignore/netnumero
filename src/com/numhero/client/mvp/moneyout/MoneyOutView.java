package com.numhero.client.mvp.moneyout;

import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.numhero.client.mvp.TabbedPage;
import com.numhero.client.widget.TabBar.INumheroTab;

public class MoneyOutView extends TabbedPage {
    private MoneyOutPanel moneyOutPanel;

    @Inject
    public MoneyOutView(MoneyOutPanel moneyOutPanel) {
        this.moneyOutPanel = moneyOutPanel;
        init();
    }

    @Override
    public Widget getContent() {
        return moneyOutPanel;
    }

    @Override
    public INumheroTab getCurrentTab() {
        return INumheroTab.moneyout;
    }

    public MoneyOutPanel getMoneyOutPanel() {
        return moneyOutPanel;
    }

}
