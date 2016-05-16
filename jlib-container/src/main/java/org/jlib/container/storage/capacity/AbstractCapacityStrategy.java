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

package org.jlib.container.storage.capacity;

import org.jlib.container.storage.IndexRange;
import org.jlib.container.storage.IndexRangeOperationDescriptor;
import org.jlib.container.storage.InvalidStorageIndexException;
import org.jlib.container.storage.LinearIndexStorage;

import org.jlib.basefunctions.ApplicationObject;
import static org.jlib.message.Messages.mfmessage;

public abstract class AbstractCapacityStrategy
extends ApplicationObject {

    private final LinearIndexStorage<?> storage;

    private final IndexRange contentIndexRange;

    protected AbstractCapacityStrategy(final LinearIndexStorage<?> storage, final IndexRange contentIndexRange) {
        this.storage = storage;
        this.contentIndexRange = contentIndexRange;
    }

    protected LinearIndexStorage<?> getStorage() {
        return storage;
    }

    protected IndexRange getContentIndexRange() {
        return contentIndexRange;
    }

    /**
     * Returns the tail capacity, that is, the number of storable items behind the last itme.
     *
     * @return integer specifying the tail capacity
     */
    protected int getTailCapacity() {
        return storage.capacity() - contentIndexRange.getMaximum();
    }

    protected IndexRangeOperationDescriptor getDescriptorCopyAllItemsToIndex(final int targetIndex) {
        return new IndexRangeOperationDescriptor(contentIndexRange, targetIndex);
    }

    /**
     * Ensures that the specified capacity is valid.
     *
     * @param capacity
     *        integer specifying the capacity
     *
     * @throws InvalidCapacityException
     *         if {@code capacity < 0}
     */
    public void ensureCapacityValid(final int capacity) {
        if (capacity < 0)
            throw new InvalidCapacityException(storage, capacity);
    }

    protected void ensureIndexValid(final int index) {
        if (index < contentIndexRange.getMinimum())
            throw new InvalidStorageIndexException(storage, mfmessage("index = {0} > {1} = firstItemIndex", index,
                                                               contentIndexRange.getMinimum()));

        if (index > contentIndexRange.getMaximum())
            throw new InvalidStorageIndexException(storage, mfmessage("index = {0} < {1} = lastItemIndex", index,
                                                               contentIndexRange.getMaximum()));
    }
}
