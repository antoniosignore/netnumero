package com.numhero.server.command;

import com.google.inject.Inject;
import com.numhero.client.model.datacargo.timeentry.TimeEntriesBilledStatusRequest;
import com.numhero.client.model.pojoc.TimeEntry;
import com.numhero.server.model.daolite.TimeEntryDao;
import com.numhero.shared.datacargo.BulkActionResponse;
import com.numhero.shared.pojoc.BAPojo;

import java.util.List;

public class CommandTimeEntriesBilledStatus extends AbstractAuthenticatedCommand<TimeEntriesBilledStatusRequest, BulkActionResponse> {

    @Inject
    TimeEntryDao dao;

    @Override
    public BulkActionResponse execute(TimeEntriesBilledStatusRequest request) throws Exception {

        log.info("CommandTimeEntriesBilledStatus.execute");

        BulkActionResponse resp = new BulkActionResponse();
        List<Long> ids = request.getEntityIdList();

        if (ids.isEmpty())
            throw new RuntimeException("ids cannot be null");

        log.fine("id List:" + ids);

        for (Long s : ids) {
            log.fine("s:" + s);
            BAPojo ba = dao.get(s);
            log.fine("ba:" + ba.getId());

            TimeEntry timeEntry = dao.get(s);
            timeEntry.fBilled.setValue(true);

            dao.save(timeEntry);
                resp.getSuccessIdList().add(s);
        }
        log.fine("resp.getSuccessIdList().size() = " + resp.getSuccessIdList().size());
        log.fine("resp.getFailureIdList().size() = " + resp.getFailureIdList().size());

        resp.setSuccessIdList(resp.getSuccessIdList());
        resp.setFailureIdList(resp.getFailureIdList());
        resp.setMessage("OK");

        return resp;
    }
}
