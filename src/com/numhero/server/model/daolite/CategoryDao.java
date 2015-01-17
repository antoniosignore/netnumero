package com.numhero.server.model.daolite;

import com.google.appengine.api.datastore.Query;
import com.numhero.client.model.pojoc.Category;
import com.numhero.shared.datacargo.PaginatedList;


public class CategoryDao extends BaseSearchableDao<Category> {

	public PaginatedList<Category> findAllPaginated(String businessAccountId, int maxResults, Long refObjectId) {
		return findAllPaginatedInternal(businessAccountId, maxResults, Category.FIELD_NAME, refObjectId, Query.SortDirection.ASCENDING);
	}
}
