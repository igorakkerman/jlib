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
 * {@link ObservedInsertSequenceTraverser} and
 * {@link ObservedRemoveSequenceTraverser}.
 * 
 * @param <Item>
 *        type of items held in the {@link ObservedInsertRemoveSequence}
 * 
 * @author Igor Akkerman
 */
public interface ObservedInsertRemoveSequenceTraverser<Item>
extends InsertRemoveSequenceTraverser<Item>, ObservedInsertSequenceTraverser<Item>,
ObservedRemoveSequenceTraverser<Item> {
    // unifying interface
}
