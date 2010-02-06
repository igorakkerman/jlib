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
 * Time interval in years, months, daysCount, hoursCount, minutesCount and
 * secondsCount. Adding the interval to a calendar adds all values to the
 * calendar's date.
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

    /** number of seconds per hour */
    public static final int SECONDS_PER_HOUR = SECONDS_PER_MINUTE * MINUTES_PER_HOUR;

    /** number of seconds per day */
    public static final int SECONDS_PER_DAY = SECONDS_PER_HOUR * HOURS_PER_DAY;

    /** number of days */
    private int daysCount;

    /** number of hours */
    private int hoursCount;

    /** number of minutes */
    private int minutesCount;

    /** number of seconds */
    private int secondsCount;

    /**
     * Creates a new TimeInterval with no length.
     */
    public TimeInterval() {
        super();
    }

    /**
     * Creates a new TimeInterval specified by the number of days.
     * 
     * @param daysCount
     *        integer specifying the number of days of this TimeInterval
     */
    public TimeInterval(int daysCount) {
        this();
        this.daysCount = daysCount;
    }

    /**
     * Creates a new TimeInterval with the specified length.
     * 
     * @param daysCount
     *        integer specifying the number of days of this TimeInterval
     * @param hoursCount
     *        integer specifying the number of hours of this TimeInterval
     * @param minutesCount
     *        integer specifying the number of minutes of this TimeInterval
     * @param secondsCount
     *        integer specifying the number of seconds of this TimeInterval
     */
    public TimeInterval(int daysCount, int hoursCount, int minutesCount, int secondsCount) {
        this(daysCount);
        this.hoursCount = hoursCount;
        this.minutesCount = minutesCount;
        this.secondsCount = secondsCount;
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
        calendar.add(Calendar.DAY_OF_MONTH, daysCount);
        calendar.add(Calendar.HOUR, hoursCount);
        calendar.add(Calendar.MINUTE, minutesCount);
        calendar.add(Calendar.SECOND, secondsCount);
        return calendar;
    }

    /**
     * Returns the number of days of this TimeInterval.
     * 
     * @return integer specifying the number of number of days
     */
    public int getDaysCount() {
        return daysCount;
    }

    /**
     * Registers the number of days of this TimeInterval.
     * 
     * @param daysCount
     *        integer specifying the number of days
     */
    public void setDaysCount(int daysCount) {
        this.daysCount = daysCount;
    }

    /**
     * Returns the number of hours of this TimeInterval.
     * 
     * @return integer specifying the number of number of hours
     */
    public int getHours() {
        return hoursCount;
    }

    /**
     * Registers the number of hours of this TimeInterval.
     * 
     * @param hoursCount
     *        integer specifying the number of number of hours
     */
    public void setHoursCount(int hoursCount) {
        this.hoursCount = hoursCount;
    }

    /**
     * Returns the number of minutes of this TimeInterval.
     * 
     * @return integer specifying the number of number of minutes
     */
    public int getMinutesCount() {
        return minutesCount;
    }

    /**
     * Registers the number of minutes of this TimeInterval.
     * 
     * @param minutesCount
     *        integer specifying the number of number of minutes
     */
    public void setMinutesCount(int minutesCount) {
        this.minutesCount = minutesCount;
    }

    /**
     * Returns the number of seconds of this TimeInterval.
     * 
     * @return integer specifying the number of number of seconds
     */
    public int getSecondsCount() {
        return secondsCount;
    }

    /**
     * Registers the number of seconds of this TimeInterval.
     * 
     * @param secondsCount
     *        integer specifying the number of number of seconds
     */
    public void setSecondsCount(int secondsCount) {
        this.secondsCount = secondsCount;
    }

    /**
     * Returns a String representation of this TimeInterval.
     * 
     * @return String containing all values of this TimeInterval
     */
    @Override
    public String toString() {
        return "TimeInterval[" + "daysCount=" + daysCount + ", " + "hoursCount=" + hoursCount + ", " + "minutesCount=" +
               minutesCount + ", " + "secondsCount=" + secondsCount + "]";
    }

    /**
     * Returns the overall number of seconds of this TimeInterval.
     * 
     * @return long integer specifying the overall number of seconds of this
     *         TimeInterval
     */
    public long getOverallSeconds() {
        return daysCount * SECONDS_PER_DAY + hoursCount * SECONDS_PER_HOUR + minutesCount * SECONDS_PER_MINUTE +
               secondsCount;
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
