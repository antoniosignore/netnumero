package com.numhero.client;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.numhero.client.model.datacargo.businessaccount.GetBusinessAccountRequest;
import com.numhero.client.model.datacargo.businessaccount.GetBusinessAccountResponse;
import com.numhero.client.model.pojoc.BusinessAccount;
import com.numhero.client.model.pojoc.User;
import com.numhero.client.service.Service;
import com.numhero.client.service.ServiceCallback;
import com.numhero.client.service.ServiceCallbackImpl;
import com.numhero.client.util.CoreUtils;
import com.numhero.shared.datacargo.CommandRequest;
import com.numhero.shared.datacargo.CommandResponse;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

@Singleton
public class ClientCache {
    @Inject
    private Service<CommandRequest, CommandResponse> service;

    private Map<CommandRequest, CacheEntry> cache;

    public ClientCache() {
        cache = new LinkedHashMap<CommandRequest, CacheEntry>();
    }

    public void dontUseCache(CommandRequest request, ServiceCallback<CommandResponse> callback) {
        fetchFromServer(request, callback);
    }

    public void useCache(CommandRequest request, ServiceCallback<CommandResponse> callback) {
        CacheEntry entry = null;
        entry = cache.get(request);
        if (entry == null || entry.isExpired()) {
            fetchFromServer(request, callback);
        } else {
            callback.onSuccess(entry.response);
        }
    }

    public void removeFromCache(CommandRequest request) {
        cache.remove(request);
    }

    // private methods
    private void fetchFromServer(final CommandRequest request, final ServiceCallback<CommandResponse> callback) {
        service.execute(request, new ServiceCallbackImpl<CommandResponse>() {
            @Override
            public void onSuccess(CommandResponse response) {
                CoreUtils.debug("Cache: " + request + " = " + response);
                cache.put(request, new CacheEntry(new Date().getTime(), (long) request.getCacheExpireInSec() * 1000, response));
                callback.onSuccess(response);
            }
        });
    }

    // static methods
    public static BusinessAccount getCurrentBA() {
        GetBusinessAccountRequest request = new GetBusinessAccountRequest();
        CacheEntry entry = Application.injector.getClientCache().cache.get(request);
        return entry == null ? null : ((GetBusinessAccountResponse) entry.response).getEntity();
    }

    // static methods
    public static User getCurrentUser() {
        GetBusinessAccountRequest request = new GetBusinessAccountRequest();
        CacheEntry entry = Application.injector.getClientCache().cache.get(request);
        return entry == null ? null : ((GetBusinessAccountResponse) entry.response).getCurrentUser();
    }

    // inner class
    private class CacheEntry {
        long timestamp;
        long expireInMs;
        CommandResponse response;

        public CacheEntry(long timestamp, long expireInMs, CommandResponse response) {
            this.timestamp = timestamp;
            this.expireInMs = expireInMs;
            this.response = response;
        }

        public boolean isExpired() {
            return expireInMs > 0 && new Date().getTime() > timestamp + expireInMs;
        }
    }
}
