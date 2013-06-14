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

package org.jlib.container.sequence.index;

import org.jlib.container.Container;
import org.jlib.container.sequence.InvalidSequenceItemsCountException;
import org.jlib.container.sequence.Sequence;
import org.jlib.container.sequence.SequenceUtility;
import org.jlib.container.sequence.index.array.InvalidStoredItemsCountException;
import org.jlib.core.array.ArrayUtility;
import org.jlib.core.observer.ObserverUtility;
import org.jlib.core.observer.ValueObserver;
import org.jlib.core.operator.HandledOperator;

import java.util.Collection;

/**
 * {@link AbstractIndexSequence} that can be initialized.
 *
 * @param <Item>
 *        type of the items held in the {@link Sequence}
 *
 * @author Igor Akkerman
 */
public abstract class AbstractInitializeableIndexSequence<Item>
extends AbstractIndexSequence<Item> {

    /**
     * Creates a new uninitialized {@link AbstractInitializeableIndexSequence}
     * with the specified first and last indices.
     *
     * @param firstIndex
     *        integer specifying the initial first index
     *
     * @param lastIndex
     *        integer specifying the initial last index
     *
     * @throws InvalidSequenceIndexRangeException
     *         if {@code lastIndex < firstIndex}
     */
    protected AbstractInitializeableIndexSequence(final int firstIndex, final int lastIndex)
    throws InvalidSequenceIndexRangeException {
        super(firstIndex, lastIndex);

        initialize();
    }

    /**
     * Creates a new {@link AbstractInitializeableIndexSequence} with a first
     * index of {@code 0} and the specified number of Items.
     *
     * @param itemsCount
     *        integer specifying the initial number of Items
     *
     * @throws InvalidSequenceItemsCountException
     *         if {@code itemsCount < 1}
     */
    protected AbstractInitializeableIndexSequence(final int itemsCount)
    throws InvalidSequenceItemsCountException {
        this(0, SequenceUtility.getValidatedSequenceItemsCount(itemsCount) - 1);
    }

    /**
     * Creates a new {@link AbstractInitializeableIndexSequence} with a first
     * index of {@code 0} containing the specified Items.
     *
     * @param items
     *        comma separated sequence of Items to store
     */
    @SafeVarargs
    protected AbstractInitializeableIndexSequence(final Item... items) {
        this(0, items);
    }

    /**
     * Creates a new {@link AbstractInitializeableIndexSequence} with the
     * specified first index containing the specified Items.
     *
     * @param firstIndex
     *        integer specifying the first index
     *
     * @param items
     *        comma separated sequence of Items to store
     */
    @SafeVarargs
    protected AbstractInitializeableIndexSequence(final int firstIndex, final Item... items) {
        this(firstIndex, firstIndex + items.length - 1);

        storeItems(items);
    }

    /**
     * Creates a new {@link AbstractInitializeableIndexSequence} with a first
     * index of {@code 0} containing the specified Items.
     *
     * @param items
     *        {@link Collection} of Items to store
     */
    public AbstractInitializeableIndexSequence(final Collection<? extends Item> items) {
        this(0, items);
    }

    /**
     * Creates a new {@link AbstractInitializeableIndexSequence} with the
     * specified first index containing the specified Items.
     *
     * @param firstIndex
     *        integer specifying the first index
     *
     * @param items
     *        {@link Collection} of Items to store
     */
    public AbstractInitializeableIndexSequence(final int firstIndex, final Collection<? extends Item> items) {
        this(firstIndex, firstIndex + items.size() - 1);

        storeItems(items);
    }

    /**
     * Creates a new {@link AbstractInitializeableIndexSequence} with a first
     * index of {@code 0} containing the specified Items.
     *
     * @param items
     *        {@link Container} of Items to store
     */
    public AbstractInitializeableIndexSequence(final Container<? extends Item> items) {
        this(0, items);
    }

    /**
     * Creates a new {@link AbstractInitializeableIndexSequence} with the
     * specified first index containing the specified Items.
     *
     * @param firstIndex
     *        integer specifying the first index
     *
     * @param items
     *        {@link Container} of Items to store
     */
    public AbstractInitializeableIndexSequence(final int firstIndex, final Container<? extends Item> items) {
        this(firstIndex, firstIndex + items.getItemsCount() - 1);

        storeItems(items);
    }

    /**
     * <p>
     * Initializes the data structures holding the Items of this
     * {@link AbstractInitializeableIndexSequence}.
     * </p>
     * <p>
     * This method is called when this
     * {@link AbstractInitializeableIndexSequence} is created
     * </p>
     * <ul>
     * <li><em>after</em> the minimum and maximum indices have been registered</li>
     * <li><em>before</em> the Items are stored</li>
     * </ul>
     */
    protected abstract void initialize();

    /**
     * Stores the specified Items in this
     * {@link AbstractInitializeableIndexSequence}.
     *
     * @param items
     *        {@link Container} of Items to store
     *
     * @throws InvalidStoredItemsCountException
     *         if {@code items.getItemsCount() != getItemsCount()}
     */
    protected void storeItems(final Container<? extends Item> items) {
        if (items.getItemsCount() != getItemsCount())
            throw new InvalidStoredItemsCountException(this, items.getItemsCount(),
                                                       "{0}: items.getItemsCount() == {1} != {2} == getItemsCount()",
                                                       getItemsCount());
        storeItems((Iterable<? extends Item>) items);
    }

    /**
     * Stores the specified Items in this
     * {@link AbstractInitializeableIndexSequence}.
     *
     * @param items
     *        {@link Collection} of Items to store
     *
     * @throws InvalidStoredItemsCountException
     *         if {@code items.size() != getItemsCount()}
     */
    protected void storeItems(final Collection<? extends Item> items) {
        if (items.size() != getItemsCount())
            throw new InvalidStoredItemsCountException(this, items.size(),
                                                       "{0}: items.size() == {1} != {2} == getItemsCount()",
                                                       getItemsCount());
        storeItems((Iterable<? extends Item>) items);
    }

    /**
     * Stores the specified Items in this
     * {@link AbstractInitializeableIndexSequence}.
     *
     * @param items
     *        comma separated sequence of Items to store
     *
     * @throws InvalidStoredItemsCountException
     *         if {@code items.length != getItemsCount()}
     */
    @SuppressWarnings("unchecked")
    protected void storeItems(final Item... items) {
        if (items.length != getItemsCount())
            throw new InvalidStoredItemsCountException(this, items.length,
                                                       "{0}: items.length == {1} != {2} == getItemsCount()",
                                                       getItemsCount());
        storeItems(ArrayUtility.iterable(items));
    }

    /**
     * Stores the specified Items in this
     * {@link AbstractInitializeableIndexSequence}.
     *
     * @param items
     *        {@link Iterable} providing Items to store
     */
    protected void storeItems(final Iterable<? extends Item> items) {
        int index = getFirstIndex();

        for (final Item item : items)
            replaceStoredItem(index++, item);
    }

    /**
     * Replaces the Item stored at the specified index in this
     * {@link AbstractInitializeableIndexSequence} by the specified Item.
     *
     * @param index
     *        integer specifying the index
     *
     * @param newItem
     *        Item to store
     *
     * @throws SequenceIndexOutOfBoundsException
     *         if {@code index < getFirstIndex() || index > getLastIndex()}
     */
    protected void replace(final int index, final Item newItem)
    throws SequenceIndexOutOfBoundsException {
        IndexSequenceUtility.assertIndexValid(this, index);

        replaceStoredItem(index, newItem);
    }

    /**
     * Replaces the Item stored at the specified index in this
     * {@link AbstractInitializeableIndexSequence} by the specified Item.
     *
     * @param index
     *        integer specifying the index
     *
     * @param newItem
     *        Item to store
     *
     * @param observers
     *        comma separated sequence of {@link ValueObserver} instances
     *        attending the operation
     *
     * @throws SequenceIndexOutOfBoundsException
     *         if {@code index < getFirstIndex() || index > getLastIndex()}
     *
     * @throws RuntimeException
     *         if a {@link ValueObserver} in {@code observers} throws this
     *         {@link RuntimeException}
     */
    @SuppressWarnings("unchecked")
    protected void replace(final int index, final Item newItem, final ValueObserver<Item>... observers)
    throws SequenceIndexOutOfBoundsException, RuntimeException {
        IndexSequenceUtility.assertIndexValid(this, index);

        replaceStoredItem(index, newItem, observers);
    }

    /**
     * Replaces the Item stored at the specified index in this
     * {@link AbstractInitializeableIndexSequence} by the specified Item
     * assuming the index to be valid.
     *
     * @param index
     *        integer specifying the valid index
     *
     * @param newItem
     *        Item to store
     */
    protected abstract void replaceStoredItem(final int index, final Item newItem);

    /**
     * Replaces the Item stored at the specified index in this
     * {@link AbstractInitializeableIndexSequence} by the specified Item
     * expecting the index to be valid.
     *
     * @param index
     *        integer specifying the valid index
     *
     * @param newItem
     *        Item to store
     *
     * @param observers
     *        comma separated sequence of {@link ValueObserver} instances
     *        attending the operation
     *
     * @throws RuntimeException
     *         if a {@link ValueObserver} in {@code observers} throws this
     *         {@link RuntimeException}
     */
    @SuppressWarnings("unchecked")
    protected final void replaceStoredItem(final int index, final Item newItem, final ValueObserver<Item>... observers)
    throws RuntimeException {
        ObserverUtility.operate(new HandledOperator() {

            @Override
            public void operate() {
                replaceStoredItem(index, newItem);
            }
        },

                                newItem, observers);
    }
}
