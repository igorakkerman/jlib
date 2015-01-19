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

package org.jlib.core.storage.capacity;

import org.jlib.core.language.AbstractObject;
import org.jlib.core.storage.ContentIndexRegistry;
import org.jlib.core.storage.InvalidIndexException;
import org.jlib.core.storage.LinearIndexStorage;
import org.jlib.core.storage.LinearIndexStorageException;
import org.jlib.core.storage.indexrangeoperation.IndexRangeOperationDescriptor;

import static org.jlib.core.text.message.MessageUtility.messageMf;

public abstract class AbstractCapacityStrategy<Item>
extends AbstractObject {

    private final LinearIndexStorage<Item> storage;

    private final ContentIndexRegistry contentIndexRegistry;

    protected AbstractCapacityStrategy(final LinearIndexStorage<Item> storage,
                                       final ContentIndexRegistry contentIndexRegistry) {

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
     * Ensures that the specified capacity is valid.
     *
     * @param capacity
     *        integer specifying the capacity
     *
     * @throws LinearIndexStorageException
     *         if {@code capacity < 0}
     */
    public void ensurePartialCapacityValid(final int capacity) {
        if (capacity < 0)
            throw new InvalidPartialCapacityException(storage, capacity);
    }

    protected void ensureIndexValid(final int index) {
        if (index < contentIndexRegistry.getFirstItemIndex())
            throw new InvalidIndexException(storage, messageMf("index = {0} > {1} = " + "firstItemIndex", index,
                                                               contentIndexRegistry.getFirstItemIndex()));

        if (index > contentIndexRegistry.getLastItemIndex()) {
            throw new InvalidIndexException(storage, messageMf("index = {0} < {1} = lastItemIndex", index,
                                                               contentIndexRegistry.getLastItemIndex()));
        }
    }
}
