package com.numhero.client.model.pojoc;

import com.numhero.shared.enums.CurrencyEnum;
import com.numhero.shared.pojoc.EntityPojo;
import com.numhero.shared.pojoc.field.DateField;
import com.numhero.shared.pojoc.field.DoubleField;
import com.numhero.shared.pojoc.field.EnumField;
import com.numhero.shared.pojoc.field.StringField;

import java.util.Date;

public class AccountBalanceRow extends EntityPojo {

    private static final String DATE = "date";
    private static final String BUSINESS_TRANSACTION_TITLE = "businessTransactionTitle";
    private static final String CURRENCY = "currency";
    private static final String DEBIT_VALUE = "debitValue";
    private static final String CREDIT_VALUE = "creditValue";
    private static final String BALANCE = "balance";

    public DateField fDate = dateField(DATE, new Date());
    public StringField fTitle = stringField(BUSINESS_TRANSACTION_TITLE, 100);
    public EnumField<CurrencyEnum> fCurrency = enumField(CURRENCY, CurrencyEnum.EUR);
    public DoubleField fDebitValue = doubleField(DEBIT_VALUE, 0D);
    public DoubleField fCreditValue = doubleField(CREDIT_VALUE, 0D);
    public DoubleField fBalance = doubleField(BALANCE, 0D);

}