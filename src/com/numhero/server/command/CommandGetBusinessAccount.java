package com.numhero.server.command;

import com.google.inject.Inject;
import com.numhero.client.model.datacargo.businessaccount.GetBusinessAccountRequest;
import com.numhero.client.model.datacargo.businessaccount.GetBusinessAccountResponse;
import com.numhero.client.model.pojoc.BusinessAccount;
import com.numhero.server.model.daolite.BusinessAccountDao;

public class CommandGetBusinessAccount extends AbstractAuthenticatedCommand<GetBusinessAccountRequest, GetBusinessAccountResponse> {

    @Inject
    BusinessAccountDao businessAccountDao;

    @Override
    public GetBusinessAccountResponse execute(GetBusinessAccountRequest request) {
        GetBusinessAccountResponse response = new GetBusinessAccountResponse();
        //special case in which we don't use the entity id but the BaName from the request
        BusinessAccount businessAccount = businessAccountDao.getByUri(request.getBusinessAccountId());
        response.setEntity(businessAccount);
        response.setCurrentUser(this.getUser());
        return response;
    }
}
