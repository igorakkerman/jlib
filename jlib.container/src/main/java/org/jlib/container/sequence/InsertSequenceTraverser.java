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

package org.jlib.container.sequence;

import org.jlib.container.sequence.index.IndexSequenceTraverser;

/**
 * {@link SequenceTraverser} over a {@link InsertSequence}.
 * 
 * @param <Item>
 *        type of items held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public interface InsertSequenceTraverser<Item>
extends SequenceTraverser<Item> {

    /**
     * <p>
     * Inserts the specified Item into the sequence at the current position of
     * this {@link IndexSequenceTraverser}.
     * </p>
     * <p>
     * The Item is inserted immediately before the next Item that would have
     * been returned by {@link #getNextItem()} and immediately after the
     * previous Item that would have been returned by {@link #getPreviousItem()}
     * .
     * </p>
     * <p>
     * A subsequent call to {@link #getNextItem()} would be unaffected, and a
     * subsequent call to {@link #getPreviousItem()} would return the new item.
     * </p>
     * 
     * @param newItem
     *        new Item to insert
     * 
     * @throws IllegalStateException
     *         if {@link #getNextItem()} or {@link #getPreviousItem()} have not
     *         been called initially or after the last call to
     *         {@link #insert(Object)}
     */
    public void insert(final Item newItem)
    throws IllegalStateException;
}
