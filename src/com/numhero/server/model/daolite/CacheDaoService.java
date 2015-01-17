package com.numhero.server.model.daolite;

import com.google.appengine.api.memcache.Expiration;
import com.google.appengine.api.memcache.MemcacheService;
import com.google.appengine.api.memcache.MemcacheServiceFactory;
import com.numhero.shared.pojoc.EntityPojo;

public class CacheDaoService<T extends EntityPojo> {
    private MemcacheService nameCache;
    private String serviceName;

    public CacheDaoService(String serviceName) {
        this.serviceName = serviceName;
        nameCache = MemcacheServiceFactory.getMemcacheService(serviceName);
    }

    public T getFromCache(String key) {
        if (key == null) {
            throw new RuntimeException("null key for " + serviceName);
        }

        return (T) nameCache.get(key);
    }

    public void putInCache(String key, T pojo) {
        nameCache.put(key, pojo, Expiration.byDeltaSeconds(3600));
    }

    public void deleteFromCache(String key) {
        nameCache.delete(key);
    }

    T innerGet(String key, PojoSelector<T> selectPojo) {
        T pojo = getFromCache(key);
        if (pojo == null) {
            pojo = selectPojo.invoke();

            putInCache(key, pojo);
        }
        return pojo;
    }
}
