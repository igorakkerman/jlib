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

/**
 * {@link ReplaceSequence} allowing its replace operations to be attended by
 * {@link ValueObserver} instances.
 * 
 * @param <Item>
 *        type of items held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public interface ObservedReplaceRemoveSequence<Item>
extends ObservedReplaceSequence<Item>, ObservedRemoveSequence<Item> {

    /**
     * @return {@link ObservedReplaceRemoveSequenceTraverser} traversing the
     *         Items of this {@link ObservedReplaceRemoveSequence}
     */
    @Override
    public ObservedReplaceRemoveSequenceTraverser<Item> createTraverser();
}
