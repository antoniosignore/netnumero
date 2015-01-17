// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   UtilCache.java

package com.dtmc.server.analytics.util;

import java.lang.ref.SoftReference;
import java.util.*;

public class UtilCache
{
    public static class CacheLine
    {

        public Object getValue()
        {
            if(valueRef == null)
                return null;
            if(useSoftReference)
                return ((SoftReference)valueRef).get();
            else
                return valueRef;
        }

        public void setUseSoftReference(boolean useSoftReference)
        {
            if(this.useSoftReference != useSoftReference)
                synchronized(this)
                {
                    this.useSoftReference = useSoftReference;
                    if(useSoftReference)
                        valueRef = new SoftReference(valueRef);
                    else
                        valueRef = ((SoftReference)valueRef).get();
                }
        }

        public Object valueRef;
        public long loadTime;
        public boolean useSoftReference;

        public CacheLine(Object value, boolean useSoftReference)
        {
            valueRef = null;
            loadTime = 0L;
            this.useSoftReference = false;
            if(useSoftReference)
                valueRef = new SoftReference(value);
            else
                valueRef = value;
            this.useSoftReference = useSoftReference;
        }

        public CacheLine(Object value, boolean useSoftReference, long loadTime)
        {
            this(value, useSoftReference);
            this.loadTime = loadTime;
        }
    }


    public UtilCache(String cacheName, long maxSize, long expireTime, boolean useSoftReference)
    {
        keyLRUList = new LinkedList();
        cacheLineTable = new HashMap();
        hitCount = 0L;
        missCount = 0L;
        this.maxSize = 0L;
        this.expireTime = 0L;
        this.useSoftReference = false;
        this.useSoftReference = useSoftReference;
        this.maxSize = maxSize;
        this.expireTime = expireTime;
        setPropertiesParams(cacheName);
        name = (new StringBuilder()).append(cacheName).append(getNextDefaultIndex(cacheName)).toString();
        utilCacheTable.put(name, this);
    }

    public UtilCache(String cacheName, long maxSize, long expireTime)
    {
        this(cacheName, maxSize, expireTime, false);
    }

    public UtilCache(long maxSize, long expireTime)
    {
        keyLRUList = new LinkedList();
        cacheLineTable = new HashMap();
        hitCount = 0L;
        missCount = 0L;
        this.maxSize = 0L;
        this.expireTime = 0L;
        useSoftReference = false;
        useSoftReference = false;
        this.maxSize = maxSize;
        this.expireTime = expireTime;
        String name = (new StringBuilder()).append("specified").append(getNextDefaultIndex("specified")).toString();
        setPropertiesParams(name);
        utilCacheTable.put(name, this);
    }

    public UtilCache(String cacheName)
    {
        keyLRUList = new LinkedList();
        cacheLineTable = new HashMap();
        hitCount = 0L;
        missCount = 0L;
        maxSize = 0L;
        expireTime = 0L;
        useSoftReference = false;
        setPropertiesParams("default");
        setPropertiesParams(cacheName);
        name = (new StringBuilder()).append(cacheName).append(getNextDefaultIndex(cacheName)).toString();
        utilCacheTable.put(name, this);
    }

    public UtilCache()
    {
        keyLRUList = new LinkedList();
        cacheLineTable = new HashMap();
        hitCount = 0L;
        missCount = 0L;
        maxSize = 0L;
        expireTime = 0L;
        useSoftReference = false;
        setPropertiesParams("default");
        name = (new StringBuilder()).append("default").append(getNextDefaultIndex("default")).toString();
        utilCacheTable.put(name, this);
    }

    protected String getNextDefaultIndex(String cacheName)
    {
        Integer curInd = (Integer)defaultIndices.get(cacheName);
        if(curInd == null)
        {
            defaultIndices.put(cacheName, new Integer(1));
            return "";
        } else
        {
            defaultIndices.put(cacheName, new Integer(curInd.intValue() + 1));
            return Integer.toString(curInd.intValue() + 1);
        }
    }

    protected void setPropertiesParams(String cacheName)
    {
        ResourceBundle res = ResourceBundle.getBundle("cache");
        if(res != null)
        {
            try
            {
                String value = res.getString((new StringBuilder()).append(cacheName).append(".maxSize").toString());
                Long longValue = new Long(value);
                if(longValue != null)
                    maxSize = longValue.longValue();
            }
            catch(Exception e) { }
            try
            {
                String value = res.getString((new StringBuilder()).append(cacheName).append(".expireTime").toString());
                Long longValue = new Long(value);
                if(longValue != null)
                    expireTime = longValue.longValue();
            }
            catch(Exception e) { }
            try
            {
                String value = res.getString((new StringBuilder()).append(cacheName).append(".useSoftReference").toString());
                if(value != null)
                    useSoftReference = "true".equals(value);
            }
            catch(Exception e) { }
        }
    }

    public synchronized void put(Object key, Object value)
    {
        if(key == null)
            return;
        if(maxSize > 0L)
            if(cacheLineTable.containsKey(key))
            {
                keyLRUList.remove(key);
                keyLRUList.addFirst(key);
            } else
            {
                keyLRUList.addFirst(key);
            }
        if(expireTime > 0L)
            cacheLineTable.put(key, new CacheLine(value, useSoftReference, System.currentTimeMillis()));
        else
            cacheLineTable.put(key, new CacheLine(value, useSoftReference));
        if(maxSize > 0L && (long)cacheLineTable.size() > maxSize)
        {
            Object lastKey = keyLRUList.getLast();
            remove(lastKey);
        }
    }

    public Object get(Object key)
    {
        if(key == null)
        {
            missCount++;
            return null;
        }
        CacheLine line = (CacheLine)cacheLineTable.get(key);
        if(hasExpired(line))
        {
            remove(key);
            line = null;
        }
        if(line == null)
        {
            missCount++;
            return null;
        }
        hitCount++;
        if(maxSize > 0L)
            synchronized(this)
            {
                keyLRUList.remove(key);
                keyLRUList.addFirst(key);
            }
        return line.getValue();
    }

    public synchronized Object remove(Object key)
    {
        if(key == null)
        {
            missCount++;
            return null;
        }
        CacheLine line = (CacheLine)cacheLineTable.remove(key);
        if(line != null)
        {
            if(maxSize > 0L)
                keyLRUList.remove(key);
            return line.getValue();
        } else
        {
            missCount++;
            return null;
        }
    }

    public synchronized void clear()
    {
        cacheLineTable.clear();
        keyLRUList.clear();
        clearCounters();
    }

    public static void clearAllCaches()
    {
        UtilCache utilCache;
        for(Iterator entries = utilCacheTable.entrySet().iterator(); entries.hasNext(); utilCache.clear())
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)entries.next();
            utilCache = (UtilCache)entry.getValue();
        }

    }

    public String getName()
    {
        return name;
    }

    public long getHitCount()
    {
        return hitCount;
    }

    public long getMissCount()
    {
        return missCount;
    }

    public void clearCounters()
    {
        hitCount = 0L;
        missCount = 0L;
    }

    public void setMaxSize(long maxSize)
    {
        if(maxSize <= 0L)
            keyLRUList.clear();
        else
        if(maxSize > 0L && this.maxSize <= 0L)
        {
            for(Iterator keys = cacheLineTable.keySet().iterator(); keys.hasNext(); keyLRUList.add(keys.next()));
        }
        if(maxSize > 0L && (long)cacheLineTable.size() > maxSize)
        {
            Object lastKey;
            for(; (long)cacheLineTable.size() > maxSize; remove(lastKey))
                lastKey = keyLRUList.getLast();

        }
        this.maxSize = maxSize;
    }

    public long getMaxSize()
    {
        return maxSize;
    }

    public void setExpireTime(long expireTime)
    {
        if(this.expireTime <= 0L && expireTime > 0L)
        {
            long currentTime = System.currentTimeMillis();
            for(Iterator values = cacheLineTable.values().iterator(); values.hasNext();)
            {
                CacheLine line = (CacheLine)values.next();
                line.loadTime = currentTime;
            }

        } else
        if(this.expireTime <= 0L)
            if(expireTime <= 0L);
        this.expireTime = expireTime;
    }

    public long getExpireTime()
    {
        return expireTime;
    }

    public void setUseSoftReference(boolean useSoftReference)
    {
        if(this.useSoftReference != useSoftReference)
        {
            this.useSoftReference = useSoftReference;
            CacheLine line;
            for(Iterator values = cacheLineTable.values().iterator(); values.hasNext(); line.setUseSoftReference(useSoftReference))
                line = (CacheLine)values.next();

        }
    }

    public boolean getUseSoftReference()
    {
        return useSoftReference;
    }

    public long size()
    {
        return (long)cacheLineTable.size();
    }

    public boolean containsKey(Object key)
    {
        CacheLine line = (CacheLine)cacheLineTable.get(key);
        if(hasExpired(line))
        {
            remove(key);
            line = null;
        }
        return line != null;
    }

    public boolean hasExpired(Object key)
    {
        if(key == null)
        {
            return false;
        } else
        {
            CacheLine line = (CacheLine)cacheLineTable.get(key);
            return hasExpired(line);
        }
    }

    protected boolean hasExpired(CacheLine line)
    {
        if(line == null)
            return false;
        if(useSoftReference && line.getValue() == null)
            return true;
        if(expireTime <= 0L)
            return false;
        if(line.loadTime <= 0L)
            return true;
        return line.loadTime + expireTime < System.currentTimeMillis();
    }

    public void clearExpired()
    {
        Iterator keys = cacheLineTable.keySet().iterator();
        do
        {
            if(!keys.hasNext())
                break;
            Object key = keys.next();
            if(hasExpired(key))
                remove(key);
        } while(true);
    }

    public static void clearExpiredFromAllCaches()
    {
        UtilCache utilCache;
        for(Iterator entries = utilCacheTable.entrySet().iterator(); entries.hasNext(); utilCache.clearExpired())
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)entries.next();
            utilCache = (UtilCache)entry.getValue();
        }

    }

    public static boolean validKey(String cacheName, Object key)
    {
        UtilCache cache = (UtilCache)utilCacheTable.get(cacheName);
        return cache != null && cache.containsKey(key);
    }

    public static Map utilCacheTable = new HashMap();
    protected static Map defaultIndices = new HashMap();
    protected String name;
    public LinkedList keyLRUList;
    public Map cacheLineTable;
    protected long hitCount;
    protected long missCount;
    protected long maxSize;
    protected long expireTime;
    protected boolean useSoftReference;

}
