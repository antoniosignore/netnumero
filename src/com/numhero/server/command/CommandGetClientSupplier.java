package com.numhero.server.command;

import com.google.inject.Inject;
import com.numhero.client.model.datacargo.client_supplier.GetClientSupplierRequest;
import com.numhero.client.model.pojoc.ClientSupplier;
import com.numhero.server.model.daolite.ClientSupplierDao;
import com.numhero.shared.datacargo.GetSingleEntityResponse;

public class CommandGetClientSupplier extends AbstractAuthenticatedCommand<GetClientSupplierRequest, GetSingleEntityResponse<ClientSupplier>> {

    @Inject
    ClientSupplierDao clientSupplierDao;

    @Override
    public GetSingleEntityResponse<ClientSupplier> execute(GetClientSupplierRequest request) throws Exception {
        GetSingleEntityResponse<ClientSupplier> response = new GetSingleEntityResponse<ClientSupplier>();

        ClientSupplier clientSupplier = clientSupplierDao.get(request.getEntityId());
        response.setEntity(clientSupplier);

        return response;
    }
}
