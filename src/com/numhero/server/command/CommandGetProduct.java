package com.numhero.server.command;

import com.google.inject.Inject;
import com.numhero.client.model.datacargo.product.GetItemRequest;
import com.numhero.client.model.datacargo.product.GetItemResponse;
import com.numhero.client.model.pojoc.ProductService;
import com.numhero.server.model.daolite.ProductDao;

public class CommandGetProduct extends AbstractAuthenticatedCommand<GetItemRequest, GetItemResponse> {

    @Inject
    ProductDao productDao;

    @Override
    public GetItemResponse execute(GetItemRequest request) throws Exception {
        GetItemResponse response = new GetItemResponse();

        ProductService productService = productDao.get(request.getEntityId());
        response.setEntity(productService);

        return response;
    }
}
