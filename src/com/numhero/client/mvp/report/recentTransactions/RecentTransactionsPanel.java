package com.numhero.client.mvp.report.recentTransactions;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.inject.Inject;

public class RecentTransactionsPanel extends Composite {

    interface RecentTransactionsUiBinder extends UiBinder<HTMLPanel, RecentTransactionsPanel> {
    }

    private static RecentTransactionsUiBinder uiBinder = GWT.create(RecentTransactionsUiBinder.class);

    @UiField
    RecentTransactionsTable recentTransactionsTable;

    @Inject
    public RecentTransactionsPanel() {
        initWidget(uiBinder.createAndBindUi(this));

        recentTransactionsTable.hideNavigationButtons();
    }

    public RecentTransactionsTable getRecentTransactionsTable() {
        return recentTransactionsTable;
    }

    public void setRecentTransactionsTable(RecentTransactionsTable recentTransactionsTable) {
        this.recentTransactionsTable = recentTransactionsTable;
    }
}
