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

package org.jlib.container.sequence.index.array;

import java.util.Collection;

import static org.jlib.core.array.ArrayUtility.iterable;

import static org.jlib.container.sequence.SequenceUtility.singleton;

import org.jlib.container.Container;
import org.jlib.container.sequence.InvalidSequenceItemsCountException;
import org.jlib.container.sequence.Sequence;
import org.jlib.container.sequence.index.DefaultReplaceInsertIndexSequenceTraverser;
import org.jlib.container.sequence.index.IndexSequenceUtility;
import org.jlib.container.sequence.index.InsertIndexSequence;
import org.jlib.container.sequence.index.InvalidSequenceIndexException;
import org.jlib.container.sequence.index.SubReplaceInsertIndexSequence;
import org.jlib.core.observer.ObserverUtility;
import org.jlib.core.observer.ValueObserver;
import org.jlib.core.operator.HandledOperator;
import org.jlib.core.traverser.InvalidTraversibleStateException;

/**
 * {@link ReplaceAppendArraySequence} into which Items can be inserted.
 *
 * @param <Item>
 *        type of items held in the {@link Sequence}
 *
 * @author Igor Akkerman
 */
public class ReplaceInsertArraySequence<Item>
extends ReplacePrependAppendArraySequence<Item>
implements ObservedReplaceInsertIndexSequence<Item> {

    /**
     * Creates a new uninitialized {@link ReplaceInsertArraySequence} with the
     * specified first and last indices.
     *
     * @param firstIndex
     *        integer specifying the initial first index
     *
     * @param lastIndex
     *        integer specifying the initial last index
     *
     * @throws InvalidSequenceIndexException
     *         if {@code lastIndex < firstIndex}
     */
    protected ReplaceInsertArraySequence(final int firstIndex, final int lastIndex)
    throws InvalidSequenceIndexException {
        super(firstIndex, lastIndex);
    }

    /**
     * Creates a new {@link ReplaceInsertArraySequence} with a first index of
     * {@code 0} and the specified number of Items.
     *
     * @param itemsCount
     *        integer specifying the initial number of Items
     *
     * @throws InvalidSequenceItemsCountException
     *         if {@code itemsCount < 1}
     */
    protected ReplaceInsertArraySequence(final int itemsCount)
    throws InvalidSequenceItemsCountException {
        super(itemsCount);
    }

    /**
     * Creates a new {@link ReplaceInsertArraySequence} with a first index of
     * {@code 0} containing the specified Items.
     *
     * @param items
     *        comma separated sequence of Items to store
     */
    @SafeVarargs
    public ReplaceInsertArraySequence(final Item... items) {
        super(items);
    }

    /**
     * Creates a new {@link ReplaceInsertArraySequence} with the specified first
     * index containing the specified Items.
     *
     * @param firstIndex
     *        integer specifying the first index
     *
     * @param items
     *        comma separated sequence of Items to store
     */
    @SafeVarargs
    public ReplaceInsertArraySequence(final int firstIndex, final Item... items) {
        super(firstIndex, items);
    }

    /**
     * Creates a new {@link ReplaceInsertArraySequence} with a first index of
     * {@code 0} containing the specified Items.
     *
     * @param items
     *        {@link Collection} of Items to store
     */
    public ReplaceInsertArraySequence(final Collection<? extends Item> items) {
        super(items);
    }

    /**
     * Creates a new {@link ReplaceInsertArraySequence} with the specified first
     * index containing the specified Items.
     *
     * @param firstIndex
     *        integer specifying the first index
     *
     * @param items
     *        {@link Collection} of Items to store
     */
    public ReplaceInsertArraySequence(final int firstIndex, final Collection<? extends Item> items) {
        super(firstIndex, items);
    }

    /**
     * Creates a new {@link ReplaceInsertArraySequence} with a first index of
     * {@code 0} containing the specified Items.
     *
     * @param items
     *        {@link Container} of Items to store
     */
    public ReplaceInsertArraySequence(final Container<? extends Item> items) {
        super(items);
    }

    /**
     * Creates a new {@link ReplaceInsertArraySequence} with the specified first
     * index containing the specified Items.
     *
     * @param firstIndex
     *        integer specifying the first index
     *
     * @param items
     *        {@link Container} of Items to store
     */
    public ReplaceInsertArraySequence(final int firstIndex, final Container<? extends Item> items) {
        super(firstIndex, items);
    }

    @Override
    public void insert(final int index, final Item item) {
        insert(index, singleton(item));
    }

    @Override
    public void insert(final int index, final Container<? extends Item> items) {
        insert(index, items, items.getItemsCount());
    }

    @Override
    public void insert(final int index, final Collection<? extends Item> items) {
        insert(index, items, items.size());
    }

    @Override
    @SuppressWarnings("unchecked")
    public void insert(final int index, final Item... items) {
        insert(index, iterable(items), items.length);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void insert(final int index, final Item item, final ValueObserver<Item>... observers)
    throws InvalidSequenceIndexException, InvalidTraversibleArgumentException, InvalidTraversibleStateException {
        insert(index, singleton(item), 1, observers);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void insert(final int index, final Container<? extends Item> items, final ValueObserver<Item>... observers) {
        insert(index, items, items.getItemsCount(), observers);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void insert(final int index, final Collection<? extends Item> items, final ValueObserver<Item>... observers) {
        insert(index, items, items.size(), observers);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void insert(final int index, final ValueObserver<Item>[] observers, final Item... items) {
        insert(index, iterable(items), items.length, observers);
    }

    /**
     * Inserts the specified Items at the specified index of this
     * {@link InsertIndexSequence}.
     *
     * @param index
     *        integer specifying the index
     *
     * @param items
     *        {@link Collection} holding the Items to insert
     *
     * @param insertedItemsCount
     *        integer specifying the number of inserted Items
     *
     * @throws InvalidSequenceIndexException
     *         if {@code index < getFirstIndex() || index > getLastIndex()}
     */
    private void insert(final int index, final Iterable<? extends Item> items, final int insertedItemsCount) {
        IndexSequenceUtility.assertIndexValid(this, index);

        int storageItemIndex = getStorageItemIndex(index);

        getCapacityStrategy().ensureSplitCapacity(insertedItemsCount, storageItemIndex);

        for (final Item item : items)
            replace(storageItemIndex++, item);

        setLastIndex(getLastIndex() + insertedItemsCount);
        getStorage().incrementLastItemIndex(insertedItemsCount);
    }

    /**
     * Inserts the specified Items at the specified index of this
     * {@link InsertIndexSequence}.
     *
     * @param index
     *        integer specifying the index
     *
     * @param items
     *        {@link Collection} holding the Items to insert
     *
     * @param insertedItemsCount
     *        integer specifying the number of inserted Items
     *
     * @param observers
     *        comma separated sequence of {@link ValueObserver} instances
     *        attending the operation
     *
     * @throws InvalidSequenceIndexException
     *         if {@code index < getFirstIndex() || index > getLastIndex()}
     */
    @SafeVarargs
    private final void insert(final int index, final Iterable<? extends Item> items, final int insertedItemsCount, final ValueObserver<Item>... observers) {
        IndexSequenceUtility.assertIndexValid(this, index);

        int storageItemIndex = getStorageItemIndex(index);

        getCapacityStrategy().ensureSplitCapacity(insertedItemsCount, storageItemIndex);

        for (final Item item : items) {
            final int currentStorageItemIndex = storageItemIndex++;
            ObserverUtility.operate(new HandledOperator() {

                @Override
                public void operate() {
                    getStorage().replaceItem(currentStorageItemIndex, item);
                }
            },

                                    item, observers);
        }

        setLastIndex(getLastIndex() + insertedItemsCount);
        getStorage().incrementLastItemIndex(insertedItemsCount);
    }

    @Override
    public ObservedReplaceInsertIndexSequence<Item> getSubsequenceView(final int fromIndex, final int toIndex)
    throws InvalidSequenceIndexException, InvalidSequenceIndexException {
        return new SubReplaceInsertIndexSequence<Item, ReplaceInsertArraySequence<Item>>(this, fromIndex, toIndex);
    }

    @Override
    public ObservedReplaceInsertIndexSequenceTraverser<Item> createTraverser() {
        return createTraverser(getFirstIndex());
    }

    @Override
    public ObservedReplaceInsertIndexSequenceTraverser<Item> createTraverser(final int startIndex)
    throws InvalidSequenceIndexException {
        return new DefaultReplaceInsertIndexSequenceTraverser<>(this, startIndex);
    }
}
