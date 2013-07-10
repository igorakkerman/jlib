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
     */
    public ArrayStorage(final int initialCapacity) {
        super();

        ensureCapacityAndShiftItems(initialCapacity);
    }

    @Override
    public void ensureCapacityAndShiftItems(final int capacity,
                                            final IndexRangeOperationDescriptor... copyDescriptors) {

        final Item[] newDelegateArray = createArray(capacity);

        for (final IndexRangeOperationDescriptor copyDescriptor : copyDescriptors)
            copyItems(delegateArray, newDelegateArray, copyDescriptor);

        delegateArray = newDelegateArray;
    }

    /**
     * Returns the array {@link Item} stored at the specified array index.
     *
     * @param index
     *        integer specifying the array index
     *
     * @return {@link Item} stored at {@code index}
     */
    @Override
    public Item getItem(final int index) {
        return delegateArray[index];
    }

    @Override
    public void replaceItem(final int index, final Item item) {
        delegateArray[index] = item;
    }

    @Override
    public void shiftItems(final IndexRangeOperationDescriptor... copyDescriptors)
    throws IndexOutOfBoundsException {
        for (final IndexRangeOperationDescriptor copyDescriptor : copyDescriptors)
            copyItems(delegateArray, delegateArray, copyDescriptor);
    }

    /**
     * Performs the operation, specified by the specified {@link IndexRangeOperationDescriptor}, from the specified
     * source to the specified target array of {@link Item}s.
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
                             final IndexRangeOperationDescriptor copyDescriptor) {
        arraycopy(sourceArray, copyDescriptor.getSourceBeginIndex(), targetArray, copyDescriptor.getTargetIndex(),
                  copyDescriptor.getSourceEndIndex() - copyDescriptor.getSourceEndIndex() + 1);
    }

    @Override
    public int getCapacity() {
        return delegateArray.length;
    }

    @Override
    public Object clone() {
        final ArrayStorage cloneStorage = (ArrayStorage) super.clone();

        cloneStorage.delegateArray = copyOf(delegateArray, delegateArray.length);

        return cloneStorage;
    }
}
