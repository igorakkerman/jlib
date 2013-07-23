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

package org.jlib.container.sequence.index;

import java.util.Collection;

import org.jlib.container.GetContainer;
import org.jlib.container.sequence.Sequence;

/**
 * {@link IndexSequence} into which an {@link Item} can be inserted at a specified index.
 *
 * @param <Item>
 *        type of the items held in the {@link Sequence}
 *
 * @author Igor Akkerman
 */
public interface InsertIndexSequence<Item>
extends IndexSequence<Item> {

    /**
     * Inserts the specified Item at the specified index in this
     * {@link IndexSequence}.
     *
     * @param index
     *        integer specifying the index
     *
     * @param item
     *        Item to insert
     *
     */
    public void insert(int index, Item item);

    /**
     * Inserts the specified Items at the specified index of this
     * {@link InsertIndexSequence}.
     *
     * @param index
     *        integer specifying the index
     *
     * @param items
     *        {@link GetContainer} holding the Items to insert
     */
    public void insert(int index, GetContainer<? extends Item> items);

    /**
     * Inserts the specified Items at the specified index of this
     * {@link InsertIndexSequence}.
     *
     * @param index
     *        integer specifying the index
     *
     * @param items
     *        {@link Collection} holding the Items to insert
     */
    public void insert(int index, Collection<? extends Item> items);

    /**
     * Inserts the specified Items at the specified index of this
     * {@link InsertIndexSequence}.
     *
     * @param index
     *        integer specifying the index
     *
     * @param items
     *        comma separated sequence holding the Items to insert
     */
    @SuppressWarnings("unchecked")
    public void insert(int index, Item... items);

    /**
     * @return {@link InsertIndexSequence} view of the specified subsequence
     */
    @Override
    public InsertIndexSequence<Item> getSubsequenceView(int fromIndex, int toIndex)
    throws InvalidSequenceIndexException, InvalidSequenceIndexException;
}
