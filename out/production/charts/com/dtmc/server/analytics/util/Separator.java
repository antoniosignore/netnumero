// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Separator.java

package com.dtmc.server.analytics.util;


public class Separator
{

    public Separator()
    {
    }

    public static char getFileSeparator()
    {
        String s1 = System.getProperty("file.separator", "/");
        s1.getChars(0, 1, separator, 0);
        return separator[0];
    }

    static char separator[] = new char[1];

}
