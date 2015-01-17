package com.numhero.server.command;

import com.google.inject.Inject;
import com.numhero.client.model.datacargo.client_supplier.DeleteClientsSuppliersRequest;
import com.numhero.server.model.daolite.ClientSupplierDao;
import com.numhero.server.utils.BulkCommandUtils;
import com.numhero.shared.datacargo.BulkActionResponse;

import java.util.List;

public class CommandDeleteClientsSuppliers extends AbstractAuthenticatedCommand<DeleteClientsSuppliersRequest, BulkActionResponse> {

    @Inject
    ClientSupplierDao dao;

    @Override
    public BulkActionResponse execute(DeleteClientsSuppliersRequest deleteClientsSuppliersRequest) throws Exception {
        BulkActionResponse resp = new BulkActionResponse();
        List<Long> ids = deleteClientsSuppliersRequest.getEntityIdList();
        BulkCommandUtils.deleteIdList(resp, ids, dao);
        return resp;
    }
}
