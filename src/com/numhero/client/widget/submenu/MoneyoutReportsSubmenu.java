package com.numhero.client.widget.submenu;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class MoneyoutReportsSubmenu extends Composite {

    private static MoneyoutReportsSubmenuUiBinder uiBinder = GWT
            .create(MoneyoutReportsSubmenuUiBinder.class);

    interface MoneyoutReportsSubmenuUiBinder extends
            UiBinder<Widget, MoneyoutReportsSubmenu> {
    }

    public MoneyoutReportsSubmenu() {
        initWidget(uiBinder.createAndBindUi(this));
    }
}
