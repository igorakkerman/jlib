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

import org.jlib.core.storage.capacity.SingleCapacityStrategy;
import org.jlib.core.storage.indexrangeoperation.IndexRangeOperationDescriptor;
import org.jlib.core.system.AbstractObject;

public abstract class AbstractSingleCapacityStrategy<Item>
extends AbstractObject
implements SingleCapacityStrategy {

    private final LinearIndexStorage<Item> storage;

    private final ContentIndexRegistry contentIndexRegistry;

    protected AbstractSingleCapacityStrategy(final LinearIndexStorage<Item> storage,
                                             final ContentIndexRegistry contentIndexRegistry) {
        super();

        this.storage = storage;
        this.contentIndexRegistry = contentIndexRegistry;
    }

    protected LinearIndexStorage<Item> getStorage() {
        return storage;
    }

    protected ContentIndexRegistry getContentIndexRegistry() {
        return contentIndexRegistry;
    }

    /**
     * Returns the tail capacity, that is, the number of storable {@link Item}s behind the last {@link Item}.
     *
     * @return integer specifying the tail capacity
     */
    protected int getTailCapacity() {
        return storage.getCapacity() - contentIndexRegistry.getLastItemIndex();
    }

    protected IndexRangeOperationDescriptor getDescriptorCopyAllItemsToIndex(final int targetIndex) {
        return new IndexRangeOperationDescriptor(contentIndexRegistry.getFirstItemIndex(),
                                                 contentIndexRegistry.getLastItemIndex(), targetIndex);
    }

    /**
     * Ensures that the specified partial capacity is valid.
     *
     * @param capacityName
     *        String specifying the name of the partial capacity
     *
     * @param capacity
     *        integer specifying the partial capacity
     *
     * @throws LinearIndexStorageException
     *         if {@code capacity < 0}
     */
    protected void ensureCapacityValid(final String capacityName, final int capacity) {
        if (capacity < 0)
            throw new NegativeCapacityException(storage, capacityName, capacity);
    }
}
