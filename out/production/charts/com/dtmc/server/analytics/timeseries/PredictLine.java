// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   PredictLine.java

package com.dtmc.server.analytics.timeseries;

import java.io.PrintStream;

// Referenced classes of package com.dtmc.server.analytics.timeseries:
//            PredictBase

public class PredictLine extends PredictBase
{

    public PredictLine()
    {
    }

    private double new_y(double y1, double y2)
    {
        double y = 2D * y2 - y1;
        return y;
    }

    protected void predict(double vec[], int N, int direction)
    {
        int half = N >> 1;
        for(int i = 0; i < half; i++)
        {
            int j = i + half;
            double predictVal;
            if(i < half - 1)
                predictVal = (vec[i] + vec[i + 1]) / 2D;
            else
            if(N == 2)
                predictVal = vec[0];
            else
                predictVal = new_y(vec[i - 1], vec[i]);
            if(direction == 1)
            {
                vec[j] = vec[j] - predictVal;
                continue;
            }
            if(direction == 2)
                vec[j] = vec[j] + predictVal;
            else
                System.out.println("PredictLine::predict: bad direction value");
        }

    }
}
