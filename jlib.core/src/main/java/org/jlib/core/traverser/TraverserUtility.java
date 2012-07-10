package org.jlib.core.traverser;

import org.jlib.core.ObjectUtility;

/**
 * Utility providing operations on {@link Traverser} and {@link Traversible}
 * instances.
 * 
 * @author Igor Akkerman
 */
public final class TraverserUtility {

    /** no visible constructor */
    private TraverserUtility() {}

    /**
     * Verifies whether the {@link Traverser} instances created by the
     * {@link Traversible#createTraverser()} methods of the two specified
     * {@link Traversible} instances traverse the same number of Items in the
     * same order and all traversed Items are equal. Two Items {@code item1} and
     * {@code item2} are called equal if {@code item1.equals(item2)}.
     * 
     * @param <Item>
     *        type of the items traversed by {@code traversible1} and
     *        {@code traversible2}
     * 
     * @param traversible1
     *        first traversed {@link Traversible}
     * 
     * @param traversible2
     *        second traversed {@link Traversible}
     * 
     * @return {@code true} if {@code traverser1} and {@code traverser2} provide
     *         equal Items; {@code false} otherwise
     */
    public static <Item> boolean provideEqualItems(final Traversible<Item> traversible1,
                                                   final Traversible<Item> traversible2) {
        final Traverser<?> traverser1 = traversible1.createTraverser();
        final Traverser<?> traverser2 = traversible2.createTraverser();

        do {
            final boolean nextItemAccessible = traverser1.isNextItemAccessible();

            if (nextItemAccessible != traverser2.isNextItemAccessible())
                return false;

            if (!nextItemAccessible)
                return true;

            if (!ObjectUtility.equal(traverser1.getNextItem(), traverser2.getNextItem()))
                return false;
        }
        while (true);
    }

    /**
     * Returns the number of Items provided by the specified
     * {@link BidirectionalTraversible}.
     * 
     * @param traversible
     *        {@link BidirectionalTraversible} providing the items
     * 
     * @return integer specifying the number of Items
     */
    public static int getItemsCount(final BidirectionalTraversible<?> traversible) {
        final BidirectionalTraverser<?> itemsTraverser = traversible.createBidirectionalTraverser();

        int itemsCount = 0;

        while (itemsTraverser.isNextItemAccessible()) {
            itemsTraverser.getNextItem();

            itemsCount ++;
        }

        return itemsCount;
    }

    /**
     * Returns the sum of number of Items provided by the specified
     * {@link BidirectionalTraverser} instances.
     * 
     * @param traversibles
     *        comma separated sequence of {@link BidirectionalTraversible}
     *        instances
     * 
     * @return integer specifying the number of Items
     */
    public static int getItemsCount(final BidirectionalTraversible<?>... traversibles) {
        int itemsCount = 0;

        for (final BidirectionalTraversible<?> traversible : traversibles)
            itemsCount += getItemsCount(traversible);

        return itemsCount;
    }
}
