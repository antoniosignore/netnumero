package com.numhero.client.widget;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Widget;

public class MainTitlePanel extends Composite {

    private static MainTitlePanelUiBinder uiBinder = GWT
            .create(MainTitlePanelUiBinder.class);


    interface MainTitlePanelUiBinder extends UiBinder<Widget, MainTitlePanel> {
    }

    @UiField
    HorizontalPanel rightButtonSpace;

    @UiField
    TitleLevelOne txTitle;

    @UiField
    HorizontalPanel subMenubar;

    public MainTitlePanel() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    public void setPanelTitle(String title) {
        txTitle.setText(title);
    }

    public HorizontalPanel getSubMenubar() {
        return subMenubar;
    }

//	public HorizontalPanel getRightButtonSpace() {
//		return rightButtonSpace;
//	}

    public void setSubMenu(Widget submenuPanel) {
        subMenubar.add(submenuPanel);
    }

}
