// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Registar.java

package com.dtmc.server.analytics.util;

import java.util.Hashtable;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Registar
{

    public Registar()
    {
    }

    public static Object addname(String name)
    {
        Object obj = registar.put(name, "present");
        return obj;
    }

    public static boolean exist(String name)
    {
        return registar.containsKey(name);
    }

    public static void main(String args[])
    {
        addname("pippo");
        addname("pippo");
    }

    private static Log logger = LogFactory.getLog(com/dtmc/server/analytics/util/Registar);
    static Hashtable registar = new Hashtable();

}
