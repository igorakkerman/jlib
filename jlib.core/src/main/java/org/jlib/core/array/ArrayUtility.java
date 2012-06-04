package org.jlib.core.array;

/**
 * Utility for arrays.
 * 
 * @author Igor Akkerman
 */
public final class ArrayUtility {

    /** no visible constructor */
    private ArrayUtility() {}

    /**
     * Returns a new {@link Iterable} adapter for the specified array.
     * 
     * @param <Item>
     *        type of the items held in the array
     * 
     * @param items
     *        comma separated sequence of Items to traverse
     * 
     * @return {@link Iterable} adapter for {@code array}
     */
    @SafeVarargs
    public static <Item> Iterable<Item> iterable(final Item... items) {
        return new ArrayIterable<>(items);
    }
}
