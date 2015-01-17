package com.numhero.client.mvp.report.profitloss;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.inject.Inject;

public class ProfitLossPanel extends Composite {

    interface ProfitLossUiBinder extends UiBinder<HTMLPanel, ProfitLossPanel> {
    }

    private static ProfitLossUiBinder uiBinder = GWT.create(ProfitLossUiBinder.class);

    @UiField
    ProfitLossTable profitLossTable;

    @Inject
    public ProfitLossPanel() {
        initWidget(uiBinder.createAndBindUi(this));

        profitLossTable.hideNavigationButtons();
    }

    public ProfitLossTable getProfitLossTable() {
        return profitLossTable;
    }

    public void setProfitLossTable(ProfitLossTable profitLossTable) {
        this.profitLossTable = profitLossTable;
    }
}
