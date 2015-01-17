package com.numhero.server.command;

import com.numhero.client.model.pojoc.BusinessAccount;
import com.numhero.client.model.pojoc.User;
import com.numhero.shared.datacargo.CommandRequest;
import com.numhero.shared.datacargo.CommandResponse;
import com.numhero.shared.exception.ClientWarningException;

public interface ICommandProcessor {

	public <REQUEST extends CommandRequest, RESPONSE extends CommandResponse> CommandResponse process(User user, BusinessAccount ba, REQUEST request) throws ClientWarningException;
}
