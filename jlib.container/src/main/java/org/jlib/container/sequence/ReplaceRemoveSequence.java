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

/**
 * {@link Sequence} allowing its Items to be modified using an
 * {@link ReplaceSequenceTraverser}.
 * 
 * @param <Item>
 *        type of items held in the {@link ReplaceRemoveSequence}
 * 
 * @author Igor Akkerman
 */
public interface ReplaceRemoveSequence<Item>
extends ReplaceSequence<Item>, RemoveSequence<Item> {

    /**
     * Returns a {@link ReplaceRemoveSequenceTraverser} traversing the Items of
     * this Sequence in proper order.
     * 
     * @return {@link ReplaceRemoveSequenceTraverser} traversing the Items of
     *         this {@link ReplaceRemoveSequence} in proper order
     */
    @Override
    public ReplaceRemoveSequenceTraverser<Item> createTraverser();
}
