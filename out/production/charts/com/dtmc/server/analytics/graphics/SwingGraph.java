// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   SwingGraph.java

package com.dtmc.server.analytics.graphics;

import java.awt.*;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageProducer;
import javax.swing.*;

// Referenced classes of package com.dtmc.server.analytics.graphics:
//            TransparentFilter

public class SwingGraph
{

    public SwingGraph()
    {
        image = null;
        title = "Graph";
        width = 600;
        height = 400;
        transparent = false;
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

    public boolean isTransparent()
    {
        return transparent;
    }

    public void setTransparent(boolean transparent)
    {
        this.transparent = transparent;
    }

    public JComponent getPlot()
    {
        return plot;
    }

    public void setPlot(JComponent plot)
    {
        this.plot = plot;
    }

    public ImageProducer convertToGIF(boolean transparent)
    {
        JFrame frame;
        final Graphics g;
        plot.setDoubleBuffered(false);
        frame = new JFrame();
        frame.setContentPane(plot);
        frame.pack();
        Dimension size = plot.getSize();
        image = plot.createImage(size.width, size.height);
        g = image.getGraphics();
        g.setClip(0, 0, size.width, size.height);
        SwingUtilities.invokeAndWait(new Runnable() {

            public void run()
            {
                plot.paint(g);
            }

            final Graphics val$g;
            final SwingGraph this$0;

            
            {
                this$0 = SwingGraph.this;
                g = g1;
                super();
            }
        });
        g.dispose();
        frame.dispose();
        break MISSING_BLOCK_LABEL_137;
        Exception x;
        x;
        x.printStackTrace();
        g.dispose();
        frame.dispose();
        break MISSING_BLOCK_LABEL_137;
        Exception exception;
        exception;
        g.dispose();
        frame.dispose();
        throw exception;
        ImageProducer prod = image.getSource();
        if(transparent)
        {
            java.awt.Color bg = plot.getBackground();
            java.awt.image.ImageFilter f = new TransparentFilter(bg);
            prod = new FilteredImageSource(prod, f);
        }
        return prod;
    }

    private Image image;
    private String title;
    private int width;
    private int height;
    private JComponent plot;
    private boolean transparent;

}
