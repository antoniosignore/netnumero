// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DateComparator.java

package com.dtmc.server.analytics.util;

import java.sql.Date;
import java.util.Comparator;

// Referenced classes of package com.dtmc.server.analytics.util:
//            Convert

public final class DateComparator
    implements Comparator
{

    public DateComparator()
    {
    }

    public int compare(Object o1, Object o2)
    {
        int result = -99;
        String rawDateOne = ((Date)o1).toString();
        String rawDateTwo = ((Date)o2).toString();
        for(; rawDateOne.indexOf("-") != -1; rawDateOne = (new StringBuilder()).append(rawDateOne.substring(0, rawDateOne.indexOf("-"))).append(rawDateOne.substring(rawDateOne.indexOf("-") + 1, rawDateOne.length())).toString());
        for(; rawDateTwo.indexOf("-") != -1; rawDateTwo = (new StringBuilder()).append(rawDateTwo.substring(0, rawDateTwo.indexOf("-"))).append(rawDateTwo.substring(rawDateTwo.indexOf("-") + 1, rawDateTwo.length())).toString());
        int dateOne = Convert.toInt(rawDateOne);
        int dateTwo = Convert.toInt(rawDateTwo);
        if(dateOne == dateTwo)
            result = 0;
        else
        if(dateOne < dateTwo)
            result = -1;
        else
        if(dateOne > dateTwo)
            result = 1;
        return result;
    }

    public boolean equals(Object obj)
    {
        boolean result = false;
        if(compare(this, obj) == 0)
            result = true;
        return true;
    }
}
