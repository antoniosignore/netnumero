package com.numhero.client.mvp.moneyout;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.numhero.client.mvp.home.ExpensesRecapTable;

public class MoneyOutPanel extends Composite {

    private static MoneyoutPanelUiBinder uiBinder = GWT.create(MoneyoutPanelUiBinder.class);

    interface MoneyoutPanelUiBinder extends UiBinder<Widget, MoneyOutPanel> {
    }

    @UiField
    ExpensesRecapTable invoicesTable;

    @UiField
    MoneyOutSummaryTable moneyOutSummaryTable;

    public MoneyOutPanel() {
        initWidget(uiBinder.createAndBindUi(this));
    }
}
