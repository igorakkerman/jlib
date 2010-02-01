/*
 * jlib - The Free Java Library
 * 
 *     http://www.jlib.org
 * 
 * Copyright (c) 2006-2008 Igor Akkerman
 * 
 * jlib is distributed under the
 * 
 *     COMMON PUBLIC LICENSE VERSION 1.0
 * 
 * http://www.opensource.org/licenses/cpl1.0.php
 */

// TODO: Review

package org.jlib.core.calendar;

import java.util.Calendar;

/**
 * Time interval in years, months, days, hours, minutes and seconds. Adding the
 * interval to a calendar adds all values to the calendar's date.
 * 
 * @author Igor Akkerman
 */
public class TimeInterval {

    /** number of seconds per minute */
    public static final int SECONDS_PER_MINUTE = 60;

    /** number of minutes per hour */
    public static final int MINUTES_PER_HOUR = 60;

    /** number of hours per day */
    public static final int HOURS_PER_DAY = 24;

    /**
     * number of days per month as used for the comparison of two time intervals
     */
    public static final int DAYS_PER_MONTH = 30;

    /** number of months per year */
    public static final int MONTHS_PER_YEAR = 12;

    /** number of seconds per hour */
    public static final int SECONDS_PER_HOUR = SECONDS_PER_MINUTE * MINUTES_PER_HOUR;

    /** number of seconds per day */
    public static final int SECONDS_PER_DAY = SECONDS_PER_HOUR * HOURS_PER_DAY;

    /**
     * number of seconds per month as used for the comparison of two time
     * intervals
     */
    public static final int SECONDS_PER_MONTH = SECONDS_PER_DAY * DAYS_PER_MONTH;

    /**
     * number of seconds per year as used for the comparison of two time
     * intervals
     */
    public static final int SECONDS_PER_YEAR = SECONDS_PER_MONTH * MONTHS_PER_YEAR;

    /** number of years */
    private int years;

    /** number of months */
    private int months;

    /** number of days */
    private int days;

    /** number of hours */
    private int hours;

    /** number of minutes */
    private int minutes;

    /** number of seconds */
    private int seconds;

    /**
     * Creates a new TimeInterval with no length.
     */
    public TimeInterval() {
        super();
    }

    /**
     * Creates a new TimeInterval with the specified length.
     * 
     * @param years
     *        integer specifying the number of years of this TimeInterval
     * @param months
     *        integer specifying the number of months of this TimeInterval
     * @param days
     *        integer specifying the number of days of this TimeInterval
     */
    public TimeInterval(int years, int months, int days) {
        super();
        this.years = years;
        this.months = months;
        this.days = days;
    }

    /**
     * Creates a new TimeInterval with the specified length.
     * 
     * @param years
     *        integer specifying the number of years of this TimeInterval
     * @param months
     *        integer specifying the number of months of this TimeInterval
     * @param days
     *        integer specifying the number of days of this TimeInterval
     * @param hours
     *        integer specifying the number of hours of this TimeInterval
     * @param minutes
     *        integer specifying the number of minutes of this TimeInterval
     * @param seconds
     *        integer specifying the number of seconds of this TimeInterval
     */
    public TimeInterval(int years, int months, int days, int hours, int minutes, int seconds) {
        this(years, months, days);
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    /**
     * Adds this TimeInterval to the date of the specified Calendar. The
     * specified calendar is left unchanged within the operation. A new {@code
     * Calendar} instance with the new date is returned.
     * 
     * @param calendar
     *        Calendar to add this TimeInterval to; the specified Calendar is
     *        left unchanged during the operation
     * @return new Calendar with the new date
     */
    public Calendar addTo(Calendar calendar) {
        calendar = (Calendar) calendar.clone();
        calendar.add(Calendar.YEAR, years);
        calendar.add(Calendar.MONTH, months);
        calendar.add(Calendar.DAY_OF_MONTH, days);
        calendar.add(Calendar.HOUR, hours);
        calendar.add(Calendar.MINUTE, minutes);
        calendar.add(Calendar.SECOND, seconds);
        return calendar;
    }

    /**
     * Returns the years of this TimeInterval.
     * 
     * @return integer specifying the number of years
     */
    public int getYears() {
        return years;
    }

    /**
     * Registers the years of this TimeInterval.
     * 
     * @param years
     *        integer specifying the number of years
     */
    public void setYears(int years) {
        this.years = years;
    }

    /**
     * Returns the months of this TimeInterval.
     * 
     * @return integer specifying the number of months
     */
    public int getMonths() {
        return months;
    }

    /**
     * Registers the months of this TimeInterval.
     * 
     * @param months
     *        integer specifying the number of months
     */
    public void setMonths(int months) {
        this.months = months;
    }

    /**
     * Returns the number of days of this TimeInterval.
     * 
     * @return integer specifying the number of number of days
     */
    public int getDays() {
        return days;
    }

    /**
     * Registers the number of days of this TimeInterval.
     * 
     * @param days
     *        integer specifying the number of days
     */
    public void setDays(int days) {
        this.days = days;
    }

    /**
     * Returns the number of hours of this TimeInterval.
     * 
     * @return integer specifying the number of number of hours
     */
    public int getHours() {
        return hours;
    }

    /**
     * Registers the number of hours of this TimeInterval.
     * 
     * @param hours
     *        integer specifying the number of number of hours
     */
    public void setHours(int hours) {
        this.hours = hours;
    }

    /**
     * Returns the minutes of this TimeInterval.
     * 
     * @return integer specifying the number of number of minutes
     */
    public int getMinutes() {
        return minutes;
    }

    /**
     * Registers the number of minutes of this TimeInterval.
     * 
     * @param minutes
     *        integer specifying the number of number of minutes
     */
    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    /**
     * Returns the number of seconds of this TimeInterval.
     * 
     * @return integer specifying the number of number of seconds
     */
    public int getSeconds() {
        return seconds;
    }

    /**
     * Registers the number of seconds of this TimeInterval.
     * 
     * @param seconds
     *        integer specifying the number of number of seconds
     */
    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    /**
     * Returns a String representation of this TimeInterval.
     * 
     * @return String containing all values of this TimeInterval
     */
    @Override
    public String toString() {
        return "TimeInterval[" + "years=" + years + ", " + "months=" + months + "days=" + days + ", " + "hours=" +
               hours + ", " + "minutes=" + minutes + ", " + "seconds=" + seconds + "]";
    }

    /**
     * Returns the overall number of seconds of this TimeInterval. The number of
     * days per month is assumed to be {@value #DAYS_PER_MONTH}.
     * 
     * @return long integer specifying the overall number of seconds of this
     *         TimeInterval
     */
    public long getOverallSeconds() {
        return years * SECONDS_PER_YEAR + months * SECONDS_PER_MONTH + days * SECONDS_PER_DAY + hours *
               SECONDS_PER_HOUR + minutes * SECONDS_PER_MINUTE + seconds;
    }

    /**
     * Compares the specified Object to this TimeInterval.
     * 
     * @param otherObject
     *        Object to compare to this TimeInterval
     * 
     * @return {@code true} if the specified Object is an instance of
     *         TimeInterval and the {@link #getOverallSeconds()} methods of both
     *         TimeIntervals return the same value; {@code false} otherwise
     */
    @Override
    public boolean equals(Object otherObject) {
        if (!(otherObject instanceof TimeInterval))
            return false;
        TimeInterval otherTimeInterval = (TimeInterval) otherObject;
        return getOverallSeconds() == otherTimeInterval.getOverallSeconds();
    }

    // @see java.lang.Object#hashCode()
    @Override
    public int hashCode() {
        return (int) getOverallSeconds();
    }
}
