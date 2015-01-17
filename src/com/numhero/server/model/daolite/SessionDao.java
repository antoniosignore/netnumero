package com.numhero.server.model.daolite;

import com.google.appengine.api.memcache.Expiration;
import com.google.appengine.api.memcache.MemcacheService;
import com.google.appengine.api.memcache.MemcacheServiceFactory;
import com.google.inject.Singleton;
import com.numhero.client.model.pojoc.Session;

@Singleton
public class SessionDao {
    private MemcacheService memcache;

    public SessionDao() {

        memcache = MemcacheServiceFactory.getMemcacheService("Session");
    }

    public Session findBySessionID(String sessionID) {
        Session ret = (Session) memcache.get(sessionID);
        return ret;
    }

    public void save(Session session) {
        memcache.put(session.getSessionID(), session, Expiration.byDeltaSeconds(3600 * 12)); //12h
    }

    public void delete(String sessionID) {
        memcache.delete(sessionID);
    }

    public boolean isPresent(String sessionID) {
        return memcache.contains(sessionID);
    }
}