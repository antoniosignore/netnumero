package com.numhero.client.mvp;

import com.google.gwt.user.client.ui.Widget;
import com.numhero.client.mvp.decorator.TabbedPageDecorator;
import com.numhero.client.widget.TabBar;

public abstract class AbstractTabbedPage extends TabbedPage implements PageView {
    private PageContentPanel contentPanel;
    private TabbedPageDecorator decorator;

    public AbstractTabbedPage(Widget widget, TabbedPageDecorator decorator) {
        this.decorator = decorator;

        contentPanel = new PageContentPanel();
        contentPanel.setMainTitlePanel(getPageTitle());
        contentPanel.setContentWidget(widget);

        setSubmenu(decorator.createSubMenu());

        init();

    }

    protected String getPageTitle(){
        return decorator.getTabTitle();
    }

    @Override
    public PageContentPanel getContentPanel() {
        return contentPanel;
    }

    @Override
    public void setDetailTitlePanel(String detailTitle) {
        contentPanel.setDetailTitlePanel(detailTitle);
    }

    @Override
    public Widget getContent() {
        return contentPanel;
    }

    @Override
    public void setSubmenu(Widget submenu) {
        contentPanel.setSubmenu(submenu);
    }

    @Override
    public TabBar.INumheroTab getCurrentTab() {
        return decorator.getCurrentTab();
    }

}
