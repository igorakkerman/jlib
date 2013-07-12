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

import java.io.Serializable;

import static org.jlib.core.math.MathUtility.count;

import org.jlib.core.system.AbstractCloneable;

/**
 * Manager of the content of a {@link LinearIndexStorage}.
 *
 * @param <Item>
 *        type of the items stored in the {@link LinearIndexStorage}
 *
 * @author Igor Akkerman
 */
public class ContentIndexHolder<Item>
extends AbstractCloneable
implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = 7766547798864277487L;

    /** referenced {@link LinearIndexStorage} */
    private final LinearIndexStorage<Item> storage;

    /** array index of the first {@link Item} */
    private Integer firstItemIndex;

    /** array index of the last {@link Item} */
    private Integer lastItemIndex;

/*
     * @param capacity
     *        integer specifying the capacity
     *
     * @param firstItemIndex
     *        integer specifying the index of the first {@link Item}
     *
     * @param lastItemIndex
     *        integer specifying the index of the last {@link Item}
     *

 */

    /**
     * Creates a new {@link ContentIndexHolder} for the specified {@link LinearIndexStorage}.
     *
     * @param storage
     *        {@link LinearIndexStorage} on which this {@link ContentIndexHolder} operates.
     */
    public ContentIndexHolder(final LinearIndexStorage storage)
    throws LinearIndexStorageException {
        this.storage = storage;
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
        if (firstItemIndex < 0)
            throw new InvalidIndexException(storage, "firstItemIndex = {2} < 0", firstItemIndex);

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
        return storage.getCapacity() - getLastItemIndex();
    }
}
