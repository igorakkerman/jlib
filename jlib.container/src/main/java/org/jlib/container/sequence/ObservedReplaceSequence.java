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

import org.jlib.core.observer.ItemObserver;

/**
 * {@link ReplaceSequence} allowing its replace operations to be attended by
 * {@link ItemObserver} instances.
 * 
 * @param <Item>
 *        type of items held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public interface ObservedReplaceSequence<Item>
extends ReplaceSequence<Item> {

    /**
     * Returns an {@link ObservedReplaceIndexSequenceTraverser} traversing the Items
     * of this {@link ObservedReplaceSequence} in proper order.
     * 
     * @param observers
     *        comma separated sequence of {@link ItemObserver} instances
     *        attending the replacement
     * 
     * @return {@link ObservedReplaceIndexSequenceTraverser} traversing the Items of
     *         this {@link ObservedReplaceSequence} in proper order
     */
    public ObservedReplaceSequenceTraverser<Item> createTraverser(@SuppressWarnings({ "unchecked", /* "varargs" */}) ItemObserver<Item>... observers);
}
