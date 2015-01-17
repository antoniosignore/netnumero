// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   SSA.java

package com.numhero.shared.finance.ssa;

import com.numhero.client.model.pojoc.Portfolio;
import com.numhero.client.model.pojoc.finpojo.Instrument;
import com.numhero.client.model.pojoc.finpojo.PortfolioItem;
import com.numhero.shared.data.Transaction;
import com.numhero.shared.data.TransactionSeries;
import com.numhero.shared.finance.beans.*;
import com.numhero.shared.finance.date.TDay;
import com.numhero.shared.finance.ta.*;
import com.numhero.shared.finance.utils.Util;
import com.numhero.shared.pojoc.SearchablePojo;
import java.util.*;

// Referenced classes of package com.numhero.shared.finance.ssa:
//            EigenAnalysis

public class SSA extends Strategy
{

    public SSA()
    {
        foundABUY = false;
        fast = false;
        sma3 = 3;
        sma14 = 14;
        sma10 = 10;
        sma256 = 256;
        numberOfTradingDays = 5;
        snapshot = 448;
        nleft = 10;
        nright = 10;
        mode = 4;
        predictions = new ArrayList();
        armonics = new ArrayList();
    }

    public SSA(String name, Portfolio portfolio, TDay firstDate, TDay lastDate, double wealth)
    {
        super(name, portfolio, firstDate, lastDate, wealth);
        foundABUY = false;
        fast = false;
        sma3 = 3;
        sma14 = 14;
        sma10 = 10;
        sma256 = 256;
        numberOfTradingDays = 5;
        snapshot = 448;
        nleft = 10;
        nright = 10;
        mode = 4;
        predictions = new ArrayList();
        armonics = new ArrayList();
    }

    public float[] detrended(float serie[])
    {
        EigenAnalysis eserie = new EigenAnalysis(serie);
        float s1[] = eserie.getEigenComponent(1);
        float s2[] = eserie.getEigenComponent(2);
        float somma[] = Util.sumSeries(s1, s2);
        return Util.diffSeries(serie, somma);
    }

    private float[] getFirstEigen(float totalserie[])
    {
        EigenAnalysis eserie = new EigenAnalysis(totalserie);
        return eserie.getEigenComponent(1);
    }

    public float[] getDoubleEigenvectorsTrend(float s[])
    {
        EigenAnalysis eserie = new EigenAnalysis(s);
        float s1[] = eserie.getEigenComponent(1);
        float s2[] = eserie.getEigenComponent(2);
        return Util.sumSeries(s1, s2);
    }

    public float[] forecastTrend(float serie[], int fut)
        throws NRError
    {
        float augmentedSerie[] = Util.augmentByMovingAverage(serie);
        float predictionSerie[] = Util.vector(1, fut);
        for(int i = 1; i <= fut; i++)
        {
            float prediction;
            float lastPrediction;
            do
            {
                EigenAnalysis eserie = new EigenAnalysis(augmentedSerie);
                float s1[] = eserie.getEigenComponent(1);
                float s2[] = eserie.getEigenComponent(2);
                float somma[] = Util.sumSeries(s1, s2);
                prediction = Util.getLastValue(somma);
                lastPrediction = Util.getLastValue(augmentedSerie);
                Util.setLastValue(augmentedSerie, prediction);
            } while(Math.abs(prediction - lastPrediction) >= epsilon);
            predictionSerie[i] = prediction;
            augmentedSerie = Util.augmentByMovingAverage(augmentedSerie);
        }

        return predictionSerie;
    }

    public float[] computeForecast(float serie[], int numberOfDaysInTheFuture)
        throws NRError
    {
        Util.debug("SSA.computeForecast");
        Util.debug((new StringBuilder()).append("serie.length = ").append(serie.length).toString());
        Util.debug((new StringBuilder()).append("numberOfDaysInTheFuture = ").append(numberOfDaysInTheFuture).toString());
        long start = System.currentTimeMillis();
        float predictedSerie[] = Util.vector(1, numberOfDaysInTheFuture);
        float augmentedSerie[] = Util.augmentByMovingAverage(serie);
        for(int i = 1; i <= numberOfDaysInTheFuture; i++)
        {
            float lastPrediction = Util.getLastValue(augmentedSerie);
            do
            {
                EigenAnalysis eserie = new EigenAnalysis(augmentedSerie);
                float s1[] = eserie.getEigenComponent(1);
                float s2[] = eserie.getEigenComponent(2);
                float s3[] = eserie.getEigenComponent(3);
                float s4[] = eserie.getEigenComponent(4);
                float prediction = Util.getLastValue(s1) + Util.getLastValue(s2) + Util.getLastValue(s3) + Util.getLastValue(s4);
                Util.setLastValue(augmentedSerie, prediction);
                if(Math.abs(prediction - lastPrediction) < epsilon)
                {
                    predictedSerie[i] = prediction;
                    break;
                }
                lastPrediction = prediction;
            } while(true);
            augmentedSerie = Util.augmentByMovingAverage(augmentedSerie);
        }

        long end = System.currentTimeMillis();
        Util.debug((new StringBuilder()).append("DURATA = ").append((end - start) / 1000L).toString());
        return predictedSerie;
    }

    public List getPredictions()
    {
        return predictions;
    }

    public void setPredictions(List predictions)
    {
        this.predictions = predictions;
    }

    public List getArmonics()
    {
        return armonics;
    }

    public void setArmonics(List armonics)
    {
        this.armonics = armonics;
    }

    public void processTradingDay(Instrument instrument, TDay from, TDay today, float serie[], Map params)
        throws NRError
    {
        Map signalMap = new HashMap();
        Util.debug((new StringBuilder()).append("from = ").append(from).toString());
        Util.debug((new StringBuilder()).append("today = ").append(today).toString());
        instrument.setWindow(from, today);
        TimeSeries closes = instrument.getCloseSeries(from, today);
        Indicator sma1g = new Indicator(closes, (new StringBuilder()).append("SMA-").append(sma3).toString(), sma3, -1D, -1D, -1D, -1D);
        Util.debug((new StringBuilder()).append("serie.getSize() = ").append(serie.length).toString());
        Util.debug((new StringBuilder()).append("serie.getValue() = ").append(serie[serie.length - 1]).toString());
        Util.debug((new StringBuilder()).append("closes.getFirstData() = ").append(closes.getFirstData()).toString());
        Util.debug((new StringBuilder()).append("closes.getLastData() = ").append(closes.getLastData()).toString());
        HashMap map = (HashMap)params;
        Integer snappar = (Integer)map.get("snapshot");
        float prediction[] = computeForecast(serie, 64);
        float predictedserie[] = Util.concatenateSeries(serie, prediction);
        float currentDay = predictedserie[448];
        float monoEigenTrend[] = getFirstEigen(predictedserie);
        Map trendmaps = Filter.computeArmonics(monoEigenTrend);
        float trendD1[] = (float[])(float[])trendmaps.get("d1");
        Util.debug((new StringBuilder()).append("trendD1 = ").append(trendD1[448]).toString());
        float twoEigenTrend[] = getDoubleEigenvectorsTrend(predictedserie);
        float detrended[] = Util.diffSeries(predictedserie, monoEigenTrend);
        Map maps = Filter.computeArmonics(predictedserie);
        float smoothedData[] = (float[])(float[])maps.get("filter");
        float smoothedData2N[] = (float[])(float[])maps.get("doublefilter");
        float derivative1[] = (float[])(float[])maps.get("d1");
        float derivative2[] = (float[])(float[])maps.get("d2");
        derivative1[1] = 0.0F;
        derivative1[2] = 0.0F;
        derivative1[3] = 0.0F;
        derivative1[4] = 0.0F;
        derivative1[5] = 0.0F;
        derivative1[6] = 0.0F;
        derivative1[7] = 0.0F;
        derivative1[8] = 0.0F;
        derivative1[9] = 0.0F;
        derivative1[10] = 0.0F;
        derivative1[504] = 0.0F;
        derivative1[505] = 0.0F;
        derivative1[506] = 0.0F;
        derivative1[507] = 0.0F;
        derivative1[508] = 0.0F;
        derivative1[509] = 0.0F;
        derivative1[510] = 0.0F;
        derivative1[511] = 0.0F;
        derivative1[512] = 0.0F;
        derivative1[513] = 0.0F;
        derivative2[1] = 0.0F;
        derivative2[2] = 0.0F;
        derivative2[3] = 0.0F;
        derivative2[4] = 0.0F;
        derivative2[5] = 0.0F;
        derivative2[6] = 0.0F;
        derivative2[7] = 0.0F;
        derivative2[8] = 0.0F;
        derivative2[9] = 0.0F;
        derivative2[10] = 0.0F;
        derivative2[504] = 0.0F;
        derivative2[505] = 0.0F;
        derivative2[506] = 0.0F;
        derivative2[507] = 0.0F;
        derivative2[508] = 0.0F;
        derivative2[509] = 0.0F;
        derivative2[510] = 0.0F;
        derivative2[511] = 0.0F;
        derivative2[512] = 0.0F;
        signalMap.put("smoothedData", smoothedData);
        signalMap.put("smoothedData2N", smoothedData2N);
        signalMap.put("derivative1", derivative1);
        signalMap.put("derivative2", derivative2);
        float velmacd[] = Util.diffSeries((float[])(float[])maps.get("filter"), (float[])(float[])maps.get("doublefilter"));
        evaluatePortfolioOnDate(today, signalMap);
    }

    public void init()
    {
        foundABUY = false;
    }

    public void execute(Map parametersMap)
    {
        try
        {
            List portfolioItems = getPortfolio().getItems();
            for(int i = 0; i < portfolioItems.size(); i++)
            {
                init();
                PortfolioItem portfolioItem = (PortfolioItem)portfolioItems.get(i);
                Instrument instrument = portfolioItem.getInstrument();
                TimeSeries logserie = instrument.logAverageSeries();
                NumericalRecipesSeries lserie = logserie.asRecipes();
                int size = Util.size(lserie.getData());
                float vals[] = Util.vector(1, snapshot);
                for(int index = (size - numberOfTradingDays) + 1; index <= size; index++)
                {
                    TDay from = lserie.getDate((index - snapshot) + 1);
                    for(int j = 1; j <= snapshot; j++)
                    {
                        float valore = lserie.getValue((index - snapshot) + j);
                        vals[j] = valore;
                    }

                    Util.debug((new StringBuilder()).append("lserie.getDate(index) = ").append(lserie.getDate(index)).append(" val:").append(lserie.getValue(index)).toString());
                    processTradingDay(instrument, from, lserie.getDate(index), vals, parametersMap);
                }

            }

            TransactionSeries tserie = getTransactionSerie();
            Util.debug((new StringBuilder()).append("tserie.getNTransactions() = ").append(tserie.getNTransactions()).toString());
            StrategyBacktest trader = new StrategyBacktest(getTransactionSerie(), getPortfolio(), 100000D);
            double value = trader.test();
            Util.debug((new StringBuilder()).append("value = ").append(value).toString());
            try
            {
                trader.getNLossTradesLong();
                Util.debug((new StringBuilder()).append("trader.getNLossTradesTotal() = ").append(trader.getNLossTradesTotal()).toString());
                Util.debug((new StringBuilder()).append("trader.getNWinTradesTotal()() = ").append(trader.getNWinTradesTotal()).toString());
                Util.debug((new StringBuilder()).append("trader.getNLossTradesLong() = ").append(trader.getNLossTradesLong()).toString());
                Util.debug((new StringBuilder()).append("trader.getNLossTradesShort() = ").append(trader.getNLossTradesShort()).toString());
                Util.debug((new StringBuilder()).append("tra = ").append(trader.getAccountWealth()).toString());
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        catch(Exception exception)
        {
            exception.printStackTrace(System.out);
        }
    }

    public static float getEpsilon()
    {
        return epsilon;
    }

    public static void setEpsilon(float epsilon)
    {
        epsilon = epsilon;
    }

    public boolean isFoundABUY()
    {
        return foundABUY;
    }

    public void setFoundABUY(boolean foundABUY)
    {
        this.foundABUY = foundABUY;
    }

    public boolean isFast()
    {
        return fast;
    }

    public void setFast(boolean fast)
    {
        this.fast = fast;
    }

    public int getSma3()
    {
        return sma3;
    }

    public void setSma3(int sma3)
    {
        this.sma3 = sma3;
    }

    public int getSma14()
    {
        return sma14;
    }

    public void setSma14(int sma14)
    {
        this.sma14 = sma14;
    }

    public int getSma10()
    {
        return sma10;
    }

    public void setSma10(int sma10)
    {
        this.sma10 = sma10;
    }

    public int getSma256()
    {
        return sma256;
    }

    public void setSma256(int sma256)
    {
        this.sma256 = sma256;
    }

    public int getNumberOfTradingDays()
    {
        return numberOfTradingDays;
    }

    public void setNumberOfTradingDays(int numberOfTradingDays)
    {
        this.numberOfTradingDays = numberOfTradingDays;
    }

    public int getSnapshot()
    {
        return snapshot;
    }

    public void setSnapshot(int snapshot)
    {
        this.snapshot = snapshot;
    }

    public int getNleft()
    {
        return nleft;
    }

    public void setNleft(int nleft)
    {
        this.nleft = nleft;
    }

    public int getNright()
    {
        return nright;
    }

    public void setNright(int nright)
    {
        this.nright = nright;
    }

    public int getMode()
    {
        return mode;
    }

    public void setMode(int mode)
    {
        this.mode = mode;
    }

    public void evaluatePortfolioOnDate(TDay date, Map signals)
    {
        if(date == null)
            throw new IllegalArgumentException("date cannot be null");
        for(int i = 0; i < getPortfolio().nentries();)
        {
            Instrument instrument = getPortfolio().getInstrument(i);
            if(!instrument.isDataAvailable(date))
                continue;
            try
            {
                float smoothedData[] = (float[])(float[])signals.get("smoothedData");
                float derivative1[] = (float[])(float[])signals.get("derivative1");
                float derivative2[] = (float[])(float[])signals.get("derivative2");
                int amount = 100;
                if(!instrument.isDataAvailable(date))
                    continue;
                int signal = getLastValidSignal(derivative1, derivative2);
                if(signal == 8)
                {
                    Transaction transaction = new Transaction(instrument, 8, amount, instrument.getClose(date), date);
                    add(transaction);
                    foundABUY = true;
                }
                continue;
            }
            catch(IllegalStateException e)
            {
                e.printStackTrace();
                Util.debug(e.getMessage());
                i++;
            }
        }

    }

    public void evaluateInstrumentOnDate(TDay tday, Instrument instrument)
    {
    }

    private int getLastValidSignal(float derivative1[], float derivative2[])
    {
        int today = 448;
        for(int i = 0; i < 20; i++)
        {
            if(derivative1[today - i - 1] < 0.0F && derivative1[today - i] >= 0.0F && derivative2[today - i] > 0.0F)
                return 8;
            if(derivative1[today - i - 1] > 0.0F && derivative1[today - i] <= 0.0F && derivative2[today - i] < 0.0F)
                return 6;
        }

        throw new IllegalStateException("no signal found");
    }

    public String getKind()
    {
        return null;
    }

    public SearchablePojo clone()
    {
        return null;
    }

    public volatile Object clone()
        throws CloneNotSupportedException
    {
        return clone();
    }

    private static float epsilon = 0.002F;
    boolean foundABUY;
    private boolean fast;
    int sma3;
    int sma14;
    int sma10;
    int sma256;
    int numberOfTradingDays;
    int snapshot;
    int nleft;
    int nright;
    int mode;
    List predictions;
    List armonics;

}
