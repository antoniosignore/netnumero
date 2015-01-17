package com.numhero.client.widget.submenu;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class ExpensesSubmenu extends Composite {

    private static ExpensesSubmenuUiBinder uiBinder = GWT
            .create(ExpensesSubmenuUiBinder.class);

    interface ExpensesSubmenuUiBinder extends UiBinder<Widget, ExpensesSubmenu> {
    }

    public ExpensesSubmenu() {
        initWidget(uiBinder.createAndBindUi(this));
    }

}
