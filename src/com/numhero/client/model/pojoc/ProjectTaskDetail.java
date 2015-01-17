package com.numhero.client.model.pojoc;

import com.numhero.shared.enums.CurrencyEnum;
import com.numhero.shared.enums.TaskStatusEnum;
import com.numhero.shared.enums.TimeUnitEnum;
import com.numhero.shared.pojoc.DetailBasePojo;
import com.numhero.shared.pojoc.field.*;

public class ProjectTaskDetail extends DetailBasePojo {

    public IdField fTaskId = idField("taskId");
    public BooleanField fBillable = booleanField("billable", true);
    public DoubleField fTotalTime = doubleField("totalTime");
    public DateField fLastBilled = dateField("lastBilled");
    public EnumField<TaskStatusEnum> fStatus = enumField("status", TaskStatusEnum.assigned);
    public DoubleField fBillingRate = doubleField("billingRate", 0D);
    public EnumField<TimeUnitEnum> fTimeUnit = enumField("timeUnit", TimeUnitEnum.Day);
    public EnumField<CurrencyEnum> fCurrency = enumField("currency", CurrencyEnum.EUR);

    public ProjectTaskDetail() {
    }

}
