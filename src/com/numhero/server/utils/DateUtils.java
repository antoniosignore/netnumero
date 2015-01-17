package com.numhero.server.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtils {

    public static int getDayOfYear(Date date) {
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(date);
        return cal.get(Calendar.DAY_OF_YEAR);
    }

    public static int getYear(Date date) {
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(date);
        return cal.get(Calendar.YEAR);
    }

    public static int getWeekOfYear(Date date) {
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(date);
        return cal.get(Calendar.WEEK_OF_YEAR);
    }

    public static int getMonthOfYear(Date date) {
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(date);
        return cal.get(Calendar.MONTH);
    }

    public static Date fromString(String value) {
        GregorianCalendar cal = new GregorianCalendar();
        try {
            return DateFormat.getDateInstance().parse(value);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static Date fromYYYYMMDD(String value) {
        GregorianCalendar cal = new GregorianCalendar();
        try {
            return new SimpleDateFormat("yyyyMMdd").parse(value);
        } catch (ParseException e) {
            return null;
        }
    }

    public static Date firstQuarterStartDate(Integer year) {
        GregorianCalendar cal = new GregorianCalendar();
        cal.set(Calendar.MONTH, 0);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.HOUR, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        cal.set(Calendar.AM_PM, Calendar.AM);
        return cal.getTime();
    }

    public static Date firstQuarterEndDate(Integer year) {
        GregorianCalendar cal = new GregorianCalendar();
        cal.set(Calendar.MONTH, 2);
        cal.set(Calendar.DAY_OF_MONTH, 31);
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.HOUR, 11);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.AM_PM, Calendar.PM);
        return cal.getTime();
    }

    public static Date secondQuarterStartDate(Integer year) {
        GregorianCalendar cal = new GregorianCalendar();
        cal.set(Calendar.MONTH, 3);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.HOUR, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        cal.set(Calendar.AM_PM, Calendar.AM);
        return cal.getTime();
    }

    public static Date secondQuarterEndDate(Integer year) {
        GregorianCalendar cal = new GregorianCalendar();
        cal.set(Calendar.MONTH, 5);
        cal.set(Calendar.DAY_OF_MONTH, 30);
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.HOUR, 11);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.AM_PM, Calendar.PM);
        return cal.getTime();
    }

    public static Date thirdQuarterStartDate(Integer year) {
        GregorianCalendar cal = new GregorianCalendar();
        cal.set(Calendar.MONTH, 6);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.HOUR, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        cal.set(Calendar.AM_PM, Calendar.AM);
        return cal.getTime();
    }

    public static Date thirdQuarterEndDate(Integer year) {
        GregorianCalendar cal = new GregorianCalendar();
        cal.set(Calendar.MONTH, 8);
        cal.set(Calendar.DAY_OF_MONTH, 30);
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.HOUR, 11);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.AM_PM, Calendar.PM);
        return cal.getTime();
    }

    public static Date fourthQuarterStartDate(Integer year) {
        GregorianCalendar cal = new GregorianCalendar();
        cal.set(Calendar.MONTH, 9);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.HOUR, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        cal.set(Calendar.AM_PM, Calendar.AM);
        return cal.getTime();
    }

    public static Date fourthQuarterEndDate(Integer year) {
        GregorianCalendar cal = new GregorianCalendar();
        cal.set(Calendar.MONTH, 11);
        cal.set(Calendar.DAY_OF_MONTH, 31);
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.HOUR, 11);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.AM_PM, Calendar.PM);
        return cal.getTime();
    }

    public static Integer getCurrentYear() {
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(new Date());
        return cal.get(Calendar.YEAR);
    }

    public static Integer getMonth(Date date) {
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(date);
        return cal.get(Calendar.MONTH);
    }

    public static Date getStartOfDay(Date day) {
        if (day == null)
            return null;
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(day);
        cal.set(Calendar.HOUR, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        cal.set(Calendar.AM_PM, Calendar.AM);
        return cal.getTime();
    }

    public static Date getEndOfDay(Date day) {
        if (day == null)
            return null;
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(day);
        cal.set(Calendar.HOUR, 11);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.AM_PM, Calendar.PM);
        return cal.getTime();
    }

    public static Date getFirstDayMonth(Date date) {
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.HOUR, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        cal.set(Calendar.AM_PM, Calendar.AM);
        return cal.getTime();
    }

    public static Date getStartPreviousMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) - 1);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.HOUR, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        cal.set(Calendar.AM_PM, Calendar.AM);
        return cal.getTime();
    }

    public static void main(String[] args) {
        System.out.println("args = " + DateUtils.firstQuarterStartDate(2010));
        System.out.println("args = " + DateUtils.firstQuarterEndDate(2010));

        System.out.println("args = " + DateUtils.secondQuarterStartDate(2010));
        System.out.println("args = " + DateUtils.secondQuarterEndDate(2010));

        System.out.println("args = " + DateUtils.thirdQuarterStartDate(2010));
        System.out.println("args = " + DateUtils.thirdQuarterEndDate(2010));

        System.out.println("args = " + DateUtils.fourthQuarterStartDate(2010));
        System.out.println("args = " + DateUtils.fourthQuarterEndDate(2010));


        Date d = getStartPreviousMonth(new Date());

        d = getStartPreviousMonth(d);
        System.out.println("d = " + d);

        d = getStartPreviousMonth(d);
        System.out.println("d = " + d);

        d = getStartPreviousMonth(d);
        System.out.println("d = " + d);

        d = getStartPreviousMonth(d);
        System.out.println("d = " + d);

        d = getStartPreviousMonth(d);
        System.out.println("d = " + d);

        d = getStartPreviousMonth(d);
        System.out.println("d = " + d);

        d = getStartPreviousMonth(d);
        System.out.println("d = " + d);

        d = getStartPreviousMonth(d);
        System.out.println("d = " + d);

        d = getStartPreviousMonth(d);
        System.out.println("d = " + d);

        d = getStartPreviousMonth(d);
        System.out.println("d = " + d);

        d = getStartPreviousMonth(d);
        System.out.println("d = " + d);

        d = getStartPreviousMonth(d);
        System.out.println("d = " + d);


    }
}
