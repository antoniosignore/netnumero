package com.numhero.server.model.daolite;

import com.google.appengine.api.datastore.Query;
import com.numhero.client.model.pojoc.Project;
import com.numhero.server.model.daolite.filter.DSFilters;
import com.numhero.shared.datacargo.PaginatedList;

import java.util.List;


public class ProjectDao extends BaseSearchableDao<Project> {

    public List<Project> findAllMaxResults(String businessAccountId, int maxResults) {
        return findByCriteria(businessAccountId, maxResults, null);
    }

    public Project findByName(String businessAccountId, String name) {
        return findUniqueResultByCriteria(businessAccountId, DSFilters.eq("projectName", name));
    }


	public PaginatedList<Project> findAllPaginated(String businessAccountId, int maxResults, Long refObjectId) {
		return findAllPaginatedInternal(businessAccountId, maxResults, Project.FIELD_NAME, refObjectId, Query.SortDirection.ASCENDING);
	}
}
