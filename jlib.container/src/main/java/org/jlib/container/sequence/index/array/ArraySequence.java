/*
 * jlib - The Free Java Library
 * 
 * http://www.jlib.org
 * 
 * Copyright (c) 2006-2008 Igor Akkerman
 * 
 * jlib is distributed under the
 * 
 * COMMON PUBLIC LICENSE VERSION 1.0
 * 
 * http://www.opensource.org/licenses/cpl1.0.php
 */

package org.jlib.container.sequence.index.array;

import java.util.Collection;

import org.jlib.core.observer.ObserverUtility;
import org.jlib.core.observer.Operator;
import org.jlib.core.observer.ValueObserver;

import org.jlib.container.Container;
import org.jlib.container.sequence.InvalidSequenceItemsCountException;
import org.jlib.container.sequence.Sequence;
import org.jlib.container.sequence.index.AbstractInitializeableIndexSequence;
import org.jlib.container.sequence.index.IndexSequence;
import org.jlib.container.sequence.index.InvalidSequenceIndexRangeException;
import org.jlib.container.sequence.index.array.storage.ArrayStorage;
import org.jlib.container.sequence.index.array.storage.LinearIndexStorage;
import org.jlib.container.sequence.index.array.storage.LinearIndexStorageCapacityStrategy;
import org.jlib.container.sequence.index.array.storage.MinimalLinearIndexStorageCapacityStrategy;

// @formatter:off
/**
 * {@link IndexSequence} baked by an array.
 * 
 * @param <Item>
 *        type of items held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
// @formatter:on
public class ArraySequence<Item>
extends AbstractInitializeableIndexSequence<Item> {

    /** {@link LinearIndexStorage} used to store the Items */
    private LinearIndexStorage<Item> storage = new ArrayStorage<>();

    /**
     * {@link LinearIndexStorageCapacityStrategy} used to adjust the
     * {@link LinearIndexStorage} capacity
     */
    private final LinearIndexStorageCapacityStrategy capacityStrategy =
        new MinimalLinearIndexStorageCapacityStrategy<>(storage);

    /**
     * Creates a new uninitialized {@link ArraySequence} with the specified
     * first and last indices.
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
    protected ArraySequence(final int firstIndex, final int lastIndex)
    throws InvalidSequenceIndexRangeException {
        super(firstIndex, lastIndex);
    }

    /**
     * Creates a new {@link ArraySequence} with a first index of {@code 0} and
     * the specified number of Items.
     * 
     * @param itemsCount
     *        integer specifying the initial number of Items
     * 
     * @throws InvalidSequenceItemsCountException
     *         if {@code itemsCount < 1}
     */
    public ArraySequence(final int itemsCount)
    throws InvalidSequenceItemsCountException {
        super(itemsCount);
    }

    /**
     * Creates a new {@link ArraySequence} with a first index of {@code 0}
     * containing the specified Items.
     * 
     * @param items
     *        comma separated sequence of Items to store
     */
    @SafeVarargs
    public ArraySequence(final Item... items) {
        super(items);
    }

    /**
     * Creates a new {@link ArraySequence} with the specified first index
     * containing the specified Items.
     * 
     * @param firstIndex
     *        integer specifying the first index
     * 
     * @param items
     *        comma separated sequence of Items to store
     */
    @SafeVarargs
    public ArraySequence(final int firstIndex, final Item... items) {
        super(firstIndex, items);
    }

    /**
     * Creates a new {@link ArraySequence} with a first index of {@code 0}
     * containing the specified Items.
     * 
     * @param items
     *        {@link Collection} of Items to store
     */
    public ArraySequence(final Collection<? extends Item> items) {
        super(items);
    }

    /**
     * Creates a new {@link ArraySequence} with the specified first index
     * containing the specified Items.
     * 
     * @param firstIndex
     *        integer specifying the first index
     * 
     * @param items
     *        {@link Collection} of Items to store
     */
    public ArraySequence(final int firstIndex, final Collection<? extends Item> items) {
        super(firstIndex, items);
    }

    /**
     * Creates a new {@link ArraySequence} with a first index of {@code 0}
     * containing the specified Items.
     * 
     * @param items
     *        {@link Container} of Items to store
     */
    public ArraySequence(final Container<? extends Item> items) {
        super(items);
    }

    /**
     * Creates a new {@link ArraySequence} with the specified first index
     * containing the specified Items.
     * 
     * @param firstIndex
     *        integer specifying the first index
     * 
     * @param items
     *        {@link Container} of Items to store
     */
    public ArraySequence(final int firstIndex, final Container<? extends Item> items) {
        super(firstIndex, items);
    }

    @Override
    protected void initialize() {
        storage.initialize(getItemsCount(), getFirstIndex(), getLastIndex());
    }

    @Override
    protected Item getStoredItem(final int index) {
        return getStorageItem(getStorageItemIndex(index));
    }

    @Override
    protected void replaceStoredItem(final int index, final Item newItem) {
        replaceDelegateArrayItem(getStorageItemIndex(index), newItem);
    }

    /**
     * Returns the {@link LinearIndexStorage} index in the specified index in
     * this {@link ArraySequence}.
     * 
     * @param index
     *        integer specifying the index of the Item in the
     *        {@link ArraySequence}
     * 
     * @return integer specifying the corresponding index in the delegate
     *         {@link LinearIndexStorage}
     */
    protected int getStorageItemIndex(final int index) {
        return index - getFirstIndex() + storage.getFirstItemIndex();
    }

    /**
     * Returns the Item stored in {@link LinearIndexStorage} at its specified
     * index.
     * 
     * @param storageItemIndex
     *        integer specifying the Item index in the
     *        {@link LinearIndexStorage}
     * 
     * @return Item stored at {@code storageItemIndex} in the
     *         {@link LinearIndexStorage}
     */
    private Item getStorageItem(final int storageItemIndex) {
        return storage.getItem(storageItemIndex);
    }

    /**
     * Replaces the Item stored in the delegate array at the specified index.
     * 
     * @param itemArrayIndex
     *        integer specifying the index of the Item in the array
     * 
     * @param newItem
     *        replacing Item
     * 
     * @param observers
     *        comma separated sequence of {@link ValueObserver} instances
     *        attending the operation
     * 
     * @throws RuntimeException
     *         if a {@link ValueObserver} operation throws this
     *         {@link RuntimeException}
     */
    @SafeVarargs
    protected final void replaceDelegateArrayItem(final int itemArrayIndex, final Item newItem,
                                                  final ValueObserver<Item>... observers)
    throws RuntimeException {
        ObserverUtility.operate(new Operator() {

            @Override
            public void operate() {
                replaceDelegateArrayItem(itemArrayIndex, newItem);
            }
        },

        newItem, observers);
    }

    @Override
    public ArraySequence<Item> clone() {
        @SuppressWarnings("unchecked")
        final ArraySequence<Item> clonedSequence = (ArraySequence<Item>) super.clone();

        clonedSequence.storage = storage.clone();

        return clonedSequence;
    }

    @Override
    public int hashCode() {
        return super.hashCode() << 1 + storage.hashCode();
    }
}
