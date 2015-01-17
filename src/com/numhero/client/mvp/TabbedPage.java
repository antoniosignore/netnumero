package com.numhero.client.mvp;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.numhero.client.Application;
import com.numhero.client.widget.Footer;
import com.numhero.client.widget.HeaderPanel;
import com.numhero.client.widget.TabBar.INumheroTab;

public abstract class TabbedPage extends Composite implements BaseView {

    private static TabbedPageUiBinder uiBinder = GWT.create(TabbedPageUiBinder.class);

    interface TabbedPageUiBinder extends UiBinder<Widget, TabbedPage> {
    }

    @UiField
    protected HeaderPanel headerPanel;

    @UiField
    protected Footer footerPanel;

    @UiField
    protected AbsolutePanel contentPanel;

    public TabbedPage() {
        initWidget(uiBinder.createAndBindUi(this));

    }

    public abstract INumheroTab getCurrentTab();

    public void setActiveTab(INumheroTab tab) {
        this.headerPanel.getTabBar().setActiveTab(tab);
    }

    public abstract Widget getContent();

    protected void init() {

        contentPanel.add(getContent());
        setActiveTab(getCurrentTab());
    }

    @Override
    public void replaceInWrapperDiv() {

        RootPanel w = RootPanel.get("wrapper");
        if (w != null) {
            w.clear();
            w.add(this);
        }
    }

    @Override
    public void showGlassPanel() {
        Application.showGlasspanelLoading();
    }

    @Override
    public void showToaster(String message) {
         Application.toasterMessage(message);
    }

    @Override
    public void showError(String message) {
        Window.alert(message);
    }


}
