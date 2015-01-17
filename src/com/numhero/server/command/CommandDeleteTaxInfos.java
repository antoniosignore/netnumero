package com.numhero.server.command;

import com.google.inject.Inject;
import com.numhero.client.model.datacargo.taxinfo.DeleteTaxInfosRequest;
import com.numhero.server.model.daolite.TaxInfoDao;
import com.numhero.shared.datacargo.BulkActionResponse;

import java.util.List;

import static com.numhero.server.utils.BulkCommandUtils.deleteIdList;

public class CommandDeleteTaxInfos extends AbstractAuthenticatedCommand<DeleteTaxInfosRequest, BulkActionResponse> {

    @Inject
    TaxInfoDao dao;

    @Override
    public BulkActionResponse execute(DeleteTaxInfosRequest deleteTaxInfosRequest) throws Exception {
        BulkActionResponse resp = new BulkActionResponse();
        List<Long> ids = deleteTaxInfosRequest.getEntityIdList();
        deleteIdList(resp, ids, dao);
        return resp;
    }
}
