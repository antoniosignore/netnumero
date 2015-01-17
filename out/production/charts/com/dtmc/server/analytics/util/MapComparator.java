// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   MapComparator.java

package com.dtmc.server.analytics.util;

import java.util.*;

public class MapComparator
    implements Comparator
{

    public MapComparator(List keys)
    {
        this.keys = keys;
    }

    public boolean equals(Object obj)
    {
        return obj.equals(this);
    }

    public int compare(Object obj1, Object obj2)
    {
        Map map1;
        Map map2;
        try
        {
            map1 = (Map)obj1;
            map2 = (Map)obj2;
        }
        catch(ClassCastException e)
        {
            throw new IllegalArgumentException("Objects not from the Map interface");
        }
        if(keys == null || keys.size() < 1)
            throw new IllegalArgumentException("No sort fields defined");
        for(Iterator i = keys.iterator(); i.hasNext();)
        {
            boolean ascending = true;
            Object key = i.next();
            if(key instanceof String)
            {
                String keyStr = (String)key;
                if(keyStr.charAt(0) == '-')
                {
                    ascending = false;
                    key = keyStr.substring(1);
                } else
                if(keyStr.charAt(0) == '+')
                {
                    ascending = true;
                    key = keyStr.substring(1);
                }
            }
            Object o1 = map1.get(key);
            Object o2 = map2.get(key);
            if(o1 != null || o2 != null)
            {
                int compareResult = 0;
                if(o1 != null && o2 == null)
                    compareResult = -1;
                if(o1 == null && o2 != null)
                    compareResult = 1;
                if(compareResult == 0)
                    try
                    {
                        Comparable comp1 = (Comparable)o1;
                        Comparable comp2 = (Comparable)o2;
                        compareResult = comp1.compareTo(comp2);
                    }
                    catch(Exception e)
                    {
                        String errorMessage = (new StringBuilder()).append("Error sorting list of Maps: ").append(e.toString()).toString();
                        throw new RuntimeException(errorMessage);
                    }
                if(compareResult != 0)
                    if(ascending)
                        return compareResult;
                    else
                        return -compareResult;
            }
        }

        return 0;
    }

    public static final String module = com/dtmc/server/analytics/util/MapComparator.getName();
    private List keys;

}
