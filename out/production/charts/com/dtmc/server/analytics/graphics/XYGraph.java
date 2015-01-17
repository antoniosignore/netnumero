// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   XYGraph.java

package com.dtmc.server.analytics.graphics;

import java.awt.Color;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYAreaRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYSeriesCollection;

// Referenced classes of package com.dtmc.server.analytics.graphics:
//            FinGraph

public class XYGraph extends FinGraph
{

    public XYGraph(int w, int h, int weight, boolean b)
    {
        super(w, h, weight);
        dataset = new XYSeriesCollection();
        XLabel = "Time";
        YLabel = "Value";
        areachart = false;
        areachart = b;
    }

    public XYPlot getXYPlot()
    {
        XYLineAndShapeRenderer lineShapeRenderer = new XYLineAndShapeRenderer();
        lineShapeRenderer.setPaint(Color.black);
        chart.getXYPlot().setRenderer(lineShapeRenderer);
        return chart.getXYPlot();
    }

    public TimeSeriesCollection getDatasetCollection()
    {
        return null;
    }

    public XYSeriesCollection getDataset()
    {
        return dataset;
    }

    public void setDataset(XYSeriesCollection dataset)
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
        chart = ChartFactory.createXYLineChart(getTitle(), getXLabel(), getYLabel(), getDataset(), PlotOrientation.VERTICAL, true, false, false);
        chart.setBackgroundPaint(Color.white);
        XYPlot plot = (XYPlot)chart.getPlot();
        XYLineAndShapeRenderer lineShapeRenderer = new XYLineAndShapeRenderer();
        lineShapeRenderer.setPaint(Color.black);
        chart.getXYPlot().setRenderer(lineShapeRenderer);
        plot.setBackgroundPaint(Color.white);
        if(areachart)
            plot.setRenderer(new XYAreaRenderer(4, null, null));
        NumberAxis axis = (NumberAxis)plot.getRangeAxis();
        axis.setAutoRangeIncludesZero(false);
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

    XYSeriesCollection dataset;
    protected String XLabel;
    protected String YLabel;
    protected JFreeChart chart;
    protected boolean areachart;
}
