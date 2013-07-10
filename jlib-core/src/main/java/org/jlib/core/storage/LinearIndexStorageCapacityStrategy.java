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

/**
 * Strategy of capacity provision in a {@link LinearIndexStorage}.
 *
 * @author Igor Akkerman
 */
public interface LinearIndexStorageCapacityStrategy {

    /**
     * Initializes the referenced {@link LinearIndexStorage} with a sufficient
     * capacity to fit Items in the specified range.
     *
     * @param firstItemIndex
     *        integer specifying the first Item index
     *
     * @param lastItemIndex
     *        integer specifying the last Item index
     */
    public void initialize(int firstItemIndex, int lastItemIndex);

    /**
     * Ensures that the referenced {@link LinearIndexStorage} fits the specified
     * number of Items at the head of the {@link LinearIndexStorage}. The
     * indices of the stored Items are incremented, if necessary.
     *
     * @param headCapacity
     *        integer specifying the head capacity
     *
     * @throws LinearIndexStorageException
     *         if {@code headCapacity < 0}
     */
    public void ensureHeadCapacity(final int headCapacity)
    throws LinearIndexStorageException;

    /**
     * Ensures that the referenced {@link LinearIndexStorage} fits the specified
     * number of Items betweeen the existing stored Items. The indices of the
     * Items stored after the specified split index are incremented.
     *
     * @param splitIndex
     *        integer specifying the split index
     *
     * @param middleCapacity
     *        integer specifying the middle capacity
     *
     * @throws LinearIndexStorageException
     *         if {@code middleCapacity < 0 ||
     *                   middleIndex < linearIndexStorage.getFirstIndex() ||
     *                   middleIndex > linearIndexStorage.getLastIndex()}
     */
    public void ensureMiddleCapacity(final int splitIndex, final int middleCapacity)
    throws LinearIndexStorageException;

    /**
     * Ensures that the referenced {@link LinearIndexStorage} fits the specified
     * number of Items behind the existing stored Items. The indices of all
     * stored Items are left unchanged.
     *
     * @param tailCapacity
     *        integer specifying the tail capacity
     *
     * @throws LinearIndexStorageException
     *         if {@code tailCapacity < 0}
     */
    public void ensureTailCapacity(final int tailCapacity)
    throws LinearIndexStorageException;
}
