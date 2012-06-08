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
 * {@link Sequence} that allows Items to be inserted.
 * 
 * @param <Item>
 *        type of items held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public interface InsertSequence<Item>
extends Sequence<Item> {

    /**
     * Returns a InsertSequenceTraverser traversing the Items of this Sequence
     * in proper order.
     * 
     * @return {@link InsertSequenceTraverser} traversing the Items of this
     *         Sequence in proper order
     */
    public InsertSequenceTraverser<Item> createInsertSequenceTraverser();
}
