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

package org.jlib.container.storage;

/**
 * <p>
 * Storage providing <em>n</em> slots for {@link Item}s indexed from <em>0</em> to <em>n-1</em>.
 * Each slot may or may not hold an {@link Item}.
 * </p>
 * <p>
 * An application using a {@link LinearIndexStorage} is responsible for managing the sets of indices it addresses.
 * The behaviour is unspecified when trying to access an {@link Item} at an index whose slot does not hold an
 * {@link Item}.
 * The {@link Item}s can be shifted within a {@link LinearIndexStorage}.
 * </p>
 * <p>
 * The capacity of a {@link LinearIndexStorage} can be raised but it cannot be lowered. That is, more slots can be
 * provided upon request but slots cannot be removed.
 * When an application requests the capacity to be raised, it has to specify at which index existing {@link Item}s can
 * be accessed afterwards.
 * </p>
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
    int capacity();

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
    Item get(int index)
    throws InvalidStorageIndexException;

    /**
     * Replaces the {@link Item} stored at the specified index by the specified {@link Item}.
     *
     * @param index
     *        integer specifying the index of the {@link Item}
     *
     * @param newItem
     *        new {@link Item} replacing the former
     *
     * @throws InvalidStorageIndexException
     *         if {@code index} is out of the valid bounds of this {@link LinearIndexStorage}
     */
    void set(int index, Item newItem)
    throws InvalidStorageIndexException;

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
     * @throws InvalidStorageIndexException
     *         if an {@link IndexRangeOperationDescriptor} specifies a shift on an index outside the valid bounds
     */
    void ensureCapacityAndShiftItems(int capacity, IndexRangeOperationDescriptor... shiftDescriptors)
    throws InvalidCapacityException, InvalidStorageIndexException;

    /**
     * Shifts the {@link Item}s <em>ithin</em> this {@link LinearIndexStorage}, as defined by the specified
     * {@link IndexRangeOperationDescriptor}s.
     *
     * @param shiftDescriptors
     *        comma separated sequence of {@link IndexRangeOperationDescriptor}s
     *
     * @throws InvalidStorageIndexException
     *         if an {@link IndexRangeOperationDescriptor} specifies an index outside the valid bounds
     */
    void shiftItems(IndexRangeOperationDescriptor... shiftDescriptors)
    throws InvalidStorageIndexException;
}
