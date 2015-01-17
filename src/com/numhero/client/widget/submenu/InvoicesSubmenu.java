package com.numhero.client.widget.submenu;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class InvoicesSubmenu extends Composite {

    private static InvoicesSubmenuUiBinder uiBinder = GWT
            .create(InvoicesSubmenuUiBinder.class);

    interface InvoicesSubmenuUiBinder extends UiBinder<Widget, InvoicesSubmenu> {
    }

    public InvoicesSubmenu() {
        initWidget(uiBinder.createAndBindUi(this));
    }


}
