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

package org.jlib.core.storage.minimal;

import static org.jlib.core.math.MathUtility.count;

import org.jlib.core.storage.ContentIndexHolder;
import org.jlib.core.storage.InvalidIndexException;
import org.jlib.core.storage.LinearIndexStorage;
import org.jlib.core.storage.LinearIndexStorageException;
import org.jlib.core.storage.capacity.CapacityStrategy;
import org.jlib.core.storage.capacity.NegativeCapacityException;
import org.jlib.core.storage.indexrangeoperation.IndexRangeOperationDescriptor;

/**
 * <p>
 * {@link CapacityStrategy} providing just as much capacity as needed.
 * </p>
 * <p>
 * The algorithm defines:
 * </p>
 * <dl>
 * <dt>the <em>head capacity</em></dt>
 * <dd>as the capacity in front of the first {@link Item}
 * <dt>the <em>tail capacity</em></dt>
 * <dd>as the capacity behind the last {@link Item}</dd>
 * </dl>
 * <p>
 * Head capacity:
 * This {@link CapacityStrategy} analyzes the current head capacity to verify for the requested capacity.
 * If the requested head capacity is above the available head capacity,
 * the {@link LinearIndexStorage} is requested to re-allocate a capacity higher by the difference between requested and
 * available head capacity. The {@link Item}s are shifted "right" to have exactly the requested head capacity.
 * The {@link LinearIndexStorage} is always requested to provide an additional capacity even if its tail capacity would
 * be sufficient.
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
implements CapacityStrategy {

    /** {@link LinearIndexStorage} holding the {@link Item}s */
    private final LinearIndexStorage<Item> storage;

    /** {@link ContentIndexHolder} for {@link LinearIndexStorage} */
    private final ContentIndexHolder contentIndexHolder;

    /**
     * Creates a new {@link MinimalCapacityStrategy}.
     *
     * @param storage
     *        targeted {@link LinearIndexStorage}
     *
     * @param contentIndexHolder
     *        used {@link ContentIndexHolder}
     */
    public MinimalCapacityStrategy(final LinearIndexStorage<Item> storage,
                                   final ContentIndexHolder contentIndexHolder) {
        super();

        this.storage = storage;
        this.contentIndexHolder = contentIndexHolder;
    }

    @Override
    public void initialize(final int firstItemIndex, final int lastItemIndex) {
        storage.ensureCapacityAndShiftItems(count(firstItemIndex, lastItemIndex));
    }

    private IndexRangeOperationDescriptor getCopyAllItemsToNewIndexDescriptor(final int targetIndex) {
        return new IndexRangeOperationDescriptor(contentIndexHolder.getFirstItemIndex(),
                                                 contentIndexHolder.getLastItemIndex(), targetIndex);
    }

    private boolean isCurrentHeadCapacitySufficientFor(final int headCapacity) {
        return headCapacity <= contentIndexHolder.getFirstItemIndex();
    }

    @Override
    public void ensureTailCapacity(final int tailCapacity)
    throws LinearIndexStorageException {
        ensurePartialCapacityValid("tailCapacity", tailCapacity);

        if (tailCapacity <= contentIndexHolder.getTailCapacity())
            return;

        storage.ensureCapacityAndShiftItems(contentIndexHolder.getLastItemIndex() + 1 + tailCapacity,
                                            getCopyAllItemsToNewIndexDescriptor(
                                                                               contentIndexHolder.getFirstItemIndex()));
    }

    @Override
    public void ensureMiddleCapacity(final int splitIndex, final int middleCapacity)
    throws LinearIndexStorageException {
        ensurePartialCapacityValid("middleCapacity", middleCapacity);
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
         */ new IndexRangeOperationDescriptor(splitIndex, contentIndexHolder.getLastItemIndex(),
                                              splitIndex + middleCapacity);

        final int newLastItemIndex = contentIndexHolder.getLastItemIndex() + middleCapacity;

        if (contentIndexHolder.getTailCapacity() >= middleCapacity) {

            storage.shiftItems(shiftRightPartFromSplitIndexRightByMidleCapacity);
            contentIndexHolder.setLastItemIndex(newLastItemIndex);

            return;
        }

        final int fullCapacity = contentIndexHolder.getItemsCount() + middleCapacity;

        // TODO: is leftCopyDescriptor an adequate name? tried to find a name without analyzing
        final IndexRangeOperationDescriptor leftCopyDescriptor = /*
         */ new IndexRangeOperationDescriptor(contentIndexHolder.getFirstItemIndex(), splitIndex - 1, splitIndex);

        final IndexRangeOperationDescriptor[] copyDescriptors = /*
         */ splitIndex > contentIndexHolder.getFirstItemIndex() ?
            new IndexRangeOperationDescriptor[]{ leftCopyDescriptor,
                                                 shiftRightPartFromSplitIndexRightByMidleCapacity } :
            new IndexRangeOperationDescriptor[]{ shiftRightPartFromSplitIndexRightByMidleCapacity };

        storage.ensureCapacityAndShiftItems(fullCapacity, copyDescriptors);
    }

    private void ensureIndexValid(final String indexName, final int splitIndex) {
        if (splitIndex < contentIndexHolder.getFirstItemIndex())
            throw new InvalidIndexException(storage, indexName + " = {1} > {2} = firstItemIndex", splitIndex,
                                            contentIndexHolder.getFirstItemIndex());

        if (splitIndex > contentIndexHolder.getLastItemIndex())
            throw new InvalidIndexException(storage, indexName + " = {1} < {2} = lastItemIndex", splitIndex,
                                            contentIndexHolder.getLastItemIndex());
    }

    /**
     * Ensures that the specified partial capacity is valid.
     *
     * @param partialCapacityName
     *        String specifying the name of the partial capacity
     *
     * @param partialCapacity
     *        integer specifying the partial capacity
     *
     * @throws LinearIndexStorageException
     *         if {@code partialCapacity < 0}
     */
    private void ensurePartialCapacityValid(final String partialCapacityName, final int partialCapacity) {
        if (partialCapacity < 0)
            throw new NegativeCapacityException(storage, partialCapacityName, partialCapacity);
    }

/*

    private void ensureInitializationArgumentsValid(final int capacity, final int firstItemIndex,
                                                    final int lastItemIndex)
    throws NegativeCapacityException, LinearIndexStorageException {

        if (capacity < 0)
            throw new NegativeCapacityException(capacity);

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
*/
}
