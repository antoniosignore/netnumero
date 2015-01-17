// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   OrderedMap.java

package com.dtmc.server.analytics.util;

import java.util.*;

// Referenced classes of package com.dtmc.server.analytics.util:
//            OrderedSet

public class OrderedMap extends HashMap
{

    public OrderedMap()
    {
        orderedKeys = new LinkedList();
    }

    public Set keySet()
    {
        return new OrderedSet(orderedKeys);
    }

    public Object put(Object key, Object value)
    {
        if(!orderedKeys.contains(key))
            orderedKeys.add(key);
        return super.put(key, value);
    }

    public void clear()
    {
        super.clear();
        orderedKeys.clear();
    }

    public Object remove(Object key)
    {
        if(orderedKeys.contains(key))
            orderedKeys.remove(key);
        return super.remove(key);
    }

    public Collection values()
    {
        Iterator i = orderedKeys.iterator();
        if(!i.hasNext())
            return null;
        List values = new ArrayList();
        for(; i.hasNext(); values.add(get(i.next())));
        return values;
    }

    private List orderedKeys;
}
