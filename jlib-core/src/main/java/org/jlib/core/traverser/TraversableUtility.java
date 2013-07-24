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

package org.jlib.core.traverser;

import org.jlib.core.observer.ValueObserver;

/**
 * Utility providing operations on {@link Traverser} and {@link Traversable} instances.
 *
 * @author Igor Akkerman
 */
public final class TraversableUtility {

    /** no visible constructor */
    private TraversableUtility() {
    }

    /**
     * Verifies whether the {@link Traverser} instances created by the {@link Traversable#createTraverser()} methods of
     * the two specified {@link Traversable} instances traverse the same number of Items in the same order and all
     * traversed Items are equal. Two Items {@code item1} and {@code item2} are called equal if
     * {@code item1.equals(item2)}.
     *
     * @param <Item>
     *        type of the items traversed by {@code traversable1} and {@code traversable2}
     *
     * @param traversable1
     *        first traversed {@link Traversable}
     *
     * @param traversable2
     *        second traversed {@link Traversable}
     *
     * @return {@code true} if {@code traverser1} and {@code traverser2} provide equal Items;
     *         {@code false} otherwise
     */
    @SuppressWarnings({ "FeatureEnvy" })
    public static <Item> boolean provideEqualItems(final Traversable<Item> traversable1,
                                                   final Traversable<Item> traversable2) {
        final Traverser<?> traverser1 = traversable1.createTraverser();
        final Traverser<?> traverser2 = traversable2.createTraverser();

        do {
            // if either traverser has Items accessible and the other traverser is done
            if (traverser1.hasNextItem() != traverser2.hasNextItem())
                return false;

            // if both traversers are done
            if (! traverser1.hasNextItem())
                return true;
        }
        // while the Items returned by both Traversers are equal
        while (traverser1.getNextItem().equals(traverser2.getNextItem()));

        return false;
    }

    /**
     * Returns the number of Items provided by the specified {@link TwoWayTraversable}.
     *
     * @param traversable
     * {@link TwoWayTraversable} providing the items
     *
     * @return integer specifying the number of Items
     */
    public static int getItemsCount(final TwoWayTraversable<?> traversable) {
        final TwoWayTraverser<?> itemsTraverser = traversable.createTraverser();

        int itemsCount = 0;

        while (itemsTraverser.hasNextItem()) {
            itemsTraverser.getNextItem();

            itemsCount++;
        }

        return itemsCount;
    }

    /**
     * Returns the sum of number of Items provided by the specified {@link TwoWayTraverser} instances.
     *
     * @param traversables
     * comma separated sequence of {@link TwoWayTraversable} instances
     *
     * @return integer specifying the number of Items
     */
    public static int getItemsCount(final TwoWayTraversable<?>... traversables) {
        int itemsCount = 0;

        for (final TwoWayTraversable<?> traversable : traversables)
            itemsCount += getItemsCount(traversable);

        return itemsCount;
    }

    /**
     * Removes all Items of the specified {@link RemoveTraversable}.
     *
     * @param traversable
     *        {@link RemoveTraversable} providing the Items
     *
     * @param <Item>
     *        type of the items of {@code traversable}
     *
     * @throws InvalidTraversableStateException
     *         if an error occurs during one of the remove operations
     */
    // TODO: check declared exceptions
    @SuppressWarnings("OverlyBroadThrowsClause")
    public static <Item> void removeAll(final RemoveTraversable<Item> traversable)
    throws InvalidTraversableStateException {
        for (final RemoveTraverser<Item> traverser = traversable.createTraverser();
             traverser.hasNextItem(); ) {
            traverser.getNextItem();
            traverser.remove();
        }
    }

    /**
     * Removes all Items of the specified {@link RemoveTraversable}.
     *
     * @param traversable
     *        {@link RemoveTraversable} providing the Items
     *
     * @param <Item>
     *        type of the items of {@code traversable}
     *
     * @param observers
     *        comma separated sequence of {@link ValueObserver} instances
     *        attending the removal
     *
     * @throws InvalidTraversableStateException
     *         if an error occurs during one of the remove operations
     */
    @SafeVarargs
    // TODO: check declared exceptions
    @SuppressWarnings("OverlyBroadThrowsClause")
    public static <Item> void removeAll(final ObservedRemoveTraversable<Item> traversable,
                                        final ValueObserver<Item>... observers)
    throws InvalidTraversableStateException {
        for (final ObservedRemoveTraverser<Item> traverser = traversable.createTraverser();
             traverser.hasNextItem(); ) {
            traverser.getNextItem();
            traverser.remove(observers);
        }
    }

    public static <Item> Iterable<Item> iterable(final Traversable<Item> traversable) {
        return new TraversableIterable<>(traversable);
    }

    public static <Item> Iterable<Item> iterable(final RemoveTraversable<Item> traversable) {
        return new RemoveTraversableIterable<>(traversable);
    }

    public static <Item> Traversable<Item> traversable(final Iterable<Item> iterable) {
        return new IterableTraversable<>(iterable);
    }

    public static <Item> RemoveTraversable<Item> removeTraversable(final Iterable<Item> iterable) {
        return new RemoveIterableTraversable<>(iterable);
    }
}
