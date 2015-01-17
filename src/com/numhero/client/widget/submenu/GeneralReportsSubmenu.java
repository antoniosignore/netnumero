package com.numhero.client.widget.submenu;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class GeneralReportsSubmenu extends Composite {

    private static GeneralReportsSubmenuUiBinder uiBinder = GWT
            .create(GeneralReportsSubmenuUiBinder.class);

    interface GeneralReportsSubmenuUiBinder extends
            UiBinder<Widget, GeneralReportsSubmenu> {
    }

    public GeneralReportsSubmenu() {
        initWidget(uiBinder.createAndBindUi(this));
    }

}
