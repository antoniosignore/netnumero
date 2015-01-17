package com.numhero.client.widget.submenu;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class EstimatesSubmenu extends Composite {

    private static EstimatesSubmenuUiBinder uiBinder = GWT
            .create(EstimatesSubmenuUiBinder.class);

    interface EstimatesSubmenuUiBinder extends
            UiBinder<Widget, EstimatesSubmenu> {
    }

    public EstimatesSubmenu() {
        initWidget(uiBinder.createAndBindUi(this));
    }

}
