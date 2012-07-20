package org.jlib.core.math;

/**
 * Utility providing mathematical operations.
 * 
 * @author Igor Akkerman
 */
public final class MathUtility {

    /** no visible constructor */
    private MathUtility() {}

    /**
     * Returns the number of numbers between a minimum and a maximum number,
     * both inclusive.
     * 
     * @param minimum
     *        integer specifying the minimum number
     * 
     * @param maximum
     *        integer specifying the maximum number
     * 
     * @return {@code maximum - minimum + 1}
     */
    public static int count(final int minimum, final int maximum) {
        return maximum - minimum + 1;
    }
}
