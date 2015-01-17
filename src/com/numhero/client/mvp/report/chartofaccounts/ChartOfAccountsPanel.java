package com.numhero.client.mvp.report.chartofaccounts;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.inject.Inject;

public class ChartOfAccountsPanel extends Composite {

    interface ChartOfAccountsUiBinder extends UiBinder<HTMLPanel, ChartOfAccountsPanel> {
    }

    private static ChartOfAccountsUiBinder uiBinder = GWT.create(ChartOfAccountsUiBinder.class);

    @UiField
    ChartOfAccountsTable chartOfAccountsTable;

    @Inject
    public ChartOfAccountsPanel() {
        initWidget(uiBinder.createAndBindUi(this));

        chartOfAccountsTable.hideNavigationButtons();
    }

    public ChartOfAccountsTable getChartOfAccountsTable() {
        return chartOfAccountsTable;
    }

    public void setChartOfAccountsTable(ChartOfAccountsTable chartOfAccountsTable) {
        this.chartOfAccountsTable = chartOfAccountsTable;
    }
}
