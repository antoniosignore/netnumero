package com.numhero.client.mvp.report.deposits;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.inject.Inject;
import com.numhero.client.widget.NetNumeroButton;

public class DepositsPanel extends Composite {

    interface DepositsUiBinder extends UiBinder<HTMLPanel, DepositsPanel> {
    }

    private static DepositsUiBinder uiBinder = GWT.create(DepositsUiBinder.class);

    @UiField
    DepositsTable depositsTable;

    @UiField
    NetNumeroButton btCancel;

    @Inject
    public DepositsPanel() {
        initWidget(uiBinder.createAndBindUi(this));

        depositsTable.hideNavigationButtons();
    }

    public DepositsTable getDepositsTable() {
        return depositsTable;
    }

    public void setDepositsTable(DepositsTable depositsTable) {
        this.depositsTable = depositsTable;
    }

    public NetNumeroButton getBtCancel() {
        return btCancel;
    }

    public void setBtCancel(NetNumeroButton btCancel) {
        this.btCancel = btCancel;
    }
}
