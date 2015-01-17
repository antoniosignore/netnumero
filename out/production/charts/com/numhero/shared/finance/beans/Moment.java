// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Moment.java

package com.numhero.shared.finance.beans;

import com.numhero.shared.finance.utils.Util;

// Referenced classes of package com.numhero.shared.finance.beans:
//            NRError

public class Moment
{
    public static class MomentResult
    {

        public float ave;
        public float adev;
        public float sdev;
        public float var;
        public float skew;
        public float curt;

        public MomentResult()
        {
        }
    }


    public Moment()
    {
    }

    public static MomentResult Moment(float data[], int n)
        throws NRError
    {
        float ep = 0.0F;
        MomentResult res = new MomentResult();
        if(n <= 1)
            Util.nrerror("n must be at least 2 in moment");
        float s = 0.0F;
        for(int j = 1; j <= n; j++)
            s += data[j];

        res.ave = s / (float)n;
        res.adev = res.var = res.skew = res.curt = 0.0F;
        for(int j = 1; j <= n; j++)
        {
            res.adev += Math.abs(s = data[j] - res.ave);
            ep += s;
            float p;
            res.var += p = s * s;
            res.skew += p *= s;
            res.curt += p *= s;
        }

        res.adev /= n;
        res.var = (res.var - (ep * ep) / (float)n) / (float)(n - 1);
        res.sdev = (float)Math.sqrt(res.var);
        if(res.var != 0.0F)
        {
            res.skew /= (float)n * res.var * res.sdev;
            res.curt = res.curt / ((float)n * res.var * res.var) - 3F;
        } else
        {
            Util.nrerror("No skew/kurtosis when variance = 0 (in moment)");
        }
        return res;
    }
}
