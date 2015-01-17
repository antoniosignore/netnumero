package com.numhero.client.mvp.report.vat;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.inject.Inject;
import com.numhero.client.widget.NetNumeroButton;

public class VATPanel extends Composite {

    interface VATUiBinder extends UiBinder<HTMLPanel, VATPanel> {
    }

    private static VATUiBinder uiBinder = GWT.create(VATUiBinder.class);

    @UiField
    VATTable vatTable;

    @UiField
    NetNumeroButton btCancel;

    @Inject
    public VATPanel() {
        initWidget(uiBinder.createAndBindUi(this));

        vatTable.hideNavigationButtons();
    }

    public VATTable getVATTable() {
        return vatTable;
    }

    public void setVATTable(VATTable vatTable) {
        this.vatTable = vatTable;
    }

    public NetNumeroButton getBtCancel() {
        return btCancel;
    }

    public void setBtCancel(NetNumeroButton btCancel) {
        this.btCancel = btCancel;
    }
}
