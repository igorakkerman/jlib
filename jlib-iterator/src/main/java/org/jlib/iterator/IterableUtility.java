/*
 * jlib - Open Source Java Library
 *
 *     www.jlib.org
 *
 *
 *     Copyright 2005-2015 Igor Akkerman
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

package org.jlib.iterator;

import java.util.Iterator;

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
     * Verifies whether this IterableContainer contains all of the Items returned by the
     * Iterator of the specified Iterable.
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
     * @return {@code true} if this IterableContainer contains all of the Items
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
     * Verifies whether the {@link Iterator} instances created by the {@link Iterable#iterator()} methods of
     * the two specified {@link Iterable} instances traverse the same number of Items in the same order and all
     * traversed Items are equal. Two Items {@code item1} and {@code item2} are called equal if
     * {@code item1.provideEqualItems(item2)}.
     *
     * @param <Item>
     *        type of the items traversed by {@code iterable1} and {@code iterable2}
     *
     * @param iterable1
     *        first traversed {@link Iterable}
     *
     * @param iterable2
     *        second traversed {@link Iterable}
     *
     * @return {@code true} if {@code iterator1} and {@code iterator2} provide equal Items;
     *         {@code false} otherwise
     */
    public static <Item> boolean provideEqualItems(final Iterable<? extends Item> iterable1,
                                                   final Iterable<Item> iterable2) {
        final Iterator<?> iterator1 = iterable1.iterator();
        final Iterator<?> iterator2 = iterable2.iterator();

        do {
            // if either iterator has Items accessible and the other iterator is done
            if (iterator1.hasNext() != iterator2.hasNext())
                return false;

            // if both iterators are done
            if (! iterator1.hasNext())
                return true;
        }
        // while the Items returned by both Iterators are equal
        while (iterator1.next().equals(iterator2.next()));

        return false;
    }

    public static boolean isEmpty(final Iterable<?> iterable) {
        return ! iterable.iterator().hasNext();
    }

    /**
     * Returns the number of Items provided by the specified {@link BidiIterable}.
     *
     * @param iterable
     * {@link BidiIterable} providing the items
     *
     * @return integer specifying the number of Items
     */
    public static int getItemsCount(final BidiIterable<?> iterable) {
        final BidiIterator<?> itemsIterator = iterable.iterator();

        int itemsCount = 0;

        while (itemsIterator.hasNext()) {
            itemsIterator.next();

            itemsCount++;
        }

        return itemsCount;
    }

    /**
     * Returns the sum of number of Items provided by the specified {@link BidiIterator} instances.
     *
     * @param iterables
     * comma separated sequence of {@link BidiIterable} instances
     *
     * @return integer specifying the number of Items
     */
    public static int getItemsCount(final BidiIterable<?>... iterables) {
        int itemsCount = 0;

        for (final BidiIterable<?> iterable : iterables)
            itemsCount += getItemsCount(iterable);

        return itemsCount;
    }

    public static <Item> BidiIterable<Item> singletonIterable(final Item item) {
        return new SingletonIterable<>(item);
    }

    private IterableUtility() {}
}
