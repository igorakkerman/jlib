/*
 * jlib - The Free Java Library
 *
 *    http://www.jlib.org
 *
 * Copyright (c) 2006-2008 Igor Akkerman
 *
 * jlib is distributed under the
 *
 *    COMMON PUBLIC LICENSE VERSION 1.0
 *
 *    http://www.opensource.org/licenses/cpl1.0.php
 */

package org.jlib.container.sequence.index;

import org.jlib.core.observer.ValueObserver;

import org.jlib.container.sequence.IllegalSequenceArgumentException;
import org.jlib.container.sequence.IllegalSequenceStateException;
import org.jlib.container.sequence.InsertSequenceTraverser;
import org.jlib.container.sequence.ObservedRemoveSequenceTraverser;
import org.jlib.container.sequence.Sequence;

/**
 * {@link IndexSequenceTraverser} allowing observed insertion of Items.
 * 
 * @param <Item>
 *        type of items held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public interface ObservedInsertSequenceTraverser<Item>
extends InsertSequenceTraverser<Item> {

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
     * @param operationObservers
     *        comma separated sequence of {@link ValueObserver} items attending
     *        the operation
     * 
     * @param item
     *        Item to insert
     * 
     * @throws IllegalSequenceArgumentException
     *         if some property of {@code item} prevents it from being inserted
     * 
     * @throws IllegalSequenceStateException
     *         if an error occurs during the operation
     * 
     * @throws RuntimeException
     *         if a {@link ValueObserver} operation throws this
     *         {@link RuntimeException}
     */
    @SuppressWarnings("unchecked")
    public void insert(final Item item, final ValueObserver<Item>... operationObservers)
    throws IllegalSequenceArgumentException, IllegalSequenceStateException, RuntimeException;

    /**
     * Registers the specified {@link ValueObserver} for the insert operations
     * of this {@link ObservedRemoveSequenceTraverser}.
     * 
     * @param insertObserver
     *        additional insert {@link ValueObserver}
     */
    public void addInsertObserver(final ValueObserver<Item> insertObserver);
}
