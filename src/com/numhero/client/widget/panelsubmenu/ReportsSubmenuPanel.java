package com.numhero.client.widget.panelsubmenu;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class ReportsSubmenuPanel extends Composite {

    private static ReportsSubmenuPanelUiBinder uiBinder = GWT
            .create(ReportsSubmenuPanelUiBinder.class);

    interface ReportsSubmenuPanelUiBinder extends
            UiBinder<Widget, ReportsSubmenuPanel> {
    }

    public ReportsSubmenuPanel() {
        initWidget(uiBinder.createAndBindUi(this));
    }

}
