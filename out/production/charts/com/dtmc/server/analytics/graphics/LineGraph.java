// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   LineGraph.java

package com.dtmc.server.analytics.graphics;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.time.TimeSeriesCollection;

// Referenced classes of package com.dtmc.server.analytics.graphics:
//            FinGraph

public class LineGraph extends FinGraph
{

    public LineGraph(int w, int h, int weight)
    {
        super(w, h, weight);
        dataset = null;
        XLabel = "Time";
        YLabel = "Value";
    }

    public XYPlot getXYPlot()
    {
        return chart.getXYPlot();
    }

    public TimeSeriesCollection getDatasetCollection()
    {
        return null;
    }

    public CategoryDataset getDataset()
    {
        return dataset;
    }

    public void setDataset(CategoryDataset dataset)
    {
        this.dataset = dataset;
    }

    public String getXLabel()
    {
        return XLabel;
    }

    public void setXLabel(String XLabel)
    {
        this.XLabel = XLabel;
    }

    public String getYLabel()
    {
        return YLabel;
    }

    public void setYLabel(String YLabel)
    {
        this.YLabel = YLabel;
    }

    public JFreeChart getChart()
    {
        return chart;
    }

    public void setChart(JFreeChart chart)
    {
        this.chart = chart;
    }

    public void createChart()
    {
        chart = ChartFactory.createLineChart(getTitle(), getXLabel(), getYLabel(), getDataset(), PlotOrientation.VERTICAL, true, true, false);
    }

    public void generateImage()
    {
        if(chart == null)
            createChart();
        if(chart != null)
        {
            chart.getXYPlot().setOrientation(PlotOrientation.VERTICAL);
            image = chart.createBufferedImage(width, height);
        }
    }

    CategoryDataset dataset;
    protected String XLabel;
    protected String YLabel;
    protected JFreeChart chart;
}
