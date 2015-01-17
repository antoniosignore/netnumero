package com.numhero.client.mvp.home;

import com.numhero.client.mvp.TabbedPage;
import com.numhero.client.widget.TabBar;

public class HomeView extends TabbedPage {
    private HomePanel homePanel;

    public HomeView() {
        init();
    }

    @Override
    public HomePanel getContent() {
        if (homePanel == null)
            homePanel = new HomePanel();
        return homePanel;
    }

    public TabBar.INumheroTab getCurrentTab() {
        return TabBar.INumheroTab.dashboard;
    }

}
