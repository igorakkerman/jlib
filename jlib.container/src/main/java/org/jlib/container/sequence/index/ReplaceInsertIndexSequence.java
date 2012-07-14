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

import org.jlib.core.traverser.ReplaceTraverser;

import org.jlib.container.sequence.Sequence;

/**
 * {@link InsertIndexSequence} and {@link ReplaceIndexSequence}.
 * 
 * @param <Item>
 *        type of items held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public interface ReplaceInsertIndexSequence<Item>
extends InsertIndexSequence<Item>, ReplaceIndexSequence<Item> {

    /**
     * {@inheritDoc}
     * 
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
