package com.numhero.client.model.datacargo.user;

import com.numhero.shared.datacargo.BulkActionRequest;
import com.numhero.shared.service.ApplicationCommandEnum;

public class SuspendUsersRequest extends BulkActionRequest {

	public SuspendUsersRequest() {
		setCommand(ApplicationCommandEnum.CommandSuspendUsers);
	}

}