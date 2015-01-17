package com.numhero.client.model.datacargo.timeentry;

import com.numhero.shared.datacargo.BulkActionRequest;
import com.numhero.shared.service.ApplicationCommandEnum;

public class DeleteTimeEntriesRequest extends BulkActionRequest {

	public DeleteTimeEntriesRequest() {
		setCommand(ApplicationCommandEnum.CommandDeleteTimeEntries);
	}

}