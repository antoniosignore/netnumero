package com.numhero.server.model.daolite;

import com.google.appengine.api.datastore.Query;
import com.google.inject.Singleton;
import com.numhero.client.model.pojoc.Staff;
import com.numhero.server.model.daolite.filter.DSFilter;
import com.numhero.server.model.daolite.filter.DSFilters;
import com.numhero.shared.datacargo.PaginatedList;
import com.numhero.shared.enums.StaffTypeEnum;

import java.util.List;

@Singleton
public class StaffDao extends BaseSearchableDao<Staff> {

	public List<Staff> findAllByType(String businessAccountId, int maxResults, StaffTypeEnum type) {
        return findByCriteria(businessAccountId,
				maxResults,
				null, type != null ? DSFilters.eq("staffType", type.name()) : null)
				;
	}

	public PaginatedList<Staff> findAllPaginated(String baUri, int resultsForPage, Long refObjectId, StaffTypeEnum type) {

		String orderedFieldName = Staff.FIELD_NAME;

		if (type == null || type == StaffTypeEnum.Both){
			return findAllPaginatedInternal(baUri, resultsForPage, orderedFieldName, refObjectId, Query.SortDirection.ASCENDING);
		} else {

            DSFilter staffType = DSFilters.eq("staffType", type.name()) ;
			return findAllPaginatedInternal(baUri, resultsForPage, orderedFieldName, refObjectId, Query.SortDirection.ASCENDING, staffType);
		}

	}

	public void searchByType(List<Staff> staffs, String startingKey, int maxResults, String businessAccountId, DSFilter dsFilter) {
		staffs = this.searchForStartsWith(startingKey, maxResults, businessAccountId, dsFilter);
	}

	public Staff findByUserId(String businessAccountId, long userId) {
		return selectOneOnBA(businessAccountId, DSFilters.eq("userId", userId));
	}
}
