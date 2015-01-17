// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   PersistenceUtils.java

package com.dtmc.server.analytics.util;

import java.io.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PersistenceUtils
{

    public PersistenceUtils()
    {
    }

    public static void write(String filename, Serializable obj)
    {
        try
        {
            FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(obj);
            oos.flush();
            fos.close();
        }
        catch(Throwable e)
        {
            if(logger.isInfoEnabled())
                logger.info("exception:", e);
        }
    }

    public static Serializable read(String filename)
    {
        Serializable obj = null;
        FileInputStream fis = new FileInputStream(filename);
        ObjectInputStream ois = new ObjectInputStream(fis);
        obj = (Serializable)ois.readObject();
        fis.close();
        return obj;
        Throwable e;
        e;
        if(logger.isInfoEnabled())
            logger.info("exception:", e);
        return null;
    }

    private static Log logger = LogFactory.getLog(com/dtmc/server/analytics/util/PersistenceUtils);

}
