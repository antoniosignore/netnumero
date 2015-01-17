// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   CacheCleaner.java

package com.dtmc.server.analytics.graphics;

import java.io.File;
import java.io.PrintStream;
import java.util.Date;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class CacheCleaner
    implements Runnable
{

    public CacheCleaner()
    {
        cacheDir = null;
        sleepInterval = 0x1499700L;
        expiredAge = 0x927c0L;
        daemonThread = true;
        verbose = false;
        runOnce = false;
        done = false;
        myThread = null;
    }

    protected void log(String s)
    {
        System.out.println(s);
    }

    protected synchronized void deleteOldFiles(String files[])
    {
        long now = (new Date()).getTime();
        if(verbose)
            log((new StringBuilder()).append("files is this long:").append(files.length).toString());
        for(int i = 0; i < files.length; i++)
        {
            File f = new File((new StringBuilder()).append(cacheDir).append(File.separator).append(files[i]).toString());
            long diff = now - f.lastModified();
            if(diff <= expiredAge)
                continue;
            if(verbose)
                log((new StringBuilder()).append("deleting ").append(f).toString());
            f.delete();
        }

    }

    public String getCacheDir()
    {
        return cacheDir;
    }

    public int getExpiredTimeInMinutes()
    {
        return (int)(expiredAge / 60000L);
    }

    public boolean getRunOnce()
    {
        return runOnce;
    }

    public int getSleepIntervalInMinutes()
    {
        return (int)(sleepInterval / 60000L);
    }

    public boolean isDone()
    {
        return done;
    }

    public static void main(String args[])
    {
        CacheCleaner me = new CacheCleaner();
        me.daemonThread = false;
        if(args.length != 0)
        {
            for(int i = 0; i < args.length; i++)
                if(args[i].startsWith("-"))
                    if(args[i].charAt(1) == 'd')
                        me.setCacheDir(args[i].substring(2));
                    else
                    if(args[i].charAt(1) == 's')
                        me.setSleepIntervalInMinutes(Integer.parseInt(args[i].substring(2)));
                    else
                    if(args[i].charAt(1) == 'x')
                        me.setExpiredTimeInMinutes(Integer.parseInt(args[i].substring(2)));
                    else
                    if(args[i].charAt(1) == 'v')
                        me.verbose = true;
                    else
                    if(args[i].charAt(1) == 'r')
                    {
                        me.runOnce = true;
                    } else
                    {
                        me.printUsage();
                        System.exit(0);
                    }

        } else
        {
            me.printUsage();
            System.exit(0);
        }
        me.start();
    }

    private void printUsage()
    {
        log("CacheCleaner arguments:");
        log("\t-xExpiredTimeInMinutes");
        log("\t-sSleepIntervalInMinutes");
        log("\t-dCacheDirectory");
        log("\t-v verbose mode on");
        log("     -r run once and exit");
        log("eg: java CacheCleaner -dE:\\apache\\htdocs\\images -x10 -s120");
    }

    public void run()
    {
        if(myThread == null)
        {
            log("null thread calling me...");
            return;
        }
        if(cacheDir == null)
        {
            log("CacheCleaner: cacheDir has not been set.  exiting...");
            return;
        }
_L2:
        File cache;
        cache = new File(cacheDir);
        if(!cache.isDirectory())
        {
            log("CacheCleaner: cacheDir not a directory");
            return;
        }
        try
        {
            deleteOldFiles(cache.list());
            myThread;
            Thread.sleep(sleepInterval);
        }
        catch(Exception e)
        {
            log("CacheCleaner problem:");
            if(logger.isInfoEnabled())
                logger.info("exception:", e);
        }
        if(runOnce)
        {
            done = true;
            return;
        }
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void setCacheDir(String dir)
    {
        cacheDir = dir;
    }

    public void setExpiredTimeInMinutes(int minutes)
    {
        if(minutes > 0)
            expiredAge = 60000 * minutes;
    }

    public void setRunOnce(boolean truefalse)
    {
        runOnce = truefalse;
    }

    public void setSleepIntervalInMinutes(int interval)
    {
        if(sleepInterval > 0L)
            sleepInterval = 60000 * interval;
    }

    public void start()
    {
        if(myThread == null)
        {
            myThread = new Thread(this);
            myThread.setPriority(1);
            myThread.setDaemon(daemonThread);
            myThread.start();
        }
    }

    public void stop()
    {
        if(myThread != null)
            myThread = null;
    }

    private static Log logger = LogFactory.getLog(com/dtmc/server/analytics/graphics/CacheCleaner);
    String cacheDir;
    long sleepInterval;
    long expiredAge;
    boolean daemonThread;
    boolean verbose;
    private boolean runOnce;
    boolean done;
    Thread myThread;

}
