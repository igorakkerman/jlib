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

import java.util.Arrays;
import java.util.Collection;

import org.jlib.core.observer.ObserverUtility;
import org.jlib.core.observer.Operator;
import org.jlib.core.observer.ValueObserver;

import static org.jlib.core.array.ArrayUtility.createArray;

import org.jlib.container.Container;
import org.jlib.container.sequence.InvalidSequenceItemsCountException;
import org.jlib.container.sequence.Sequence;
import org.jlib.container.sequence.index.AbstractInitializeableIndexSequence;
import org.jlib.container.sequence.index.IndexSequence;
import org.jlib.container.sequence.index.InvalidSequenceIndexRangeException;
import org.jlib.container.sequence.index.array.storage.ArrayStorage;
import org.jlib.container.sequence.index.array.storage.LinearIndexStorage;
import org.jlib.container.sequence.index.array.storage.LinearIndexStorageCapacityStrategy;
import org.jlib.container.sequence.index.array.storage.LinearIndexStorageCapacityStrategyFactory;
import org.jlib.container.sequence.index.array.storage.LinearIndexStorageException;
import org.jlib.container.sequence.index.array.storage.MinimalLinearIndexStorageCapacityStrategy;
import org.jlib.container.sequence.index.array.storage.MinimalLinearIndexStorageCapacityStrategyFactory;

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
extends AbstractInitializeableIndexSequence<Item>
implements Cloneable {

    /**
     * {@link LinearIndexStorageCapacityStrategyFactory} used to create
     * {@link LinearIndexStorageCapacityStrategy} used to adjust the
     * {@link LinearIndexStorage} capacity
     */
    private static final LinearIndexStorageCapacityStrategyFactory capacityStrategyFactory =
        MinimalLinearIndexStorageCapacityStrategyFactory.getInstance();

    /** {@link LinearIndexStorage} used to store the Items */
    private LinearIndexStorage<Item> storage;

    /**
     * {@link LinearIndexStorageCapacityStrategy} used to adjust the
     * {@link LinearIndexStorage} capacity
     */
    private LinearIndexStorageCapacityStrategy capacityStrategy;

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
        storage = new ArrayStorage<>(getLastIndex(), getItemsCount(), getFirstIndex())
        storage.initialize(getItemsCount());
    }

    @Override
    protected Item getStoredItem(final int index) {
        return getStorageItem(getStorageIndex(index));
    }

    @Override
    protected void replaceStoredItem(final int index, final Item newItem) {
        replaceDelegateArrayItem(getStorageIndex(index), newItem);
    }

    /**
     * Returns the delegate {@link LinearIndexStorage} index in the specified
     * index in this {@link ArraySequence}.
     * 
     * @param index
     *        integer specifying the index of the Item in the
     *        {@link ArraySequence}
     * 
     * @return integer specifying the corresponding index in the delegate
     *         {@link LinearIndexStorage}
     */
    protected int getStorageIndex(final int index) {
        return index - getFirstIndex() + storage.getFirstItemIndex();
    }

    @Override
    public ArraySequence<Item> clone() {
        final ArraySequence<Item> cloneSequence = new ArraySequence<Item>(getFirstIndex(), getLastIndex());

        final int delegateArrayLength = delegateArray.length;

        final Object[] cloneSequenceDelegateArray = cloneSequence.delegateArray;

        for (int delegateArrayIndex = 0; delegateArrayIndex < delegateArrayLength; delegateArrayIndex ++)
            cloneSequenceDelegateArray[delegateArrayIndex] = delegateArray[delegateArrayIndex];

        return cloneSequence;
    }

    @Override
    public int hashCode() {
        return super.hashCode() << 1;
    }

    /**
     * Asserts that the delegate array has the specified expected capacity,
     * replacing it by a larger {@code null} padded copy, if necessary.
     * 
     * @param expectedCapacity
     *        integer specifying the expected capacity
     * 
     * @throws LinearIndexStorageException
     *         if {@code expectedCapacity < 1}
     */
    protected void assertCapacity(final int expectedCapacity) {
        assertExpectedCapacityValid(expectedCapacity);

        if (delegateArray.length < expectedCapacity)
            delegateArray = Arrays.copyOf(delegateArray, expectedCapacity);
    }

    /**
     * Asserts that the delegate array has the specified expected capacity,
     * replacing it by a larger {@code null} padded copy, if necessary.
     * 
     * @param expectedCapacity
     *        integer specifying the expected capacity
     * 
     * @param holeArrayIndex
     *        integer specifying the insert index
     * 
     * @param holeSize
     *        integer specifying the size of the hole
     * 
     * @throws LinearIndexStorageException
     *         if
     *         {@code expectedCapacity < 1 || getSize() + holeSize > expectedCapacity}
     */
    protected void assertCapacityWithHole(final int expectedCapacity, final int holeArrayIndex, final int holeSize)
    throws LinearIndexStorageException {
        assertExpectedCapacityValid(expectedCapacity);

        // @formatter:off
        if (getItemsCount() + holeSize > expectedCapacity)
            throw new LinearIndexStorageException
                (this, expectedCapacity, "{0}: getSize() + items.length == {2} + {3} > {1} == expectedCapacity",
                 getItemsCount(), holeSize);
        // @formatter:on

        final Item[] originalDelegateArray = delegateArray;

        if (delegateArray.length < expectedCapacity) {
            delegateArray = createArray(expectedCapacity);

            System.arraycopy(originalDelegateArray, 0, delegateArray, 0, holeArrayIndex);
        }

        System.arraycopy(originalDelegateArray, holeArrayIndex, delegateArray, holeArrayIndex + holeSize,
                         getItemsCount() - holeArrayIndex);

        Arrays.fill(delegateArray, getItemsCount() + expectedCapacity, delegateArray.length, null);
    }

    /**
     * Asserts that the specified expected capacity is valid.
     * 
     * @param expectedCapacity
     *        integer specifying the expected capacity
     * 
     * @throws LinearIndexStorageException
     *         if {@code expectedCapacity < 1}
     */
    protected void assertExpectedCapacityValid(final int expectedCapacity)
    throws LinearIndexStorageException {
        if (expectedCapacity < 1)
            throw new LinearIndexStorageException(this, expectedCapacity, "{0}: expectedCapacity == {1} < 1");
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
}
