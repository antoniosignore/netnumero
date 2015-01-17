// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Maths.java

package com.dtmc.server.analytics.util;


public class Maths
{

    public Maths()
    {
    }

    public static double hypot(double a, double b)
    {
        double r;
        if(Math.abs(a) > Math.abs(b))
        {
            r = b / a;
            r = Math.abs(a) * Math.sqrt(1.0D + r * r);
        } else
        if(b != 0.0D)
        {
            r = a / b;
            r = Math.abs(b) * Math.sqrt(1.0D + r * r);
        } else
        {
            r = 0.0D;
        }
        return r;
    }
}
