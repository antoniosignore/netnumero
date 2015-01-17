package com.numhero.client.model.pojoc;

import com.google.gwt.user.client.ui.SuggestOracle;
import com.numhero.shared.enums.CurrencyEnum;
import com.numhero.shared.enums.TimeUnitEnum;
import com.numhero.shared.pojoc.SearchablePojo;
import com.numhero.shared.pojoc.field.BooleanField;
import com.numhero.shared.pojoc.field.DoubleField;
import com.numhero.shared.pojoc.field.EnumField;

public class Task extends SearchablePojo implements SuggestOracle.Suggestion {
	private static final long serialVersionUID = 3363036697318557326L;

	public BooleanField fBillable = booleanField("billable", true);
    public DoubleField fBillingRate = doubleField("billingRate");
    public EnumField<TimeUnitEnum> fTimeUnit = enumField("timeUnit", TimeUnitEnum.Day);
    public EnumField<CurrencyEnum> fCurrency = enumField("currency", CurrencyEnum.EUR);

    @Override
    public String getDisplayString() {
        return fName.getValue();
    }

    @Override
    public String getReplacementString() {
        return fName.getValue();
    }

    public Task clone() {
    	Task ret = new Task();
    	ret.copyFrom(this);
    	return ret;
    }

    @Override
    public String getKind() {
    	return "Task";
    }
}
