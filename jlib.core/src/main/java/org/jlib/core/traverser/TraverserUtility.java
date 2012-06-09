package org.jlib.core.traverser;

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
     * Returns the number of Items provided by the specified
     * {@link BidirectionalTraversible}.
     * 
     * @param traversible
     *        {@link BidirectionalTraversible} providing the items
     * 
     * @return integer specifying the number of Items
     */
    public static int getItemsCount(final BidirectionalTraversible<?> traversible) {
        final BidirectionalTraverser<?> itemsTraverser = traversible.createTraverser();

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
