package com.numhero.server.command;

import com.google.inject.Inject;
import com.numhero.client.model.datacargo.timeentry.TimeEntryBillingListRequest;
import com.numhero.client.model.datacargo.timeentry.TimeEntryListResponse;
import com.numhero.client.model.pojoc.TimeEntry;
import com.numhero.server.model.daolite.TimeEntryDao;

import java.util.List;
import java.util.logging.Logger;

public class CommandGetBillableTimeEntries extends AbstractAuthenticatedCommand<TimeEntryBillingListRequest, TimeEntryListResponse> {

    @SuppressWarnings("unused")
    private static final Logger log = Logger.getLogger(CommandGetBillableTimeEntries.class.getName());

    @Inject
    TimeEntryDao dao;

    @Override
    public TimeEntryListResponse execute(TimeEntryBillingListRequest req) {
        TimeEntryListResponse response = new TimeEntryListResponse();
        List<TimeEntry> timeEntries;
        timeEntries = getPaginatedResults(req);
        response.setEntityList(timeEntries);
        return response;
    }

	private List<TimeEntry> getPaginatedResults(TimeEntryBillingListRequest req) {

		return  dao.findTimeEntries(req.getBusinessAccountId(), req.getFilter());
	}
}
