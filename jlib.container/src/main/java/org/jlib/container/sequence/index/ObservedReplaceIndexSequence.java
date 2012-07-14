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

import org.jlib.core.observer.ValueObserver;

import org.jlib.container.sequence.IllegalSequenceArgumentException;
import org.jlib.container.sequence.IllegalSequenceStateException;
import org.jlib.container.sequence.ObservedReplaceSequence;
import org.jlib.container.sequence.ReplaceSequence;
import org.jlib.container.sequence.Sequence;

/**
 * {@link IndexSequence} and {@link ReplaceSequence}.
 * 
 * @param <Item>
 *        type of items held in the {@link Sequence}
 * @author Igor Akkerman
 */
public interface ObservedReplaceIndexSequence<Item>
extends ObservedReplaceSequence<Item>, ReplaceIndexSequence<Item> {

    /**
     * Replaces the Item at the specified index in this
     * {@link ObservedReplaceIndexSequence} by the specified Items.
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
    @SuppressWarnings("unchecked")
    public void replace(final int index, final Item newItem, final ValueObserver<Item>... observers)
    throws SequenceIndexOutOfBoundsException, IllegalSequenceArgumentException, IllegalSequenceStateException;

    /**
     * {@inheritDoc}
     * 
     * @return {@link ObservedRemoveIndexSequenceTraverser} traversing the Items
     */
    @Override
    public ObservedReplaceIndexSequenceTraverser<Item> createTraverser()
    throws SequenceIndexOutOfBoundsException;

    /**
     * {@inheritDoc}
     * 
     * @return {@link ObservedRemoveIndexSequenceTraverser} traversing the Items
     */
    @Override
    public ObservedReplaceIndexSequenceTraverser<Item> createTraverser(final int startIndex)
    throws SequenceIndexOutOfBoundsException;
}
