// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Stock.java

package com.numhero.client.model.pojoc.finpojo.asset;

import com.numhero.shared.data.*;
import com.numhero.shared.pojoc.SearchablePojo;
import java.io.Serializable;
import java.util.Date;

// Referenced classes of package com.numhero.client.model.pojoc.finpojo.asset:
//            Asset

public class Stock extends Asset
    implements Serializable
{

    public Stock()
    {
        dividendArray = null;
        splitArray = null;
    }

    public Stock(String name)
    {
        super(name);
        dividendArray = null;
        splitArray = null;
    }

    public DividendArray getDividendArray()
    {
        return dividendArray;
    }

    public void setDividendArray(DividendArray Array)
    {
        dividendArray = Array;
    }

    public void addDividend(Dividend dividend)
    {
        if(dividendArray == null)
            dividendArray = new DividendArray();
        dividendArray.insert(dividend);
    }

    public void addDividend(Date date, double dividend)
    {
        if(dividendArray == null)
            dividendArray = new DividendArray();
        dividendArray.insert(date, dividend);
    }

    public Dividend getDividend(Date date)
    {
        if(dividendArray != null)
            return dividendArray.getDividend(date);
        else
            return null;
    }

    public SplitArray splitArray()
    {
        return splitArray;
    }

    public void setSplitArray(SplitArray array)
    {
        splitArray = array;
    }

    public void addSplit(Split split)
    {
        if(splitArray == null)
            splitArray = new SplitArray();
        splitArray.insert(split);
    }

    public void addSplit(Date date, double split)
    {
        if(splitArray == null)
            splitArray = new SplitArray();
        splitArray.insert(date, split);
    }

    public Split getSplit(Date date)
    {
        if(splitArray != null)
            return splitArray.getSplit(date);
        else
            return null;
    }

    public Split getSplit(int i)
    {
        if(splitArray != null)
            return splitArray.getSplit(i);
        else
            return null;
    }

    public String getKind()
    {
        return null;
    }

    public SearchablePojo clone()
    {
        return null;
    }

    public volatile Object clone()
        throws CloneNotSupportedException
    {
        return clone();
    }

    DividendArray dividendArray;
    SplitArray splitArray;
}
