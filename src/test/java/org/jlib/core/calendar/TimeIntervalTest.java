/*
 * jlib - The Free Java Library
 * 
 * http://www.jlib.org
 * 
 * Copyright (c) 2006-2008 Igor Akkerman
 * 
 * jlib is distributed under the
 * 
 * COMMON PUBLIC LICENSE VERSION 1.0
 * 
 * http://www.opensource.org/licenses/cpl1.0.php
 */

package org.jlib.core.calendar;

import static junit.framework.Assert.assertEquals;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Test;

/**
 * JUnit test suite for TimeInterval. 
 *
 * @author Igor Akkerman
 */
public class TimeIntervalTest {
    private static final Calendar CALENDAR20070101 = new GregorianCalendar(2007, Calendar.JANUARY, 01);
    private static final Calendar CALENDAR20070301 = new GregorianCalendar(2007, Calendar.MARCH, 01);
    private static final Calendar CALENDAR20080101 = new GregorianCalendar(2008, Calendar.JANUARY, 01);
    private static final Calendar CALENDAR20080301 = new GregorianCalendar(2008, Calendar.MARCH, 01);
    private static final Calendar CALENDAR20090101 = new GregorianCalendar(2009, Calendar.JANUARY, 01);
    private static final Calendar CALENDAR20090301 = new GregorianCalendar(2009, Calendar.MARCH, 01);
    private static final TimeInterval ONE_YEAR = new TimeInterval(1, 0, 0, 0, 0, 0);
    private static final TimeInterval ONE_MONTH = new TimeInterval(0, 1, 0, 0, 0, 0);
    private static final TimeInterval ONE_DAY = new TimeInterval(0, 0, 1, 0, 0, 0);
    private static final TimeInterval THREESIXTYFIVE_DAYS = new TimeInterval(0, 0, 365, 0, 0, 0);
    private static final TimeInterval THREESIXTYSIX_DAYS = new TimeInterval(0, 0, 366, 0, 0, 0);
    private static final TimeInterval ONE_AND_A_HALF_YEARS = new TimeInterval(1, 6, 0, 0, 0, 0);

    @Test
    public void testOneYear1() {
        assertEquals(CALENDAR20080101, ONE_YEAR.addTo(CALENDAR20070101));
    }

    @Test
    public void testOneYear2() {
        assertEquals(CALENDAR20080301, ONE_YEAR.addTo(CALENDAR20070301));
    }

    @Test
    public void test365Days1() {
        assertEquals(CALENDAR20080101, THREESIXTYFIVE_DAYS.addTo(CALENDAR20070101));
    }

    @Test
    public void test366Days1() {
        assertEquals(CALENDAR20080301, THREESIXTYSIX_DAYS.addTo(CALENDAR20070301));
    }

    @Test
    public void testLeapYear() {
        assertEquals(CALENDAR20090101, ONE_YEAR.addTo(CALENDAR20080101));
    }
}
