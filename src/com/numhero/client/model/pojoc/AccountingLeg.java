package com.numhero.client.model.pojoc;

import com.numhero.shared.enums.AccountClassEnum;
import com.numhero.shared.enums.AccountingEntrySide;
import com.numhero.shared.pojoc.DetailBasePojo;
import com.numhero.shared.pojoc.field.*;

import java.util.Date;

public class AccountingLeg extends DetailBasePojo {

    public static final String DATE = "date";
    public static final String DOUBLE_ENTRY_TYPE = "doubleEntryType";

    public static final String ACCOUNT_ID = "accountId";
    public static final String ACCOUNT_NAME = "accountName";
    public static final String ACCOUNT_CLASS = "accountClass";

//    public static final String REFERENCE_ACCOUNT_CLASS = "referenceAccountClass";
//    public static final String REFERENCE_ACCOUNT_NAME = "referenceAccountName";
    public static final String NOMINAL_CODE = "nominalCode";

    public static final String REFERENCE_ACCOUNT_ID = "referenceAccountId";

    public DateField fDate = dateField(DATE, new Date());
    public EnumField<AccountingEntrySide> fDoubleEntryType = enumField(DOUBLE_ENTRY_TYPE, AccountingEntrySide.credit);

    public IdField fAccountId = idField(ACCOUNT_ID);
    public StringField fAccountName = stringField(ACCOUNT_NAME, 100);
    public EnumField<AccountClassEnum> fAccountClass = enumField(ACCOUNT_CLASS, AccountClassEnum.Category);
    public StringField fNominalCode = stringField(NOMINAL_CODE, 20);
//
//    public IdField fReferenceAccountId = idField(REFERENCE_ACCOUNT_ID);
//    public StringField fReferenceAccountName = stringField(REFERENCE_ACCOUNT_NAME, 100);
//    public EnumField<AccountClassEnum> fReferenceAccountClass = enumField(REFERENCE_ACCOUNT_CLASS, AccountClassEnum.Category);

//    public EnumField<CurrencyEnum> fCurrency = enumField("currency", CurrencyEnum.EUR);
    public DoubleField fValue = doubleField("value", 0D);

}
