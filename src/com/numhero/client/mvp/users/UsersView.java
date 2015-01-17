package com.numhero.client.mvp.users;

import com.google.gwt.user.client.ui.Widget;
import com.numhero.client.mvp.TabbedPage;
import com.numhero.client.widget.TabBar;

public class UsersView extends TabbedPage {

    private UsersPanel usersPanel;

    public UsersView() {
        this.usersPanel = new UsersPanel();
        init();
    }

    @Override
    public Widget getContent() {
        return usersPanel;
    }

    @Override
    public TabBar.INumheroTab getCurrentTab() {
        return TabBar.INumheroTab.time;
    }

    public UsersPanel getUsersPanel() {
        return usersPanel;
    }
}
