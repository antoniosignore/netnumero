package com.numhero.client.widget.submenu;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class ClientsSubmenu extends Composite {

    private static ClientsSubmenuUiBinder uiBinder = GWT
            .create(ClientsSubmenuUiBinder.class);

    interface ClientsSubmenuUiBinder extends UiBinder<Widget, ClientsSubmenu> {
    }

    public ClientsSubmenu() {
        initWidget(uiBinder.createAndBindUi(this));
    }


}
