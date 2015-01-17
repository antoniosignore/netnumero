package com.numhero.client.model.datacargo.timeentry;

import com.numhero.shared.datacargo.GetSingleEntityRequest;
import com.numhero.shared.service.ApplicationCommandEnum;

public class GetTimeEntryRequest extends GetSingleEntityRequest {

    public GetTimeEntryRequest() {
        setCommand(ApplicationCommandEnum.CommandGetTimeEntry);
    }

}
