// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   NeuralNetwork.java

package com.dtmc.server.analytics.timeseries;

import java.applet.Applet;
import java.awt.*;

public class NeuralNetwork extends Applet
{

    public NeuralNetwork()
    {
        MAXNEURON = 20;
        MAXCOUPLING = 10;
        alty1 = new int[MAXCOUPLING];
        alty2 = new int[MAXCOUPLING];
        s = new int[MAXNEURON];
        j = new double[MAXCOUPLING];
        hits = 0.0D;
        games = 0.0D;
        kappa = 1.0D;
        pred = true;
    }

    public void init()
    {
        setLayout(null);
        setBackground(Color.white);
        active = new Button("active");
        active.reshape(30, 370, 90, 40);
        add(active);
        quiescent = new Button("quiescent");
        quiescent.reshape(130, 370, 90, 40);
        add(quiescent);
        new_statistics = new Button("new statistics");
        new_statistics.reshape(230, 370, 180, 40);
        add(new_statistics);
        reset_all = new Button("reset all");
        reset_all.reshape(420, 370, 150, 40);
        add(reset_all);
        reset();
    }

    public void reset()
    {
        for(int i = 0; i < MAXNEURON; i++)
            s[i] = 1;

        for(int i = 0; i < MAXCOUPLING; i++)
            j[i] = 1.0D / (double)MAXCOUPLING;

    }

    public boolean action(Event evt, Object arg)
    {
        if((String)arg == "active")
        {
            s_in = 1;
            learn();
        }
        if((String)arg == "quiescent")
        {
            s_in = -1;
            learn();
        }
        if((String)arg == "new statistics")
        {
            hits = 0.0D;
            games = 0.0D;
            repaint();
        }
        if((String)arg == "reset all")
        {
            hits = 0.0D;
            games = 0.0D;
            s_in = 1;
            reset();
            learn();
        }
        return true;
    }

    public boolean mouseDown(Event evt, int x, int y)
    {
        if(evt.modifiers == 0)
        {
            s_in = 1;
            learn();
            repaint();
        }
        if(evt.modifiers == 4)
        {
            s_in = -1;
            learn();
            repaint();
        }
        return true;
    }

    public void learn()
    {
        games++;
        h = 0.0D;
        for(int i = 0; i < MAXCOUPLING; i++)
            h += j[i] * (double)s[i];

        if(h * (double)s_in > 0.0D)
        {
            hits++;
            pred = true;
        } else
        {
            pred = false;
        }
        qsum = 0.0D;
        for(int i = 0; i < MAXCOUPLING; i++)
            qsum += j[i] * j[i];

        qsum = Math.sqrt(qsum);
        if(h * (double)s_in <= kappa * qsum)
        {
            for(int i = 0; i < MAXCOUPLING; i++)
                j[i] += (double)(s_in * s[i]) / (double)MAXCOUPLING;

        }
        for(int i = MAXNEURON - 1; i > 0; i--)
            s[i] = s[i - 1];

        s[0] = s_in;
        repaint();
    }

    public void paint(Graphics g)
    {
        int x = 38;
        for(int i = 0; i < MAXCOUPLING; i++)
        {
            g.drawLine(x, 48, 30 + (30 * MAXCOUPLING) / 2, 180);
            x += 30;
        }

        g.setColor(Color.blue);
        g.fillOval(23 + (30 * MAXCOUPLING) / 2, 185, 15, 15);
        g.setColor(Color.black);
        g.drawString("Neuron active (left mousebutton)", 325, 155);
        g.drawString("Neuron quiescent (right mb)", 325, 175);
        g.drawString("Coupling strengths", 90, 355);
        g.setColor(Color.red);
        g.fillOval(305, 141, 15, 15);
        g.setColor(Color.green);
        g.fillOval(305, 161, 15, 15);
        neuron(s);
        g.setColor(Color.black);
        String str = String.valueOf((hits / games) * 100D);
        g.drawString((new StringBuilder()).append(" Hit percentage: ").append(str.substring(0, Math.min(8, str.length()))).append("%").toString(), 325, 305);
        if(pred)
            g.drawString("Prediction correct", 325, 220);
        else
            g.drawString("Prediction wrong", 325, 220);
        couplings(j);
    }

    public void couplings(double j[])
    {
        Graphics g = getGraphics();
        int x = 30;
        for(int i = 0; i < MAXCOUPLING; i++)
        {
            int y1 = 300;
            int y2 = 300 - (int)(j[i] * 50D);
            if(y1 < y2)
            {
                int y3 = y2;
                y2 = y1;
                y1 = y3;
            }
            g.setColor(Color.black);
            g.drawRect(x - 5, alty1[i] = y2, 10, alty2[i] = y1 - y2);
            x += 30;
        }

        g.drawLine(30, 300, 15 + 30 * MAXCOUPLING, 300);
    }

    public void neuron(int s[])
    {
        Graphics g = getGraphics();
        int x = 30;
        for(int i = 0; i < MAXNEURON; i++)
        {
            if(s[i] == 1)
                g.setColor(Color.red);
            else
                g.setColor(Color.green);
            g.fillOval(x, 30, 15, 15);
            x += 30;
        }

    }

    int MAXNEURON;
    int MAXCOUPLING;
    int alty1[];
    int alty2[];
    int s[];
    int s_in;
    double j[];
    double h;
    double hits;
    double games;
    double qsum;
    double kappa;
    boolean pred;
    Button active;
    Button quiescent;
    Button new_statistics;
    Button reset_all;
}
