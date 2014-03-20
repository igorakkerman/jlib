/*
 * jlib - Open Source Java Library
 *
 *     www.jlib.org
 *
 *
 *     Copyright 2005-2013 Igor Akkerman
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 */

package org.jlib.core.iterator;

import java.util.Iterator;

import org.jlib.core.observer.ValueObserver;

/**
 * {@link Iterator} utility.
 *
 * @author Igor Akkerman
 */
public final class IterableUtility {

    /**
     * Verifies whether the {@link Iterator} instances created by the
     * {@link Iterable#iterator()} methods of the two specified {@link Iterable}
     * instances traverse the same number of Items in the same order and all
     * traversed Items are equal. Two Items {@code item1} and {@code item2} are
     * called equal if {@code item1.equals(item2)}.
     *
     * @param <Item>
     *        type of the items traversed by {@code iterable1} and
     *        {@code iterable2}
     *
     * @param iterable1
     *        first traversed {@link Iterable}
     *
     * @param iterable2
     *        second traversed {@link Iterable}
     *
     * @return {@code true} if {@code iterator1} and {@code iterator2} provide
     *         equal Items; {@code false} otherwise
     */
    public static <Item> boolean equals(final Iterable<Item> iterable1, final Iterable<Item> iterable2) {
        final Iterator<?> iterator1 = iterable1.iterator();
        final Iterator<?> iterator2 = iterable2.iterator();

        do {
            final boolean nextItemAccessible = iterator1.hasNext();

            if (nextItemAccessible != iterator2.hasNext())
                return false;

            if (! nextItemAccessible)
                return true;

            if (! iterator1.next().equals(iterator2.next()))
                return false;
        }
        while (true);
    }

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

        for (@SuppressWarnings("unused") final Object item : items)
            itemsCount++;

        return itemsCount;
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

        for (final Iterable<?> iterable : iterables)
            itemsCount += getItemsCount(iterable);

        return itemsCount;
    }

    public static <Item> boolean contains(final Iterable<Item> iterable, final Item item) {
        for (final Object containedItem : iterable)
            if (containedItem.equals(item))
                return true;

        return false;
    }

    /**
     * Verifies whether this TraversableContainer contains all of the Items returned by the
     * Traverser of the specified Iterable.
     *
     * @param containedItems
     *        {@link Iterable} providing the contained {@link Item}s;
     *        if {@code containedItems} provides a {@code null} value, the behaviour is unspecified,
     *        an {@link Exception} may be thrown
     *
     * @param lookedUpItems
     *        {@link Iterable} providing the looked up {@link Item}s;
     *        if {@code lookedUpItems} provides a {@code null} value, the behaviour is unspecified,
     *        an {@link Exception} may be thrown
     *
     * @return {@code true} if this TraversableContainer contains all of the Items
     *         contained by {@code otherContainer}; {@code false} otherwise
     */
    public static <Item> boolean contains(final Iterable<Item> containedItems,
                                          final Iterable<? extends Item> lookedUpItems) {
        for (final Item lookedUpItem : lookedUpItems)
            if (! contains(containedItems, lookedUpItem))
                return false;

        return true;
    }

    /**
     * Verifies whether the {@link Iterator} instances created by the {@link Iterable#createTraverser()} methods of
     * the two specified {@link Iterable} instances traverse the same number of Items in the same order and all
     * traversed Items are equal. Two Items {@code item1} and {@code item2} are called equal if
     * {@code item1.provideEqualItems(item2)}.
     *
     * @param <Item>
     *        type of the items traversed by {@code traversable1} and {@code traversable2}
     *
     * @param iterable1
     *        first traversed {@link Iterable}
     *
     * @param iterable2
     *        second traversed {@link Iterable}
     *
     * @return {@code true} if {@code traverser1} and {@code traverser2} provide equal Items;
     *         {@code false} otherwise
     */
    @SuppressWarnings({ "FeatureEnvy" })
    public static <Item> boolean provideEqualItems(final Iterable<Item> iterable1, final Iterable<Item> iterable2) {
        final Iterator<?> iterator1 = iterable1.createTraverser();
        final Iterator<?> iterator2 = iterable2.createTraverser();

        do {
            // if either traverser has Items accessible and the other traverser is done
            if (iterator1.hasNextItem() != iterator2.hasNextItem())
                return false;

            // if both traversers are done
            if (! iterator1.hasNextItem())
                return true;
        }
        // while the Items returned by both Traversers are equal
        while (iterator1.getNextItem().equals(iterator2.getNextItem()));

        return false;
    }

    public static boolean isEmpty(final Iterable<?> iterable) {
        return ! iterable.createTraverser().hasNextItem();
    }

    /**
     * Returns the number of Items provided by the specified {@link BidiIterable}.
     *
     * @param traversable
     * {@link BidiIterable} providing the items
     *
     * @return integer specifying the number of Items
     */
    public static int getItemsCount(final BidiIterable<?> traversable) {
        final BidiIterator<?> itemsTraverser = traversable.iterator();

        int itemsCount = 0;

        while (itemsTraverser.hasNextItem()) {
            itemsTraverser.getNextItem();

            itemsCount++;
        }

        return itemsCount;
    }

    /**
     * Returns the sum of number of Items provided by the specified {@link BidiIterator} instances.
     *
     * @param traversables
     * comma separated sequence of {@link BidiIterable} instances
     *
     * @return integer specifying the number of Items
     */
    public static int getItemsCount(final BidiIterable<?>... traversables) {
        int itemsCount = 0;

        for (final BidiIterable<?> traversable : traversables)
            itemsCount += getItemsCount(traversable);

        return itemsCount;
    }

    /**
     * Removes all Items of the specified {@link RemoveIterable}.
     *
     * @param traversable
     *        {@link RemoveIterable} providing the Items
     *
     * @param <Item>
     *        type of the items of {@code traversable}
     *
     * @throws InvalidIterableStateException
     *         if an error occurs during one of the remove operations
     */
    // TODO: check declared exceptions
    @SuppressWarnings("OverlyBroadThrowsClause")
    public static <Item> void removeAll(final RemoveIterable<Item> traversable)
    throws InvalidIterableStateException {
        for (final RemoveIterator<Item> traverser = traversable.createTraverser(); traverser.hasNextItem(); ) {
            traverser.getNextItem();
            traverser.remove();
        }
    }

    /**
     * Removes all Items of the specified {@link RemoveIterable}.
     *
     * @param traversable
     *        {@link RemoveIterable} providing the Items
     *
     * @param <Item>
     *        type of the items of {@code traversable}
     *
     * @param observers
     *        comma separated sequence of {@link ValueObserver} instances
     *        attending the removal
     *
     * @throws InvalidIterableStateException
     *         if an error occurs during one of the remove operations
     */
    @SafeVarargs
    // TODO: check declared exceptions
    @SuppressWarnings("OverlyBroadThrowsClause")
    public static <Item> void removeAll(final ObservedRemoveIterable<Item> traversable,
                                        final ValueObserver<Item>... observers)
    throws InvalidIterableStateException {
        for (final ObservedRemoveIterator<Item> traverser = traversable.createTraverser(); traverser.hasNextItem(); ) {
            traverser.getNextItem();
            traverser.remove(observers);
        }
    }

    public static <Item> java.lang.Iterable iterable(final Iterable<Item> iterable) {
        return new TraversableIterable<>(iterable);
    }

    public static <Item> java.lang.Iterable iterable(final RemoveIterable<Item> traversable) {
        return new RemoveTraversableIterable<>(traversable);
    }

    public static <Item> Iterable<Item> traversable(final java.lang.Iterable iterable) {
        return new IterableIterable<>(iterable);
    }

    public static <Item> RemoveIterable<Item> removeTraversable(final java.lang.Iterable iterable) {
        return new RemoveIterableIterable<>(iterable);
    }

    public static <Item> boolean contains(final Iterable<Item> items, final Item item) {
        for (final Item containedItem : iterable(items))
            if (containedItem.equals(item))
                return true;

        return false;
    }

    public static <Item> BidiIterable<Item> singletonTraversable(final Item item) {
        return new SingletonIterable<>(item);
    }

    /** no visible constructor */
    private IterableUtility() {
    }
}
