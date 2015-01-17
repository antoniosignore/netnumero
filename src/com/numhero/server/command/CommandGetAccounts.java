package com.numhero.server.command;

import com.google.inject.Inject;
import com.numhero.client.model.datacargo.account.AccountListRequest;
import com.numhero.client.model.datacargo.account.AccountListResponse;
import com.numhero.client.model.pojoc.NominalLedgerAccount;
import com.numhero.server.model.daolite.NominalLedgerAccountDao;
import com.numhero.shared.datacargo.ListCommandRequest.TYPE;
import com.numhero.shared.datacargo.PaginatedList;

import java.util.List;
import java.util.logging.Logger;

public class CommandGetAccounts extends AbstractGetPaginatedCommand<AccountListRequest, AccountListResponse> {

    @SuppressWarnings("unused")
    private static final Logger log = Logger.getLogger(CommandGetAccounts.class.getName());

    @Inject
    NominalLedgerAccountDao nominalLedgerAccountDao;

    @Override
    public AccountListResponse execute(AccountListRequest request) {
        AccountListResponse response = new AccountListResponse();

        if (request.getType() == TYPE.SUGGEST) {
            List<NominalLedgerAccount> nominalLedgerAccounts;
            if (request.getStartingKey().equals("*")) {
                response.setEntityList(nominalLedgerAccountDao.findAll(
                        request.getBusinessAccountId(),
                        request.getMaxResults()));
                return response;
            } else {
                nominalLedgerAccounts = nominalLedgerAccountDao.searchForStartsWith(
                        request.getStartingKey(),
                        request.getMaxResults(),
                        request.getBusinessAccountId());
                response.setEntityList(nominalLedgerAccounts);
                return response;
            }
        } else if (request.getType() == TYPE.SEARCH) {
            response.setEntityList(nominalLedgerAccountDao.search(
                    request.getStartingKey(),
                    request.getBusinessAccountId()));
            return response;
        } else {
            return getPaginatedResults(request);
        }
    }


    protected PaginatedList<NominalLedgerAccount> getPaginated(AccountListRequest request) {
        PaginatedList<NominalLedgerAccount> accounts = nominalLedgerAccountDao.findAllPaginated(request.getBusinessAccountId(),
                request.getMaxResults(), request.getRefObjectId());
        log.fine("Get accounts: " + accounts);
        return accounts;
    }

    @Override
    protected AccountListResponse getPaginatedResults(AccountListRequest request) {
        AccountListResponse response = new AccountListResponse();
        response.setPaginatedList(getPaginated(request));
        return response;
    }
}
