// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Type.java

package com.dtmc.server.analytics.util;


public class Type
{

    Type(String name, int dim)
    {
        this.name = name;
        this.dim = dim;
    }

    public String toString()
    {
        return (new StringBuilder()).append("").append(getClass()).append("[name=").append(name).append(",dim=").append(dim).append("]").toString();
    }

    public String name;
    public int dim;
}
