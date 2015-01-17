// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Regression.java

package com.dtmc.server.analytics.timeseries;

import com.numhero.client.model.pojoc.finpojo.Parameters;
import com.numhero.server.utils.DateUtils;
import com.numhero.shared.finance.beans.TimeSeries;
import com.numhero.shared.finance.date.TDay;
import com.numhero.shared.pojoc.field.StringField;

public class Regression extends Parameters
{

    public Regression(TimeSeries Series1, TimeSeries Series2)
    {
        super(0.0D, 0.0D);
        fSeries1 = Series1;
        fSeries2 = Series2;
        fResidualSeries = null;
    }

    public Regression(TimeSeries Series1, TimeSeries Series2, double alpha, double beta)
    {
        super(alpha, beta);
        fSeries1 = Series1;
        fSeries2 = Series2;
        fResidualSeries = null;
    }

    public void calculate()
    {
        double beta = fSeries1.getCovariance(fSeries2) / fSeries1.getVariance();
        double alpha = fSeries2.getMean() - beta * fSeries1.getMean();
        setParam(0, alpha);
        setParam(1, beta);
    }

    public TimeSeries getResidualSeries()
    {
        if(fResidualSeries == null)
        {
            fResidualSeries = new TimeSeries();
            fResidualSeries.fName.setValue("Regression residuals");
        }
        TDay firstSeriesFirstDate = DateUtils.max(fSeries1.getFirstDate(), fSeries2.getFirstDate());
        TDay firstSeriesLastDate = DateUtils.min(fSeries1.getLastDate(), fSeries2.getLastDate());
        TDay secSeriesFirstDate = DateUtils.max(fSeries2.getFirstDate(), fSeries2.getFirstDate());
        TDay secSeriesLastDate = DateUtils.min(fSeries2.getLastDate(), fSeries2.getLastDate());
        if(fSeries1.getNData() != fSeries2.getNData() || !firstSeriesFirstDate.isEqual(secSeriesFirstDate) || !secSeriesLastDate.isEqual(secSeriesLastDate))
            throw new IllegalArgumentException("series d not contain the same number of data");
        for(TDay dd = firstSeriesLastDate; dd.isLessEqual(firstSeriesLastDate); dd = dd.addDays(1))
        {
            int Index1 = fSeries1.getIndex(dd);
            int Index2 = fSeries2.getIndex(dd);
            if(!fSeries1.isEmpty(Index1) && !fSeries2.isEmpty(Index2))
            {
                double x = fSeries1.getData(Index1);
                double y = fSeries2.getData(Index1);
                double r = getParam(0) + getParam(1) * x;
                fResidualSeries.add(fSeries1.getDate(Index1), y - r);
            }
        }

        return fResidualSeries;
    }

    private TimeSeries fSeries1;
    private TimeSeries fSeries2;
    private TimeSeries fResidualSeries;
}
