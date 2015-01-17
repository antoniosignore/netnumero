package com.numhero.client.widget.submenu;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class InternalStaffSubmenu extends Composite {

    private static InternalStaffSubmenuUiBinder uiBinder = GWT
            .create(InternalStaffSubmenuUiBinder.class);

    interface InternalStaffSubmenuUiBinder extends
            UiBinder<Widget, InternalStaffSubmenu> {
    }

    public InternalStaffSubmenu() {
        initWidget(uiBinder.createAndBindUi(this));
    }

}
