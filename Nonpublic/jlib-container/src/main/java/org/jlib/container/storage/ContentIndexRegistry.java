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

import java.io.Serializable;

import org.jlib.core.exception.UnexpectedStateException;

import static org.jlib.core.math.NumberUtility.count;

/**
 * Manager of the content of a {@link LinearIndexStorage}.
 *
 * @author Igor Akkerman
 */
public class ContentIndexRegistry
implements Cloneable,
           Serializable {

    private static final long serialVersionUID = 7766547798864277487L;

    /** {@link LinearIndexStorage} index of the first item */
    private Integer firstItemIndex;

    /** {@link LinearIndexStorage} index of the last item */
    private Integer lastItemIndex;

    /**
     * Creates a new {@link ContentIndexRegistry} for the specified {@link LinearIndexStorage}.
     */
    public ContentIndexRegistry(final Integer firstItemIndex, final Integer lastItemIndex)
    throws LinearIndexStorageException {

        this.firstItemIndex = firstItemIndex;
        this.lastItemIndex = lastItemIndex;
    }

    /**
     * Returns the index of the first item.
     *
     * @return Integer specifying the index of the first item
     */
    public Integer getFirstItemIndex() {
        return firstItemIndex;
    }

    /**
     * Registers the index of the first item.
     *
     * @param firstItemIndex
     *        Integer specifying the index of the first item
     */
    public void setFirstItemIndex(final Integer firstItemIndex) {
        this.firstItemIndex = firstItemIndex;
    }

    /**
     * Returns the index of the last item.
     *
     * @return Integer specifying the index of the last item
     */
    public Integer getLastItemIndex() {
        return lastItemIndex;
    }

    /**
     * Registers the index of the last item.
     *
     * @param lastItemIndex
     *        Integer specifying the index of the last item
     */
    public void setLastItemIndex(final Integer lastItemIndex) {
        this.lastItemIndex = lastItemIndex;
    }

    /**
     * Increments the index of the first item by the specified value.
     *
     * @param increment
     *        positive or negative Integer specifying the increment
     */
    public void incrementFirstItemIndex(final int increment) {
        firstItemIndex += increment;
    }

    /**
     * Increments the index of the last item by the specified value.
     *
     * @param increment
     *        positive or negative Integer specifying the increment
     */
    public void incrementLastItemIndex(final int increment) {
        lastItemIndex += increment;
    }

    /**
     * Returns the number of stored items.
     *
     * @return integer spacifying the number of stored items
     */
    public int getItemsCount() {
        return count(firstItemIndex, lastItemIndex);
    }

    @Override
    public ContentIndexRegistry clone() {
        try {
            return (ContentIndexRegistry) super.clone();
        }
        catch (final CloneNotSupportedException exception) {
            throw new UnexpectedStateException(exception);
        }
    }
}
