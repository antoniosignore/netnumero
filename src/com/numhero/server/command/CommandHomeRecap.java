package com.numhero.server.command;

import com.numhero.client.model.datacargo.home.GetHomeRecapRequest;
import com.numhero.client.model.datacargo.home.GetHomeRecapResponse;

public class CommandHomeRecap extends AbstractAuthenticatedCommand<GetHomeRecapRequest, GetHomeRecapResponse> {
    @Override
    public GetHomeRecapResponse execute(GetHomeRecapRequest getHomeRecapRequest) throws Exception {

        GetHomeRecapResponse rsp = new GetHomeRecapResponse();

        return rsp;
    }
}
