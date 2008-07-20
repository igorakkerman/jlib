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

package org.jlib.core.collections;

import java.util.HashSet;
import java.util.Set;

/**
 * Utility class providing methods operating on Collections.
 * 
 * @author Igor Akkerman
 */
public final class CollectionUtility {

    /** no visible constructor */
    private CollectionUtility() {}

    /**
     * Creates a Set containing the elements of the specified array.
     * 
     * @param <SetElement>
     *        type of the elements in the Set; super type of {@code
     *        <ArrayElement>}
     * @param <ArrayElement>
     *        type of the elements in the array
     * @param array
     *        the source array
     * @return Set containing the Elements of {@code array}
     */
    public static <SetElement, ArrayElement extends SetElement> Set<SetElement> asSet(ArrayElement[] array) {
        Set<SetElement> set = new HashSet<SetElement>(array.length);
        for (ArrayElement element : array)
            set.add(element);
        return set;
    }
}
