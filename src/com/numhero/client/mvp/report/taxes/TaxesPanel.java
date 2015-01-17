package com.numhero.client.mvp.report.taxes;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.inject.Inject;
import com.numhero.client.widget.NetNumeroButton;

public class TaxesPanel extends Composite {

    interface TaxesUiBinder extends UiBinder<HTMLPanel, TaxesPanel> {
    }

    private static TaxesUiBinder uiBinder = GWT.create(TaxesUiBinder.class);

    @UiField
    TaxesTable taxesTable;

    @UiField
    NetNumeroButton btCancel;

    @Inject
    public TaxesPanel() {
        initWidget(uiBinder.createAndBindUi(this));

        taxesTable.hideNavigationButtons();
    }

    public TaxesTable getTaxesTable() {
        return taxesTable;
    }

    public void setTaxesTable(TaxesTable taxesTable) {
        this.taxesTable = taxesTable;
    }

    public NetNumeroButton getBtCancel() {
        return btCancel;
    }

    public void setBtCancel(NetNumeroButton btCancel) {
        this.btCancel = btCancel;
    }
}
