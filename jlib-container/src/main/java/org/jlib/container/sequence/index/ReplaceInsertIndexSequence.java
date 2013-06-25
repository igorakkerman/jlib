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

import org.jlib.container.sequence.ReplaceInsertSequence;
import org.jlib.container.traverser.ReplaceTraverser;

/**
 * {@link ReplaceIndexSequence} and {@link InsertIndexSequence}.
 *
 * @param <Item>
 *        type of items held in the {@link ReplaceInsertIndexSequence}
 *
 * @author Igor Akkerman
 */
public interface ReplaceInsertIndexSequence<Item>
extends ReplaceInsertSequence<Item>, ReplaceIndexSequence<Item>, InsertIndexSequence<Item> {

    /**
     * @return {@link ReplaceInsertIndexSequence} view of the specified Items
     */
    @Override
    public ReplaceInsertIndexSequence<Item> getSubsequenceView(final int fromIndex, final int toIndex)
    throws SequenceIndexOutOfBoundsException, InvalidSequenceIndexRangeException;

    /**
     * Returns an {@link IndexSequenceTraverser} and {@link ReplaceTraverser}
     * traversing the Items of this {@link ReplaceInsertIndexSequence} in proper
     * sequence. That is, the Item returned by the first call to
     * {@link IndexSequenceTraverser#getNextItem()} is the Item stored at the
     * first index.
     *
     * @return {@link ReplaceIndexSequenceTraverser} over the Items of this
     *         {@link ReplaceInsertIndexSequence}
     */
    @Override
    public ReplaceInsertIndexSequenceTraverser<Item> createTraverser();

    /**
     * Returns an {@link ReplaceIndexSequenceTraverser} and
     * {@link ReplaceTraverser} traversing the Items of this
     * {@link ReplaceInsertIndexSequence} in proper sequence. That is, the Item
     * returned by the first call to
     * {@link IndexSequenceTraverser#getNextItem()} is the Item stored at the
     * specified start index.
     *
     * @param startIndex
     *        integer specifying the index of the first Item to traverse
     *
     * @return {@link ReplaceIndexSequenceTraverser} over the Items of this
     *         {@link ReplaceInsertIndexSequence}
     *
     * @throws SequenceIndexOutOfBoundsException
     *         if
     *         {@code startIndex < getFirstIndex() || startIndex > getLastIndex()}
     */
    @Override
    public ReplaceInsertIndexSequenceTraverser<Item> createTraverser(final int startIndex)
    throws SequenceIndexOutOfBoundsException;
}
