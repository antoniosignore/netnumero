package com.numhero.client.mvp.accounting;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.inject.Inject;
import com.numhero.client.widget.NetNumeroButton;

public class LedgerAccountPanel extends Composite {

    interface ChartOfAccountsUiBinder extends UiBinder<HTMLPanel, LedgerAccountPanel> {
    }

    private static ChartOfAccountsUiBinder uiBinder = GWT.create(ChartOfAccountsUiBinder.class);

    @UiField
    LedgerAccountTable ledgerAccountTable;

    @UiField
    NetNumeroButton btCancel;

    @Inject
    public LedgerAccountPanel() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    public LedgerAccountTable getLedgerAccountTable() {
        return ledgerAccountTable;
    }

    public NetNumeroButton getBtCancel() {
        return btCancel;
    }

    public void setBtCancel(NetNumeroButton btCancel) {
        this.btCancel = btCancel;
    }
}
