package com.numhero.client.model.datacargo.timeentry;

import com.numhero.shared.datacargo.BulkActionRequest;
import com.numhero.shared.service.ApplicationCommandEnum;

public class TimeEntriesBilledStatusRequest extends BulkActionRequest {

    public TimeEntriesBilledStatusRequest() {
        setCommand(ApplicationCommandEnum.CommandTimeEntriesBilledStatus);
    }

}