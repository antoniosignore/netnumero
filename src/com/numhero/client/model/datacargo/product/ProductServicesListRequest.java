package com.numhero.client.model.datacargo.product;

import com.numhero.shared.datacargo.ListCommandRequest;
import com.numhero.shared.enums.ProductTypeEnum;
import com.numhero.shared.service.ApplicationCommandEnum;

public class ProductServicesListRequest extends ListCommandRequest {
	private ProductTypeEnum productType;

    public ProductServicesListRequest() {
        setCommand(ApplicationCommandEnum.CommandGetProductServices);
    }

    public ProductServicesListRequest(ProductTypeEnum productType) {
    	this();
    	this.productType = productType;
    }

    public ProductTypeEnum getProductType() {
		return productType;
	}
}
