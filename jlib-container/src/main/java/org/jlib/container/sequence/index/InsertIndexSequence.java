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

import org.jlib.container.Container;
import org.jlib.container.sequence.InsertSequence;
import org.jlib.container.sequence.InsertSequenceTraverser;
import org.jlib.container.sequence.Sequence;

import java.util.Collection;

/**
 * {@link InsertSequence} and {@link IndexSequence}.
 *
 * @param <Item>
 *        type of the items held in the {@link Sequence}
 *
 * @author Igor Akkerman
 */
public interface InsertIndexSequence<Item>
extends InsertSequence<Item>, IndexSequence<Item> {

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
     *        {@link Container} holding the Items to insert
     */
    public void insert(int index, Container<? extends Item> items);

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
    public InsertIndexSequence<Item> getSubsequenceView(final int fromIndex, final int toIndex)
    throws SequenceIndexOutOfBoundsException, InvalidSequenceIndexRangeException;

    /**
     * Returns an {@link InsertIndexSequenceTraverser} traversing the Items of
     * this {@link InsertIndexSequence} in proper sequence. That is, the Item
     * returned by the first call to
     * {@link InsertIndexSequenceTraverser#getNextItem()} is the Item stored at
     * the first index.
     *
     * @return {@link InsertIndexSequenceTraverser} over the Items of this
     *         {@link InsertIndexSequence}
     *
     * @throws SequenceIndexOutOfBoundsException
     *         if
     *         {@code startIndex < getFirstIndex() || startIndex > getLastIndex()}
     */
    @Override
    public InsertIndexSequenceTraverser<Item> createTraverser()
    throws SequenceIndexOutOfBoundsException;

    /**
     * Returns an {@link InsertSequenceTraverser} traversing the Items of this
     * {@link InsertIndexSequence} in proper sequence. That is, the Item
     * returned by the first call to
     * {@link InsertSequenceTraverser#getNextItem()} is the Item stored at the
     * specified start index.
     *
     * @param startIndex
     *        integer specifying the index of the first Item returned by the
     *        Traverser
     *
     * @return {@link InsertIndexSequenceTraverser} over the Items of this
     *         {@link InsertIndexSequence}
     *
     * @throws SequenceIndexOutOfBoundsException
     *         if
     *         {@code startIndex < getFirstIndex() || startIndex > getLastIndex()}
     */
    @Override
    public InsertIndexSequenceTraverser<Item> createTraverser(int startIndex)
    throws SequenceIndexOutOfBoundsException;
}
