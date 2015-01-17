// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Util.java

package com.dtmc.server.analytics.util;

import com.dtmc.server.analytics.finmath.Moment;
import java.io.*;
import java.net.*;
import java.util.Date;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

// Referenced classes of package com.dtmc.server.analytics.util:
//            NRError, FileUtils

public class Util
{

    public Util()
    {
    }

    public static int[] ivector(int startIndex, int size)
    {
        int v[] = new int[startIndex + size];
        for(int i = 0; i < v.length; i++)
            v[i] = 0;

        return v;
    }

    public static float[] vector(int startIndex, int size)
    {
        float v[] = new float[startIndex + size];
        for(int i = 0; i < v.length; i++)
            v[i] = 0.0F;

        return v;
    }

    public static Date[] datesvector(int startIndex, int size)
    {
        Date v[] = new Date[startIndex + size];
        for(int i = 0; i < v.length; i++)
            v[i] = null;

        return v;
    }

    public static int[] intvector(int startIndex, int size)
    {
        int v[] = new int[startIndex + size];
        for(int i = 0; i < v.length; i++)
            v[i] = 0;

        return v;
    }

    public static float[][] matrix(int start1, int size1, int start2, int size2)
    {
        float v[][] = new float[start1 + size1][];
        for(int i = 0; i < v.length; i++)
            v[i] = vector(start2, size2);

        return v;
    }

    public static void swap(float data[], int a, int b)
    {
        float tempr = data[a];
        data[a] = data[b];
        data[b] = tempr;
    }

    public static float sign(float a, float b)
    {
        return b < 0.0F ? -Math.abs(a) : Math.abs(a);
    }

    public static void nrerror(String message)
        throws NRError
    {
        throw new NRError(message);
    }

    public static int imin(int x, int y)
    {
        return x >= y ? y : x;
    }

    public static float max(float x, float y)
    {
        return x <= y ? y : x;
    }

    public static InputStream openFile(String s)
    {
        FileInputStream fileinputstream = new FileInputStream(s);
        return fileinputstream;
        Exception exception;
        exception;
        exception.printStackTrace();
        return null;
    }

    public static boolean closeURL(InputStream myInputStream)
    {
        try
        {
            myInputStream.close();
        }
        catch(IOException e)
        {
            if(logger.isInfoEnabled())
                logger.info("exception:", e);
            return false;
        }
        return true;
    }

    public static synchronized String getLineFromURL(InputStream myInputStream)
    {
        int ch = -1;
        StringBuffer sb = new StringBuffer(256);
        do
        {
            try
            {
                ch = myInputStream.read();
            }
            catch(IOException e)
            {
                return null;
            }
            if(ch == -1)
                if(sb.length() == 0)
                    return null;
                else
                    return sb.toString();
            if(ch == 10 || ch == 13)
            {
                if(sb.length() > 0)
                    return sb.toString();
            } else
            {
                sb.append((char)ch);
            }
        } while(true);
    }

    public static float[] sumSeries(float s1[], float s2[])
    {
        int size = s1.length - 1;
        float sum[] = vector(1, size);
        for(int i = 1; i <= size; i++)
            sum[i] = s1[i] + s2[i];

        return sum;
    }

    public static float[] diffSeries(float s1[], float s2[])
    {
        int size = s1.length - 1;
        float diff[] = vector(1, size);
        for(int i = 1; i <= size; i++)
            diff[i] = s1[i] - s2[i];

        return diff;
    }

    public static float[] exponential(float s1[])
    {
        int size = s1.length - 1;
        float sum[] = vector(1, size);
        for(int i = 1; i <= size; i++)
            sum[i] = (float)Math.exp(s1[i]);

        return sum;
    }

    public static float[] augmentByMovingAverage(float s1[])
        throws NRError
    {
        float aug[] = vector(1, size(s1));
        float madata[] = vector(1, 10);
        com.dtmc.server.analytics.finmath.Moment.MomentResult ma = null;
        for(int i = 1; i < size(s1); i++)
            aug[i] = s1[i + 1];

        float add = 0.0F;
        for(int j = 1; j <= 10; j++)
        {
            float val = s1[(size(s1) - 10) + j];
            madata[j] = val;
            add += val;
        }

        ma = Moment.Moment(madata, 10);
        aug[size(s1)] = ma.ave;
        return aug;
    }

    public static float[] concatenateSeries(float s1[], float s2[])
    {
        float totSerie[] = vector(1, size(s1) + size(s2));
        int i = -1;
        for(i = 1; i <= size(s1); i++)
            totSerie[i] = s1[i];

        for(int j = 1; j <= size(s2); j++)
        {
            totSerie[i] = s2[j];
            i++;
        }

        return totSerie;
    }

    public static float[] getPrevN(float series[], int seriesSize, int today)
    {
        float totSerie[] = vector(1, seriesSize);
        int i = -1;
        for(i = 1; i <= seriesSize; i++)
            totSerie[i] = series[(today - seriesSize) + i];

        return totSerie;
    }

    public static float[] getNextN(float series[], int seriesSize, int today)
    {
        float totSerie[] = vector(1, seriesSize);
        int i = -1;
        for(i = 1; i <= seriesSize; i++)
            totSerie[i] = series[today + i];

        return totSerie;
    }

    public static float getLastValue(float series[])
    {
        return series[series.length - 1];
    }

    public static int size(float s1[])
    {
        return s1.length - 1;
    }

    public static void setLastValue(float series[], float x)
    {
        series[size(series)] = x;
    }

    public static void toFile(String filename, float series[])
        throws FileNotFoundException
    {
        PrintWriter pw = FileUtils.createFile(filename);
        for(int i = 1; i <= series.length - 1; i++)
        {
            float sery = series[i];
            pw.println((new StringBuilder()).append(i).append("=").append(sery).toString());
        }

        pw.close();
    }

    public static InputStream openURL(String s)
    {
        URL url;
        try
        {
            url = new URL(s);
        }
        catch(MalformedURLException malformedurlexception)
        {
            return openFile(s);
        }
        InputStream inputstream;
        try
        {
            URLConnection urlconnection = url.openConnection();
            urlconnection.setUseCaches(false);
            inputstream = urlconnection.getInputStream();
        }
        catch(IOException ioexception)
        {
            ioexception.printStackTrace(System.out);
            return null;
        }
        return inputstream;
    }

    public static void dumpSerie(float lserie[])
    {
        for(int i = 1; i <= size(lserie); i++)
            System.out.println((new StringBuilder()).append(i).append("\t: ").append(lserie[i]).toString());

    }

    public static double[] convert(float serie[])
    {
        double ar[] = new double[serie.length];
        for(int i = 1; i < serie.length; i++)
            ar[i - 1] = serie[i];

        return ar;
    }

    private static Log logger = LogFactory.getLog(com/dtmc/server/analytics/util/Util);

}
