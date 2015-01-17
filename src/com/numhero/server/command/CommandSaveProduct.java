package com.numhero.server.command;

import com.google.inject.Inject;
import com.numhero.client.model.datacargo.product.SaveProductRequest;
import com.numhero.client.model.datacargo.product.SaveProductResponse;
import com.numhero.client.model.pojoc.ProductService;
import com.numhero.server.model.daolite.ProductDao;
import com.numhero.server.utils.DaoUtils;
import com.numhero.shared.exception.ClientWarningException;

public class CommandSaveProduct extends AbstractAuthenticatedCommand<SaveProductRequest, SaveProductResponse> {
    @Inject
    ProductDao productDao;

    @Override
    public SaveProductResponse execute(SaveProductRequest request) {
        ProductService ps = (ProductService) request.getEntity();

        validate(request.getBusinessAccountId(), ps);

        DaoUtils.setData(request, ps);
        productDao.save(ps);

        // createAudit
        SaveProductResponse response = new SaveProductResponse();
        response.setEntityId(ps.getId());
        return response;
    }

	private void validate(String ba, ProductService ps) {
		ProductService psWithSameName = productDao.findByName(ba, ps.fName.getValue());
        if (psWithSameName != null && !psWithSameName.fId.getValue().equals(ps.fId.getValue())) {
        	throw new ClientWarningException("productServiceExists");
        }
	}
}
