package com.numhero.client.model.pojoc;

import com.numhero.shared.enums.AccountClassEnum;
import com.numhero.shared.enums.AccountingGroupEnum;
import com.numhero.shared.enums.CountryEnum;
import com.numhero.shared.enums.CurrencyEnum;
import com.numhero.shared.pojoc.SearchablePojo;
import com.numhero.shared.pojoc.field.*;

import java.util.Date;

public class BankAccount extends SearchablePojo implements LedgerAccountIF {
	private static final long serialVersionUID = -3630543781322880008L;

	public static final String IS_MAIN_TRADING_ACCOUNT = "isMainTradingAccount";
    private static final String LEDGER_ACCOUNT_BALANCE_DATE = "ledgerAccountBalanceDate";
    private static final String LEDGER_ACCOUNT_BALANCE_VALUE = "ledgerAccountBalanceValue";
    private static final String EXTERNAL_ACCOUNT_NUMBER = "externalAccountNumber";
    private static final String COUNTRY = "country";
    private static final String REGION = "region";
    private static final String CITY = "city";
    private static final String ZIP_CODE = "zipCode";
    private static final String ADDRESS = "address";
    private static final String DATE = "date";
    private static final String VALUE = "value";
    private static final String CURRENCY = "currency";
    private static final String OPENING_BALANCE = "openingBalance";
    private static final String ACCOUNT_NUMBER = "accountNumber";
    private static final String IBAN = "iban";
    private static final String SWIFT = "swift";
    private static final String BANK = "bank";

    public StringField fBank = stringField(BANK, 120);
    public StringField fSwift = stringField(SWIFT, 120);
    public StringField fIban = stringField(IBAN, 120);
    public StringField fAccountNumber = stringField(ACCOUNT_NUMBER, 120);
    public DoubleField fOpeningBalance = doubleField(OPENING_BALANCE);

    public EnumField<CurrencyEnum> fCurrency = enumField(CURRENCY, CurrencyEnum.EUR);
    public DoubleField fValue = doubleField(VALUE, 0D);
    public DateField fDate = dateField(DATE, new Date());

    public StringField fAddress = stringField(ADDRESS, 30);
    public StringField fZipCode = stringField(ZIP_CODE, 30);
    public StringField fCity = stringField(CITY, 30);
    public StringField fRegion = stringField(REGION, 30);
    public EnumField<CountryEnum> fCountry = enumField(COUNTRY, CountryEnum.GB);
    public StringField fExternalAccountNumber = stringField(EXTERNAL_ACCOUNT_NUMBER, 120);

    public DoubleField fLedgerAccountBalanceValue = doubleField(LEDGER_ACCOUNT_BALANCE_VALUE);
    public DateField fLedgerAccountBalanceDate = dateField(LEDGER_ACCOUNT_BALANCE_DATE, new Date());

    public BooleanField fIsMainTradingAccount = booleanField(IS_MAIN_TRADING_ACCOUNT, false);
    
    public BankAccount() {
    }

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
        return fId.getValueAsString();
    }

    @Override
    public AccountingGroupEnum getAccountingGroup() {
        return AccountingGroupEnum.Liability;
    }

    @Override
    public AccountClassEnum getAccountClass() {
        return AccountClassEnum.BankAccount;
    }

    @Override
    public Boolean isPersonalLedger() {
        return true;
    }
    
    @Override
    public BankAccount clone() {
    	BankAccount ret = new BankAccount();
    	ret.copyFrom(this);
    	return ret;
    }
    
    @Override
    public String getKind() {
    	return "BankAccount";
    }
}
