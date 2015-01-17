// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   MessageUtils.java

package com.dtmc.server.analytics.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MessageUtils
{

    public MessageUtils()
    {
    }

    public static void debug(String s)
    {
        if(logger.isInfoEnabled())
            logger.info((new StringBuilder()).append("message = ").append(s).toString());
    }

    private static Log logger = LogFactory.getLog(com/dtmc/server/analytics/util/MessageUtils);

}
