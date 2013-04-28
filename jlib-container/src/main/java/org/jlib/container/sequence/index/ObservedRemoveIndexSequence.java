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

import org.jlib.container.sequence.ObservedRemoveFirstSequence;
import org.jlib.container.sequence.ObservedRemoveLastSequence;
import org.jlib.container.sequence.ObservedRemoveSequence;
import org.jlib.container.sequence.Sequence;
import org.jlib.core.observer.ValueObserver;

/**
 * {@link RemoveIndexSequence} .
 * 
 * @param <Item>
 *        type of items held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public interface ObservedRemoveIndexSequence<Item>
extends RemoveIndexSequence<Item>, ObservedRemoveSequence<Item>, ObservedRemoveFirstSequence<Item>,
ObservedRemoveLastSequence<Item> {

    /**
     * Removes from this IndexSequence the Item stored at the specified index.
     * 
     * @param index
     *        integer specifying the index
     * 
     * @param observers
     *        comma separated sequence of {@link ValueObserver} instances
     *        attending the operation
     * 
     */
    @SuppressWarnings("unchecked")
    public void remove(final int index, final ValueObserver<Item>... observers);

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
    @Override
    public ObservedRemoveIndexSequenceTraverser<Item> createTraverser();

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
     *         beginning of this {@link ObservedRemoveIndexSequence}
     * 
     * @throws SequenceIndexOutOfBoundsException
     *         if
     *         {@code startIndex < getFirstIndex() || startIndex > getLastIndex()}
     */
    @Override
    public ObservedRemoveIndexSequenceTraverser<Item> createTraverser(final int startIndex)
    throws SequenceIndexOutOfBoundsException;
}
