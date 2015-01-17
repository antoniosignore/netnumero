package com.numhero.client.mvp.accounting;

import com.google.gwt.user.client.ui.DialogBox;

public class LedgerAccountDialog extends DialogBox {

    public LedgerAccountDialog(final LedgerAccountPanel ledger, String name) {
        setModal(true);
        setGlassEnabled(true);
        setAnimationEnabled(true);
        setWidget(ledger);
        setText(name);
    }

}
