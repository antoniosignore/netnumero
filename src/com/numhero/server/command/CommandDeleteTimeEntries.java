package com.numhero.server.command;

import com.google.inject.Inject;
import com.numhero.client.model.datacargo.timeentry.DeleteTimeEntriesRequest;
import com.numhero.server.model.daolite.TimeEntryDao;
import com.numhero.shared.datacargo.BulkActionResponse;

import java.util.List;

import static com.numhero.server.utils.BulkCommandUtils.deleteIdList;

public class CommandDeleteTimeEntries extends AbstractAuthenticatedCommand<DeleteTimeEntriesRequest, BulkActionResponse> {

    @Inject
    TimeEntryDao dao;

    @Override
    public BulkActionResponse execute(DeleteTimeEntriesRequest deleteTimeEntriesRequest) throws Exception {
        BulkActionResponse resp = new BulkActionResponse();
        List<Long> ids = deleteTimeEntriesRequest.getEntityIdList();
        deleteIdList(resp, ids, dao);
        return resp;
    }
}
