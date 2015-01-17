package com.numhero.client.widget;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;


public class DividerLine extends Composite {

    private static DividerLineUiBinder uiBinder = GWT
            .create(DividerLineUiBinder.class);

    interface DividerLineUiBinder extends UiBinder<Widget, DividerLine> {
    }

    public DividerLine() {
        initWidget(uiBinder.createAndBindUi(this));
    }

}
