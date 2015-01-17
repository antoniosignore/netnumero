package com.numhero.client.model.pojoc;

import com.numhero.shared.enums.CurrencyEnum;
import com.numhero.shared.pojoc.EntityPojo;
import com.numhero.shared.pojoc.field.DoubleField;
import com.numhero.shared.pojoc.field.EnumField;
import com.numhero.shared.pojoc.field.IntegerField;

public class MoneyInOutRecapRow extends EntityPojo {

    public IntegerField fMonth = integerField(MONTH, 10);
    public IntegerField fYear = integerField(YEAR, 10);
    public EnumField<CurrencyEnum> fCurrency = enumField(CURRENCY, CurrencyEnum.EUR);
    public DoubleField fInvoiceValue = doubleField(INVOICES_TOTAL, 0D);
    public DoubleField fEstimatesValue = doubleField(ESTIMATES_TOTAL, 0D);
    public DoubleField fExpensesValue = doubleField(EXPENSES_TOTAL, 0D);
    public DoubleField fReceiptsValue = doubleField(RECEIPTS_TOTAL, 0D);

    private static final String MONTH = "month";
    private static final String YEAR = "year";
    private static final String CURRENCY = "currency";
    private static final String INVOICES_TOTAL = "invoicesTotal";
    private static final String ESTIMATES_TOTAL = "estimatesTotal";
    private static final String EXPENSES_TOTAL = "expensesTotal";
    private static final String RECEIPTS_TOTAL = "receiptsTotal";
}
