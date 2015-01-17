package com.numhero.client.model.datacargo.usermessage;

import com.numhero.shared.datacargo.CommandRequest;
import com.numhero.shared.datacargo.SaveSingleEntityRequest;
import com.numhero.shared.service.ApplicationCommandEnum;

public class SaveUserMessageRequest extends SaveSingleEntityRequest {


    public SaveUserMessageRequest() {
        setCommand(ApplicationCommandEnum.CommandSaveUserMessage);
    }

    @Override
    public CommandRequest[] getRemoveFromCacheOnSuccess() {
        return new CommandRequest[]{new SaveUserMessageRequest()};
    }

}
