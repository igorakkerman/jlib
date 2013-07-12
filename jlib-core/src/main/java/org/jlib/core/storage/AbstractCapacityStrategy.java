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

import org.jlib.core.storage.capacity.CapacityStrategy;
import org.jlib.core.system.AbstractObject;

public abstract class AbstractCapacityStrategy<Item>
extends AbstractObject
implements CapacityStrategy {

    private final LinearIndexStorage<Item> storage;

    private final ContentIndexRegistry contentIndexRegistry;

    protected AbstractCapacityStrategy(final LinearIndexStorage<Item> storage,
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
}
