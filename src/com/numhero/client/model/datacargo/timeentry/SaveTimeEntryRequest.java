package com.numhero.client.model.datacargo.timeentry;

import com.numhero.shared.datacargo.SaveSingleEntityRequest;
import com.numhero.shared.service.ApplicationCommandEnum;

public class SaveTimeEntryRequest extends SaveSingleEntityRequest {

    public SaveTimeEntryRequest() {
        setCommand(ApplicationCommandEnum.CommandSaveTimeEntry);
    }
}
