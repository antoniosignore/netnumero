package com.numhero.client.model.datacargo.product;

import com.numhero.shared.datacargo.BulkActionRequest;
import com.numhero.shared.service.ApplicationCommandEnum;

public class DeleteProductsRequest extends BulkActionRequest {

	public DeleteProductsRequest() {
		setCommand(ApplicationCommandEnum.CommandDeleteProducts);
	}

}