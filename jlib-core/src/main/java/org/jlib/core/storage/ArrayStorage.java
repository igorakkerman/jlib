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

package org.jlib.core.storage;

import static org.jlib.core.array.ArrayUtility.createArray;

import org.jlib.core.storage.indexrangeoperation.IndexRangeOperationDescriptor;
import org.jlib.core.system.AbstractCloneable;

import static java.lang.System.arraycopy;
import static java.util.Arrays.copyOf;

/**
 * {@link LinearIndexStorage} based on an array.
 *
 * @param <Item>
 *        type of the items stored in the array
 *
 * @author Igor Akkerman
 */
public class ArrayStorage<Item>
extends AbstractCloneable
implements LinearIndexStorage<Item> {

    /** array holding the {@link Item}s */
    private Item[] delegateArray;

    /**
     * Creates a new {@link ArrayStorage} with the specified initial capacity.
     *
     * @param initialCapacity
     *        integer specifying the initial capacity
     */
    public ArrayStorage(final int initialCapacity)
    throws InvalidCapacityException {
        super();

        ensureCapacityValid("initialCapacity", initialCapacity);

        delegateArray = createArray(initialCapacity);
    }

    @Override
    public void addCapacityAndShiftItems(final int capacity, final IndexRangeOperationDescriptor... copyDescriptors) {

        ensureCapacityValid("capacity", capacity);

        final Item[] newDelegateArray = createArray(delegateArray.length + capacity);

        copyItemsTo(newDelegateArray, copyDescriptors);

        delegateArray = newDelegateArray;
    }

    private void copyItems(final Item[] newDelegateArray, final IndexRangeOperationDescriptor[] copyDescriptors) {
        copyItemsTo(newDelegateArray, copyDescriptors);
    }

    @Override
    public Item getItem(final int index) {
        return delegateArray[index];
    }

    @Override
    public void replaceItem(final int index, final Item item) {
        delegateArray[index] = item;
    }

    /**
     * Copies ranges of {@link Item}s defined by the specified {@link IndexRangeOperationDescriptor} from the specified
     * source to the specified target array.
     *
     * @param sourceArray
     *        source array of {@link Item}s
     *
     * @param targetArray
     *        target array of {@link Item}s
     *
     * @param copyDescriptor
     *        {@link IndexRangeOperationDescriptor} for the operation
     */
    protected void copyItems(final Item[] sourceArray, final Item[] targetArray,
                             final IndexRangeOperationDescriptor copyDescriptor)
    throws InvalidIndexException {
        final int sourceBeginIndex = copyDescriptor.getSourceBeginIndex();
        final int sourceEndIndex = copyDescriptor.getSourceEndIndex();
        final int targetIndex = copyDescriptor.getTargetIndex();
        final int capacity = getCapacity();

        if (sourceBeginIndex < 0)
            throw new InvalidIndexException(this, "sourceBeginIndex = {1} < 0", sourceBeginIndex);

        if (sourceEndIndex < sourceBeginIndex)
            throw new InvalidIndexException(this, "sourceEndIndex = {1} < {2} = sourceBeginIndex", sourceEndIndex,
                                            sourceBeginIndex);

        if (targetIndex > capacity - 1)
            throw new InvalidIndexException(this, "targetIndex = {1} < {2} = capacity", targetIndex, capacity);

        arraycopy(sourceArray, sourceBeginIndex, targetArray, copyDescriptor.getTargetIndex(),
                  copyDescriptor.getSourceEndIndex() - copyDescriptor.getSourceEndIndex() + 1);
    }

    private void copyItemsTo(final Item[] targetArray, final IndexRangeOperationDescriptor... copyDescriptors) {
        for (final IndexRangeOperationDescriptor copyDescriptor : copyDescriptors)
            copyItems(delegateArray, targetArray, copyDescriptor);
    }

    @Override
    public void shiftItems(final IndexRangeOperationDescriptor... shiftDescriptors)
    throws IndexOutOfBoundsException {
        copyItemsTo(delegateArray, shiftDescriptors);
    }

    @Override
    public int getCapacity() {
        return delegateArray.length;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Object clone() {
        final ArrayStorage<Item> cloneStorage = (ArrayStorage<Item>) super.clone();

        cloneStorage.delegateArray = copyOf(delegateArray, delegateArray.length);

        return cloneStorage;
    }

    /**
     * Ensures the specified capacity is valid.
     *
     * @param capacity
     *        integer specifying a capacity
     *
     * @throws InvalidCapacityException
     *         if {@code capacity < 0}
     */
    private void ensureCapacityValid(final String capacityName, final int capacity)
    throws InvalidCapacityException {
        if (capacity < 0)
            throw new InvalidCapacityException(this, capacity);
    }
}
