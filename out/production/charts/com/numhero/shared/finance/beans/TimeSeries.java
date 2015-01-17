// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   TimeSeries.java

package com.numhero.shared.finance.beans;

import com.numhero.server.utils.DateUtils;
import com.numhero.shared.data.DateWindow;
import com.numhero.shared.finance.date.TDay;
import com.numhero.shared.finance.matrix.Matrix;
import com.numhero.shared.finance.ta.DateValue;
import com.numhero.shared.finance.utils.Util;
import com.numhero.shared.pojoc.SearchablePojo;
import com.numhero.shared.pojoc.field.StringField;
import java.io.PrintStream;

// Referenced classes of package com.numhero.shared.finance.beans:
//            NumericalRecipesSeries

public class TimeSeries extends DateWindow
{

    public TimeSeries()
    {
        frequency = 0;
        option = 0;
        size = 0;
        initialSize = 0;
        expansion = 0;
        dimension = 0;
        lengthsArray = null;
        minimum = null;
        maximum = null;
        mean = null;
        variance = null;
        asymmetry = null;
        excess = null;
        correlationPairs = 0;
        init();
    }

    public TimeSeries(String name)
    {
        frequency = 0;
        option = 0;
        size = 0;
        initialSize = 0;
        expansion = 0;
        dimension = 0;
        lengthsArray = null;
        minimum = null;
        maximum = null;
        mean = null;
        variance = null;
        asymmetry = null;
        excess = null;
        correlationPairs = 0;
        fName.setValue(name);
        init();
    }

    public void init()
    {
        option = -1;
        initialSize = 500;
        expansion = 500;
        size = 0;
        dimension = 0;
        lengthsArray = null;
        data = null;
        minimum = null;
        maximum = null;
        mean = null;
        variance = null;
        excess = null;
        asymmetry = null;
        correlationPairs = 0;
    }

    public int getFrequency()
    {
        return frequency;
    }

    public int getOption()
    {
        return option;
    }

    public void setOption(int Option)
    {
        option = Option;
    }

    public int getNRows()
    {
        return dimension;
    }

    public TDay getPrevDate(TDay date1)
    {
        return getPrevDate(getIndex(date1));
    }

    public TDay getNextDate(TDay date1)
    {
        return getNextDate(getIndex(date1));
    }

    public double getPrevData(TDay date1, int Row)
    {
        return getPrevData(getIndex(date1), Row);
    }

    public double getPrevData(TDay date1)
    {
        return getPrevData(getIndex(date1), 0);
    }

    public double getNextData(TDay date1)
    {
        return getNextData(date1, 0);
    }

    public double getNextData(TDay date, int Row)
    {
        return getNextData(getIndex(date), Row);
    }

    public int getIndex(String date, String pattern)
    {
        return getIndex(date, pattern);
    }

    public double getData(String date, String pattern, int Row)
    {
        return getData(date, pattern, Row);
    }

    public double getData(String date, String pattern)
    {
        return getData(date, pattern, 0);
    }

    double getStandardError(int row)
    {
        if(!isValidRow(row))
            throw new IllegalArgumentException((new StringBuilder()).append("Illegal row number: ").append(row).append(" ").append(getName()).toString());
        else
            return getStandardDeviation(row) / Math.sqrt(lengthsArray[row]);
    }

    public int getLowerBoundIndex()
    {
        return getIndex(getLowerBoundDate());
    }

    public int getUpperBoundIndex()
    {
        return getIndex(getUpperBoundDate());
    }

    public double getStdDev(int FirstIndex, int LastIndex, int Row)
    {
        return getStandardDeviation(FirstIndex, LastIndex, Row);
    }

    public double getStdDev(int FirstIndex, int LastIndex)
    {
        return getStandardDeviation(FirstIndex, LastIndex, 0);
    }

    public double getStdErr(int FirstIndex, int LastIndex, int Row)
    {
        return getStandardError(FirstIndex, LastIndex, Row);
    }

    public double getStdErr(int FirstIndex, int LastIndex)
    {
        return getStandardError(FirstIndex, LastIndex, 0);
    }

    public double getStdDev(TDay firstDate, TDay lastDate, int Row)
    {
        return getStandardDeviation(firstDate, lastDate, Row);
    }

    public double getStdDev(TDay firstDate, TDay lastDate)
    {
        return getStandardDeviation(firstDate, lastDate, 0);
    }

    public double getStdErr(TDay firstDate, TDay lastDate, int Row)
    {
        return getStandardError(firstDate, lastDate, Row);
    }

    public double getStdErr(TDay firstDate, TDay lastDate)
    {
        return getStandardError(firstDate, lastDate, 0);
    }

    public double getStdDev(int Row)
    {
        return getStandardDeviation(Row);
    }

    public double getStdDev()
    {
        return getStandardDeviation(0);
    }

    public double getStdErr(int Row)
    {
        return getStandardError(Row);
    }

    public double getStdErr()
    {
        return getStandardError(0);
    }

    public boolean isValidRow(int row)
    {
        return row >= 0 && row < dimension;
    }

    public boolean isEmpty(int index)
    {
        return isEmpty(index, 0);
    }

    public boolean isEmpty(int index, int row)
    {
        if(index >= size)
            return true;
        if(row == -1)
        {
            for(int RowCount = 0; RowCount < dimension; RowCount++)
                if(!Double.isNaN(data.get(RowCount, index)))
                    return false;

            return true;
        }
        if(isValidRow(row))
            return Double.isNaN(data.get(row, index));
        else
            return false;
    }

    public boolean isEmpty(TDay date)
    {
        return isEmpty(date, 0);
    }

    public boolean isEmpty(TDay date, int Row)
    {
        int Index = getIndex(date);
        if(Index == -1)
            return true;
        else
            return isEmpty(Index, Row);
    }

    public int getFirstIndex()
    {
        TDay firstDate = getFirstDate();
        if(firstDate == null)
            throw new IllegalArgumentException("firstDate cannot be null");
        else
            return getIndex(firstDate);
    }

    public int getLastIndex()
    {
        return getIndex(getLastDate());
    }

    public int getNData()
    {
        return getNumberOfNotNullData(0);
    }

    public int getNumberOfNotNullData(int Row)
    {
        if(isValidRow(Row))
            return lengthsArray[Row];
        else
            return 0;
    }

    public int getPrevIndex(int index)
    {
        if(index == -1)
            return -1;
        int FirstIndex = getFirstIndex();
        for(int PrevIndex = index - 1; PrevIndex >= FirstIndex; PrevIndex--)
            if(!isEmpty(PrevIndex))
                return PrevIndex;

        return -1;
    }

    public TDay getPrevDate(int Index)
    {
        return getDate(getPrevIndex(Index));
    }

    public double getPrevData(int index)
    {
        return getPrevData(index, 0);
    }

    public double getPrevData(int index, int row)
    {
        int PrevIndex = getPrevIndex(index);
        if(PrevIndex == -1)
        {
            Util.debug((new StringBuilder()).append(" GetPrevData. No previous data for index ").append(index).toString());
            return 0.0D;
        } else
        {
            return data.get(row, PrevIndex);
        }
    }

    public int getNextIndex(int index)
    {
        if(index == -1)
            return -1;
        int LastIndex = getLastIndex();
        for(int NextIndex = index + 1; NextIndex <= LastIndex; NextIndex++)
            if(!isEmpty(NextIndex))
                return NextIndex;

        return -1;
    }

    public TDay getNextDate(int index)
    {
        return getDate(getNextIndex(index));
    }

    public double getNextData(int index)
    {
        return getNextData(index, 0);
    }

    public double getNextData(int index, int row)
    {
        int nextIndex = getNextIndex(index);
        if(nextIndex == -1)
        {
            Util.debug((new StringBuilder()).append(" GetNextData. No next data for index ").append(index).toString());
            return 0.0D;
        } else
        {
            return data.get(row, nextIndex);
        }
    }

    public int getIndex(TDay date)
    {
        if(!inBounds(date))
        {
            throw new IllegalStateException("index not in bound");
        } else
        {
            TDay dt = getLowerBoundDate();
            return (int)DateUtils.diffDays(dt, date);
        }
    }

    public int subtractFreq(TDay finalDate, TDay initialDate, int freq)
    {
        return diffDays(finalDate, initialDate);
    }

    public int diffDays(TDay finalDate, TDay initialDate)
    {
        long res = finalDate.getTime() - initialDate.getTime();
        res /= 0x5265c00L;
        return (int)res;
    }

    public TDay getDate(int index)
    {
        if(index == -1)
        {
            throw new IllegalStateException("index not in bound");
        } else
        {
            TDay lb = getLowerBoundDate();
            return addFreq(lb, index);
        }
    }

    public TDay addFreq(TDay lb, int index)
    {
        TDay res = lb.addDays(index);
        return res;
    }

    public double getData(TDay date)
    {
        return getData(date, 0);
    }

    public double getData(TDay date, int row)
    {
        if(date == null)
            return (0.0D / 0.0D);
        int index = getIndex(date);
        if(index == -1)
            return (0.0D / 0.0D);
        else
            return data.get(row, index);
    }

    public double getData(int index)
    {
        return getData(index, 0);
    }

    public double getData(int index, int row)
    {
        if(index < getLowerBoundIndex() || index > getUpperBoundIndex())
            throw new IllegalStateException("index out of bound");
        else
            return data.get(row, index);
    }

    public void set(int index, double data)
    {
        set(index, data, 0);
    }

    public void set(int index, double data, int row)
    {
        if(index < getLowerBoundIndex() || index > getUpperBoundIndex())
        {
            Util.debug((new StringBuilder()).append("TS: Set. index out of bounds: ").append(index).toString());
            return;
        }
        if(isEmpty(index, row))
        {
            Util.debug((new StringBuilder()).append("TS: Set. Empty entry with index :").append(index).toString());
            return;
        } else
        {
            this.data.set(row, index, data);
            return;
        }
    }

    public void set(TDay date, double Data)
    {
        set(date, Data, 0);
    }

    public void set(TDay date, double Data, int Row)
    {
        int Index = getIndex(date);
        if(Index != -1)
            set(Index, Data, Row);
        else
            Util.debug("TS: Set. CalendarDate out of bounds");
    }

    public void set(TimeSeries Series)
    {
        set(Series, 0, 0);
    }

    public void set(TimeSeries serie, int FromRow, int ToRow)
    {
        int FirstIndex = serie.getFirstIndex();
        int LastIndex = serie.getLastIndex();
        for(int Index = FirstIndex; Index <= LastIndex; Index++)
            if(!serie.isEmpty(Index, FromRow))
                add(serie.getDate(Index), serie.getData(Index, FromRow), ToRow);

    }

    public void set(TimeSeries Series, TDay firstDate, TDay lastDate)
    {
        set(Series, firstDate, lastDate, 0, 0);
    }

    public void set(TimeSeries series, TDay firstDate, TDay lastDate, int fromRow, int toRow)
    {
        firstDate = DateUtils.max(firstDate, series.getFirstDate());
        lastDate = DateUtils.min(lastDate, series.getLastDate());
        int FirstIndex = series.getIndex(firstDate);
        int LastIndex = series.getIndex(lastDate);
        for(int Index = FirstIndex; Index <= LastIndex; Index++)
            if(!series.isEmpty(Index, fromRow))
                add(series.getDate(Index), series.getData(Index, fromRow), toRow);

    }

    public void add(TDay date, double data)
    {
        add(date, data, 0);
    }

    public void add(TDay date, double value, int row)
    {
        int i = 0;
        int dimensionIndex = 0;
        if(row >= dimension)
        {
            if(lengthsArray == null)
            {
                lengthsArray = new int[row + 1];
                for(dimensionIndex = 0; dimensionIndex <= row; dimensionIndex++)
                    lengthsArray[dimensionIndex] = 0;

            } else
            {
                int NewNData[] = new int[row + 1];
                for(dimensionIndex = 0; dimensionIndex < dimension; dimensionIndex++)
                    NewNData[dimensionIndex] = lengthsArray[dimensionIndex];

                for(dimensionIndex = dimension; dimensionIndex <= row; dimensionIndex++)
                    NewNData[dimensionIndex] = 0;

                lengthsArray = NewNData;
            }
            if(minimum == null)
            {
                minimum = new double[row + 1];
                for(dimensionIndex = 0; dimensionIndex <= row; dimensionIndex++)
                    minimum[dimensionIndex] = 9.9999999999999997E+98D;

            } else
            {
                double NewMin[] = new double[row + 1];
                for(dimensionIndex = 0; dimensionIndex < dimension; dimensionIndex++)
                    NewMin[dimensionIndex] = minimum[dimensionIndex];

                for(dimensionIndex = dimension; dimensionIndex <= row; dimensionIndex++)
                    NewMin[dimensionIndex] = 9.9999999999999997E+98D;

                minimum = NewMin;
            }
            if(maximum == null)
            {
                maximum = new double[row + 1];
                for(dimensionIndex = 0; dimensionIndex <= row; dimensionIndex++)
                    maximum[dimensionIndex] = -9.9999999999999997E+98D;

            } else
            {
                double NewMax[] = new double[row + 1];
                for(dimensionIndex = 0; dimensionIndex < dimension; dimensionIndex++)
                    NewMax[dimensionIndex] = maximum[dimensionIndex];

                for(dimensionIndex = dimension; dimensionIndex <= row; dimensionIndex++)
                    NewMax[dimensionIndex] = -9.9999999999999997E+98D;

                maximum = NewMax;
            }
            if(mean == null)
            {
                mean = new double[row + 1];
                for(dimensionIndex = 0; dimensionIndex <= row; dimensionIndex++)
                    mean[dimensionIndex] = 0.0D;

            } else
            {
                double NewMean[] = new double[row + 1];
                for(dimensionIndex = 0; dimensionIndex < dimension; dimensionIndex++)
                    NewMean[dimensionIndex] = mean[dimensionIndex];

                for(dimensionIndex = dimension; dimensionIndex <= row; dimensionIndex++)
                    NewMean[dimensionIndex] = 0.0D;

                mean = NewMean;
            }
            if(variance == null)
            {
                variance = new double[row + 1];
                for(dimensionIndex = 0; dimensionIndex <= row; dimensionIndex++)
                    variance[dimensionIndex] = 0.0D;

            } else
            {
                double newVariance[] = new double[row + 1];
                for(dimensionIndex = 0; dimensionIndex < dimension; dimensionIndex++)
                    newVariance[dimensionIndex] = variance[dimensionIndex];

                for(dimensionIndex = dimension; dimensionIndex <= row; dimensionIndex++)
                    newVariance[dimensionIndex] = 0.0D;

                variance = newVariance;
            }
            if(asymmetry == null)
            {
                asymmetry = new double[row + 1];
                for(dimensionIndex = 0; dimensionIndex <= row; dimensionIndex++)
                    asymmetry[dimensionIndex] = 0.0D;

            } else
            {
                double newAsymmetry[] = new double[row + 1];
                for(dimensionIndex = 0; dimensionIndex < dimension; dimensionIndex++)
                    newAsymmetry[dimensionIndex] = asymmetry[dimensionIndex];

                for(dimensionIndex = dimension; dimensionIndex <= row; dimensionIndex++)
                    newAsymmetry[dimensionIndex] = 0.0D;

                asymmetry = newAsymmetry;
            }
            if(excess == null)
            {
                excess = new double[row + 1];
                for(dimensionIndex = 0; dimensionIndex <= row; dimensionIndex++)
                    excess[dimensionIndex] = 0.0D;

            } else
            {
                double NewExcess[] = new double[row + 1];
                for(dimensionIndex = 0; dimensionIndex < dimension; dimensionIndex++)
                    NewExcess[dimensionIndex] = excess[dimensionIndex];

                for(dimensionIndex = dimension; dimensionIndex <= row; dimensionIndex++)
                    NewExcess[dimensionIndex] = 0.0D;

                excess = NewExcess;
            }
        }
        if(this.data == null)
        {
            dimension = row + 1;
            size = initialSize;
            this.data = new Matrix(dimension, size);
            for(dimensionIndex = 0; dimensionIndex < dimension; dimensionIndex++)
                for(i = 0; i < size; i++)
                    this.data.set(dimensionIndex, i, (0.0D / 0.0D));


            setLowerBoundDate(date);
            setLowerRangeDate(date);
            setUpperRangeDate(date);
            TDay upperDate = getDate(size - 1);
            setUpperBoundDate(upperDate);
        }
        if(date.isLess(getLowerBoundDate()))
        {
            TDay lbdt = getLowerBoundDate();
            long addSize = Math.max(expansion, DateUtils.diffDays(lbdt, date));
            long newSize = (long)size + addSize;
            long newNRows = dimension;
            if(row >= dimension)
                newNRows = row + 1;
            Matrix data = new Matrix((int)newNRows, (int)newSize);
            TDay newlbdt = lbdt.subtractDays((int)addSize);
            setLowerBoundDate(newlbdt);
            for(dimensionIndex = 0; (long)dimensionIndex < newNRows; dimensionIndex++)
                for(i = 0; (long)i < newSize; i++)
                    data.set(dimensionIndex, i, (0.0D / 0.0D));


            for(dimensionIndex = 0; (long)dimensionIndex < newNRows; dimensionIndex++)
            {
                if(Double.isNaN(this.data.get(dimensionIndex, 0)))
                    continue;
                for(i = 0; i < size; i++)
                    data.set(dimensionIndex, (int)((long)i + addSize), this.data.get(dimensionIndex, i));

            }

            this.data = data;
            size = (int)newSize;
            dimension = (int)newNRows;
            setLowerRangeDate(date);
        }
        if(date.isGreater(getUpperBoundDate()))
        {
            System.out.println((new StringBuilder()).append("date ").append(date).append(" is after upper bound = ").append(getUpperBoundDate()).toString());
            printWindow();
            TDay dt = getUpperBoundDate();
            long addSize = Math.max(expansion, DateUtils.diffDays(date, dt));
            long newSize = (long)size + addSize;
            int newNRows = dimension;
            if(row >= dimension)
                newNRows = row + 1;
            Matrix data = new Matrix(newNRows, (int)newSize);
            for(dimensionIndex = 0; dimensionIndex < newNRows; dimensionIndex++)
                for(i = 0; (long)i < newSize; i++)
                    data.set(dimensionIndex, i, (0.0D / 0.0D));


            for(dimensionIndex = 0; dimensionIndex < dimension; dimensionIndex++)
            {
                if(Double.isNaN(this.data.get(dimensionIndex, 0)))
                    continue;
                for(i = 0; i < size; i++)
                    data.set(dimensionIndex, i, this.data.get(dimensionIndex, i));

            }

            this.data = data;
            size = (int)newSize;
            dimension = newNRows;
            TDay upperDate = getDate((int)(newSize - 1L));
            setUpperBoundDate(upperDate);
            setUpperRangeDate(date);
        }
        if(row >= dimension)
        {
            int NewNRows = row + 1;
            Matrix NewData = new Matrix(NewNRows, size);
            for(dimensionIndex = 0; dimensionIndex < dimension; dimensionIndex++)
                for(i = 0; i < size; i++)
                    NewData.set(dimensionIndex, i, this.data.get(dimensionIndex, i));


            for(dimensionIndex = dimension; dimensionIndex < NewNRows; dimensionIndex++)
                for(i = 0; i < size; i++)
                    NewData.set(dimensionIndex, i, (0.0D / 0.0D));


            this.data = NewData;
            dimension = NewNRows;
        }
        if(date.isGreater(getUpperRangeDate()))
            setUpperRangeDate(date);
        if(date.isLess(getLowerRangeDate()))
            setLowerRangeDate(date);
        int Index = getIndex(date);
        if(isEmpty(Index, row))
            lengthsArray[row]++;
        this.data.set(row, Index, value);
    }

    private void printWindow()
    {
        System.out.println("------------ window ------------------------------------------");
        System.out.println((new StringBuilder()).append("getLowerBoundDate() = ").append(getLowerBoundDate().toString()).toString());
        System.out.println((new StringBuilder()).append("getLowerBoundIndex() = ").append(getLowerBoundIndex()).toString());
        System.out.println((new StringBuilder()).append("getUpperBoundDate() = ").append(getUpperBoundDate().toString()).toString());
        System.out.println((new StringBuilder()).append("getUpperBoundIndex() = ").append(getUpperBoundIndex()).toString());
        System.out.println("--------------------------------------------------------------");
    }

    public TimeSeries getTimeSeries(TDay first, TDay last)
    {
        return getTimeSeries(first, last, 0);
    }

    public TimeSeries getTimeSeries(TDay first, TDay last, int row)
    {
        if(!isValidRow(row))
            throw new IllegalArgumentException((new StringBuilder()).append("Illegal row number: ").append(row).append(" ").append(getName()).toString());
        TimeSeries timeseries = new TimeSeries();
        if(last == null)
            last = getLastDate();
        int FirstIndex = getIndex(first);
        int LastIndex = getIndex(last);
        for(int Index = FirstIndex; Index <= LastIndex; Index++)
            if(!isEmpty(Index, row))
                timeseries.add(getDate(Index), getData(Index, row));

        return timeseries;
    }

    public TimeSeries getAccumulatedSeries()
    {
        TimeSeries AccumulatedSeries = new TimeSeries();
        TDay firstCalendarDate = getFirstDate();
        TDay lastCalendarDate = getLastDate();
        double AccumulatedData = 0.0D;
        int FirstIndex = getIndex(firstCalendarDate);
        int LastIndex = getIndex(lastCalendarDate);
        for(int Index = FirstIndex; Index <= LastIndex; Index++)
            if(!isEmpty(Index))
            {
                AccumulatedData += getData(Index);
                AccumulatedSeries.add(getDate(Index), AccumulatedData);
            }

        return AccumulatedSeries;
    }

    public TimeSeries getDiffSeries(TimeSeries Series)
    {
        TimeSeries diffSeries = new TimeSeries();
        if(frequency != Series.frequency)
        {
            Util.debug("TS: GetDiffSeries. Time xyseries with different tick sizes");
            return diffSeries;
        }
        TDay firstCalendarDate = DateUtils.max(getFirstDate(), Series.getFirstDate());
        TDay lastCalendarDate = DateUtils.min(getLastDate(), Series.getLastDate());
        int FirstIndex = getIndex(firstCalendarDate);
        int LastIndex = getIndex(lastCalendarDate);
        for(int index = FirstIndex; index <= LastIndex; index++)
            if(!isEmpty(index) && !Series.isEmpty(index))
                diffSeries.add(getDate(index), getData(index) - Series.getData(index));

        return diffSeries;
    }

    public TimeSeries getShiftedSeries()
    {
        return getShiftedSeries(1, null, null);
    }

    public TimeSeries getShiftedSeries(TDay from, TDay to)
    {
        return getShiftedSeries(1, from, to);
    }

    public TimeSeries getShiftedSeries(int Lag, TDay from, TDay to)
    {
        TimeSeries shiftedSeries = new TimeSeries();
        TDay firstCalendarDate = getFirstDate();
        TDay lastCalendarDate = getLastDate();
        if(from != null)
            firstCalendarDate = from;
        if(to != null)
            lastCalendarDate = to;
        for(TDay date = firstCalendarDate; date.isLessEqual(lastCalendarDate); date = date.addDays(1))
            if(!isEmpty(date))
            {
                date = date.addDays(Lag);
                shiftedSeries.add(date, getData(date));
            }

        return shiftedSeries;
    }

    public double getFirstData()
    {
        return getFirstData(0);
    }

    public double getFirstData(int row)
    {
        if(!isValidRow(row))
            throw new IllegalArgumentException((new StringBuilder()).append("Illegal row number: ").append(row).append(" ").append(getName()).toString());
        else
            return data.get(row, getFirstIndex());
    }

    public double getLastValidData()
    {
        return getLastValidData(0);
    }

    public double getLastValidData(int row)
    {
        if(!isValidRow(row))
            throw new IllegalArgumentException((new StringBuilder()).append("Illegal row number: ").append(row).append(" ").append(getName()).toString());
        int i = getLastIndex();
        Double d;
        for(d = Double.valueOf(data.get(row, i)); d.isNaN() && i >= 0; d = Double.valueOf(data.get(row, i--)));
        return d.doubleValue();
    }

    public double getLastData()
    {
        return getLastData(0);
    }

    public double getLastData(int row)
    {
        if(!isValidRow(row))
            throw new IllegalArgumentException((new StringBuilder()).append("Illegal row number: ").append(row).append(" ").append(getName()).toString());
        else
            return data.get(row, getLastIndex());
    }

    public double getMin(int FirstIndex, int LastIndex)
    {
        return getMin(FirstIndex, LastIndex, 0);
    }

    public double getMin(int fIndex, int lIndex, int row)
    {
        if(!isValidRow(row))
            throw new IllegalArgumentException((new StringBuilder()).append("Illegal row number: ").append(row).append(" ").append(getName()).toString());
        fIndex = Math.max(fIndex, getFirstIndex());
        lIndex = Math.min(lIndex, getLastIndex());
        double Min = 9.9999999999999997E+98D;
        for(int i = fIndex; i <= lIndex; i++)
            if(!isEmpty(i, row))
                Min = Math.min(Min, data.get(row, i));

        return Min;
    }

    public double getMax(int FirstIndex, int LastIndex)
    {
        return getMax(FirstIndex, LastIndex, 0);
    }

    public double getMax(int fIndex, int lIndex, int row)
    {
        if(!isValidRow(row))
            throw new IllegalArgumentException((new StringBuilder()).append("Illegal row number: ").append(row).append(" ").append(getName()).toString());
        fIndex = Math.max(fIndex, getFirstIndex());
        lIndex = Math.min(lIndex, getLastIndex());
        double Max = -9.9999999999999997E+98D;
        for(int i = fIndex; i <= lIndex; i++)
            if(!isEmpty(i, row))
                Max = Math.max(Max, data.get(row, i));

        return Max;
    }

    public int getNZero()
    {
        return getNZero(0);
    }

    public int getNZero(int row)
    {
        if(!isValidRow(row))
            throw new IllegalArgumentException((new StringBuilder()).append("Illegal row number: ").append(row).append(" ").append(getName()).toString());
        int FirstIndex = getFirstIndex();
        int LastIndex = getLastIndex();
        int N = 0;
        for(int i = FirstIndex; i <= LastIndex; i++)
            if(!isEmpty(i) && data.get(row, i) == 0.0D)
                N++;

        return N;
    }

    public int getNNonZero()
    {
        return getNNonZero(0);
    }

    public int getNNonZero(int row)
    {
        if(!isValidRow(row))
            throw new IllegalArgumentException((new StringBuilder()).append("Illegal row number: ").append(row).append(" ").append(getName()).toString());
        int FirstIndex = getFirstIndex();
        int LastIndex = getLastIndex();
        int N = 0;
        for(int i = FirstIndex; i <= LastIndex; i++)
            if(!isEmpty(i) && data.get(row, i) != 0.0D)
                N++;

        return N;
    }

    public int getNPositive()
    {
        return getNPositive(0);
    }

    public int getNPositive(int row)
    {
        if(!isValidRow(row))
            throw new IllegalArgumentException((new StringBuilder()).append("Illegal row number: ").append(row).append(" ").append(getName()).toString());
        int FirstIndex = getFirstIndex();
        int LastIndex = getLastIndex();
        int N = 0;
        for(int i = FirstIndex; i <= LastIndex; i++)
            if(!isEmpty(i) && data.get(row, i) > 0.0D)
                N++;

        return N;
    }

    public int getNNegative()
    {
        return getNNegative(0);
    }

    public int getNNegative(int row)
    {
        if(!isValidRow(row))
            throw new IllegalArgumentException((new StringBuilder()).append("Illegal row number: ").append(row).append(" ").append(getName()).toString());
        int FirstIndex = getFirstIndex();
        int LastIndex = getLastIndex();
        int N = 0;
        for(int i = FirstIndex; i <= LastIndex; i++)
            if(!isEmpty(i) && data.get(row, i) < 0.0D)
                N++;

        return N;
    }

    public double getMean(int FirstIndex, int LastIndex)
    {
        return getMean(FirstIndex, LastIndex, 0);
    }

    public double getMean(int firstIndex, int lastIndex, int row)
    {
        if(!isValidRow(row))
            throw new IllegalArgumentException((new StringBuilder()).append("Illegal row number: ").append(row).append(" ").append(getName()).toString());
        firstIndex = Math.max(firstIndex, getFirstIndex());
        lastIndex = Math.min(lastIndex, getLastIndex());
        int N = 0;
        double Mean = 0.0D;
        for(int i = firstIndex; i <= lastIndex; i++)
            if(!isEmpty(i))
            {
                double val = data.get(row, i);
                Mean += val;
                N++;
            }

        return Mean / (double)N;
    }

    public double getVariance(int FirstIndex, int LastIndex)
    {
        return getVariance(FirstIndex, LastIndex, 0);
    }

    public double getVariance(int firstIndex, int lastIndex, int row)
    {
        if(!isValidRow(row))
            throw new IllegalArgumentException((new StringBuilder()).append("Illegal row number: ").append(row).append(" ").append(getName()).toString());
        firstIndex = Math.max(firstIndex, getFirstIndex());
        lastIndex = Math.min(lastIndex, getLastIndex());
        double Mean = getMean(firstIndex, lastIndex, row);
        int N = 0;
        double Variance = 0.0D;
        for(int i = firstIndex; i <= lastIndex; i++)
            if(!isEmpty(i))
            {
                Variance += (data.get(row, i) - Mean) * (data.get(row, i) - Mean);
                N++;
            }

        return Variance / (double)(N - 1);
    }

    public double getStandardDeviation(int firstIndex, int lastIndex)
    {
        return getStandardDeviation(firstIndex, lastIndex, 0);
    }

    public double getStandardDeviation(int firstIndex, int lastIndex, int row)
    {
        if(!isValidRow(row))
            throw new IllegalArgumentException((new StringBuilder()).append("Illegal row number: ").append(row).append(" ").append(getName()).toString());
        else
            return Math.sqrt(getVariance(firstIndex, lastIndex, row));
    }

    public double getStandardError(int FirstIndex, int LastIndex)
    {
        return getStandardError(FirstIndex, LastIndex, 0);
    }

    public double getStandardError(int firstIndex, int lastIndex, int row)
    {
        if(!isValidRow(row))
            throw new IllegalArgumentException((new StringBuilder()).append("Illegal row number: ").append(row).append(" ").append(getName()).toString());
        firstIndex = Math.max(firstIndex, getFirstIndex());
        lastIndex = Math.min(lastIndex, getLastIndex());
        double Mean = getMean(firstIndex, lastIndex, row);
        int N = 0;
        double SE = 0.0D;
        for(int i = firstIndex; i <= lastIndex; i++)
            if(!isEmpty(i))
            {
                SE += (data.get(row, i) - Mean) * (data.get(row, i) - Mean);
                N++;
            }

        return Math.sqrt(SE / (double)(N * (N - 1)));
    }

    public double getMomentum(int k, int FirstIndex, int LastIndex)
    {
        return getMomentum(k, FirstIndex, LastIndex, 0);
    }

    public double getMomentum(int k, int firstIndex, int lastIndex, int row)
    {
        if(!isValidRow(row))
            throw new IllegalArgumentException((new StringBuilder()).append("Illegal row number: ").append(row).append(" ").append(getName()).toString());
        firstIndex = Math.max(firstIndex, getFirstIndex());
        lastIndex = Math.min(lastIndex, getLastIndex());
        double X;
        if(k == 1)
            X = 0.0D;
        else
            X = getMean(firstIndex, lastIndex, row);
        int N = 0;
        double Momentum = 0.0D;
        for(int i = firstIndex; i <= lastIndex; i++)
            if(!isEmpty(i))
            {
                Momentum += Math.pow(data.get(row, i) - X, k);
                N++;
            }

        if(N == 0)
        {
            Util.debug("getMomentum . N = 0");
            return 0.0D;
        } else
        {
            return Momentum / (double)N;
        }
    }

    public double getAsimmetry(int firstIndex, int lastIndex)
    {
        return getAsimmetry(firstIndex, lastIndex, 0);
    }

    public double getAsimmetry(int firstIndex, int lastIndex, int row)
    {
        if(!isValidRow(row))
            throw new IllegalArgumentException((new StringBuilder()).append("Illegal row number: ").append(row).append(" ").append(getName()).toString());
        firstIndex = Math.max(firstIndex, getFirstIndex());
        lastIndex = Math.min(lastIndex, getLastIndex());
        double StdDev = getStandardDeviation(firstIndex, lastIndex, row);
        if(StdDev == 0.0D)
        {
            Util.debug("getAsimmetry. StdDev = 0");
            return 0.0D;
        } else
        {
            return getMomentum(3, firstIndex, lastIndex, row) / Math.pow(StdDev, 3D);
        }
    }

    public double getExcess(int firstIndex, int lastIndex)
    {
        return getExcess(firstIndex, lastIndex, 0);
    }

    public double getExcess(int FirstIndex, int LastIndex, int row)
    {
        if(!isValidRow(row))
            throw new IllegalArgumentException((new StringBuilder()).append("Illegal row number: ").append(row).append(" ").append(getName()).toString());
        FirstIndex = Math.max(FirstIndex, getFirstIndex());
        LastIndex = Math.min(LastIndex, getLastIndex());
        double StdDev = getStandardDeviation(FirstIndex, LastIndex, row);
        if(StdDev == 0.0D)
        {
            Util.debug("getAsimmetry. StdDev = 0");
            return 0.0D;
        } else
        {
            return getMomentum(4, FirstIndex, LastIndex, row) / Math.pow(StdDev, 4D);
        }
    }

    public double getMin(TDay firstDate, TDay lastDate)
    {
        return getMin(firstDate, lastDate, 0);
    }

    public double getMin(TDay firstDate, TDay lastDate, int Row)
    {
        return getMin(getIndex(firstDate), getIndex(lastDate), Row);
    }

    public double getMax(TDay firstDate, TDay lastDate)
    {
        return getMax(firstDate, lastDate, 0);
    }

    public double getMax(TDay firstDate, TDay lastDate, int Row)
    {
        return getMax(getIndex(firstDate), getIndex(lastDate), Row);
    }

    public double getMean(TDay firstDate, TDay lastDate)
    {
        return getMean(firstDate, lastDate, 0);
    }

    public double getMean(TDay firstDate, TDay lastDate, int Row)
    {
        return getMean(getIndex(firstDate), getIndex(lastDate), Row);
    }

    public double getVariance(TDay firstDate, TDay lastDate)
    {
        return getVariance(firstDate, lastDate, 0);
    }

    public double getVariance(TDay firstDate, TDay lastDate, int Row)
    {
        return getVariance(getIndex(firstDate), getIndex(lastDate), Row);
    }

    public double getStandardDeviation(TDay firstDate, TDay lastDate)
    {
        return getStandardDeviation(firstDate, lastDate, 0);
    }

    public double getStandardDeviation(TDay firstDate, TDay lastDate, int Row)
    {
        return getStandardDeviation(getIndex(firstDate), getIndex(lastDate), Row);
    }

    public double getStandardError(TDay firstDate, TDay lastDate)
    {
        return getStandardError(firstDate, lastDate, 0);
    }

    public double getStandardError(TDay firstDate, TDay lastDate, int Row)
    {
        return getStandardError(getIndex(firstDate), getIndex(lastDate), Row);
    }

    public double getMomentum(int k, TDay firstDate, TDay lastDate)
    {
        return getMomentum(k, firstDate, lastDate, 0);
    }

    public double getMomentum(int k, TDay firstDate, TDay lastDate, int Row)
    {
        return getMomentum(k, getIndex(firstDate), getIndex(lastDate), Row);
    }

    public double getAsimmetry(TDay firstDate, TDay lastDate)
    {
        return getAsimmetry(firstDate, lastDate, 0);
    }

    public double getAsimmetry(TDay firstDate, TDay lastDate, int Row)
    {
        return getAsimmetry(getIndex(firstDate), getIndex(lastDate), Row);
    }

    public double getExcess(TDay firstDate, TDay lastDate)
    {
        return getExcess(firstDate, lastDate, 0);
    }

    public double getExcess(TDay firstDate, TDay lastDate, int Row)
    {
        return getExcess(getIndex(firstDate), getIndex(lastDate), Row);
    }

    public double getMin(String FirstDate, String LastDate, String pattern)
    {
        return getMin(FirstDate, LastDate, pattern, 0);
    }

    public double getMin(String FirstDate, String LastDate, String pattern, int Row)
    {
        return getMin(getIndex(FirstDate, pattern), getIndex(LastDate, pattern), Row);
    }

    public double getMax(String FirstDate, String LastDate, String pattern)
    {
        return getMax(FirstDate, LastDate, pattern, 0);
    }

    public double getMax(String FirstDate, String LastDate, String pattern, int Row)
    {
        return getMax(getIndex(FirstDate, pattern), getIndex(LastDate, pattern), Row);
    }

    public double getMean(String FirstDate, String LastDate, String pattern)
    {
        return getMean(FirstDate, LastDate, pattern, 0);
    }

    public double getMean(String FirstDate, String LastDate, String pattern, int Row)
    {
        return getMean(getIndex(FirstDate, pattern), getIndex(LastDate, pattern), Row);
    }

    public double getVariance(String FirstDate, String LastDate, String pattern)
    {
        return getVariance(FirstDate, LastDate, pattern, 0);
    }

    public double getVariance(String FirstDate, String LastDate, String pattern, int Row)
    {
        return getVariance(getIndex(FirstDate, pattern), getIndex(LastDate, pattern), Row);
    }

    public double getStandardDeviation(String FirstDate, String LastDate, String pattern)
    {
        return getStandardDeviation(FirstDate, LastDate, pattern, 0);
    }

    public double getStandardDeviation(String FirstDate, String LastDate, String pattern, int Row)
    {
        return getStandardDeviation(getIndex(FirstDate, pattern), getIndex(LastDate, pattern), Row);
    }

    public double getStandardError(String FirstDate, String LastDate, String pattern)
    {
        return getStandardError(FirstDate, LastDate, pattern, 0);
    }

    public double getStandardError(String FirstDate, String LastDate, String pattern, int Row)
    {
        return getStandardError(getIndex(FirstDate, pattern), getIndex(LastDate, pattern), Row);
    }

    public double getMomentum(int k, String FirstDate, String LastDate, String pattern)
    {
        return getMomentum(k, FirstDate, LastDate, pattern, 0);
    }

    public double getMomentum(int k, String FirstDate, String LastDate, String pattern, int Row)
    {
        return getMomentum(k, getIndex(FirstDate, pattern), getIndex(LastDate, pattern), Row);
    }

    public double getAsimmetry(String FirstDate, String LastDate, String pattern)
    {
        return getAsimmetry(FirstDate, LastDate, pattern, 0);
    }

    public double getAsimmetry(String FirstDate, String LastDate, String pattern, int Row)
    {
        return getAsimmetry(getIndex(FirstDate, pattern), getIndex(LastDate, pattern), Row);
    }

    public double getExcess(String FirstDate, String LastDate, String pattern)
    {
        return getExcess(FirstDate, LastDate, pattern, 0);
    }

    public double getExcess(String FirstDate, String LastDate, String pattern, int Row)
    {
        return getExcess(getIndex(FirstDate, pattern), getIndex(LastDate, pattern), Row);
    }

    public double getMin()
    {
        return getMin(0);
    }

    public double getMin(int row)
    {
        if(isEmpty(0))
            return 0.0D;
        if(!isValidRow(row))
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Illegal row number: ").append(row).append(" ").append(getName()).toString());
        } else
        {
            minimum[row] = getMin(getFirstIndex(), getLastIndex(), row);
            return minimum[row];
        }
    }

    public double getMax()
    {
        return getMax(0);
    }

    public double getMax(int row)
    {
        if(isEmpty(0))
            return 0.0D;
        if(!isValidRow(row))
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Illegal row number: ").append(row).append(" ").append(getName()).toString());
        } else
        {
            maximum[row] = getMax(getFirstIndex(), getLastIndex(), row);
            return maximum[row];
        }
    }

    public double getMean()
    {
        return getMean(0);
    }

    public double getMean(int row)
    {
        if(isEmpty(0))
            return 0.0D;
        if(!isValidRow(row))
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Illegal row number: ").append(row).append(" ").append(getName()).toString());
        } else
        {
            mean[row] = getMean(getFirstIndex(), getLastIndex(), row);
            return mean[row];
        }
    }

    public double getVariance()
    {
        return getVariance(0);
    }

    public double getVariance(int row)
    {
        if(isEmpty(0))
            return 0.0D;
        if(!isValidRow(row))
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Illegal row number: ").append(row).append(" ").append(getName()).toString());
        } else
        {
            variance[row] = getVariance(getFirstIndex(), getLastIndex(), row);
            return variance[row];
        }
    }

    public double getStandardDeviation()
    {
        return getStandardDeviation(0);
    }

    public double getStandardDeviation(int row)
    {
        if(isEmpty(0))
            return 0.0D;
        if(!isValidRow(row))
            throw new IllegalArgumentException((new StringBuilder()).append("Illegal row number: ").append(row).append(" ").append(getName()).toString());
        else
            return Math.sqrt(getVariance(row));
    }

    public double getError()
    {
        return getError(0);
    }

    public double getError(int row)
    {
        if(isEmpty(0))
            return 0.0D;
        if(!isValidRow(row))
            throw new IllegalArgumentException((new StringBuilder()).append("Illegal row number: ").append(row).append(" ").append(getName()).toString());
        else
            return getStandardDeviation(row) / Math.sqrt(lengthsArray[row]);
    }

    public double getMomentum(int k)
    {
        return getMomentum(k, 0);
    }

    public double getMomentum(int k, int row)
    {
        if(isEmpty(0))
            return 0.0D;
        if(!isValidRow(row))
            throw new IllegalArgumentException((new StringBuilder()).append("Illegal row number: ").append(row).append(" ").append(getName()).toString());
        else
            return getMomentum(k, getFirstIndex(), getLastIndex(), row);
    }

    public double getAsimmetry(int row)
    {
        if(isEmpty(0))
            return 0.0D;
        if(!isValidRow(row))
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Illegal row number: ").append(row).append(" ").append(getName()).toString());
        } else
        {
            asymmetry[row] = getAsimmetry(getFirstIndex(), getLastIndex(), row);
            return asymmetry[row];
        }
    }

    public double getExcess()
    {
        return getExcess(0);
    }

    public double getExcess(int row)
    {
        if(isEmpty(0))
            return 0.0D;
        if(!isValidRow(row))
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Illegal row number: ").append(row).append(" ").append(getName()).toString());
        } else
        {
            excess[row] = getExcess(getFirstIndex(), getLastIndex(), row);
            return excess[row];
        }
    }

    public double getCovariance(int row1, int row2)
    {
        if(!isValidRow(row1))
            throw new IllegalArgumentException((new StringBuilder()).append("Illegal row number: ").append(row1).append(" ").append(getName()).toString());
        if(!isValidRow(row2))
            throw new IllegalArgumentException((new StringBuilder()).append("Illegal row number: ").append(row2).append(" ").append(getName()).toString());
        double Mean1 = getMean(row1);
        double Mean2 = getMean(row2);
        int FirstIndex = getFirstIndex();
        int LastIndex = getLastIndex();
        correlationPairs = 0;
        double Covariance = 0.0D;
        for(int Index = FirstIndex; Index <= LastIndex; Index++)
            if(!isEmpty(Index, row1) && !isEmpty(Index, row2))
            {
                correlationPairs++;
                Covariance += (data.get(row1, Index) - Mean1) * (data.get(row2, Index) - Mean2);
            }

        if(correlationPairs <= 1)
            return 0.0D;
        else
            return Covariance / (double)(correlationPairs - 1);
    }

    public double getCorrelation(int row1, int row2)
    {
        return getCovariance(row1, row2) / (getStandardDeviation(row1) * getStandardDeviation(row2));
    }

    public double getCovariance(TimeSeries series)
    {
        if(frequency != series.frequency)
            throw new IllegalArgumentException("Different tick sizes");
        double Mean1 = getMean();
        double Mean2 = series.getMean();
        TDay firstCalendarDate = DateUtils.max(getLowerBoundDate(), series.getLowerBoundDate());
        TDay lastCalendarDate = DateUtils.min(getUpperBoundDate(), series.getUpperBoundDate());
        correlationPairs = 0;
        double Covariance = 0.0D;
        for(TDay dt = firstCalendarDate; dt.isLessEqual(lastCalendarDate); dt = dt.addDays(1))
        {
            int Index1 = getIndex(dt);
            int Index2 = series.getIndex(dt);
            if(!isEmpty(Index1) && !series.isEmpty(Index2))
            {
                correlationPairs++;
                double val1 = data.get(0, Index1);
                double val2 = series.data.get(0, Index2);
                Covariance += (val1 - Mean1) * (val2 - Mean2);
            }
        }

        if(correlationPairs <= 1)
            return 0.0D;
        else
            return Covariance / (double)(correlationPairs - 1);
    }

    public double getCorrelation(TimeSeries series)
    {
        return getCovariance(series) / (getStandardDeviation() * series.getStandardDeviation());
    }

    public int getNCorrelationPairs(TimeSeries series)
    {
        getCovariance(series);
        return correlationPairs;
    }

    public double getAutoCovariance()
    {
        return getAutoCovariance(1);
    }

    public double getAutoCovariance(int lag)
    {
        double Mean = getMean();
        double AutoCovariance = 0.0D;
        int CurrentIndex = getFirstIndex();
        int LaggedIndex = getFirstIndex();
        for(int i = 0; i < lag; i++)
        {
            LaggedIndex = getNextIndex(LaggedIndex);
            if(LaggedIndex == -1)
                return 0.0D;
        }

        int N = 0;
        for(; LaggedIndex != -1; LaggedIndex = getNextIndex(LaggedIndex))
        {
            AutoCovariance += (data.get(0, CurrentIndex) - Mean) * (data.get(0, LaggedIndex) - Mean);
            N++;
            CurrentIndex = getNextIndex(CurrentIndex);
        }

        if(N <= lag)
        {
            return 0.0D;
        } else
        {
            AutoCovariance /= N - lag;
            return AutoCovariance;
        }
    }

    public double getAutoCorrelation()
    {
        return getAutoCorrelation(1);
    }

    public double getAutoCorrelation(int lag)
    {
        return getAutoCovariance(lag) / getVariance();
    }

    public TimeSeries getReturnSeries()
    {
        return getReturnSeries(1);
    }

    public TimeSeries getReturnSeries(int lag)
    {
        TimeSeries ReturnSeries = new TimeSeries();
        ReturnSeries.setOption(49);
        double LastData = getData(getFirstIndex());
        for(int i = getFirstIndex(); i <= getLastIndex(); i++)
        {
            if(isEmpty(i))
                continue;
            TDay date = getDate(i);
            double Data = getData(i);
            if(LastData != 0.0D)
                ReturnSeries.add(date, Data / LastData);
            LastData = Data;
        }

        return ReturnSeries;
    }

    public TimeSeries getLogReturnSeries()
    {
        return getLogReturnSeries(1);
    }

    public TimeSeries getLogReturnSeries(int Lag)
    {
        TimeSeries ReturnSeries = new TimeSeries();
        ReturnSeries.setOption(50);
        double LastData = getData(getLowerBoundIndex());
        for(int i = getLowerBoundIndex(); i <= getUpperBoundIndex(); i++)
        {
            if(isEmpty(i))
                continue;
            TDay date = getDate(i);
            double Data = getData(i);
            if(LastData != 0.0D)
                ReturnSeries.add(date, Math.log(Data / LastData));
            LastData = Data;
        }

        return ReturnSeries;
    }

    public int getNCrossings()
    {
        return getNCrossings(0.0D);
    }

    public int getNCrossings(double Level)
    {
        double Data = getFirstData();
        boolean IsBelow;
        if(Data < Level)
            IsBelow = true;
        else
            IsBelow = false;
        int FirstIndex = getFirstIndex() + 1;
        int LastIndex = getLastIndex();
        int NCrossings = 0;
        for(int Index = FirstIndex; Index <= LastIndex; Index++)
        {
            if(isEmpty(Index))
                continue;
            Data = getData(Index);
            if(IsBelow && Data > Level || !IsBelow && Data < Level)
            {
                NCrossings++;
                IsBelow = !IsBelow;
            }
        }

        return NCrossings;
    }

    public void clear()
    {
        init();
    }

    public void normalize()
    {
        normalize(0);
    }

    public void normalize(int Row)
    {
        int FirstIndex = getFirstIndex();
        int LastIndex = getLastIndex();
        double Mean = getMean(Row);
        double StandardDeviation = getStandardDeviation(Row);
        for(int i = FirstIndex; i <= LastIndex; i++)
            if(!isEmpty(i, Row))
                data.set(Row, i, (data.get(Row, i) - Mean) / StandardDeviation);

    }

    public void linearMapping(double Lower, double Upper)
    {
        linearMapping(Lower, Upper, 0);
    }

    public void linearMapping(double Lower, double Upper, int Row)
    {
        double Alpha = (Upper - Lower) / (getMax(Row) - getMin(Row));
        double Beta = -1D * Alpha * getMin(Row) + Lower;
        int FirstIndex = getFirstIndex();
        int LastIndex = getLastIndex();
        for(int i = FirstIndex; i <= LastIndex; i++)
            if(!isEmpty(i))
                data.set(Row, i, data.get(Row, i) * Alpha + Beta);

    }

    public void SMA(int Order)
    {
        int FirstIndex = getLowerBoundIndex();
        int LastIndex = getUpperBoundIndex();
        double Sum = 0.0D;
        double LastData = 0.0D;
        double PointCount = 0.0D;
        int Index;
        for(Index = FirstIndex; Index <= LastIndex; Index++)
        {
            if(isEmpty(Index))
                continue;
            LastData = data.get(0, Index);
            Sum += LastData;
            PointCount++;
            data.set(0, Index, Sum / PointCount);
            if(PointCount == (double)Order)
                break;
        }

        FirstIndex = Index + 1;
        for(Index = FirstIndex; Index <= LastIndex; Index++)
            if(!isEmpty(Index))
            {
                Sum -= LastData;
                LastData = data.get(0, Index);
                Sum += LastData;
                data.set(0, Index, Sum / (double)Order);
            }

    }

    public TimeSeries lag(int Periods)
    {
        TimeSeries lag = new TimeSeries();
        int index = 0;
        for(int i = 0; i < Periods; i++)
            index = getNextIndex(index);

        for(; index != -1; index = getNextIndex(index))
        {
            int prev = index;
            for(int i = 0; i < Periods; i++)
                prev = getPrevIndex(prev);

            for(int k = 0; k < dimension; k++)
                lag.add(getDate(index), getData(prev, k), k);

        }

        return lag;
    }

    public TimeSeries lead(int Periods)
    {
        TimeSeries lead = new TimeSeries();
        int index = getLastIndex();
        for(int i = 0; i < Periods; i++)
            index = getPrevIndex(index);

        int stopat = index;
        index = 0;
        int next = 0;
        for(; index <= stopat; index = getNextIndex(index))
        {
            next = index;
            for(int i = 0; i < Periods; i++)
                next = getNextIndex(next);

            for(int k = 0; k < dimension; k++)
                lead.add(getDate(index), getData(next, k), k);

        }

        return lead;
    }

    public String getKind()
    {
        return null;
    }

    public TimeSeries clone()
    {
        TimeSeries timeSeries = new TimeSeries();
        timeSeries.clear();
        timeSeries.size = size;
        timeSeries.data = new Matrix(dimension, size);
        for(int rowCount = 0; rowCount < dimension; rowCount++)
        {
            for(int i = 0; i < size; i++)
                timeSeries.data.set(rowCount, i, data.get(rowCount, i));

        }

        timeSeries.frequency = frequency;
        timeSeries.setLowerBoundDate(getLowerBoundDate());
        timeSeries.setUpperBoundDate(getUpperBoundDate());
        timeSeries.setLowerRangeDate(getLowerRangeDate());
        timeSeries.setUpperRangeDate(getUpperRangeDate());
        timeSeries.initialSize = initialSize;
        timeSeries.expansion = expansion;
        timeSeries.dimension = dimension;
        timeSeries.lengthsArray = lengthsArray;
        timeSeries.minimum = minimum;
        timeSeries.maximum = maximum;
        timeSeries.mean = mean;
        timeSeries.variance = variance;
        timeSeries.option = option;
        timeSeries.correlationPairs = correlationPairs;
        if(minimum != null)
        {
            timeSeries.minimum = new double[minimum.length];
            for(int i = 0; i < minimum.length; i++)
                timeSeries.minimum[i] = minimum[i];

        }
        if(maximum != null)
        {
            timeSeries.maximum = new double[maximum.length];
            for(int i = 0; i < maximum.length; i++)
                timeSeries.maximum[i] = maximum[i];

        }
        if(mean != null)
        {
            timeSeries.mean = new double[mean.length];
            for(int i = 0; i < mean.length; i++)
                timeSeries.mean[i] = mean[i];

        }
        if(variance != null)
        {
            timeSeries.variance = new double[variance.length];
            for(int i = 0; i < variance.length; i++)
                timeSeries.variance[i] = variance[i];

        }
        if(asymmetry != null)
        {
            timeSeries.asymmetry = new double[asymmetry.length];
            for(int i = 0; i < asymmetry.length; i++)
                timeSeries.asymmetry[i] = asymmetry[i];

        }
        if(excess != null)
        {
            timeSeries.excess = new double[excess.length];
            for(int i = 0; i < excess.length; i++)
                timeSeries.excess[i] = excess[i];

        }
        return timeSeries;
    }

    public TimeSeries plus(double data)
    {
        for(int i = getLowerBoundIndex(); i <= getUpperBoundIndex(); i++)
            if(!isEmpty(i))
                this.data.set(0, i, this.data.get(0, i) + data);

        minimum[0] += data;
        maximum[0] += data;
        mean[0] += data;
        return this;
    }

    public TimeSeries minus(double data)
    {
        for(int i = getLowerBoundIndex(); i <= getUpperBoundIndex(); i++)
            if(!isEmpty(i))
                this.data.set(0, i, this.data.get(0, i) - data);

        minimum[0] -= data;
        maximum[0] -= data;
        mean[0] -= data;
        return this;
    }

    public TimeSeries times(double data)
    {
        for(int i = getLowerBoundIndex(); i <= getUpperBoundIndex(); i++)
            if(!isEmpty(i))
                this.data.set(0, i, this.data.get(0, i) * data);

        minimum[0] *= data;
        maximum[0] *= data;
        mean[0] *= data;
        variance[0] *= data * data;
        return this;
    }

    public TimeSeries divided(double data)
    {
        for(int i = getLowerBoundIndex(); i <= getUpperBoundIndex(); i++)
            if(!isEmpty(i))
                this.data.set(0, i, this.data.get(0, i) / data);

        minimum[0] /= data;
        maximum[0] /= data;
        mean[0] /= data;
        variance[0] /= data * data;
        return this;
    }

    public Matrix getData()
    {
        return data;
    }

    public double getStandardError()
    {
        return getStandardError(0);
    }

    public double getAsymmetry()
    {
        return getAsimmetry(0);
    }

    public NumericalRecipesSeries asRecipes()
    {
        NumericalRecipesSeries series = new NumericalRecipesSeries();
        int size = lengthsArray[0];
        series.setData(Util.vector(1, size));
        series.setDates(Util.datesvector(1, size));
        int j = 1;
        for(int i = getLowerBoundIndex(); i <= getUpperBoundIndex(); i++)
            if(!isEmpty(i))
            {
                series.setValue(j, (float)data.get(0, i));
                getDate(i);
                series.setDate(j++, getDate(i));
            }

        return series;
    }

    public double[] toArray()
    {
        int size = lengthsArray[0];
        double vals[] = new double[size];
        int j = 0;
        for(int i = getLowerBoundIndex(); i <= getUpperBoundIndex(); i++)
            if(!isEmpty(i))
                vals[j++] = data.get(0, i);

        return vals;
    }

    public DateValue[] toDateValue()
    {
        int size = lengthsArray[0];
        DateValue vals[] = new DateValue[size];
        int j = 0;
        for(int i = getLowerBoundIndex(); i <= getUpperBoundIndex(); i++)
            if(!isEmpty(i))
            {
                DateValue dv = new DateValue();
                dv.setValue(data.get(0, i));
                dv.setDate(getDate(i));
                vals[j++] = dv;
                j++;
            }

        return vals;
    }

    public void toTimeSeries(double vals[])
    {
        int j = 0;
        for(int i = getLowerBoundIndex(); i <= getUpperBoundIndex(); i++)
            if(!isEmpty(i))
                data.set(0, j++, vals[i]);

    }

    public void printDates()
    {
        for(int i = getLowerBoundIndex(); i <= getUpperBoundIndex(); i++)
            if(!isEmpty(i))
                Util.debug((new StringBuilder()).append("i = ").append(getDate(i).toString()).toString());

    }

    public double[] getLastNData(int newSize)
    {
        double vals[] = new double[newSize];
        int n = vals.length;
        for(int i = getUpperBoundIndex(); n > 0; i--)
            if(!isEmpty(i))
            {
                vals[n - 1] = data.get(0, i);
                n--;
            }

        return vals;
    }

    public void copriLastNData(double vals[])
    {
        int n = vals.length;
        for(int i = getUpperBoundIndex(); n > 0; i--)
            if(!isEmpty(i))
            {
                set(i, vals[n - 1]);
                n--;
            }

    }

    public int getSize()
    {
        return size;
    }

    public void setSize(int size)
    {
        this.size = size;
    }

    public int getInitialSize()
    {
        return initialSize;
    }

    public void setInitialSize(int initialSize)
    {
        this.initialSize = initialSize;
    }

    public int getExpansion()
    {
        return expansion;
    }

    public void setExpansion(int expansion)
    {
        this.expansion = expansion;
    }

    public int getDimension()
    {
        return dimension;
    }

    public void setDimension(int dimension)
    {
        this.dimension = dimension;
    }

    public int[] getLengthsArray()
    {
        return lengthsArray;
    }

    public void setLengthsArray(int lengthsArray[])
    {
        this.lengthsArray = lengthsArray;
    }

    public double[] getMinimum()
    {
        return minimum;
    }

    public void setMinimum(double minimum[])
    {
        this.minimum = minimum;
    }

    public double[] getMaximum()
    {
        return maximum;
    }

    public void setMaximum(double maximum[])
    {
        this.maximum = maximum;
    }

    public int getCorrelationPairs()
    {
        return correlationPairs;
    }

    public void setCorrelationPairs(int correlationPairs)
    {
        this.correlationPairs = correlationPairs;
    }

    public volatile SearchablePojo clone()
    {
        return clone();
    }

    public volatile Object clone()
        throws CloneNotSupportedException
    {
        return clone();
    }

    private int frequency;
    private int option;
    private int size;
    private int initialSize;
    private int expansion;
    private int dimension;
    protected int lengthsArray[];
    public Matrix data;
    private double minimum[];
    private double maximum[];
    private double mean[];
    private double variance[];
    private double asymmetry[];
    private double excess[];
    private int correlationPairs;
    final long MILLISECONDS_DAY = 0x5265c00L;
}
