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

import org.jlib.core.storage.indexrangeoperation.IndexRangeOperationDescriptor;

/**
 * Storage of <em>n</em> {@link Item}s indexed from <em>0</em> to <em>n-1</em>.
 *
 * @param <Item>
 *        type of the {@link Item}s stored in the {@link LinearIndexStorage}
 *
 * @author Igor Akkerman
 */
public interface LinearIndexStorage<Item>
extends Cloneable {

    /**
     * Returns the current capacity, that is, the number of currently storable {@link Item}s without need of allocating
     * new resources.
     *
     * @return integer specifying the capacity
     */
    public int getCapacity();

    /**
     * Returns the {@link Item} stored at the specified index.
     *
     * @param index
     *        integer specifying the index of the {@link Item}
     *
     * @return {@link Item} stored at {@code index}
     *
     * @throws IndexOutOfBoundsException
     *         if {@code index} is out of the valid bounds of this {@link LinearIndexStorage}
     */
    public Item getItem(int index)
    throws InvalidIndexException;

    /**
     * Replaces the {@link Item} stored at the specified index by the specified {@link Item}.
     *
     * @param index
     *        integer specifying the index of the {@link Item}
     *
     * @param newItem
     *        new {@link Item} replacing the former
     *
     * @throws InvalidIndexException
     *         if {@code index} is out of the valid bounds of this {@link LinearIndexStorage}
     */
    public void replaceItem(int index, Item newItem)
    throws InvalidIndexException;

    /**
     * <p>
     * Newly allocates the resources for this {@link LinearIndexStorage}, ensuring it to provide the specified capacity
     * and to contain the formerly stored {@link Item}s, potentially at new indices.
     * </p>
     * <p>
     * The {@link Item}s are shifted from former indices to the new indices, according to the specified
     * {@link IndexRangeOperationDescriptor}s. Their source indices reference the {@link Item} indices <em>before</em>,
     * their target indices the {@link Item} indices <em>after</em> the operation.
     * </p>
     * <p>
     * <em>Only</em> actually specified index ranges are taken in consideration. {@link Item}s located at other indices
     * are removed from this {@link LinearIndexStorage}.
     * </p>
     *
     * @param capacity
     *        integer specifying the capacity
     *
     * @param shiftDescriptors
     *        comma separated sequence of {@link IndexRangeOperationDescriptor}s
     *
     * @throws InvalidCapacityException
     *         if {@code capacity < 0}
     *
     * @throws InvalidIndexException
     *         if an {@link IndexRangeOperationDescriptor} specifies a shift on an index outside the valid bounds
     */
    public void addCapacityAndShiftItems(int capacity, IndexRangeOperationDescriptor... shiftDescriptors)
    throws InvalidCapacityException, InvalidIndexException;

    /**
     * Shifts the {@link Item}s <em>ithin</em> this {@link LinearIndexStorage}, as defined by the specified
     * {@link IndexRangeOperationDescriptor}s.
     *
     * @param shiftDescriptors
     *        comma separated sequence of {@link IndexRangeOperationDescriptor}s
     *
     * @throws InvalidIndexException
     *         if an {@link IndexRangeOperationDescriptor} specifies an index outside the valid bounds
     */
    public void shiftItems(IndexRangeOperationDescriptor... shiftDescriptors)
    throws InvalidIndexException;
}
