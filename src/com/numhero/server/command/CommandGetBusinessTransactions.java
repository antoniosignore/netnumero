package com.numhero.server.command;

import com.google.inject.Inject;
import com.numhero.client.model.datacargo.businesstransaction.BusinessTransactionListRequest;
import com.numhero.client.model.datacargo.businesstransaction.BusinessTransactionListResponse;
import com.numhero.client.model.pojoc.BusinessTransaction;
import com.numhero.server.model.daolite.BusinessTransactionDao;
import com.numhero.shared.datacargo.PaginatedList;

import java.util.logging.Logger;

public class CommandGetBusinessTransactions extends
        AbstractGetPaginatedCommand<BusinessTransactionListRequest, BusinessTransactionListResponse> {

    @SuppressWarnings("unused")
    private static final Logger log = Logger.getLogger(CommandGetTasks.class.getName());

    @Inject
    BusinessTransactionDao businessTransactionDao;

    @Override
    public BusinessTransactionListResponse execute(BusinessTransactionListRequest request) throws Exception {


        return getPaginatedResults(request);
    }

    private PaginatedList<BusinessTransaction> getPaginated(BusinessTransactionListRequest request) {

        return businessTransactionDao.findAllPaginated(
                request.getBusinessAccountId(),
                request.getMaxResults(),
                request.getRefObjectId());
    }

    @Override
    protected BusinessTransactionListResponse getPaginatedResults(BusinessTransactionListRequest request) {

        BusinessTransactionListResponse response = new BusinessTransactionListResponse();
        response.setPaginatedList(getPaginated(request));
        return response;
    }
}
