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

import org.jlib.container.sequence.Sequence;

/**
 * {@link ReplaceAppendIndexSequence} and {@link InsertIndexSequence} .
 * 
 * @param <Item>
 *        type of items held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public interface ReplaceAppendInsertIndexSequence<Item>
extends ReplaceAppendIndexSequence<Item>, InsertIndexSequence<Item> {

    /**
     * Returns a {@link ReplaceInsertIndexSequenceTraverser} traversing the
     * Items of this IndexSequence in proper sequence. Initially, the Traverser
     * points to the head of this IndexSequence, that is, the Item returned by
     * the first call to
     * {@link ReplaceInsertIndexSequenceTraverser#getNextItem()} is the Item
     * stored at {@link #getFirstIndex()}.
     * 
     * @return {@link ReplaceInsertIndexSequenceTraverser} over this
     *         {@link ReplaceAppendInsertIndexSequence}
     */
    public ReplaceInsertIndexSequenceTraverser<Item> createReplaceInsertIndexSequenceTraverser();

    /**
     * Returns an {@link ReplaceInsertIndexSequenceTraverser} traversing the
     * Items of this {@link ReplaceAppendInsertIndexSequence} in proper
     * sequence. That is, the Item returned by the first call to
     * {@link ReplaceInsertIndexSequenceTraverser#getNextItem()} is the Item
     * stored at the specified start index.
     * 
     * @param startIndex
     *        integer specifying the index of the first Item to traverse
     * 
     * @return {@link ReplaceInsertIndexSequenceTraverser} over this
     *         {@link ReplaceAppendInsertIndexSequence}
     * 
     * @throws SequenceIndexOutOfBoundsException
     *         if
     *         {@code startIndex < getFirstIndex() || startIndex > getLastIndex()}
     */
    public ReplaceInsertIndexSequenceTraverser<Item> createRemoveInsertIndexSequenceTraverser(final int startIndex)
    throws SequenceIndexOutOfBoundsException;

    /**
     * {@inheritDoc}
     * 
     * @return {@link ReplaceAppendInsertIndexSequence} view of the specified
     *         subsequence
     */
    @Override
    public ReplaceAppendInsertIndexSequence<Item> getSubsequenceView(int fromIndex, int toIndex)
    throws SequenceIndexOutOfBoundsException, InvalidSequenceIndexRangeException;
}
