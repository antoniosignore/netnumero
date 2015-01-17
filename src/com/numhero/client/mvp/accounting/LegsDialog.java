package com.numhero.client.mvp.accounting;

import com.google.gwt.user.client.ui.DialogBox;
import com.numhero.client.Application;

public class LegsDialog extends DialogBox {

    public LegsDialog(final LegsPanel legsPanel) {
        setModal(true);
        setGlassEnabled(true);
        setAnimationEnabled(true);
        setWidget(legsPanel);
        setText(Application.getConstants().accountingLegs());
    }

}
