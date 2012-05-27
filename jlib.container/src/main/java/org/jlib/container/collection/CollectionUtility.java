package org.jlib.container.collection;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Utility class providing methods operating on {@link Collection Collections}.
 * 
 * @author Igor Akkerman
 */
public final class CollectionUtility {

    /** no visible constructor */
    private CollectionUtility() {}

    /**
     * Creates a {@link Set} containing the items of the specified array.
     * 
     * @param <SetItem>
     *        type of the items held in the {@link Set}
     * 
     * @param <ArrayItem>
     *        type of the items held in the array; subtype of
     *        {@code <SetItem>}
     * 
     * @param array
     *        the source array
     * 
     * @return Set containing the Items of {@code array}
     */
    public static <SetItem, ArrayItem extends SetItem> Set<SetItem> toSet(final ArrayItem[] array) {
        final Set<SetItem> set = new HashSet<SetItem>(array.length);
        for (ArrayItem item : array)
            set.add(item);
        return set;
    }

    /**
     * Creates a Set containing the items provided by the specified
     * {@link Iterable}.
     * 
     * @param <SetItem>
     *        type of the items held in the {@link Set}
     * 
     * @param <IterableItem>
     *        type of the items provided by the {@link Iterable}; subtype of
     *        {@code <SetItem>}
     * 
     * @param iterable
     *        the source iterable
     * 
     * @return Set containing the Items of {@code iterable}
     */
    public static <SetItem, IterableItem extends SetItem> Set<SetItem> toSet(final Iterable<IterableItem> iterable) {
        final Set<SetItem> set = new HashSet<SetItem>();
        for (IterableItem item : iterable)
            set.add(item);
        return set;
    }

    /**
     * Removes all items from the specified {@link Collection} provided by
     * the specified {@link Iterable}.
     * 
     * @param <CollectionItem>
     *        type of the items held in the {@link Collection}
     * 
     * @param <RemovedItem>
     *        type of the items removed from the {@link Collection}; subtype
     *        of {@code <CollectionItem>}
     * 
     * @param collection
     *        Collection from which {@code items} are removed
     * 
     * @param items
     *        {@link Iterable} providing the items to remove
     */
    public static <CollectionItem, RemovedItem extends CollectionItem> void removeAll(final Collection<CollectionItem> collection,
                                                                                               final Iterable<RemovedItem> items) {
        for (RemovedItem item : items)
            collection.remove(item);
    }
}
