/*
 * jlib - Open Source Java Library
 *
 *     www.jlib.org
 *
 *
 *     Copyright 2005-2015 Igor Akkerman
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

package org.jlib.container.storage.array;

import org.jlib.core.language.Valid;

import org.jlib.container.storage.AbstractLinearIndexStorage;
import org.jlib.container.storage.IndexRangeOperationDescriptor;
import org.jlib.container.storage.InvalidCapacityException;
import org.jlib.container.storage.InvalidIndexException;
import org.jlib.container.storage.LinearIndexStorage;

import static java.lang.System.arraycopy;
import static java.util.Arrays.copyOf;
import static org.jlib.core.array.ArrayUtility.array;
import static org.jlib.core.math.NumberUtility.count;

/**
 * {@link LinearIndexStorage} based on an array.
 *
 * @param <Item>
 *        type of the items stored in the array
 *
 * @author Igor Akkerman
 */

public class ArrayStorage<Item>
extends AbstractLinearIndexStorage<Item> {

    /** array holding the {@link Item}s */
    private Item[] delegateArray;

    public ArrayStorage(final int initialCapacity)
    throws InvalidCapacityException {
        super(initialCapacity);

        delegateArray = array(initialCapacity);
    }

    @Override
    public int capacity() {
        return delegateArray.length;
    }

    @Override
    protected Item safeGet(@Valid final int index) {
        return delegateArray[index];
    }

    @Override
    protected void safeSet(@Valid final int index, final Item item) {
        delegateArray[index] = item;
    }

    @Override
    protected void safeAddCapacityAndShiftItems(@Valid final int capacity,
                                                @Valid final IndexRangeOperationDescriptor... copyDescriptors) {
        final Item[] newDelegateArray = array(delegateArray.length + capacity);

        copyItemsTo(newDelegateArray, copyDescriptors);

        delegateArray = newDelegateArray;
    }

    @Override
    public void shiftItems(final IndexRangeOperationDescriptor... shiftDescriptors)
    throws IndexOutOfBoundsException {
        copyItemsTo(delegateArray, shiftDescriptors);
    }

    private void copyItemsTo(final Item[] targetArray, final IndexRangeOperationDescriptor... copyDescriptors) {
        for (final IndexRangeOperationDescriptor copyDescriptor : copyDescriptors)
            copyItems(delegateArray, targetArray, copyDescriptor);
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

        validateOperationDescriptor(copyDescriptor);

        arraycopy(sourceArray, copyDescriptor.getSourceRange().getMinimum(), targetArray,
                  copyDescriptor.getTargetIndex(),
                  count(copyDescriptor.getSourceRange().getMinimum(), copyDescriptor.getSourceRange().getMaximum()));
    }

    @Override
    @SuppressWarnings("unchecked")
    public ArrayStorage<Item> clone() {
        final ArrayStorage<Item> cloneStorage = (ArrayStorage<Item>) super.clone();

        cloneStorage.delegateArray = copyOf(delegateArray, delegateArray.length);

        return cloneStorage;
    }
}
