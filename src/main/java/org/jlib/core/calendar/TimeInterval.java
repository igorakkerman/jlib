/*
 * jlib - The Free Java Library
 * 
 *    http://www.jlib.org
 *    
 * Copyright (c) 2006-2008 Igor Akkerman
 * 
 * jlib is distributed under the
 *
 *    COMMON PUBLIC LICENSE VERSION 1.0
 *
 *    http://www.opensource.org/licenses/cpl1.0.php
 */

package org.jlib.core.calendar;

import java.util.Calendar;

/**
 * Time interval in days, hours, minutes and seconds. Adding the interval to a
 * calendar adds all values to the calendar's current date.
 * 
 * @author Igor Akkerman
 */
public class TimeInterval {

    /**
     * Creates a new TimeInterval with no length.
     */
    public TimeInterval() {
        super();
    }

    /**
     * Creates a new TimeInterval with the specified length.
     * 
     * @param days
     *        number of days of this TimeInterval
     * @param hours
     *        number of hours of this TimeInterval
     * @param minutes
     *        number of minutes of this TimeInterval
     * @param seconds
     *        number of seconds of this TimeInterval
     */
    TimeInterval(int days, int hours, int minutes, int seconds) {
        super();
        this.days = days;
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    /** number of days */
    private int days;

    /** number of hours */
    private int hours;

    /** number of minutes */
    private int minutes;

    /** number of seconds */
    private int seconds;

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
        calendar.add(Calendar.DAY_OF_MONTH, days);
        calendar.add(Calendar.HOUR, hours);
        calendar.add(Calendar.MINUTE, minutes);
        calendar.add(Calendar.SECOND, seconds);
        return calendar;
    }

    /**
     * Returns the number of days of this TimeInterval.
     * 
     * @return integer specifying the number of days
     */
    public int getDays() {
        return days;
    }

    /**
     * Registers the number of days of this TimeInterval.
     * 
     * @param days
     *        integer specifying the days
     */
    public void setDays(int days) {
        this.days = days;
    }

    /**
     * Returns the number of hours of this TimeInterval.
     * 
     * @return integer specifying the number of hours
     */
    public int getHours() {
        return hours;
    }

    /**
     * Registers the number of hours of this TimeInterval.
     * 
     * @param hours
     *        integer specifying the number of hours
     */
    public void setHours(int hours) {
        this.hours = hours;
    }

    /**
     * Returns the minutes of this TimeInterval.
     * 
     * @return integer specifying the number of minutes
     */
    public int getMinutes() {
        return minutes;
    }

    /**
     * Registers the number of minutes of this TimeInterval.
     * 
     * @param minutes
     *        integer specifying the number of minutes
     */
    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    /**
     * Returns the number of seconds of this TimeInterval.
     * 
     * @return integer specifying the number of seconds
     */
    public int getSeconds() {
        return seconds;
    }

    /**
     * Registers the number of seconds of this TimeInterval.
     * 
     * @param seconds
     *        integer specifying the number of seconds
     */
    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    /**
     * Returns the overall number of seconds of this TimeInterval.
     * 
     * @return long integer specifying the overall number of seconds
     */
    public long overallSeconds() {
        return days * 86400 + hours * 3600 + minutes * 60 + seconds;
    }

    /**
     * Returns a String representation of this TimeInterval.
     * 
     * @return String containing all values of this TimeInterval
     */
    @Override
    public String toString() {
        return "TimeInterval[" + "days=" + days + ", " + "hours=" + hours + ", " + "minutes=" + minutes + ", "
               + "seconds=" + seconds + "]";
    }

    // @see java.lang.Object#equals(java.lang.Object)
    @Override
    public boolean equals(Object otherObject) {
        if (!(otherObject instanceof TimeInterval))
            return false;
        TimeInterval otherTimeInterval = (TimeInterval) otherObject;
        return otherTimeInterval.days == days && otherTimeInterval.hours == hours
               && otherTimeInterval.minutes == minutes && otherTimeInterval.seconds == seconds;
    }

    // @see java.lang.Object#hashCode()
    @Override
    public int hashCode() {
        return (int) overallSeconds();
    }
}
