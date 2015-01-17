package com.numhero.client.model.datacargo.task;

import com.numhero.shared.datacargo.BulkActionRequest;
import com.numhero.shared.service.ApplicationCommandEnum;

public class DeleteTasksRequest extends BulkActionRequest {

	public DeleteTasksRequest() {
		setCommand(ApplicationCommandEnum.CommandDeleteTasks);
	}

}