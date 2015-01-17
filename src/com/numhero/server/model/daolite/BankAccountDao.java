package com.numhero.server.model.daolite;

import com.google.appengine.api.datastore.Query;
import com.numhero.client.model.pojoc.BankAccount;
import com.numhero.server.model.daolite.filter.DSFilters;
import com.numhero.shared.datacargo.PaginatedList;

import java.util.List;

public class BankAccountDao extends BaseSearchableDao<BankAccount> {

    public List<BankAccount> findAllMaxResults(String businessAccountId, int maxResults) {
        return findByCriteria(businessAccountId, maxResults, null);
    }

    public BankAccount getMainTradingAccount(String businessAccountId) {
        return findUniqueResultByCriteria(businessAccountId,
                DSFilters.eq(BankAccount.IS_MAIN_TRADING_ACCOUNT, true));
    }

	public PaginatedList<BankAccount> findAllPaginated(String businessAccountId, int maxResults, Long refObjectId) {
		return findAllPaginatedInternal(businessAccountId, maxResults, BankAccount.FIELD_LAST_UPDATED, refObjectId, Query.SortDirection.DESCENDING);
	}
}
