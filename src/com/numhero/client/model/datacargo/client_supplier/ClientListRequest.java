package com.numhero.client.model.datacargo.client_supplier;

import com.numhero.shared.datacargo.ListCommandRequest;
import com.numhero.shared.service.ApplicationCommandEnum;

public class ClientListRequest extends ListCommandRequest {

	public ClientListRequest() {
		setCommand(ApplicationCommandEnum.CommandGetClients);
	}
}
