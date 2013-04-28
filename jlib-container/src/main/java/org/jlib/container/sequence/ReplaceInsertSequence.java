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

import org.jlib.core.traverser.TwoWayTraverser;

/**
 * {@link Sequence} allowing its Items to be modified using an
 * {@link ReplaceSequenceTraverser}.
 * 
 * @param <Item>
 *        type of items held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public interface ReplaceInsertSequence<Item>
extends ReplaceSequence<Item>, InsertSequence<Item> {

    /**
     * <p>
     * Returns a {@link ReplaceInsertSequenceTraverser} traversing the Items of
     * this Sequence in proper order.
     * </p>
     * <p>
     * The {@link ReplaceSequenceTraverser#replace(Object)} method of the
     * {@link TwoWayTraverser} can be used to modify Items in this
     * {@link ReplaceInsertSequence}.
     * </p>
     * 
     * @return {@link ReplaceInsertSequenceTraverser} traversing the Items of
     *         this {@link ReplaceInsertSequence} in proper order
     */
    @Override
    public ReplaceInsertSequenceTraverser<Item> createTraverser();
}
