// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   EigenAnalysis.java

package com.numhero.shared.finance.ssa;

import com.numhero.shared.finance.matrix.EigenvalueDecomposition;
import com.numhero.shared.finance.matrix.Matrix;
import com.numhero.shared.finance.utils.Util;

public class EigenAnalysis
{

    public EigenAnalysis(float s[])
    {
        pcaMatrix = null;
        X = null;
        Xt = null;
        S = null;
        eigen = null;
        lambda = null;
        E = null;
        serie = s;
        serieLength = Util.size(s);
        Nt = serieLength;
        m = Nt / 4;
        N = (Nt - m) + 1;
        X = new Matrix(N, m);
        for(int i = 0; i < N; i++)
        {
            for(int k = 0; k < m; k++)
                X.set(i, k, serie[i + k + 1]);

        }

        Xt = X.transpose();
        X = X.times(1.0D / Math.sqrt(N));
        Xt = Xt.times(1.0D / Math.sqrt(N));
        S = Xt.times(X);
        eigen = S.eig();
        lambda = eigen.getD();
        E = eigen.getV();
        eigenvalues = eigen.getRealEigenvalues();
        double pca = 0.0D;
        pcaMatrix = new Matrix(m, N);
        for(int t = 0; t < m; t++)
        {
            for(int i = 0; i < N; i++)
            {
                pca = 0.0D;
                for(int j = 0; j < m; j++)
                {
                    double dummy = serie[i + j + 1];
                    pca += dummy * E.get(j, t);
                }

                pcaMatrix.set(t, i, pca);
            }

        }

    }

    private float[] getEigenComponent(Matrix pcaMatrix, Matrix E, int n)
    {
        float component[] = Util.vector(1, serieLength);
        float conv = 0.0F;
        for(int i = 0; i < N; i++)
        {
            for(int j = 0; j < m; j++)
            {
                if(i != 0)
                    j = m - 1;
                conv = 0.0F;
                conv = (float)((double)conv + pcaMatrix.get(n, i) * E.get(j, n));
                component[i + j + 1] = conv;
            }

        }

        return component;
    }

    public int getNt()
    {
        return Nt;
    }

    public void setNt(int nt)
    {
        Nt = nt;
    }

    public int getM()
    {
        return m;
    }

    public void setM(int m)
    {
        this.m = m;
    }

    public int getN()
    {
        return N;
    }

    public void setN(int n)
    {
        N = n;
    }

    public int getSerieLength()
    {
        return serieLength;
    }

    public void setSerieLength(int serieLength)
    {
        this.serieLength = serieLength;
    }

    public Matrix getPcaMatrix()
    {
        return pcaMatrix;
    }

    public void setPcaMatrix(Matrix pcaMatrix)
    {
        this.pcaMatrix = pcaMatrix;
    }

    public Matrix getX()
    {
        return X;
    }

    public void setX(Matrix x)
    {
        X = x;
    }

    public Matrix getXt()
    {
        return Xt;
    }

    public void setXt(Matrix xt)
    {
        Xt = xt;
    }

    public Matrix getS()
    {
        return S;
    }

    public void setS(Matrix s)
    {
        S = s;
    }

    public EigenvalueDecomposition getEigen()
    {
        return eigen;
    }

    public void setEigen(EigenvalueDecomposition eigen)
    {
        this.eigen = eigen;
    }

    public Matrix getLambda()
    {
        return lambda;
    }

    public void setLambda(Matrix LAMBDA)
    {
        lambda = LAMBDA;
    }

    public Matrix getE()
    {
        return E;
    }

    public void setE(Matrix e)
    {
        E = e;
    }

    public double[] getEigenvalues()
    {
        return eigenvalues;
    }

    public void setEigenvalues(double eigenvalues[])
    {
        this.eigenvalues = eigenvalues;
    }

    public float[] getEigenComponent(int index)
    {
        return getEigenComponent(getPcaMatrix(), getE(), getM() - index);
    }

    private int Nt;
    private int m;
    private int N;
    private int serieLength;
    private final float serie[];
    private Matrix pcaMatrix;
    private Matrix X;
    private Matrix Xt;
    private Matrix S;
    private EigenvalueDecomposition eigen;
    private Matrix lambda;
    private Matrix E;
    private double eigenvalues[];
}
