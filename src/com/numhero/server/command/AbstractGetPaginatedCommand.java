package com.numhero.server.command;

import com.numhero.shared.datacargo.CommandRequest;
import com.numhero.shared.datacargo.CommandResponse;

public abstract class AbstractGetPaginatedCommand<REQUEST extends CommandRequest, RESPONSE extends CommandResponse> extends AbstractAuthenticatedCommand<REQUEST, RESPONSE> {

	abstract protected RESPONSE getPaginatedResults(REQUEST request);



}
