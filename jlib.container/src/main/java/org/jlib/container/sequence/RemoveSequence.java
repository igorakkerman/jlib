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

import org.jlib.container.RemoveContainer;

/**
 * {@link ReplaceSequence} that allows Items to be added and removed.
 * 
 * @param <Item>
 *        type of items held in the {@link Sequence}
 * @author Igor Akkerman
 */
public interface RemoveSequence<Item>
extends Sequence<Item>, RemoveContainer<Item> {

    /**
     * Returns a {@link RemoveSequenceTraverser} traversing the Items of this
     * Sequence in proper order.
     * 
     * @return InsertSequenceTraverser traversing the Items of this Sequence in
     *         proper order
     */
    public RemoveSequenceTraverser<Item> createRemoveSequenceTraverser();
}
