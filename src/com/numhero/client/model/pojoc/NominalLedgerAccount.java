package com.numhero.client.model.pojoc;

import com.google.gwt.user.client.ui.SuggestOracle;
import com.numhero.shared.enums.AccountClassEnum;
import com.numhero.shared.enums.AccountingGroupEnum;
import com.numhero.shared.enums.BalanceSheetEnum;
import com.numhero.shared.pojoc.SearchablePojo;
import com.numhero.shared.pojoc.field.DateField;
import com.numhero.shared.pojoc.field.DoubleField;
import com.numhero.shared.pojoc.field.EnumField;
import com.numhero.shared.pojoc.field.StringField;

import java.util.Date;

public class NominalLedgerAccount extends SearchablePojo implements SuggestOracle.Suggestion, LedgerAccountIF {
	private static final long serialVersionUID = 2023380938509866263L;

    public static final String ACCOUNTING_GROUP = "accountingGroup";
    public static final String DEBIT = "debit";
    public static final String CODE = "code";
    public static final String CREDIT = "credit";

    public EnumField<AccountingGroupEnum> fAccountingGroup = enumField(ACCOUNTING_GROUP, AccountingGroupEnum.Capital);
    public DoubleField fDebitValue = doubleField(DEBIT, 0D);

    public DoubleField fCreditValue = doubleField(CREDIT, 0D);
    public DoubleField fLedgerAccountBalanceValue = doubleField("ledgerAccountBalanceValue");

    public DateField fLedgerAccountBalanceDate = dateField("ledgerAccountBalanceDate", new Date());
    public EnumField<BalanceSheetEnum> fBalanceSheetType = enumField("balanceSheetType", BalanceSheetEnum.unused);
    public StringField fCode = stringField(CODE, 20);

    @Override
    public Double getBalance() {
        return fLedgerAccountBalanceValue.getValue();
    }

    @Override
    public Date getBalanceDate() {
        return fLedgerAccountBalanceDate.getValue();
    }

    @Override
    public String getCode() {
        return fCode.getValue();
    }

    @Override
    public SearchablePojo clone() {
        return null;
    }

    @Override
    public AccountingGroupEnum getAccountingGroup() {
        return fAccountingGroup.getValue();
    }

    @Override
    public AccountClassEnum getAccountClass() {
        return AccountClassEnum.NominalLedgerAccount;
    }

    @Override
    public Boolean isPersonalLedger() {
        return false;
    }
    
    @Override
    public String getKind() {
    	return "NominalLedgerAccount";
    }
}
