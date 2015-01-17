// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Utility.java

package com.numhero.shared.finance.beans;


public class Utility
{

    public Utility()
    {
    }

    static boolean equalsWithNullCheck(Object a, Object b)
    {
        return a == b || a != null && a.equals(b);
    }
}
