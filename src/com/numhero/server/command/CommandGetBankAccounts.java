package com.numhero.server.command;

import com.google.inject.Inject;
import com.numhero.client.model.datacargo.bankaccount.BankAccountListRequest;
import com.numhero.client.model.datacargo.bankaccount.BankAccountListResponse;
import com.numhero.client.model.pojoc.BankAccount;
import com.numhero.server.model.daolite.BankAccountDao;
import com.numhero.shared.datacargo.ListCommandRequest.TYPE;
import com.numhero.shared.datacargo.PaginatedList;

import java.util.logging.Logger;

public class CommandGetBankAccounts extends AbstractGetPaginatedCommand<BankAccountListRequest, BankAccountListResponse> {

    @SuppressWarnings("unused")
    private static final Logger log = Logger.getLogger(CommandGetTasks.class.getName());

    @Inject
    BankAccountDao bankAccountDao;

    @Override
    public BankAccountListResponse execute(BankAccountListRequest request) {
        BankAccountListResponse response = new BankAccountListResponse();


        if (request.getType() == TYPE.SUGGEST) {
            if (request.getStartingKey().equals("*")) {
                response.setEntityList(bankAccountDao.findAllMaxResults(
                        request.getBusinessAccountId(),
                        request.getMaxResults()));
                return response;
            } else {
                response.setEntityList(bankAccountDao.searchForStartsWith(
                        request.getStartingKey(),
                        request.getMaxResults(),
                        request.getBusinessAccountId()));
                return response;
            }
        } else if (request.getType() == TYPE.SEARCH) {
            response.setEntityList(bankAccountDao.search(request.getStartingKey(), request.getBusinessAccountId()));
            return response;
        } else {
            return getPaginatedResults(request);
        }


    }

    private PaginatedList<BankAccount> getPaginated(BankAccountListRequest request) {
        return bankAccountDao.findAllPaginated(request.getBusinessAccountId(), request.getMaxResults(), request.getRefObjectId());
    }

    @Override
    protected BankAccountListResponse getPaginatedResults(BankAccountListRequest request) {
        BankAccountListResponse response = new BankAccountListResponse();
        response.setPaginatedList(getPaginated(request));
        return response;
    }
}
