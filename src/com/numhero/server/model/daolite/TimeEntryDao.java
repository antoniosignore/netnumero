package com.numhero.server.model.daolite;

import com.google.appengine.api.datastore.Query;
import com.numhero.client.model.pojoc.TimeEntry;
import com.numhero.client.widget.filter.BAPojoFilter;
import com.numhero.shared.datacargo.PaginatedList;

import java.util.List;
import java.util.logging.Logger;

public class TimeEntryDao extends BaseDao<TimeEntry> {

    @SuppressWarnings("unused")
    private static final Logger log = Logger.getLogger(ClientSupplierDao.class.getName());

    public List<TimeEntry> findTimeEntries(String businessAccountId, BAPojoFilter baFilter) {

        BaPojoFilterHelper filter = new BaPojoFilterHelper(baFilter);
        List<TimeEntry> list = findByCriteria(businessAccountId,
                filter.getStaffFilter(),
                filter.getFromFilter(),
                filter.getToFilter(),
                filter.getProjectFilter(),
                filter.getTaskFilter(),
                filter.getIsBilledFilter()
        );
        log.info("list = " + list);
        return list;
    }

	public PaginatedList<TimeEntry> findAllPaginated(String businessAccountId, int maxResults, Long refObjectId, BAPojoFilter baFilter) {

        BaPojoFilterHelper filter = new BaPojoFilterHelper(baFilter);

		return findAllPaginatedInternal(businessAccountId, maxResults, TimeEntry.DATE, refObjectId, Query.SortDirection.DESCENDING,
				filter.getStaffFilter(),
                filter.getProjectFilter(),
                filter.getTaskFilter(),
                filter.getIsBilledFilter());
	}



}
