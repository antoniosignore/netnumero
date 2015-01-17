package com.numhero.client.mvp.home;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.numhero.client.widget.NetNumeroButton;

public class HomePanel extends Composite {

    private static HomePanelUiBinder uiBinder = GWT.create(HomePanelUiBinder.class);

    interface HomePanelUiBinder extends UiBinder<Widget, HomePanel> {
    }

    @UiField
    NetNumeroButton btNewInvoice;

    @UiField
    NetNumeroButton btNewEstimate;

    @UiField
    NetNumeroButton btTimeTrack;

    @UiField
    NetNumeroButton btNewReport;

    @UiField
    InvoicesRecapTable invoicesRecapPanel;

    @UiField
    ExpensesRecapTable expensesRecapPanel;

    @UiField
    HomeRecentTransactionsTable homeRecentTransactionsTable;

    public HomePanel() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    public InvoicesRecapTable getInvoicesRecapPanel() {
        return invoicesRecapPanel;
    }

    public ExpensesRecapTable getExpensesRecapPanel() {
        return expensesRecapPanel;
    }

    public HomeRecentTransactionsTable getRecentTransactionsTable() {
        return homeRecentTransactionsTable;
    }
}
