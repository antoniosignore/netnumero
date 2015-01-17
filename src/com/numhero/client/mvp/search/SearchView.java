package com.numhero.client.mvp.search;

import com.google.gwt.user.client.ui.Widget;
import com.numhero.client.mvp.TabbedPage;
import com.numhero.client.widget.TabBar;

public class SearchView extends TabbedPage {

    private SearchPanel searchPanel;

    public SearchView() {
        init();
    }

    @Override
    public TabBar.INumheroTab getCurrentTab() {
        return TabBar.INumheroTab.search;
    }

    @Override
    public Widget getContent() {
        return getSearchPanel();
    }

    public SearchPanel getSearchPanel() {
        if (searchPanel == null) {
            searchPanel = new SearchPanel();
        }
        return searchPanel;
    }
}
