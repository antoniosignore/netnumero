// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   PredictBase.java

package com.dtmc.server.analytics.timeseries;

import java.io.PrintStream;

public abstract class PredictBase
{

    public PredictBase()
    {
    }

    protected void split(double vec[], int N)
    {
        int start = 1;
        for(int end = N - 1; start < end; end--)
        {
            for(int i = start; i < end; i += 2)
            {
                double tmp = vec[i];
                vec[i] = vec[i + 1];
                vec[i + 1] = tmp;
            }

            start++;
        }

    }

    protected void merge(double vec[], int N)
    {
        int half = N >> 1;
        int start = half - 1;
        for(int end = half; start > 0; end++)
        {
            for(int i = start; i < end; i += 2)
            {
                double tmp = vec[i];
                vec[i] = vec[i + 1];
                vec[i + 1] = tmp;
            }

            start--;
        }

    }

    private double round4(double d)
    {
        double multiplier = 10000D;
        double rounded = (double)Math.round(d * 10000D) / 10000D;
        return rounded;
    }

    public void pr_ordered(double vec[])
    {
        if(vec != null)
        {
            int len = vec.length;
            if(len > 0)
            {
                System.out.println(round4(vec[0]));
                int num_in_freq = 1;
                int cnt = 0;
                for(int i = 1; i < len; i++)
                {
                    System.out.print((new StringBuilder()).append(round4(vec[i])).append(" ").toString());
                    if(++cnt == num_in_freq)
                    {
                        System.out.println();
                        cnt = 0;
                        num_in_freq *= 2;
                    }
                }

            }
        }
    }

    protected abstract void predict(double ad[], int i, int j);

    public void forwardTrans(double vec[])
    {
        int N = vec.length;
        for(int n = N; n > 1; n >>= 1)
        {
            split(vec, n);
            predict(vec, n, 1);
        }

    }

    public void inverseTrans(double vec[])
    {
        int N = vec.length;
        for(int n = 2; n <= N; n <<= 1)
        {
            predict(vec, n, 2);
            merge(vec, n);
        }

    }

    protected final int forward = 1;
    protected final int inverse = 2;
}
