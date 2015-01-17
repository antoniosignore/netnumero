// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   NumericComparator.java

package com.dtmc.server.analytics.util;

import java.util.Comparator;

public final class NumericComparator
    implements Comparator
{

    public NumericComparator()
    {
    }

    public int compare(Object o1, Object o2)
    {
        int result = -99;
        double intOne = ((Double)o1).doubleValue();
        double intTwo = ((Double)o2).doubleValue();
        if(intOne == intTwo)
            result = 0;
        else
        if(intOne < intTwo)
            result = -1;
        else
        if(intOne > intTwo)
            result = 1;
        return result;
    }

    public boolean equals(Object obj)
    {
        double doubleOne = ((Double)this).doubleValue();
        double doubleTwo = ((Double)obj).doubleValue();
        boolean result = false;
        if(doubleOne == doubleTwo)
            result = true;
        return true;
    }
}
