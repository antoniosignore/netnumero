package com.numhero.server.command;

import com.numhero.shared.datacargo.ListCommandRequest;
import com.numhero.shared.datacargo.ListCommandResponse;

public abstract class GetPaginatedEntities <REQUEST extends ListCommandRequest, RESPONSE extends ListCommandResponse> extends AbstractAuthenticatedCommand {
	protected abstract void getPaginatedResults(REQUEST request, RESPONSE response);
}
