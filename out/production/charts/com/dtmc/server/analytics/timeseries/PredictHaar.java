// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   PredictHaar.java

package com.dtmc.server.analytics.timeseries;

import java.io.PrintStream;

// Referenced classes of package com.dtmc.server.analytics.timeseries:
//            PredictBase

public class PredictHaar extends PredictBase
{

    public PredictHaar()
    {
    }

    protected void predict(double vec[], int N, int direction)
    {
        int half = N >> 1;
        int cnt = 0;
        for(int i = 0; i < half; i++)
        {
            double predictVal = vec[i];
            int j = i + half;
            if(direction == 1)
            {
                vec[j] = vec[j] - predictVal;
                continue;
            }
            if(direction == 2)
                vec[j] = vec[j] + predictVal;
            else
                System.out.println("PredictHaar::predict: bad direction value");
        }

    }
}
