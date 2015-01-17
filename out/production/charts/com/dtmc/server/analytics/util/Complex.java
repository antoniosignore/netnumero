// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Complex.java

package com.dtmc.server.analytics.util;


public class Complex
{

    public Complex()
    {
        this(0.0F, 0.0F);
    }

    public Complex(float r, float i)
    {
        this.r = r;
        this.i = i;
    }

    public static Complex add(Complex a, Complex b)
    {
        return new Complex(a.r + b.r, a.i + b.i);
    }

    public static Complex sub(Complex a, Complex b)
    {
        return new Complex(a.r - b.r, a.i - b.i);
    }

    public static Complex mul(Complex a, Complex b)
    {
        return new Complex(a.r * b.r - a.i * b.i, a.i * b.r + a.r * b.i);
    }

    public static Complex onjg(Complex z)
    {
        return new Complex(z.r, -z.i);
    }

    public static Complex div(Complex a, Complex b)
    {
        Complex c = new Complex();
        if(Math.abs(b.r) >= Math.abs(b.i))
        {
            float r = b.i / b.r;
            float den = b.r + r * b.i;
            c.r = (a.r + r * a.i) / den;
            c.i = (a.i - r * a.r) / den;
        } else
        {
            float r = b.r / b.i;
            float den = b.i + r * b.r;
            c.r = (a.r * r + a.i) / den;
            c.i = (a.i * r - a.r) / den;
        }
        return c;
    }

    public static float abs(Complex z)
    {
        float x = Math.abs(z.r);
        float y = Math.abs(z.i);
        float ans;
        if(x == 0.0F)
            ans = y;
        else
        if(y == 0.0F)
            ans = x;
        else
        if(x > y)
        {
            float temp = y / x;
            ans = x * (float)Math.sqrt(1.0F + temp * temp);
        } else
        {
            float temp = x / y;
            ans = y * (float)Math.sqrt(1.0F + temp * temp);
        }
        return ans;
    }

    public static Complex sqrt(Complex z)
    {
        Complex c = new Complex();
        if(z.r == 0.0F && z.i == 0.0F)
            return new Complex(0.0F, 0.0F);
        float x = Math.abs(z.r);
        float y = Math.abs(z.i);
        float w;
        if(x >= y)
        {
            float r = y / x;
            w = (float)(Math.sqrt(x) * Math.sqrt(0.5D * (1.0D + Math.sqrt(1.0F + r * r))));
        } else
        {
            float r = x / y;
            w = (float)(Math.sqrt(y) * Math.sqrt(0.5D * ((double)r + Math.sqrt(1.0F + r * r))));
        }
        if(z.r >= 0.0F)
        {
            c.r = w;
            c.i = z.i / (2.0F * w);
        } else
        {
            c.i = z.i < 0.0F ? -w : w;
            c.r = z.i / (2.0F * c.i);
        }
        return c;
    }

    public static Complex mulReal(float x, Complex a)
    {
        return new Complex(x * a.r, x * a.i);
    }

    public float r;
    public float i;
}
