// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   UtilDateTime.java

package com.dtmc.server.analytics.util;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class UtilDateTime
{

    public UtilDateTime()
    {
    }

    public static Timestamp nowTimestamp()
    {
        return new Timestamp(System.currentTimeMillis());
    }

    public static String nowDateString()
    {
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        return df.format(new Date());
    }

    public static Date nowDate()
    {
        return new Date();
    }

    public static Timestamp getDayStart(Timestamp stamp)
    {
        return getDayStart(stamp, 0);
    }

    public static Timestamp getDayStart(Timestamp stamp, int daysLater)
    {
        Calendar tempCal = Calendar.getInstance();
        tempCal.setTime(new Date(stamp.getTime()));
        tempCal.set(tempCal.get(1), tempCal.get(2), tempCal.get(5), 0, 0, 0);
        tempCal.add(5, daysLater);
        Timestamp retStamp = new Timestamp(tempCal.getTime().getTime());
        retStamp.setNanos(0);
        return retStamp;
    }

    public static Timestamp getNextDayStart(Timestamp stamp)
    {
        return getDayStart(stamp, 1);
    }

    public static Timestamp getDayEnd(Timestamp stamp)
    {
        return getDayEnd(stamp, 0);
    }

    public static Timestamp getDayEnd(Timestamp stamp, int daysLater)
    {
        Calendar tempCal = Calendar.getInstance();
        tempCal.setTime(new Date(stamp.getTime()));
        tempCal.set(tempCal.get(1), tempCal.get(2), tempCal.get(5), 23, 59, 59);
        tempCal.add(5, daysLater);
        Timestamp retStamp = new Timestamp(tempCal.getTime().getTime());
        retStamp.setNanos(0x3b9ac9ff);
        return retStamp;
    }

    public static Timestamp getMonthStart(Timestamp stamp)
    {
        return getMonthStart(stamp, 0);
    }

    public static Timestamp getMonthStart(Timestamp stamp, int daysLater)
    {
        Calendar tempCal = Calendar.getInstance();
        tempCal.setTime(new Date(stamp.getTime()));
        tempCal.set(tempCal.get(1), tempCal.get(2), 1, 0, 0, 0);
        tempCal.add(5, daysLater);
        Timestamp retStamp = new Timestamp(tempCal.getTime().getTime());
        retStamp.setNanos(0);
        return retStamp;
    }

    public static Timestamp getWeekStart(Timestamp stamp)
    {
        return getWeekStart(stamp, 0);
    }

    public static Timestamp getWeekStart(Timestamp stamp, int daysLater)
    {
        Calendar tempCal = Calendar.getInstance();
        tempCal.setTime(new Date(stamp.getTime()));
        tempCal.set(tempCal.get(1), tempCal.get(2), tempCal.get(5), 0, 0, 0);
        tempCal.add(5, daysLater);
        tempCal.set(7, tempCal.getFirstDayOfWeek());
        Timestamp retStamp = new Timestamp(tempCal.getTime().getTime());
        retStamp.setNanos(0);
        return retStamp;
    }

    public static java.sql.Date toSqlDate(String date)
    {
        Date newDate = toDate(date, "00:00:00");
        if(newDate != null)
            return new java.sql.Date(newDate.getTime());
        else
            return null;
    }

    public static java.sql.Date toSqlDate(String monthStr, String dayStr, String yearStr)
    {
        Date newDate = toDate(monthStr, dayStr, yearStr, "0", "0", "0");
        if(newDate != null)
            return new java.sql.Date(newDate.getTime());
        else
            return null;
    }

    public static java.sql.Date toSqlDate(int month, int day, int year)
    {
        Date newDate = toDate(month, day, year, 0, 0, 0);
        if(newDate != null)
            return new java.sql.Date(newDate.getTime());
        else
            return null;
    }

    public static Time toSqlTime(String time)
    {
        Date newDate = toDate("1/1/1970", time);
        if(newDate != null)
            return new Time(newDate.getTime());
        else
            return null;
    }

    public static Time toSqlTime(String hourStr, String minuteStr, String secondStr)
    {
        Date newDate = toDate("0", "0", "0", hourStr, minuteStr, secondStr);
        if(newDate != null)
            return new Time(newDate.getTime());
        else
            return null;
    }

    public static Time toSqlTime(int hour, int minute, int second)
    {
        Date newDate = toDate(0, 0, 0, hour, minute, second);
        if(newDate != null)
            return new Time(newDate.getTime());
        else
            return null;
    }

    public static Timestamp toTimestamp(String dateTime)
    {
        Date newDate = toDate(dateTime);
        if(newDate != null)
            return new Timestamp(newDate.getTime());
        else
            return null;
    }

    public static Timestamp toTimestamp(String date, String time)
    {
        Date newDate = toDate(date, time);
        if(newDate != null)
            return new Timestamp(newDate.getTime());
        else
            return null;
    }

    public static Timestamp toTimestamp(String monthStr, String dayStr, String yearStr, String hourStr, String minuteStr, String secondStr)
    {
        Date newDate = toDate(monthStr, dayStr, yearStr, hourStr, minuteStr, secondStr);
        if(newDate != null)
            return new Timestamp(newDate.getTime());
        else
            return null;
    }

    public static Timestamp toTimestamp(int month, int day, int year, int hour, int minute, int second)
    {
        Date newDate = toDate(month, day, year, hour, minute, second);
        if(newDate != null)
            return new Timestamp(newDate.getTime());
        else
            return null;
    }

    public static Date toDate(String dateTime)
    {
        String date = dateTime.substring(0, dateTime.indexOf(" "));
        String time = dateTime.substring(dateTime.indexOf(" ") + 1);
        return toDate(date, time);
    }

    public static Date toDate(String date, String time)
    {
        if(date == null || time == null)
            return null;
        int dateSlash1 = date.indexOf("/");
        int dateSlash2 = date.lastIndexOf("/");
        if(dateSlash1 <= 0 || dateSlash1 == dateSlash2)
            return null;
        int timeColon1 = time.indexOf(":");
        int timeColon2 = time.lastIndexOf(":");
        if(timeColon1 <= 0)
            return null;
        String month = date.substring(0, dateSlash1);
        String day = date.substring(dateSlash1 + 1, dateSlash2);
        String year = date.substring(dateSlash2 + 1);
        String hour = time.substring(0, timeColon1);
        String minute;
        String second;
        if(timeColon1 == timeColon2)
        {
            minute = time.substring(timeColon1 + 1);
            second = "0";
        } else
        {
            minute = time.substring(timeColon1 + 1, timeColon2);
            second = time.substring(timeColon2 + 1);
        }
        return toDate(month, day, year, hour, minute, second);
    }

    public static Date toDate(String monthStr, String dayStr, String yearStr, String hourStr, String minuteStr, String secondStr)
    {
        int month;
        int day;
        int year;
        int hour;
        int minute;
        int second;
        try
        {
            month = Integer.parseInt(monthStr);
            day = Integer.parseInt(dayStr);
            year = Integer.parseInt(yearStr);
            hour = Integer.parseInt(hourStr);
            minute = Integer.parseInt(minuteStr);
            second = Integer.parseInt(secondStr);
        }
        catch(Exception e)
        {
            return null;
        }
        return toDate(month, day, year, hour, minute, second);
    }

    public static Date toDate(int month, int day, int year, int hour, int minute, int second)
    {
        Calendar calendar = Calendar.getInstance();
        try
        {
            calendar.set(year, month - 1, day, hour, minute, second);
        }
        catch(Exception e)
        {
            return null;
        }
        return new Date(calendar.getTime().getTime());
    }

    public static String toDateString(Date date)
    {
        if(date == null)
            return "";
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int month = calendar.get(2) + 1;
        int day = calendar.get(5);
        int year = calendar.get(1);
        String monthStr;
        if(month < 10)
            monthStr = (new StringBuilder()).append("0").append(month).toString();
        else
            monthStr = (new StringBuilder()).append("").append(month).toString();
        String dayStr;
        if(day < 10)
            dayStr = (new StringBuilder()).append("0").append(day).toString();
        else
            dayStr = (new StringBuilder()).append("").append(day).toString();
        String yearStr = (new StringBuilder()).append("").append(year).toString();
        return (new StringBuilder()).append(monthStr).append("/").append(dayStr).append("/").append(yearStr).toString();
    }

    public static String toTimeString(Date date)
    {
        if(date == null)
        {
            return "";
        } else
        {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            return toTimeString(calendar.get(11), calendar.get(12), calendar.get(13));
        }
    }

    public static String toTimeString(int hour, int minute, int second)
    {
        String hourStr;
        if(hour < 10)
            hourStr = (new StringBuilder()).append("0").append(hour).toString();
        else
            hourStr = (new StringBuilder()).append("").append(hour).toString();
        String minuteStr;
        if(minute < 10)
            minuteStr = (new StringBuilder()).append("0").append(minute).toString();
        else
            minuteStr = (new StringBuilder()).append("").append(minute).toString();
        String secondStr;
        if(second < 10)
            secondStr = (new StringBuilder()).append("0").append(second).toString();
        else
            secondStr = (new StringBuilder()).append("").append(second).toString();
        if(second == 0)
            return (new StringBuilder()).append(hourStr).append(":").append(minuteStr).toString();
        else
            return (new StringBuilder()).append(hourStr).append(":").append(minuteStr).append(":").append(secondStr).toString();
    }

    public static String toDateTimeString(Date date)
    {
        if(date == null)
            return "";
        String dateString = toDateString(date);
        String timeString = toTimeString(date);
        if(dateString != null && timeString != null)
            return (new StringBuilder()).append(dateString).append(" ").append(timeString).toString();
        else
            return "";
    }

    public static Timestamp monthBegin()
    {
        Calendar mth = Calendar.getInstance();
        mth.set(5, 1);
        mth.set(11, 0);
        mth.set(12, 0);
        mth.set(13, 0);
        mth.set(9, 0);
        return new Timestamp(mth.getTime().getTime());
    }
}
