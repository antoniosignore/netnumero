package com.numhero.client.widget.panelsubmenu;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class TimeSubmenuPanel extends Composite {

    private static TimeSubmenuPanelUiBinder uiBinder = GWT
            .create(TimeSubmenuPanelUiBinder.class);

    interface TimeSubmenuPanelUiBinder extends
            UiBinder<Widget, TimeSubmenuPanel> {
    }

    public TimeSubmenuPanel() {
        initWidget(uiBinder.createAndBindUi(this));
    }

}
