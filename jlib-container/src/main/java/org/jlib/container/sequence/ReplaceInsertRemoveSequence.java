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
 * {@link ReplaceInsertSequence}, {@link InsertRemoveSequence} and
 * {@link ReplaceRemoveSequence}.
 * 
 * @param <Item>
 *        type of items held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public interface ReplaceInsertRemoveSequence<Item>
extends ReplaceInsertSequence<Item>, InsertRemoveSequence<Item>, ReplaceRemoveSequence<Item> {

    /**
     * Returns a {@link ReplaceInsertRemoveSequenceTraverser} traversing the
     * Items of this Sequence in proper order.
     * 
     * @return newly created {@link ReplaceInsertSequenceTraverser}
     */
    @Override
    public ReplaceInsertRemoveSequenceTraverser<Item> createTraverser();
}
