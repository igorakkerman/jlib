/*
 * jlib - The Free Java Library
 * 
 * http://www.jlib.org
 * 
 * Copyright (c) 2006-2008 Igor Akkerman
 * 
 * jlib is distributed under the
 * 
 * COMMON PUBLIC LICENSE VERSION 1.0
 * 
 * http://www.opensource.org/licenses/cpl1.0.php
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
     * Returns a {@link ReplaceAppendInsertRemoveIndexSequenceTraverser}
     * traversing the Items of this IndexSequence in proper sequence. Initially,
     * the Traverser points to the head of this IndexSequence, that is, the Item
     * returned by the first call to
     * {@link ReplaceAppendInsertRemoveIndexSequenceTraverser#getNextItem()} is
     * the Item stored at {@link #getFirstIndex()}.
     * 
     * @return {@link ReplaceAppendInsertRemoveIndexSequenceTraverser} over this
     *         {@link ReplaceAppendInsertRemoveIndexSequence}
     */
    @Override
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
     * @return {@link ReplaceAppendInsertRemoveIndexSequenceTraverser} over this
     *         {@link ReplaceAppendInsertRemoveIndexSequence}
     * 
     * @throws SequenceIndexOutOfBoundsException
     *         if
     *         {@code startIndex < getFirstIndex() || startIndex > getLastIndex()}
     */
    public ReplaceAppendInsertRemoveIndexSequenceTraverser<Item> createReplaceInsertRemoveIndexSequenceTraverser(final int startIndex)
    throws SequenceIndexOutOfBoundsException;
}
