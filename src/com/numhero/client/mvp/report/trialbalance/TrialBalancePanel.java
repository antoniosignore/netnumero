package com.numhero.client.mvp.report.trialbalance;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.inject.Inject;

public class TrialBalancePanel extends Composite {

    interface TrialBalanceUiBinder extends UiBinder<HTMLPanel, TrialBalancePanel> {
    }

    private static TrialBalanceUiBinder uiBinder = GWT.create(TrialBalanceUiBinder.class);

    @UiField
    TrialBalanceTable trialBalanceTable;

    @Inject
    public TrialBalancePanel() {
        initWidget(uiBinder.createAndBindUi(this));

        trialBalanceTable.hideNavigationButtons();
    }

    public TrialBalanceTable getTrialBalanceTable() {
        return trialBalanceTable;
    }

    public void setTrialBalanceTable(TrialBalanceTable trialBalanceTable) {
        this.trialBalanceTable = trialBalanceTable;
    }
}
