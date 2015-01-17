package com.numhero.client.model.datacargo.product;

import com.numhero.client.model.pojoc.ProductService;
import com.numhero.shared.datacargo.CommandRequest;
import com.numhero.shared.datacargo.SaveSingleEntityRequest;
import com.numhero.shared.service.ApplicationCommandEnum;

public class SaveProductRequest extends SaveSingleEntityRequest {

    public SaveProductRequest() {
        setCommand(ApplicationCommandEnum.CommandSaveProduct);
    }

    public ProductService getProduct() {
        return (ProductService) getEntity();
    }

    public void setProduct(ProductService product) {
        setEntity(product);
    }

    @Override
    public CommandRequest[] getRemoveFromCacheOnSuccess() {
    	return new CommandRequest[] { new ProductServicesListRequest() };
    }
}
