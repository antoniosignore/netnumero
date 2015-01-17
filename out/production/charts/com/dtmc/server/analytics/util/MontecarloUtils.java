// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   MontecarloUtils.java

package com.dtmc.server.analytics.util;

import com.dtmc.server.analytics.matrix.Matrix;
import com.dtmc.server.cern.colt.list.DoubleArrayList;
import com.dtmc.server.cern.colt.matrix.DoubleMatrix1D;
import com.dtmc.server.cern.colt.matrix.DoubleMatrix2D;
import com.dtmc.server.cern.colt.matrix.impl.DenseDoubleMatrix1D;
import com.dtmc.server.cern.colt.matrix.linalg.Algebra;
import com.dtmc.server.cern.jet.random.AbstractDistribution;
import com.dtmc.server.cern.jet.random.Normal;
import com.dtmc.server.cern.jet.random.engine.MersenneTwister;
import com.dtmc.server.cern.jet.random.engine.RandomEngine;
import com.dtmc.server.hep.aida.bin.DynamicBin1D;
import hep.analysis.Histogram;
import jas.hep.PartitionAdapter;
import jas.hist.JASHist;
import jas.hist.JASHistData;
import java.awt.Color;
import java.awt.Dimension;

public class MontecarloUtils
{

    public MontecarloUtils()
    {
    }

    public static final AbstractDistribution[] getDistributionArray(double meanArray[], double volArray[])
    {
        AbstractDistribution dists[] = new AbstractDistribution[volArray.length];
        RandomEngine rand = new MersenneTwister();
        for(int i = 0; i < volArray.length; i++)
        {
            dists[i] = new Normal(meanArray[i], volArray[i], rand);
            dists[i] = new Normal(0.0D, 1.0D, rand);
        }

        return dists;
    }

    public static final AbstractDistribution[] getDistributionArray(int len)
    {
        AbstractDistribution dists[] = new AbstractDistribution[len];
        RandomEngine rand = new MersenneTwister();
        for(int i = 0; i < len; i++)
            dists[i] = new Normal(0.0D, 1.0D, rand);

        return dists;
    }

    public static final void randomize(AbstractDistribution dists[], double rands[])
    {
        for(int i = 0; i < dists.length; i++)
            rands[i] = dists[i].nextDouble();

    }

    public static final DoubleMatrix1D correlateRandoms(DoubleMatrix2D cholesky, double rands[])
    {
        DoubleMatrix1D uncorrRand = new DenseDoubleMatrix1D(rands);
        Algebra algebra = new Algebra();
        DoubleMatrix1D ret = algebra.mult(cholesky, uncorrRand);
        return ret;
    }

    public static DynamicBin1D[] getDynamicBins(int numberOfEntries)
    {
        DynamicBin1D dists[] = new DynamicBin1D[numberOfEntries];
        for(int i = 0; i < numberOfEntries; i++)
            dists[i] = new DynamicBin1D();

        return dists;
    }

    public static void fillBins(DoubleMatrix2D randomResults, DynamicBin1D bins[], DoubleArrayList lists[], Histogram histograms[])
    {
        double array[][] = randomResults.toArray();
        int m = array.length;
        int n = array[0].length;
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                lists[j].add(array[i][j]);
                histograms[j].fill(array[i][j]);
            }

        }

        for(int j = 0; j < n; j++)
            bins[j].addAllOf(lists[j]);

    }

    public static DoubleArrayList[] getDoubleArrayLists(int numberOfEntries)
    {
        DoubleArrayList dists[] = new DoubleArrayList[numberOfEntries];
        for(int i = 0; i < numberOfEntries; i++)
            dists[i] = new DoubleArrayList();

        return dists;
    }

    public static Histogram[] getHistograms(int numberOfEntries, String titles[])
    {
        Histogram dists[] = new Histogram[numberOfEntries];
        for(int i = 0; i < numberOfEntries; i++)
            dists[i] = new Histogram(titles[i]);

        return dists;
    }

    public static JASHist getHistogramGraph(Histogram hist)
    {
        JASHist plot = new JASHist();
        plot.setTitle("Monte Carlo Histo");
        Dimension dim = new Dimension(600, 300);
        plot.setPreferredSize(dim);
        plot.setMinimumSize(dim);
        plot.setBackground(Color.white);
        plot.setForegroundColor(Color.red);
        plot.setDataAreaColor(Color.white);
        plot.setForeground(Color.red);
        plot.addData(PartitionAdapter.create(hist.getPartition(), "Title")).show(true);
        return plot;
    }

    public static void computePaths(Matrix cammini, double spotPrices[])
    {
        double array[][] = cammini.getArray();
        int m = array.length;
        int n = array[0].length;
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
                array[i][j] = spotPrices[j] * Math.exp(array[i][j]);

        }

    }
}
