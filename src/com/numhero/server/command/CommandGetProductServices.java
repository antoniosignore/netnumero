package com.numhero.server.command;

import com.google.inject.Inject;
import com.numhero.client.model.datacargo.product.ProductListResponse;
import com.numhero.client.model.datacargo.product.ProductServicesListRequest;
import com.numhero.client.model.pojoc.ProductService;
import com.numhero.server.model.daolite.ProductDao;
import com.numhero.shared.datacargo.ListCommandRequest.TYPE;
import com.numhero.shared.datacargo.PaginatedList;

import java.util.ArrayList;
import java.util.List;

public class CommandGetProductServices extends AbstractGetPaginatedCommand<ProductServicesListRequest, ProductListResponse> {
    @Inject
    ProductDao productDao;

    @Override
    public ProductListResponse execute(ProductServicesListRequest request) throws Exception {
        ProductListResponse response = new ProductListResponse();
        List<ProductService> productServices = new ArrayList<ProductService>();
        if (request.getType() == TYPE.SUGGEST) {
            if (request.getStartingKey().equals("*")) {
                response.setEntityList(productDao.findAll(
                        request.getBusinessAccountId(),
                        request.getMaxResults()));
                return response;
            } else {
                response.setEntityList(productDao.searchForStartsWith(
                        request.getStartingKey(),
                        request.getMaxResults(),
                        request.getBusinessAccountId()));
                return response;
            }
        } else if (request.getType() == TYPE.SEARCH) {
            response.setEntityList(productDao.search(
                    request.getStartingKey(),
                    request.getBusinessAccountId()));
            return response;
        } else if (request.getProductType() != null) {
            response.setEntityList(productDao.findAllByType(
                    request.getBusinessAccountId(),
                    request.getProductType()));
            return response;
        } else {
            return getPaginatedResults(request);
        }

    }

    private PaginatedList<ProductService> getPaginated(ProductServicesListRequest request) {

        return productDao.findAllPaginated(
                request.getBusinessAccountId(), request.getMaxResults(), request.getRefObjectId());
    }

    @Override
    protected ProductListResponse getPaginatedResults(ProductServicesListRequest request) {
        ProductListResponse response = new ProductListResponse();
        response.setPaginatedList(getPaginated(request));
        return response;
    }
}
