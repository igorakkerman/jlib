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
import org.jlib.container.sequence.RemoveSequenceTraverser;
import org.jlib.container.sequence.Sequence;
import org.jlib.core.traverser.RemoveTraverser;

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
     * Returns an {@link IndexSequenceTraverser} and
     * {@link RemoveSequenceTraverser} traversing the Items of this Sequence in
     * proper sequence. Initially, the {@link IndexSequenceTraverser} points to
     * the beginning of this Sequence, that is, the Item returned by the first
     * call to {@link IndexSequenceTraverser#getNextItem()} is the Item stored
     * at {@link #getFirstIndex()}.
     * 
     * @param <Traverzer>
     *        type of the returned {@link IndexSequenceTraverser} and
     *        {@link RemoveTraverser}
     * 
     * @return {@link IndexSequenceTraverser} and
     *         {@link RemoveSequenceTraverser} over this IndexSequence initially
     *         pointing to the beginning of this Sequence
     */
    // @formatter:off
    public <Traverzer extends IndexSequenceTraverser<Item> & RemoveSequenceTraverser<Item>> 
           Traverzer createRemoveIndexSequenceTraverser();
    // @formatter:on

    /**
     * Returns an {@link IndexSequenceTraverser} and
     * {@link RemoveSequenceTraverser} traversing the Items of this Sequence in
     * proper sequence. Initially, the {@link IndexSequenceTraverser} points to
     * the beginning of this Sequence, that is, the Item returned by the first
     * call to {@link IndexSequenceTraverser#getNextItem()} is the Item stored
     * at the specified index.
     * 
     * @param <Traverzer>
     *        type of the returned {@link IndexSequenceTraverser} and
     *        {@link RemoveTraverser}
     * 
     * @param startIndex
     *        integer specifying the index of the first Item returned by the
     *        Traverser
     * 
     * @return InsertIndexSequenceTraverser over this Sequence initially
     *         pointing to the beginning of this Sequence
     * 
     * @throws SequenceIndexOutOfBoundsException
     *         if
     *         {@code startIndex < getFirstIndex() || startIndex > getLastIndex()}
     */
    // @formatter:off
    public <Traverzer extends IndexSequenceTraverser<Item> & RemoveSequenceTraverser<Item>> 
           Traverzer createRemoveIndexSequenceTraverser(final int startIndex)
    throws SequenceIndexOutOfBoundsException;
    // @formatter:on
}
