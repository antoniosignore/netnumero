package com.numhero.server.model.daolite;

import com.google.appengine.api.datastore.Query;
import com.numhero.client.model.pojoc.ProductService;
import com.numhero.server.model.daolite.filter.DSFilters;
import com.numhero.shared.datacargo.PaginatedList;
import com.numhero.shared.enums.ProductTypeEnum;
import com.numhero.shared.pojoc.BAPojo;

import java.util.List;

public class ProductDao extends BaseSearchableDao<ProductService> {
    public List<ProductService> findAll(String businessAccountId, int maxResults) {
        return findByCriteria(businessAccountId, maxResults, null);
    }

    public List<ProductService> findAllByType(String businessAccountId, ProductTypeEnum type) {
        return findByCriteria(businessAccountId, DSFilters.eq("type", type.name()));
    }

    public ProductService findByName(String businessAccountId, String name) {
        return findUniqueResultByCriteria(businessAccountId, DSFilters.eq(BAPojo.FIELD_NAME, name));
    }

	public PaginatedList<ProductService> findAllPaginated(String businessAccountId, int maxResults, Long refObjectId) {
		return findAllPaginatedInternal(businessAccountId, maxResults, ProductService.FIELD_NAME, refObjectId, Query.SortDirection.ASCENDING);
	}
}
