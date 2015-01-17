// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   FinGraph.java

package com.dtmc.server.analytics.graphics;

import java.awt.Image;
import java.io.FileOutputStream;
import java.io.IOException;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.time.TimeSeriesCollection;

// Referenced classes of package com.dtmc.server.analytics.graphics:
//            GifMaker

public abstract class FinGraph
{

    public FinGraph(int width, int height, int weight)
    {
        image = null;
        title = "";
        offset = 0;
        this.width = width;
        this.height = height;
        this.weight = weight;
    }

    public int getOffset()
    {
        return offset;
    }

    public void setOffset(int offset)
    {
        this.offset = offset;
    }

    public abstract XYPlot getXYPlot();

    public abstract TimeSeriesCollection getDatasetCollection();

    public void toGIF(String filename)
        throws IOException
    {
        if(filename == null)
            throw new IllegalArgumentException("filename cannot be null");
        FileOutputStream gif_file = new FileOutputStream(filename);
        GifMaker gif_encoder = new GifMaker();
        if(image != null)
        {
            gif_encoder.setImage(image);
            gif_encoder.setOutputStream(gif_file);
            gif_encoder.write();
            gif_file.flush();
            gif_file.close();
        }
    }

    public Image getImage()
    {
        return image;
    }

    public void setImage(Image image)
    {
        this.image = image;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public int getWidth()
    {
        return width;
    }

    public void setWidth(int width)
    {
        this.width = width;
    }

    public int getHeight()
    {
        return height;
    }

    public void setHeight(int height)
    {
        this.height = height;
    }

    public int getWeight()
    {
        return weight;
    }

    public void setWeight(int weight)
    {
        this.weight = weight;
    }

    protected Image image;
    protected String title;
    protected int width;
    protected int height;
    protected int weight;
    protected int offset;
}
