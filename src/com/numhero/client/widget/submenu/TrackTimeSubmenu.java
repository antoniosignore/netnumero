package com.numhero.client.widget.submenu;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class TrackTimeSubmenu extends Composite {

    private static TrackTimeSubmenuUiBinder uiBinder = GWT
            .create(TrackTimeSubmenuUiBinder.class);

    interface TrackTimeSubmenuUiBinder extends
            UiBinder<Widget, TrackTimeSubmenu> {
    }

    public TrackTimeSubmenu() {
        initWidget(uiBinder.createAndBindUi(this));
    }

}
