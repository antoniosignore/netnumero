package com.numhero.client.model.datacargo.staff;

import com.numhero.shared.datacargo.BulkActionRequest;
import com.numhero.shared.service.ApplicationCommandEnum;

public class DeleteStaffRequest extends BulkActionRequest {

	public DeleteStaffRequest() {
		setCommand(ApplicationCommandEnum.CommandDeleteStaff);
	}

}