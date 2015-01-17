package com.numhero.server.command;

import com.google.inject.Inject;
import com.numhero.client.model.datacargo.timeentry.GetTimeEntryRequest;
import com.numhero.client.model.datacargo.timeentry.GetTimeEntryResponse;
import com.numhero.client.model.pojoc.TimeEntry;
import com.numhero.server.model.daolite.TimeEntryDao;

public class CommandGetTimeEntry extends AbstractAuthenticatedCommand<GetTimeEntryRequest, GetTimeEntryResponse> {

    @Inject
    TimeEntryDao timeEntryDao;

    @Override
    public GetTimeEntryResponse execute(GetTimeEntryRequest request) throws Exception {
        GetTimeEntryResponse response = new GetTimeEntryResponse();
        TimeEntry timeEntry = timeEntryDao.get(request.getEntityId());
        response.setEntity(timeEntry);
        return response;
    }
}
