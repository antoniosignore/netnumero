// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   TimeSeriesUtils.java

package com.dtmc.server.analytics.timeseries;

import com.dtmc.server.analytics.graphics.FinGraph;
import com.dtmc.server.analytics.graphics.GraphFactory;
import com.dtmc.server.analytics.graphics.TimeSerieGraph;
import com.dtmc.server.analytics.graphics.XYGraph;
import com.dtmc.server.analytics.util.GraphicsUtils;
import com.numhero.shared.data.TransactionSeries;
import com.numhero.shared.finance.date.TDay;
import com.numhero.shared.finance.matrix.Matrix;
import java.awt.Color;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.SegmentedTimeline;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class TimeSeriesUtils
{

    public TimeSeriesUtils()
    {
    }

    public static FinGraph getGraph(com.numhero.shared.finance.beans.TimeSeries serie, int w, int h, int weight, boolean isLogScale)
    {
        return getGraph(serie, 0, w, h, weight, isLogScale);
    }

    public static FinGraph getGraph(com.numhero.shared.finance.beans.TimeSeries serie, int w, int h, int weight)
    {
        return getGraph(serie, 0, w, h, weight, false);
    }

    public static FinGraph getGraph(com.numhero.shared.finance.beans.TimeSeries serie)
    {
        return getGraph(serie, 0, 800, 200, 1, false);
    }

    public static FinGraph getGraph(com.numhero.shared.finance.beans.TimeSeries serie, int RowCount, int w, int h, int weight, boolean isLogScale)
    {
        GraphFactory graphfactory = GraphFactory.getInstance();
        TimeSerieGraph graph = (TimeSerieGraph)graphfactory.newGraph("timeserie", w, h, weight);
        TimeSeriesCollection dataset = getDataset(serie, RowCount);
        graph.setDatasetCollection(dataset);
        graph.setTitle(serie.getName());
        graph.createChart();
        graph.getChart().setBorderVisible(false);
        graph.getChart().setBackgroundPaint(Color.white);
        graph.generateImage();
        return graph;
    }

    public static FinGraph getGraph(com.numhero.shared.finance.beans.TimeSeries serie, int RowCount, int w, int h, int weight, boolean isLogScale, TransactionSeries tseries)
    {
        GraphFactory graphfactory = GraphFactory.getInstance();
        TimeSerieGraph graph = (TimeSerieGraph)graphfactory.newGraph("timeserie", w, h, weight);
        TimeSeriesCollection dataset = getDataset(serie, RowCount);
        graph.setDatasetCollection(dataset);
        graph.setTitle(serie.getName());
        graph.createChart();
        graph.getChart().setBorderVisible(false);
        graph.getChart().setBackgroundPaint(Color.white);
        for(int j = 0; j < tseries.getNTransactions(); j++)
        {
            com.numhero.shared.data.Transaction t = tseries.getTransaction(j);
            GraphicsUtils.addDateMarker(graph, t);
        }

        graph.generateImage();
        return graph;
    }

    public static TimeSeriesCollection getDataset(com.numhero.shared.finance.beans.TimeSeries serie, int RowCount)
    {
        SegmentedTimeline timeline = SegmentedTimeline.newMondayThroughFridayTimeline();
        TimeSeries ts = new TimeSeries("time xyseries", org/jfree/data/time/Day);
        org.jfree.chart.axis.SegmentedTimeline.Segment segment = null;
        try
        {
            for(int i = serie.getFirstIndex(); i <= serie.getLastIndex(); i++)
            {
                double v = serie.data.get(RowCount, i);
                if(!Double.isNaN(v))
                {
                    TDay dt = serie.getDate(i);
                    ts.add(new Day(dt.getDate(), dt.getMonth() + 1, dt.getYear()), v);
                }
            }

        }
        catch(Exception e) { }
        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(ts);
        return dataset;
    }

    public static FinGraph getXYGraph(com.numhero.shared.finance.beans.TimeSeries serie, int w, int h, int weight, boolean isLogScale)
    {
        return getXYGraph(serie, 0, w, h, weight, isLogScale);
    }

    public static FinGraph getXYGraph(com.numhero.shared.finance.beans.TimeSeries serie, int w, int h, int weight)
    {
        return getXYGraph(serie, 0, w, h, weight, true);
    }

    public static FinGraph getXYGraph(com.numhero.shared.finance.beans.TimeSeries serie, int RowCount, int w, int h, int weight, boolean isLogScale)
    {
        GraphFactory graphfactory = GraphFactory.getInstance();
        XYGraph graph = (XYGraph)graphfactory.newGraph("XY", w, h, weight);
        XYSeriesCollection dataset = getXYDataset(serie, RowCount);
        graph.setDataset(dataset);
        graph.setTitle(serie.getName());
        graph.createChart();
        graph.getChart().setBorderVisible(false);
        graph.generateImage();
        return graph;
    }

    private static XYSeriesCollection getXYDataset(com.numhero.shared.finance.beans.TimeSeries serie, int RowCount)
    {
        XYSeries xyseries = new XYSeries(serie.getName());
        for(int i = serie.getFirstIndex(); i <= serie.getLastIndex(); i++)
        {
            double v = serie.data.get(RowCount, i);
            if(!Double.isNaN(v))
                xyseries.add(i, v);
        }

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(xyseries);
        return dataset;
    }
}
