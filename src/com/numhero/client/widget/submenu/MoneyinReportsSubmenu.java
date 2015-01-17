package com.numhero.client.widget.submenu;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class MoneyinReportsSubmenu extends Composite {

    private static MoneyinReportsSubmenuUiBinder uiBinder = GWT
            .create(MoneyinReportsSubmenuUiBinder.class);

    interface MoneyinReportsSubmenuUiBinder extends
            UiBinder<Widget, MoneyinReportsSubmenu> {
    }

    public MoneyinReportsSubmenu() {
        initWidget(uiBinder.createAndBindUi(this));
    }

}
