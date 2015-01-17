// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   SortedAttribute.java

package com.dtmc.server.analytics.util;


public class SortedAttribute
{

    public SortedAttribute(String attName, String attType)
    {
        this.attName = attName;
        this.attType = attType;
    }

    public String getAttName()
    {
        return attName;
    }

    public String getAttType()
    {
        return attType;
    }

    public void setAttName(String attName)
    {
        this.attName = attName;
    }

    public void setAttType(String attType)
    {
        this.attType = attType;
    }

    private String attName;
    private String attType;
}
