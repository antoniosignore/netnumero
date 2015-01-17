package com.numhero.client.model.datacargo.project;

import com.numhero.shared.datacargo.BulkActionRequest;
import com.numhero.shared.service.ApplicationCommandEnum;

public class DeleteProjectsRequest extends BulkActionRequest {

	public DeleteProjectsRequest() {
		setCommand(ApplicationCommandEnum.CommandDeleteProjects);
	}

}