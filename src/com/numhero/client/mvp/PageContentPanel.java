package com.numhero.client.mvp;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.numhero.client.widget.DetailTitlePanel;
import com.numhero.client.widget.MainTitlePanel;

public class PageContentPanel extends Composite {

    private static final PageContentPanelUiBinder uiBinder = GWT
            .create(PageContentPanelUiBinder.class);

    interface PageContentPanelUiBinder extends UiBinder<Widget, PageContentPanel> {
    }

    @UiField
    MainTitlePanel titlePanel;

    @UiField
    DetailTitlePanel detailTitlePanel;

    @UiField
    VerticalPanel tableContainer;


    public PageContentPanel() {
        initWidget(uiBinder.createAndBindUi(this));

    }

    public void setMainTitlePanel(String mainPanelTitle) {
        titlePanel.setPanelTitle(mainPanelTitle);
    }

    public void setDetailTitlePanel(String detailPanelTitle) {
        detailTitlePanel.setHTML(detailPanelTitle);

    }

    public void setSubmenu(Widget submenuPanel) {
        titlePanel.setSubMenu(submenuPanel);
    }

    public void setContentWidget(Widget w) {
        tableContainer.clear();
        if (w != null) {
            tableContainer.add(w);
        }
    }


    public Widget getContentWidget() {
        if (tableContainer.getWidgetCount() == 0) {
            return null;
        } else {
            return tableContainer.getWidget(0);
        }
    }

}
