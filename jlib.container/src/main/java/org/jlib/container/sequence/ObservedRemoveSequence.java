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

import org.jlib.container.ObservedRemoveContainer;
import org.jlib.core.observer.ValueObserver;

/**
 * {@link ReplaceSequence} allowing its replace operations to be attended by
 * {@link ValueObserver} instances.
 * 
 * @param <Item>
 *        type of items held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public interface ObservedRemoveSequence<Item>
extends RemoveSequence<Item>, ObservedRemoveContainer<Item> {

    /**
     * Returns an {@link ObservedRemoveSequenceTraverser} traversing the Items
     * of this {@link ObservedRemoveSequence} in proper order.
     * 
     * @param observers
     *        comma separated sequence of {@link ValueObserver} instances
     *        attending every removal
     * 
     * @return {@link ObservedRemoveSequenceTraverser} traversing the Items of
     *         this {@link ObservedRemoveSequence} in proper order
     */
    @SuppressWarnings("unchecked")
    public ObservedRemoveSequenceTraverser<Item> createTraverser(ValueObserver<Item>... observers);
}
