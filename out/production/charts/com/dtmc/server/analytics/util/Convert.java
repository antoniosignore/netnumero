// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Convert.java

package com.dtmc.server.analytics.util;


public class Convert
{

    public Convert()
    {
    }

    public static int toInt(String s)
    {
        return (new Integer(s)).intValue();
    }

    public static float toFloat(String s)
    {
        return (new Float(s)).floatValue();
    }

    public static long toLong(String s)
    {
        return (new Long(s)).longValue();
    }

    public static double toDouble(String s)
    {
        return (new Double(s)).doubleValue();
    }
}
