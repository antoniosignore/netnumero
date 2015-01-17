package com.numhero.client.model.pojoc;

import com.numhero.shared.enums.CurrencyEnum;
import com.numhero.shared.enums.TransactionEnum;
import com.numhero.shared.pojoc.SearchablePojo;
import com.numhero.shared.pojoc.field.*;

import java.util.Date;

public class BankTransaction extends SearchablePojo {
    private static final long serialVersionUID = 6121021337282185888L;

    public IdField fBankAccountId = idField("bankAccountId");
    public StringField fBankAccountName = stringField("bankAccountName", 100);
    public StringField fNotes = stringField("notes", 100);
    public EnumField<TransactionEnum> fType = enumField("bankTransactiontype", TransactionEnum.deposit);

    public EnumField<CurrencyEnum> fCurrency = enumField("currency", CurrencyEnum.EUR);
    public DoubleField fValue = doubleField("value", 0D);
    public DateField fDate = dateField("date", new Date());

    public IdField fAccountID = idField("accountID");
    public StringField fAccountName = stringField("accountName", 100);

    public Long getAccountID() {
        return fAccountID.getValue();
    }

    public void setAccountID(Long accountID) {
        fAccountID.setValue(accountID);
    }

    public String getAccountName() {
        return fAccountName.getValue();
    }

    public void setAccountName(String accountName) {
        fAccountName.setValue(accountName);
    }
    
    public BankTransaction clone() {
    	BankTransaction ret = new BankTransaction();
    	ret.copyFrom(this);
    	
    	return ret;
    }

    @Override
    public String getKind() {
    	return "BankTransaction";
    }
}
