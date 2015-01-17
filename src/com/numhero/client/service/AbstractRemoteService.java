package com.numhero.client.service;

import com.numhero.shared.datacargo.CommandRequest;
import com.numhero.shared.datacargo.CommandResponse;
import com.numhero.shared.exception.ClientWarningException;

public interface AbstractRemoteService {
    public <REQUEST extends CommandRequest, RESPONSE extends CommandResponse> RESPONSE execute(REQUEST request) throws ClientWarningException;
}
