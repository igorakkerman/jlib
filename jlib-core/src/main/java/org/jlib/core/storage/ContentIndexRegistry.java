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

import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;

import org.jlib.core.language.TypedCloneable;
import org.jlib.core.language.UnexpectedStateException;
import org.jlib.core.storage.indexrangeoperation.IndexRangeOperationDescriptor;

import org.apache.commons.beanutils.BeanUtils;
import static org.jlib.core.math.MathUtility.count;

/**
 * Manager of the content of a {@link LinearIndexStorage}.
 *
 * @param <Item>
 *        type of the items stored in the {@link LinearIndexStorage}
 *
 * @author Igor Akkerman
 */
public class ContentIndexRegistry
extends TypedCloneable<ContentIndexRegistry>
implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = 7766547798864277487L;

    /** {@link LinearIndexStorage} index of the first {@link Item} */
    private Integer firstItemIndex;

    /** {@link LinearIndexStorage} index of the last {@link Item} */
    private Integer lastItemIndex;

    /**
     * Creates a new {@link ContentIndexRegistry} for the specified {@link LinearIndexStorage}.
     *
     * @param storage
     *        {@link LinearIndexStorage} on which this {@link ContentIndexRegistry} operates.
     */
    public ContentIndexRegistry(final int firstItemIndex, final int lastItemIndex)
    throws LinearIndexStorageException {

        this.firstItemIndex = firstItemIndex;
        this.lastItemIndex = lastItemIndex;
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
    public void setFirstItemIndex(final int firstItemIndex) {
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
    public void setLastItemIndex(final int lastItemIndex) {
        this.lastItemIndex = lastItemIndex;
    }

    /**
     * Increments the index of the first {@link Item} by the specified value.
     *
     * @param increment
     *        positive or negative integer specifying the increment
     */
    public void incrementFirstItemIndex(final int increment) {
        firstItemIndex += increment;
    }

    /**
     * Increments the index of the last {@link Item} by the specified value.
     *
     * @param increment
     *        positive or negative integer specifying the increment
     */
    public void incrementLastItemIndex(final int increment) {
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

    @Override
    public ContentIndexRegistry clone() {
        // TODO: replace by more general strategy
        try {
            final ContentIndexRegistry cloneTarget = super.clone();

            BeanUtils.copyProperties(cloneTarget, this);

            return cloneTarget;
        }
        catch (IllegalAccessException | InvocationTargetException exception) {
            throw new UnexpectedStateException(exception);
        }
    }
}
