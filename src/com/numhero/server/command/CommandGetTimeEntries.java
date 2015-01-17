package com.numhero.server.command;

import com.google.inject.Inject;
import com.numhero.client.model.datacargo.timeentry.TimeEntryListRequest;
import com.numhero.client.model.datacargo.timeentry.TimeEntryListResponse;
import com.numhero.client.model.pojoc.TimeEntry;
import com.numhero.client.widget.filter.BAPojoFilter;
import com.numhero.server.model.daolite.TimeEntryDao;
import com.numhero.shared.datacargo.PaginatedList;

public class CommandGetTimeEntries extends AbstractGetPaginatedCommand<TimeEntryListRequest, TimeEntryListResponse> {

    @Inject
    TimeEntryDao timeEntryDao;

    @Override
    public TimeEntryListResponse execute(TimeEntryListRequest request) {

        return getPaginatedResults(request);
    }

    private PaginatedList<TimeEntry> getPaginated(TimeEntryListRequest request) {
        BAPojoFilter filter = request.getFilter();

        //timeEntryDao.findTimeEntries(request.getBusinessAccountId(), filter);
        return timeEntryDao.findAllPaginated(request.getBusinessAccountId(), request.getMaxResults(), request.getRefObjectId(), filter);
    }

    @Override
    protected TimeEntryListResponse getPaginatedResults(TimeEntryListRequest request) {
        TimeEntryListResponse response = new TimeEntryListResponse();
        response.setPaginatedList(getPaginated(request));
        return response;
    }
}
