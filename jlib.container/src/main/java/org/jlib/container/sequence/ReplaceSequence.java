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

import org.jlib.container.ReplaceContainer;

/**
 * {@link Sequence} allowing its Items to be modified using an
 * {@link ReplaceSequenceTraverser}.
 * 
 * @param <Item>
 *        type of items held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public interface ReplaceSequence<Item>
extends ReplaceContainer<Item>, Sequence<Item> {

    /**
     * <p>
     * Returns an ReplaceSequenceTraverser traversing the Items of this Sequence
     * in proper order.
     * </p>
     * <p>
     * The {@link ReplaceSequenceTraverser#replace(Object)} method of the
     * {@link SequenceTraverser} can be used to modify Items in this Sequence.
     * </p>
     * 
     * @return ReplaceSequenceTraverser traversing the Items of this Sequence in
     *         proper order
     */
    public ReplaceSequenceTraverser<Item> createReplaceTraverser();
}
