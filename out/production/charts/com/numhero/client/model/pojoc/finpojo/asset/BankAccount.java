// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   BankAccount.java

package com.numhero.client.model.pojoc.finpojo.asset;

import java.io.PrintStream;

// Referenced classes of package com.numhero.client.model.pojoc.finpojo.asset:
//            Asset

public abstract class BankAccount extends Asset
{

    public BankAccount(String Name, double fInterestRate)
    {
        super(Name);
        this.fInterestRate = fInterestRate;
    }

    public void setInterestRate(double ir)
    {
        fInterestRate = ir;
    }

    public double getInterestRate()
    {
        return fInterestRate;
    }

    public double getExpectedReturn(int Option)
    {
        return Math.exp(Math.log(fInterestRate / 100D + 1.0D) / 365D);
    }

    public double variance()
    {
        return getVariance(0);
    }

    public double getVariance(int Option)
    {
        return 0.0D;
    }

    public double getCovariance(Asset asset)
    {
        return 0.0D;
    }

    public double getCorrelation(Asset asset)
    {
        return 0.0D;
    }

    public void print()
    {
        System.out.println(toString());
    }

    private double fInterestRate;
}
