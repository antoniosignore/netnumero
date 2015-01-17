package com.numhero.client.model.datacargo.timeentry;

import com.numhero.client.widget.filter.BAPojoFilter;
import com.numhero.shared.datacargo.ListCommandRequest;
import com.numhero.shared.service.ApplicationCommandEnum;

public class TimeEntryListRequest extends ListCommandRequest {

    private BAPojoFilter filter = new BAPojoFilter();

    public TimeEntryListRequest() {
        setCommand(ApplicationCommandEnum.CommandGetTimeEntries);
    }

    public void setFilter(BAPojoFilter filter) {
        this.filter = filter;
    }

    public BAPojoFilter getFilter() {
        return filter;
    }
}