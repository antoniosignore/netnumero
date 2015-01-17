package com.numhero.server.model.daolite;

import com.google.appengine.api.datastore.Query;
import com.google.inject.Singleton;
import com.numhero.client.model.pojoc.User;
import com.numhero.server.model.daolite.filter.DSFilters;
import com.numhero.shared.datacargo.PaginatedList;

import java.util.List;

@Singleton
public class UserDao extends BaseSearchableDao<User> {
    private CacheDaoService<User> cacheDaoService = new CacheDaoService<User>(User.USER_PORTAL_ID);

    @Override
    public void save(User pojo) {
        super.save(pojo);
        cacheDaoService.deleteFromCache(pojo.fUserPortalId.getValue());
    }

    @Override
    public void delete(User pojo) {
        super.delete(pojo);
        cacheDaoService.deleteFromCache(pojo.fUserPortalId.getValue());
    }

    @Override
    public void delete(Long id) {
        User pojo = get(id);
        delete(pojo);
    }

    public User findByPortalUserId(final String userId) {

        User u = cacheDaoService.innerGet(userId, new PojoSelector<User>() {
            @Override
            public User invoke() {
                return selectOne(DSFilters.eq(User.USER_PORTAL_ID, userId));
            }
        });
        return u;
    }

    public List<User> findAllMaxResults(String businessAccountId, int maxResults) {
        return findByCriteria(businessAccountId, maxResults, null);
    }

	public PaginatedList<User> findAllPaginated(String businessAccountId, int maxResults, Long refObjectId) {

		return findAllPaginatedInternal(businessAccountId, maxResults, User.FIELD_NAME, refObjectId, Query.SortDirection.ASCENDING);

	}
}
