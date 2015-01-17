package com.numhero.server.utils;

import org.junit.Test;

import java.util.Date;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class DateUtilsTest {
    @Test
    public void testGetDayOfYear() throws Exception {
        int d = DateUtils.getDayOfYear(DateUtils.fromYYYYMMDD("20101001"));
        assertThat(d, is(274));
        int d2 = DateUtils.getDayOfYear(DateUtils.fromYYYYMMDD("20091231"));
        assertThat(d2, is(365));
    }

    @Test
    public void testGetYear() throws Exception {
        int d = DateUtils.getYear(DateUtils.fromYYYYMMDD("20101001"));
        assertThat(d, is(2010));
    }

    @Test
    public void testGetWeekOfYear() throws Exception {
        int d = DateUtils.getWeekOfYear(DateUtils.fromYYYYMMDD("20101001"));
        assertThat(d, is(40));
    }

    @Test
    public void testGetMonth() throws Exception {
        int d = DateUtils.getMonth(DateUtils.fromYYYYMMDD("20101001"));
        assertThat(d, is(9));
    }

    @Test
    public void testfromYYYYMMDD() throws Exception {

        Date d = DateUtils.fromYYYYMMDD("20101010");
        assertThat(d.toString(), is("Sun Oct 10 00:00:00 CEST 2010"));
    }
}
