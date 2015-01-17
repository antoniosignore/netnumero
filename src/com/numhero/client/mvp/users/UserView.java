package com.numhero.client.mvp.users;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Widget;
import com.numhero.client.mvp.TabbedPage;
import com.numhero.client.widget.TabBar;

public class UserView extends TabbedPage {

    private UserPanel userPanel;

    public UserView() {
        init();
    }

    @Override
    public TabBar.INumheroTab getCurrentTab() {
        return TabBar.INumheroTab.dashboard;
    }

    @Override
    public Widget getContent() {
        return getUserPanel();
    }

    public UserPanel getUserPanel() {
        if (userPanel == null) {
            userPanel = new UserPanel();
        }
        return userPanel;
    }

    public HasClickHandlers getSaveButton() {
        return userPanel.getBtSave();
    }
}