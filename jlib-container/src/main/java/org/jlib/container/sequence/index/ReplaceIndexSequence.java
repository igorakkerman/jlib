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

import org.jlib.container.sequence.InvalidSequenceArgumentException;
import org.jlib.container.sequence.InvalidSequenceStateException;
import org.jlib.container.sequence.ReplaceSequence;
import org.jlib.container.sequence.Sequence;

/**
 * {@link IndexSequence} and {@link ReplaceSequence}.
 *
 * @param <Item>
 *        type of items held in the {@link Sequence}
 *
 * @author Igor Akkerman
 */
public interface ReplaceIndexSequence<Item>
extends IndexSequence<Item>, ReplaceSequence<Item> {

    /**
     * Replaces the Item at the specified index in this
     * {@link ReplaceIndexSequence} by the specified Items.
     *
     * @param index
     *        integer specifying the index of the Item
     *
     * @param newItem
     *        new Item to store
     *
     * @throws SequenceIndexOutOfBoundsException
     *         if {@code index < getFirstIndex() || index > getLastIndex()}
     *
     * @throws InvalidSequenceArgumentException
     *         if some property of {@code newItem} prevents the operation from
     *         being performed
     *
     * @throws InvalidSequenceStateException
     *         if an error occurs performing the operation
     */
    public void replace(final int index, final Item newItem)
    throws SequenceIndexOutOfBoundsException, InvalidSequenceArgumentException, InvalidSequenceStateException;

    /**
     * @return {@link ReplaceIndexSequence} view of the specified subsequence
     */
    @Override
    public ReplaceIndexSequence<Item> getSubsequenceView(final int fromIndex, final int toIndex)
    throws SequenceIndexOutOfBoundsException, InvalidSequenceIndexRangeException;

    /**
     * Returns a {@link ReplaceIndexSequenceTraverser} traversing the Items of
     * this {@link ReplaceIndexSequence} in proper order.
     *
     * @return {@link ReplaceIndexSequenceTraverser} traversing the Items
     */
    @Override
    public ReplaceIndexSequenceTraverser<Item> createTraverser();

    /**
     * Returns a {@link ReplaceIndexSequenceTraverser} traversing the Items of
     * this {@link ReplaceIndexSequence} in proper order, starting at the
     * specified index.
     *
     * @param startIndex
     *        integer specifying the index of the first Item to traverse
     *
     * @return {@link ReplaceIndexSequenceTraverser} traversing the Items
     *
     * @throws SequenceIndexOutOfBoundsException
     *         if
     *         {@code startIndex < getFirstIndex() || startIndex > getLastIndex()}
     */
    @Override
    public ReplaceIndexSequenceTraverser<Item> createTraverser(final int startIndex)
    throws SequenceIndexOutOfBoundsException;
}
