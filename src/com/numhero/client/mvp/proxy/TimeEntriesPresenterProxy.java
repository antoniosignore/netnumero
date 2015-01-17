package com.numhero.client.mvp.proxy;

import com.numhero.client.model.datacargo.timeentry.DeleteTimeEntriesRequest;
import com.numhero.client.model.datacargo.timeentry.TimeEntryListRequest;
import com.numhero.client.model.datacargo.timeentry.TimeEntryListResponse;
import com.numhero.client.mvp.timeentry.TimeEntriesPresenter;
import com.numhero.client.mvp.timeentry.TimeEntriesTable;
import com.numhero.shared.datacargo.BulkActionResponse;

public class TimeEntriesPresenterProxy extends PresenterProxy<TimeEntriesPresenter> {
    @Override
    protected TimeEntriesPresenter createPresenter() {

        TimeEntriesTable table = new TimeEntriesTable();
        return new TimeEntriesPresenter(getEventManager(),
                PresenterProxy.<TimeEntryListRequest, TimeEntryListResponse>createNewService(),
                PresenterProxy.<DeleteTimeEntriesRequest, BulkActionResponse>createNewService(),
                table,
                getConstants());
    }
}
