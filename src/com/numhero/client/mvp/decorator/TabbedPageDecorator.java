package com.numhero.client.mvp.decorator;

import com.google.gwt.user.client.ui.Widget;
import com.numhero.client.widget.TabBar;

public interface TabbedPageDecorator {
    Widget createSubMenu();

    String getTabTitle();

    TabBar.INumheroTab getCurrentTab();
}
