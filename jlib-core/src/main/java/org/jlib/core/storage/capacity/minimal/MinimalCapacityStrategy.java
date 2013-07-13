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
 * <p>
 * {@link CapacityStrategy} providing just as much capacity as needed.
 * </p>
 * <p>
 * The algorithm defines:
 * </p>
 * <dl>
 *     <dt>the <em>head capacity</em></dt>
 *     <dd>as the capacity in front of the first {@link Item}
 *     <dt>the <em>tail capacity</em></dt>
 *     <dd>as the capacity behind the last {@link Item}</dd>
 * </dl>
 *
 *     and analyzes the current head and tail capacities, that is, the empty space before the first and after the
 * last {@link Item} index
 * </p>
 *
 * @param <Item>
 *        type of the {@link LinearIndexStorage} items
 *
 * @author Igor Akkerman
 */
// TODO: 2013-07-10 name all ItemCopyDescriptors with an explaining name
// TODO: 2013-07-10 explain the algorithms
public class MinimalCapacityStrategy<Item>
extends AbstractCapacityStrategy<Item> {

    /** {@link LinearIndexStorage} holding the {@link Item}s */
    private final LinearIndexStorage<Item> storage;

    private final ContentIndexRegistry contentIndexRegistry;

    /**
     * Creates a new {@link org.jlib.core.storage.MinimalSingleCapacityStrategy}.
     *
     * @param storage
     *        referenced {@link LinearIndexStorage}
     */
    public MinimalCapacityStrategy(final LinearIndexStorage<Item> storage,
                                   final ContentIndexRegistry contentIndexRegistry) {
        super();

        this.storage = storage;
        this.contentIndexRegistry = contentIndexRegistry;
    }

    @Override
    public void ensureTailCapacity(final int tailCapacity)
    throws LinearIndexStorageException {
        ensureCapacityValid(tailCapacity);

        if (tailCapacity <= getTailCapacity())
            return;

        storage.ensureCapacityAndShiftItems(contentIndexRegistry.getLastItemIndex() + 1 + tailCapacity,
                                            getDescriptorCopyAllItemsToIndex(contentIndexRegistry.getFirstItemIndex()));
    }

    @Override
    public void ensureMiddleCapacity(final int splitIndex, final int middleCapacity)
    throws LinearIndexStorageException {
        ensureCapacityValid("middleCapacity", middleCapacity);
        ensureIndexValid("splitIndex", splitIndex);

        if (middleCapacity == 0)
            return;

        ensureValidMiddleCapacity(splitIndex, middleCapacity);
    }

    /**
     * @param middleCapacity
     *        <em>positive</em> integer specifying the middle capacity
     */
    private void ensureValidMiddleCapacity(final int splitIndex, final int middleCapacity) {
        final IndexRangeOperationDescriptor shiftRightPartFromSplitIndexRightByMidleCapacity = /*
         */ new IndexRangeOperationDescriptor(splitIndex, contentIndexRegistry.getLastItemIndex(),
                                              splitIndex + middleCapacity);

        final int newLastItemIndex = contentIndexRegistry.getLastItemIndex() + middleCapacity;

        if (contentIndexRegistry.getTailCapacity() >= middleCapacity) {

            storage.shiftItems(shiftRightPartFromSplitIndexRightByMidleCapacity);
            contentIndexRegistry.setLastItemIndex(newLastItemIndex);

            return;
        }

        final int fullCapacity = contentIndexRegistry.getItemsCount() + middleCapacity;

        // TODO: is leftCopyDescriptor an adequate name? tried to find a name without analyzing
        final IndexRangeOperationDescriptor leftCopyDescriptor = /*
         */ new IndexRangeOperationDescriptor(contentIndexRegistry.getFirstItemIndex(), splitIndex - 1, splitIndex);

        final IndexRangeOperationDescriptor[] copyDescriptors = /*
         */ splitIndex > contentIndexRegistry.getFirstItemIndex() ?
            new IndexRangeOperationDescriptor[]{ leftCopyDescriptor,
                                                 shiftRightPartFromSplitIndexRightByMidleCapacity } :
            new IndexRangeOperationDescriptor[]{ shiftRightPartFromSplitIndexRightByMidleCapacity };

        storage.ensureCapacityAndShiftItems(fullCapacity, copyDescriptors);
    }

    private void ensureIndexValid(final String indexName, final int splitIndex) {
        if (splitIndex < contentIndexRegistry.getFirstItemIndex())
            throw new InvalidIndexException(storage, indexName + " = {1} > {2} = firstItemIndex", splitIndex,
                                            contentIndexRegistry.getFirstItemIndex());

        if (splitIndex > contentIndexRegistry.getLastItemIndex())
            throw new InvalidIndexException(storage, indexName + " = {1} < {2} = lastItemIndex", splitIndex,
                                            contentIndexRegistry.getLastItemIndex());
    }

    private void ensureInitializationArgumentsValid(final int capacity, final int firstItemIndex,
                                                    final int lastItemIndex)
    throws InvalidCapacityException, LinearIndexStorageException {

        if (capacity < 0)
            throw new InvalidCapacityException(capacity);

        if (firstItemIndex < 0)
            throw new InvalidIndexException(this, "firstItemIndex = {1} < 0", firstItemIndex);

        if (firstItemIndex > lastItemIndex)
            throw new InvalidIndexException(this, "lastItemIndex = {2} > {1} = firstItemIndex", firstItemIndex,
                                            lastItemIndex);

        if (lastItemIndex > capacity - 1)
            throw new InvalidIndexException(this, "lastItemIndex = {2} > {1} - 1 = capacity - 1", capacity,
                                            lastItemIndex);

        if (count(firstItemIndex, lastItemIndex) > capacity)
            throw new InvalidIndexException(this,
                                            "count(firstItemIndex: {2}, lastItemIndex: {3}) = {4} > {1} = capacity",
                                            capacity, firstItemIndex, lastItemIndex,
                                            count(firstItemIndex, lastItemIndex));
    }
}
