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

import org.jlib.container.sequence.IllegalSequenceArgumentException;
import org.jlib.container.sequence.IllegalSequenceStateException;
import org.jlib.container.sequence.ReplaceSequence;
import org.jlib.container.sequence.ReplaceSequenceTraverser;
import org.jlib.container.sequence.Sequence;
import org.jlib.core.observer.ValueObserver;
import org.jlib.core.traverser.ReplaceTraverser;

/**
 * {@link IndexSequence} and {@link ReplaceSequence}.
 * 
 * @param <Item>
 *        type of items held in the {@link Sequence}
 * @author Igor Akkerman
 */
public interface ObservedReplaceInsertIndexSequence<Item>
extends ObservedReplaceIndexSequence<Item> {

    /**
     * Replaces the Item at the specified index in this
     * {@link ObservedReplaceInsertIndexSequence} by the specified Items.
     * 
     * @param index
     *        integer specifying the index
     * 
     * @param newItem
     *        new Item to store
     * 
     * @param observers
     *        comma separated sequence of {@link ValueObserver} instances
     *        attending the replacement
     * 
     * @throws SequenceIndexOutOfBoundsException
     *         if {@code index < getFirstIndex() || index > getLastIndex()}
     * 
     * @throws IllegalSequenceArgumentException
     *         if some property of {@code newItem} prevents the operation from
     *         being performed
     * 
     * @throws IllegalSequenceStateException
     *         if an error occurs performing the operation
     */
    @Override
    public void replace(final int index, final Item newItem,
    @SuppressWarnings("unchecked")
                        final ValueObserver<Item>... observers)
    throws SequenceIndexOutOfBoundsException, IllegalSequenceArgumentException, IllegalSequenceStateException;

    @Override
    public ObservedReplaceIndexSequenceTraverser<Item> createReplaceIndexSequenceTraverser()
    throws SequenceIndexOutOfBoundsException;

    @Override
    public ObservedReplaceIndexSequenceTraverser<Item> createReplaceIndexSequenceTraverser(final int startIndex)
    throws SequenceIndexOutOfBoundsException;

    /**
     * Returns an {@link IndexSequenceTraverser} and {@link ReplaceTraverser}
     * traversing the Items of this {@link ReplaceIndexSequence} in proper
     * sequence. That is, the Item returned by the first call to
     * {@link IndexSequenceTraverser#getNextItem()} is the Item stored at the
     * specified start index.
     * 
     * @param startIndex
     *        integer specifying the index of the first Item to traverse
     * 
     * @param observers
     *        comma separated sequence of {@link ValueObserver} instances
     *        attending the replacement
     * 
     * @return {@link IndexSequenceTraverser} and
     *         {@link ReplaceSequenceTraverser} over this
     *         {@link ReplaceIndexSequence}
     * 
     * @throws SequenceIndexOutOfBoundsException
     *         if
     *         {@code startIndex < getFirstIndex() || startIndex > getLastIndex()}
     */
    // @formatter:off
    public ObservedReplaceIndexSequenceTraverser<Item> 
               createTraverser(final int startIndex, 
    @SuppressWarnings("unchecked")
                               final ValueObserver<Item>... observers)
    throws SequenceIndexOutOfBoundsException;
    // @formatter:on
}
