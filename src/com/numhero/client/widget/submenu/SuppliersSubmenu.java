package com.numhero.client.widget.submenu;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class SuppliersSubmenu extends Composite {

    private static SuppliersSubmenuUiBinder uiBinder = GWT
            .create(SuppliersSubmenuUiBinder.class);

    interface SuppliersSubmenuUiBinder extends
            UiBinder<Widget, SuppliersSubmenu> {
    }

    public SuppliersSubmenu() {
        initWidget(uiBinder.createAndBindUi(this));
    }


}
