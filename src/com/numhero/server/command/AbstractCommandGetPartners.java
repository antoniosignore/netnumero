package com.numhero.server.command;

import com.google.inject.Inject;
import com.numhero.client.model.datacargo.client_supplier.ClientSupplierListResponse;
import com.numhero.client.model.pojoc.ClientSupplier;
import com.numhero.server.model.daolite.ClientSupplierDao;
import com.numhero.server.model.daolite.filter.DSFilter;
import com.numhero.server.model.daolite.filter.DSFilters;
import com.numhero.shared.datacargo.ListCommandRequest;
import com.numhero.shared.datacargo.ListCommandRequest.TYPE;
import com.numhero.shared.datacargo.PaginatedList;
import com.numhero.shared.enums.ClientSupplierEnum;

public abstract class AbstractCommandGetPartners<REQUEST extends ListCommandRequest> extends AbstractGetPaginatedCommand<REQUEST, ClientSupplierListResponse> {
    @Inject
    private ClientSupplierDao clientSupplierDao;

    protected ClientSupplierEnum type;

    @Override
    public ClientSupplierListResponse execute(REQUEST request) {
        ClientSupplierListResponse response = new ClientSupplierListResponse();

        if (request.getType() == TYPE.SUGGEST) {
            requestSuggest(request, response);
            return response;
        } else if (request.getType() == TYPE.SEARCH) {
            requestSearch(request, response);
            return response;
        } else {
            return getPaginatedResults(request);
        }

    }

    private void requestSearch(REQUEST request, ClientSupplierListResponse response) {
        DSFilter filter;
        if (type == ClientSupplierEnum.client) {
            filter = DSFilters.eq("client", true);
        } else if (type == ClientSupplierEnum.supplier) {
            filter = DSFilters.eq("supplier", true);
        } else {
            filter = DSFilters.nullFilter();
        }
        response.setEntityList(clientSupplierDao.search(
                request.getStartingKey(),
                request.getMaxResults(),
                request.getBusinessAccountId(),
                filter));
    }

    private void requestSuggest(REQUEST request, ClientSupplierListResponse response) {
        ClientSupplierDao clientSupplierDao1 = clientSupplierDao;
        if ("*".equals(request.getStartingKey())) {
            response.setEntityList(clientSupplierDao1.findByType(request.getBusinessAccountId(), request.getMaxResults(), type));
        } else {
            DSFilter filter;
            if (type == ClientSupplierEnum.client) {
                filter = DSFilters.eq("client", true);

            } else if (type == ClientSupplierEnum.supplier) {
                filter = DSFilters.eq("supplier", true);

            } else {
                filter = DSFilters.nullFilter();
            }
            response.setEntityList(clientSupplierDao1.searchForStartsWith(
                    request.getStartingKey(),
                    request.getMaxResults(),
                    request.getBusinessAccountId(),
                    filter));
        }
    }

    @Override
    protected ClientSupplierListResponse getPaginatedResults(REQUEST request) {
                ClientSupplierListResponse response = new ClientSupplierListResponse();
    	PaginatedList<ClientSupplier> cs = clientSupplierDao.findAllPaginated(request.getBusinessAccountId(), request.getMaxResults(), request.getRefObjectId(), type);
    	response.setPaginatedList(cs);
        return response;
    }
}
