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

package org.jlib.container.sequence;

import java.util.Iterator;

import org.jlib.core.array.ArrayUtility;
import org.jlib.core.observer.ValueObserver;
import org.jlib.core.traverser.InvalidTraversableArgumentException;
import org.jlib.core.traverser.Traverser;
import org.jlib.core.traverser.TwoWayTraversable;

/**
 * Facade utility for {@link Sequence} creation and operations.
 *
 * @author Igor Akkerman
 */
public final class SequenceUtility {

    /** no visible default constructor */
    private SequenceUtility() {
    }

    /**
     * Creates a new {@link Sequence} containing solely the specified Item.
     *
     * @param <Item>
     *        type of the items held in the {@link Sequence}
     *
     * @param item
     *        sole Item of the new {@link Sequence}
     *
     * @return new singleton {@link Sequence}
     */
    public static <Item> Sequence<Item> singleton(final Item item) {
        return null; //new SingletonSequence<Item>(item);
    }

    /**
     * Appends the specified Item to the specified {@link AppendSequence} that
     * does not yet contain the Item.
     *
     * @param <Item>
     *        type of the items held in the {@link Sequence}
     *
     * @param sequence
     *        {@link AppendSequence} to which the Item is appended
     *
     * @param item
     *        appended Item
     *
     * @throws InvalidTraversableArgumentException
     *         if some property of {@code item} prevents it from being appended
     *         to {@code sequence}
     */
    public static <Item> void append(final AppendSequence<Item> sequence, final Item item)
    throws InvalidTraversableArgumentException {
        sequence.append(item);
    }

    /**
     * Appends all Items provided by the specified {@link Iterable} to the
     * specified {@link AppendSequence}.
     *
     * @param <Item>
     *        type of the items held in the {@link Sequence}
     *
     * @param sequence
     *        {@link AppendSequence} to which the Items are appended
     *
     * @param items
     *        {@link Iterable} providing the Items to append
     *
     * @throws InvalidTraversableArgumentException
     *         if some property of one Item in {@code items} prevents it from
     *         being appended to {@code sequence}
     */
    public static <Item> void append(final AppendSequence<Item> sequence, final Iterable<? extends Item> items) {
        for (final Item item : items)
            sequence.append(item);
    }

    /**
     * Appends all Items in the specified comma separated sequence to the
     * specified {@link AppendSequence}.
     *
     * @param <Item>
     *        type of the items held in the {@link Sequence}
     *
     * @param sequence
     *        {@link AppendSequence} to which the Items are appended
     *
     * @param items
     *        {@link Iterable} providing the Items to append
     *
     * @throws InvalidTraversableArgumentException
     *         if some property of one Item in {@code items} prevents it from
     *         being appended to {@code sequence}
     */
    @SafeVarargs
    public static <Item> void append(final AppendSequence<Item> sequence, final Item... items)
    throws InvalidTraversableArgumentException {
        append(sequence, ArrayUtility.iterable(items));
    }

    /**
     * Appends the specified Item to the specified {@link AppendSequence} that
     * does not yet contain the Item.
     *
     * @param <Item>
     *        type of the items held in the {@link Sequence}
     *
     * @param sequence
     *        {@link ObservedAppendSequence} to which the Item is appended
     *
     * @param item
     *        appended Item
     *
     * @param observers
     *        comma separated sequence of {@link ValueObserver} instances
     *        attending the operation
     *
     * @throws InvalidTraversableArgumentException
     *         if some property of {@code item} prevents it from being appended
     *         to {@code sequence}
     */
    @SafeVarargs
    public static <Item> void append(final ObservedAppendSequence<Item> sequence, final Item item, final ValueObserver<Item>... observers)
    throws InvalidTraversableArgumentException {
        sequence.append(item, observers);
    }

    /**
     * Appends all Items provided by the specified {@link Iterable} to the
     * specified {@link AppendSequence}.
     *
     * @param <Item>
     *        type of the items held in the {@link Sequence}
     *
     * @param sequence
     *        {@link ObservedAppendSequence} to which the Items are appended
     *
     * @param items
     *        {@link Iterable} providing the Items to append
     *
     * @param observers
     *        comma separated sequence of {@link ValueObserver} instances
     *        attending the operation
     *
     * @throws InvalidTraversableArgumentException
     *         if some property of one Item in {@code items} prevents it from
     *         being appended to {@code sequence}
     */
    @SafeVarargs
    public static <Item> void append(final ObservedAppendSequence<Item> sequence, final Iterable<? extends Item> items, final ValueObserver<Item>... observers) {
        for (final Item item : items)
            sequence.append(item, observers);
    }

    /**
     * Appends all Items in the specified comma separated sequence to the
     * specified {@link AppendSequence}.
     *
     * @param <Item>
     *        type of the items held in the {@link Sequence}
     *
     * @param sequence
     *        {@link ObservedAppendSequence} to which the Items are appended
     *
     * @param items
     *        {@link Iterable} providing the Items to append
     *
     * @param observers
     *        array of {@link ValueObserver} instances attending the operation
     *
     * @throws InvalidTraversableArgumentException
     *         if some property of one Item in {@code items} prevents it from
     *         being appended to {@code sequence}
     */
    @SafeVarargs
    public static <Item> void append(final ObservedAppendSequence<Item> sequence, final ValueObserver<Item>[] observers, final Item... items)
    throws InvalidTraversableArgumentException {
        append(sequence, ArrayUtility.iterable(items), observers);
    }

    /**
     * Prepends the specified Item to the specified {@link PrependSequence} that
     * does not yet contain the Item.
     *
     * @param <Item>
     *        type of the items held in the {@link Sequence}
     *
     * @param sequence
     *        {@link PrependSequence} to which the Item is prepended
     *
     * @param item
     *        prepended Item
     *
     * @throws InvalidTraversableArgumentException
     *         if some property of {@code item} prevents it from being prepended
     *         to {@code sequence}
     */
    public static <Item> void prepend(final PrependSequence<Item> sequence, final Item item)
    throws InvalidTraversableArgumentException {
        sequence.prepend(item);
    }

    /**
     * Prepends all Items provided by the specified {@link Iterable} to the
     * specified {@link PrependSequence}.
     *
     * @param <Item>
     *        type of the items held in the {@link Sequence}
     *
     * @param sequence
     *        {@link PrependSequence} to which the Items are prepended
     *
     * @param items
     *        {@link Iterable} providing the Items to prepend
     *
     * @throws InvalidTraversableArgumentException
     *         if some property of one Item in {@code items} prevents it from
     *         being prepended to {@code sequence}
     */
    public static <Item> void prepend(final PrependSequence<Item> sequence, final Iterable<? extends Item> items) {
        for (final Item item : items)
            sequence.prepend(item);
    }

    /**
     * Prepends all Items in the specified comma separated sequence to the
     * specified {@link PrependSequence}.
     *
     * @param <Item>
     *        type of the items held in the {@link Sequence}
     *
     * @param sequence
     *        {@link PrependSequence} to which the Items are prepended
     *
     * @param items
     *        {@link Iterable} providing the Items to prepend
     *
     * @throws InvalidTraversableArgumentException
     *         if some property of one Item in {@code items} prevents it from
     *         being prepended to {@code sequence}
     */
    @SafeVarargs
    public static <Item> void prepend(final PrependSequence<Item> sequence, final Item... items)
    throws InvalidTraversableArgumentException {
        prepend(sequence, ArrayUtility.iterable(items));
    }

    /**
     * Prepends the specified Item to the specified {@link PrependSequence} that
     * does not yet contain the Item.
     *
     * @param <Item>
     *        type of the items held in the {@link Sequence}
     *
     * @param sequence
     *        {@link ObservedPrependSequence} to which the Item is prepended
     *
     * @param item
     *        prepended Item
     *
     * @param observers
     *        comma separated sequence of {@link ValueObserver} instances
     *        attending the operation
     *
     * @throws InvalidTraversableArgumentException
     *         if some property of {@code item} prevents it from being prepended
     *         to {@code sequence}
     */
    @SafeVarargs
    public static <Item> void prepend(final ObservedPrependSequence<Item> sequence, final Item item, final ValueObserver<Item>... observers)
    throws InvalidTraversableArgumentException {
        sequence.prepend(item, observers);
    }

    /**
     * Prepends all Items provided by the specified {@link Iterable} to the
     * specified {@link PrependSequence}.
     *
     * @param <Item>
     *        type of the items held in the {@link Sequence}
     *
     * @param sequence
     *        {@link ObservedPrependSequence} to which the Items are prepended
     *
     * @param items
     *        {@link Iterable} providing the Items to prepend
     *
     * @param observers
     *        comma separated sequence of {@link ValueObserver} instances
     *        attending the operation
     *
     * @throws InvalidTraversableArgumentException
     *         if some property of one Item in {@code items} prevents it from
     *         being prepended to {@code sequence}
     */
    @SafeVarargs
    public static <Item> void prepend(final ObservedPrependSequence<Item> sequence, final Iterable<? extends Item> items, final ValueObserver<Item>... observers) {
        for (final Item item : items)
            sequence.prepend(item, observers);
    }

    /**
     * Prepends all Items in the specified comma separated sequence to the
     * specified {@link PrependSequence}.
     *
     * @param <Item>
     *        type of the items held in the {@link Sequence}
     *
     * @param sequence
     *        {@link ObservedPrependSequence} to which the Items are prepended
     *
     * @param items
     *        {@link Iterable} providing the Items to prepend
     *
     * @param observers
     *        array of {@link ValueObserver} instances attending the operation
     *
     * @throws InvalidTraversableArgumentException
     *         if some property of one Item in {@code items} prevents it from
     *         being prepended to {@code sequence}
     */
    @SafeVarargs
    public static <Item> void prepend(final ObservedPrependSequence<Item> sequence, final ValueObserver<Item>[] observers, final Item... items)
    throws InvalidTraversableArgumentException {
        prepend(sequence, ArrayUtility.iterable(items), observers);
    }

    /**
     * Returns a concatenated view of the specified {@link TwoWayTraversable}
     * instances. The behaviour of the returned {@link Sequence} and its
     * {@link Traverser} or {@link Iterator} is unspecified if one of the
     * {@link TwoWayTraversable} instances is modified.
     *
     * @param <Item>
     *        type of the items provided by {@code traversables}
     *
     * @param traversables
     *        comma separated sequence of {@link TwoWayTraversable} instances
     *
     * @return concatenated {@link Sequence} view
     */
    @SafeVarargs
    public static <Item> Sequence<Item> concatenated(final TwoWayTraversable<Item>... traversables) {
        return null; // new ConcatenatedSequence<>(traversables);
    }

    /**
     * Returns the specified sequence itemsCount if it is positive.
     *
     * @param itemsCount
     *        positive integer specifying the sequence itemsCount
     *
     * @return {@code itemsCount} if {@code itemsCount >= 1}
     *
     * @throws InvalidSequenceItemsCountException
     *         if {@code itemsCount < 1}
     */
    public static int getValidatedSequenceItemsCount(final int itemsCount)
    throws InvalidSequenceItemsCountException {
        if (itemsCount < 1)
            throw new InvalidSequenceItemsCountException(itemsCount);

        return itemsCount;
    }
}
