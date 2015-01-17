package com.numhero.client.mvp.bankaccount;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.numhero.client.Application;
import com.numhero.client.model.pojoc.BankAccount;
import com.numhero.client.mvp.AbstractTableForEntities;

import java.util.List;

public class BankAccountsTable extends AbstractTableForEntities<BankAccount> {

    @Override
    public void setEntities(List<BankAccount> BankAccount) {
        removeAllRows();
        int row = 0;
        for (BankAccount bankAccount : BankAccount) {
            row++;
            HTML hID = new HTML("<a href='#bankaccount/" + bankAccount.getId() + "'>" + bankAccount.fName.getValue() + "</a>");
            setWidget(row, 0, getCheckbox(bankAccount.getId()));
            setWidget(row, 1, hID);
            setText(row, 2, bankAccount.getDescription());
            setText(row, 3, bankAccount.fBank.getValue());
            setText(row, 4, bankAccount.fCurrency.getValue().name());
            setText(row, 5, bankAccount.fValue.getValueAsString());
        }
        addEmptyStatus();
    }


	@Override
    protected void setHeader() {
        setHeader(0, "", HasHorizontalAlignment.ALIGN_CENTER, "20px");
        setHeader(1, Application.getConstants().nameOnAccount(), HasHorizontalAlignment.ALIGN_LEFT, "140px");
        setHeader(2, Application.getConstants().description(), HasHorizontalAlignment.ALIGN_LEFT, "140px");
        setHeader(3, Application.getConstants().bankName(), HasHorizontalAlignment.ALIGN_LEFT, "140px");
        setHeader(4, Application.getConstants().currency(), HasHorizontalAlignment.ALIGN_LEFT, "40px");
        setHeader(5, Application.getConstants().currentBalance(), HasHorizontalAlignment.ALIGN_LEFT, "50px");
    }
}
