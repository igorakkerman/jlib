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

package org.jlib.core.text;

import java.util.Comparator;

/**
 * <p>
 * Comparator performing the comparison of two objects by comparing the lengths
 * of their String representations as returned by the {@code toString()} method.
 * Null String representations are assumed to have length -1.
 * </p>
 * <p>
 * Implemented as a singleton.
 * </p>
 * 
 * @param <ComparisonObject>
 *        type of the objects to compare
 * @author Igor Akkerman
 */
public class StringLengthComparator<ComparisonObject>
implements Comparator<ComparisonObject> {

    /** sole StringLengthComparator instance */
    private static final StringLengthComparator<?> INSTANCE = new StringLengthComparator<Object>();

    /**
     * Returns the sole StringLengthComparator instance.
     * @param <ComparisonObject>
     *        type of the objects to compare
     *
     * @return sole StringLengthComparator instance
     */
    @SuppressWarnings("unchecked")
    public static <ComparisonObject> StringLengthComparator<ComparisonObject> getInstance() {
        return (StringLengthComparator<ComparisonObject>) INSTANCE;
    }
    
    /**
     * Creates a new StringLengthComparator.
     */
    private StringLengthComparator() {
        super();
    }

    // @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
    @Override
    public int compare(ComparisonObject object1, ComparisonObject object2) {
        String string1 = object1.toString();
        String string2 = object2.toString();
        int string1Length = string1 != null ? string1.length() : -1;
        int string2Length = string2 != null ? string2.length() : -1;

        return string1Length - string2Length;
    }
}
