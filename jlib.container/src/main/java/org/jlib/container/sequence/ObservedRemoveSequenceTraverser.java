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

package org.jlib.container.sequence;

import org.jlib.core.observer.ValueObserver;
import org.jlib.core.observer.ValueObserverException;
import org.jlib.core.traverser.ObservedRemoveTraverser;

/**
 * {@link ObservedRemoveTraverser} and {@link RemoveSequenceTraverser}.
 * 
 * @param <Item>
 *        type of items held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public interface ObservedRemoveSequenceTraverser<Item>
extends ObservedRemoveTraverser<Item>, RemoveSequenceTraverser<Item> {

    /**
     * Replaces the last Item returned by {@link #getNextItem()} or
     * {@link #getPreviousItem()} with the specified value.
     * 
     * @param observers
     *        comma separated sequence of {@link ValueObserver} instances
     *        attending the operation
     * 
     * @throws NoSequenceItemToRemoveException
     *         if no Item has been returned by this
     *         {@link ObservedRemoveSequenceTraverser}
     * 
     * @throws ValueObserverException
     *         if an error occurs during the {@link ValueObserver} operation
     * 
     * @throws RuntimeException
     *         if a {@link ValueObserver} operation throws this
     *         {@link RuntimeException}
     */
    @Override
    @SuppressWarnings("unchecked")
    public void remove(final ValueObserver<Item>... observers)
    throws NoSequenceItemToRemoveException, ValueObserverException, RuntimeException;

    /**
     * Registers the specified {@link ValueObserver} for the remove operations
     * of this {@link ObservedRemoveSequenceTraverser}.
     * 
     * @param removeObserver
     *        additional remove {@link ValueObserver}
     */
    public void addRemoveObserver(final ValueObserver<Item> removeObserver);
}
