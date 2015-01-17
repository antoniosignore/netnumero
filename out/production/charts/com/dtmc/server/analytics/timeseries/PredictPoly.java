// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   PredictPoly.java

package com.dtmc.server.analytics.timeseries;

import java.io.PrintStream;

// Referenced classes of package com.dtmc.server.analytics.timeseries:
//            PredictBase

public class PredictPoly extends PredictBase
{

    private void legrange(double x, int N, double c[])
    {
        for(int i = 0; i < N; i++)
        {
            double num = 1.0D;
            double denom = 1.0D;
            for(int k = 0; k < N; k++)
                if(i != k)
                {
                    num *= x - (double)k;
                    denom *= i - k;
                }

            c[i] = num / denom;
        }

    }

    private void fillTable(int N, double table[][])
    {
        double n = N;
        int i = 0;
        for(double x = 0.5D; x < n; x++)
        {
            legrange(x, N, table[i]);
            i++;
        }

    }

    public PredictPoly()
    {
        fourPointTable = new double[4][4];
        fillTable(4, fourPointTable);
        twoPointTable = new double[2][2];
        fillTable(2, twoPointTable);
    }

    private void printTable(double table[][], int N)
    {
        System.out.println((new StringBuilder()).append(N).append("-point interpolation table:").toString());
        double x = 0.5D;
        for(int i = 0; i < N; i++)
        {
            System.out.print((new StringBuilder()).append(x).append(": ").toString());
            for(int j = 0; j < N; j++)
            {
                System.out.print(table[i][j]);
                if(j < N - 1)
                    System.out.print(", ");
            }

            System.out.println();
            x++;
        }

    }

    public void printTables()
    {
        printTable(fourPointTable, 4);
        printTable(twoPointTable, 2);
    }

    private void getCoef(double x, int n, double c[])
    {
        double table[][] = (double[][])null;
        int j = (int)x;
        if(j < 0 || j >= n)
            System.out.println((new StringBuilder()).append("PredictPoly::getCoef: n = ").append(n).append(", bad x value").toString());
        if(n == 4)
            table = fourPointTable;
        else
        if(n == 2)
        {
            table = twoPointTable;
            c[2] = 0.0D;
            c[3] = 0.0D;
        } else
        {
            System.out.println("PredictPoly::getCoef: bad value for N");
        }
        if(table != null)
        {
            for(int i = 0; i < n; i++)
                c[i] = table[j][i];

        }
    }

    private double interpPoint(double x, int N, double d[])
    {
        double c[] = new double[4];
        double point = 0.0D;
        int n = 4;
        if(N < 4)
            n = N;
        getCoef(x, n, c);
        if(n == 4)
            point = c[0] * d[0] + c[1] * d[1] + c[2] * d[2] + c[3] * d[3];
        else
        if(n == 2)
            point = c[0] * d[0] + c[1] * d[1];
        return point;
    }

    private void fill(double vec[], double d[], int N, int start)
    {
        int n = 4;
        if(n > N)
            n = N;
        int end = start + n;
        int j = 0;
        for(int i = start; i < end; i++)
        {
            d[j] = vec[i];
            j++;
        }

    }

    protected void predict(double vec[], int N, int direction)
    {
        int half = N >> 1;
        double d[] = new double[4];
        int k = 42;
        for(int i = 0; i < half; i++)
        {
            double predictVal;
            if(i == 0)
            {
                if(half == 1)
                {
                    predictVal = vec[0];
                } else
                {
                    fill(vec, d, N, 0);
                    predictVal = interpPoint(0.5D, half, d);
                }
            } else
            if(i == 1)
                predictVal = interpPoint(1.5D, half, d);
            else
            if(i == half - 2)
                predictVal = interpPoint(2.5D, half, d);
            else
            if(i == half - 1)
            {
                predictVal = interpPoint(3.5D, half, d);
            } else
            {
                fill(vec, d, N, i - 1);
                predictVal = interpPoint(1.5D, half, d);
            }
            int j = i + half;
            if(direction == 1)
            {
                vec[j] = vec[j] - predictVal;
                continue;
            }
            if(direction == 2)
                vec[j] = vec[j] + predictVal;
            else
                System.out.println("PredictPoly::predict: bad direction value");
        }

    }

    final int numPts = 4;
    private double fourPointTable[][];
    private double twoPointTable[][];
}
