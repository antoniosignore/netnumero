package com.numhero.server.model.daolite;

import com.numhero.client.model.pojoc.BusinessAccount;

public class BusinessAccountDao extends BaseDao<BusinessAccount> {

    private CacheDaoService<BusinessAccount> cacheDaoService = new CacheDaoService<BusinessAccount>("BAByUri");

    public BusinessAccount getByUri(final String baUri) {

        BusinessAccount pojo = cacheDaoService.innerGet(baUri, new PojoSelector<BusinessAccount>(){
            @Override
            public BusinessAccount invoke() {
                return selectOneOnBA(baUri);
            }
        });
        return pojo;
    }

    @Override
    public void save(BusinessAccount pojo) {
        super.save(pojo);
        cacheDaoService.deleteFromCache(pojo.fBusinessAccountUri.getValue());
    }

    @Override
    public void delete(BusinessAccount pojo) {
        super.delete(pojo);
        cacheDaoService.deleteFromCache(pojo.fBusinessAccountUri.getValue());
    }

    @Override
    public void delete(Long id) {
        BusinessAccount pojo = get(id);
        delete(pojo);
    }
}
