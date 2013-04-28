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
 * {@link ReplaceInsertRemoveSequenceTraverser},
 * {@link ObservedReplaceInsertSequenceTraverser},
 * {@link ObservedInsertRemoveSequenceTraverser} and
 * {@link ObservedReplaceRemoveSequenceTraverser}.
 * 
 * @param <Item>
 *        type of items held in the {@link ObservedReplaceInsertRemoveSequence}
 * 
 * @author Igor Akkerman
 */
public interface ObservedReplaceInsertRemoveSequenceTraverser<Item>
extends ReplaceInsertRemoveSequenceTraverser<Item>, ObservedReplaceInsertSequenceTraverser<Item>,
ObservedInsertRemoveSequenceTraverser<Item>, ObservedReplaceRemoveSequenceTraverser<Item> {
    // unifying interface
}
