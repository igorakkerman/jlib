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
import org.jlib.core.traverser.ObservedReplaceTraverser;

/**
 * {@link ObservedReplaceTraverser} of an {@link ObservedReplaceSequence}.
 * 
 * @param <Item>
 *        type of items held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public interface ObservedReplaceSequenceTraverser<Item>
extends ObservedReplaceTraverser<Item>, ReplaceSequenceTraverser<Item> {

    /**
     * Replaces the last Item returned by {@link #getNextItem()} or
     * {@link #getPreviousItem()} with the specified value.
     * 
     * @param newItem
     *        Item by which the former Item is replaced
     * 
     * @param observers
     *        comma separated sequence of {@link ValueObserver} instances
     *        attending the replacement
     * 
     * @throws NoSequenceItemToReplaceException
     *         if no Item has been returned by this
     *         {@link ObservedReplaceSequenceTraverser}
     * 
     * @throws ValueObserverException
     *         if an error occurs during the {@link ValueObserver} operation
     */
    @Override
    public void replace(final Item newItem, @SuppressWarnings("unchecked") final ValueObserver<Item>... observers)
    throws NoSequenceItemToReplaceException, ValueObserverException;
}
