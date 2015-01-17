package com.numhero.client.widget.submenu;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class ItemsSubmenu extends Composite {

    private static ItemsSubmenuUiBinder uiBinder = GWT
            .create(ItemsSubmenuUiBinder.class);

    interface ItemsSubmenuUiBinder extends UiBinder<Widget, ItemsSubmenu> {
    }

    public ItemsSubmenu() {
        initWidget(uiBinder.createAndBindUi(this));
    }

}
