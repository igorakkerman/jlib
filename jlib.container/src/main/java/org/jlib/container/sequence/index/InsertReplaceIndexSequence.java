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
 * {@link IndexSequence} that allows its Items to be modified.
 * 
 * @param <Item>
 *        type of items held in the {@link Sequence}
 * @author Igor Akkerman
 */
public interface InsertReplaceIndexSequence<Item>
extends ReplaceIndexSequence<Item>, InsertIndexSequence<Item> {

    /**
     * Returns an {@link InsertReplaceIndexSequenceTraverser} traversing the
     * Items of this IndexSequence in proper sequence. Initially, the Traverser
     * points to the head of this IndexSequence, that is, the Item returned by
     * the first call to
     * {@link InsertReplaceIndexSequenceTraverser#getNextItem()} is the Item
     * stored at {@link #getFirstIndex()}.
     * 
     * @return {@link InsertReplaceIndexSequenceTraverser} over this
     *         {@link InsertReplaceIndexSequence}
     */
    @Override
    public InsertReplaceIndexSequenceTraverser<Item> createTraverser();

    /**
     * Returns an {@link InsertReplaceIndexSequenceTraverser} traversing the
     * Items of this {@link InsertReplaceIndexSequence} in proper sequence. That
     * is, the Item returned by the first call to
     * {@link InsertReplaceIndexSequenceTraverser#getNextItem()} is the Item
     * stored at the specified start index.
     * 
     * @param startIndex
     *        integer specifying the index of the first Item to traverse
     * 
     * @return {@link InsertReplaceIndexSequenceTraverser} over this
     *         {@link InsertReplaceIndexSequence}
     * 
     * @throws SequenceIndexOutOfBoundsException
     *         if
     *         {@code startIndex < getFirstIndex() || startIndex > getLastIndex()}
     */
    @Override
    public InsertReplaceIndexSequenceTraverser<Item> createTraverser(final int startIndex)
    throws SequenceIndexOutOfBoundsException;
}
