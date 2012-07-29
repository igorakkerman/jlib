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
 * {@link ReplaceInsertSequenceTraverser} and
 * {@link ObservedReplaceSequenceTraverser}.
 * 
 * @param <Item>
 *        type of items held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public interface ObservedReplaceInsertSequenceTraverser<Item>
extends ReplaceInsertSequenceTraverser<Item>, ObservedReplaceSequenceTraverser<Item>,
ObservedInsertSequenceTraverser<Item> {
    // unifying interface
}
