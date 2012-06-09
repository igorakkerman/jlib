package org.jlib.core.iterator;

import java.util.Iterator;

/**
 * {@link Iterator} utility.
 * 
 * @author Igor Akkerman
 */
public final class IteratorUtility {

    /** no visible constructor */
    private IteratorUtility() {}

    /**
     * Returns the number of Items provided by the specified {@link Iterable}.
     * 
     * @param items
     *        {@link Iterator} providing the items
     * 
     * @return integer specifying the number of Items
     */
    public static int getItemsCount(final Iterable<?> items) {
        int itemsCount = 0;

        // @formatter:off
        for (@SuppressWarnings("unused")
                 final Object item : items)
            itemsCount ++;

        return itemsCount;

        // @formatter:on
    }

    /**
     * Returns the sum of number of Items provided by the specified
     * {@link Iterable} instances.
     * 
     * @param iterables
     *        comma separated sequence of {@link Iterator} instances
     * 
     * @return integer specifying the number of Items
     */
    public static int getItemsCount(final Iterable<?>... iterables) {
        int itemsCount = 0;

        // @formatter:off
        for (final Iterable<?> iterable : iterables)
            itemsCount += getItemsCount(iterable);
        
        return itemsCount;
        
        // @formatter:on
    }
}
