package com.numhero.server.model.daolite;

import com.numhero.client.widget.filter.BAPojoFilter;
import com.numhero.server.model.daolite.filter.DSFilter;
import com.numhero.server.model.daolite.filter.DSFilters;
import com.numhero.server.utils.DateUtils;

import java.util.Date;

public class BaPojoFilterHelper {
    private BAPojoFilter baFilter;

    public BaPojoFilterHelper(BAPojoFilter baFilter) {

        this.baFilter = baFilter;
    }


    public DSFilter getFromFilter() {
        Date startOfDay = baFilter.getFrom() != null ? DateUtils.getStartOfDay(baFilter.getFrom()): null;

        return DSFilters.ge("date", startOfDay);
    }

    public DSFilter getToFilter() {
        Date endOfDay = baFilter.getTo() != null ? DateUtils.getEndOfDay(baFilter.getTo()): null;
        return DSFilters.le("date", endOfDay);
    }

    public DSFilter getStaffFilter() {
        return DSFilters.eq("staffId", baFilter.getStaffId());
    }

    public DSFilter getProjectFilter() {
        return DSFilters.eq("projectId", baFilter.getProjectId());
    }

    public DSFilter getTaskFilter() {
        return DSFilters.eq("taskId", baFilter.getTaskId());
    }

    public DSFilter getIsBilledFilter() {
        return DSFilters.eq("billed", baFilter.getBilled());
    }
}
