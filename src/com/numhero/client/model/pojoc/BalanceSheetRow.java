package com.numhero.client.model.pojoc;

import com.numhero.shared.enums.AccountingGroupEnum;
import com.numhero.shared.enums.BalanceSheetEnum;
import com.numhero.shared.enums.CurrencyEnum;
import com.numhero.shared.pojoc.EntityPojo;
import com.numhero.shared.pojoc.field.DoubleField;
import com.numhero.shared.pojoc.field.EnumField;
import com.numhero.shared.pojoc.field.StringField;

public class BalanceSheetRow extends EntityPojo {

    private static final String CURRENCY = "currency";
    private static final String DEBIT_VALUE = "debitValue";
    private static final String CREDIT_VALUE = "creditValue";
    private static final String LEDGER_ACCOUNT_NAME = "ledgerAccountName";
    private static final String GROUP_ENUM = "groupEnum";
    private static final String BALANCE_SHEET_TYPE = "balanceSheetType";

    public StringField fNominalLedgerName = stringField(LEDGER_ACCOUNT_NAME, 100);
    public EnumField<CurrencyEnum> fCurrency = enumField(CURRENCY, CurrencyEnum.EUR);
    public DoubleField fDebitValue = doubleField(DEBIT_VALUE, 0D);
    public DoubleField fCreditValue = doubleField(CREDIT_VALUE, 0D);
    public EnumField<AccountingGroupEnum> fAccountingGroup = enumField(GROUP_ENUM, AccountingGroupEnum.Expense);
    public EnumField<BalanceSheetEnum> fBalanceSheetType = enumField(BALANCE_SHEET_TYPE, BalanceSheetEnum.unused);

}