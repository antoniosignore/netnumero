package com.numhero.client.model.datacargo.timeentry;

import com.numhero.client.widget.filter.BAPojoFilter;
import com.numhero.shared.datacargo.CommandRequest;
import com.numhero.shared.service.ApplicationCommandEnum;

public class TimeEntryBillingListRequest extends CommandRequest {

    private BAPojoFilter filter;

    public TimeEntryBillingListRequest() {
        setCommand(ApplicationCommandEnum.CommandGetBillableTimeEntries);
    }

    public BAPojoFilter getFilter() {
        return filter;
    }

    public void setFilter(BAPojoFilter filter) {
        this.filter = filter;
    }
}