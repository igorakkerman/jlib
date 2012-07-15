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

package org.jlib.container.sequence.index;

import org.jlib.container.sequence.ObservedReplaceRemoveSequenceTraverser;

/**
 * {@link ObservedReplaceInsertIndexSequenceTraverser} and
 * {@link ObservedRemoveIndexSequenceTraverser}.
 * 
 * @param <Item>
 *        type of items held in the
 *        {@link ObservedReplaceInsertRemoveIndexSequence}
 * 
 * @author Igor Akkerman
 */
public interface ObservedReplaceInsertRemoveIndexSequenceTraverser<Item>
extends ObservedReplaceInsertIndexSequenceTraverser<Item>, ObservedRemoveIndexSequenceTraverser<Item>,
ObservedReplaceRemoveSequenceTraverser<Item> {
    // unifying interface
}
