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

/**
 * Manager of the content of a {@link LinearIndexStorage}.
 *
 * @param <Item>
 *        type of the items stored in the {@link LinearIndexStorage}
 *
 * @author Igor Akkerman
 */
public interface LinearIndexStorageContentManager<Item> {

    /**
     * Initializes or re-initializes the {@link LinearIndexStorage} content performing the copy operations on its
     * {@link Item}s as specified by one or more {@link IndexRangeOperationDescriptor}s. Their source indices reference the
     * {@link Item} indices <em>before</em> the operation, their target indices the {@link Item} indices <em>after</em>
     * the operation. The {@link Item}s stored at the former indices are not overwritten and can be reused in each
     * specified {@link IndexRangeOperationDescriptor} operation.
     *
     * @param capacity
     *        integer specifying the capacity
     *
     * @param copyDescriptors
     *        comma separated sequence of {@link IndexRangeOperationDescriptor}s
     *
     * @throws InvalidCapacityFactorException
     *         if {@code capacity < 0}
     */
    public void initialize(int capacity, IndexRangeOperationDescriptor... copyDescriptors);

    /**
     * Shifts the {@link Item}s within this {@link LinearIndexStorageContentManager} as defined defined by the specified
     * {@link IndexRangeOperationDescriptor}s. Their source indices reference the {@link Item} indices <em>before</em>, their
     * target indices the {@link Item} indices <em>after</em> the operation. The {@link Item}s stored at the former
     * indices are overwritten by each specified {@link IndexRangeOperationDescriptor} operation. Shifted {@link Item}s are
     * overwritten by {@code null}.
     *
     * @param copyDescriptors
     *        comma separated sequence of {@link IndexRangeOperationDescriptor}s
     *
     * @throws IndexOutOfBoundsException
     *         if an {@link IndexRangeOperationDescriptor} specifies a copy operation on an index outside the valid bounds
     */
    public void shiftItems(IndexRangeOperationDescriptor... copyDescriptors)
    throws IndexOutOfBoundsException;

    /**
     * Returns the index of the first {@link Item}.
     *
     * @return integer specifying the index of the first {@link Item}
     */
    public int getFirstItemIndex();

    /**
     * Registers the index of the first {@link Item}.
     *
     * @param firstItemIndex
     *        integer specifying the index of the first {@link Item}
     */
    public void setFirstItemIndex(int firstItemIndex);

    /**
     * Increments the index of the first {@link Item} by the specified value.
     *
     * @param increment
     *        positive or negative integer specifying the increment
     */
    public void incrementFirstItemIndex(int increment);

    /**
     * Increments the index of the last {@link Item} by the specified value.
     *
     * @param increment
     *        positive or negative integer specifying the increment
     */
    public void incrementLastItemIndex(int increment);

    /**
     * Returns the index of the last {@link Item}.
     *
     * @return integer specifying the index of the last {@link Item}
     */
    public int getLastItemIndex();

    /**
     * Registers the index of the last {@link Item}.
     *
     * @param lastItemIndex
     *        integer specifying the index of the last {@link Item}
     */
    public void setLastItemIndex(int lastItemIndex);

    /**
     * Returns the number of stored {@link Item}s.
     *
     * @return integer spacifying the number of stored {@link Item}s
     */
    public int getItemsCount();

    /**
     * Returns the tail capacity, that is, the number of storable {@link Item}s behind the last {@link Item}.
     *
     * @return integer specifying the tail capacity
     */
    public int getTailCapacity();

    /**
     * Creates a copy of this {@link LinearIndexStorageContentManager}.
     *
     * @return cloned {@link LinearIndexStorageContentManager}
     */
    public LinearIndexStorageContentManager<Item> clone();
}
