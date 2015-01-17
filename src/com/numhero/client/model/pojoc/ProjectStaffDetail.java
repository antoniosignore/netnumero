package com.numhero.client.model.pojoc;

import com.numhero.shared.enums.CurrencyEnum;
import com.numhero.shared.enums.TimeUnitEnum;
import com.numhero.shared.pojoc.DetailBasePojo;
import com.numhero.shared.pojoc.field.DoubleField;
import com.numhero.shared.pojoc.field.EnumField;
import com.numhero.shared.pojoc.field.IdField;

public class ProjectStaffDetail extends DetailBasePojo {

    public IdField fStaffId = idField("staffId");
    public DoubleField fBillingRate = doubleField("billingRate");
    public EnumField<TimeUnitEnum> fTimeUnit = enumField("timeUnit", TimeUnitEnum.Day);
    public EnumField<CurrencyEnum> fCurrency = enumField("currency", CurrencyEnum.EUR);


}
