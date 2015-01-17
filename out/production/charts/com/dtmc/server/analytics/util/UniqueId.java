// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   UniqueId.java

package com.dtmc.server.analytics.util;


public class UniqueId
{

    public UniqueId()
    {
    }

    public static synchronized int getUniqueId()
    {
        return id++;
    }

    public static int getId()
    {
        return id;
    }

    public static void setId(int id)
    {
        id = id;
    }

    static int id = 0;

}
