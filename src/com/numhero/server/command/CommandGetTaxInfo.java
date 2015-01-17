package com.numhero.server.command;

import com.google.inject.Inject;
import com.numhero.client.model.datacargo.taxinfo.GetTaxInfoRequest;
import com.numhero.client.model.datacargo.taxinfo.GetTaxInfoResponse;
import com.numhero.client.model.pojoc.TaxInfo;
import com.numhero.server.model.daolite.TaxInfoDao;

public class CommandGetTaxInfo extends AbstractAuthenticatedCommand<GetTaxInfoRequest, GetTaxInfoResponse> {

    @Inject
    TaxInfoDao dao;

    @Override
    public GetTaxInfoResponse execute(GetTaxInfoRequest request) throws Exception {
        GetTaxInfoResponse response = new GetTaxInfoResponse();
        TaxInfo task = dao.get(request.getEntityId());
        response.setEntity(task);
        return response;
    }
}
