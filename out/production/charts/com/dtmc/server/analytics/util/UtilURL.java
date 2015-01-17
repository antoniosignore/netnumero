// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   UtilURL.java

package com.dtmc.server.analytics.util;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class UtilURL
{

    public UtilURL()
    {
    }

    public static URL fromClass(Class contextClass)
    {
        String resourceName = contextClass.getName();
        int dotIndex = resourceName.lastIndexOf('.');
        if(dotIndex != -1)
            resourceName = resourceName.substring(0, dotIndex);
        resourceName = (new StringBuilder()).append(resourceName).append(".properties").toString();
        return fromResource(contextClass, resourceName);
    }

    public static URL fromResource(String resourceName)
    {
        return fromResource(resourceName, ((ClassLoader) (null)));
    }

    public static URL fromResource(Class contextClass, String resourceName)
    {
        if(contextClass == null)
            return fromResource(resourceName, ((ClassLoader) (null)));
        else
            return fromResource(resourceName, contextClass.getClassLoader());
    }

    public static URL fromResource(String resourceName, ClassLoader loader)
    {
        URL url = null;
        if(loader != null && url == null)
            url = loader.getResource(resourceName);
        if(loader != null && url == null)
            url = loader.getResource((new StringBuilder()).append(resourceName).append(".properties").toString());
        if(loader == null && url == null)
            try
            {
                loader = Thread.currentThread().getContextClassLoader();
            }
            catch(SecurityException e)
            {
                UtilURL utilURL = new UtilURL();
                loader = utilURL.getClass().getClassLoader();
            }
        if(url == null)
            url = loader.getResource(resourceName);
        if(url == null)
            url = loader.getResource((new StringBuilder()).append(resourceName).append(".properties").toString());
        if(url == null)
            url = ClassLoader.getSystemResource(resourceName);
        if(url == null)
            url = ClassLoader.getSystemResource((new StringBuilder()).append(resourceName).append(".properties").toString());
        if(url == null)
            url = fromFilename(resourceName);
        if(url == null)
            url = fromOfbizHomePath(resourceName);
        if(url == null)
            url = fromUrlString(resourceName);
        return url;
    }

    public static URL fromFilename(String filename)
    {
        if(filename == null)
            return null;
        File file = new File(filename);
        URL url = null;
        try
        {
            if(file.exists())
                url = file.toURL();
        }
        catch(MalformedURLException e)
        {
            if(logger.isInfoEnabled())
                logger.info("exception:", e);
            url = null;
        }
        return url;
    }

    public static URL fromUrlString(String urlString)
    {
        URL url = null;
        try
        {
            url = new URL(urlString);
        }
        catch(MalformedURLException e) { }
        return url;
    }

    public static URL fromOfbizHomePath(String filename)
    {
        String ofbizHome = System.getProperty("ofbiz.home");
        String newFilename = ofbizHome;
        if(!newFilename.endsWith("/") && !newFilename.startsWith("/"))
            newFilename = (new StringBuilder()).append(newFilename).append("/").toString();
        newFilename = (new StringBuilder()).append(newFilename).append(filename).toString();
        return fromFilename(newFilename);
    }

    private static Log logger = LogFactory.getLog(com/dtmc/server/analytics/util/UtilURL);

}
