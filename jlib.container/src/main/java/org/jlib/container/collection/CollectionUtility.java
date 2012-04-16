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
     * Creates a {@link Set} containing the elements of the specified array.
     * 
     * @param <SetElement>
     *        type of the elements held in the {@link Set}
     * 
     * @param <ArrayElement>
     *        type of the elements held in the array; subtype of
     *        {@code <SetElement>}
     * 
     * @param array
     *        the source array
     * 
     * @return Set containing the Elements of {@code array}
     */
    public static <SetElement, ArrayElement extends SetElement> Set<SetElement> toSet(final ArrayElement[] array) {
        final Set<SetElement> set = new HashSet<SetElement>(array.length);
        for (ArrayElement element : array)
            set.add(element);
        return set;
    }

    /**
     * Creates a Set containing the elements provided by the specified
     * {@link Iterable}.
     * 
     * @param <SetElement>
     *        type of the elements held in the {@link Set}
     * 
     * @param <IterableElement>
     *        type of the elements provided by the {@link Iterable}; subtype of
     *        {@code <SetElement>}
     * 
     * @param iterable
     *        the source iterable
     * 
     * @return Set containing the Elements of {@code iterable}
     */
    public static <SetElement, IterableElement extends SetElement> Set<SetElement> toSet(final Iterable<IterableElement> iterable) {
        final Set<SetElement> set = new HashSet<SetElement>();
        for (IterableElement element : iterable)
            set.add(element);
        return set;
    }

    /**
     * Removes all elements from the specified {@link Collection} provided by
     * the specified {@link Iterable}.
     * 
     * @param <CollectionElement>
     *        type of the elements held in the {@link Collection}
     * 
     * @param <RemovedElement>
     *        type of the elements removed from the {@link Collection}; subtype
     *        of {@code <CollectionElement>}
     * 
     * @param collection
     *        Collection from which {@code elements} are removed
     * 
     * @param elements
     *        {@link Iterable} providing the elements to remove
     */
    public static <CollectionElement, RemovedElement extends CollectionElement> void removeAll(final Collection<CollectionElement> collection,
                                                                                               final Iterable<RemovedElement> elements) {
        for (RemovedElement element : elements)
            collection.remove(element);
    }
}
