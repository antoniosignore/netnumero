package com.numhero.client.widget.submenu;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class ContractorsSubmenu extends Composite {

    private static ContractorsSubmenuUiBinder uiBinder = GWT
            .create(ContractorsSubmenuUiBinder.class);

    interface ContractorsSubmenuUiBinder extends
            UiBinder<Widget, ContractorsSubmenu> {
    }

    public ContractorsSubmenu() {
        initWidget(uiBinder.createAndBindUi(this));
    }

}
