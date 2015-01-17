package com.numhero.client.mvp.moneyin;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.numhero.client.mvp.home.InvoicesRecapTable;

public class MoneyinPanel extends Composite {

    private static MoneyinPanelUiBinder uiBinder = GWT.create(MoneyinPanelUiBinder.class);

    interface MoneyinPanelUiBinder extends UiBinder<Widget, MoneyinPanel> {
    }

    @UiField
    InvoicesRecapTable invoicesTable;

    @UiField
    InvoicesRecapTable estimatesTable;

    @UiField
    MoneyInSummaryTable moneyInSummaryTable;

    public MoneyinPanel() {
        initWidget(uiBinder.createAndBindUi(this));
    }
}
