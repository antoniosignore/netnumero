// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   OrderedSet.java

package com.dtmc.server.analytics.util;

import java.util.*;

public class OrderedSet extends AbstractSet
{

    public OrderedSet()
    {
        backedList = new LinkedList();
    }

    public OrderedSet(Collection c)
    {
        backedList = new LinkedList();
        for(Iterator i = c.iterator(); i.hasNext(); add(i.next()));
    }

    public Iterator iterator()
    {
        return backedList.iterator();
    }

    public int size()
    {
        return backedList.size();
    }

    public boolean add(Object obj)
    {
        int index = backedList.indexOf(obj);
        if(index == -1)
        {
            return backedList.add(obj);
        } else
        {
            backedList.set(index, obj);
            return false;
        }
    }

    private List backedList;
}
