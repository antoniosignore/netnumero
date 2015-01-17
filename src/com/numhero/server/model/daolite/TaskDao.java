package com.numhero.server.model.daolite;

import com.google.appengine.api.datastore.Query;
import com.numhero.client.model.pojoc.Task;
import com.numhero.shared.datacargo.PaginatedList;

import java.util.List;


public class TaskDao extends BaseSearchableDao<Task> {

    public List<Task> findAllMaxResults(String businessAccountId, int maxResults) {
        return findByCriteria(businessAccountId, maxResults, null);
    }

	public PaginatedList<Task> findAllPaginated(String businessAccountId, int maxResults, Long refObjectId) {
		return findAllPaginatedInternal(businessAccountId, maxResults, Task.FIELD_NAME, refObjectId, Query.SortDirection.ASCENDING);
	}
}
