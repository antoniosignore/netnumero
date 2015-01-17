package com.numhero.client.mvp.accounting;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.inject.Inject;
import com.numhero.client.widget.NetNumeroButton;

public class LegsPanel extends Composite {

    interface LegsUiBinder extends UiBinder<HTMLPanel, LegsPanel> {
    }

    private static LegsUiBinder uiBinder = GWT.create(LegsUiBinder.class);

    @UiField
    LegsTable legsTable;

    @UiField
    NetNumeroButton btCancel;

    @UiField
    Label tbBusinessTransactionEnum;

    @UiField
    Anchor tbReferenceDoc;

    @Inject
    public LegsPanel() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    public LegsTable getLegsTable() {
        return legsTable;
    }

    public void setLegsTable(LegsTable legsTable) {
        this.legsTable = legsTable;
    }

    public NetNumeroButton getBtCancel() {
        return btCancel;
    }

    public void setBtCancel(NetNumeroButton btCancel) {
        this.btCancel = btCancel;
    }

    public Label getTbBusinessTransactionEnum() {
        return tbBusinessTransactionEnum;
    }

    public void setTbBusinessTransactionEnum(Label tbBusinessTransactionEnum) {
        this.tbBusinessTransactionEnum = tbBusinessTransactionEnum;
    }

    public Anchor getTbReferenceDoc() {
        return tbReferenceDoc;
    }

    public void setTbReferenceDoc(Anchor tbReferenceDoc) {
        this.tbReferenceDoc = tbReferenceDoc;
    }
}
