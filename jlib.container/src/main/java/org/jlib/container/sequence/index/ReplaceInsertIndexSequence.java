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
import org.jlib.core.traverser.ReplaceTraverser;

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
     * Returns an {@link IndexSequenceTraverser} and {@link ReplaceTraverser}
     * traversing the Items of this {@link ReplaceInsertIndexSequence} in proper
     * sequence. That is, the Item returned by the first call to
     * {@link IndexSequenceTraverser#getNextItem()} is the Item stored at the
     * first index.
     * 
     * @return {@link ReplaceIndexSequenceTraverser} over this
     *         {@link ReplaceInsertIndexSequence}
     * 
     * @throws SequenceIndexOutOfBoundsException
     *         if
     *         {@code startIndex < getFirstIndex() || startIndex > getLastIndex()}
     */
    @Override
    public ReplaceInsertIndexSequenceTraverser<Item> createTraverser()
    throws SequenceIndexOutOfBoundsException;

    /**
     * Returns an {@link IndexSequenceTraverser} and {@link ReplaceTraverser}
     * traversing the Items of this {@link ReplaceInsertIndexSequence} in proper
     * sequence. That is, the Item returned by the first call to
     * {@link IndexSequenceTraverser#getNextItem()} is the Item stored at the
     * specified start index.
     * 
     * @param startIndex
     *        integer specifying the index of the first Item to traverse
     * 
     * @return {@link ReplaceIndexSequenceTraverser} over this
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
