// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   NumericalRecipesSeries.java

package com.numhero.shared.finance.beans;

import com.numhero.shared.finance.date.TDay;

public class NumericalRecipesSeries
{

    public NumericalRecipesSeries()
    {
    }

    public float[] getData()
    {
        return data;
    }

    public void setData(float data[])
    {
        this.data = data;
    }

    public void setValue(int index, float data)
    {
        this.data[index] = data;
    }

    public void setDate(int index, TDay data)
    {
        dates[index] = data;
    }

    public float getValue(int index)
    {
        return data[index];
    }

    public TDay getDate(int index)
    {
        return dates[index];
    }

    public TDay[] getDates()
    {
        return dates;
    }

    public void setDates(TDay dates[])
    {
        this.dates = dates;
    }

    public int getSize()
    {
        return data.length - 1;
    }

    public double getLastValue()
    {
        return (double)getValue(data.length - 1);
    }

    float data[];
    TDay dates[];
}
