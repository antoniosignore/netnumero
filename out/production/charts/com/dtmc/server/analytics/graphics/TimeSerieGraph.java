// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   TimeSerieGraph.java

package com.dtmc.server.analytics.graphics;

import java.text.SimpleDateFormat;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.*;
import org.jfree.chart.labels.XYToolTipGenerator;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StandardXYItemRenderer;
import org.jfree.chart.urls.StandardXYURLGenerator;
import org.jfree.chart.urls.XYURLGenerator;
import org.jfree.data.general.AbstractSeriesDataset;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;

// Referenced classes of package com.dtmc.server.analytics.graphics:
//            FinGraph

public class TimeSerieGraph extends FinGraph
{

    public TimeSerieGraph(int w, int h, int weight)
    {
        super(w, h, weight);
        datasetCollection = new TimeSeriesCollection();
        XLabel = "";
        YLabel = "";
        data = null;
    }

    public XYPlot getXYPlot()
    {
        return chart.getXYPlot();
    }

    public TimeSeriesCollection getDatasetCollection()
    {
        return datasetCollection;
    }

    public void setDatasetCollection(AbstractSeriesDataset datasetCollection)
    {
        this.datasetCollection = (TimeSeriesCollection)datasetCollection;
    }

    public void addDataset(TimeSeries timeserie)
    {
        datasetCollection.addSeries(timeserie);
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

    public XYDataset getData()
    {
        return data;
    }

    public void setData(XYDataset data)
    {
        this.data = data;
    }

    public JFreeChart createTimeSeriesChart(String title, String timeAxisLabel, String valueAxisLabel, XYDataset data, boolean legend, boolean tooltips, boolean urls)
    {
        this.data = data;
        setTitle(title);
        SegmentedTimeline segmentedTimeline = SegmentedTimeline.newMondayThroughFridayTimeline();
        ValueAxis timeAxis = new DateAxis(timeAxisLabel);
        NumberAxis valueAxis = new NumberAxis(valueAxisLabel);
        valueAxis.setAutoRangeIncludesZero(false);
        XYPlot plot = new XYPlot(data, timeAxis, valueAxis, null);
        XYToolTipGenerator toolTipGenerator = null;
        XYURLGenerator urlGenerator = null;
        if(urls)
            urlGenerator = new StandardXYURLGenerator();
        StandardXYItemRenderer s = new StandardXYItemRenderer(2, toolTipGenerator, urlGenerator);
        plot.setDomainCrosshairVisible(true);
        plot.setRangeCrosshairVisible(true);
        plot.getDomainAxis().setLowerMargin(0.0D);
        plot.getDomainAxis().setUpperMargin(0.0D);
        plot.setRenderer(s);
        DateAxis axis = (DateAxis)plot.getDomainAxis();
        axis.setTickUnit(new DateTickUnit(1, 1, new SimpleDateFormat("MMM-yy")));
        axis.setVerticalTickLabels(true);
        JFreeChart chart = new JFreeChart(title, JFreeChart.DEFAULT_TITLE_FONT, plot, legend);
        return chart;
    }

    public void createChart()
    {
        chart = createTimeSeriesChart(getTitle(), getXLabel(), getYLabel(), getDatasetCollection(), true, false, false);
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

    private static Log logger = LogFactory.getLog(com/dtmc/server/analytics/graphics/TimeSerieGraph);
    TimeSeriesCollection datasetCollection;
    protected String XLabel;
    protected String YLabel;
    protected JFreeChart chart;
    protected XYDataset data;
    public static final boolean debug = false;

}
