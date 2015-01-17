package com.numhero.client.model.pojoc;

import com.numhero.shared.enums.BusinessTransactionEnum;
import com.numhero.shared.enums.ReferenceDocEnum;
import com.numhero.shared.pojoc.DetailBasePojo;
import com.numhero.shared.pojoc.SearchablePojo;
import com.numhero.shared.pojoc.field.*;

import java.util.Date;

public class BusinessTransaction extends SearchablePojo {
	private static final long serialVersionUID = -4128066870552515189L;

	private static final String LEGS = "legs";
    public static final String FIELD_DATE = "date";
    public static final String FIELD_REFERENCE_DOC_ID = "referenceDocId";
    public static final String FIELD_BUSINESS_TRANSACTION_ENUM = "businessTransactionEnum";
    public static final String FIELD_REFERENCE_DOC_NAME = "referenceDocName";
    public static final String FIELD_REFERENCE_DOC_TYPE = "referenceDocType";

    public DateTimeField fDate = dateTimeField(FIELD_DATE, new Date());

    public EnumField<BusinessTransactionEnum> fBusinessTransaction = enumField(FIELD_BUSINESS_TRANSACTION_ENUM, BusinessTransactionEnum.SaleToClient);

    public IdField fReferenceDocId = idField(FIELD_REFERENCE_DOC_ID);

    public EnumField<ReferenceDocEnum> fReferenceDocType = enumField(FIELD_REFERENCE_DOC_TYPE, ReferenceDocEnum.None);

    public StringField fReferenceDocName = stringField(FIELD_REFERENCE_DOC_NAME, 40);

    protected OwnedListField<AccountingLeg> fLegs = ownedListField(LEGS);

    @Override
    public DetailBasePojo createNewDetail(String collectionName) {
        AccountingLeg leg = new AccountingLeg();
        leg.fBusinessAccountUri.setValue(this.fBusinessAccountUri.getValue());
        leg.fDate.setValue(fDate.getValue());
        return leg;
    }

    public BusinessTransaction clone() {
        BusinessTransaction ret = new BusinessTransaction();
        ret.copyFrom(this);
        return ret;
    }

    public OwnedListField<AccountingLeg> getAccountingLegs() {
        return fLegs;
    }

    public void addAccountingLeg(AccountingLeg leg) {
        if (leg != null) {
            fLegs.addDetail(leg);
            leg.fDate.setValue(this.fDate.getValue());
        }
    }

    @Override
    public String getKind() {
    	return "BusinessTransaction";
    }
}
