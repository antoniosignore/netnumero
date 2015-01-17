package com.numhero.server.command;

import com.google.inject.Inject;
import com.numhero.client.model.datacargo.businesstransaction.GetBusinessTransactionRequest;
import com.numhero.client.model.datacargo.businesstransaction.GetBusinessTransactionResponse;
import com.numhero.client.model.pojoc.BusinessTransaction;
import com.numhero.server.model.daolite.BusinessTransactionDao;

public class CommandGetBusinessTransaction extends AbstractAuthenticatedCommand<GetBusinessTransactionRequest, GetBusinessTransactionResponse> {
    @Inject
    BusinessTransactionDao BusinessTransactionDao;

    @Override
    public GetBusinessTransactionResponse execute(GetBusinessTransactionRequest request) throws Exception {
        GetBusinessTransactionResponse response = new GetBusinessTransactionResponse();
        BusinessTransaction BusinessTransaction = BusinessTransactionDao.get(request.getEntityId());
        response.setEntity(BusinessTransaction);
        return response;
    }
}
