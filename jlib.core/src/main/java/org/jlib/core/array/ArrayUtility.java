package org.jlib.core.array;

import java.util.ArrayList;
import java.util.List;

import org.jlib.core.traverser.BidirectionalTraversible;

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
     * Returns a new {@link BidirectionalTraversible} adapter for the specified
     * array.
     * 
     * @param <Item>
     *        type of the items held in the array
     * 
     * @param items
     *        comma separated sequence of Items to traverse
     * 
     * @return {@link BidirectionalTraversible} adapter for {@code array}
     */
    @SafeVarargs
    public static <Item> BidirectionalTraversible<Item> traversible(final Item... items) {
        return new ArrayTraversible<>(items);
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
    public static int getFlattenedItemsCount(final Object... items) {
        int itemsCount = 0;

        for (final Object item : items)
            itemsCount += item.getClass().isArray()
                ? getFlattenedItemsCount((Object[]) item)
                : 1;

        return itemsCount;
    }

    /**
     * Recursively appends all Items specified as a comma separated list to the
     * specified {@link List}.
     * 
     * @param <Item>
     *        type of the specified items
     * 
     * @param allItems
     *        {@link List} to which the items are added
     * 
     * @param items
     *        comma separated liet of items
     */
    public static <Item> void flatten(final List<Object> allItems, final Object... items) {
        for (final Object item : items)
            if (item.getClass().isArray())
                flatten(allItems, (Object[]) item);
            else
                allItems.add(item);
    }

    /**
     * Returns an array of all Items specified as a comma separated list to the
     * specified {@link List}, recursively collected from contained arrays.
     * 
     * @param <Item>
     *        type of the specified items
     * 
     * @param items
     *        comma separated liet of items
     * 
     * @return array of all collected Items
     */
    @SuppressWarnings("unchecked")
    public static <Item> Item[] flatten(final Item... items) {
        final List<Object> allItems = new ArrayList<>(getFlattenedItemsCount(items));
        flatten(allItems, items);
        return (Item[]) allItems.toArray();
    }
}
