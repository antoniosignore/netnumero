// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ZipUtils.java

package com.dtmc.server.analytics.util;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ZipUtils
{

    public ZipUtils()
    {
    }

    public static void zip(String dir, String output)
    {
        try
        {
            BufferedInputStream origin = null;
            FileOutputStream dest = new FileOutputStream(output);
            ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(dest));
            byte data[] = new byte[2048];
            File f = new File(dir);
            String files[] = f.list();
            for(int i = 0; i < files.length; i++)
            {
                System.out.println((new StringBuilder()).append("Adding: ").append(dir).append("/").append(files[i]).toString());
                FileInputStream fi = new FileInputStream((new StringBuilder()).append(dir).append("/").append(files[i]).toString());
                origin = new BufferedInputStream(fi, 2048);
                ZipEntry entry = new ZipEntry((new StringBuilder()).append("db/").append(files[i]).toString());
                out.putNextEntry(entry);
                int count;
                while((count = origin.read(data, 0, 2048)) != -1) 
                    out.write(data, 0, count);
                origin.close();
            }

            out.close();
        }
        catch(Exception e)
        {
            if(logger.isInfoEnabled())
                logger.info("exception:", e);
        }
    }

    public static void main(String args[])
    {
        zip("C:/db/agent1", "C:/db/agent1.zip");
    }

    static final int BUFFER = 2048;
    private static Log logger = LogFactory.getLog(com/dtmc/server/analytics/util/ZipUtils);

}
