package com.numhero.client.model.datacargo.client_supplier;

import com.numhero.shared.datacargo.ListCommandRequest;
import com.numhero.shared.service.ApplicationCommandEnum;

public class SupplierListRequest extends ListCommandRequest {

	public SupplierListRequest() {
		setCommand(ApplicationCommandEnum.CommandGetSuppliers);
	}
}
