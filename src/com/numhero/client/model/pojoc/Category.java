package com.numhero.client.model.pojoc;

import com.google.gwt.user.client.ui.SuggestOracle;
import com.numhero.shared.enums.AccountClassEnum;
import com.numhero.shared.enums.AccountingGroupEnum;
import com.numhero.shared.pojoc.SearchablePojo;
import com.numhero.shared.pojoc.field.DateField;
import com.numhero.shared.pojoc.field.DoubleField;

import java.util.Date;

public class Category extends SearchablePojo implements SuggestOracle.Suggestion, LedgerAccountIF, Comparable<Category> {
    private static final long serialVersionUID = 7516368289129218698L;

    public DoubleField fTaxPercent = doubleField("taxPercent", 0D);

    public DoubleField fLedgerAccountBalanceValue = doubleField("ledgerAccountBalanceValue");
    public DateField fLedgerAccountBalanceDate = dateField("ledgerAccountBalanceDate", new Date());

    @Override
    public Double getBalance() {
        return fLedgerAccountBalanceValue.getValue();
    }

    @Override
    public Date getBalanceDate() {
        return fLedgerAccountBalanceDate.getValue();
    }

    public Category clone() {
        Category ret = new Category();
        ret.copyFrom(this);
        return ret;
    }

    @Override
    public AccountingGroupEnum getAccountingGroup() {
        return AccountingGroupEnum.Expense;
    }

    @Override
    public AccountClassEnum getAccountClass() {
        return AccountClassEnum.Category;
    }

    @Override
    public Boolean isPersonalLedger() {
        return true;
    }

    @Override
    public String getCode() {
        return fId.getValueAsString();
    }

    @Override
    public int compareTo(Category o) {
        return o.fName.getValue().compareTo(this.fName.getValue());
    }

    @Override
    public String getKind() {
        return "Category";
    }
}
