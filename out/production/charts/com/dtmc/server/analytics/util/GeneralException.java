// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   GeneralException.java

package com.dtmc.server.analytics.util;

import java.io.PrintStream;
import java.io.PrintWriter;

public class GeneralException extends Exception
{

    public GeneralException()
    {
        nested = null;
    }

    public GeneralException(String msg)
    {
        super(msg);
        nested = null;
    }

    public GeneralException(String msg, Throwable nested)
    {
        super(msg);
        this.nested = null;
        this.nested = nested;
    }

    public GeneralException(Throwable nested)
    {
        this.nested = null;
        this.nested = nested;
    }

    public String getMessage()
    {
        if(nested != null)
            return (new StringBuilder()).append(super.getMessage()).append(" (").append(nested.getMessage()).append(")").toString();
        else
            return super.getMessage();
    }

    public String getNonNestedMessage()
    {
        return super.getMessage();
    }

    public Throwable getNested()
    {
        if(nested == null)
            return this;
        else
            return nested;
    }

    public void printStackTrace()
    {
        super.printStackTrace();
        if(nested != null)
            nested.printStackTrace();
    }

    public void printStackTrace(PrintStream ps)
    {
        super.printStackTrace(ps);
        if(nested != null)
            nested.printStackTrace(ps);
    }

    public void printStackTrace(PrintWriter pw)
    {
        super.printStackTrace(pw);
        if(nested != null)
            nested.printStackTrace(pw);
    }

    Throwable nested;
}
