package com.numhero.client.mvp.report.receivables;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.inject.Inject;
import com.numhero.client.widget.NetNumeroButton;

public class ReceivablesPanel extends Composite {

    interface ReceivablesUiBinder extends UiBinder<HTMLPanel, ReceivablesPanel> {
    }

    private static ReceivablesUiBinder uiBinder = GWT.create(ReceivablesUiBinder.class);

    @UiField
    ReceivablesTable receivablesTable;

    @UiField
    NetNumeroButton btCancel;

    @Inject
    public ReceivablesPanel() {
        initWidget(uiBinder.createAndBindUi(this));

        receivablesTable.hideNavigationButtons();
    }

    public ReceivablesTable getReceivablesTable() {
        return receivablesTable;
    }

    public void setReceivablesTable(ReceivablesTable receivablesTable) {
        this.receivablesTable = receivablesTable;
    }

    public NetNumeroButton getBtCancel() {
        return btCancel;
    }

    public void setBtCancel(NetNumeroButton btCancel) {
        this.btCancel = btCancel;
    }
}
