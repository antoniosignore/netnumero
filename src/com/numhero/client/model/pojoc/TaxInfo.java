package com.numhero.client.model.pojoc;

import com.google.gwt.user.client.ui.SuggestOracle.Suggestion;
import com.numhero.shared.enums.AccountClassEnum;
import com.numhero.shared.enums.AccountingGroupEnum;
import com.numhero.shared.enums.CurrencyEnum;
import com.numhero.shared.pojoc.SearchablePojo;
import com.numhero.shared.pojoc.field.BooleanField;
import com.numhero.shared.pojoc.field.DateField;
import com.numhero.shared.pojoc.field.DoubleField;
import com.numhero.shared.pojoc.field.EnumField;

import java.util.Date;

public class TaxInfo extends SearchablePojo implements Suggestion, LedgerAccountIF {
    private static final long serialVersionUID = 4965781049733812434L;

    public DoubleField fPercent = doubleField("percent");
    public BooleanField fIsVAT = booleanField("isVat");

    public EnumField<CurrencyEnum> fCurrency = enumField("currency", CurrencyEnum.EUR);

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

    public Double getPercent() {
        return fPercent.getValue();
    }

    public void setPercent(Double percent) {
        fPercent.setValue(percent);
    }

    public CurrencyEnum getCurrency() {
        return fCurrency.getValue();
    }

    public void setCurrency(CurrencyEnum currency) {
        fCurrency.setValue(currency);
    }

    public String getDisplayString() {
        return fName.getValue();
    }

    public String getReplacementString() {
        return fName.getValue();
    }

    public TaxInfo clone() {
        TaxInfo ret = new TaxInfo();
        ret.copyFrom(this);
        return ret;
    }

    @Override
    public AccountingGroupEnum getAccountingGroup() {
        return AccountingGroupEnum.Liability;
    }

    @Override
    public AccountClassEnum getAccountClass() {
        return AccountClassEnum.TaxInfo;
    }

    @Override
    public Boolean isPersonalLedger() {
        return true;
    }
    
    @Override
    public String getKind() {
    	return "TaxInfo";
    }
}
