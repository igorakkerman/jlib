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

import org.jlib.container.sequence.RemoveSequence;
import org.jlib.container.sequence.Sequence;

/**
 * {@link IndexSequence} that allows Items to be removed.
 *
 * @param <Item>
 *        type of items held in the {@link Sequence}
 *
 * @author Igor Akkerman
 */
public interface RemoveIndexSequence<Item>
extends RemoveSequence<Item>, IndexSequence<Item> {

    /**
     * Removes from this IndexSequence the Item stored at the specified index.
     *
     * @param index
     *        integer specifying the index
     */
    public void remove(final int index);

    /**
     * @return {@link RemoveIndexSequence} view of the specified subsequence
     */
    @Override
    public RemoveIndexSequence<Item> getSubsequenceView(final int fromIndex, final int toIndex)
    throws SequenceIndexOutOfBoundsException, InvalidSequenceIndexRangeException;

    /**
     * Returns a {@link RemoveIndexSequenceTraverser} traversing the Items of
     * this Sequence in proper sequence. Initially, the
     * {@link RemoveIndexSequenceTraverser} points to the beginning of this
     * Sequence, that is, the Item returned by the first call to
     * {@link RemoveIndexSequenceTraverser#getNextItem()} is the Item stored at
     * {@link #getFirstIndex()}.
     *
     * @return {@link RemoveIndexSequenceTraverser} initially pointing to the
     *         beginning of this {@link RemoveIndexSequenceTraverser} Sequence
     */
    public RemoveIndexSequenceTraverser<Item> createTraverser();

    /**
     * Returns a {@link RemoveIndexSequenceTraverser} and traversing the Items
     * of this Sequence in proper sequence. Initially, the
     * {@link RemoveIndexSequenceTraverser} points to the beginning of this
     * Sequence, that is, the Item returned by the first call to
     * {@link RemoveIndexSequenceTraverser#getNextItem()} is the Item stored at
     * the specified index.
     *
     * @param startIndex
     *        integer specifying the index of the first Item returned by the
     *        {@link RemoveIndexSequenceTraverser}
     *
     * @return {@link RemoveIndexSequenceTraverser} initially pointing to the
     *         beginning of this {@link RemoveIndexSequence}
     *
     * @throws SequenceIndexOutOfBoundsException
     *         if
     *         {@code startIndex < getFirstIndex() || startIndex > getLastIndex()}
     */
    public RemoveIndexSequenceTraverser<Item> createTraverser(final int startIndex)
    throws SequenceIndexOutOfBoundsException;
}
