package com.numhero.server.model.daolite;

import com.google.appengine.api.datastore.Query;
import com.numhero.client.model.pojoc.AccountingLeg;
import com.numhero.client.model.pojoc.BusinessTransaction;
import com.numhero.server.model.daolite.filter.DSFilters;
import com.numhero.shared.datacargo.PaginatedList;
import com.numhero.shared.enums.ReferenceDocEnum;
import com.numhero.shared.pojoc.field.OwnedListField;

import java.util.List;

public class BusinessTransactionDao extends BaseSearchableDao<BusinessTransaction> {

    @Override
    protected void preSave(BusinessTransaction pojo) {
        OwnedListField<AccountingLeg> l = pojo.getAccountingLegs();
        for (AccountingLeg accountingLeg : l) {
            accountingLeg.fDate.setValue(pojo.fDate.getValue());
            accountingLeg.fBusinessAccountUri.setValue(pojo.fBusinessAccountUri.getValue());
        }
    }

//    public List<BusinessTransaction> findByAccountAndDateRange(
//            String businessAccountId,
//            Date from,
//            Date to, Long ledgerAccountId) {
//        return findByCriteria(businessAccountId,
//                DSFilters.eq("accountId", ledgerAccountId),
//                (from != null) ? DSFilters.ge("date", from) :  DSFilters.nullFilter(),
//                (to != null) ? DSFilters.le("date", to) : DSFilters.nullFilter());

    //cannot work like that, in case we should get the legs and from the legs the BT
//    }

    public List<BusinessTransaction> findByDocRelation(String baUri, Long docId, ReferenceDocEnum docType) {

       return findByCriteria(baUri,
                DSFilters.eq(BusinessTransaction.FIELD_REFERENCE_DOC_ID, docId),
               DSFilters.eq(BusinessTransaction.FIELD_REFERENCE_DOC_TYPE, docType.name()));

    }

	public PaginatedList<BusinessTransaction> findAllPaginated(String businessAccountId, int maxResults, Long refObjectId) {
		return findAllPaginatedInternal(businessAccountId, maxResults, BusinessTransaction.FIELD_DATE, refObjectId, Query.SortDirection.DESCENDING);

	}
}
