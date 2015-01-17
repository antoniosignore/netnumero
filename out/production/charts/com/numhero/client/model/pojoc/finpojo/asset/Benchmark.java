// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Benchmark.java

package com.numhero.client.model.pojoc.finpojo.asset;

import com.numhero.shared.pojoc.SearchablePojo;
import java.util.ArrayList;

// Referenced classes of package com.numhero.client.model.pojoc.finpojo.asset:
//            Asset

public class Benchmark extends Asset
{

    public Benchmark(String Name)
    {
        super(Name);
        assetlist = null;
    }

    public ArrayList getAssetlist()
    {
        return assetlist;
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

    private ArrayList assetlist;
}
