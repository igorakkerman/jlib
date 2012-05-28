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
     * Removes from this IndexSequence the Item stored at the specified
     * index.
     * 
     * @param index
     *        integer specifying the index
     */
    public void remove(final int index);

    /**
     * Returns a {@link RemoveIndexSequenceTraverser} traversing the Items of
     * this Sequence in proper sequence. Initially, the Traverser points to the
     * beginning of this Sequence, that is, the Item returned by the first
     * call to {@link InsertIndexSequenceTraverser#getNextItem()} is the Item stored
     * at {@link #getFirstIndex()}.
     * 
     * @return InsertIndexSequenceTraverser over this IndexSequence initially
     *         pointing to the beginning of this Sequence
     */
    @Override
    public RemoveIndexSequenceTraverser<Item> createTraverser();

    /**
     * Returns a RemoveIndexSequenceTraverser traversing the Items of this
     * Sequence in proper sequence. That is, the Item returned by the first
     * call to {@link InsertIndexSequenceTraverser#getNextItem()} is the Item stored
     * at the specified start index.
     * 
     * @param startIndex
     *        integer specifying the index of the first Item returned by the
     *        Traverser
     * 
     * @return InsertIndexSequenceTraverser over this Sequence initially pointing
     *         to the beginning of this Sequence
     * 
     * @throws SequenceIndexOutOfBoundsException
     *         if
     *         {@code startIndex < getFirstIndex() || startIndex > getLastIndex()}
     */
    @Override
    public RemoveIndexSequenceTraverser<Item> createTraverser(final int startIndex)
    throws SequenceIndexOutOfBoundsException;
}
