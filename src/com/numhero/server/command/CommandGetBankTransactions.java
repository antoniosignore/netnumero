package com.numhero.server.command;

import com.google.inject.Inject;
import com.numhero.client.model.datacargo.banktransaction.BankTransactionListRequest;
import com.numhero.client.model.datacargo.banktransaction.BankTransactionListResponse;
import com.numhero.client.model.pojoc.BankTransaction;
import com.numhero.server.model.daolite.BankTransactionDao;
import com.numhero.shared.datacargo.PaginatedList;


public class CommandGetBankTransactions extends AbstractGetPaginatedCommand<BankTransactionListRequest, BankTransactionListResponse> {

    @Inject
    BankTransactionDao dao;

    @Override
    public BankTransactionListResponse execute(BankTransactionListRequest request) {
        return getPaginatedResults(request);
    }

    private PaginatedList<BankTransaction> getPaginated(BankTransactionListRequest request) {

        return dao.findAllPaginated(request.getBusinessAccountId(), request.getMaxResults(), request.getRefObjectId());
    }

    @Override
    protected BankTransactionListResponse getPaginatedResults(BankTransactionListRequest request) {
        BankTransactionListResponse response = new BankTransactionListResponse();
        response.setPaginatedList(getPaginated(request));
        return response;

    }
}
