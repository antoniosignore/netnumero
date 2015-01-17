// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   GraphicsUtils.java

package com.dtmc.server.analytics.util;

import com.dtmc.server.analytics.graphics.CircleDrawer;
import com.dtmc.server.analytics.graphics.FinGraph;
import com.dtmc.server.analytics.graphics.GifMaker;
import com.dtmc.server.analytics.graphics.GraphFactory;
import com.dtmc.server.analytics.graphics.TimeSerieGraph;
import com.dtmc.server.analytics.graphics.XYGraph;
import com.numhero.shared.data.Transaction;
import com.numhero.shared.data.TransactionSeries;
import com.numhero.shared.finance.date.TDay;
import jas.util.encoder.GifEncoder;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.PixelGrabber;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Vector;
import javax.swing.ImageIcon;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.annotations.XYAnnotation;
import org.jfree.chart.annotations.XYDrawableAnnotation;
import org.jfree.chart.annotations.XYPointerAnnotation;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CombinedDomainXYPlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StandardXYItemRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.TextAnchor;

// Referenced classes of package com.dtmc.server.analytics.util:
//            ColorUtils, Util

public class GraphicsUtils
{

    public GraphicsUtils()
    {
    }

    public static boolean hasAlpha(Image image)
    {
        if(image instanceof BufferedImage)
        {
            BufferedImage bimage = (BufferedImage)image;
            return bimage.getColorModel().hasAlpha();
        }
        PixelGrabber pg = new PixelGrabber(image, 0, 0, 1, 1, false);
        try
        {
            pg.grabPixels();
        }
        catch(InterruptedException e) { }
        ColorModel cm = pg.getColorModel();
        return cm.hasAlpha();
    }

    public static Image createImage(String url)
    {
        Toolkit tk = Toolkit.getDefaultToolkit();
        return tk.createImage(url);
    }

    public static BufferedImage toBufferedImage(Image image)
    {
        if(image instanceof BufferedImage)
            return (BufferedImage)image;
        image = (new ImageIcon(image)).getImage();
        boolean hasAlpha = hasAlpha(image);
        BufferedImage bimage = null;
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        try
        {
            int transparency = 1;
            if(hasAlpha)
                transparency = 2;
            GraphicsDevice gs = ge.getDefaultScreenDevice();
            GraphicsConfiguration gc = gs.getDefaultConfiguration();
            bimage = gc.createCompatibleImage(image.getWidth(null), image.getHeight(null), transparency);
        }
        catch(HeadlessException e) { }
        if(bimage == null)
        {
            int type = 1;
            if(hasAlpha)
                type = 2;
            bimage = new BufferedImage(image.getWidth(null), image.getHeight(null), type);
        }
        Graphics g = bimage.createGraphics();
        g.drawImage(image, 0, 0, null);
        g.dispose();
        return bimage;
    }

    public static byte[] encodeGif(Image img)
        throws IOException
    {
        BufferedImage image = toBufferedImage(img);
        BufferedImage indexedImage = convertImage(image, 13);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        GifEncoder enc = new GifEncoder(indexedImage, out);
        enc.encode();
        return out.toByteArray();
    }

    public static BufferedImage convertImage(BufferedImage source, int type)
    {
        int w = source.getWidth();
        int h = source.getHeight();
        BufferedImage target = new BufferedImage(w, h, type);
        Graphics2D g = target.createGraphics();
        g.drawRenderedImage(source, null);
        g.dispose();
        return target;
    }

    public static byte[] toByteArray(Image img)
        throws InterruptedException
    {
        int imgW = img.getWidth(null);
        int imgH = img.getHeight(null);
        int dat32[] = new int[imgW * imgH];
        PixelGrabber grab = new PixelGrabber(img, 0, 0, imgW, imgH, dat32, 0, imgW);
        grab.grabPixels();
        byte tmp[] = new byte[dat32.length];
        for(int i = 0; i < tmp.length; i++)
            tmp[i] = (byte)dat32[i];

        return tmp;
    }

    public static JFreeChart generateTopChart(String title, CombinedDomainXYPlot multiPlot, String subtitleStr)
    {
        JFreeChart topchart = new JFreeChart(title, new Font("Comic Sans MS", 0, 12), multiPlot, true);
        TextTitle subtitle = new TextTitle(subtitleStr, new Font("Comic Sans MS", 0, 10));
        topchart.addSubtitle(subtitle);
        topchart.setBackgroundPaint(ColorUtils.white);
        return topchart;
    }

    public static JFreeChart generateTopChart(String title, CombinedDomainXYPlot multiPlot)
    {
        JFreeChart topchart = new JFreeChart(title, JFreeChart.DEFAULT_TITLE_FONT, multiPlot, true);
        return topchart;
    }

    public static JFreeChart generateTAGraphs(String title, Vector v)
    {
        String domain = "combined.vertical.domain";
        ValueAxis timeAxis = new DateAxis(domain);
        CombinedDomainXYPlot multiPlot = new CombinedDomainXYPlot(timeAxis);
        for(int i = 0; i < v.size(); i++)
        {
            FinGraph graph = (FinGraph)v.elementAt(i);
            XYPlot subplot1 = new XYPlot(graph.getDatasetCollection(), null, new NumberAxis(graph.getTitle()), new StandardXYItemRenderer());
            NumberAxis range1 = (NumberAxis)subplot1.getRangeAxis();
            range1.setTickLabelFont(new Font("Comic Sans MS", 0, 7));
            range1.setLabelFont(new Font("Comic Sans MS", 0, 8));
            range1.setAutoRangeIncludesZero(false);
            multiPlot.add(subplot1, graph.getWeight());
        }

        return generateTopChart(title, multiPlot);
    }

    public static JFreeChart generateXYMultiplotGraphs(String title, Vector v)
    {
        String domain = "combined.vertical.domain";
        NumberAxis numberAxis = new NumberAxis(domain);
        CombinedDomainXYPlot multiPlot = new CombinedDomainXYPlot(numberAxis);
        for(int i = 0; i < v.size(); i++)
        {
            FinGraph graph = (FinGraph)v.elementAt(i);
            XYDataset dataset = null;
            if(graph instanceof XYGraph)
                dataset = ((XYGraph)graph).getDataset();
            if(graph instanceof TimeSerieGraph)
                dataset = graph.getDatasetCollection();
            XYItemRenderer renderer = new StandardXYItemRenderer();
            renderer.setSeriesPaint(0, Color.black);
            renderer.setSeriesStroke(0, new BasicStroke(1.0F, 1, 1, 1.0F, null, 0.0F));
            XYPlot subplot1 = new XYPlot(dataset, null, new NumberAxis(graph.getTitle()), new StandardXYItemRenderer());
            subplot1.setRenderer(renderer);
            subplot1.setForegroundAlpha(0.5F);
            subplot1.setDomainGridlinePaint(Color.black);
            subplot1.setRangeGridlinePaint(Color.black);
            subplot1.setDomainCrosshairVisible(true);
            subplot1.setDomainCrosshairLockedOnData(true);
            subplot1.setRangeCrosshairVisible(true);
            subplot1.setRangeCrosshairLockedOnData(true);
            NumberAxis range1 = (NumberAxis)subplot1.getRangeAxis();
            range1.setTickLabelFont(new Font("Comic Sans MS", 0, 7));
            range1.setLabelFont(new Font("Comic Sans MS", 0, 8));
            range1.setAutoRangeIncludesZero(false);
            multiPlot.add(subplot1, graph.getWeight());
        }

        return generateTopChart(title, multiPlot);
    }

    public static JFreeChart generateTimeSeriesMultiplotGraphs(String title, Vector v)
    {
        String domain = "combined.vertical.domain";
        DateAxis domainAxis = new DateAxis("Date");
        CombinedDomainXYPlot multiPlot = new CombinedDomainXYPlot(domainAxis);
        for(int i = 0; i < v.size(); i++)
        {
            FinGraph graph = (FinGraph)v.elementAt(i);
            XYDataset dataset = null;
            if(graph instanceof XYGraph)
                dataset = ((XYGraph)graph).getDataset();
            if(graph instanceof TimeSerieGraph)
                dataset = graph.getDatasetCollection();
            XYItemRenderer renderer = new StandardXYItemRenderer();
            renderer.setSeriesPaint(0, Color.black);
            renderer.setSeriesStroke(0, new BasicStroke(1.0F, 1, 1, 1.0F, null, 0.0F));
            XYPlot subplot1 = new XYPlot(dataset, null, new NumberAxis(graph.getTitle()), new StandardXYItemRenderer());
            subplot1.setRenderer(renderer);
            subplot1.setForegroundAlpha(0.5F);
            subplot1.setDomainGridlinePaint(Color.black);
            subplot1.setRangeGridlinePaint(Color.black);
            subplot1.setDomainCrosshairVisible(true);
            subplot1.setDomainCrosshairLockedOnData(true);
            subplot1.setRangeCrosshairVisible(true);
            subplot1.setRangeCrosshairLockedOnData(true);
            NumberAxis range1 = (NumberAxis)subplot1.getRangeAxis();
            range1.setTickLabelFont(new Font("Comic Sans MS", 0, 7));
            range1.setLabelFont(new Font("Comic Sans MS", 0, 8));
            range1.setAutoRangeIncludesZero(false);
            multiPlot.add(subplot1, graph.getWeight());
        }

        return generateTopChart(title, multiPlot);
    }

    public static TimeSerieGraph mergeGraphs(TimeSerieGraph g1, TimeSerieGraph g2, int w, int h, int weight)
    {
        GraphFactory graphfactory = GraphFactory.getInstance();
        TimeSerieGraph graph = (TimeSerieGraph)graphfactory.newGraph("timeserie", w, h, weight);
        java.util.List l = g1.getDatasetCollection().getSeries();
        for(int i = 0; i < l.size(); i++)
            graph.getDatasetCollection().addSeries((TimeSeries)l.get(i));

        l = g2.getDatasetCollection().getSeries();
        for(int i = 0; i < l.size(); i++)
            graph.getDatasetCollection().addSeries((TimeSeries)l.get(i));

        graph.createChart();
        graph.getChart().setBorderVisible(false);
        graph.getChart().setBackgroundPaint(Color.white);
        graph.generateImage();
        return graph;
    }

    public static TimeSerieGraph mergeGraphs(String graphtitle, Vector graphs)
    {
        return mergeGraphs(graphtitle, graphs, 800, 600, 1);
    }

    public static TimeSerieGraph mergeGraphs(String graphtitle, Vector graphs, int w, int h, int weight)
    {
        GraphFactory graphfactory = GraphFactory.getInstance();
        TimeSerieGraph graph = (TimeSerieGraph)graphfactory.newGraph("timeserie", w, h, weight);
        graph.setTitle(graphtitle);
        for(int i = 0; i < graphs.size(); i++)
        {
            TimeSerieGraph timeSerieGraph = (TimeSerieGraph)graphs.elementAt(i);
            java.util.List l = timeSerieGraph.getDatasetCollection().getSeries();
            for(int ii = 0; ii < l.size(); ii++)
                graph.getDatasetCollection().addSeries((TimeSeries)l.get(ii));

        }

        graph.createChart();
        graph.getChart().setBorderVisible(false);
        graph.getChart().setBackgroundPaint(Color.white);
        graph.generateImage();
        return graph;
    }

    public static TimeSerieGraph mergeGraphsWithSignals(String graphtitle, Vector graphs, int w, int h, int weight, TransactionSeries tseries)
    {
        GraphFactory graphfactory = GraphFactory.getInstance();
        TimeSerieGraph graph = (TimeSerieGraph)graphfactory.newGraph("timeserie", w, h, weight);
        graph.setTitle(graphtitle);
        for(int i = 0; i < graphs.size(); i++)
        {
            TimeSerieGraph timeSerieGraph = (TimeSerieGraph)graphs.elementAt(i);
            if(timeSerieGraph == null)
                throw new IllegalArgumentException((new StringBuilder()).append("graph ").append(i).append(" cannot be is null").toString());
            java.util.List l = timeSerieGraph.getDatasetCollection().getSeries();
            for(int ii = 0; ii < l.size(); ii++)
                graph.getDatasetCollection().addSeries((TimeSeries)l.get(ii));

        }

        graph.createChart();
        for(int j = 0; j < tseries.getNTransactions(); j++)
        {
            Transaction t = tseries.getTransaction(j);
            addDateMarker(graph, t);
        }

        graph.getChart().setBorderVisible(false);
        graph.getChart().setBackgroundPaint(Color.white);
        graph.generateImage();
        return graph;
    }

    public static XYGraph mergeXYGraphs(String graphtitle, Vector graphs, int w, int h, int weight, Image background, TDay date, int type, 
            double value)
    {
        GraphFactory graphfactory = GraphFactory.getInstance();
        XYGraph graph = (XYGraph)graphfactory.newGraph("XY", w, h, weight);
        XYSeriesCollection dataset = new XYSeriesCollection();
        for(int i = 0; i < graphs.size(); i++)
        {
            XYGraph xyGraph = (XYGraph)graphs.elementAt(i);
            if(xyGraph == null)
                throw new IllegalArgumentException((new StringBuilder()).append("graph ").append(i).append(" cannot be is null").toString());
            java.util.List l = xyGraph.getDataset().getSeries();
            for(int j = 0; j < l.size(); j++)
            {
                XYSeries o = (XYSeries)l.get(j);
                dataset.addSeries(o);
            }

        }

        graph.setTitle(graphtitle);
        graph.setDataset(dataset);
        graph.createChart();
        graph.getChart().setBorderVisible(false);
        graph.getChart().setBackgroundPaint(Color.white);
        XYPlot plot = graph.getXYPlot();
        plot.setDomainCrosshairVisible(true);
        plot.setDomainCrosshairLockedOnData(true);
        plot.setRangeCrosshairVisible(true);
        plot.setRangeCrosshairLockedOnData(true);
        addDateMarker(graph, date, type, value);
        if(background != null)
        {
            plot.setBackgroundPaint(null);
            plot.setBackgroundImage(background);
        }
        graph.generateImage();
        return graph;
    }

    public static void toGIF(Image image, String filename)
        throws IOException
    {
        if(image == null)
            throw new IllegalArgumentException("image cannot be null");
        if(filename == null)
        {
            throw new IllegalArgumentException("filename cannot be null");
        } else
        {
            FileOutputStream gif_file = new FileOutputStream(filename);
            GifMaker gif_encoder = new GifMaker();
            gif_encoder.setImage(image);
            gif_encoder.setOutputStream(gif_file);
            gif_encoder.write();
            gif_file.flush();
            gif_file.close();
            return;
        }
    }

    public static void toGIF(Image image, OutputStream out)
        throws IOException
    {
        if(image == null)
            throw new IllegalArgumentException("image cannot be null");
        if(out == null)
        {
            throw new IllegalArgumentException("filename cannot be null");
        } else
        {
            GifMaker gif_encoder = new GifMaker();
            gif_encoder.setImage(image);
            gif_encoder.setOutputStream(out);
            gif_encoder.write();
            out.flush();
            return;
        }
    }

    public static void toPGN(Image image, OutputStream out)
        throws IOException
    {
        if(image == null)
            throw new IllegalArgumentException("image cannot be null");
        if(out == null)
        {
            throw new IllegalArgumentException("filename cannot be null");
        } else
        {
            GifMaker gif_encoder = new GifMaker();
            gif_encoder.setImage(image);
            gif_encoder.setOutputStream(out);
            gif_encoder.write();
            out.flush();
            return;
        }
    }

    public static Image generateChart(JFreeChart chart, int width, int height)
    {
        chart.getXYPlot().setOrientation(PlotOrientation.VERTICAL);
        return chart.createBufferedImage(width, height);
    }

    public static FinGraph getXYGraph(String name, float series[], int w, int h, int weight, boolean isAreachart, boolean isLogScale, double x, double y, String label)
    {
        return getXYGraph(name, series, w, h, weight, isAreachart, isLogScale, null, x, y, label);
    }

    public static FinGraph getXYGraph(String name, float series[], int w, int h, int weight, boolean isAreachart, boolean isLogScale, Image background, 
            double x, double y, String label, int size)
    {
        float copiedserie[] = Util.vector(1, size);
        for(int i = 1; i <= size; i++)
            copiedserie[i] = series[i];

        GraphFactory graphfactory = GraphFactory.getInstance();
        XYGraph graph = null;
        if(!isAreachart)
            graph = (XYGraph)graphfactory.newGraph("XY", w, h, weight);
        else
            graph = (XYGraph)graphfactory.newGraph("XYArea", w, h, weight);
        XYSeriesCollection dataset = getXYDataset(name, copiedserie);
        graph.setDataset(dataset);
        graph.setTitle(name);
        graph.createChart();
        graph.getChart().setBorderVisible(false);
        XYPlot plot = graph.getXYPlot();
        plot.setDomainCrosshairVisible(true);
        plot.setDomainCrosshairLockedOnData(true);
        plot.setRangeCrosshairVisible(true);
        plot.setRangeCrosshairLockedOnData(true);
        plot.getRenderer().setSeriesPaint(0, Color.black);
        if(label != null)
            addDateMarker(graph, x, y, label);
        graph.generateImage();
        return graph;
    }

    public static FinGraph getXYGraph(String name, float series[], int w, int h, int weight, boolean isAreachart, boolean isLogScale, Image background, 
            double x, double y, String label)
    {
        GraphFactory graphfactory = GraphFactory.getInstance();
        XYGraph graph = null;
        if(!isAreachart)
            graph = (XYGraph)graphfactory.newGraph("XY", w, h, weight);
        else
            graph = (XYGraph)graphfactory.newGraph("XYArea", w, h, weight);
        XYSeriesCollection dataset = getXYDataset(name, series);
        graph.setDataset(dataset);
        graph.setTitle(name);
        graph.createChart();
        graph.getChart().setBorderVisible(false);
        Plot plot = graph.getXYPlot();
        if(background != null)
        {
            plot.setBackgroundPaint(null);
            plot.setBackgroundImage(background);
        }
        if(label != null)
            addDateMarker(graph, x, y, label);
        graph.generateImage();
        return graph;
    }

    public static FinGraph getXYGraph(String name, int axis[], float series[], int w, int h, int weight, boolean isAreachart, boolean isLogScale)
    {
        return getXYGraph(name, axis, series, w, h, weight, isAreachart, isLogScale, null);
    }

    public static FinGraph getXYGraph(String name, int axis[], float series[], int w, int h, int weight, boolean isAreachart, boolean isLogScale, 
            Image background)
    {
        GraphFactory graphfactory = GraphFactory.getInstance();
        XYGraph graph = null;
        if(!isAreachart)
            graph = (XYGraph)graphfactory.newGraph("XY", w, h, weight);
        else
            graph = (XYGraph)graphfactory.newGraph("XYArea", w, h, weight);
        XYSeriesCollection dataset = getXYDataset(name, axis, series);
        graph.setTitle(name);
        graph.setDataset(dataset);
        graph.createChart();
        graph.getChart().setBorderVisible(false);
        if(background != null)
        {
            Plot plot = graph.getXYPlot();
            plot.setBackgroundPaint(null);
            plot.setBackgroundImage(background);
        }
        graph.generateImage();
        return graph;
    }

    private static XYSeriesCollection getXYDataset(String name, float data[])
    {
        XYSeries series = new XYSeries(name);
        for(int i = 1; i <= data.length - 1; i++)
            series.add(i, data[i]);

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series);
        return dataset;
    }

    public static XYSeriesCollection getXYDataset(String name, int axis[], float data[])
    {
        XYSeries series = new XYSeries(name);
        for(int i = 1; i <= Util.size(data); i++)
            series.add(axis[i], data[i]);

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series);
        return dataset;
    }

    public static FinGraph createGraph(String name, float series[], int w, int h, int weight, boolean isLogScale)
    {
        return createGraph(name, series, w, h, weight, false, null, 0.0D, 0.0D, null);
    }

    public static FinGraph createGraph(String name, float series[], int w, int h, int weight, boolean isLogScale, int size)
    {
        return createGraph(name, series, w, h, weight, false, null, 0.0D, 0.0D, null, size);
    }

    public static FinGraph createGraph(String name, float series[], int w, int h, int weight, boolean isLogScale, double x, 
            double y, String label)
    {
        return createGraph(name, series, w, h, weight, false, null, x, y, label);
    }

    public static FinGraph createGraph(String name, float series[], int w, int h, int weight, boolean isLogScale, Image background, double x, double y, String label, int size)
    {
        return getXYGraph(name, series, w, h, weight, false, isLogScale, background, x, y, label, size);
    }

    public static FinGraph createGraph(String name, float series[], int w, int h, int weight, boolean isLogScale, Image background, double x, double y, String label)
    {
        return getXYGraph(name, series, w, h, weight, false, isLogScale, background, x, y, label);
    }

    public static FinGraph createGraph(String name, int axis[], float series[], int size, int w, int h, int weight, boolean isLogScale)
    {
        float copiedserie[] = Util.vector(1, size);
        for(int i = 1; i <= size; i++)
            copiedserie[i] = series[i];

        return getXYGraph(name, axis, copiedserie, w, h, weight, false, isLogScale);
    }

    public static void addDateMarker(FinGraph graph, Transaction transaction)
    {
        XYPlot plot = graph.getXYPlot();
        TDay d = transaction.getDate();
        Day day = new Day(d.getDate(), d.getMonth() + 1, d.getYear());
        double millis = day.getFirstMillisecond();
        CircleDrawer cd = null;
        XYAnnotation note = null;
        int type = transaction.getAction();
        XYPointerAnnotation pointer = null;
        if(type == 8)
        {
            cd = new CircleDrawer(Color.blue, new BasicStroke(1.0F), null);
            note = new XYDrawableAnnotation(millis, transaction.getPrice(), 11D, 11D, cd);
            pointer = new XYPointerAnnotation(d.toString(), millis, transaction.getPrice(), 1.5707963267948966D);
            pointer.setTextAnchor(TextAnchor.HALF_ASCENT_CENTER);
            pointer.setPaint(Color.blue);
        } else
        if(type == 9)
        {
            cd = new CircleDrawer(Color.blue, new BasicStroke(1.0F), null);
            note = new XYDrawableAnnotation(millis, transaction.getPrice(), 11D, 11D, cd);
            pointer = new XYPointerAnnotation(d.toString(), millis, transaction.getPrice(), 1.5707963267948966D);
            pointer.setTextAnchor(TextAnchor.HALF_ASCENT_CENTER);
            pointer.setPaint(Color.blue);
        } else
        if(type == 6)
        {
            cd = new CircleDrawer(Color.red, new BasicStroke(1.0F), null);
            note = new XYDrawableAnnotation(millis, transaction.getPrice(), 11D, 11D, cd);
            pointer = new XYPointerAnnotation(d.toString(), millis, transaction.getPrice(), 4.7123889803846897D);
            pointer.setTextAnchor(TextAnchor.HALF_ASCENT_CENTER);
            pointer.setPaint(Color.red);
        } else
        if(type == 5)
        {
            cd = new CircleDrawer(Color.red, new BasicStroke(1.0F), null);
            note = new XYDrawableAnnotation(millis, transaction.getPrice(), 11D, 11D, cd);
            pointer = new XYPointerAnnotation(d.toString(), millis, transaction.getPrice(), 4.7123889803846897D);
            pointer.setTextAnchor(TextAnchor.HALF_ASCENT_CENTER);
            pointer.setPaint(Color.red);
        }
        plot.addAnnotation(note);
        if(!$assertionsDisabled && pointer == null)
        {
            throw new AssertionError();
        } else
        {
            pointer.setBaseRadius(35D);
            pointer.setTipRadius(10D);
            pointer.setFont(new Font("Comic Sans MS", 1, 9));
            plot.addAnnotation(pointer);
            return;
        }
    }

    public static void addDateMarker(FinGraph graph, TDay date, int type, double value)
    {
        System.out.println("GraphicsUtils.addDateMarker");
        System.out.println((new StringBuilder()).append("date.toString()] = ").append(date.toString()).toString());
        System.out.println((new StringBuilder()).append("value = ").append(value).toString());
        XYPlot plot = graph.getXYPlot();
        TDay d = date;
        Day day = new Day(d.getDate(), d.getMonth() + 1, d.getYear());
        double millis = day.getFirstMillisecond();
        CircleDrawer cd = null;
        XYAnnotation note = null;
        XYPointerAnnotation pointer = null;
        if(type == 8)
        {
            cd = new CircleDrawer(Color.blue, new BasicStroke(1.0F), null);
            note = new XYDrawableAnnotation(millis, value, 11D, 11D, cd);
            pointer = new XYPointerAnnotation(d.toString(), millis, value, 1.5707963267948966D);
            pointer.setTextAnchor(TextAnchor.HALF_ASCENT_CENTER);
            pointer.setPaint(Color.blue);
        } else
        if(type == 9)
        {
            cd = new CircleDrawer(Color.blue, new BasicStroke(1.0F), null);
            note = new XYDrawableAnnotation(millis, value, 11D, 11D, cd);
            pointer = new XYPointerAnnotation(d.toString(), millis, value, 1.5707963267948966D);
            pointer.setTextAnchor(TextAnchor.HALF_ASCENT_CENTER);
            pointer.setPaint(Color.blue);
        } else
        if(type == 6)
        {
            cd = new CircleDrawer(Color.red, new BasicStroke(1.0F), null);
            note = new XYDrawableAnnotation(millis, value, 11D, 11D, cd);
            pointer = new XYPointerAnnotation(d.toString(), millis, value, 4.7123889803846897D);
            pointer.setTextAnchor(TextAnchor.HALF_ASCENT_CENTER);
            pointer.setPaint(Color.red);
        } else
        if(type == 5)
        {
            cd = new CircleDrawer(Color.red, new BasicStroke(1.0F), null);
            note = new XYDrawableAnnotation(millis, value, 11D, 11D, cd);
            pointer = new XYPointerAnnotation(d.toString(), millis, value, 4.7123889803846897D);
            pointer.setTextAnchor(TextAnchor.HALF_ASCENT_CENTER);
            pointer.setPaint(Color.red);
        }
        plot.addAnnotation(note);
        if(!$assertionsDisabled && pointer == null)
        {
            throw new AssertionError();
        } else
        {
            pointer.setBaseRadius(35D);
            pointer.setTipRadius(10D);
            pointer.setFont(new Font("Comic Sans MS", 1, 9));
            plot.addAnnotation(pointer);
            return;
        }
    }

    public static void addDateMarker(FinGraph graph, double x, double y, String label)
    {
        XYPlot plot = graph.getXYPlot();
        CircleDrawer cd = null;
        XYAnnotation note = null;
        XYPointerAnnotation pointer = null;
        cd = new CircleDrawer(Color.blue, new BasicStroke(1.0F), null);
        pointer = new XYPointerAnnotation(label, x, y, 1.5707963267948966D);
        pointer.setTextAnchor(TextAnchor.HALF_ASCENT_CENTER);
        pointer.setPaint(Color.blue);
        plot.addAnnotation(pointer);
        if(!$assertionsDisabled && pointer == null)
        {
            throw new AssertionError();
        } else
        {
            pointer.setBaseRadius(35D);
            pointer.setTipRadius(10D);
            pointer.setFont(new Font("Comic Sans MS", 1, 9));
            plot.addAnnotation(pointer);
            return;
        }
    }

    static final boolean $assertionsDisabled = !com/dtmc/server/analytics/util/GraphicsUtils.desiredAssertionStatus();

}
