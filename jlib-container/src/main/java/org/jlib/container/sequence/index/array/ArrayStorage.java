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

import java.util.Arrays;

import static org.jlib.core.array.ArrayUtility.createArray;

import org.jlib.core.storage.AbstractLinearIndexStorage;
import org.jlib.core.storage.ItemsCopyDescriptor;
import org.jlib.core.storage.LinearIndexStorage;

import static java.lang.Math.min;
import static java.lang.System.arraycopy;
import static java.util.Arrays.fill;

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

    /**
     * Creates a new {@link ArrayStorage} with the specified capacity.
     */
    public ArrayStorage() {
        super();
    }

    @Override
    protected void initializeDelegate(final int capacity, final int firstItemIndex, final int lastItemIndex,
                                      final ItemsCopyDescriptor... copyDescriptors) {

        final Item[] newDelegateArray = createArray(capacity);

        for (final ItemsCopyDescriptor copyDescriptor : copyDescriptors)
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
    public void shiftItems(final ItemsCopyDescriptor... copyDescriptors)
    throws IndexOutOfBoundsException {
        for (final ItemsCopyDescriptor copyDescriptor : copyDescriptors) {
            copyItems(delegateArray, delegateArray, copyDescriptor);

            // replace the shifted Items with null
            // TODO 2013-07-06: is this really necessary?
            fill(delegateArray, copyDescriptor.getSourceBeginIndex(),
                 min(copyDescriptor.getSourceEndIndex(), copyDescriptor.getTargetIndex()) + 1, /* @ValidNullArgument */
                 null);
        }
    }

    /**
     * Performs the operation, specified by the specified {@link ItemsCopyDescriptor}, from the specified source to the
     * specified target array of {@link Item}s.
     *
     * @param sourceArray
     *        source array of {@link Item}s
     *
     * @param targetArray
     *        target array of {@link Item}s
     *
     * @param copyDescriptor
     *        {@link ItemsCopyDescriptor} for the operation
     */
    protected void copyItems(final Item[] sourceArray, final Item[] targetArray,
                             final ItemsCopyDescriptor copyDescriptor) {
        arraycopy(sourceArray, copyDescriptor.getSourceBeginIndex(), targetArray, copyDescriptor.getTargetIndex(),
                  copyDescriptor.getSourceEndIndex() - copyDescriptor.getSourceEndIndex() + 1);
    }

    @Override
    public int getCapacity() {
        return delegateArray.length;
    }

    @Override
    public ArrayStorage<Item> clone() {
        final ArrayStorage<Item> clonedArrayStorage = (ArrayStorage<Item>) super.clone();

        clonedArrayStorage.delegateArray = delegateArray.clone();

        return clonedArrayStorage;
    }

    @Override
    public boolean equals(final Object otherObject) {
        if (! (otherObject instanceof ArrayStorage))
            return false;

        @SuppressWarnings("unchecked")
        final ArrayStorage<Item> otherStorage = (ArrayStorage<Item>) otherObject;

        return hasMatchingProperties(otherStorage) && Arrays.equals(delegateArray, otherStorage.delegateArray);
    }

    @Override
    public int hashCode() {
        return super.hashCode() << 1 + Arrays.hashCode(delegateArray);
    }
}
