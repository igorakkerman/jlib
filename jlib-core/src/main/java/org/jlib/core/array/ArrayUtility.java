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

package org.jlib.core.array;

import org.jlib.core.traverser.TwoWayTraverser;
import org.jlib.core.traverser.TwoWayTraversible;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility for arrays.
 *
 * @author Igor Akkerman
 */
public final class ArrayUtility {

    /** empty array of Objects */
    public static final Object[] EMPTY_ARRAY = new Object[0];

    /** no visible constructor */
    private ArrayUtility() {}

    /**
     * Returns a new {@link Iterable} adapter for the specified Items.
     *
     * @param <Item>
     *        type of the items held in the array
     *
     * @param items
     *        comma separated sequence of Items to traverse
     *
     * @return {@link Iterable} adapter for {@code items}
     */
    @SafeVarargs
    public static <Item> Iterable<Item> iterable(final Item... items) {
        return new ArrayIterable<>(items);
    }

    /**
     * Returns a new {@link TwoWayTraversible} adapter for the specified Items.
     *
     * @param <Item>
     *        type of the items held in the array
     *
     * @param items
     *        comma separated sequence of Items to traverse
     *
     * @return {@link TwoWayTraversible} adapter for {@code items}
     */
    @SafeVarargs
    public static <Item> TwoWayTraversible<Item> traversible(final Item... items) {
        return new ArrayTraversible<>(items);
    }

    /**
     * Returns a new {@link TwoWayTraverser} over the specified Items.
     *
     * @param <Item>
     *        type of the items held in the array
     *
     * @param items
     *        comma separated sequence of Items to traverse
     *
     * @return {@link TwoWayTraversible} adapter for {@code items}
     */
    @SafeVarargs
    public static <Item> TwoWayTraverser<Item> createTraverser(final Item... items) {
        return new ArrayTraverser<>(items);
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
     * @param allItems
     *        {@link List} to which the items are added
     *
     * @param items
     *        comma separated liet of items
     */
    public static void flatten(final List<Object> allItems, final Object... items) {
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

    /**
     * Returns a typesafe empty array of Items.
     *
     * @param <Item>
     *        type of potential Items in the array
     *
     * @return empty array of Items
     */
    @SuppressWarnings("unchecked")
    public static <Item> Item[] getEmptyArray() {
        return (Item[]) EMPTY_ARRAY;
    }

    /**
     * Crates an array of Items in a typesafe manner.
     *
     * @param <Item>
     *        type of the items held in the array
     *
     * @param length
     *        integer specifying the array length
     *
     * @return newly created array
     *
     * @throws NegativeArraySizeException
     *         if {@code length < 0}
     */
    @SuppressWarnings("unchecked")
    public static <Item> Item[] createArray(final int length)
    throws NegativeArraySizeException {
        return (Item[]) new Object[length];
    }
}
