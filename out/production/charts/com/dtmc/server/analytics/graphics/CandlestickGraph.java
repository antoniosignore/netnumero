// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   CandlestickGraph.java

package com.dtmc.server.analytics.graphics;

import com.dtmc.server.analytics.util.ColorUtils;
import java.awt.Color;
import java.awt.Font;
import java.text.SimpleDateFormat;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.*;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.CandlestickRenderer;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.OHLCDataset;

// Referenced classes of package com.dtmc.server.analytics.graphics:
//            FinGraph

public class CandlestickGraph extends FinGraph
{

    public CandlestickGraph(int w, int h, int weight)
    {
        super(w, h, weight);
        dataset = null;
        XLabel = "Time";
        YLabel = "Value";
    }

    public XYPlot getXYPlot()
    {
        return plot;
    }

    public TimeSeriesCollection getDatasetCollection()
    {
        return null;
    }

    public void setPlot(XYPlot plot)
    {
        this.plot = plot;
    }

    public OHLCDataset getDataset()
    {
        return dataset;
    }

    public void setDataset(OHLCDataset dataset)
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
        ValueAxis timeAxis = new DateAxis(XLabel);
        timeAxis.setAutoRange(true);
        timeAxis.setPositiveArrowVisible(true);
        timeAxis.setNegativeArrowVisible(true);
        NumberAxis valueAxis = new NumberAxis(YLabel);
        valueAxis.setAutoRangeIncludesZero(false);
        plot = new XYPlot(getDataset(), timeAxis, valueAxis, null);
        DateAxis axis = (DateAxis)plot.getDomainAxis();
        axis.setTickUnit(new DateTickUnit(1, 1, new SimpleDateFormat("MM-yy")));
        axis.setVerticalTickLabels(true);
        plot.setBackgroundPaint(ColorUtils.white);
        CandlestickRenderer candlestickRenderer = new CandlestickRenderer();
        candlestickRenderer.setDrawVolume(true);
        candlestickRenderer.setDownPaint(Color.black);
        candlestickRenderer.setUpPaint(Color.white);
        plot.setRenderer(candlestickRenderer);
        chart = new JFreeChart(title, new Font("Arial", 0, 12), plot, false);
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

    protected OHLCDataset dataset;
    protected String XLabel;
    protected String YLabel;
    protected JFreeChart chart;
    protected XYPlot plot;
}
