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

import org.jlib.container.Container;
import org.jlib.container.sequence.IllegalSequenceSizeException;
import org.jlib.container.sequence.Sequence;
import org.jlib.container.sequence.index.AbstractInitializeableIndexSequence;
import org.jlib.container.sequence.index.IndexSequence;
import org.jlib.container.sequence.index.InvalidSequenceIndexRangeException;
import org.jlib.core.observer.ObserverUtility;
import org.jlib.core.observer.Operator;
import org.jlib.core.observer.ValueObserver;

import static org.jlib.core.array.ArrayUtility.createArray;

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

    /** array holding the Items of this {@link ArraySequence} */
    private Item[] delegateArray;

    /**
     * Creates a new uninitialized {@link ArraySequence} with the specified
     * first and last indices.
     * 
     * @param firstIndex
     *        integer specifying the minimum index of this {@link ArraySequence}
     * 
     * @param lastIndex
     *        integer specifying the maximum index of this {@link ArraySequence}
     * 
     * @throws InvalidSequenceIndexRangeException
     *         if {@code lastIndex < firstIndex}
     */
    protected ArraySequence(final int firstIndex, final int lastIndex)
    throws InvalidSequenceIndexRangeException {
        super(firstIndex, lastIndex);

        delegateArray = createArray(getItemsCount());
    }

    /**
     * Creates a new {@link ArraySequence}.
     * 
     * @param items
     */
    public ArraySequence(final Collection<? extends Item> items) {
        super(items);
    }

    /**
     * Creates a new {@link ArraySequence}.
     * 
     * @param items
     */
    public ArraySequence(final Container<? extends Item> items) {
        super(items);
    }

    /**
     * Creates a new {@link ArraySequence}.
     * 
     * @param firstIndex
     * @param items
     */
    public ArraySequence(final int firstIndex, final Collection<? extends Item> items) {
        super(firstIndex, items);
    }

    /**
     * Creates a new {@link ArraySequence}.
     * 
     * @param firstIndex
     * @param items
     */
    public ArraySequence(final int firstIndex, final Container<? extends Item> items) {
        super(firstIndex, items);
    }

    /**
     * Creates a new {@link ArraySequence}.
     * 
     * @param firstIndex
     * @param items
     */
    public ArraySequence(final int firstIndex, final Item... items) {
        super(firstIndex, items);
    }

    /**
     * Creates a new {@link ArraySequence}.
     * 
     * @param size
     * @throws IllegalSequenceSizeException
     */
    public ArraySequence(final int size)
    throws IllegalSequenceSizeException {
        super(size);
    }

    /**
     * Creates a new {@link ArraySequence}.
     * 
     * @param items
     */
    public ArraySequence(final Item... items) {
        super(items);
    }

    /**
     * Creates a new {@link ArraySequence}.
     * 
     * @param observers
     * @param items
     */
    public ArraySequence(final ValueObserver<Item>[] observers, final Item... items) {
        super(observers, items);
    }

    /**
     * Returns the Item stored at the specified index expecting the index to be
     * valid.
     * 
     * @param index
     *        integer specifying the valid index
     * 
     * @return Item stored at {@code index}
     */
    @Override
    protected Item getStoredItem(final int index) {
        return getDelegateArrayItem(getDelegateArrayIndex(index));
    }

    @Override
    protected void replaceStoredItem(final int index, final Item item) {
        replaceDelegateArrayItem(getDelegateArrayIndex(index), item);
    }

    @Override
    @SuppressWarnings("unchecked")
    protected void replaceStoredItem(final int index, final Item newItem, final ValueObserver<Item>... observers) {
        ObserverUtility.operate(new Operator() {

            @Override
            public void operate() {
                replaceStoredItem(getDelegateArrayIndex(index), newItem);
            }
        },

        newItem, observers); // throws SequenceIndexOutOfBoundsException
    }

    /**
     * Returns the delegate array index in the specified index in this
     * {@link ArraySequence}.
     * 
     * @param index
     *        integer specifying the index of the Item in the
     *        {@link ArraySequence}
     * 
     * @return integer specifying the corresponding index in the delegate array
     */
    protected int getDelegateArrayIndex(final int index) {
        return index - getFirstIndex();
    }

    /**
     * Returns the Item stored in the delegate array at the specified index.
     * Provides a typesafe access to the (non generic) array.
     * 
     * @param arrayIndex
     *        index of the Item in the array
     * 
     * @return Item stored at {@code arrayIndex} in the array
     */
    protected Item getDelegateArrayItem(final int arrayIndex) {
        return delegateArray[arrayIndex];
    }

    /**
     * Replaces the Item stored in the delegate array at the specified index.
     * Provides a typesafe access to the (non generic) array.
     * 
     * @param arrayIndex
     *        integer specifying the index of the Item in the array
     * 
     * @param item
     *        replacing Item
     */
    protected void replaceDelegateArrayItem(final int arrayIndex, final Item item) {
        delegateArray[arrayIndex] = item;
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
     * @throws IllegalArgumentException
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
     * @throws InvalidDelegateArrayCapacityException
     *         if
     *         {@code expectedCapacity < 1 || getSize() + holeSize > expectedCapacity}
     */
    protected void assertCapacityWithHole(final int expectedCapacity, final int holeArrayIndex, final int holeSize)
    throws InvalidDelegateArrayCapacityException {
        assertExpectedCapacityValid(expectedCapacity);

        // @formatter:off
        if (getItemsCount() + holeSize > expectedCapacity)
            throw new InvalidDelegateArrayCapacityException
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
     * @throws InvalidDelegateArrayCapacityException
     *         if {@code expectedCapacity < 1}
     */
    protected void assertExpectedCapacityValid(final int expectedCapacity)
    throws InvalidDelegateArrayCapacityException {
        if (expectedCapacity < 1)
            throw new InvalidDelegateArrayCapacityException(this, expectedCapacity, "{0}: expectedCapacity == {1} < 1");
    }
}
