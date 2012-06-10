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

    /**
     * Returns the total number of non array items held in the specified array,
     * recursively descending in every array item.
     * 
     * @param items
     *        comma separated sequence of {@link Object} items
     * 
     * @return integer specifying the total number of items
     */
    public static int getItemsCount(final Object... items) {
        int itemsCount = 0;

        for (final Object item : items)
            itemsCount += item.getClass().isArray()
                ? getItemsCount((Object[]) item)
                : 1;

        return itemsCount;
    }
}
