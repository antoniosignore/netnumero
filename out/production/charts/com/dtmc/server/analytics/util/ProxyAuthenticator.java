// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ProxyAuthenticator.java

package com.dtmc.server.analytics.util;

import java.net.Authenticator;
import java.net.PasswordAuthentication;

public class ProxyAuthenticator extends Authenticator
{

    public ProxyAuthenticator()
    {
    }

    protected PasswordAuthentication getPasswordAuthentication()
    {
        return new PasswordAuthentication("asignore", "nicholas".toCharArray());
    }
}
