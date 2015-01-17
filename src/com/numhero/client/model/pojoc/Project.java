package com.numhero.client.model.pojoc;

import com.google.gwt.user.client.ui.SuggestOracle.Suggestion;
import com.numhero.shared.enums.BillingMethodEnum;
import com.numhero.shared.enums.CurrencyEnum;
import com.numhero.shared.enums.ProjectStateEnum;
import com.numhero.shared.enums.TimeUnitEnum;
import com.numhero.shared.pojoc.DetailBasePojo;
import com.numhero.shared.pojoc.SearchablePojo;
import com.numhero.shared.pojoc.field.*;

import java.util.Date;

public class Project extends SearchablePojo implements Suggestion {
	private static final long serialVersionUID = 148894962811016859L;

	public DateField fLastBilled = dateField("lastBilled", null);
    public DoubleField fTotalBilledTime = doubleField("totalTime");
    public DoubleField fBillableTime = doubleField("notBilledTime");
    public EnumField<ProjectStateEnum> fState = enumField("state", ProjectStateEnum.active);
    public EnumField<BillingMethodEnum> fBillingMethod = enumField("billingMethod", BillingMethodEnum.FLAT_AMOUNT);
    public IdField fClientSupplierID = idField("clientSupplierID");
    public StringField fClientSupplierName = stringField("clientSupplierName", 100);
    public DoubleField fFlatBillingRate = doubleField("flatBillingRate");

    public DoubleField fBillingRate = doubleField("billingRate");
    public EnumField<TimeUnitEnum> fTimeUnit = enumField("timeUnit", TimeUnitEnum.Hour);

    public OwnedListField<ProjectTaskDetail> fProjectTaskDetails = ownedListField("projectTaskDetails");
    public OwnedListField<ProjectStaffDetail> fProjectStaffDetails = ownedListField("projectStaffDetails");

    public EnumField<CurrencyEnum> fCurrency = enumField("currency", CurrencyEnum.EUR);
    public DoubleField fValue = doubleField("value", 0D);
    public DateField fDate = dateField("date", new Date());

    @Override
    public String getDisplayString() {
        return fName.getValue();
    }

    @Override
    public String getReplacementString() {
        return fName.getValue();
    }

    @Override
    public DetailBasePojo createNewDetail(String collectionName) {
        if ("projectTaskDetails".equals(collectionName))
            return new ProjectTaskDetail();
        else
            return new ProjectStaffDetail();
    }

    public Project clone() {
        Project ret = new Project();
        ret.copyFrom(this);
        return ret;
    }
    
    @Override
    public String getKind() {
    	return "Project";
    }
}
