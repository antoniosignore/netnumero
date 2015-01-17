// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   GraphFactory.java

package com.dtmc.server.analytics.graphics;


// Referenced classes of package com.dtmc.server.analytics.graphics:
//            CandlestickGraph, TimeSerieGraph, XYGraph, LineGraph, 
//            FinGraph

public class GraphFactory
{

    private GraphFactory()
    {
    }

    public static GraphFactory getInstance()
    {
        return instance;
    }

    public FinGraph newGraph(String type, int w, int h, int weight)
    {
        if(type.equalsIgnoreCase("daily"))
            return new CandlestickGraph(w, h, weight);
        if(type.equalsIgnoreCase("timeserie"))
            return new TimeSerieGraph(w, h, weight);
        if(type.equalsIgnoreCase("XY"))
            return new XYGraph(w, h, weight, false);
        if(type.equalsIgnoreCase("XYArea"))
            return new XYGraph(w, h, weight, true);
        if(type.equalsIgnoreCase("Line"))
            return new LineGraph(w, h, weight);
        else
            return null;
    }

    private static final GraphFactory instance = new GraphFactory();

}
