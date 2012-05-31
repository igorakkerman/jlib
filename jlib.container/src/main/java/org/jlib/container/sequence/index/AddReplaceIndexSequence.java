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

import org.jlib.container.sequence.ReplaceSequence;
import org.jlib.container.sequence.Sequence;

/**
 * {@link IndexSequence} that allows its Items to be modified.
 * 
 * @param <Item>
 *        type of items held in the {@link Sequence}
 * @author Igor Akkerman
 */
public interface AddReplaceIndexSequence<Item>
extends ReplaceSequence<Item>, IndexSequence<Item> {

    /**
     * Replaces the Item at the specified index in this
     * {@link AddReplaceIndexSequence} by the specified Items.
     * 
     * @param index
     *        integer specifying the index
     * 
     * @param newItem
     *        new Item to store
     * 
     * @throws SequenceIndexOutOfBoundsException
     *         if {@code index < getFirstIndex() || index > getLastIndex()}
     */
    public void replace(final int index, final Item newItem)
    throws SequenceIndexOutOfBoundsException;

    /**
     * Returns an {@link ReplaceIndexSequenceTraverser} traversing the Items of
     * this IndexSequence in proper sequence. Initially, the Traverser points to
     * the head of this IndexSequence, that is, the Item returned by the first
     * call to {@link ReplaceIndexSequenceTraverser#getNextItem()} is the Item
     * stored at {@link #getFirstIndex()}.
     * 
     * @return {@link ReplaceIndexSequenceTraverser} over this
     *         {@link AddReplaceIndexSequence}
     */
    @Override
    public ReplaceIndexSequenceTraverser<Item> createTraverser();

    /**
     * Returns an {@link ReplaceIndexSequenceTraverser} traversing the Items of
     * this {@link AddReplaceIndexSequence} in proper sequence. That is, the Item
     * returned by the first call to
     * {@link ReplaceIndexSequenceTraverser#getNextItem()} is the Item stored at
     * the specified start index.
     * 
     * @param startIndex
     *        integer specifying the index of the first Item to traverse
     * 
     * @return {@link ReplaceIndexSequenceTraverser} over this
     *         {@link AddReplaceIndexSequence}
     * 
     * @throws SequenceIndexOutOfBoundsException
     *         if
     *         {@code startIndex < getFirstIndex() || startIndex > getLastIndex()}
     */
    @Override
    public ReplaceIndexSequenceTraverser<Item> createTraverser(final int startIndex)
    throws SequenceIndexOutOfBoundsException;
}
