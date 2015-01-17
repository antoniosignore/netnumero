package com.numhero.client.model.pojoc;

import com.numhero.shared.enums.CurrencyEnum;
import com.numhero.shared.enums.InvoiceStatusEnum;
import com.numhero.shared.enums.ReceiptStatusEnum;
import com.numhero.shared.enums.RecurringFrequencyEnum;
import com.numhero.shared.pojoc.SearchablePojo;
import com.numhero.shared.pojoc.field.*;

import java.util.Date;

public class ExpenseReceipt extends SearchablePojo {
    private static final long serialVersionUID = 3820733886626470373L;

    public static final String RECEIPT_STATUS = "receiptStatus";

    public IdField fClientSupplierID = idField("clientSupplierID");
    public StringField fClientSupplierName = stringField("clientSupplierName", 100);

    public LongField fCategoryID = idField("categoryID");
    public StringField fCategoryName = stringField("categoryName", 100);

    public IdField fStaffId = idField("staffId");
    public StringField fStaffName = stringField("staffName", 100);

    public EnumField<InvoiceStatusEnum> fInvoiceStatus = enumField("status", InvoiceStatusEnum.Unbilled);
    public StringField fNotes = stringField("notes", 100);
    public DateField fDatePaid = dateField("paidDate", new Date());

    public EnumField<CurrencyEnum> fCurrency = enumField("currency", CurrencyEnum.EUR);
    public DoubleField fValue = doubleField("value", 0D);
    public DateField fDate = dateField("date", new Date());

    public BooleanField fRecurring = booleanField("recurring", false);
    public EnumField<RecurringFrequencyEnum> fFrequency = enumField("frequency", RecurringFrequencyEnum.monthly);

    public EnumField<ReceiptStatusEnum> fReceiptStatus = enumField(RECEIPT_STATUS, ReceiptStatusEnum.Presented);

    public BusinessTransaction clone() {
        BusinessTransaction ret = new BusinessTransaction();
        ret.copyFrom(this);
        return ret;
    }
    
    @Override
    public String getKind() {
    	return "ExpenseReceipt";
    }
}
