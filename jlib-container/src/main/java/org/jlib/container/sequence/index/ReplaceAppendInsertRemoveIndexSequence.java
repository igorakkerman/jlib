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

import org.jlib.container.sequence.AppendSequence;
import org.jlib.container.sequence.Sequence;

/**
 * {@link AppendSequence}, {@link InsertIndexSequence} and
 * {@link RemoveIndexSequence}.
 *
 * @param <Item>
 *        type of items held in the {@link Sequence}
 *
 * @author Igor Akkerman
 */
public interface ReplaceAppendInsertRemoveIndexSequence<Item>
extends ReplaceAppendInsertIndexSequence<Item>, RemoveIndexSequence<Item> {

    /**
     * @return {@link ReplaceAppendInsertRemoveIndexSequence} view of the
     *         specified subsequence
     */
    @Override
    public ReplaceAppendInsertRemoveIndexSequence<Item> getSubsequenceView(final int fromIndex, final int toIndex)
    throws SequenceIndexOutOfBoundsException, InvalidSequenceIndexRangeException;

    /**
     * Returns a {@link ReplaceAppendInsertRemoveIndexSequenceTraverser}
     * traversing the Items of this IndexSequence in proper sequence. Initially,
     * the Traverser points to the head of this IndexSequence, that is, the Item
     * returned by the first call to
     * {@link ReplaceAppendInsertRemoveIndexSequenceTraverser#getNextItem()} is
     * the Item stored at {@link #getFirstIndex()}.
     *
     * @return {@link ReplaceAppendInsertRemoveIndexSequenceTraverser} over the Items of this
     *         {@link ReplaceAppendInsertRemoveIndexSequence}
     */
    public ReplaceAppendInsertRemoveIndexSequenceTraverser<Item> createTraverser();

    /**
     * Returns an {@link ReplaceAppendInsertRemoveIndexSequenceTraverser}
     * traversing the Items of this
     * {@link ReplaceAppendInsertRemoveIndexSequence} in proper sequence. That
     * is, the Item returned by the first call to
     * {@link ReplaceAppendInsertRemoveIndexSequenceTraverser#getNextItem()} is
     * the Item stored at the specified start index.
     *
     * @param startIndex
     *        integer specifying the index of the first Item to traverse
     *
     * @return {@link ReplaceAppendInsertRemoveIndexSequenceTraverser} over the Items of this
     *         {@link ReplaceAppendInsertRemoveIndexSequence}
     *
     * @throws SequenceIndexOutOfBoundsException
     *         if
     *         {@code startIndex < getFirstIndex() || startIndex > getLastIndex()}
     */
    public ReplaceAppendInsertRemoveIndexSequenceTraverser<Item> createTraverser(final int startIndex)
    throws SequenceIndexOutOfBoundsException;
}
