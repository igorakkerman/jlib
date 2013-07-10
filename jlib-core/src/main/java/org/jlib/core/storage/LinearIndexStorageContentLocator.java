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

import static org.jlib.core.math.MathUtility.count;

/**
 * Manager of the content of a {@link LinearIndexStorage}.
 *
 * @param <Item>
 *        type of the items stored in the {@link LinearIndexStorage}
 *
 * @author Igor Akkerman
 */
public class LinearIndexStorageContentLocator<Item> {

    /** array index of the first {@link Item} */
    private Integer firstItemIndex;

    /** array index of the last {@link Item} */
    private Integer lastItemIndex;

    /**
     * Creates a new {@link LinearIndexStorageContentLocator}.
     */
    public LinearIndexStorageContentLocator(final int capacity, final int firstItemIndex, final int lastItemIndex,
                                               final IndexRangeOperationDescriptor... copyDescriptors)
    throws LinearIndexStorageException {
        ensureInitializationArgumentsValid(capacity, firstItemIndex, lastItemIndex);

        this.firstItemIndex = firstItemIndex;
        this.lastItemIndex = lastItemIndex;

        initializeStorage(capacity, copyDescriptors);
    }

    /**
     * Initializes the delegate data structures.
     *
     * @param capacity
     *        integer specifying the valid capacity
     *
     * @param copyDescriptors
     *        comma separated sequence of {@link IndexRangeOperationDescriptor} descriptors
     */
    protected abstract void initializeStorage(final int capacity,
                                              final IndexRangeOperationDescriptor... copyDescriptors);

    /**
     * Ensures that the specified capacity and first and last {@link Item} indices are valid values.
     *
     * @param capacity
     *        integer specifying the capacity
     *
     * @param firstItemIndex
     *        integer specifying the index of the first {@link Item}
     *
     * @param lastItemIndex
     *        integer specifying the index of the last {@link Item}
     *
     * @throws LinearIndexStorageException
     *         if the specified values are not valid as defined by
     *         {@link #initialize(int, int, int, IndexRangeOperationDescriptor...)}
     */
    private void ensureInitializationArgumentsValid(final int capacity, final int firstItemIndex,
                                                    final int lastItemIndex) {
        if (firstItemIndex < 0)
            throw new LinearIndexStorageException(this, "firstItemIndex = {1} < 0", firstItemIndex);

        if (firstItemIndex > lastItemIndex)
            throw new LinearIndexStorageException(this, "lastItemIndex = {2} > {1} = firstItemIndex", firstItemIndex,
                                                  lastItemIndex);

        if (lastItemIndex > capacity - 1)
            throw new LinearIndexStorageException(this, "lastItemIndex = {2} > {1} - 1 = capacity - 1", capacity,
                                                  lastItemIndex);

        if (count(firstItemIndex, lastItemIndex) > capacity)
            throw new LinearIndexStorageException(this,
                                                  "count(firstItemIndex: {2}, lastItemIndex: {3}) = {4} > {1} = capacity",
                                                  capacity, firstItemIndex, lastItemIndex,
                                                  count(firstItemIndex, lastItemIndex));
    }

    /**
     * Returns the index of the first {@link Item}.
     *
     * @return integer specifying the index of the first {@link Item}
     */
    public int getFirstItemIndex() {
        return firstItemIndex;
    }

    /**
     * Registers the index of the first {@link Item}.
     *
     * @param firstItemIndex
     *        integer specifying the index of the first {@link Item}
     */
    public void setFirstItemIndex(int firstItemIndex) {
        this.firstItemIndex = firstItemIndex;
    }

    /**
     * Returns the index of the last {@link Item}.
     *
     * @return integer specifying the index of the last {@link Item}
     */
    public int getLastItemIndex() {
        return lastItemIndex;
    }

    /**
     * Registers the index of the last {@link Item}.
     *
     * @param lastItemIndex
     *        integer specifying the index of the last {@link Item}
     */
    public void setLastItemIndex(int lastItemIndex) {
        this.lastItemIndex = lastItemIndex;
    }

    /**
     * Increments the index of the first {@link Item} by the specified value.
     *
     * @param increment
     *        positive or negative integer specifying the increment
     */
    public void incrementFirstItemIndex(int increment) {
        firstItemIndex += increment;
    }

    /**
     * Increments the index of the last {@link Item} by the specified value.
     *
     * @param increment
     *        positive or negative integer specifying the increment
     */
    public void incrementLastItemIndex(int increment) {
        lastItemIndex += increment;
    }

    /**
     * Returns the number of stored {@link Item}s.
     *
     * @return integer spacifying the number of stored {@link Item}s
     */
    public int getItemsCount() {
        return count(firstItemIndex, lastItemIndex);
    }

    /**
     * Returns the tail capacity, that is, the number of storable {@link Item}s behind the last {@link Item}.
     *
     * @return integer specifying the tail capacity
     */
    public int getTailCapacity() {
        return capacity - getLastItemIndex();
    }
}
