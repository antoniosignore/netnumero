// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Asset.java

package com.numhero.client.model.pojoc.finpojo.asset;

import com.numhero.client.model.pojoc.finpojo.Instrument;
import java.io.Serializable;

public abstract class Asset extends Instrument
    implements Serializable
{

    public Asset()
    {
    }

    public Asset(String name)
    {
        super(name);
    }

    public double modelPrice(int model)
    {
        return spot();
    }

    public boolean isEqual(Asset obj)
    {
        return getName().equalsIgnoreCase(obj.getName());
    }

    public double getBeta(Asset index)
    {
        return getCovariance(index) / index.variance();
    }

    public double getExcess(Asset index, double interestRate)
    {
        return interestRate + getBeta(index) * ((Math.pow(index.expectedReturn(), 365D) - 1.0D) * 100D - interestRate);
    }

    public double getSharpeIndex(double interestRate)
    {
        return ((Math.pow(expectedReturn(), 365D) - 1.0D) * 100D - interestRate) / standardDeviation();
    }

    public double getTreynorIndex(Asset index, double interestRate)
    {
        return ((Math.pow(expectedReturn(), 365D) - 1.0D) * 100D - interestRate) / getBeta(index);
    }
}
