package com.numhero.server.model.daolite;

import com.google.appengine.api.datastore.Query;
import com.numhero.client.model.pojoc.NominalLedgerAccount;
import com.numhero.server.model.daolite.filter.DSFilters;
import com.numhero.shared.datacargo.PaginatedList;
import com.numhero.shared.enums.AccountingGroupEnum;

import java.util.List;

public class NominalLedgerAccountDao extends BaseSearchableDao<NominalLedgerAccount> {

    private CacheDaoService<NominalLedgerAccount> cacheDaoService = new CacheDaoService<NominalLedgerAccount>(NominalLedgerAccount.CODE);

    @Override
    public void save(NominalLedgerAccount pojo) {
        super.save(pojo);
        cacheDaoService.deleteFromCache(composeKey(pojo));
    }

    @Override
    public void delete(NominalLedgerAccount pojo) {
        super.delete(pojo);
        cacheDaoService.deleteFromCache(composeKey(pojo));
    }

    @Override
    public void delete(Long id) {
        NominalLedgerAccount pojo = get(id);
        delete(pojo);
    }

    public NominalLedgerAccount loadAccountsByCode(final String businessAccountId, final String code) {

        NominalLedgerAccount pojo = cacheDaoService.innerGet(composeKey(businessAccountId, code), new PojoSelector<NominalLedgerAccount>() {
            @Override
            public NominalLedgerAccount invoke() {
                return selectOneOnBA(businessAccountId, DSFilters.eq(NominalLedgerAccount.CODE, code));
            }
        });
        return pojo;
    }

    private String composeKey(String businessAccountId, String code) {
        return businessAccountId + "--" + code;
    }

    private String composeKey(NominalLedgerAccount pojo) {
        return composeKey(pojo.fBusinessAccountUri.getValue(), pojo.fCode.getValue());
    }


    public List<NominalLedgerAccount> findAllByGroup(String businessAccountId, AccountingGroupEnum group) {
        List<NominalLedgerAccount> list =  findByCriteria(businessAccountId,
                (group != null) ? DSFilters.eq(NominalLedgerAccount.ACCOUNTING_GROUP, group.name()) : null);

        return list;
    }

	public PaginatedList<NominalLedgerAccount> findAllPaginated(String businessAccountId, int maxResults, Long refObjectId) {
		return findAllPaginatedInternal(businessAccountId, maxResults, NominalLedgerAccount.FIELD_NAME, refObjectId, Query.SortDirection.ASCENDING);
	}
}
